package scapecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import scapecraft.item.ItemBlockBlockSpawner;
import scapecraft.item.ItemScapecraftSlab;
import scapecraft.item.ScapecraftItems;
import scapecraft.tileentity.*;
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

	//TODO Combine spawn blocks and use the tileentity to keep track of what block it is
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


	public static HashMap<String, Block> levelWalls = new HashMap<String, Block>();

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
	public static BlockScapecraftSlab slab;
	public static BlockScapecraftSlab doubleSlab;

	public static Block whiteBlock;
	public static Block blackBlock;
	public static Block hardIce;
	public static Block invisibleLight;
	public static Block dungeonTele;
	public static Block scapecraftPortal;

	public static Block cabbage;

	public static Block mobSpawner;
	public static Block dungeonDoor;
	public static Block smeltingFurnace;
	public static Block smithingAnvil;

	public static void registerBlocks()
	{
		coffin = new BlockCoffin();

		cabbage = new BlockCabbage().setUnlocalizedName("cabbage");

		blueCobble = new BlockScapecraft(Material.ROCK).setUnlocalizedName("blueCobble").setHardness(1.0F);
		blueCobbleCompressed = new BlockScapecraft(Material.ROCK).setUnlocalizedName("blueCobbleCompressed");

		tinOre = new BlockScapecraft(Material.ROCK).setHarvest("pickaxe", 0).setHardness(10.0F).setResistance(5.0F).setUnlocalizedName("tinOre");
		copperOre = new BlockScapecraft(Material.ROCK).setHarvest("pickaxe", 0).setHardness(10.0F).setResistance(5.0F).setUnlocalizedName("copperOre");
		bluriteOre = new BlockScapecraft(Material.ROCK).setHarvest("pickaxe", 0).setHardness(10.0F).setResistance(5.0F).setUnlocalizedName("bluriteOre");
		mithrilOre = new BlockScapecraft(Material.ROCK).setHarvest("pickaxe", 1).setHardness(30.0F).setResistance(5.0F).setUnlocalizedName("mithrilOre");
		adamantOre = new BlockScapecraft(Material.ROCK).setHarvest("pickaxe", 2).setHardness(60.0F).setResistance(5.0F).setUnlocalizedName("adamantOre");
		runeOre = new BlockScapecraft(Material.ROCK).setHarvest("pickaxe", 2).setHardness(80.0F).setResistance(50.0F).setUnlocalizedName("runeOre");

		bronzeBlock = new BlockScapecraft(Material.ROCK).setBeaconBase().setHardness(10.0F).setResistance(2.0F).setUnlocalizedName("bronzeBlock");
		steelBlock = new BlockScapecraft(Material.ROCK).setBeaconBase().setHardness(10.0F).setResistance(2.0F).setUnlocalizedName("steelBlock");
		mithrilBlock = new BlockScapecraft(Material.ROCK).setBeaconBase().setHardness(30.0F).setResistance(5.0F).setUnlocalizedName("mithrilBlock");
		adamantBlock = new BlockScapecraft(Material.ROCK).setBeaconBase().setHardness(60.0F).setResistance(25.0F).setUnlocalizedName("adamantBlock");
		runeBlock = new BlockScapecraft(Material.ROCK).setBeaconBase().setHardness(80.0F).setResistance(50.0F).setUnlocalizedName("runeBlock");

		cobblestoneSpawn = new BlockBlockSpawner(Blocks.COBBLESTONE, 10, 3);
		tinOreSpawn = new BlockBlockSpawner(tinOre, 90, 35);
		copperOreSpawn = new BlockBlockSpawner(copperOre, 90, 35);
		bluriteOreSpawn = new BlockBlockSpawner(bluriteOre, 90, 35);
		redstoneOreSpawn = new BlockBlockSpawner(Blocks.REDSTONE_ORE, 600, 50);
		ironOreSpawn = new BlockBlockSpawner(Blocks.IRON_ORE, 300, 70);
		coalOreSpawn = new BlockBlockSpawner(Blocks.COAL_ORE, 120, 50);
		diamondOreSpawn = new BlockBlockSpawner(Blocks.DIAMOND_ORE, 1800, 100);
		emeraldOreSpawn = new BlockBlockSpawner(Blocks.EMERALD_ORE, 4500, 120);
		goldOreSpawn = new BlockBlockSpawner(Blocks.GOLD_ORE, 1200, 130);
		mithrilOreSpawn = new BlockBlockSpawner(mithrilOre, 1200, 160);
		adamantOreSpawn = new BlockBlockSpawner(adamantOre, 2400, 180);
		runeOreSpawn = new BlockBlockSpawner(runeOre, 3600, 250);
		sandstoneSpawn = new BlockBlockSpawner(Blocks.SANDSTONE, 3);
		sandSpawn = new BlockBlockSpawner(Blocks.SAND, 2);
		dirtSpawn = new BlockBlockSpawner(Blocks.DIRT, 2);
		gravelSpawn = new BlockBlockSpawner(Blocks.GRAVEL, 20);
		blueCobbleSpawn = new BlockBlockSpawner(blueCobble, 10800);
		gravelSpawn = new BlockBlockSpawner(Blocks.GRAVEL, 20);

		wheatSpawn = new BlockCropSpawner(Blocks.WHEAT, 1800, 0);
		carrotSpawn = new BlockCropSpawner(Blocks.CARROTS, 1800, 0);
		potatoSpawn = new BlockCropSpawner(Blocks.POTATOES, 1800, 0);
		cabbageSpawn = new BlockCropSpawner(cabbage, 60, 1);

		strongOakLog = new BlockScapecraftLog().setHarvest("axe", 2).setHardness(20.0F).setUnlocalizedName("strongOakLog");
		strongOakPlank = new BlockScapecraft(Material.WOOD).setHarvest("axe", 2).setHardness(50F).setUnlocalizedName("strongOakPlank");
		strongOakStairs = new BlockScapecraftStairs(strongOakPlank).setUnlocalizedName("strongOakStairs");
		strongOakSapling = new BlockScapecraftSapling(WorldGenStrongOakTree.class).setUnlocalizedName("strongOakSapling");
		strongOakLeaves = new BlockScapecraftLeaves(strongOakSapling).setUnlocalizedName("strongOakLeaves");
		willowLog = new BlockScapecraftLog().setHarvest("axe", 2).setHardness(20.0F).setUnlocalizedName("willowLog");
		willowPlank = new BlockScapecraft(Material.WOOD).setHarvest("axe", 2).setHardness(50F).setUnlocalizedName("willowPlank");
		willowStairs = new BlockScapecraftStairs(willowPlank).setUnlocalizedName("willowStairs");
		willowSapling = new BlockScapecraftSapling(WorldGenWillowTree.class).setUnlocalizedName("willowSapling");
		willowLeaves = new BlockScapecraftLeaves(willowSapling).setUnlocalizedName("willowLeaves");
		mapleLog = new BlockScapecraftLog().setHarvest("axe", 2).setHardness(15.0F).setUnlocalizedName("mapleLog");
		maplePlank = new BlockScapecraft(Material.WOOD).setHarvest("axe", 2).setHardness(50F).setUnlocalizedName("maplePlank");
		mapleStairs = new BlockScapecraftStairs(maplePlank).setUnlocalizedName("mapleStairs");
		mapleSapling = new BlockScapecraftSapling(WorldGenMapleTree.class).setUnlocalizedName("mapleSapling");
		mapleLeaves = new BlockScapecraftLeaves(mapleSapling).setUnlocalizedName("mapleLeaves");
		yewLog = new BlockScapecraftLog().setHarvest("axe", 2).setHardness(20.0F).setUnlocalizedName("yewLog");
		yewPlank = new BlockScapecraft(Material.WOOD).setHarvest("axe", 2).setHardness(50F).setUnlocalizedName("yewPlank");
		yewStairs = new BlockScapecraftStairs(yewPlank).setUnlocalizedName("yewStairs");
		yewSapling = new BlockScapecraftSapling(WorldGenYewTree.class).setUnlocalizedName("yewSapling");
		yewLeaves = new BlockScapecraftLeaves(yewSapling).setUnlocalizedName("yewLeaves");
		magicLog = new BlockScapecraftLog().setHarvest("axe", 2).setHardness(50.0F).setUnlocalizedName("magicLog");
		magicPlank = new BlockScapecraft(Material.WOOD).setHarvest("axe", 2).setHardness(5.0F).setUnlocalizedName("magicPlank");
		magicStairs = new BlockScapecraftStairs(magicPlank).setUnlocalizedName("magicStairs");
		magicSapling = new BlockScapecraftSapling(WorldGenMagicTree.class).setUnlocalizedName("magicSapling");
		magicLeaves = new BlockScapecraftLeaves(magicSapling, ScapecraftItems.magicFruit).setUnlocalizedName("magicLeaves");

		whiteBlock = new BlockScapecraft(Material.GLASS).setHardness(40F).setResistance(5000F).setUnlocalizedName("whiteBlock");
		blackBlock = new BlockScapecraft(Material.GLASS).setHardness(40F).setResistance(5000F).setUnlocalizedName("blackBlock");
		hardIce = new BlockScapecraftTransparent(Material.ICE).setHardness(40F).setResistance(5000F).setUnlocalizedName("hardIce");
		invisibleLight = new BlockInvisibleLight();

		mobSpawner = new BlockSpawn();
		dungeonDoor = new BlockDungeonDoor();
		smeltingFurnace = new BlockSmeltingFurnace();
		smithingAnvil = new BlockSmithingAnvil();

		oakTreeSpawn = new BlockTreeSpawner(Blocks.LOG, 100, new WorldGenOakTree(true), 4);
		strongOakTreeSpawn = new BlockTreeSpawner(strongOakLog, 200, new WorldGenStrongOakTree(true), 38);
		willowTreeSpawn = new BlockTreeSpawner(willowLog, 400, new WorldGenWillowTree(true), 68);
		mapleTreeSpawn = new BlockTreeSpawner(mapleLog, 600, new WorldGenMapleTree(true), 100);
		yewTreeSpawn = new BlockTreeSpawner(yewLog, 1200, new WorldGenYewTree(true), 175);
		magicTreeSpawn = new BlockTreeSpawner(magicLog, 1800, new WorldGenMagicTree(true), 250);

		dungeonTele = new BlockDungeonTele();
		scapecraftPortal = new BlockScapecraftPortal();
		slab = new BlockScapecraftSlab(false);
		doubleSlab = new BlockScapecraftSlab(true);

		coffin.setRegistryName("coffin");
		blueCobble.setRegistryName("blueCobble");
		blueCobbleCompressed.setRegistryName("blueCobbleCompressed");
		tinOre.setRegistryName("tinOre");
		copperOre.setRegistryName("copperOre");
		bluriteOre.setRegistryName("bluriteOre");
		mithrilOre.setRegistryName("mithrilOre");
		adamantOre.setRegistryName("adamantOre");
		runeOre.setRegistryName("runeOre");
		bronzeBlock.setRegistryName("bronzeBlock");
		steelBlock.setRegistryName("steelBlock");
		mithrilBlock.setRegistryName("mithrilBlock");
		adamantBlock.setRegistryName("adamantBlock");
		runeBlock.setRegistryName("runeBlock");
		tinOreSpawn.setRegistryName("tinOreSpawn");
		copperOreSpawn.setRegistryName("copperOreSpawn");
		bluriteOreSpawn.setRegistryName("bluriteOreSpawn");
		mithrilOreSpawn.setRegistryName("mithrilOreSpawn");
		adamantOreSpawn.setRegistryName("adamantOreSpawn");
		runeOreSpawn.setRegistryName("runeOreSpawn");
		coalOreSpawn.setRegistryName("coalOreSpawn");
		diamondOreSpawn.setRegistryName("diamondOreSpawn");
		cobblestoneSpawn.setRegistryName("cobblestoneSpawn");
		redstoneOreSpawn.setRegistryName("redstoneOreSpawn");
		goldOreSpawn.setRegistryName("goldOreSpawn");
		emeraldOreSpawn.setRegistryName("emeraldOreSpawn");
		ironOreSpawn.setRegistryName("ironOreSpawn");
		sandstoneSpawn.setRegistryName("sandstoneSpawn");
		sandSpawn.setRegistryName("sandSpawn");
		dirtSpawn.setRegistryName("dirtSpawn");
		gravelSpawn.setRegistryName("gravelSpawn");
		blueCobbleSpawn.setRegistryName("blueCobbleSpawn");
		wheatSpawn.setRegistryName("wheatSpawn");
		carrotSpawn.setRegistryName("carrotSpawn");
		potatoSpawn.setRegistryName("potatoSpawn");
		cabbageSpawn.setRegistryName("cabbageSpawn");
		oakTreeSpawn.setRegistryName("oakTreeSpawn");
		strongOakTreeSpawn.setRegistryName("strongOakTreeSpawn");
		willowTreeSpawn.setRegistryName("willowTreeSpawn");
		mapleTreeSpawn.setRegistryName("mapleTreeSpawn");
		yewTreeSpawn.setRegistryName("yewTreeSpawn");
		magicTreeSpawn.setRegistryName("magicTreeSpawn");
		strongOakLog.setRegistryName("strongOakLog");
		strongOakPlank.setRegistryName("strongOakPlank");
		strongOakStairs.setRegistryName("strongOakStairs");
		strongOakSapling.setRegistryName("strongOakSapling");
		strongOakLeaves.setRegistryName("strongOakLeaves");
		willowLog.setRegistryName("willowLog");
		willowPlank.setRegistryName("willowPlank");
		willowStairs.setRegistryName("willowStairs");
		willowSapling.setRegistryName("willowSapling");
		willowLeaves.setRegistryName("willowLeaves");
		mapleLog.setRegistryName("mapleLog");
		maplePlank.setRegistryName("maplePlank");
		mapleStairs.setRegistryName("mapleStairs");
		mapleSapling.setRegistryName("mapleSapling");
		mapleLeaves.setRegistryName("mapleLeaves");
		yewLog.setRegistryName("yewLog");
		yewPlank.setRegistryName("yewPlank");
		yewStairs.setRegistryName("yewStairs");
		yewSapling.setRegistryName("yewSapling");
		yewLeaves.setRegistryName("yewLeaves");
		magicLog.setRegistryName("magicLog");
		magicPlank.setRegistryName("magicPlank");
		magicStairs.setRegistryName("magicStairs");
		magicSapling.setRegistryName("magicSapling");
		magicLeaves.setRegistryName("magicLeaves");
		slab.setRegistryName("slab");
		doubleSlab.setRegistryName("doubleSlab");
		whiteBlock.setRegistryName("whiteBlock");
		blackBlock.setRegistryName("blackBlock");
		hardIce.setRegistryName("hardIce");
		invisibleLight.setRegistryName("invisibleLight");
		dungeonTele.setRegistryName("dungeonTele");
		scapecraftPortal.setRegistryName("scapecraftPortal");
		cabbage.setRegistryName("cabbage");
		mobSpawner.setRegistryName("mobSpawner");
		dungeonDoor.setRegistryName("dungeonDoor");
		smeltingFurnace.setRegistryName("smeltingFurnace");
		smithingAnvil.setRegistryName("smithingAnvil");

		registerWithItem(coffin);

		registerWithItem(blueCobble);
		registerWithItem(blueCobbleCompressed);

		registerWithItem(tinOre);
		registerWithItem(copperOre);
		registerWithItem(bluriteOre);
		registerWithItem(mithrilOre);
		registerWithItem(adamantOre);
		registerWithItem(runeOre);

		registerWithItem(bronzeBlock);
		registerWithItem(steelBlock);
		registerWithItem(mithrilBlock);
		registerWithItem(adamantBlock);
		registerWithItem(runeBlock);

		GameRegistry.register(tinOreSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(tinOreSpawn));
		GameRegistry.register(copperOreSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(copperOreSpawn));
		GameRegistry.register(bluriteOreSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(bluriteOreSpawn));
		GameRegistry.register(mithrilOreSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(mithrilOreSpawn));
		GameRegistry.register(adamantOreSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(adamantOreSpawn));
		GameRegistry.register(runeOreSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(runeOreSpawn));
		GameRegistry.register(coalOreSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(coalOreSpawn));
		GameRegistry.register(diamondOreSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(diamondOreSpawn));
		GameRegistry.register(cobblestoneSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(cobblestoneSpawn));
		GameRegistry.register(redstoneOreSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(redstoneOreSpawn));
		GameRegistry.register(goldOreSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(goldOreSpawn));
		GameRegistry.register(emeraldOreSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(emeraldOreSpawn));
		GameRegistry.register(ironOreSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(ironOreSpawn));
		GameRegistry.register(sandstoneSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(sandstoneSpawn));
		GameRegistry.register(sandSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(sandSpawn));
		GameRegistry.register(dirtSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(dirtSpawn));
		GameRegistry.register(gravelSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(gravelSpawn));
		GameRegistry.register(blueCobbleSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(blueCobbleSpawn));
		GameRegistry.register(wheatSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(wheatSpawn));
		GameRegistry.register(carrotSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(carrotSpawn));
		GameRegistry.register(potatoSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(potatoSpawn));

		GameRegistry.register(oakTreeSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(oakTreeSpawn));
		GameRegistry.register(strongOakTreeSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(strongOakTreeSpawn));
		GameRegistry.register(willowTreeSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(willowTreeSpawn));
		GameRegistry.register(mapleTreeSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(mapleTreeSpawn));
		GameRegistry.register(yewTreeSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(yewTreeSpawn));
		GameRegistry.register(magicTreeSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(magicTreeSpawn));

		GameRegistry.register(cabbageSpawn);
		GameRegistry.register(new ItemBlockBlockSpawner(cabbageSpawn));

		GameRegistry.register(cabbage);

		for(Map.Entry<String, Block> entry : levelWalls.entrySet())
		{
			GameRegistry.register(entry.getValue(), new ResourceLocation(entry.getKey()));
			Item.getItemFromBlock(entry.getValue()).setHasSubtypes(true);
		}

		registerWithItem(strongOakLog);
		registerWithItem(strongOakPlank);
		registerWithItem(strongOakStairs);
		registerWithItem(strongOakSapling);
		registerWithItem(strongOakLeaves);
		registerWithItem(willowLog);
		registerWithItem(willowPlank);
		registerWithItem(willowStairs);
		registerWithItem(willowSapling);
		registerWithItem(willowLeaves);
		registerWithItem(mapleLog);
		registerWithItem(maplePlank);
		registerWithItem(mapleStairs);
		registerWithItem(mapleSapling);
		registerWithItem(mapleLeaves);
		registerWithItem(yewLog);
		registerWithItem(yewPlank);
		registerWithItem(yewStairs);
		registerWithItem(yewSapling);
		registerWithItem(yewLeaves);
		registerWithItem(magicLog);
		registerWithItem(magicPlank);
		registerWithItem(magicStairs);
		registerWithItem(magicSapling);
		registerWithItem(magicLeaves);
		GameRegistry.register(slab);
		GameRegistry.register(doubleSlab);
		GameRegistry.register(new ItemScapecraftSlab(slab, slab, doubleSlab, false).setRegistryName(slab.getRegistryName()));
		GameRegistry.register(new ItemScapecraftSlab(doubleSlab, slab, doubleSlab, true).setRegistryName(doubleSlab.getRegistryName()));

		registerWithItem(whiteBlock);
		registerWithItem(blackBlock);
		registerWithItem(hardIce);
		registerWithItem(invisibleLight);

		registerWithItem(mobSpawner);
		registerWithItem(dungeonDoor);
		registerWithItem(smeltingFurnace);
		registerWithItem(smithingAnvil);

		registerWithItem(dungeonTele);
		registerWithItem(scapecraftPortal);

		GameRegistry.registerTileEntity(TileEntityBlockSpawner.class, "blockSpawner");
		GameRegistry.registerTileEntity(TileEntityTreeSpawner.class, "treeSpawner");
		GameRegistry.registerTileEntity(TileEntityScapecraftMobSpawner.class, "scapecraftMobSpawner");
		GameRegistry.registerTileEntity(TileEntityStall.class, "stall");
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
			Block block = Block.REGISTRY.getObject(new ResourceLocation(tag.getString("string")));
			blockLevels.put(block, tag.getInteger("number"));
		}
	}

	public static void registerWithItem(Block block)
	{
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
}
