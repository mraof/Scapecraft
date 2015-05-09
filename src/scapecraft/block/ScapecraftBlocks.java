package scapecraft.block;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import scapecraft.item.ScapecraftItems;
import scapecraft.tileentity.TileEntityBlockSpawner;
import scapecraft.tileentity.TileEntityDungeonDoor;
import scapecraft.tileentity.TileEntityFire;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;
import scapecraft.tileentity.TileEntityStall;
import scapecraft.world.gen.feature.WorldGenMagicTree;
import scapecraft.world.gen.feature.WorldGenMapleTree;
import scapecraft.world.gen.feature.WorldGenOakTree;
import scapecraft.world.gen.feature.WorldGenStrongOakTree;
import scapecraft.world.gen.feature.WorldGenWillowTree;
import scapecraft.world.gen.feature.WorldGenYewTree;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

public class ScapecraftBlocks
{
	public static HashMap<Block, Integer> blockLevels;

	public static Block coffin;

	public static Block blueCobble;
	public static Block blueCobbleCompressed;

	public static Block tinOre;
	public static Block copperOre;
	public static Block bluriteOre;
	public static Block mithOre;
	public static Block addyOre;
	public static Block runeOre;

	public static Block bronzeBlock;
	public static Block mithBlock;
	public static Block addyBlock;
	public static Block runeBlock;
	
	public static Block tinOreSpawn;
	public static Block copperOreSpawn;
	public static Block bluriteOreSpawn;
	public static Block mithOreSpawn;
	public static Block addyOreSpawn;
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

	public static Block miningLevelWall;
	public static Block agilityLevelWall;
	public static Block combatLevelWall;

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

	public static Block serverNotice;
	public static Block whiteBlock;
	public static Block blackBlock;
	public static Block hardIce;
	public static Block invisibleLight;
	public static Block dungeonTele;

	public static Block cabbage;

	public static Block stall;
	public static Block mobSpawner;
	public static Block scapecraftFire;
	public static Block dungeonDoor;

