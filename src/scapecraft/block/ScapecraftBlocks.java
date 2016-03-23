package scapecraft.block;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.oredict.OreDictionary;
import scapecraft.item.ItemBlockBlockSpawner;
import scapecraft.item.ItemScapecraftSlab;
import scapecraft.item.ScapecraftItems;
import scapecraft.tileentity.*;
import scapecraft.util.Stat;
import scapecraft.world.gen.feature.*;

import java.util.HashMap;
import java.util.Map;

public class ScapecraftBlocks
{
	public static HashMap<Block, Integer> blockLevels;

	public static Block coffin;

	public static Block blueCobble;
	public static Block blueCobbleCompressed;

	public static Block tinOre;
	public static Block copperOre;
	public static Block bluriteOre;
	public static Block mithrilOre;
	public static Block adamantOre;
	public static Block runeOre;

	public static Block bronzeBlock;
	public static Block steelBlock;
	public static Block mithrilBlock;
	public static Block adamantBlock;
	public static Block runeBlock;
	
	public static Block tinOreSpawn;
	public static Block copperOreSpawn;
	public static Block bluriteOreSpawn;
	public static Block mithrilOreSpawn;
	public static Block adamantOreSpawn;
	public static Block runeOreSpawn;
	public static Block coalOreSpawn;
	public static Block diamondOreSpawn;
	public static Block cobblestoneSpawn;
	public static Block redstoneOreSpawn;
	public static Block goldOreSpawn;
	public static Block emeraldOreSpawn;
	public static Block ironOreSpawn;
	public static Block sandstoneSpawn;
	public static Block sandSpawn;
	public static Block dirtSpawn;
	public static Block gravelSpawn;
	public static Block blueCobbleSpawn;
	public static Block wheatSpawn;
	public static Block carrotSpawn;
	public static Block potatoSpawn;

	public static Block cabbageSpawn;
	public static Block oakTreeSpawn;
	public static Block strongOakTreeSpawn;
	public static Block willowTreeSpawn;
	public static Block mapleTreeSpawn;
	public static Block yewTreeSpawn;
	public static Block magicTreeSpawn;

	public static Block unbreakableAnvil;

	public static HashMap<String, Block> levelWalls = new HashMap<String, Block>();

	public static Block agilityBlock;
	public static Block agilityBlock2;
	public static Block agilityBlock3;

	public static Block kosTele;
	public static Block woolGate;

	public static Block keyBlock;
	public static Block keyBlock2;

	public static Block strongOakLog;
	public static Block strongOakPlank;
	public static Block strongOakStairs;
	public static Block strongOakSapling;
	public static Block strongOakLeaves;
	public static Block willowLog;
	public static Block willowPlank;
	public static Block willowStairs;
	public static Block willowSapling;
	public static Block willowLeaves;
	public static Block mapleLog;
	public static Block maplePlank;
	public static Block mapleStairs;
	public static Block mapleSapling;
	public static Block mapleLeaves;
	public static Block yewLog;
	public static Block yewPlank;
	public static Block yewStairs;
	public static Block yewSapling;
	public static Block yewLeaves;
	public static Block magicLog;
	public static Block magicPlank;
	public static Block magicStairs;
	public static Block magicSapling;
	public static Block magicLeaves;
	public static Block slab;
	public static Block doubleSlab;

	public static Block serverNotice;
	public static Block whiteBlock;
	public static Block blackBlock;
	public static Block hardIce;
	public static Block invisibleLight;
	public static Block dungeonTele;
	public static Block scapecraftPortal;

	public static Block cabbage;

	public static Block stall;
	public static Block mobSpawner;
	public static Block scapecraftFire;
	public static Block dungeonDoor;
	public static Block smeltingFurnace;
	public static Block smithingAnvil;

