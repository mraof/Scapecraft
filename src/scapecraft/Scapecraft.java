package scapecraft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import scapecraft.block.ScapecraftBlocks;
import scapecraft.client.gui.GuiHandler;
import scapecraft.command.StatCommand;
import scapecraft.economy.EconomyHandler;
import scapecraft.economy.ScapecraftEconomy;
import scapecraft.entity.ScapecraftEntities;
import scapecraft.item.ScapecraftItems;
import scapecraft.network.ConfigPacket;
import scapecraft.network.MobSpawnerGuiPacket;
import scapecraft.network.MobSpawnerPacket;
import scapecraft.network.ShopGuiPacket;
import scapecraft.network.StatsPacket;
import scapecraft.util.Config;
import scapecraft.util.UpdateHandler;
import scapecraft.world.WorldProviderDungeon;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent.MissingMapping;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "Scapecraft", name = "Scapecraft", version = Scapecraft.version)
public class Scapecraft
{
	public static final String version = "@VERSION@";
	public static boolean requireLevels = true;
	public static int dungeonDimensionId;
	public static int dungeonProviderId;

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
			return ScapecraftItems.SGS;
		}
	};

	public static final CreativeTabs tabScapecraftTool = new CreativeTabs("tabScapecraftTool")
	{
		@Override
		public Item getTabIconItem()
		{
			return ScapecraftItems.dragonAxe;
		}
	};

	public static final CreativeTabs tabScapecraftMisc = new CreativeTabs("tabScapecraftMisc")
	{
		@Override
		public Item getTabIconItem()
		{
			return ScapecraftItems.questPoint;
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
		proxy.registerRenderers();

		ScapecraftEntities.registerEntities();

		Config.loadDrops();

		ScapecraftRecipes.registerRecipes();

		DimensionManager.registerProviderType(dungeonProviderId, WorldProviderDungeon.class, true);
		DimensionManager.registerDimension(dungeonDimensionId, dungeonProviderId);

		ScapecraftEventHandler eventHandler = new ScapecraftEventHandler();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		FMLCommonHandler.instance().bus().register(eventHandler);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		network = NetworkRegistry.INSTANCE.newSimpleChannel("scapecraft");
		network.registerMessage(StatsPacket.class, StatsPacket.class, 0, Side.CLIENT);
		network.registerMessage(MobSpawnerGuiPacket.class, MobSpawnerGuiPacket.class, 1, Side.CLIENT);
		network.registerMessage(MobSpawnerPacket.class, MobSpawnerPacket.class, 2, Side.SERVER);
		network.registerMessage(ConfigPacket.Handler.class, ConfigPacket.class, 3, Side.CLIENT);
		network.registerMessage(ShopGuiPacket.class, ShopGuiPacket.class, 4, Side.CLIENT);
	}

	@EventHandler
	public void serverAboutToStart(FMLServerAboutToStartEvent event)
	{
		if(event.getServer() != null)
		{
			File levelDat = new File(event.getServer().getFile(event.getServer().getFolderName()), "level.dat");
			if(levelDat.exists())
			{
				try
				{
					//List<String> oldIds = Arrays.asList(new String[] {"mod_BlocksGalore", "mod_Botter", "mod_Flower", "mod_MagicBow", "mod_MagicTree", "mod_mobs", "mod_phat", "mod_WorldGenBarrows", "mod_WorldGenBlackFortress", "mod_WorldGenBlacktower", "mod_WorldGenCastle", "mod_WorldGenDragons", "mod_WorldGenIceDragons", "mod_WorldGen", "mod_WorldGenLummy", "mod_WorldGenVarrock", "mod_WorldGenWar", "mod_WorldGenWhitetower", "mod_YewTree", "You_Must_Update_Scapecraft"});
					NBTTagCompound nbt = CompressedStreamTools.readCompressed(new FileInputStream(levelDat));

					NBTTagList itemList = nbt.getCompoundTag("FML").getTagList("ModItemData", 10);
					for(int i = 0; i < itemList.tagCount(); i++)
					{
						if(UpdateHandler.mappings.containsKey(itemList.getCompoundTagAt(i).getInteger("ItemId")))
						{
							itemList.getCompoundTagAt(i).setString("ModId", "Scapecraft");
							//itemList.getCompoundTagAt(i).setString("ForcedName", UpdateHandler.mappings.containsKey(itemList.getCompoundTagAt(i).getInteger("ItemId")) ? UpdateHandler.mappings.get(itemList.getCompoundTagAt(i).getInteger("ItemId")) : "UNKNOWN" + itemList.getCompoundTagAt(i).getInteger("ItemId"));
							itemList.getCompoundTagAt(i).setString("ForcedName", "" + itemList.getCompoundTagAt(i).getInteger("ItemId"));
						}
					}
					System.out.println(itemList);

					CompressedStreamTools.writeCompressed(nbt, new FileOutputStream(levelDat));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		File dataFile = event.getServer().worldServers[0].getSaveHandler().getMapFileFromName("ScapecraftData");
		if(dataFile != null && dataFile.exists())
		{
			NBTTagCompound nbt;
			try {
				nbt = CompressedStreamTools.readCompressed(new FileInputStream(dataFile));
			} catch(IOException e) {
				e.printStackTrace();
				return;
			}

			EconomyHandler.scEconomy = new ScapecraftEconomy();
			EconomyHandler.scEconomy.readFromNBT(nbt);
		}

		//event.registerServerCommand(new TestingCommand());
		event.registerServerCommand(new StatCommand());
	}

	@EventHandler
	public void serverStarted(FMLServerStartedEvent event)
	{
		System.out.println("Initiallizing economy");
		EconomyHandler.initEconomy();
	}

	@EventHandler
	public void onMissingMapping(FMLMissingMappingsEvent event)
	{
		for(MissingMapping mapping: event.get())
		{
			System.out.println(mapping.id);
			if(UpdateHandler.mappings.containsKey(mapping.id))
			{
				if(mapping.type == GameRegistry.Type.BLOCK)
				{
					Block block = GameRegistry.findBlock("Scapecraft", UpdateHandler.mappings.get(mapping.id));
					if(block != null)
					{
						mapping.remap(block);
					}
				}
				else
				{
					Item item = GameRegistry.findItem("Scapecraft", UpdateHandler.mappings.get(mapping.id));
					if(item != null)
					{
						mapping.remap(item);
					}
				}
			}
		}
	}
}
