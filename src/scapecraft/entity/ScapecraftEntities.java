package scapecraft.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import scapecraft.Scapecraft;
import scapecraft.block.ScapecraftBlocks;
import scapecraft.item.ScapecraftItems;
import scapecraft.util.BytecodeClassLoader;
import scapecraft.util.CombatXpHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScapecraftEntities
{
	protected static final float[] defaultStats = new float[] {16, 4, 0, 1, 0, 0.5f, 10, 4};
	protected static final int[] defaultLevels = new int[] {1, 1};
	//should this stuff be in this class?
	public static HashMap<Class<? extends Entity>, ArrayList<Drop>> drops = new HashMap<Class<? extends Entity>, ArrayList<Drop>>();
	public static HashMap<Class<? extends Entity>, int[]> moneyDrops = new HashMap<Class<? extends Entity>, int[]>();
	//turn into a config
	private static HashMap<Class<? extends EntityScapecraft>, float[]> mobStats = new HashMap<Class<? extends EntityScapecraft>, float[]>();
	private static HashMap<Class<? extends EntityScapecraft>, int[]> mobLevels = new HashMap<Class<? extends EntityScapecraft>, int[]>();
	private static int currentEntityIdOffset = 0;

	//All classes with their name as the key
	public static HashMap<String, Class<? extends Entity>> entityNames = new HashMap<String, Class<? extends Entity>>();
	//Entities that extend EntityScapecraft
	public static ArrayList<String> entities = new ArrayList<String>();
	//Entity objects for use by spawn eggs
	public static ArrayList<EntityScapecraft> entityObjects = new ArrayList<EntityScapecraft>();
	//List of textures, empty on servers
	private static HashMap<Class<? extends EntityScapecraft>, List<ResourceLocation>> textures = new HashMap<Class<? extends EntityScapecraft>, List<ResourceLocation>>();
	public static NBTTagList dynamicMobs;
	private static BytecodeClassLoader dynamicLoader;

	public static Class<? extends Entity> createNewEntityClass(String name)
	{
		String desc = null;
		try
		{
			desc = Type.getConstructorDescriptor(EntityGeneric.class.getConstructor(World.class));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC, "scapecraft/entity/" + name, null, "scapecraft/entity/EntityGeneric", null);
		MethodVisitor con = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", desc, null, null);
		con.visitCode();
		con.visitVarInsn(Opcodes.ALOAD, 0);
		con.visitVarInsn(Opcodes.ALOAD, 1);
		con.visitMethodInsn(Opcodes.INVOKESPECIAL, "scapecraft/entity/EntityGeneric", "<init>", desc, false);
		con.visitInsn(Opcodes.RETURN);
		con.visitMaxs(2, 2);
		cw.visitEnd();
		//noinspection unchecked
		return (Class<? extends Entity>) dynamicLoader.defineClass("scapecraft.entity." + name, cw.toByteArray());
	}

	public static void registerEntities()
	{
		dynamicLoader = new BytecodeClassLoader(EntityGeneric.class.getClassLoader());
		dynamicMobs = new NBTTagList();
		registerEntity(EntityAbbyDemon.class);
		registerEntity(EntityAhrim.class);
		registerEntity(EntityAkrisae.class);
		registerEntity(EntityBandit.class);
		registerEntity(EntityBarbarian.class);
		registerEntity(EntityBlackDemon.class);
		registerEntity(EntityBlackDragon.class);
		registerEntity(EntityBlackGuard.class);
		registerEntity(EntityBlackKnight.class);
		registerEntity(EntityCaveCrawler.class);
		registerEntity(EntityCook.class);
		registerEntity(EntityDarkwizard.class);
		registerEntity(EntityDharok.class);
		registerEntity(EntityDoctor.class);
		registerEntity(EntityDwarf.class);
		registerEntity(EntityEliteBlackKnight.class);
		registerEntity(EntityFarmer.class);
		registerEntity(EntityFireGiant.class);
		registerEntity(EntityFremGuard.class);
		registerEntity(EntityGeneralGraardor.class);
		registerEntity(EntityGiantSpider.class);
		registerEntity(EntityGhost.class);
		registerEntity(EntityGoblin.class);
		registerEntity(EntityGreenDragon.class);
		registerEntity(EntityGuard.class);
		registerEntity(EntityGuthan.class);
		registerEntity(EntityHellhound.class);
		registerEntity(EntityHeroKnight.class);
		registerEntity(EntityHighMage.class);
		registerEntity(EntityHillGiant.class);
		registerEntity(EntityIceGiant.class);
		registerEntity(EntityIronDragon.class);
		registerEntity(EntityKaril.class);
		registerEntity(EntityKing.class);
		registerEntity(EntityKingsGuard.class);
		registerEntity(EntityKK.class);
		registerEntity(EntityKKspawn.class);
		registerEntity(EntityKos1.class);
		registerEntity(EntityKos2.class);
		registerEntity(EntityKos3.class);
		registerEntity(EntityKos4.class);
		registerEntity(EntityKQ2.class);
		registerEntity(EntityKQ.class);
		registerEntity(EntityLavaBlock.class);
		registerEntity(EntityLesserDemon.class);
		registerEntity(EntityLesserDemonUgly.class);
		registerEntity(EntityLootChest.class);
		registerEntity(EntityMan.class);
		registerEntity(EntityMorgan.class);
		registerEntity(EntityMossGiant.class);
		registerEntity(EntityMugger.class);
		registerEntity(EntityRat.class);
		registerEntity(EntityRatSmall.class);
		registerEntity(EntityScorpion.class);
		registerEntity(EntitySergeantGrimspike.class);
		registerEntity(EntitySergeantSteelwill.class);
		registerEntity(EntitySergeantStrongstack.class);
		registerEntity(EntityShopKeeper.class);
		registerEntity(EntityTormentedDemon.class);
		registerEntity(EntityThief.class);
		registerEntity(EntityTorag.class);
		registerEntity(EntityVampire.class);
		registerEntity(EntityVarze.class);
		registerEntity(EntityVerac.class);
		registerEntity(EntityWhiteKnight.class);
		registerEntity(EntityWizard.class);
		registerEntity(EntityZilyana.class);
		registerEntity(EntityZaklnGritch.class);
		registerEntity(EntityTstanonKarlak.class);
		registerEntity(EntityKrilTsutsaroth.class);
		registerEntity(EntityBalfrugKreeyath.class);
		registerEntity(EntityKreearra.class);
		registerEntity(EntityGenericBiped.class);
		registerEntity(EntityShapeshifter.class);
		registerEntity(EntityShopshifter.class);
		registerEntity(EntityBlueDragon.class);
		registerEntity(EntityKey.class);
		registerEntity(EntityDrop.class);
		CombatXpHelper.addVanilla();

		//Hacky stuff to make protectable ItemFrames
		EntityList.stringToClassMapping.remove("ItemFrame");
		EntityList.idToClassMap.remove(18);
		EntityList.addMapping(EntityItemFrame.class, "ItemFrame", 18);

		setStats(EntityGoblin.class, 18, 3, 2.7f, 0.7f, 0, 0.5f, 24, 4);
		setStats(EntityBandit.class, 25, 6, 1, 0.3f, 0, 0.5f, 13, 4);
		setStats(EntityHillGiant.class, 16, 4, 1, 0.1f, 0.5f, 0.4f, 21, 4);
		setDefaultLevel(EntityBandit.class, 49, 52);
		setDefaultLevel(EntityHillGiant.class, 50, 50);
	}

	public static void registerEntity(Class<? extends Entity> entityClass)
	{
		String name = entityClass.getSimpleName().substring(6);
		EntityRegistry.registerModEntity(entityClass, name, currentEntityIdOffset, Scapecraft.instance, 80, 3, true);
		entityNames.put(name.toLowerCase(), entityClass);
		if(EntityScapecraft.class.isAssignableFrom(entityClass))
		{
			entities.add(name);
			try
			{
				entityObjects.add((EntityScapecraft) entityClass.getConstructor(new Class[] { World.class }).newInstance(new Object[] { null }));
			} catch(Exception e) {e.printStackTrace(); }
		}

		currentEntityIdOffset++;
	}

	public static void registerDynamicMob(NBTTagCompound tag)
	{
		if (!entityNames.containsKey(tag.getString("name").toLowerCase()))
		{
			registerEntity(createNewEntityClass("Entity" + tag.getString("name")));
			dynamicMobs.appendTag(tag);
		}
		Scapecraft.proxy.registerMobRenderer(tag);
	}

	@SideOnly(Side.CLIENT)
	public static void addTextures(String name)
	{
		//noinspection unchecked
		Class<? extends EntityScapecraft> entityClass = (Class<? extends EntityScapecraft>) entityNames.get(name.toLowerCase());
		System.out.println(name + " " + entityClass);
		ArrayList<ResourceLocation> entityTextures = new ArrayList<ResourceLocation>();
		for (int i = 0; i == entityTextures.size(); i++)
		{
			ResourceLocation texture = new ResourceLocation("scapecraft", "textures/entity/" + name + "/" + i + ".png");
			try
			{
				Minecraft.getMinecraft().getResourceManager().getResource(texture);
				entityTextures.add(texture);
			} catch (IOException e)
			{
				System.out.println(name + " textures: " + entityTextures.size());
				if (entityTextures.size() == 0)
				{
					entityTextures.add(texture);
				}
			}
		}
		textures.put(entityClass, entityTextures);
		int i = 0;
		while (i < entityObjects.size() && !(entityObjects.get(i).getClass() == entityClass))
		{
			i++;
		}
		if(i != entityObjects.size())
		{
			entityObjects.get(i).setTexture(0);
		}
		else
		{
			System.out.println(name);
		}
	}

	public static void addDrops()
	{
		//Use this format for addding drops
		//addDrop((Entity.class), (drop price), new ItemStack(name of item/block), (how many are dropped at once)));

		//for example we wanted a mob called "Bob" to drop 1 iron ingot, 2 adamant ore, 1 bronze sword, and 1 dirt block all with a drop rate of 1/1
		//addDrop(EntityBob.class, 1, new ItemStack(Items.iron_ingot));
		//addDrop(EntityBob.class, 1, new ItemStack(ScapecraftBlocks.adamantOre, 2));
		//addDrop(EntityBob.class, 1, "Scapecraft:bronzeSword");
		//addDrop(EntityBob.class, 1, new ItemStack(Blocks.dirt));



		//addDrop(EntityAbbyDemon.class, 800, "Scapecraft:whip");
		//addDrop(EntityAbbyDemon.class, 30, "Scapecraft:runeHelmet");
		//addDrop(EntityAbbyDemon.class, 30, "Scapecraft:adamantAxe");
		//addDrop(EntityAbbyDemon.class, 35, new ItemStack(ScapecraftBlocks.adamantOre, 2));
		//addDrop(EntityAbbyDemon.class, 45, new ItemStack(ScapecraftBlocks.magicLog, 6));
		//addDrop(EntityAbbyDemon.class, 45, "Scapecraft:runeOre");

		//addDrop(EntityAhrim.class, 1, "Scapecraft:ahrimKey");
		//addDrop(EntityAhrim.class, 300, "Scapecraft:ahrimBoots");
		//addDrop(EntityAhrim.class, 300, "Scapecraft:ahrimPlatebody");
		//addDrop(EntityAhrim.class, 300, "Scapecraft:ahrimHelmet");
		//addDrop(EntityAhrim.class, 300, "Scapecraft:ahrimPlatelegs");
		//addDrop(EntityAhrim.class, 400, "Scapecraft:ahrimStaff");

		//addDrop(EntityAkrisae.class, 1, "Scapecraft:akrisaeKey");
		//addDrop(EntityAkrisae.class, 300, "Scapecraft:akrisaeBoots");
		//addDrop(EntityAkrisae.class, 300, "Scapecraft:akrisaePlatebody");
		//addDrop(EntityAkrisae.class, 300, "Scapecraft:akrisaeHelmet");
		//addDrop(EntityAkrisae.class, 300, "Scapecraft:akrisaePlatelegs");
		//addDrop(EntityAkrisae.class, 400, "Scapecraft:akrisaeMace");

		//bandit leader (low level boss)
		addDrop(EntityBandit.class, 8, "Scapecraft:blackSword");
		addDrop(EntityBandit.class, 1, new ItemStack(ScapecraftItems.fishPie, 3));
		addDrop(EntityBandit.class, 2, new ItemStack(Blocks.coal_block, 1));
		addDrop(EntityBandit.class, 5, "Scapecraft:mithrilIngot");
		addDrop(EntityBandit.class, 10, "Scapecraft:adamantSword");
		addDrop(EntityBandit.class, 20, "Scapecraft:runeSword");
		addDrop(EntityBandit.class, 25, "Scapecraft:adamantPlatebody");
		addDrop(EntityBandit.class, 5, new ItemStack(ScapecraftItems.runeIngot, 1));

		addDrop(EntityBarbarian.class, 20, "Scapecraft:ironSword");
		addDrop(EntityBarbarian.class, 15, new ItemStack(Items.arrow, 16));
		addDrop(EntityBarbarian.class, 6, new ItemStack(Blocks.iron_ore));
		addDrop(EntityBarbarian.class, 2, "Scapecraft:beer");
		addDrop(EntityBarbarian.class, 4, new ItemStack(Items.cooked_beef));
		addDrop(EntityBarbarian.class, 20, "Scapecraft:ironChestplate");

		//addDrop(EntityBlackDemon.class, 15, "Scapecraft:adamantIngot");
		//addDrop(EntityBlackDemon.class, 2000, "Scapecraft:chaoticMaul");
		//addDrop(EntityBlackDemon.class, 2000, "Scapecraft:chaoticRapier");
		//addDrop(EntityBlackDemon.class, 40, "Scapecraft:blackHalberd");
		//addDrop(EntityBlackDemon.class, 25, "Scapecraft:blackPlatebody");
		//addDrop(EntityBlackDemon.class, 25, "Scapecraft:blackSword");
		//addDrop(EntityBlackDemon.class, 40, "Scapecraft:runeHelmet");
		//addDrop(EntityBlackDemon.class, 750, "Scapecraft:dragonBattleAxe");
		//addDrop(EntityBlackDemon.class, 70, "Scapecraft:runePlatebody");

		//addDrop(EntityBlackDragon.class, 1, "Scapecraft:blackDHide");
		//addDrop(EntityBlackDragon.class, 40, "Scapecraft:runeSword");
		//addDrop(EntityBlackDragon.class, 30, new ItemStack(ScapecraftBlocks.adamantOre, 3));
		//addDrop(EntityBlackDragon.class, 500, "Scapecraft:dragonScimmy");
		//addDrop(EntityBlackDragon.class, 40, "Scapecraft:adamantPlatebody");
		//addDrop(EntityBlackDragon.class, 25, "Scapecraft:mithrilAxe");
		//addDrop(EntityBlackDragon.class, 40, new ItemStack(Items.arrow, 32));

		addDrop(EntityBlackGuard.class, 50, "Scapecraft:blackHalberd");
		addDrop(EntityBlackGuard.class, 30, "Scapecraft:blackBoots");
		addDrop(EntityBlackGuard.class, 30, "Scapecraft:blackSword");
		addDrop(EntityBlackGuard.class, 30, "Scapecraft:blackPlatebody");
		addDrop(EntityBlackGuard.class, 30, "Scapecraft:blackPlatelegs");
		addDrop(EntityBlackGuard.class, 30, "Scapecraft:blackHelmet");

		//black guard for black knights fortress quest
		//addDrop(EntityBlackGuard2.class, 1, new ItemStack(ScapecraftItems.doorKey, 2));
		//addDrop(EntityBlackGuard2.class, 50, "Scapecraft:blackHalberd");
		//addDrop(EntityBlackGuard2.class, 30, "Scapecraft:blackBoots");
		//addDrop(EntityBlackGuard2.class, 30, "Scapecraft:blackSword");
		//addDrop(EntityBlackGuard2.class, 30, "Scapecraft:blackPlatebody");
		//addDrop(EntityBlackGuard2.class, 30, "Scapecraft:blackPlatelegs");
		//addDrop(EntityBlackGuard2.class, 30, "Scapecraft:blackHelmet");

		//Black Knight
		addDrop(EntityBlackKnight.class, 60, "Scapecraft:blackBoots");
		addDrop(EntityBlackKnight.class, 60, "Scapecraft:blackHelmet");
		addDrop(EntityBlackKnight.class, 60, "Scapecraft:blackSword");
		addDrop(EntityBlackKnight.class, 60, "Scapecraft:blackPlatebody");
		addDrop(EntityBlackKnight.class, 60, "Scapecraft:blackPlatelegs");
		addDrop(EntityBlackKnight.class, 25, "Scapecraft:ironSword");
		addDrop(EntityBlackKnight.class, 25, "Scapecraft:ironHelmet");
		addDrop(EntityBlackKnight.class, 10, new ItemStack(Items.arrow, 8));
		addDrop(EntityBlackKnight.class, 5, new ItemStack(Items.iron_ingot));
		addDrop(EntityBlackKnight.class, 1, new ItemStack(Items.bread, 2));

		//Cave Crawler
		addDrop(EntityCaveCrawler.class, 20, "Scapecraft:magicFruit");
		addDrop(EntityCaveCrawler.class, 150, "Scapecraft:mithrilPlatelegs");
		addDrop(EntityCaveCrawler.class, 150, "Scapecraft:mithrilPlatebody");

		//addDrop(EntityDarkwizard.class, 30, "Scapecraft:"); //unfinished, no items as drops

		//addDrop(EntityDharok.class, 1, "Scapecraft:dharokKey");
		//addDrop(EntityDharok.class, 300, "Scapecraft:dharokBoots");
		//addDrop(EntityDharok.class, 300, "Scapecraft:dharokPlatebody");
		//addDrop(EntityDharok.class, 300, "Scapecraft:dharokHelmet");
		//addDrop(EntityDharok.class, 300, "Scapecraft:dharokPlatelegs");
		//addDrop(EntityDharok.class, 400, "Scapecraft:dharokAxe");

		addDrop(EntityDwarf.class, 5, "Scapecraft:bronzePickaxe");
		addDrop(EntityDwarf.class, 5, "Scapecraft:beer");
		addDrop(EntityDwarf.class, 30, "Scapecraft:ironPickaxe");
		addDrop(EntityDwarf.class, 10, new ItemStack(Blocks.iron_ore));
		addDrop(EntityDwarf.class, 20, new ItemStack(Items.iron_ingot, 2));
		addDrop(EntityDwarf.class, 40, new ItemStack(Items.coal, 5));
		addDrop(EntityDwarf.class, 60, "Scapecraft:mithrilPickaxe");
		addDrop(EntityDwarf.class, 150, "Scapecraft:adamantPickaxe");
		addDrop(EntityDwarf.class, 1, new ItemStack(Blocks.stone, 1));

		//addDrop(EntityEliteBlackKnight.class, 15, "Scapecraft:blackSword");
		//addDrop(EntityEliteBlackKnight.class, 100, "Scapecraft:blackHalberd");
		//addDrop(EntityEliteBlackKnight.class, 400, "Scapecraft:blackgBoots");
		//addDrop(EntityEliteBlackKnight.class, 400, "Scapecraft:blackgPlatebody");
		//addDrop(EntityEliteBlackKnight.class, 400, "Scapecraft:blackgHelmet");
		//addDrop(EntityEliteBlackKnight.class, 400, "Scapecraft:blackgPlatelegs");

		addDrop(EntityFarmer.class, 30, new ItemStack(Items.melon_seeds, 2));
		addDrop(EntityFarmer.class, 30, new ItemStack(Items.pumpkin_seeds, 2));
		addDrop(EntityFarmer.class, 20, new ItemStack(Items.wheat_seeds, 2));
		addDrop(EntityFarmer.class, 50, new ItemStack(Items.water_bucket));
		addDrop(EntityFarmer.class, 30, "Scapecraft:bronzeHoe");
		addDrop(EntityFarmer.class, 50, "Scapecraft:ironHoe");
		addDrop(EntityFarmer.class, 25, new ItemStack(ScapecraftBlocks.cabbage, 4));
		addDrop(EntityFarmer.class, 50, "Scapecraft:pitchFork");

		addDrop(EntityFireGiant.class, 40, "Scapecraft:runeIngot");
		addDrop(EntityFireGiant.class, 150, "Scapecraft:runeBoots");
		addDrop(EntityFireGiant.class, 5, new ItemStack(Blocks.obsidian));
		addDrop(EntityFireGiant.class, 75, "Scapecraft:adamantOre");
		addDrop(EntityFireGiant.class, 20, new ItemStack(Items.coal, 6));
		addDrop(EntityFireGiant.class, 12, new ItemStack(Blocks.iron_ore, 3));
		addDrop(EntityFireGiant.class, 5, new ItemStack(Items.arrow, 4));

		//addDrop(EntityGeneralGraardor.class, 15, "Scapecraft:runeSword");
		//addDrop(EntityGeneralGraardor.class, 15, "Scapecraft:runePickaxe");
		//addDrop(EntityGeneralGraardor.class, 15, "Scapecraft:runePlatebody");
		//addDrop(EntityGeneralGraardor.class, 15, "Scapecraft:dragonLongsword");
		//addDrop(EntityGeneralGraardor.class, 100, "Scapecraft:coalOreSpawn");
		//addDrop(EntityGeneralGraardor.class, 150, "Scapecraft:mithrilOreSpawn");
		//addDrop(EntityGeneralGraardor.class, 250, "Scapecraft:adamantOreSpawn");
		//addDrop(EntityGeneralGraardor.class, 400, "Scapecraft:runeOreSpawn");
		//addDrop(EntityGeneralGraardor.class, 20, new ItemStack(Items.coal, 32));
		//addDrop(EntityGeneralGraardor.class, 10, new ItemStack(ScapecraftBlocks.adamantOre, 4));
		//addDrop(EntityGeneralGraardor.class, 8, new ItemStack(ScapecraftBlocks.runeOre, 2));
		//addDrop(EntityGeneralGraardor.class, 50, new ItemStack(ScapecraftItems.adamantIngot, 10));
		//addDrop(EntityGeneralGraardor.class, 200, "Scapecraft:bandosBoots");
		//addDrop(EntityGeneralGraardor.class, 200, "Scapecraft:bandosPlatebody");
		//addDrop(EntityGeneralGraardor.class, 200, "Scapecraft:bandosPlatelegs");
		//addDrop(EntityGeneralGraardor.class, 200, "Scapecraft:bandosHelmet");
		//addDrop(EntityGeneralGraardor.class, 100, "Scapecraft:bandosHilt");
		//addDrop(EntityGeneralGraardor.class, 200, "Scapecraft:shard1");
		//addDrop(EntityGeneralGraardor.class, 200, "Scapecraft:shard2");
		//addDrop(EntityGeneralGraardor.class, 200, "Scapecraft:shard3");
		//addDrop(EntityGeneralGraardor.class, 15, new ItemStack(ScapecraftItems.superRestore, 3));
		//addDrop(EntityGeneralGraardor.class, 25, new ItemStack(ScapecraftBlocks.magicLog, 8));

		addDrop(EntityGhost.class, 50, "Scapecraft:mithrilBoots");
		addDrop(EntityGhost.class, 50, "Scapecraft:mithrilHelmet");
		addDrop(EntityGhost.class, 30, new ItemStack(Items.arrow, 16));
		addDrop(EntityGhost.class, 2, new ItemStack(Items.bread, 2));
		addDrop(EntityGhost.class, 1, new ItemStack(Items.snowball, 2));

		addDrop(EntityGoblin.class, 25, new ItemStack(Items.bow));
		addDrop(EntityGoblin.class, 35, "Scapecraft:bronzeSword");
		addDrop(EntityGoblin.class, 35, "Scapecraft:bronzeAxe");
		addDrop(EntityGoblin.class, 35, "Scapecraft:bronzeShovel");
		addDrop(EntityGoblin.class, 35, "Scapecraft:bronzePickaxe");
		addDrop(EntityGoblin.class, 60, "Scapecraft:ironSword");
		addDrop(EntityGoblin.class, 20, new ItemStack(ScapecraftBlocks.cabbage, 3));
		addDrop(EntityGoblin.class, 20, new ItemStack(Items.bread, 3));
		addDrop(EntityGoblin.class, 50, new ItemStack(Blocks.iron_ore, 3));
		addDrop(EntityGoblin.class, 50, new ItemStack(Items.iron_ingot, 3));
		addDrop(EntityGoblin.class, 25, "Scapecraft:bronzeBoots");
		addDrop(EntityGoblin.class, 25, new ItemStack(ScapecraftBlocks.tinOre, 3));
		addDrop(EntityGoblin.class, 25, new ItemStack(ScapecraftBlocks.copperOre, 3));

		addDrop(EntityGreenDragon.class, 5, "Scapecraft:greenDHide");
		addDrop(EntityGreenDragon.class, 90, "Scapecraft:adamantHelmet");
		addDrop(EntityGreenDragon.class, 60, "Scapecraft:adamantBoots");
		addDrop(EntityGreenDragon.class, 20, "Scapecraft:whitePlatelegs");
		addDrop(EntityGreenDragon.class, 5, "Scapecraft:adamantOre");
		addDrop(EntityGreenDragon.class, 30, "Scapecraft:mithrilAxe");
		addDrop(EntityGreenDragon.class, 100, "Scapecraft:mithrilPlatebody");

		addDrop(EntityGuard.class, 20, "Scapecraft:bronzeHelmet");
		addDrop(EntityGuard.class, 20, "Scapecraft:ironPlatebody");
		addDrop(EntityGuard.class, 30, "Scapecraft:ironSword");
		addDrop(EntityGuard.class, 50, "Scapecraft:ironChestplate");
		addDrop(EntityGuard.class, 50, "Scapecraft:ironLeggings");
		addDrop(EntityGuard.class, 50, "Scapecraft:ironHammer");
		addDrop(EntityGuard.class, 30, new ItemStack(Items.arrow, 8));
		addDrop(EntityGuard.class, 30, new ItemStack(Items.iron_ingot));
		addDrop(EntityGuard.class, 15, new ItemStack(Items.bread, 3));

		//addDrop(EntityGuthan.class, 1, "Scapecraft:guthanKey");
		//addDrop(EntityGuthan.class, 300, "Scapecraft:guthanBoots");
		//addDrop(EntityGuthan.class, 300, "Scapecraft:guthanPlatebody");
		//addDrop(EntityGuthan.class, 300, "Scapecraft:guthanHelmet");
		//addDrop(EntityGuthan.class, 300, "Scapecraft:guthanPlatelegs");
		//addDrop(EntityGuthan.class, 400, "Scapecraft:guthanSpear");

		//addDrop(EntityHeroKnight.class, 50, "Scapecraft:whiteSword");
		//addDrop(EntityHeroKnight.class, 50, "Scapecraft:whiteBoots");
		//addDrop(EntityHeroKnight.class, 50, "Scapecraft:whiteHelmet");
		//addDrop(EntityHeroKnight.class, 50, "Scapecraft:whitePlatebody");
		//addDrop(EntityHeroKnight.class, 50, "Scapecraft:whitePlatelegs");
		//addDrop(EntityHeroKnight.class, 25, new ItemStack(Items.arrow, 16));
		//addDrop(EntityHeroKnight.class, 50, new ItemStack(Items.iron_ingot, 3));
		//addDrop(EntityHeroKnight.class, 50, "Scapecraft:yewBow");
		//addDrop(EntityHeroKnight.class, 3, new ItemStack(Items.gold_nugget, 3));

		//addDrop(EntityHighMage.class, 3, new ItemStack(Items.gold_ingot, 3));
		//addDrop(EntityHighMage.class, 150, "Scapecraft:coalOreSpawn");
		//addDrop(EntityHighMage.class, 200, "Scapecraft:ironOreSpawn");
		//addDrop(EntityHighMage.class, 1500, "Scapecraft:armaStaff");
		//addDrop(EntityHighMage.class, 25, "Scapecraft:saraStaff");
		//addDrop(EntityHighMage.class, 5, new ItemStack(Items.golden_apple));
		//addDrop(EntityHighMage.class, 5, "Scapecraft:dragonLongsword");
		//addDrop(EntityHighMage.class, 5, new ItemStack(ScapecraftItems.magicFruit, 3));
		//addDrop(EntityHighMage.class, 50, "Scapecraft:dragonPlatelegs");
		//addDrop(EntityHighMage.class, 25, "Scapecraft:guthixStaff");
		//addDrop(EntityHighMage.class, 25, "Scapecraft:zamorakStaff");
		//addDrop(EntityHighMage.class, 50, "Scapecraft:dragonScimmy");

		addDrop(EntityHillGiant.class, 20, "Scapecraft:mithrilOre");
		addDrop(EntityHillGiant.class, 30, "Scapecraft:blackPlatebody");
		addDrop(EntityHillGiant.class, 30, "Scapecraft:blackHelmet");
		addDrop(EntityHillGiant.class, 60, "Scapecraft:mithrilPlatebody");
		addDrop(EntityHillGiant.class, 35, "Scapecraft:ironSword");
		addDrop(EntityHillGiant.class, 35, "Scapecraft:ironHelmet");
		addDrop(EntityHillGiant.class, 35, "Scapecraft:ironChestplate");
		addDrop(EntityHillGiant.class, 35, "Scapecraft:ironLeggings");
		addDrop(EntityHillGiant.class, 35, "Scapecraft:ironBoots");

		addDrop(EntityIceGiant.class, 1, new ItemStack(Items.snowball, 4));
		addDrop(EntityIceGiant.class, 25, "Scapecraft:mithrilSword");
		addDrop(EntityIceGiant.class, 50, "Scapecraft:adamantHelmet");
		addDrop(EntityIceGiant.class, 70, "Scapecraft:adamantPlatebody");
		addDrop(EntityIceGiant.class, 70, "Scapecraft:adamantPlatelegs");
		addDrop(EntityIceGiant.class, 30, "Scapecraft:mithrilBoots");
		addDrop(EntityIceGiant.class, 20, "Scapecraft:blackPlatebody");
		addDrop(EntityIceGiant.class, 20, "Scapecraft:blackHelmet");
		addDrop(EntityIceGiant.class, 15, "Scapecraft:mithrilOre");

		addDrop(EntityIronDragon.class, 20, new ItemStack(Items.iron_ingot, 5));
		addDrop(EntityIronDragon.class, 250, "Scapecraft:dragonPlatelegs");
		addDrop(EntityIronDragon.class, 50, "Scapecraft:adamantAxe");
		addDrop(EntityIronDragon.class, 50, "Scapecraft:adamantSword");
		addDrop(EntityIronDragon.class, 75, "Scapecraft:runeAxe");
		addDrop(EntityIronDragon.class, 75, "Scapecraft:runeSword");
		addDrop(EntityIronDragon.class, 75, "Scapecraft:runeHelmet");
		addDrop(EntityIronDragon.class, 35, new ItemStack(ScapecraftItems.adamantIngot, 2));
		addDrop(EntityIronDragon.class, 30, "Scapecraft:runeIngot");
		addDrop(EntityIronDragon.class, 40, "Scapecraft:superStr");
		addDrop(EntityIronDragon.class, 40, "Scapecraft:superDef");

		//addDrop(EntityKK.class, 50, "Scapecraft:dryMace");
		//addDrop(EntityKK.class, 100, "Scapecraft:dryRapier");
		//addDrop(EntityKK.class, 150, "Scapecraft:dryLong");
		//addDrop(EntityKK.class, 75, new ItemStack(ScapecraftItems.runeIngot, 10));
		//addDrop(EntityKK.class, 15, "Scapecraft:dragonHelmet");
		//addDrop(EntityKK.class, 40, "Scapecraft:dds");
		//addDrop(EntityKK.class, 75, new ItemStack(ScapecraftItems.adamantOre, 16));
		//addDrop(EntityKK.class, 5, "Scapecraft:runeBoots");
		//addDrop(EntityKK.class, 5, "Scapecraft:runePlatebody");
		//addDrop(EntityKK.class, 5, "Scapecraft:runeHelmet");
		//addDrop(EntityKK.class, 5, "Scapecraft:runePlatelegs");
		//addDrop(EntityKK.class, 5, "Scapecraft:runeAxe");
		//addDrop(EntityKK.class, 5, "Scapecraft:runeSword");
		//addDrop(EntityKK.class, 75, new ItemStack(Blocks.coal_block, 8));
		//addDrop(EntityKK.class, 75, new ItemStack(ScapecraftBlocks.runeOre, 20));
		//addDrop(EntityKK.class, 20, new ItemStack(ScapecraftItems.superRestore, 5));
		//addDrop(EntityKK.class, 20, new ItemStack(ScapecraftItems.superDef, 5));
		//addDrop(EntityKK.class, 150, "Scapecraft:runeOreSpawn");
		//addDrop(EntityKK.class, 120, "Scapecraft:adamantOreSpawn");
		//addDrop(EntityKK.class, 75, "Scapecraft:mithrilOreSpawn");
		//addDrop(EntityKK.class, 75, "Scapecraft:coalOreSpawn");
		//addDrop(EntityKK.class, 75, "Scapecraft:ironOreSpawn");
		//addDrop(EntityKK.class, 50, "Scapecraft:sandstoneSpawn");
		//addDrop(EntityKK.class, 50, "Scapecraft:sandSpawn");

		//addDrop(EntityKKspawn.class, 30, new ItemStack(Items.coal));
		//addDrop(EntityKKspawn.class, 3000, "Scapecraft:dragonPickaxe");

		//addDrop(EntityKQ.class, 1, new ItemStack(ScapecraftBlocks.adamantOre, 2));
		//addDrop(EntityKQ.class, 20, "Scapecraft:dragonLongsword");
		//addDrop(EntityKQ.class, 2, "Scapecraft:mithrilPlatelegs");
		//addDrop(EntityKQ.class, 50, "Scapecraft:D2H");
		//addDrop(EntityKQ.class, 50, "Scapecraft:dragonPlatebody");

		//addDrop(EntityKQ2.class, 100, new ItemStack(Items.coal));

		//addDrop(EntityKaril.class, 1, "Scapecraft:karilKey");
		//addDrop(EntityKaril.class, 300, "Scapecraft:karilBoots");
		//addDrop(EntityKaril.class, 300, "Scapecraft:karilPlatebody");
		//addDrop(EntityKaril.class, 300, "Scapecraft:karilHelmet");
		//addDrop(EntityKaril.class, 300, "Scapecraft:karilPlatelegs");
		//addDrop(EntityKaril.class, 400, "Scapecraft:KarilBow");

		//addDrop(EntityKing.class, 40, "Scapecraft:dragonLongsword");
		//addDrop(EntityKing.class, 10, "Scapecraft:runeSword");
		//addDrop(EntityKing.class, 30, "Scapecraft:DD");
		//addDrop(EntityKing.class, 4, "Scapecraft:whiteHelmet");
		//addDrop(EntityKing.class, 6, "Scapecraft:whitePlatebody");
		//addDrop(EntityKing.class, 25, "Scapecraft:runePlatelegs");
		//addDrop(EntityKing.class, 5, new ItemStack(ScapecraftItems.fishPie, 4));

		//addDrop(EntityKingsGuard.class, 10, "Scapecraft:guardPlatebody");
		//addDrop(EntityKingsGuard.class, 10, "Scapecraft:guardHelmet");

		//koschei the deathless stage 3
		//addDrop(EntityKos3.class, 30, new ItemStack(ScapecraftBlocks.runeOre, 5));
		//addDrop(EntityKos3.class, 50, "Scapecraft:dragonHelmet");
		//addDrop(EntityKos3.class, 75, "Scapecraft:crystalBow");
		//addDrop(EntityKos3.class, 15, "Scapecraft:cabbageSpawn");
		//addDrop(EntityKos3.class, 5, "Scapecraft:fremSword");
		//addDrop(EntityKos3.class, 50, "Scapecraft:dragonPlatelegs");
		//addDrop(EntityKos3.class, 50, "Scapecraft:dragonBoots");
		//addDrop(EntityKos3.class, 40, "Scapecraft:runeBoots");
		//addDrop(EntityKos3.class, 40, "Scapecraft:runeHelmet");
		//addDrop(EntityKos3.class, 40, "Scapecraft:runePlatebody");
		//addDrop(EntityKos3.class, 40, "Scapecraft:runePlatelegs");
		//addDrop(EntityKos3.class, 50, "Scapecraft:fremSwordf");
		//addDrop(EntityKos3.class, 50, "Scapecraft:diamondOreSpawn");
		//addDrop(EntityKos3.class, 60, "Scapecraft:coalSpawn");
		//addDrop(EntityKos3.class, 75, "Scapecraft:mithrilOreSpawn");
		//addDrop(EntityKos3.class, 100, "Scapecraft:adamantOreSpawn");
		//addDrop(EntityKos3.class, 150, "Scapecraft:runeOreSpawn");

		//uses new lesser demon model
		addDrop(EntityLesserDemonUgly.class, 100, "Scapecraft:mithrilSword");
		addDrop(EntityLesserDemonUgly.class, 100, "Scapecraft:mithrilHelmet");
		addDrop(EntityLesserDemonUgly.class, 100, "Scapecraft:mithrilPlatebody");
		addDrop(EntityLesserDemonUgly.class, 100, "Scapecraft:mithrilPlatelegs");
		addDrop(EntityLesserDemonUgly.class, 100, "Scapecraft:mithrilBoots");
		addDrop(EntityLesserDemonUgly.class, 40, "Scapecraft:blackSword");
		addDrop(EntityLesserDemonUgly.class, 200, "Scapecraft:runeHelmet");
		addDrop(EntityLesserDemonUgly.class, 75, "Scapecraft:adamantSword");
		addDrop(EntityLesserDemonUgly.class, 50, new ItemStack(Blocks.gold_ore, 3));
		addDrop(EntityLesserDemonUgly.class, 1, new ItemStack(Items.gold_nugget));

		//uses old lesser demon model
		addDrop(EntityLesserDemon.class, 70, "Scapecraft:mithrilSword");
		addDrop(EntityLesserDemon.class, 70, "Scapecraft:mithrilHelmet");
		addDrop(EntityLesserDemon.class, 70, "Scapecraft:mithrilPlatebody");
		addDrop(EntityLesserDemon.class, 70, "Scapecraft:mithrilPlatelegs");
		addDrop(EntityLesserDemon.class, 70, "Scapecraft:mithrilBoots");
		addDrop(EntityLesserDemon.class, 20, "Scapecraft:blackSword");
		addDrop(EntityLesserDemon.class, 100, "Scapecraft:runeHelmet");
		addDrop(EntityLesserDemon.class, 75, "Scapecraft:adamantSword");
		addDrop(EntityLesserDemon.class, 50, new ItemStack(Blocks.gold_ore, 3));
		addDrop(EntityLesserDemon.class, 1, new ItemStack(Items.gold_nugget));

		//addDrop(EntityLootChest.class, 1, new ItemStack(Items.gold_ingot));
		//addDrop(EntityLootChest.class, 1, new ItemStack(Items.gold_ingot));
		//addDrop(EntityLootChest.class, 1, "Scapecraft:questPoint3");
		//addDrop(EntityLootChest.class, 1, new ItemStack(ScapecraftItems.fishPieUncooked, 10));
		//addDrop(EntityLootChest.class, 1, "Scapecraft:whiteBoots");
		//addDrop(EntityLootChest.class, 1, "Scapecraft:whitePlatebody");
		//addDrop(EntityLootChest.class, 1, "Scapecraft:whiteHelmet");
		//addDrop(EntityLootChest.class, 1, "Scapecraft:whitePlatelegs");
		//addDrop(EntityLootChest.class, 1, "Scapecraft:whiteSword");

		addDrop(EntityMan.class, 30, "Scapecraft:bronzeHelmet");
		addDrop(EntityMan.class, 30, "Scapecraft:bronzeBoots");
		addDrop(EntityMan.class, 20, "Scapecraft:bronzeSword");
		addDrop(EntityMan.class, 10, new ItemStack(ScapecraftBlocks.cabbage, 8));
		addDrop(EntityMan.class, 20, new ItemStack(Items.bow));
		addDrop(EntityMan.class, 20, new ItemStack(Items.arrow, 16));
		addDrop(EntityMan.class, 10, new ItemStack(Items.bread, 5));
		addDrop(EntityMan.class, 20, "Scapecraft:bronzePickaxe");

		addDrop(EntityMossGiant.class, 30, "Scapecraft:blackHelmet");
		addDrop(EntityMossGiant.class, 30, "Scapecraft:blackBoots");
		addDrop(EntityMossGiant.class, 40, "Scapecraft:mithrilSword");
		addDrop(EntityMossGiant.class, 50, "Scapecraft:mithrilPlatebody");
		addDrop(EntityMossGiant.class, 75, "Scapecraft:adamantSword");
		addDrop(EntityMossGiant.class, 75, "Scapecraft:adamantBoots");
		addDrop(EntityMossGiant.class, 10, new ItemStack(Items.coal, 4));
		addDrop(EntityMossGiant.class, 30, new ItemStack(Items.arrow, 12));

		addDrop(EntityMugger.class, 20, "Scapecraft:bronzeAxe");
		addDrop(EntityMugger.class, 20, "Scapecraft:bronzeSword");
		addDrop(EntityMugger.class, 40, "Scapecraft:ironSword");
		addDrop(EntityMugger.class, 2, new ItemStack(Items.gold_nugget));
		addDrop(EntityMugger.class, 30, "Scapecraft:magicFruit");

		addDrop(EntityRat.class, 5, "quest:ratTail");
		addDrop(EntityRat.class, 25, "Scapecraft:bronzeSword");

		addDrop(EntityRatSmall.class, 25, "Scapecraft:bronzeSword");
		addDrop(EntityRatSmall.class, 5, "quest:ratTail");

		addDrop(EntityScorpion.class, 100, "Scapecraft:blackPlatebody");
		addDrop(EntityScorpion.class, 30, "Scapecraft:ironPickaxe");
		addDrop(EntityScorpion.class, 1, new ItemStack(Items.wheat, 2));

		//addDrop(EntitySergeantGrimspike.class, 100, "Scapecraft:magicFruit");
		//addDrop(EntitySergeantGrimspike.class, 1000, "Scapecraft:shard1");
		//addDrop(EntitySergeantGrimspike.class, 500, "Scapecraft:dragonBoots");

		//addDrop(EntitySergeantSteelwill.class, 100, "Scapecraft:magicFruit");
		//addDrop(EntitySergeantSteelwill.class, 1000, "Scapecraft:shard2");
		//addDrop(EntitySergeantSteelwill.class, 500, "Scapecraft:dragonBoots");

		//addDrop(EntitySergeantStrongstack.class, 100, "Scapecraft:magicFruit");
		//addDrop(EntitySergeantStrongstack.class, 1000, "Scapecraft:shard3");
		//addDrop(EntitySergeantStrongstack.class, 500, "Scapecraft:dragonBoots");

		//addDrop(EntityTormentedDemon.class, 1, "Scapecraft:runeOre");
		//addDrop(EntityTormentedDemon.class, 1, "Scapecraft:magicFruit");
		//addDrop(EntityTormentedDemon.class, 100, "Scapecraft:mithrilOreSpawn");
		//addDrop(EntityTormentedDemon.class, 100, "Scapecraft:dragonBattleAxe");
		//addDrop(EntityTormentedDemon.class, 100, "Scapecraft:dragonHelmet");
		//addDrop(EntityTormentedDemon.class, 1000, "Scapecraft:runeOreSpawn");
		//addDrop(EntityTormentedDemon.class, 200, "Scapecraft:adamantOreSpawn");
		//addDrop(EntityTormentedDemon.class, 2000, "Scapecraft:crystalBow");
		//addDrop(EntityTormentedDemon.class, 3, "Scapecraft:mithrilPlatebody");
		//addDrop(EntityTormentedDemon.class, 400, "Scapecraft:dragonlBoots");
		//addDrop(EntityTormentedDemon.class, 400, "Scapecraft:dragonlPlatebody");
		//addDrop(EntityTormentedDemon.class, 400, "Scapecraft:dragonlHelmet");
		//addDrop(EntityTormentedDemon.class, 400, "Scapecraft:dragonlPlatelegs");
		//addDrop(EntityTormentedDemon.class, 500, "Scapecraft:coalOreSpawn");

		addDrop(EntityThief.class, 100, "Scapecraft:blackPlatelegs");
		addDrop(EntityThief.class, 20, "Scapecraft:magicFruit");
		addDrop(EntityThief.class, 50, "Scapecraft:blackSword");
		addDrop(EntityThief.class, 1, new ItemStack(Blocks.wool, 2, 15));

		//addDrop(EntityTorag.class, 1, "Scapecraft:toragKey");
		//addDrop(EntityTorag.class, 300, "Scapecraft:toragBoots");
		//addDrop(EntityTorag.class, 300, "Scapecraft:toragPlatebody");
		//addDrop(EntityTorag.class, 300, "Scapecraft:toragHelmet");
		//addDrop(EntityTorag.class, 300, "Scapecraft:toragPlatelegs");
		//addDrop(EntityTorag.class, 400, "Scapecraft:toragHammer");

		//addDrop(EntityVampire.class, 1, "Scapecraft:questItem");
		//addDrop(EntityVampire.class, 3, "Scapecraft:blackBoots");
		//addDrop(EntityVampire.class, 3, "Scapecraft:blackPlatebody");
		//addDrop(EntityVampire.class, 3, "Scapecraft:blackHelmet");
		//addDrop(EntityVampire.class, 3, "Scapecraft:blackPlatelegs");
		//addDrop(EntityVampire.class, 3, "Scapecraft:blackSword");

		//addDrop(EntityVerac.class, 1, "Scapecraft:veracKey");
		//addDrop(EntityVerac.class, 300, "Scapecraft:veracBoots");
		//addDrop(EntityVerac.class, 300, "Scapecraft:veracPlatebody");
		//addDrop(EntityVerac.class, 300, "Scapecraft:veracHelmet");
		//addDrop(EntityVerac.class, 300, "Scapecraft:veracPlatelegs");
		//addDrop(EntityVerac.class, 400, "Scapecraft:veracFlail");

		addDrop(EntityWhiteKnight.class, 60, "Scapecraft:whiteBoots");
		addDrop(EntityWhiteKnight.class, 60, "Scapecraft:whiteHelmet");
		addDrop(EntityWhiteKnight.class, 60, "Scapecraft:whiteSword");
		addDrop(EntityWhiteKnight.class, 60, "Scapecraft:whitePlatebody");
		addDrop(EntityWhiteKnight.class, 60, "Scapecraft:whitePlatelegs");
		addDrop(EntityWhiteKnight.class, 1, new ItemStack(Items.apple, 1));

		//addDrop(EntityWizard.class, 8, "Scapecraft:"); //no current drops

		//addDrop(EntityZilyana.class, 65, "Scapecraft:saraSword");
		//addDrop(EntityZilyana.class, 25, "Scapecraft:runePlatebody");
		//addDrop(EntityZilyana.class, 25, "Scapecraft:runePlatelegs");
		//addDrop(EntityZilyana.class, 15, "Scapecraft:adamantPlatebody");
		//addDrop(EntityZilyana.class, 25, "Scapecraft:runeSword");
		//addDrop(EntityZilyana.class, 20, new ItemStack(ScapecraftItems.superStr, 3));
		//addDrop(EntityZilyana.class, 20, new ItemStack(ScapecraftItems.superDef, 3));
		//addDrop(EntityZilyana.class, 20, new ItemStack(ScapecraftItems.saraBrew, 3));
		//addDrop(EntityZilyana.class, 20, new ItemStack(ScapecraftItems.superRestore, 3));
		//addDrop(EntityZilyana.class, 200, "Scapecraft:shard1");
		//addDrop(EntityZilyana.class, 200, "Scapecraft:shard2");
		//addDrop(EntityZilyana.class, 200, "Scapecraft:shard3");
		//addDrop(EntityZilyana.class, 100, "Scapecraft:saradominHilt");
		//addDrop(EntityZilyana.class, 35, new ItemStack(ScapecraftBlocks.yewLog, 16));
		//addDrop(EntityZilyana.class, 15, new ItemStack(ScapecraftBlocks.adamantOre, 8));
		//addDrop(EntityZilyana.class, 10, new ItemStack(ScapecraftBlocks.runeOre, 2));
		//addDrop(EntityZilyana.class, 30, new ItemStack(Items.coal, 32));
		//addDrop(EntityZilyana.class, 25, "Scapecraft:dragonDagger");
		//addDrop(EntityZilyana.class, 50, "Scapecraft:dragonHelmet");
		//addDrop(EntityZilyana.class, 25, "Scapecraft:runeAxe");
		//addDrop(EntityZilyana.class, 10, "Scapecraft:runeIngot");
		//addDrop(EntityZilyana.class, 35, new ItemStack(ScapecraftBlocks.magicLog, 16));

		//addDrop(EntityZaklnGritch.class, 1000, new ItemStack(Items.ScapecraftItems.)); zamorakian spear
		//addDrop(EntityZaklnGritch.class, 3000, new ItemStack(Items.ScapecraftItems.shard1));
		//addDrop(EntityZaklnGritch.class, 3000, new ItemStack(Items.ScapecraftItems.shard2));
		//addDrop(EntityZaklnGritch.class, 3000, new ItemStack(Items.ScapecraftItems.shard3));
		//addDrop(EntityZaklnGritch.class, 30, new ItemStack(Items.ScapecraftItems.superStr, 3));
		//addDrop(EntityZaklnGritch.class, 30, new ItemStack(Items.ScapecraftItems.superRestore, 3));
		//addDrop(EntityZaklnGritch.class, 30, new ItemStack(Items.ScapecraftItems.superDef, 3));
		//addDrop(EntityZaklnGritch.class, 30, new ItemStack(Items.ScapecraftItems.fishPie, 8));

		//addDrop(EntityZaklnGritch.class, 1000, new ItemStack(Items.ScapecraftItems.)); zamorakian spear
		//addDrop(EntityTstanonKarlak.class, 3000, new ItemStack(Items.ScapecraftItems.shard1));
		//addDrop(EntityTstanonKarlak.class, 3000, new ItemStack(Items.ScapecraftItems.shard2));
		//addDrop(EntityTstanonKarlak.class, 3000, new ItemStack(Items.ScapecraftItems.shard3));
		//addDrop(EntityTstanonKarlak.class, 30, new ItemStack(Items.ScapecraftItems.superStr, 3));
		//addDrop(EntityTstanonKarlak.class, 30, new ItemStack(Items.ScapecraftItems.superRestore, 3));
		//addDrop(EntityTstanonKarlak.class, 30, new ItemStack(Items.ScapecraftItems.superDef, 3));
		//addDrop(EntityTstanonKarlak.class, 30, new ItemStack(Items.ScapecraftItems.fishPie, 8));

		//addDrop(EntityZaklnGritch.class, 1000, new ItemStack(Items.ScapecraftItems.)); zamorakian spear
		//addDrop(EntityBalfrugKreeyath.class, 3000, new ItemStack(Items.ScapecraftItems.shard1));
		//addDrop(EntityBalfrugKreeyath.class, 3000, new ItemStack(Items.ScapecraftItems.shard2));
		//addDrop(EntityBalfrugKreeyath.class, 3000, new ItemStack(Items.ScapecraftItems.shard3));
		//addDrop(EntityBalfrugKreeyath.class, 30, new ItemStack(Items.ScapecraftItems.superStr, 3));
		//addDrop(EntityBalfrugKreeyath.class, 30, new ItemStack(Items.ScapecraftItems.superRestore, 3));
		//addDrop(EntityBalfrugKreeyath.class, 30, new ItemStack(Items.ScapecraftItems.superDef, 3));
		//addDrop(EntityBalfrugKreeyath.class, 30, new ItemStack(Items.ScapecraftItems.fishPie, 8));

		//addDrop(EntityKrilTsutsaroth.class, 65, new ItemStack(Items.ScapecraftItems.)); zamorakian spear
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.ScapecraftItems.runeSword));
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.ScapecraftItems.runePlatebody));
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.ScapecraftItems.runePlatelegs));
		//addDrop(EntityKrilTsutsaroth.class, 20, new ItemStack(Items.ScapecraftItems.adamantPlatebody));
		//addDrop(EntityKrilTsutsaroth.class, 20, new ItemStack(Items.ScapecraftItems.adamantPlatelegs));
		//addDrop(EntityKrilTsutsaroth.class, 100, new ItemStack(Items.ScapecraftItems.zamorakHilt));
		//addDrop(EntityKrilTsutsaroth.class, 200, new ItemStack(Items.ScapecraftItems.shard1));
		//addDrop(EntityKrilTsutsaroth.class, 200, new ItemStack(Items.ScapecraftItems.shard2));
		//addDrop(EntityKrilTsutsaroth.class, 200, new ItemStack(Items.ScapecraftItems.shard3));
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.ScapecraftItems.superStr, 3));
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.ScapecraftItems.superRestore, 3));
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.ScapecraftItems.runeOre, 2));
		//addDrop(EntityKrilTsutsaroth.class, 35, new ItemStack(Items.ScapecraftItems.yewLog, 16));
		//addDrop(EntityKrilTsutsaroth.class, 15, new ItemStack(Items.ScapecraftItems.adamantOre, 8));
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.coal, 32));
		//addDrop(EntityKrilTsutsaroth.class, 10, new ItemStack(Items.ScapecraftItems.runeIngot));
		//addDrop(EntityKrilTsutsaroth.class, 25, new ItemStack(Items.ScapecraftItems.dragonDagger));
		//addDrop(EntityKrilTsutsaroth.class, 50, new ItemStack(Items.ScapecraftItems.dragonHelmet));
		//addDrop(EntityKrilTsutsaroth.class, 25, new ItemStack(Items.ScapecraftItems.runeAxe));

		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.armadylHelmet));
		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.armadylPlatebody));
		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.armadylPlatelegs));
		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.armadylBoots));
		//addDrop(EntityKreearra.class, 100, new ItemStack(Items.ScapecraftItems.armadylHilt));
		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.shard1));
		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.shard2));
		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.shard3));
		//addDrop(EntityKreearra.class, 25, new ItemStack(Items.ScapecraftItems.runeSword));
		//addDrop(EntityKreearra.class, 25, new ItemStack(Items.ScapecraftItems.runePlatebody));
		//addDrop(EntityKreearra.class, 25, new ItemStack(Items.ScapecraftItems.blackdPlatebody));
		//addDrop(EntityKreearra.class, 25, new ItemStack(Items.ScapecraftItems.superDef, 3));
		//addDrop(EntityKreearra.class, 25, new ItemStack(Items.arrow, 32));

		//addDrop(EntityShapeshifter.class, 400, new ItemStack(Items.ScapecraftItems.));
		//addDrop(EntityShapeshifter.class, 400, new ItemStack(Items.ScapecraftItems.));
		//addDrop(EntityShapeshifter.class, 400, new ItemStack(Items.ScapecraftItems.));
		//addDrop(EntityShapeshifter.class, 400, new ItemStack(Items.ScapecraftItems.));

		setMoney(EntityAbbyDemon.class, 37, 200, 500, 920, 1360);
		setMoney(EntityBandit.class, 12, 25, 50, 100);
		setMoney(EntityBarbarian.class, 15, 58, 97);
		setMoney(EntityBlackDragon.class, 50, 300, 700, 1300);
		setMoney(EntityBlackDemon.class, 10, 350, 680, 1200);
		setMoney(EntityBlackGuard.class, 5, 40, 80, 120);
		setMoney(EntityBlackKnight.class, 5, 35, 59, 81);
		setMoney(EntityCaveCrawler.class, 30, 80, 110, 220);
		setMoney(EntityDarkwizard.class, 10, 30, 50, 75);
		setMoney(EntityDwarf.class, 4, 10, 30, 40);
		setMoney(EntityEliteBlackKnight.class, 25, 50, 140, 400, 750);
		setMoney(EntityFarmer.class, 9, 20, 32);
		setMoney(EntityFireGiant.class, 15, 75, 170, 250, 400);
		setMoney(EntityGhost.class, 18, 40, 120);
		setMoney(EntityGoblin.class, 1, 5, 8, 10);
		setMoney(EntityGreenDragon.class, 20, 60, 80, 140, 250);
		setMoney(EntityGuard.class, 5, 10, 30, 50);
		//setMoney(EntityHellhound.class, 15, 50, 80, 150, 340);
		setMoney(EntityHillGiant.class, 20, 50, 120, 170);
		setMoney(EntityIceGiant.class, 50, 120, 275, 540);
		setMoney(EntityIronDragon.class, 20, 80, 200, 310, 500);
		setMoney(EntityLesserDemonUgly.class, 17, 50, 120, 220, 310, 630);
		setMoney(EntityLesserDemon.class, 17, 50, 120, 220, 310, 630);
		setMoney(EntityMan.class, 1, 5, 8, 10);
		setMoney(EntityMossGiant.class, 7, 20, 80, 210, 320);
		setMoney(EntityMugger.class, 3, 15, 20, 31);
		setMoney(EntityRat.class, 1, 3, 9, 12);
		setMoney(EntityScorpion.class, 4, 21, 34);
		setMoney(EntityThief.class, 5, 11, 15, 30);
		setMoney(EntityWhiteKnight.class, 5, 35, 59, 81);
	}

	public static EntityScapecraft spawnScapecraftEntity(String name, World world)
	{
		EntityScapecraft entity = null;
		try {
			entity = (EntityScapecraft) ScapecraftEntities.entityNames.get(name.toLowerCase()).getConstructor(new Class[] { World.class }).newInstance(world);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	public static int getTextureCount(Class<? extends EntityScapecraft> entityClass)
	{
		return textures.get(entityClass).size();
	}
	public static ResourceLocation getTexture(Class<? extends EntityScapecraft> entityClass, int textureNum)
	{
		if(textures.get(entityClass).size() > textureNum)
		{
			return textures.get(entityClass).get(textureNum);
		}
		return null;
	}

	public static boolean hasTextures(Class<? extends EntityScapecraft> entityClass)
	{
		return textures.containsKey(entityClass);
	}

	public static void addDrop(Class<? extends EntityScapecraft> entityClass, int chance, String itemName)
	{
		addDrop(entityClass, chance, itemName, 1);
	}

	public static void addDrop(Class<? extends EntityScapecraft> entityClass, int chance, String itemName, int count)
	{
		if(itemName.startsWith("quest:"))
		{
			ItemStack stack = ScapecraftItems.questItem.getStackFromName(itemName.substring(6));
			if(stack != null)
			{
				addDrop(entityClass, chance, stack);
				return;
			}
		}

		Item item = GameData.getItemRegistry().getObject(itemName);
		if(item != null)
		{
			addDrop(entityClass, chance, new ItemStack(item, count));
		}
		else
		{
			System.err.printf("Attempted to add drop %s, this does not exist\n", itemName);
		}
	}

	public static void addDrop(Class<? extends EntityScapecraft> entityClass, int chance, ItemStack stack)
	{
		addDrop(entityClass, new Drop(stack, chance, false));
	}

	public static void addDrop(Class<? extends EntityScapecraft> entityClass, Drop drop)
	{
		ArrayList<Drop> list = drops.get(entityClass);
		if(list == null)
		{
			list = new ArrayList<Drop>();
		}
		list.add(drop);
		drops.put(entityClass, list);
	}

	public static void setMoney(Class<? extends Entity> entityClass, int... money)
	{
		moneyDrops.put(entityClass, money);
	}

	public static void setStats(Class<? extends EntityScapecraft> mob, float healthBase, float healthGrowth, float attackBase, float attackGrowth, float defenseBase, float defenseGrowth, float xpBase, float xpGrowth)
	{
		float[] stats = new float[]{healthBase, healthGrowth, attackBase, attackGrowth, defenseBase, defenseGrowth, xpBase, xpGrowth};
		for(int i = 0; i < stats.length; i++)
		{
			if(stats[i] < 0)
			{
				stats[i] = defaultStats[i];
			}
		}
		mobStats.put(mob, stats);
	}

	public static void setDefaultLevel(Class<? extends EntityScapecraft> mob, int minLevel, int maxLevel)
	{
		mobLevels.put(mob, new int[] {minLevel, maxLevel});
	}

	public static ArrayList<Drop> getDrops(Class<? extends Entity> mobClass)
	{
		return drops.containsKey(mobClass) ? drops.get(mobClass) : new ArrayList<Drop>();
	}

	public static void setDrops(Class<? extends Entity> mobClass, ArrayList<Drop> drops)
	{
		if(drops == null)
		{
			ScapecraftEntities.drops.remove(mobClass);
		}
		ScapecraftEntities.drops.put(mobClass, drops);
	}

	public static int[] getMoneyDrops(Class<? extends Entity> mobClass)
	{
		return moneyDrops.containsKey(mobClass) ? moneyDrops.get(mobClass) : new int[0];
	}

	public static float[] getMobStats(Class<? extends EntityScapecraft> mobClass)
	{
		return mobStats.containsKey(mobClass) ? mobStats.get(mobClass) : defaultStats;
	}

	public static int[] getMobLevels(Class<? extends EntityScapecraft> mobClass)
	{
		return mobLevels.containsKey(mobClass) ? mobLevels.get(mobClass) : defaultLevels;
	}
}