	public static void registerBlocks()
	{
		coffin = new BlockCoffin();

		cabbage = new BlockCabbage().setTextureName("scapecraft:cabbage").setUnlocalizedName("cabbage");

		blueCobble = new BlockScapecraft(Material.rock).setTextureName("scapecraft:BlueCobblestone").setUnlocalizedName("blueCobble").setHardness(1.0F);
		blueCobbleCompressed = new BlockScapecraft(Material.rock).setTextureName("scapecraft:BlueCobblestonec").setUnlocalizedName("blueCobbleCompressed");

		tinOre = new BlockScapecraft(Material.rock).setHarvest("pickaxe", 0).setTextureName("scapecraft:TinOre").setHardness(10.0F).setResistance(5.0F).setUnlocalizedName("tinOre");
		copperOre = new BlockScapecraft(Material.rock).setHarvest("pickaxe", 0).setTextureName("scapecraft:CopperOre").setHardness(10.0F).setResistance(5.0F).setUnlocalizedName("copperOre");
		bluriteOre = new BlockScapecraft(Material.rock).setHarvest("pickaxe", 0).setTextureName("scapecraft:BluriteOre").setHardness(10.0F).setResistance(5.0F).setUnlocalizedName("bluriteOre");
		mithrilOre = new BlockScapecraft(Material.rock).setHarvest("pickaxe", 1).setTextureName("scapecraft:MithrilOre").setHardness(30.0F).setResistance(5.0F).setUnlocalizedName("mithrilOre");
		adamantOre = new BlockScapecraft(Material.rock).setHarvest("pickaxe", 2).setTextureName("scapecraft:AdamantOre").setHardness(60.0F).setResistance(5.0F).setUnlocalizedName("adamantOre");
		runeOre = new BlockScapecraft(Material.rock).setHarvest("pickaxe", 2).setTextureName("scapecraft:RuneOre").setHardness(80.0F).setResistance(50.0F).setUnlocalizedName("runeOre");

		bronzeBlock = new BlockScapecraft(Material.rock).setBeaconBase().setTextureName("scapecraft:BronzeBlock").setHardness(10.0F).setResistance(2.0F).setUnlocalizedName("bronzeBlock");
		steelBlock = new BlockScapecraft(Material.rock).setBeaconBase().setTextureName("scapecraft:SteelBlock").setHardness(10.0F).setResistance(2.0F).setUnlocalizedName("steelBlock");
		mithrilBlock = new BlockScapecraft(Material.rock).setBeaconBase().setTextureName("scapecraft:MithrilBlock").setHardness(30.0F).setResistance(5.0F).setUnlocalizedName("mithrilBlock");
		adamantBlock = new BlockScapecraft(Material.rock).setBeaconBase().setTextureName("scapecraft:AdamantBlock").setHardness(60.0F).setResistance(25.0F).setUnlocalizedName("adamantBlock");
		runeBlock = new BlockScapecraft(Material.rock).setBeaconBase().setTextureName("scapecraft:RuneBlock").setHardness(80.0F).setResistance(50.0F).setUnlocalizedName("runeBlock");

		cobblestoneSpawn = new BlockBlockSpawner(Blocks.cobblestone, 10, 3);
		tinOreSpawn = new BlockBlockSpawner(tinOre, 90, 35);
		copperOreSpawn = new BlockBlockSpawner(copperOre, 90, 35);
		bluriteOreSpawn = new BlockBlockSpawner(bluriteOre, 90, 35);
		redstoneOreSpawn = new BlockBlockSpawner(Blocks.redstone_ore, 600, 50);
		ironOreSpawn = new BlockBlockSpawner(Blocks.iron_ore, 300, 70);
		coalOreSpawn = new BlockBlockSpawner(Blocks.coal_ore, 120, 50);
		diamondOreSpawn = new BlockBlockSpawner(Blocks.diamond_ore, 1800, 100);
		emeraldOreSpawn = new BlockBlockSpawner(Blocks.emerald_ore, 4500, 120);
		goldOreSpawn = new BlockBlockSpawner(Blocks.gold_ore, 1200, 130);
		mithrilOreSpawn = new BlockBlockSpawner(mithrilOre, 1200, 160);
		adamantOreSpawn = new BlockBlockSpawner(adamantOre, 2400, 180);
		runeOreSpawn = new BlockBlockSpawner(runeOre, 3600, 250);
		sandstoneSpawn = new BlockBlockSpawner(Blocks.sandstone, 3);
		sandSpawn = new BlockBlockSpawner(Blocks.sand, 2);
		dirtSpawn = new BlockBlockSpawner(Blocks.dirt, 2);
		gravelSpawn = new BlockBlockSpawner(Blocks.gravel, 20);
		blueCobbleSpawn = new BlockBlockSpawner(blueCobble, 10800);
		gravelSpawn = new BlockBlockSpawner(Blocks.gravel, 20);

		wheatSpawn = new BlockCropSpawner(Blocks.wheat, 1800, 0);
		carrotSpawn = new BlockCropSpawner(Blocks.carrots, 1800, 0);
		potatoSpawn = new BlockCropSpawner(Blocks.potatoes, 1800, 0);
		cabbageSpawn = new BlockCropSpawner(cabbage, 60, 1);


		for(Stat stat : Stat.values())
		{
			levelWalls.put(stat.toString().toLowerCase() + "LevelWall", new BlockStatWall(stat));
		}

		agilityBlock = new BlockAgility(3);
		agilityBlock2 = new BlockAgility(16);
		agilityBlock3 = new BlockAgility(70);

		kosTele = new BlockRedstoneCost(new ItemStack(Items.gold_ingot)).setUnlocalizedName("KosTele").setTextureName("minecraft:endframe_top");
		woolGate = new BlockRedstoneCost(new ItemStack(Blocks.wool, 20)).setUnlocalizedName("woolGate").setTextureName("minecraft:wool_colored_white");

		keyBlock = new BlockLock(ScapecraftItems.tombKey).setUnlocalizedName("barrowsLock");
		keyBlock2 = new BlockLock(ScapecraftItems.doorKey).setUnlocalizedName("fortressLock");

		strongOakLog = new BlockScapecraftLog().setHarvest("axe", 2).setTextureName("scapecraft:StrongOakLog").setHardness(20.0F).setUnlocalizedName("strongOakLog");
		strongOakPlank = new BlockScapecraft(Material.wood).setHarvest("axe", 2).setTextureName("scapecraft:StrongOakPlank").setHardness(50F).setUnlocalizedName("strongOakPlank");
		strongOakStairs = new BlockScapecraftStairs(strongOakPlank).setUnlocalizedName("strongOakStairs").setTextureName("strongOakPlank");
		strongOakSapling = new BlockScapecraftSapling(WorldGenStrongOakTree.class).setTextureName("scapecraft:StrongOakSapling").setUnlocalizedName("strongOakSapling");
		strongOakLeaves = new BlockScapecraftLeaves(strongOakSapling).setTextureName("scapecraft:StrongOakLeaves").setUnlocalizedName("strongOakLeaves");
		willowLog = new BlockScapecraftLog().setHarvest("axe", 2).setTextureName("scapecraft:WillowLog").setHardness(20.0F).setUnlocalizedName("willowLog");
		willowPlank = new BlockScapecraft(Material.wood).setHarvest("axe", 2).setTextureName("scapecraft:WillowPlank").setHardness(50F).setUnlocalizedName("willowPlank");
		willowStairs = new BlockScapecraftStairs(willowPlank).setUnlocalizedName("willowStairs").setTextureName("willowPlank");
		willowSapling = new BlockScapecraftSapling(WorldGenWillowTree.class).setTextureName("scapecraft:WillowSapling").setUnlocalizedName("willowSapling");
		willowLeaves = new BlockScapecraftLeaves(willowSapling).setTextureName("scapecraft:WillowLeaves").setUnlocalizedName("willowLeaves");
		mapleLog = new BlockScapecraftLog().setHarvest("axe", 2).setTextureName("scapecraft:MapleLog").setHardness(15.0F).setUnlocalizedName("mapleLog");
		maplePlank = new BlockScapecraft(Material.wood).setHarvest("axe", 2).setTextureName("scapecraft:MaplePlank").setHardness(50F).setUnlocalizedName("maplePlank");
		mapleStairs = new BlockScapecraftStairs(maplePlank).setUnlocalizedName("mapleStairs").setTextureName("maplePlank");
		mapleSapling = new BlockScapecraftSapling(WorldGenMapleTree.class).setTextureName("scapecraft:MapleSapling").setUnlocalizedName("mapleSapling");
		mapleLeaves = new BlockScapecraftLeaves(mapleSapling).setTextureName("scapecraft:MapleLeaves").setUnlocalizedName("mapleLeaves");
		yewLog = new BlockScapecraftLog().setHarvest("axe", 2).setTextureName("scapecraft:YewLog").setHardness(20.0F).setUnlocalizedName("yewLog");
		yewPlank = new BlockScapecraft(Material.wood).setHarvest("axe", 2).setTextureName("scapecraft:YewPlank").setHardness(50F).setUnlocalizedName("yewPlank");
		yewStairs = new BlockScapecraftStairs(yewPlank).setUnlocalizedName("yewStairs").setTextureName("yewPlank");
		yewSapling = new BlockScapecraftSapling(WorldGenYewTree.class).setTextureName("scapecraft:YewSapling").setUnlocalizedName("yewSapling");
		yewLeaves = new BlockScapecraftLeaves(yewSapling).setTextureName("scapecraft:YewLeaves").setUnlocalizedName("yewLeaves");
		magicLog = new BlockScapecraftLog().setHarvest("axe", 2).setTextureName("scapecraft:MagicLog").setHardness(50.0F).setUnlocalizedName("magicLog");
		magicPlank = new BlockScapecraft(Material.wood).setHarvest("axe", 2).setTextureName("scapecraft:MagicPlank").setHardness(5.0F).setUnlocalizedName("magicPlank");
		magicStairs = new BlockScapecraftStairs(magicPlank).setUnlocalizedName("magicStairs").setTextureName("magicPlank");
		magicSapling = new BlockScapecraftSapling(WorldGenMagicTree.class).setTextureName("scapecraft:MagicSapling").setUnlocalizedName("magicSapling");
		magicLeaves = new BlockScapecraftLeaves(magicSapling, ScapecraftItems.magicFruit).setTextureName("scapecraft:MagicLeaves").setUnlocalizedName("magicLeaves");

		serverNotice = new BlockScapecraft(Material.glass).setTextureName("scapecraft:ServerNotice").setUnlocalizedName("serverNotice");
		whiteBlock = new BlockScapecraft(Material.glass).setTextureName("scapecraft:WhiteBlock").setHardness(40F).setResistance(5000F).setUnlocalizedName("whiteBlock");
		blackBlock = new BlockScapecraft(Material.glass).setTextureName("scapecraft:BlackBlock").setHardness(40F).setResistance(5000F).setUnlocalizedName("blackBlock");
		hardIce = new BlockScapecraftTransparent(Material.ice).setTextureName("minecraft:ice").setHardness(40F).setResistance(5000F).setUnlocalizedName("hardIce");
		invisibleLight = new BlockInvisibleLight();

		stall = new BlockStall();
		mobSpawner = new BlockSpawn();
		scapecraftFire = new BlockScapecraftFire();
		dungeonDoor = new BlockDungeonDoor().setTextureName("endframe_eye");
		smeltingFurnace = new BlockSmeltingFurnace();
		smithingAnvil = new BlockSmithingAnvil();

		oakTreeSpawn = new BlockTreeSpawner(Blocks.log, 100, new WorldGenOakTree(true), 4);
		strongOakTreeSpawn = new BlockTreeSpawner(strongOakLog, 200, new WorldGenStrongOakTree(true), 38);
		willowTreeSpawn = new BlockTreeSpawner(willowLog, 400, new WorldGenWillowTree(true), 68);
		mapleTreeSpawn = new BlockTreeSpawner(mapleLog, 600, new WorldGenMapleTree(true), 100);
		yewTreeSpawn = new BlockTreeSpawner(yewLog, 1200, new WorldGenYewTree(true), 175);
		magicTreeSpawn = new BlockTreeSpawner(magicLog, 1800, new WorldGenMagicTree(true), 250);

		unbreakableAnvil = new BlockUnbreakableAnvil();
		dungeonTele = new BlockDungeonTele();
		scapecraftPortal = new BlockScapecraftPortal();
		slab = new BlockScapecraftSlab(false);
		doubleSlab = new BlockScapecraftSlab(true);

		GameRegistry.registerBlock(coffin, "coffin");

		GameRegistry.registerBlock(blueCobble, "blueCobble");
		GameRegistry.registerBlock(blueCobbleCompressed, "blueCobbleCompressed");

		GameRegistry.registerBlock(tinOre, "tinOre");
		GameRegistry.registerBlock(copperOre, "copperOre");
		GameRegistry.registerBlock(bluriteOre, "bluriteOre");
		GameRegistry.registerBlock(mithrilOre, "mithrilOre");
		GameRegistry.registerBlock(adamantOre, "adamantOre");
		GameRegistry.registerBlock(runeOre, "runeOre");

		GameRegistry.registerBlock(bronzeBlock, "bronzeBlock");
		GameRegistry.registerBlock(steelBlock, "steelBlock");
		GameRegistry.registerBlock(mithrilBlock, "mithrilBlock");
		GameRegistry.registerBlock(adamantBlock, "adamantBlock");
		GameRegistry.registerBlock(runeBlock, "runeBlock");

		GameRegistry.registerBlock(tinOreSpawn, ItemBlockBlockSpawner.class, "tinOreSpawn");
		GameRegistry.registerBlock(copperOreSpawn, ItemBlockBlockSpawner.class, "copperOreSpawn");
		GameRegistry.registerBlock(bluriteOreSpawn, ItemBlockBlockSpawner.class, "bluriteOreSpawn");
		GameRegistry.registerBlock(mithrilOreSpawn, ItemBlockBlockSpawner.class, "mithrilOreSpawn");
		GameRegistry.registerBlock(adamantOreSpawn, ItemBlockBlockSpawner.class, "adamantOreSpawn");
		GameRegistry.registerBlock(runeOreSpawn, ItemBlockBlockSpawner.class, "runeOreSpawn");
		GameRegistry.registerBlock(coalOreSpawn, ItemBlockBlockSpawner.class, "coalOreSpawn");
		GameRegistry.registerBlock(diamondOreSpawn, ItemBlockBlockSpawner.class, "diamondOreSpawn");
		GameRegistry.registerBlock(cobblestoneSpawn, ItemBlockBlockSpawner.class, "cobblestoneSpawn");
		GameRegistry.registerBlock(redstoneOreSpawn, ItemBlockBlockSpawner.class, "redstoneOreSpawn");
		GameRegistry.registerBlock(goldOreSpawn, ItemBlockBlockSpawner.class, "goldOreSpawn");
		GameRegistry.registerBlock(emeraldOreSpawn, ItemBlockBlockSpawner.class, "emeraldOreSpawn");
		GameRegistry.registerBlock(ironOreSpawn, ItemBlockBlockSpawner.class, "ironOreSpawn");
		GameRegistry.registerBlock(sandstoneSpawn, ItemBlockBlockSpawner.class, "sandstoneSpawn");
		GameRegistry.registerBlock(sandSpawn, ItemBlockBlockSpawner.class, "sandSpawn");
		GameRegistry.registerBlock(dirtSpawn, ItemBlockBlockSpawner.class, "dirtSpawn");
		GameRegistry.registerBlock(gravelSpawn, ItemBlockBlockSpawner.class, "gravelSpawn");
		GameRegistry.registerBlock(blueCobbleSpawn, ItemBlockBlockSpawner.class, "blueCobbleSpawn");
		GameRegistry.registerBlock(wheatSpawn, ItemBlockBlockSpawner.class, "wheatSpawn");
		GameRegistry.registerBlock(carrotSpawn, ItemBlockBlockSpawner.class, "carrotSpawn");
		GameRegistry.registerBlock(potatoSpawn, ItemBlockBlockSpawner.class, "potatoSpawn");

		GameRegistry.registerBlock(oakTreeSpawn, ItemBlockBlockSpawner.class, "oakTreeSpawn");
		GameRegistry.registerBlock(strongOakTreeSpawn, ItemBlockBlockSpawner.class, "strongOakTreeSpawn");
		GameRegistry.registerBlock(willowTreeSpawn, ItemBlockBlockSpawner.class, "willowTreeSpawn");
		GameRegistry.registerBlock(mapleTreeSpawn, ItemBlockBlockSpawner.class, "mapleTreeSpawn");
		GameRegistry.registerBlock(yewTreeSpawn, ItemBlockBlockSpawner.class, "yewTreeSpawn");
		GameRegistry.registerBlock(magicTreeSpawn, ItemBlockBlockSpawner.class, "magicTreeSpawn");

		GameRegistry.registerBlock(cabbageSpawn, ItemBlockBlockSpawner.class, "cabbageSpawn");

		GameRegistry.registerBlock(unbreakableAnvil, "unbreakableAnvil");

		GameRegistry.registerBlock(cabbage, "cabbage");

		for(Map.Entry<String, Block> entry : levelWalls.entrySet())
		{
			GameRegistry.registerBlock(entry.getValue(), entry.getKey());
			Item.getItemFromBlock(entry.getValue()).setHasSubtypes(true);
		}

		GameRegistry.registerBlock(agilityBlock, "agilityBlock");
		GameRegistry.registerBlock(agilityBlock2, "agilityBlock2");
		GameRegistry.registerBlock(agilityBlock3, "agilityBlock3");

		GameRegistry.registerBlock(kosTele, "kosTele");
		GameRegistry.registerBlock(woolGate, "woolGate");

		GameRegistry.registerBlock(keyBlock, "keyBlock");
		GameRegistry.registerBlock(keyBlock2, "keyBlock2");

		GameRegistry.registerBlock(strongOakLog, "strongOakLog");
		GameRegistry.registerBlock(strongOakPlank, "strongOakPlank");
		GameRegistry.registerBlock(strongOakStairs, "strongOakStairs");
		GameRegistry.registerBlock(strongOakSapling, "strongOakSapling");
		GameRegistry.registerBlock(strongOakLeaves, "strongOakLeaves");
		GameRegistry.registerBlock(willowLog, "willowLog");
		GameRegistry.registerBlock(willowPlank, "willowPlank");
		GameRegistry.registerBlock(willowStairs, "willowStairs");
		GameRegistry.registerBlock(willowSapling, "willowSapling");
		GameRegistry.registerBlock(willowLeaves, "willowLeaves");
		GameRegistry.registerBlock(mapleLog, "mapleLog");
		GameRegistry.registerBlock(maplePlank, "maplePlank");
		GameRegistry.registerBlock(mapleStairs, "mapleStairs");
		GameRegistry.registerBlock(mapleSapling, "mapleSapling");
		GameRegistry.registerBlock(mapleLeaves, "mapleLeaves");
		GameRegistry.registerBlock(yewLog, "yewLog");
		GameRegistry.registerBlock(yewPlank, "yewPlank");
		GameRegistry.registerBlock(yewStairs, "yewStairs");
		GameRegistry.registerBlock(yewSapling, "yewSapling");
		GameRegistry.registerBlock(yewLeaves, "yewLeaves");
		GameRegistry.registerBlock(magicLog, "magicLog");
		GameRegistry.registerBlock(magicPlank, "magicPlank");
		GameRegistry.registerBlock(magicStairs, "magicStairs");
		GameRegistry.registerBlock(magicSapling, "magicSapling");
		GameRegistry.registerBlock(magicLeaves, "magicLeaves");
		GameRegistry.registerBlock(slab, ItemScapecraftSlab.class, "slab", slab, doubleSlab, false);
		GameRegistry.registerBlock(doubleSlab, ItemScapecraftSlab.class, "doubleSlab", slab, doubleSlab, true);

		GameRegistry.registerBlock(serverNotice, "serverNotice");
		GameRegistry.registerBlock(whiteBlock, "whiteBlock");
		GameRegistry.registerBlock(blackBlock, "blackBlock");
		GameRegistry.registerBlock(hardIce, "hardIce");
		GameRegistry.registerBlock(invisibleLight, "invisibleLight");

		GameRegistry.registerBlock(stall, "stall");
		GameRegistry.registerBlock(mobSpawner, "mobSpawner");
		GameRegistry.registerBlock(scapecraftFire, "scapecraftFire");
		GameRegistry.registerBlock(dungeonDoor, "dungeonDoor");
		GameRegistry.registerBlock(smeltingFurnace, "smeltingFurnace");
		GameRegistry.registerBlock(smithingAnvil, "smithingAnvil");

		GameRegistry.registerBlock(dungeonTele, "dungeonTele");
		GameRegistry.registerBlock(scapecraftPortal, "scapecraftPortal");

		GameRegistry.registerTileEntity(TileEntityBlockSpawner.class, "blockSpawner");
		GameRegistry.registerTileEntity(TileEntityTreeSpawner.class, "treeSpawner");
		GameRegistry.registerTileEntity(TileEntityScapecraftMobSpawner.class, "scapecraftMobSpawner");
		GameRegistry.registerTileEntity(TileEntityStall.class, "stall");
		GameRegistry.registerTileEntity(TileEntityFire.class, "scapecraftFire");
		GameRegistry.registerTileEntity(TileEntityDungeonDoor.class, "dungeonDoor");
		GameRegistry.registerTileEntity(TileEntitySmeltingFurnace.class, "smeltingFurnace");
		GameRegistry.registerTileEntity(TileEntitySmithingAnvil.class, "smithingAnvil");
		GameRegistry.registerTileEntity(TileEntityScapecraftPortal.class, "scapecraftPortal");

		OreDictionary.registerOre("plankWood", strongOakPlank);
		OreDictionary.registerOre("plankWood", willowPlank);
		OreDictionary.registerOre("plankWood", maplePlank);
		OreDictionary.registerOre("plankWood", yewPlank);
		OreDictionary.registerOre("plankWood", magicPlank);
		OreDictionary.registerOre("logWood", strongOakLog);
		OreDictionary.registerOre("logWood", willowLog);
		OreDictionary.registerOre("logWood", mapleLog);
		OreDictionary.registerOre("logWood", yewLog);
		OreDictionary.registerOre("logWood", magicLog);
		OreDictionary.registerOre("treeLeaves", strongOakLeaves);
		OreDictionary.registerOre("treeLeaves", willowLeaves);
		OreDictionary.registerOre("treeLeaves", mapleLeaves);
		OreDictionary.registerOre("treeLeaves", yewLeaves);
		OreDictionary.registerOre("treeLeaves", magicLeaves);
		OreDictionary.registerOre("treeSapling", strongOakSapling);
		OreDictionary.registerOre("treeSapling", willowSapling);
		OreDictionary.registerOre("treeSapling", mapleSapling);
		OreDictionary.registerOre("treeSapling", yewSapling);
		OreDictionary.registerOre("treeSapling", magicSapling);

		OreDictionary.registerOre("oreTin", tinOre);
		OreDictionary.registerOre("oreCopper", copperOre);
		OreDictionary.registerOre("oreBlurite", bluriteOre);
		OreDictionary.registerOre("oreMithril", mithrilOre);
		OreDictionary.registerOre("oreAdamant", adamantOre);
		OreDictionary.registerOre("oreRune", runeOre);
		OreDictionary.registerOre("blockBronze", bronzeBlock);
		OreDictionary.registerOre("blockMithril", mithrilBlock);
		OreDictionary.registerOre("blockAdamant", adamantBlock);
		OreDictionary.registerOre("blockRune", runeBlock);
	}

	public static void setBlockLevels(NBTTagList blocks)
	{
		blockLevels = new HashMap<Block, Integer>();
		for(int i = 0; i < blocks.tagCount(); i++)
		{
			NBTTagCompound tag = blocks.getCompoundTagAt(i);
			Block block = GameData.getBlockRegistry().getObject(tag.getString("string"));
			blockLevels.put(block, tag.getInteger("number"));
		}
	}
}
