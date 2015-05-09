package scapecraft.entity;

import static scapecraft.entity.EntityScapecraft.addDrop;
import static scapecraft.entity.EntityScapecraft.setMoney;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import scapecraft.Scapecraft;
import scapecraft.block.ScapecraftBlocks;
import scapecraft.item.ScapecraftItems;
import scapecraft.util.CombatXpHelper;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ScapecraftEntities
{
	private static int currentEntityIdOffset = 0;

	public static HashMap<String, Class<? extends Entity>> entityNames = new HashMap<String, Class<? extends Entity>>();
	public static ArrayList<String> entities = new ArrayList<String>();
	public static ArrayList<Entity> entityObjects = new ArrayList<Entity>();


	public static void registerEntities()
	{
		registerEntity(EntityAbbyDemon.class, "AbbyDemon");
		registerEntity(EntityAhrim.class, "Ahrim");
		registerEntity(EntityAkrisae.class, "Akrisae");
		registerEntity(EntityBandit.class, "Bandit");
		registerEntity(EntityBarbarian.class, "Barbarian");
		registerEntity(EntityBlackDemon.class, "BlackDemon");
		registerEntity(EntityBlackDragon.class, "BlackDragon");
		registerEntity(EntityBlackGuard2.class, "BlackGuard2");
		registerEntity(EntityBlackGuard.class, "BlackGuard");
		registerEntity(EntityBlackKnight.class, "BlackKnight");
		registerEntity(EntityBot2.class, "Bot2");
		registerEntity(EntityBot3.class, "Bot3");
		registerEntity(EntityBot.class, "Bot");
		registerEntity(EntityCaveCrawler.class, "CaveCrawler");
		registerEntity(EntityCook.class, "Cook");
		registerEntity(EntityDarkwizard.class, "Darkwizard");
		registerEntity(EntityDharok.class, "Dharok");
		registerEntity(EntityDoctor.class, "Doctor");
		registerEntity(EntityDwarf.class, "Dwarf");
		registerEntity(EntityEliteBlackKnight.class, "EliteBlackKnight");
		registerEntity(EntityFarmer.class, "Farmer");
		registerEntity(EntityFireGiant.class, "FireGiant");
		registerEntity(EntityFremGuard.class, "FremGuard");
		registerEntity(EntityGeneralGraardor.class, "GeneralGraardor");
		registerEntity(EntityGhost.class, "Ghost");
		registerEntity(EntityGoblin.class, "Goblin");
		registerEntity(EntityGreenDragon.class, "GreenDragon");
		registerEntity(EntityGuard.class, "Guard");
		registerEntity(EntityGuthan.class, "Guthan");
		registerEntity(EntityHellhound.class, "Hellhound");
		registerEntity(EntityHeroKnight.class, "HeroKnight");
		registerEntity(EntityHighMage.class, "HighMage");
		registerEntity(EntityHillGiant.class, "HillGiant");
		registerEntity(EntityIceGiant.class, "IceGiant");
		registerEntity(EntityIronDragon.class, "IronDragon");
		registerEntity(EntityKaril.class, "Karil");
		registerEntity(EntityKing.class, "King");
		registerEntity(EntityKingsGuard.class, "KingsGuard");
		registerEntity(EntityKK.class, "KK");
		registerEntity(EntityKKspawn.class, "KKspawn");
		registerEntity(EntityKos1.class, "Kos1");
		registerEntity(EntityKos2.class, "Kos2");
		registerEntity(EntityKos3.class, "Kos3");
		registerEntity(EntityKos4.class, "Kos4");
		registerEntity(EntityKQ2.class, "KQ2");
		registerEntity(EntityKQ.class, "KQ");
		registerEntity(EntityLavaBlock.class, "LavaBlock");
		registerEntity(EntityLesserDemon2.class, "LesserDemon2");
		registerEntity(EntityLesserDemon.class, "LesserDemon");
		registerEntity(EntityLootChest.class, "LootChest");
		registerEntity(EntityMan.class, "Man");
		registerEntity(EntityMorgan.class, "Morgan");
		registerEntity(EntityMossGiant.class, "MossGiant");
		registerEntity(EntityMugger.class, "Mugger");
		registerEntity(EntityRat.class, "Rat");
		registerEntity(EntityRatSmall.class, "RatSmall");
		registerEntity(EntityScorpion.class, "Scorpion");
		registerEntity(EntitySergeantGrimspike.class, "SergeantGrimspike");
		registerEntity(EntitySergeantSteelwill.class, "SergeantSteelwill");
		registerEntity(EntitySergeantStrongstack.class, "SergeantStrongstack");
		registerEntity(EntityShopKeeper.class, "ShopKeeper");
		registerEntity(EntityTD.class, "TD");
		registerEntity(EntityTheif.class, "Theif");
		registerEntity(EntityTorag.class, "Torag");
		registerEntity(EntityVampire.class, "Vampire");
		registerEntity(EntityVarze.class, "Varze");
		registerEntity(EntityVerac.class, "Verac");
		registerEntity(EntityWhiteKnight.class, "WhiteKnight");
		registerEntity(EntityWizard.class, "Wizard");
		registerEntity(EntityZilyana.class, "Zilyana");
		registerEntity(EntityZaklnGritch.class, "ZaklnGritch");
		registerEntity(EntityTstanonKarlak.class, "TstanonKarlak");
		registerEntity(EntityKrilTsutsaroth.class, "KrilTsutsaroth");
		registerEntity(EntityBalfrugKreeyath.class, "BalfrugKreeyath");
		registerEntity(EntityKreearra.class, "Kreearra");
		registerEntity(EntityGenericBiped.class, "GenericBiped");
		registerEntity(EntityShapeshifter.class, "Shapeshifter");
		registerEntity(EntityShopshifter.class, "Shopshifter");
		registerEntity(EntityKey.class, "Key");
		CombatXpHelper.addVanilla();
	}

	public static void registerEntity(Class<? extends Entity> entityClass, String name)
	{
		EntityRegistry.registerModEntity(entityClass, name, currentEntityIdOffset, Scapecraft.instance, 80, 3, true);
		entityNames.put(name.toLowerCase(), entityClass);
		if(EntityScapecraft.class.isAssignableFrom(entityClass))
		{
			entities.add(name);
			try
			{
				entityObjects.add(entityClass.getConstructor(new Class[] { World.class }).newInstance(new Object[] { null }));
			} catch(Exception e) {e.printStackTrace(); };
		}

		currentEntityIdOffset++;
	}

	public static void addDrops()
	{
		//Use this format for addding drops
		//addDrop((Entity.class), (drop chance), new ItemStack(name of item/block), (how many are dropped at once)));

		//for example we wanted a mob called "Bob" to drop 1 iron ingot, 2 adamant ore, 1 bronze sword, and 1 dirt block all with a drop rate of 1/1
		//addDrop(EntityBob.class, 1, new ItemStack(Items.iron_ingot));
		//addDrop(EntityBob.class, 1, new ItemStack(ScapecraftBlocks.addyOre, 2));
		//addDrop(EntityBob.class, 1, new ItemStack(ScapecraftItems.bronzeSword));
		//addDrop(EntityBob.class, 1, new ItemStack(Blocks.dirt));



		//addDrop(EntityAbbyDemon.class, 800, new ItemStack(ScapecraftItems.whip));
		//addDrop(EntityAbbyDemon.class, 30, new ItemStack(ScapecraftItems.runeHelmet));
		//addDrop(EntityAbbyDemon.class, 30, new ItemStack(ScapecraftItems.addyAxe));
		//addDrop(EntityAbbyDemon.class, 35, new ItemStack(ScapecraftBlocks.addyOre, 2));
		//addDrop(EntityAbbyDemon.class, 45, new ItemStack(ScapecraftBlocks.magicLog, 6));
		//addDrop(EntityAbbyDemon.class, 45, new ItemStack(ScapecraftBlocks.runeOre));

		//addDrop(EntityAhrim.class, 1, new ItemStack(ScapecraftItems.ahrimKey));
		//addDrop(EntityAhrim.class, 300, new ItemStack(ScapecraftItems.ahrimBoots));
		//addDrop(EntityAhrim.class, 300, new ItemStack(ScapecraftItems.ahrimChestplate));
		//addDrop(EntityAhrim.class, 300, new ItemStack(ScapecraftItems.ahrimHelmet));
		//addDrop(EntityAhrim.class, 300, new ItemStack(ScapecraftItems.ahrimLeggings));
		//addDrop(EntityAhrim.class, 400, new ItemStack(ScapecraftItems.ahrimStaff));

		//addDrop(EntityAkrisae.class, 1, new ItemStack(ScapecraftItems.akrisaeKey));
		//addDrop(EntityAkrisae.class, 300, new ItemStack(ScapecraftItems.akrisaeBoots));
		//addDrop(EntityAkrisae.class, 300, new ItemStack(ScapecraftItems.akrisaeChestplate));
		//addDrop(EntityAkrisae.class, 300, new ItemStack(ScapecraftItems.akrisaeHelmet));
		//addDrop(EntityAkrisae.class, 300, new ItemStack(ScapecraftItems.akrisaeLeggings));
		//addDrop(EntityAkrisae.class, 400, new ItemStack(ScapecraftItems.akrisaeMace));

		//bandit leader (low level boss)
		addDrop(EntityBandit.class, 8, new ItemStack(ScapecraftItems.blackSword));
		addDrop(EntityBandit.class, 1, new ItemStack(ScapecraftItems.fishPie, 3));
		addDrop(EntityBandit.class, 2, new ItemStack(Blocks.coal_block, 1));
		addDrop(EntityBandit.class, 5, new ItemStack(ScapecraftItems.mithIngot));
		addDrop(EntityBandit.class, 10, new ItemStack(ScapecraftItems.addySword));
		addDrop(EntityBandit.class, 20, new ItemStack(ScapecraftItems.runeSword));
		addDrop(EntityBandit.class, 25, new ItemStack(ScapecraftItems.addyChestplate));
		addDrop(EntityBandit.class, 5, new ItemStack(ScapecraftItems.runeIngot, 1));

		addDrop(EntityBarbarian.class, 20, new ItemStack(Items.iron_sword));
		addDrop(EntityBarbarian.class, 15, new ItemStack(Items.arrow, 16));
		addDrop(EntityBarbarian.class, 6, new ItemStack(Blocks.iron_ore));
		addDrop(EntityBarbarian.class, 2, new ItemStack(ScapecraftItems.beer));
		addDrop(EntityBarbarian.class, 4, new ItemStack(Items.cooked_beef));
		addDrop(EntityBarbarian.class, 20, new ItemStack(Items.iron_chestplate));

		//addDrop(EntityBlackDemon.class, 15, new ItemStack(ScapecraftBlocks.addyIngot));
		//addDrop(EntityBlackDemon.class, 2000, new ItemStack(ScapecraftItems.chaoticMaul));
		//addDrop(EntityBlackDemon.class, 2000, new ItemStack(ScapecraftItems.chaoticRapier));
		//addDrop(EntityBlackDemon.class, 40, new ItemStack(ScapecraftItems.blackHalberd));
		//addDrop(EntityBlackDemon.class, 25, new ItemStack(ScapecraftItems.blackChestplate));
		//addDrop(EntityBlackDemon.class, 25, new ItemStack(ScapecraftItems.blackSword));
		//addDrop(EntityBlackDemon.class, 40, new ItemStack(ScapecraftItems.runeHelmet));
		//addDrop(EntityBlackDemon.class, 750, new ItemStack(ScapecraftItems.DBA));
		//addDrop(EntityBlackDemon.class, 70, new ItemStack(ScapecraftItems.runeChestplate));

		//addDrop(EntityBlackDragon.class, 1, new ItemStack(ScapecraftItems.blackDHide));
		//addDrop(EntityBlackDragon.class, 40, new ItemStack(ScapecraftItems.runeSword));
		//addDrop(EntityBlackDragon.class, 30, new ItemStack(ScapecraftBlocks.addyOre, 3));
		//addDrop(EntityBlackDragon.class, 500, new ItemStack(ScapecraftItems.dragonScimmy));
		//addDrop(EntityBlackDragon.class, 40, new ItemStack(ScapecraftItems.addyChestplate));
		//addDrop(EntityBlackDragon.class, 25, new ItemStack(ScapecraftItems.mithAxe));
		//addDrop(EntityBlackDragon.class, 40, new ItemStack(Items.arrow, 32));

		addDrop(EntityBlackGuard.class, 50, new ItemStack(ScapecraftItems.blackHalberd));
		addDrop(EntityBlackGuard.class, 30, new ItemStack(ScapecraftItems.blackBoots));
		addDrop(EntityBlackGuard.class, 30, new ItemStack(ScapecraftItems.blackSword));
		addDrop(EntityBlackGuard.class, 30, new ItemStack(ScapecraftItems.blackChestplate));
		addDrop(EntityBlackGuard.class, 30, new ItemStack(ScapecraftItems.blackLeggings));
		addDrop(EntityBlackGuard.class, 30, new ItemStack(ScapecraftItems.blackHelmet));

		//black guard for black knights fortress quest
		//addDrop(EntityBlackGuard2.class, 1, new ItemStack(ScapecraftItems.doorKey, 2));
		//addDrop(EntityBlackGuard2.class, 50, new ItemStack(ScapecraftItems.blackHalberd));
		//addDrop(EntityBlackGuard2.class, 30, new ItemStack(ScapecraftItems.blackBoots));
		//addDrop(EntityBlackGuard2.class, 30, new ItemStack(ScapecraftItems.blackSword));
		//addDrop(EntityBlackGuard2.class, 30, new ItemStack(ScapecraftItems.blackChestplate));
		//addDrop(EntityBlackGuard2.class, 30, new ItemStack(ScapecraftItems.blackLeggings));
		//addDrop(EntityBlackGuard2.class, 30, new ItemStack(ScapecraftItems.blackHelmet));

		//Black Knight
		addDrop(EntityBlackKnight.class, 60, new ItemStack(ScapecraftItems.blackBoots));
		addDrop(EntityBlackKnight.class, 60, new ItemStack(ScapecraftItems.blackHelmet));
		addDrop(EntityBlackKnight.class, 60, new ItemStack(ScapecraftItems.blackSword));
		addDrop(EntityBlackKnight.class, 60, new ItemStack(ScapecraftItems.blackChestplate));
		addDrop(EntityBlackKnight.class, 60, new ItemStack(ScapecraftItems.blackLeggings));
		addDrop(EntityBlackKnight.class, 25, new ItemStack(Items.iron_sword));
		addDrop(EntityBlackKnight.class, 25, new ItemStack(Items.iron_helmet));
		addDrop(EntityBlackKnight.class, 10, new ItemStack(Items.arrow, 8));
		addDrop(EntityBlackKnight.class, 5, new ItemStack(Items.iron_ingot));
		addDrop(EntityBlackKnight.class, 1, new ItemStack(Items.bread, 2));

		//yew tree bot
		addDrop(EntityBot.class, 100, new ItemStack(ScapecraftBlocks.yewSapling));
		addDrop(EntityBot.class, 15, new ItemStack(Items.wooden_axe));

		//magic tree bot
		addDrop(EntityBot2.class, 15, new ItemStack(Items.stone_axe));
		addDrop(EntityBot2.class, 100, new ItemStack(ScapecraftBlocks.magicSapling));

		//green dragon bot
		addDrop(EntityBot3.class, 30, new ItemStack(Items.stone_sword));

		//Cave Crawler
		addDrop(EntityCaveCrawler.class, 20, new ItemStack(ScapecraftItems.magicFruit));
		addDrop(EntityCaveCrawler.class, 150, new ItemStack(ScapecraftItems.mithLeggings));
		addDrop(EntityCaveCrawler.class, 150, new ItemStack(ScapecraftItems.mithChestplate));

		//addDrop(EntityDarkwizard.class, 30, new ItemStack(ScapecraftItems.)); //unfinished, no items as drops

		//addDrop(EntityDharok.class, 1, new ItemStack(ScapecraftItems.dharokKey));
		//addDrop(EntityDharok.class, 300, new ItemStack(ScapecraftItems.dharokBoots));
		//addDrop(EntityDharok.class, 300, new ItemStack(ScapecraftItems.dharokChestplate));
		//addDrop(EntityDharok.class, 300, new ItemStack(ScapecraftItems.dharokHelmet));
		//addDrop(EntityDharok.class, 300, new ItemStack(ScapecraftItems.dharokLeggings));
		//addDrop(EntityDharok.class, 400, new ItemStack(ScapecraftItems.dharokAxe));

		addDrop(EntityDwarf.class, 5, new ItemStack(Items.stone_pickaxe));
		addDrop(EntityDwarf.class, 5, new ItemStack(ScapecraftItems.beer));
		addDrop(EntityDwarf.class, 30, new ItemStack(Items.iron_pickaxe));
		addDrop(EntityDwarf.class, 10, new ItemStack(Blocks.iron_ore));
		addDrop(EntityDwarf.class, 20, new ItemStack(Items.iron_ingot, 2));
		addDrop(EntityDwarf.class, 40, new ItemStack(Items.coal, 5));
		addDrop(EntityDwarf.class, 60, new ItemStack(ScapecraftItems.mithPickaxe, 1));
		addDrop(EntityDwarf.class, 150, new ItemStack(ScapecraftItems.addyPickaxe, 1));
		addDrop(EntityDwarf.class, 1, new ItemStack(Blocks.stone, 1));

		//addDrop(EntityEliteBlackKnight.class, 15, new ItemStack(ScapecraftItems.blackSword));
		//addDrop(EntityEliteBlackKnight.class, 100, new ItemStack(ScapecraftItems.blackHalberd));
		//addDrop(EntityEliteBlackKnight.class, 400, new ItemStack(ScapecraftItems.blackgBoots));
		//addDrop(EntityEliteBlackKnight.class, 400, new ItemStack(ScapecraftItems.blackgChestplate));
		//addDrop(EntityEliteBlackKnight.class, 400, new ItemStack(ScapecraftItems.blackgHelmet));
		//addDrop(EntityEliteBlackKnight.class, 400, new ItemStack(ScapecraftItems.blackgLeggings));

		addDrop(EntityFarmer.class, 30, new ItemStack(Items.melon_seeds, 2));
		addDrop(EntityFarmer.class, 30, new ItemStack(Items.pumpkin_seeds, 2));
		addDrop(EntityFarmer.class, 20, new ItemStack(Items.wheat_seeds, 2));
		addDrop(EntityFarmer.class, 50, new ItemStack(Items.water_bucket));
		addDrop(EntityFarmer.class, 30, new ItemStack(Items.stone_hoe));
		addDrop(EntityFarmer.class, 50, new ItemStack(Items.iron_hoe));
		addDrop(EntityFarmer.class, 25, new ItemStack(ScapecraftBlocks.cabbage, 4));
		addDrop(EntityFarmer.class, 50, new ItemStack(ScapecraftItems.pitchFork));

		addDrop(EntityFireGiant.class, 40, new ItemStack(ScapecraftItems.runeIngot));
		addDrop(EntityFireGiant.class, 150, new ItemStack(ScapecraftItems.runeBoots));
		addDrop(EntityFireGiant.class, 5, new ItemStack(Blocks.obsidian));
		addDrop(EntityFireGiant.class, 75, new ItemStack(ScapecraftBlocks.addyOre));
		addDrop(EntityFireGiant.class, 20, new ItemStack(Items.coal, 6));
		addDrop(EntityFireGiant.class, 12, new ItemStack(Blocks.iron_ore, 3));
		addDrop(EntityFireGiant.class, 5, new ItemStack(Items.arrow, 4));

		//addDrop(EntityGeneralGraardor.class, 15, new ItemStack(ScapecraftItems.runeSword));
		//addDrop(EntityGeneralGraardor.class, 15, new ItemStack(ScapecraftItems.runePickaxe));
		//addDrop(EntityGeneralGraardor.class, 15, new ItemStack(ScapecraftItems.runeChestplate));
		//addDrop(EntityGeneralGraardor.class, 15, new ItemStack(ScapecraftItems.dragonLongsword));
		//addDrop(EntityGeneralGraardor.class, 100, new ItemStack(ScapecraftBlocks.coalOreSpawn));
		//addDrop(EntityGeneralGraardor.class, 150, new ItemStack(ScapecraftBlocks.mithOreSpawn));
		//addDrop(EntityGeneralGraardor.class, 250, new ItemStack(ScapecraftBlocks.addyOreSpawn));
		//addDrop(EntityGeneralGraardor.class, 400, new ItemStack(ScapecraftBlocks.runeOreSpawn));
		//addDrop(EntityGeneralGraardor.class, 20, new ItemStack(Items.coal, 32));
		//addDrop(EntityGeneralGraardor.class, 10, new ItemStack(ScapecraftBlocks.addyOre, 4));
		//addDrop(EntityGeneralGraardor.class, 8, new ItemStack(ScapecraftBlocks.runeOre, 2));
		//addDrop(EntityGeneralGraardor.class, 50, new ItemStack(ScapecraftItems.addyIngot, 10));
		//addDrop(EntityGeneralGraardor.class, 200, new ItemStack(ScapecraftItems.bandosBoots));
		//addDrop(EntityGeneralGraardor.class, 200, new ItemStack(ScapecraftItems.bandosChestplate));
		//addDrop(EntityGeneralGraardor.class, 200, new ItemStack(ScapecraftItems.bandosLeggings));
		//addDrop(EntityGeneralGraardor.class, 200, new ItemStack(ScapecraftItems.bandosHelmet));
		//addDrop(EntityGeneralGraardor.class, 100, new ItemStack(ScapecraftItems.bandosHilt));
		//addDrop(EntityGeneralGraardor.class, 200, new ItemStack(ScapecraftItems.shard1));
		//addDrop(EntityGeneralGraardor.class, 200, new ItemStack(ScapecraftItems.shard2));
		//addDrop(EntityGeneralGraardor.class, 200, new ItemStack(ScapecraftItems.shard3));
		//addDrop(EntityGeneralGraardor.class, 15, new ItemStack(ScapecraftItems.superRestore, 3));
		//addDrop(EntityGeneralGraardor.class, 25, new ItemStack(ScapecraftBlocks.magicLog, 8));

		addDrop(EntityGhost.class, 50, new ItemStack(ScapecraftItems.mithBoots));
		addDrop(EntityGhost.class, 50, new ItemStack(ScapecraftItems.mithHelmet));
		addDrop(EntityGhost.class, 30, new ItemStack(Items.arrow, 16));
		addDrop(EntityGhost.class, 2, new ItemStack(Items.bread, 2));
		addDrop(EntityGhost.class, 1, new ItemStack(Items.snowball, 2));

		addDrop(EntityGoblin.class, 25, new ItemStack(Items.bow));
		addDrop(EntityGoblin.class, 35, new ItemStack(Items.stone_sword));
		addDrop(EntityGoblin.class, 35, new ItemStack(Items.stone_axe));
		addDrop(EntityGoblin.class, 35, new ItemStack(Items.stone_shovel));
		addDrop(EntityGoblin.class, 35, new ItemStack(Items.stone_pickaxe));
		addDrop(EntityGoblin.class, 60, new ItemStack(Items.iron_sword));
		addDrop(EntityGoblin.class, 20, new ItemStack(ScapecraftBlocks.cabbage, 3));
		addDrop(EntityGoblin.class, 20, new ItemStack(Items.bread, 3));
		addDrop(EntityGoblin.class, 50, new ItemStack(Blocks.iron_ore, 3));
		addDrop(EntityGoblin.class, 50, new ItemStack(Items.iron_ingot, 3));
		addDrop(EntityGoblin.class, 25, new ItemStack(ScapecraftItems.bronzeBoots));
		addDrop(EntityGoblin.class, 25, new ItemStack(ScapecraftBlocks.tinOre, 3));
		addDrop(EntityGoblin.class, 25, new ItemStack(ScapecraftBlocks.copperOre, 3));

		addDrop(EntityGreenDragon.class, 5, new ItemStack(ScapecraftItems.greenDHide));
		addDrop(EntityGreenDragon.class, 90, new ItemStack(ScapecraftItems.addyHelmet));
		addDrop(EntityGreenDragon.class, 60, new ItemStack(ScapecraftItems.addyBoots));
		addDrop(EntityGreenDragon.class, 20, new ItemStack(ScapecraftItems.whiteLeggings));
		addDrop(EntityGreenDragon.class, 5, new ItemStack(ScapecraftBlocks.addyOre));
		addDrop(EntityGreenDragon.class, 30, new ItemStack(ScapecraftItems.mithAxe));
		addDrop(EntityGreenDragon.class, 100, new ItemStack(ScapecraftItems.mithChestplate));

		addDrop(EntityGuard.class, 20, new ItemStack(ScapecraftItems.bronzeHelmet));
		addDrop(EntityGuard.class, 20, new ItemStack(ScapecraftItems.guardChestplate));
		addDrop(EntityGuard.class, 30, new ItemStack(Items.iron_sword));
		addDrop(EntityGuard.class, 50, new ItemStack(Items.iron_chestplate));
		addDrop(EntityGuard.class, 50, new ItemStack(Items.iron_leggings));
		addDrop(EntityGuard.class, 50, new ItemStack(ScapecraftItems.ironHammer));
		addDrop(EntityGuard.class, 30, new ItemStack(Items.arrow, 8));
		addDrop(EntityGuard.class, 30, new ItemStack(Items.iron_ingot));
		addDrop(EntityGuard.class, 15, new ItemStack(Items.bread, 3));

		//addDrop(EntityGuthan.class, 1, new ItemStack(ScapecraftItems.guthanKey));
		//addDrop(EntityGuthan.class, 300, new ItemStack(ScapecraftItems.guthanBoots));
		//addDrop(EntityGuthan.class, 300, new ItemStack(ScapecraftItems.guthanChestplate));
		//addDrop(EntityGuthan.class, 300, new ItemStack(ScapecraftItems.guthanHelmet));
		//addDrop(EntityGuthan.class, 300, new ItemStack(ScapecraftItems.guthanLeggings));
		//addDrop(EntityGuthan.class, 400, new ItemStack(ScapecraftItems.guthanSpear));

		//addDrop(EntityHeroKnight.class, 50, new ItemStack(ScapecraftItems.whiteSword));
		//addDrop(EntityHeroKnight.class, 50, new ItemStack(ScapecraftItems.whiteBoots));
		//addDrop(EntityHeroKnight.class, 50, new ItemStack(ScapecraftItems.whiteHelmet));
		//addDrop(EntityHeroKnight.class, 50, new ItemStack(ScapecraftItems.whiteChestplate));
		//addDrop(EntityHeroKnight.class, 50, new ItemStack(ScapecraftItems.whiteLeggings));
		//addDrop(EntityHeroKnight.class, 25, new ItemStack(Items.arrow, 16));
		//addDrop(EntityHeroKnight.class, 50, new ItemStack(Items.iron_ingot, 3));
		//addDrop(EntityHeroKnight.class, 50, new ItemStack(ScapecraftItems.yewBow));
		//addDrop(EntityHeroKnight.class, 3, new ItemStack(Items.gold_nugget, 3));

		//addDrop(EntityHighMage.class, 3, new ItemStack(Items.gold_ingot, 3));
		//addDrop(EntityHighMage.class, 150, new ItemStack(ScapecraftBlocks.coalOreSpawn));
		//addDrop(EntityHighMage.class, 200, new ItemStack(ScapecraftBlocks.ironOreSpawn));
		//addDrop(EntityHighMage.class, 1500, new ItemStack(ScapecraftItems.armaStaff));
		//addDrop(EntityHighMage.class, 25, new ItemStack(ScapecraftItems.saraStaff));
		//addDrop(EntityHighMage.class, 5, new ItemStack(Items.golden_apple));
		//addDrop(EntityHighMage.class, 5, new ItemStack(ScapecraftItems.dragonLongsword));
		//addDrop(EntityHighMage.class, 5, new ItemStack(ScapecraftItems.magicFruit, 3));
		//addDrop(EntityHighMage.class, 50, new ItemStack(ScapecraftItems.dragonLeggings));
		//addDrop(EntityHighMage.class, 25, new ItemStack(ScapecraftItems.guthixStaff));
		//addDrop(EntityHighMage.class, 25, new ItemStack(ScapecraftItems.zamorakStaff));
		//addDrop(EntityHighMage.class, 50, new ItemStack(ScapecraftItems.dragonScimmy));

		addDrop(EntityHillGiant.class, 20, new ItemStack(ScapecraftBlocks.mithOre));
		addDrop(EntityHillGiant.class, 30, new ItemStack(ScapecraftItems.blackChestplate));
		addDrop(EntityHillGiant.class, 30, new ItemStack(ScapecraftItems.blackHelmet));
		addDrop(EntityHillGiant.class, 60, new ItemStack(ScapecraftItems.mithChestplate));
		addDrop(EntityHillGiant.class, 35, new ItemStack(Items.iron_sword));
		addDrop(EntityHillGiant.class, 35, new ItemStack(Items.iron_helmet));
		addDrop(EntityHillGiant.class, 35, new ItemStack(Items.iron_chestplate));
		addDrop(EntityHillGiant.class, 35, new ItemStack(Items.iron_leggings));
		addDrop(EntityHillGiant.class, 35, new ItemStack(Items.iron_boots));

		addDrop(EntityIceGiant.class, 1, new ItemStack(Items.snowball, 4));
		addDrop(EntityIceGiant.class, 25, new ItemStack(ScapecraftItems.mithSword));
		addDrop(EntityIceGiant.class, 50, new ItemStack(ScapecraftItems.addyHelmet));
		addDrop(EntityIceGiant.class, 70, new ItemStack(ScapecraftItems.addyChestplate));
		addDrop(EntityIceGiant.class, 70, new ItemStack(ScapecraftItems.addyLeggings));
		addDrop(EntityIceGiant.class, 30, new ItemStack(ScapecraftItems.mithBoots));
		addDrop(EntityIceGiant.class, 20, new ItemStack(ScapecraftItems.blackChestplate));
		addDrop(EntityIceGiant.class, 20, new ItemStack(ScapecraftItems.blackHelmet));
		addDrop(EntityIceGiant.class, 15, new ItemStack(ScapecraftBlocks.mithOre));

		addDrop(EntityIronDragon.class, 20, new ItemStack(Items.iron_ingot, 5));
		addDrop(EntityIronDragon.class, 250, new ItemStack(ScapecraftItems.dragonLeggings));
		addDrop(EntityIronDragon.class, 50, new ItemStack(ScapecraftItems.addyAxe));
		addDrop(EntityIronDragon.class, 50, new ItemStack(ScapecraftItems.addySword));
		addDrop(EntityIronDragon.class, 75, new ItemStack(ScapecraftItems.runeAxe));
		addDrop(EntityIronDragon.class, 75, new ItemStack(ScapecraftItems.runeSword));
		addDrop(EntityIronDragon.class, 75, new ItemStack(ScapecraftItems.runeHelmet));
		addDrop(EntityIronDragon.class, 35, new ItemStack(ScapecraftItems.addyIngot, 2));
		addDrop(EntityIronDragon.class, 30, new ItemStack(ScapecraftItems.runeIngot));
		addDrop(EntityIronDragon.class, 40, new ItemStack(ScapecraftItems.superStr));
		addDrop(EntityIronDragon.class, 40, new ItemStack(ScapecraftItems.superDef));

		//addDrop(EntityKK.class, 50, new ItemStack(ScapecraftItems.dryMace));
		//addDrop(EntityKK.class, 100, new ItemStack(ScapecraftItems.dryRapier));
		//addDrop(EntityKK.class, 150, new ItemStack(ScapecraftItems.dryLong));
		//addDrop(EntityKK.class, 75, new ItemStack(ScapecraftItems.runeIngot, 10));
		//addDrop(EntityKK.class, 15, new ItemStack(ScapecraftItems.dragonHelmet));
		//addDrop(EntityKK.class, 40, new ItemStack(ScapecraftItems.DDS));
		//addDrop(EntityKK.class, 75, new ItemStack(ScapecraftItems.addyOre, 16));
		//addDrop(EntityKK.class, 5, new ItemStack(ScapecraftItems.runeBoots));
		//addDrop(EntityKK.class, 5, new ItemStack(ScapecraftItems.runeChestplate));
		//addDrop(EntityKK.class, 5, new ItemStack(ScapecraftItems.runeHelmet));
		//addDrop(EntityKK.class, 5, new ItemStack(ScapecraftItems.runeLeggings));
		//addDrop(EntityKK.class, 5, new ItemStack(ScapecraftItems.runeAxe));
		//addDrop(EntityKK.class, 5, new ItemStack(ScapecraftItems.runeSword));
		//addDrop(EntityKK.class, 75, new ItemStack(Blocks.coal_block, 8));
		//addDrop(EntityKK.class, 75, new ItemStack(ScapecraftBlocks.runeOre, 20));
		//addDrop(EntityKK.class, 20, new ItemStack(ScapecraftItems.superRestore, 5));
		//addDrop(EntityKK.class, 20, new ItemStack(ScapecraftItems.superDef, 5));
		//addDrop(EntityKK.class, 150, new ItemStack(ScapecraftBlocks.runeOreSpawn));
		//addDrop(EntityKK.class, 120, new ItemStack(ScapecraftBlocks.addyOreSpawn));
		//addDrop(EntityKK.class, 75, new ItemStack(ScapecraftBlocks.mithOreSpawn));
		//addDrop(EntityKK.class, 75, new ItemStack(ScapecraftBlocks.coalOreSpawn));
		//addDrop(EntityKK.class, 75, new ItemStack(ScapecraftBlocks.ironOreSpawn));
		//addDrop(EntityKK.class, 50, new ItemStack(ScapecraftBlocks.sandstoneSpawn));
		//addDrop(EntityKK.class, 50, new ItemStack(ScapecraftBlocks.sandSpawn));

		//addDrop(EntityKKspawn.class, 30, new ItemStack(Items.coal));
		//addDrop(EntityKKspawn.class, 3000, new ItemStack(ScapecraftItems.dragonPickaxe));

		//addDrop(EntityKQ.class, 1, new ItemStack(ScapecraftBlocks.addyOre, 2));
		//addDrop(EntityKQ.class, 20, new ItemStack(ScapecraftItems.dragonLongsword));
		//addDrop(EntityKQ.class, 2, new ItemStack(ScapecraftItems.mithLeggings));
		//addDrop(EntityKQ.class, 50, new ItemStack(ScapecraftItems.D2H));
		//addDrop(EntityKQ.class, 50, new ItemStack(ScapecraftItems.dragonChestplate));

		//addDrop(EntityKQ2.class, 100, new ItemStack(Items.coal));

		//addDrop(EntityKaril.class, 1, new ItemStack(ScapecraftItems.karilKey));
		//addDrop(EntityKaril.class, 300, new ItemStack(ScapecraftItems.karilBoots));
		//addDrop(EntityKaril.class, 300, new ItemStack(ScapecraftItems.karilChestplate));
		//addDrop(EntityKaril.class, 300, new ItemStack(ScapecraftItems.karilHelmet));
		//addDrop(EntityKaril.class, 300, new ItemStack(ScapecraftItems.karilLeggings));
		//addDrop(EntityKaril.class, 400, new ItemStack(ScapecraftItems.KarilBow));

		//addDrop(EntityKing.class, 40, new ItemStack(ScapecraftItems.dragonLongsword));
		//addDrop(EntityKing.class, 10, new ItemStack(ScapecraftItems.runeSword));
		//addDrop(EntityKing.class, 30, new ItemStack(ScapecraftItems.DD));
		//addDrop(EntityKing.class, 4, new ItemStack(ScapecraftItems.whiteHelmet));
		//addDrop(EntityKing.class, 6, new ItemStack(ScapecraftItems.whiteChestplate));
		//addDrop(EntityKing.class, 25, new ItemStack(ScapecraftItems.runeLeggings));
		//addDrop(EntityKing.class, 5, new ItemStack(ScapecraftItems.fishPie, 4));

		//addDrop(EntityKingsGuard.class, 10, new ItemStack(ScapecraftItems.guardChestplate));
		//addDrop(EntityKingsGuard.class, 10, new ItemStack(ScapecraftItems.guardHelmet));

		//koschei the deathless stage 3
		//addDrop(EntityKos3.class, 30, new ItemStack(ScapecraftBlocks.runeOre, 5));
		//addDrop(EntityKos3.class, 50, new ItemStack(ScapecraftItems.dragonHelmet));
		//addDrop(EntityKos3.class, 75, new ItemStack(ScapecraftItems.crystalBow));
		//addDrop(EntityKos3.class, 15, new ItemStack(ScapecraftItems.cabbageSpawn));
		//addDrop(EntityKos3.class, 5, new ItemStack(ScapecraftItems.fremSword));
		//addDrop(EntityKos3.class, 50, new ItemStack(ScapecraftItems.dragonLeggings));
		//addDrop(EntityKos3.class, 50, new ItemStack(ScapecraftItems.dragonBoots));
		//addDrop(EntityKos3.class, 40, new ItemStack(ScapecraftItems.runeBoots));
		//addDrop(EntityKos3.class, 40, new ItemStack(ScapecraftItems.runeHelmet));
		//addDrop(EntityKos3.class, 40, new ItemStack(ScapecraftItems.runeChestplate));
		//addDrop(EntityKos3.class, 40, new ItemStack(ScapecraftItems.runeLeggings));
		//addDrop(EntityKos3.class, 50, new ItemStack(ScapecraftItems.fremSwordf));
		//addDrop(EntityKos3.class, 50, new ItemStack(ScapecraftBlocks.diamondOreSpawn));
		//addDrop(EntityKos3.class, 60, new ItemStack(ScapecraftBlocks.coalSpawn));
		//addDrop(EntityKos3.class, 75, new ItemStack(ScapecraftBlocks.mithOreSpawn));
		//addDrop(EntityKos3.class, 100, new ItemStack(ScapecraftBlocks.addyOreSpawn));
		//addDrop(EntityKos3.class, 150, new ItemStack(ScapecraftBlocks.runeOreSpawn));

		//uses new lesser demon model
		addDrop(EntityLesserDemon.class, 100, new ItemStack(ScapecraftItems.mithSword));
		addDrop(EntityLesserDemon.class, 100, new ItemStack(ScapecraftItems.mithHelmet));
		addDrop(EntityLesserDemon.class, 100, new ItemStack(ScapecraftItems.mithChestplate));
		addDrop(EntityLesserDemon.class, 100, new ItemStack(ScapecraftItems.mithLeggings));
		addDrop(EntityLesserDemon.class, 100, new ItemStack(ScapecraftItems.mithBoots));
		addDrop(EntityLesserDemon.class, 40, new ItemStack(ScapecraftItems.blackSword));
		addDrop(EntityLesserDemon.class, 200, new ItemStack(ScapecraftItems.runeHelmet));
		addDrop(EntityLesserDemon.class, 75, new ItemStack(ScapecraftItems.addySword));
		addDrop(EntityLesserDemon.class, 50, new ItemStack(Blocks.gold_ore, 3));
		addDrop(EntityLesserDemon.class, 1, new ItemStack(Items.gold_nugget));

		//uses old lesser demon model
		addDrop(EntityLesserDemon2.class, 70, new ItemStack(ScapecraftItems.mithSword));
		addDrop(EntityLesserDemon2.class, 70, new ItemStack(ScapecraftItems.mithHelmet));
		addDrop(EntityLesserDemon2.class, 70, new ItemStack(ScapecraftItems.mithChestplate));
		addDrop(EntityLesserDemon2.class, 70, new ItemStack(ScapecraftItems.mithLeggings));
		addDrop(EntityLesserDemon2.class, 70, new ItemStack(ScapecraftItems.mithBoots));
		addDrop(EntityLesserDemon2.class, 20, new ItemStack(ScapecraftItems.blackSword));
		addDrop(EntityLesserDemon2.class, 100, new ItemStack(ScapecraftItems.runeHelmet));
		addDrop(EntityLesserDemon2.class, 75, new ItemStack(ScapecraftItems.addySword));
		addDrop(EntityLesserDemon2.class, 50, new ItemStack(Blocks.gold_ore, 3));
		addDrop(EntityLesserDemon2.class, 1, new ItemStack(Items.gold_nugget));

		//addDrop(EntityLootChest.class, 1, new ItemStack(Items.gold_ingot));
		//addDrop(EntityLootChest.class, 1, new ItemStack(Items.gold_ingot));
		//addDrop(EntityLootChest.class, 1, new ItemStack(ScapecraftItems.questPoint3));
		//addDrop(EntityLootChest.class, 1, new ItemStack(ScapecraftItems.fishPieUncooked, 10));
		//addDrop(EntityLootChest.class, 1, new ItemStack(ScapecraftItems.whiteBoots));
		//addDrop(EntityLootChest.class, 1, new ItemStack(ScapecraftItems.whiteChestplate));
		//addDrop(EntityLootChest.class, 1, new ItemStack(ScapecraftItems.whiteHelmet));
		//addDrop(EntityLootChest.class, 1, new ItemStack(ScapecraftItems.whiteLeggings));
		//addDrop(EntityLootChest.class, 1, new ItemStack(ScapecraftItems.whiteSword));

		addDrop(EntityMan.class, 30, new ItemStack(ScapecraftItems.bronzeHelmet));
		addDrop(EntityMan.class, 30, new ItemStack(ScapecraftItems.bronzeBoots));
		addDrop(EntityMan.class, 20, new ItemStack(Items.stone_sword));
		addDrop(EntityMan.class, 10, new ItemStack(ScapecraftBlocks.cabbage, 8));
		addDrop(EntityMan.class, 20, new ItemStack(Items.bow));
		addDrop(EntityMan.class, 20, new ItemStack(Items.arrow, 16));
		addDrop(EntityMan.class, 10, new ItemStack(Items.bread, 5));
		addDrop(EntityMan.class, 20, new ItemStack(Items.stone_pickaxe));

		addDrop(EntityMossGiant.class, 30, new ItemStack(ScapecraftItems.blackHelmet));
		addDrop(EntityMossGiant.class, 30, new ItemStack(ScapecraftItems.blackBoots));
		addDrop(EntityMossGiant.class, 40, new ItemStack(ScapecraftItems.mithSword));
		addDrop(EntityMossGiant.class, 50, new ItemStack(ScapecraftItems.mithChestplate));
		addDrop(EntityMossGiant.class, 75, new ItemStack(ScapecraftItems.addySword));
		addDrop(EntityMossGiant.class, 75, new ItemStack(ScapecraftItems.addyBoots));
		addDrop(EntityMossGiant.class, 10, new ItemStack(Items.coal, 4));
		addDrop(EntityMossGiant.class, 30, new ItemStack(Items.arrow, 12));

		addDrop(EntityMugger.class, 20, new ItemStack(ScapecraftItems.bronzeAxe));
		addDrop(EntityMugger.class, 20, new ItemStack(ScapecraftItems.bronzeSword));
		addDrop(EntityMugger.class, 40, new ItemStack(Items.iron_sword));
		addDrop(EntityMugger.class, 2, new ItemStack(Items.gold_nugget));
		addDrop(EntityMugger.class, 30, new ItemStack(ScapecraftItems.magicFruit));

		addDrop(EntityRat.class, 5, new ItemStack(ScapecraftItems.ratTail));
		addDrop(EntityRat.class, 25, new ItemStack(Items.stone_sword));

		addDrop(EntityRatSmall.class, 25, new ItemStack(Items.stone_sword));
		addDrop(EntityRatSmall.class, 5, new ItemStack(ScapecraftItems.ratTail));

		addDrop(EntityScorpion.class, 100, new ItemStack(ScapecraftItems.blackChestplate));
		addDrop(EntityScorpion.class, 30, new ItemStack(Items.iron_pickaxe));
		addDrop(EntityScorpion.class, 1, new ItemStack(Items.wheat, 2));

		//addDrop(EntitySergeantGrimspike.class, 100, new ItemStack(ScapecraftItems.magicFruit));
		//addDrop(EntitySergeantGrimspike.class, 1000, new ItemStack(ScapecraftItems.shard1));
		//addDrop(EntitySergeantGrimspike.class, 500, new ItemStack(ScapecraftItems.dragonBoots));

		//addDrop(EntitySergeantSteelwill.class, 100, new ItemStack(ScapecraftItems.magicFruit));
		//addDrop(EntitySergeantSteelwill.class, 1000, new ItemStack(ScapecraftItems.shard2));
		//addDrop(EntitySergeantSteelwill.class, 500, new ItemStack(ScapecraftItems.dragonBoots));

		//addDrop(EntitySergeantStrongstack.class, 100, new ItemStack(ScapecraftItems.magicFruit));
		//addDrop(EntitySergeantStrongstack.class, 1000, new ItemStack(ScapecraftItems.shard3));
		//addDrop(EntitySergeantStrongstack.class, 500, new ItemStack(ScapecraftItems.dragonBoots));

		//addDrop(EntityTD.class, 1, new ItemStack(ScapecraftBlocks.runeOre));
		//addDrop(EntityTD.class, 1, new ItemStack(ScapecraftItems.magicFruit));
		//addDrop(EntityTD.class, 100, new ItemStack(ScapecraftBlocks.mithOreSpawn));
		//addDrop(EntityTD.class, 100, new ItemStack(ScapecraftItems.DBA));
		//addDrop(EntityTD.class, 100, new ItemStack(ScapecraftItems.dragonHelmet));
		//addDrop(EntityTD.class, 1000, new ItemStack(ScapecraftBlocks.runeOreSpawn));
		//addDrop(EntityTD.class, 200, new ItemStack(ScapecraftBlocks.addyOreSpawn));
		//addDrop(EntityTD.class, 2000, new ItemStack(ScapecraftItems.crystalBow));
		//addDrop(EntityTD.class, 3, new ItemStack(ScapecraftItems.mithChestplate));
		//addDrop(EntityTD.class, 400, new ItemStack(ScapecraftItems.dragonlBoots));
		//addDrop(EntityTD.class, 400, new ItemStack(ScapecraftItems.dragonlChestplate));
		//addDrop(EntityTD.class, 400, new ItemStack(ScapecraftItems.dragonlHelmet));
		//addDrop(EntityTD.class, 400, new ItemStack(ScapecraftItems.dragonlLeggings));
		//addDrop(EntityTD.class, 500, new ItemStack(ScapecraftBlocks.coalOreSpawn));

		addDrop(EntityTheif.class, 100, new ItemStack(ScapecraftItems.blackLeggings));
		addDrop(EntityTheif.class, 20, new ItemStack(ScapecraftItems.magicFruit));
		addDrop(EntityTheif.class, 50, new ItemStack(ScapecraftItems.blackSword));
		addDrop(EntityTheif.class, 1, new ItemStack(Blocks.wool, 2, 15));

		//addDrop(EntityTorag.class, 1, new ItemStack(ScapecraftItems.toragKey));
		//addDrop(EntityTorag.class, 300, new ItemStack(ScapecraftItems.toragBoots));
		//addDrop(EntityTorag.class, 300, new ItemStack(ScapecraftItems.toragChestplate));
		//addDrop(EntityTorag.class, 300, new ItemStack(ScapecraftItems.toragHelmet));
		//addDrop(EntityTorag.class, 300, new ItemStack(ScapecraftItems.toragLeggings));
		//addDrop(EntityTorag.class, 400, new ItemStack(ScapecraftItems.toragHammer));

		//addDrop(EntityVampire.class, 1, new ItemStack(ScapecraftItems.questPoint));
		//addDrop(EntityVampire.class, 3, new ItemStack(ScapecraftItems.blackBoots));
		//addDrop(EntityVampire.class, 3, new ItemStack(ScapecraftItems.blackChestplate));
		//addDrop(EntityVampire.class, 3, new ItemStack(ScapecraftItems.blackHelmet));
		//addDrop(EntityVampire.class, 3, new ItemStack(ScapecraftItems.blackLeggings));
		//addDrop(EntityVampire.class, 3, new ItemStack(ScapecraftItems.blackSword));

		//addDrop(EntityVerac.class, 1, new ItemStack(ScapecraftItems.veracKey));
		//addDrop(EntityVerac.class, 300, new ItemStack(ScapecraftItems.veracBoots));
		//addDrop(EntityVerac.class, 300, new ItemStack(ScapecraftItems.veracChestplate));
		//addDrop(EntityVerac.class, 300, new ItemStack(ScapecraftItems.veracHelmet));
		//addDrop(EntityVerac.class, 300, new ItemStack(ScapecraftItems.veracLeggings));
		//addDrop(EntityVerac.class, 400, new ItemStack(ScapecraftItems.veracFlail));

		addDrop(EntityWhiteKnight.class, 60, new ItemStack(ScapecraftItems.whiteBoots));
		addDrop(EntityWhiteKnight.class, 60, new ItemStack(ScapecraftItems.whiteHelmet));
		addDrop(EntityWhiteKnight.class, 60, new ItemStack(ScapecraftItems.whiteSword));
		addDrop(EntityWhiteKnight.class, 60, new ItemStack(ScapecraftItems.whiteChestplate));
		addDrop(EntityWhiteKnight.class, 60, new ItemStack(ScapecraftItems.whiteLeggings));
		addDrop(EntityWhiteKnight.class, 1, new ItemStack(Items.apple, 1));

		//addDrop(EntityWizard.class, 8, new ItemStack(ScapecraftItems.)); //no current drops

		//addDrop(EntityZilyana.class, 65, new ItemStack(ScapecraftItems.saraSword));
		//addDrop(EntityZilyana.class, 25, new ItemStack(ScapecraftItems.runeChestplate));
		//addDrop(EntityZilyana.class, 25, new ItemStack(ScapecraftItems.runeLeggings));
		//addDrop(EntityZilyana.class, 15, new ItemStack(ScapecraftItems.addyChestplate));
		//addDrop(EntityZilyana.class, 25, new ItemStack(ScapecraftItems.runeSword));
		//addDrop(EntityZilyana.class, 20, new ItemStack(ScapecraftItems.superStr, 3));
		//addDrop(EntityZilyana.class, 20, new ItemStack(ScapecraftItems.superDef, 3));
		//addDrop(EntityZilyana.class, 20, new ItemStack(ScapecraftItems.saraBrew, 3));
		//addDrop(EntityZilyana.class, 20, new ItemStack(ScapecraftItems.superRestore, 3));
		//addDrop(EntityZilyana.class, 200, new ItemStack(ScapecraftItems.shard1));
		//addDrop(EntityZilyana.class, 200, new ItemStack(ScapecraftItems.shard2));
		//addDrop(EntityZilyana.class, 200, new ItemStack(ScapecraftItems.shard3));
		//addDrop(EntityZilyana.class, 100, new ItemStack(ScapecraftItems.saradominHilt));
		//addDrop(EntityZilyana.class, 35, new ItemStack(ScapecraftBlocks.yewLog, 16));
		//addDrop(EntityZilyana.class, 15, new ItemStack(ScapecraftBlocks.addyOre, 8));
		//addDrop(EntityZilyana.class, 10, new ItemStack(ScapecraftBlocks.runeOre, 2));
		//addDrop(EntityZilyana.class, 30, new ItemStack(Items.coal, 32));
		//addDrop(EntityZilyana.class, 25, new ItemStack(ScapecraftItems.dragonDagger));
		//addDrop(EntityZilyana.class, 50, new ItemStack(ScapecraftItems.dragonHelmet));
		//addDrop(EntityZilyana.class, 25, new ItemStack(ScapecraftItems.runeAxe));
		//addDrop(EntityZilyana.class, 10, new ItemStack(ScapecraftItems.runeIngot));
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
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.ScapecraftItems.runeChestplate));
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.ScapecraftItems.runeLeggings));
		//addDrop(EntityKrilTsutsaroth.class, 20, new ItemStack(Items.ScapecraftItems.addyChestplate));
		//addDrop(EntityKrilTsutsaroth.class, 20, new ItemStack(Items.ScapecraftItems.addyLeggings));
		//addDrop(EntityKrilTsutsaroth.class, 100, new ItemStack(Items.ScapecraftItems.zamorakHilt));
		//addDrop(EntityKrilTsutsaroth.class, 200, new ItemStack(Items.ScapecraftItems.shard1));
		//addDrop(EntityKrilTsutsaroth.class, 200, new ItemStack(Items.ScapecraftItems.shard2));
		//addDrop(EntityKrilTsutsaroth.class, 200, new ItemStack(Items.ScapecraftItems.shard3));
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.ScapecraftItems.superStr, 3));
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.ScapecraftItems.superRestore, 3));
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.ScapecraftItems.runeOre, 2));
		//addDrop(EntityKrilTsutsaroth.class, 35, new ItemStack(Items.ScapecraftItems.yewLog, 16));
		//addDrop(EntityKrilTsutsaroth.class, 15, new ItemStack(Items.ScapecraftItems.addyOre, 8));
		//addDrop(EntityKrilTsutsaroth.class, 30, new ItemStack(Items.coal, 32));
		//addDrop(EntityKrilTsutsaroth.class, 10, new ItemStack(Items.ScapecraftItems.runeIngot));
		//addDrop(EntityKrilTsutsaroth.class, 25, new ItemStack(Items.ScapecraftItems.dragonDagger));
		//addDrop(EntityKrilTsutsaroth.class, 50, new ItemStack(Items.ScapecraftItems.dragonHelmet));
		//addDrop(EntityKrilTsutsaroth.class, 25, new ItemStack(Items.ScapecraftItems.runeAxe));

		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.armadylHelmet));
		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.armadylChestplate));
		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.armadylLeggings));
		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.armadylBoots));
		//addDrop(EntityKreearra.class, 100, new ItemStack(Items.ScapecraftItems.armadylHilt));
		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.shard1));
		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.shard2));
		//addDrop(EntityKreearra.class, 200, new ItemStack(Items.ScapecraftItems.shard3));
		//addDrop(EntityKreearra.class, 25, new ItemStack(Items.ScapecraftItems.runeSword));
		//addDrop(EntityKreearra.class, 25, new ItemStack(Items.ScapecraftItems.runeChestplate));
		//addDrop(EntityKreearra.class, 25, new ItemStack(Items.ScapecraftItems.blackdChestplate));
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
		setMoney(EntityBot3.class, 15, 40, 80, 130);
		setMoney(EntityGuard.class, 5, 10, 30, 50);
		//setMoney(EntityHellhound.class, 15, 50, 80, 150, 340);
		setMoney(EntityHillGiant.class, 20, 50, 120, 170);
		setMoney(EntityIceGiant.class, 50, 120, 275, 540);
		setMoney(EntityIronDragon.class, 20, 80, 200, 310, 500);
		setMoney(EntityLesserDemon.class, 17, 50, 120, 220, 310, 630);
		setMoney(EntityLesserDemon2.class, 17, 50, 120, 220, 310, 630);
		setMoney(EntityMan.class, 1, 5, 8, 10);
		setMoney(EntityMossGiant.class, 7, 20, 80, 210, 320);
		setMoney(EntityMugger.class, 3, 15, 20, 31);
		setMoney(EntityRat.class, 1, 3, 9, 12);
		setMoney(EntityScorpion.class, 4, 21, 34);
		setMoney(EntityTheif.class, 5, 11, 15, 30);
		setMoney(EntityWhiteKnight.class, 5, 35, 59, 81);
	}

	public static EntityScapecraft spawnScapecraftEntity(String name, World world)
	{
		EntityScapecraft entity = null;
		try {
			entity = (EntityScapecraft) ScapecraftEntities.entityNames.get(name.toLowerCase()).getConstructor(new Class[] { World.class }).newInstance(new Object[] { world });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
}
