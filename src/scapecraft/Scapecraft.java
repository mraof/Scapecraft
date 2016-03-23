package scapecraft;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import org.apache.commons.io.IOUtils;
import scapecraft.block.ScapecraftBlocks;
import scapecraft.client.gui.GuiHandler;
import scapecraft.command.*;
import scapecraft.compat.Compat;
import scapecraft.economy.EconomyHandler;
import scapecraft.economy.ScapecraftEconomy;
import scapecraft.entity.ScapecraftEntities;
import scapecraft.event.ScapecraftEventHandler;
import scapecraft.event.WorldProtectionHandler;
import scapecraft.item.ScapecraftItems;
import scapecraft.network.*;
import scapecraft.util.Config;
import scapecraft.util.Stats;
import scapecraft.world.WorldProviderDungeon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

//TODO split cache packets, print all items and blocks (And entities?) who have an unlocalized name equal to their actual name

@Mod(modid = "Scapecraft", name = "Scapecraft", version = Scapecraft.version)
public class Scapecraft
{
	public static final String version = "@VERSION@";
	public static boolean requireLevels = true;
	public static int dungeonDimensionId;
	public static int dungeonProviderId;
	public static boolean cauldron = false;

	public static File configDir;

	/*start armor*/
	public static final CreativeTabs tabScapecraftArmor = new CreativeTabs("tabScapecraftArmor")
	{
		@Override
		public Item getTabIconItem()
		{
			return ScapecraftItems.phatHelmet;
		}
	};