	public static void registerBlocks()
	{
		coffin = new BlockCoffin();

		cabbage = new BlockCabbage().setTextureName("scapecraft:cabbage").setUnlocalizedName("cabbage");

		blueCobble = new BlockScapecraft(Material.rock).setTextureName("scapecraft:BlueCobblestone").setUnlocalizedName("blueCobble").setHardness(1.0F);
		blueCobbleCompressed = new BlockScapecraft(Material.rock).setTextureName("scapecraft:BlueCobblestonec").setUnlocalizedName("blueCobbleCompressed");

		tinOre = new BlockScapecraft(Material.rock).setHarvest("pickaxe", 0).setTextureName("scapecraft:TinOre").setHardness(10.0F).setResistance(5.0F).setUnlocalizedName("tinOre");
		copperOre = new BlockScapecraft(Material.rock).setHarvest("pickaxe", 0).setTextureName("scapecraft:CopperOre").setHardness(10.0F).setResistance(5.0F).setUnlocalizedName("copperOre");
		bluriteOre = new BlockScapecraft(Material.rock).setHarvest("pickaxe", 0).setTextureName("scapecraft:BluriteOre").setHardness(10.0F).setResistance(5.0F).setUnlocalizedName("bluriteOre");
		mithOre = new BlockScapecraft(Material.rock).setHarvest("pickaxe", 1).setTextureName("scapecraft:MithOre").setHardness(30.0F).setResistance(5.0F).setUnlocalizedName("mithOre");
		addyOre = new BlockScapecraft(Material.rock).setHarvest("pickaxe", 2).setTextureName("scapecraft:AddyOre").setHardness(60.0F).setResistance(5.0F).setUnlocalizedName("addyOre");
		runeOre = new BlockScapecraft(Material.rock).setHarvest("pickaxe", 2).setTextureName("scapecraft:RuneOre").setHardness(80.0F).setResistance(50.0F).setUnlocalizedName("runeOre");
		bronzeBlock = new BlockScapecraft(Material.rock).setBeaconBase(true).setTextureName("scapecraft:BronzeBlock").setHardness(10.0F).setResistance(2.0F).setUnlocalizedName("bronzeBlock");
		mithBlock = new BlockScapecraft(Material.rock).setBeaconBase(true).setTextureName("scapecraft:MithrilBlock").setHardness(30.0F).setResistance(5.0F).setUnlocalizedName("mithBlock");
		addyBlock = new BlockScapecraft(Material.rock).setBeaconBase(true).setTextureName("scapecraft:AdamantBlock").setHardness(60.0F).setResistance(25.0F).setUnlocalizedName("addyBlock");
		runeBlock = new BlockScapecraft(Material.rock).setBeaconBase(true).setTextureName("scapecraft:RuneBlock").setHardness(80.0F).setResistance(50.0F).setUnlocalizedName("runeBlock");

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
		mithOreSpawn = new BlockBlockSpawner(mithOre, 1200, 160);
		addyOreSpawn = new BlockBlockSpawner(addyOre, 2400, 180);
		runeOreSpawn = new BlockBlockSpawner(runeOre, 3600, 250);
		sandstoneSpawn = new BlockBlockSpawner(Blocks.sandstone, 3);
		sandSpawn = new BlockBlockSpawner(Blocks.sand, 2);
		dirtSpawn = new BlockBlockSpawner(Blocks.dirt, 2);
		gravelSpawn = new BlockBlockSpawner(Blocks.gravel, 20);
		blueCobbleSpawn = new BlockBlockSpawner(blueCobble, 10800);
		gravelSpawn = new BlockBlockSpawner(Blocks.gravel, 20);
		wheatSpawn = new BlockBlockSpawner(Blocks.wheat, 1800, 0);
		carrotSpawn = new BlockBlockSpawner(Blocks.carrots, 1800, 0);
		potatoSpawn = new BlockBlockSpawner(Blocks.potatoes, 1800, 0);

		cabbageSpawn = new BlockBlockSpawner(cabbage, 60);


		miningLevelWall = new BlockStatWall("miningLevel").setTextureName("scapecraft:MiningWall");
		agilityLevelWall = new BlockStatWall("agilityLevel").setTextureName("scapecraft:AgilityWall");
		combatLevelWall = new BlockStatWall("combatLevel").setTextureName("scapecraft:CombatWall");

		agilityBlock = new BlockAgility(3);
		agilityBlock2 = new BlockAgility(16);
		agilityBlock3 = new BlockAgility(70);

		kosTele = new BlockRedstoneCost(new ItemStack(Items.gold_ingot)).setUnlocalizedName("KosTele").setTextureName("minecraft:endframe_top");
		woolGate = new BlockRedstoneCost(new ItemStack(Blocks.wool, 20)).setUnlocalizedName("woolGate").setTextureName("minecraft:wool_colored_white");

		keyBlock = new BlockLock(ScapecraftItems.tombKey).setUnlocalizedName("barrowsLock");
		keyBlock2 = new BlockLock(ScapecraftItems.doorKey).setUnlocalizedName("fortressLock");

		strongOakLog = new BlockScapecraftLog().setHarvest("axe", 2).setTextureName("scapecraft:StrongOakLog").setHardness(20.0F).setUnlocalizedName("strongOakLog");
		strongOakPlank = new BlockScapecraft(Material.wood).setHarvest("axe", 2).setTextureName("scapecraft:StrongOakPlank").setHardness(50F).setUnlocalizedName("strongOakPlank");
		strongOakStairs = new BlockScapecraftStairs(strongOakPlank).setUnlocalizedName("strongOakStairs");
		strongOakSapling = new BlockScapecraftSapling(WorldGenStrongOakTree.class).setTextureName("scapecraft:StrongOakSapling").setUnlocalizedName("strongOakSapling");
		strongOakLeaves = new BlockScapecraftLeaves(strongOakSapling).setTextureName("scapecraft:StrongOakLeaves").setUnlocalizedName("strongOakLeaves");
		willowLog = new BlockScapecraftLog().setHarvest("axe", 2).setTextureName("scapecraft:WillowLog").setHardness(20.0F).setUnlocalizedName("willowLog");
		willowPlank = new BlockScapecraft(Material.wood).setHarvest("axe", 2).setTextureName("scapecraft:WillowPlank").setHardness(50F).setUnlocalizedName("willowPlank");
		willowStairs = new BlockScapecraftStairs(willowPlank).setUnlocalizedName("willowStairs");
		willowSapling = new BlockScapecraftSapling(WorldGenWillowTree.class).setTextureName("scapecraft:WillowSapling").setUnlocalizedName("willowSapling");
		willowLeaves = new BlockScapecraftLeaves(willowSapling).setTextureName("scapecraft:WillowLeaves").setUnlocalizedName("willowLeaves");
		mapleLog = new BlockScapecraftLog().setHarvest("axe", 2).setTextureName("scapecraft:MapleLog").setHardness(15.0F).setUnlocalizedName("mapleLog");
		maplePlank = new BlockScapecraft(Material.wood).setHarvest("axe", 2).setTextureName("scapecraft:MaplePlank").setHardness(50F).setUnlocalizedName("maplePlank");
		mapleStairs = new BlockScapecraftStairs(maplePlank).setUnlocalizedName("mapleStairs");
		mapleSapling = new BlockScapecraftSapling(WorldGenMapleTree.class).setTextureName("scapecraft:MapleSapling").setUnlocalizedName("mapleSapling");
		mapleLeaves = new BlockScapecraftLeaves(mapleSapling).setTextureName("scapecraft:MapleLeaves").setUnlocalizedName("mapleLeaves");
		yewLog = new BlockScapecraftLog().setHarvest("axe", 2).setTextureName("scapecraft:YewLog").setHardness(20.0F).setUnlocalizedName("yewLog");
		yewPlank = new BlockScapecraft(Material.wood).setHarvest("axe", 2).setTextureName("scapecraft:YewPlank").setHardness(50F).setUnlocalizedName("yewPlank");
		yewStairs = new BlockScapecraftStairs(yewPlank).setUnlocalizedName("yewStairs");
		yewSapling = new BlockScapecraftSapling(WorldGenYewTree.class).setTextureName("scapecraft:YewSapling").setUnlocalizedName("yewSapling");
		yewLeaves = new BlockScapecraftLeaves(yewSapling).setTextureName("scapecraft:YewLeaves").setUnlocalizedName("yewLeaves");
		magicLog = new BlockScapecraftLog().setHarvest("axe", 2).setTextureName("scapecraft:MagicLog").setHardness(50.0F).setUnlocalizedName("magicLog");
		magicPlank = new BlockScapecraft(Material.wood).setHarvest("axe", 2).setTextureName("scapecraft:MagicPlank").setHardness(5.0F).setUnlocalizedName("magicPlank");
		magicStairs = new BlockScapecraftStairs(magicPlank).setUnlocalizedName("magicStairs");
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

		oakTreeSpawn = new BlockTreeSpawner(Blocks.log, 100, new WorldGenOakTree(true), 25);
		strongOakTreeSpawn = new BlockTreeSpawner(strongOakLog, 200, new WorldGenStrongOakTree(true), 38);
		willowTreeSpawn = new BlockTreeSpawner(willowLog, 400, new WorldGenYewTree(true), 68);
		mapleTreeSpawn = new BlockTreeSpawner(mapleLog, 600, new WorldGenMapleTree(true), 100);
		yewTreeSpawn = new BlockTreeSpawner(yewLog, 1200, new WorldGenYewTree(true), 175);
		magicTreeSpawn = new BlockTreeSpawner(magicLog, 1800, new WorldGenMagicTree(true), 250);

		unbreakableAnvil = new BlockUnbreakableAnvil();
		dungeonTele = new BlockDungeonTele();

		GameRegistry.registerBlock(coffin, "coffin");

		GameRegistry.registerBlock(blueCobble, "blueCobble");
		GameRegistry.registerBlock(blueCobbleCompressed, "blueCobbleCompressed");

		GameRegistry.registerBlock(tinOre, "tinOre");
		GameRegistry.registerBlock(copperOre, "copperOre");
		GameRegistry.registerBlock(bluriteOre, "bluriteOre");
		GameRegistry.registerBlock(mithOre, "mithOre");
		GameRegistry.registerBlock(addyOre, "addyOre");
		GameRegistry.registerBlock(runeOre, "runeOre");

		GameRegistry.registerBlock(bronzeBlock, "bronzeBlock");
		GameRegistry.registerBlock(mithBlock, "mithBlock");
		GameRegistry.registerBlock(addyBlock, "addyBlock");
		GameRegistry.registerBlock(runeBlock, "runeBlock");

		GameRegistry.registerBlock(tinOreSpawn, "tinOreSpawn");
		GameRegistry.registerBlock(copperOreSpawn, "copperOreSpawn");
		GameRegistry.registerBlock(bluriteOreSpawn, "bluriteOreSpawn");
		GameRegistry.registerBlock(mithOreSpawn, "mithOreSpawn");
		GameRegistry.registerBlock(addyOreSpawn, "addyOreSpawn");
		GameRegistry.registerBlock(runeOreSpawn, "runeOreSpawn");
		GameRegistry.registerBlock(coalOreSpawn, "coalOreSpawn");
		GameRegistry.registerBlock(diamondOreSpawn, "diamondOreSpawn");
		GameRegistry.registerBlock(cobblestoneSpawn, "cobblestoneSpawn");
		GameRegistry.registerBlock(redstoneOreSpawn, "redstoneOreSpawn");
		GameRegistry.registerBlock(goldOreSpawn, "goldOreSpawn");
		GameRegistry.registerBlock(emeraldOreSpawn, "emeraldOreSpawn");
		GameRegistry.registerBlock(ironOreSpawn, "ironOreSpawn");
		GameRegistry.registerBlock(sandstoneSpawn, "sandstoneSpawn");
		GameRegistry.registerBlock(sandSpawn, "sandSpawn");
		GameRegistry.registerBlock(dirtSpawn, "dirtSpawn");
		GameRegistry.registerBlock(gravelSpawn, "gravelSpawn");
		GameRegistry.registerBlock(blueCobbleSpawn, "blueCobbleSpawn");
		GameRegistry.registerBlock(wheatSpawn, "wheatSpawn");
		GameRegistry.registerBlock(carrotSpawn, "carrotSpawn");
		GameRegistry.registerBlock(potatoSpawn, "potatoSpawn");

		GameRegistry.registerBlock(oakTreeSpawn, "oakTreeSpawn");
		GameRegistry.registerBlock(strongOakTreeSpawn, "strongOakTreeSpawn");
		GameRegistry.registerBlock(willowTreeSpawn, "willowTreeSpawn");
		GameRegistry.registerBlock(mapleTreeSpawn, "mapleTreeSpawn");
		GameRegistry.registerBlock(yewTreeSpawn, "yewTreeSpawn");
		GameRegistry.registerBlock(magicTreeSpawn, "magicTreeSpawn");

		GameRegistry.registerBlock(unbreakableAnvil, "unbreakableAnvil");

		GameRegistry.registerBlock(cabbage, "cabbage");
		GameRegistry.registerBlock(cabbageSpawn, "cabbageSpawn");

		GameRegistry.registerBlock(miningLevelWall, "miningLevelWall");
		GameRegistry.registerBlock(agilityLevelWall, "agilityLevelWall");
		GameRegistry.registerBlock(combatLevelWall, "combatLevelWall");

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

		GameRegistry.registerBlock(serverNotice, "serverNotice");
		GameRegistry.registerBlock(whiteBlock, "whiteBlock");
		GameRegistry.registerBlock(blackBlock, "blackBlock");
		GameRegistry.registerBlock(hardIce, "hardIce");
		GameRegistry.registerBlock(invisibleLight, "invisibleLight");

		GameRegistry.registerBlock(stall, "stall");
		GameRegistry.registerBlock(mobSpawner, "mobSpawner");
		GameRegistry.registerBlock(scapecraftFire, "scapecraftFire");
		if(true)
		{
		GameRegistry.registerBlock(dungeonDoor, "dungeonDoor");

		GameRegistry.registerBlock(dungeonTele, "dungeonTele");
		}

		Item.getItemFromBlock(addyOreSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(mithOreSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(runeOreSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(coalOreSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(diamondOreSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(cobblestoneSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(redstoneOreSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(goldOreSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(emeraldOreSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(ironOreSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(sandstoneSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(sandSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(dirtSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(gravelSpawn).setHasSubtypes(true);
		Item.getItemFromBlock(blueCobbleSpawn).setHasSubtypes(true);

		Item.getItemFromBlock(miningLevelWall).setHasSubtypes(true);
		Item.getItemFromBlock(agilityLevelWall).setHasSubtypes(true);
		Item.getItemFromBlock(combatLevelWall).setHasSubtypes(true);

		GameRegistry.registerTileEntity(TileEntityBlockSpawner.class, "blockSpawner");
		GameRegistry.registerTileEntity(TileEntityScapecraftMobSpawner.class, "scapecraftMobSpawner");
		GameRegistry.registerTileEntity(TileEntityStall.class, "stall");
		GameRegistry.registerTileEntity(TileEntityFire.class, "scapecraftFire");
		GameRegistry.registerTileEntity(TileEntityDungeonDoor.class, "dungeonDoor");
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