	public static final CreativeTabs tabScapecraftBlock = new CreativeTabs("tabScapecraftBlock")
	{
		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ScapecraftBlocks.runeOre);
		}
	};

	public static final CreativeTabs tabScapecraftWeapon = new CreativeTabs("tabScapecraftWeapon")
	{
		@Override
		public Item getTabIconItem()
		{
			return ScapecraftItems.equipmentSets.get("dragonHammer");
		}
	};

	public static final CreativeTabs tabScapecraftTool = new CreativeTabs("tabScapecraftTool")
	{
		@Override
		public Item getTabIconItem()
		{
			return ScapecraftItems.equipmentSets.get("dragonAxe");
		}
	};

	public static final CreativeTabs tabScapecraftMisc = new CreativeTabs("tabScapecraftMisc")
	{
		@Override
		public Item getTabIconItem()
		{
			return ScapecraftItems.questItem;
		}
	};

	@SidedProxy(clientSide = "scapecraft.client.ClientProxy", serverSide = "scapecraft.CommonProxy")
	public static CommonProxy proxy;

	@Instance("Scapecraft")
	public static Scapecraft instance;
	
	public static SimpleNetworkWrapper network;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Config.loadConfig(new Configuration(event.getSuggestedConfigurationFile()));
		configDir = event.getSuggestedConfigurationFile().getParentFile();
		proxy.setCacheDir(new File(configDir, "scCache"));

		Stats.setXpValues(1);
		ScapecraftItems.registerItems();
		ScapecraftBlocks.registerBlocks();
		ScapecraftItems.setToolLevels(Config.toolLevels);
		ScapecraftBlocks.setBlockLevels(Config.blockLevels);
		System.out.println(ScapecraftItems.toolLevels);
		System.out.println(ScapecraftBlocks.blockLevels);
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		try
		{
			Compat.loadCompatibility();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		ScapecraftEntities.registerEntities();

		proxy.registerRenderers();

		ScapecraftRecipes.registerRecipes();

		DimensionManager.registerProviderType(dungeonProviderId, WorldProviderDungeon.class, true);
		DimensionManager.registerDimension(dungeonDimensionId, dungeonProviderId);

		ScapecraftEventHandler eventHandler = new ScapecraftEventHandler();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		MinecraftForge.EVENT_BUS.register(new WorldProtectionHandler());
		FMLCommonHandler.instance().bus().register(eventHandler);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		network = NetworkRegistry.INSTANCE.newSimpleChannel("scapecraft");
		network.registerMessage(StatsPacket.Handler.class, StatsPacket.class, 0, Side.CLIENT);
		network.registerMessage(TileEntityGuiPacket.Handler.class, TileEntityGuiPacket.class, 1, Side.CLIENT);
		network.registerMessage(TileEntityUpdatePacket.Handler.class, TileEntityUpdatePacket.class, 2, Side.SERVER);
		network.registerMessage(ConfigPacket.Handler.class, ConfigPacket.class, 3, Side.CLIENT);
		network.registerMessage(RegionPacket.Handler.class, RegionPacket.class, 4, Side.CLIENT);
		network.registerMessage(MobSpawnerKillPacket.Handler.class, MobSpawnerKillPacket.class, 5, Side.SERVER);
		network.registerMessage(SpawnDataPacket.Handler.class, SpawnDataPacket.class, 6, Side.CLIENT);
		network.registerMessage(XpSplitPacket.Handler.class, XpSplitPacket.class, 7, Side.SERVER);
		network.registerMessage(TextureDataPacket.Handler.class, TextureDataPacket.class, 8, Side.CLIENT);
		network.registerMessage(CacheListPacket.Handler.class, CacheListPacket.class, 9, Side.SERVER);
		network.registerMessage(MobListPacket.Handler.class, MobListPacket.class, 10, Side.CLIENT);
		network.registerMessage(NewDataPacket.Handler.class, NewDataPacket.class, 11, Side.SERVER);
		network.registerMessage(DropsPacket.Handler.class, DropsPacket.class, 12, Side.SERVER);
		network.registerMessage(MoneyPacket.Handler.class, MoneyPacket.class, 13, Side.CLIENT);
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		try
		{
			Class.forName("org.bukkit.Bukkit");
			cauldron = true;
		} catch (ClassNotFoundException e)
		{
			cauldron = false;
		}

		File dataFile = event.getServer().worldServers[0].getSaveHandler().getMapFileFromName("ScapecraftData");
		EconomyHandler.scEconomy = new ScapecraftEconomy();
		if(dataFile != null && dataFile.exists())
		{
			NBTTagCompound nbt;
			try {
				nbt = CompressedStreamTools.readCompressed(new FileInputStream(dataFile));
			} catch(IOException e) {
				e.printStackTrace();
				return;
			}

			Stats.readFromNBT(nbt);
			EconomyHandler.scEconomy.readFromNBT(nbt);
			WorldProtectionHandler.getInstance().readFromNBT(nbt);
		}

		dataFile = event.getServer().worldServers[0].getSaveHandler().getMapFileFromName("ScapecraftDrops");
		NBTTagCompound nbt = new NBTTagCompound();
		if(dataFile != null && dataFile.exists())
		{
			try {
				nbt = CompressedStreamTools.readCompressed(new FileInputStream(dataFile));
			} catch(IOException e) {
				e.printStackTrace();
				return;
			}
		}
		Config.loadDrops(nbt);

		event.registerServerCommand(new TestingCommand());
		event.registerServerCommand(new StatCommand());
		event.registerServerCommand(new RegionCommand());
		event.registerServerCommand(new DropsCommand());
		event.registerServerCommand(new MoneyCommand());
		event.registerServerCommand(new SellCommand());

		{
			proxy.textureData = new HashMap<String, byte[]>();
			for (String key : proxy.cache.keySet())
			{
				ResourceLocation location = new ResourceLocation(key);
				File file = new File(proxy.cacheDir, String.format("%s/%s/%s", "assets", location.getResourceDomain(), location.getResourcePath()));
				if(file.exists())
				{
					try
					{
						byte[] data = IOUtils.toByteArray(new FileInputStream(file));
						proxy.textureData.put(key, data);
					} catch (IOException e)
					{
						e.printStackTrace();
						proxy.cache.remove(key);
					}
				}
			}
			/*NBTTagCompound tagCompound = new NBTTagCompound();
			tagCompound.setString("name", "Test");
			tagCompound.setString("model", "Biped");
			ScapecraftEntities.dynamicMobs.appendTag(tagCompound);

			tagCompound = new NBTTagCompound();
			tagCompound.setString("name", "Okay");
			tagCompound.setString("model", "d2h");
			ScapecraftEntities.dynamicMobs.appendTag(tagCompound);

			tagCompound = new NBTTagCompound();
			tagCompound.setString("name", "Goblin");
			ScapecraftEntities.dynamicMobs.appendTag(tagCompound);
			//ScapecraftEntities.registerEntity(ScapecraftEntities.createNewEntityClass("EntityTest"));
			*/
			for(int i = 0; i < ScapecraftEntities.dynamicMobs.tagCount(); i++)
			{
				ScapecraftEntities.registerDynamicMob(ScapecraftEntities.dynamicMobs.getCompoundTagAt(i));
			}
		}
	}

	@EventHandler
	public void serverStarted(FMLServerStartedEvent event)
	{
		System.out.println("Initiallizing economy");
		EconomyHandler.initEconomy();
		/*ArrayList<ItemStack> stacks = new ArrayList<ItemStack>();
		for (Item item : GameData.getItemRegistry().typeSafeIterable())
		{
			item.getSubItems(item, null, stacks);
		}
		for (ItemStack stack : stacks)
		{
			if((stack.getUnlocalizedName() + ".name").equals(stack.getDisplayName()))
			{
				System.out.println(GameRegistry.findUniqueIdentifierFor(stack.getItem()) +  " " + stack.getDisplayName());
			}
		}

		for (Object entry : EntityList.stringToClassMapping.entrySet())
		{
			try
			{
				String name = ((Entity)((Class<?>) ((Map.Entry) entry).getValue()).getConstructor(World.class).newInstance(MinecraftServer.getServer().getEntityWorld())).getCommandSenderName();
				if(name.contains(".name") && ((Map.Entry)entry).getKey().toString().contains("Scapecraft"))
				{
					System.out.println(((Map.Entry)entry).getKey() + " " + name);
				}
			} catch (Exception ignored)
			{
			}
		}*/
	}

	@EventHandler
	public void serverStopped(FMLServerStoppedEvent event)
	{
		proxy.saveCache();
		proxy.cache.clear();
	}
}
