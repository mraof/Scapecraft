package scapecraft.item;

import cpw.mods.fml.common.registry.ExistingSubstitutionException;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.oredict.OreDictionary;
import scapecraft.Scapecraft;
import scapecraft.ScapecraftRecipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScapecraftItems
{
	public static HashMap<Item, Integer> toolLevels;
	public static final HashMap<String, Item> equipmentSets = new LinkedHashMap<String, Item>();

	public static Item santaHelmet;
	public static Item phatHelmet;

	public static Item graniteHelmet;
	public static Item granitePlatebody;
	public static Item granitePlatelegs;
	public static Item graniteBoots;

	public static Item stoneHelmet;
	public static Item stonePlatebody;
	public static Item stonePlatelegs;
	public static Item stoneBoots;

	//public static Item neitiznotHelmet;
	/*end armor*/

	public static Item stake;
	public static Item pitchFork;

	public static Item dryMace;
	public static Item dryRapier;
	public static Item dryLong;

	public static Item dragonPickaxeg;

	public static Item bronzeIngot;
	public static Item steelIngot;
	public static Item mithrilIngot;
	public static Item adamantIngot;
	public static Item runeIngot;
	public static Item graniteLump;
	public static Item greenDLeather;
	public static Item greenDHide;
	public static Item blackDLeather;
	public static Item blackDHide;
	public static ItemMulti stick;
	public static Item magicFruit;
	public static Item cabbagePieUncooked;
	public static Item meatPieUncooked;
	public static Item applePieUncooked;
	public static Item fishPieUncooked;
	public static Item cutCabbage;
	public static ItemScapecraftFood cabbagePie;
	public static ItemScapecraftFood fishPie;
	public static ItemScapecraftFood meatPie;
	public static ItemScapecraftFood applePie;
	public static ItemScapecraftFood beer;
	public static ItemMulti questItem;

	public static Item scapecraftSpawnEgg;
	public static Item tombKey;
	public static Item doorKey;
	public static Item boltRack;
	public static Item garlic;
	public static Item scapecraftItemFrame;

	public static Item saraBrew;
	public static Item superRestore;
	public static Item superStr;
	public static Item superDef;

	//TODO These are useless right now
	public static Item armaStaff;
 	public static Item guthixStaff;
 	public static Item saraStaff;
 	public static Item zammyStaff;

	public static ArrayList<Item> createMetalSet(String name, int level, Item metal, int smithingLevel)
	{
		return createMetalSet(name, level, level, metal, smithingLevel);
	}

	public static ArrayList<Item> createMetalSet(String name, int level, float damage, Item metal, int smithingLevel)
	{
		HashMap<String, Item> set = new HashMap<String, Item>();
		set.put(name + "Helmet", new ItemArmorScapecraft(level, damage * .15f, 0, name + "Helmet"));
		set.put(name + "FullHelm", new ItemArmorScapecraft(level, damage * .17f, 0, name + "FullHelm"));
		set.put(name + "Chainbody", new ItemArmorScapecraft(level, damage * .18f, 1, name + "Chainbody"));
		set.put(name + "Platebody", new ItemArmorScapecraft(level, damage * .2f, 1, name + "Platebody"));
		set.put(name + "Platelegs", new ItemArmorScapecraft(level, damage * .2f, 2, name + "Platelegs"));
		set.put(name + "Plateskirt", new ItemArmorScapecraft(level, damage * .2f, 2, name + "Plateskirt"));
		set.put(name + "Boots", new ItemArmorScapecraft(level, damage * .1f, 3, name + "Boots"));
		set.put(name + "Dagger", new ItemWeapon(damage, name + "Dagger", level, .6));
		set.put(name + "Sword", new ItemWeapon(damage, name + "Sword", level));
		set.put(name + "Hammer", new ItemWeapon(damage, name + "Hammer", level, 1.5));

		set.put(name + "Shovel", new ItemScapecraftShovel(damage, level, name + "Shovel"));
		set.put(name + "Pickaxe", new ItemScapecraftPickaxe(damage, level, name + "Pickaxe"));
		set.put(name + "Axe", new ItemScapecraftAxe(damage, level, name + "Axe"));
		set.put(name + "Hoe", new ItemScapecraftHoe(level, name + "Hoe"));

		equipmentSets.putAll(set);

		if(metal != null)
		{
			ScapecraftRecipes.registerSetRecipes(level, name, "ingot" + name.substring(0, 1).toUpperCase() + name.substring(1), smithingLevel);
		}
		return new ArrayList<Item>(set.values());
	}

	@SuppressWarnings("UnusedParameters") //TODO fletching
	public static ArrayList<Item> createBows(String name, int level, float damage, Item metal, int fletchingLevel)
	{
		HashMap<String, Item> set = new HashMap<String, Item>();
		set.put(name + "Shortbow", new ItemScapecraftBow(damage, name + "Shortbow", level, 0.7));
		return new ArrayList<Item>(set.values());
	}
	public static void registerItems()
	{
		bronzeIngot = new Item().setTextureName("scapecraft:bronzeIngot").setUnlocalizedName("bronzeIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);
		steelIngot = new Item().setTextureName("scapecraft:steelIngot").setUnlocalizedName("steelIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);
		mithrilIngot = new Item().setTextureName("scapecraft:mithrilIngot").setUnlocalizedName("mithrilIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);
		adamantIngot = new Item().setTextureName("scapecraft:adamantIngot").setUnlocalizedName("adamantIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);
		runeIngot = new Item().setTextureName("scapecraft:runeIngot").setUnlocalizedName("runeIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);

		graniteLump = new Item().setUnlocalizedName("graniteLump").setTextureName("scapecraft:GraniteLump").setCreativeTab(Scapecraft.tabScapecraftMisc);
		greenDLeather = new Item().setUnlocalizedName("greenDLeather").setTextureName("scapecraft:GreenDLeather").setCreativeTab(Scapecraft.tabScapecraftMisc);
		greenDHide = new Item().setUnlocalizedName("greenDHide").setTextureName("scapecraft:GreenDHide").setCreativeTab(Scapecraft.tabScapecraftMisc);
		blackDLeather = new Item().setUnlocalizedName("blackDLeather").setTextureName("scapecraft:BlackDLeather").setCreativeTab(Scapecraft.tabScapecraftMisc);
		blackDHide = new Item().setUnlocalizedName("blackDHide").setTextureName("scapecraft:BlackDHide").setCreativeTab(Scapecraft.tabScapecraftMisc);

		stick = new ItemMulti("stick");
		stick.addSubItems("strongOak", "willow", "maple", "yew", "magic");

		/*strongOakStick = new Item().setUnlocalizedName("strongOakStick").setTextureName("scapecraft:StrongOakStick").setCreativeTab(Scapecraft.tabScapecraftMisc);
		willowStick = new Item().setUnlocalizedName("willowStick").setTextureName("scapecraft:WillowStick").setCreativeTab(Scapecraft.tabScapecraftMisc);
		mapleStick = new Item().setUnlocalizedName("mapleStick").setTextureName("scapecraft:MapleStick").setCreativeTab(Scapecraft.tabScapecraftMisc);
		yewStick = new Item().setUnlocalizedName("yewStick").setTextureName("scapecraft:YewStick").setCreativeTab(Scapecraft.tabScapecraftMisc);
		magicStick = new Item().setUnlocalizedName("magicStick").setTextureName("scapecraft:MagicStick").setCreativeTab(Scapecraft.tabScapecraftMisc);*/
		magicFruit = new ItemFood(20, false).setUnlocalizedName("magicFruit").setTextureName("scapecraft:MagicFruit").setCreativeTab(Scapecraft.tabScapecraftMisc);
		cabbagePieUncooked = new Item().setUnlocalizedName("cabbagePieUncooked").setTextureName("scapecraft:CabbagePie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		meatPieUncooked = new Item().setUnlocalizedName("meatPieUncooked").setTextureName("scapecraft:MeatPie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		applePieUncooked = new Item().setUnlocalizedName("applePieUncooked").setTextureName("scapecraft:ApplePie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		fishPieUncooked = new Item().setUnlocalizedName("fishPieUncooked").setTextureName("scapecraft:FishPie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		cutCabbage = new ItemFood(2, true).setAlwaysEdible().setUnlocalizedName("cutCabbage").setTextureName("scapecraft:CutCabbage").setCreativeTab(Scapecraft.tabScapecraftMisc);
		cabbagePie = new ItemScapecraftFood(3);
		cabbagePie.setAlwaysEdible().setUnlocalizedName("cabbagePie").setTextureName("scapecraft:CabbagePie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		fishPie = new ItemScapecraftFood(12);
		fishPie.setAlwaysEdible().setUnlocalizedName("fishPie").setTextureName("scapecraft:FishPie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		meatPie = new ItemScapecraftFood(5);
		meatPie.setAlwaysEdible().setUnlocalizedName("meatPie").setTextureName("scapecraft:MeatPie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		applePie = new ItemScapecraftFood(4);
		applePie.setAlwaysEdible().setUnlocalizedName("applePie").setTextureName("scapecraft:ApplePie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		beer = new ItemScapecraftFood(2);
		beer.setAlwaysEdible().setUnlocalizedName("beer").setTextureName("scapecraft:Beer").setCreativeTab(Scapecraft.tabScapecraftMisc);
		questItem = new ItemMulti("quest");
		questItem.setUnlocalizedName("questItem").setCreativeTab(Scapecraft.tabScapecraftMisc);
		questItem.addSubItems("ratTail");

		tombKey = new Item().setUnlocalizedName("tombKey").setTextureName("scapecraft:Key2").setCreativeTab(Scapecraft.tabScapecraftMisc);
		doorKey = new Item().setUnlocalizedName("doorKey").setTextureName("scapecraft:Key2").setCreativeTab(Scapecraft.tabScapecraftMisc);
		garlic = new Item().setUnlocalizedName("garlic").setTextureName("scapecraft:Garlic").setCreativeTab(Scapecraft.tabScapecraftMisc);
		scapecraftSpawnEgg = new ItemScapecraftSpawnEgg();
		scapecraftSpawnEgg.setTextureName("minecraft:spawn_egg");
		scapecraftItemFrame = new ItemScapecraftItemFrame();
		scapecraftItemFrame.setUnlocalizedName("frame").setTextureName("item_frame");

		createMetalSet("bronze", 1, 5, bronzeIngot, 1);
		createMetalSet("iron", 10, Items.iron_ingot, 15);
		createMetalSet("steel", 20, steelIngot, 30);
		createMetalSet("white", 25, null, 0);
		createMetalSet("black", 25, null, 0);
		createMetalSet("mithril", 30, mithrilIngot, 50);
		createMetalSet("adamant", 40, adamantIngot, 70);
		createMetalSet("rune", 50, runeIngot, 85);
		createMetalSet("dragon", 60, null, 0);
		for(Item item : createMetalSet("dragonC", 60, null, 0))
		{
			item.setMaxDurability(item.getMaxDurability() / 25);
		}

		createBows("strongOak", 10, 5, Items.iron_ingot, 20);
		createBows("willow", 20, 5, steelIngot, 35);
		createBows("maple", 30, 5, mithrilIngot, 50);
		createBows("yew", 40, 5, adamantIngot, 65);
		createBows("magic", 50, 5, runeIngot, 80);

		equipmentSets.put("graniteHelmet", new ItemArmorScapecraft(55, 55 * .15f, 0, "graniteHelmet"));
		equipmentSets.put("granitePlatebody", new ItemArmorScapecraft(55, 55 * .2f, 1, "granitePlatebody"));
		equipmentSets.put("granitePlatelegs", new ItemArmorScapecraft(55, 55 * .2f, 2, "granitePlatelegs"));
		equipmentSets.put("graniteBoots", new ItemArmorScapecraft(55, 55 * .1f, 3, "graniteBoots"));

		//Aesthetic armor
		santaHelmet = new ItemArmorScapecraft(0, 0, 0, "santaHelmet");

		phatHelmet = new ItemArmorColored(0, 0, 0, "phat")
				.addColor("white", 0xFFFFFF)
				.addColor("red", 0xFF0000)
				.addColor("yellow", 0xFFFF00)
				.addColor("orange", 0xFF9900)
				.addColor("blue", 0x0000FF)
				.addColor("green", 0x00FF00)
				.addColor("purple", 0xFF99FF)
				.addColor("cyan", 0x00FFFF)
				.addColor("black", 0x111111);

		stoneHelmet = new ItemArmorScapecraft(0, 0, 0, "stoneHelmet");
		stonePlatebody = new ItemArmorScapecraft(0, 0, 1, "stonePlatebody");
		stonePlatelegs = new ItemArmorScapecraft(0, 0, 2, "stonePlatelegs");
		stoneBoots = new ItemArmorScapecraft(0, 0, 3, "stoneBoots");

		pitchFork = new ItemWeapon(6, "PitchFork", 4);
		stake = new ItemWeapon(8, "Stake", 10);

		dryMace = new ItemDryWeapon(5F, "DryMace");
		dryRapier = new ItemDryWeapon(10F, "DryRapier");
		dryLong = new ItemDryWeapon(15F, "DryLong");

		/* Ranger armor
		greendHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.GREEND, 0, "greend");
		greendPlatebody = new ItemArmorScapecraft(ScapecraftArmorMaterial.GREEND, 1, "greend");
		greendPlatelegs = new ItemArmorScapecraft(ScapecraftArmorMaterial.GREEND, 2, "greend");
		greendBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.GREEND, 3, "greend");

		blackdHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACKD, 0, "blackd");
		blackdPlatebody = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACKD, 1, "blackd");
		blackdPlatelegs = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACKD, 2, "blackd");
		blackdBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACKD, 3, "blackd");
		*/

		/* GWD
		bandosHelmet = new ItemArmorBandos(ScapecraftArmorMaterial.BANDOS, 0, "Bandos");
		bandosPlatebody = new ItemArmorBandos(ScapecraftArmorMaterial.BANDOS, 1, "Bandos");
		bandosPlatelegs = new ItemArmorBandos(ScapecraftArmorMaterial.BANDOS, 2, "Bandos");
		bandosBoots = new ItemArmorBandos(ScapecraftArmorMaterial.BANDOS, 3, "Bandos");

		ags = new ItemSpecialWeapon(ScapecraftToolMaterial.AGS, 4, "ArmadylGodsword", 50);
		bgs = new ItemSpecialWeapon(ScapecraftToolMaterial.BGS, 4, "BandosGodsword", 99);
		sgs = new ItemSpecialWeapon(ScapecraftToolMaterial.SGS, 4, "SaradominGodsword", 55);
		zgs = new ItemSpecialWeapon(ScapecraftToolMaterial.ZGS, 4, "ZamorakGodsword", 75);

		*/
		/*
		neitiznotHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.NEIT, 0, "neitiznot");
		 */
		/*end armor*/

		/*
		blackHalberd = new ItemWeapon(ScapecraftToolMaterial.BLACKH, 4, "blackHalberd");
		chicken = new ItemWeapon(ScapecraftToolMaterial.CHICKEN, 4, "Chicken");
		keris = new ItemWeapon(ScapecraftToolMaterial.KERIS, 4, "Keris");
		korasis = new ItemWeapon(ScapecraftToolMaterial.KORASIS, 4, "KorasiSword");
		dragon2hSword = new ItemWeapon(ScapecraftToolMaterial.WHIP, 4, "dragon2hSword");
		fremSword = new ItemWeapon(ScapecraftToolMaterial.FREM, 4, "FremSword");
		fremSwordf = new ItemWeapon(ScapecraftToolMaterial.FREMF, 4, "FremSwordf");
		chaoticRapier = new ItemWeapon(ScapecraftToolMaterial.CHAOTIC, 4F, "ChaoticRapier");
		chaoticMaul = new ItemWeapon(ScapecraftToolMaterial.CHAOTIC, 11F, "ChaoticMaul");
		chaoticLongsword = new ItemWeapon(ScapecraftToolMaterial.CHAOTIC, 7F, "ChaoticLongsword");

		cutlass = new ItemCutlass();

		whip = new ItemSpecialWeapon(ScapecraftToolMaterial.WHIP, 4F, "Whip", 50);
		dragonBattleAxe = new ItemSpecialWeapon(ScapecraftToolMaterial.DRAGONB, 4, "dragonBattleAxe", 99);
		dds = new ItemSpecialWeapon(ScapecraftToolMaterial.DRAGONDS, 4, "dragonDaggerS", 25);
		saraSword = new ItemSpecialWeapon(ScapecraftToolMaterial.SARASWORD, 4, "SaraSword", 99);
		vestaSword = new ItemSpecialWeapon(ScapecraftToolMaterial.VESTA, 4, "Vesta", 25);
		*/

		/* Barrows
		{
			ahrimBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.AHRIM, 3, "Ahrim");
			ahrimHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.AHRIM, 0, "Ahrim");
			ahrimPlatebody = new ItemArmorScapecraft(ScapecraftArmorMaterial.AHRIM, 1, "Ahrim");
			ahrimPlatelegs = new ItemArmorScapecraft(ScapecraftArmorMaterial.AHRIM, 2, "Ahrim");
			ahrimStaff = new Item().setUnlocalizedName("ahrimStaff").setTextureName("scapecraft:AhrimStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);

			akrisaeHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.AKRISAE, 0, "Akrisae");
			akrisaePlatebody = new ItemArmorScapecraft(ScapecraftArmorMaterial.AKRISAE, 1, "Akrisae");
			akrisaePlatelegs = new ItemArmorScapecraft(ScapecraftArmorMaterial.AKRISAE, 2, "Akrisae");
			akrisaeBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.AKRISAE, 3, "Akrisae");

			dharokHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.DHAROK, 0, "Dharok");
			dharokPlatebody = new ItemArmorScapecraft(ScapecraftArmorMaterial.DHAROK, 1, "Dharok");
			dharokPlatelegs = new ItemArmorScapecraft(ScapecraftArmorMaterial.DHAROK, 2, "Dharok");
			dharokBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.DHAROK, 3, "Dharok");
			dharokAxe = new ItemSetWeapon(ScapecraftToolMaterial.DHAROK, ScapecraftArmorMaterial.DHAROK, "DharokAxe");

			guthanHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.GUTHAN, 0, "Guthan");
			guthanPlatebody = new ItemArmorScapecraft(ScapecraftArmorMaterial.GUTHAN, 1, "Guthan");
			guthanPlatelegs = new ItemArmorScapecraft(ScapecraftArmorMaterial.GUTHAN, 2, "Guthan");
			guthanBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.GUTHAN, 3, "Guthan");
			guthanSpear = new ItemSetWeapon(ScapecraftToolMaterial.GUTHAN, ScapecraftArmorMaterial.GUTHAN, "GuthanSpear");

			karilHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.KARIL, 0, "Karil");
			karilPlatebody = new ItemArmorScapecraft(ScapecraftArmorMaterial.KARIL, 1, "Karil");
			karilPlatelegs = new ItemArmorScapecraft(ScapecraftArmorMaterial.KARIL, 2, "Karil");
			karilBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.KARIL, 3, "Karil");
			karilBow = new ItemScapecraftBow(ScapecraftBowMaterial.KARIL, "KarilCBow").setHasModel(true);

			toragHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.TORAG, 0, "Torag");
			toragPlatebody = new ItemArmorScapecraft(ScapecraftArmorMaterial.TORAG, 1, "Torag");
			toragPlatelegs = new ItemArmorScapecraft(ScapecraftArmorMaterial.TORAG, 2, "Torag");
			toragBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.TORAG, 3, "Torag");
			toragHammer = new ItemSetWeapon(ScapecraftToolMaterial.TORAG, ScapecraftArmorMaterial.TORAG, "ToragHammer");

			veracHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.VERAC, 0, "Verac");
			veracPlatebody = new ItemArmorScapecraft(ScapecraftArmorMaterial.VERAC, 1, "Verac");
			veracPlatelegs = new ItemArmorScapecraft(ScapecraftArmorMaterial.VERAC, 2, "Verac");
			veracBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.VERAC, 3, "Verac");
			veracFlail = new ItemSetWeapon(ScapecraftToolMaterial.VERAC, ScapecraftArmorMaterial.VERAC, "VeracFlail");
		}/**/

		dragonPickaxeg = new ItemScapecraftPickaxe(30, 60, "dragonPickaxeg"); //TODO Do I want this?

		saraBrew = new ItemScapecraftPotion(new PotionEffect(Potion.regeneration.id, 600, 1));
		saraBrew.setUnlocalizedName("saraBrew").setTextureName("scapecraft:sarabrew");
		superRestore = new ItemScapecraftPotion(new PotionEffect(Potion.saturation.id, 600, 1), new PotionEffect(Potion.moveSpeed.id, 600, 0));
		superRestore.setUnlocalizedName("superRestore").setTextureName("scapecraft:superrestore");
		superStr = new ItemScapecraftPotion(new PotionEffect(Potion.damageBoost.id, 600, 0));
		superStr.setUnlocalizedName("superStr").setTextureName("scapecraft:superstr");
		superDef = new ItemScapecraftPotion(new PotionEffect(Potion.resistance.id, 600, 1));
		superDef.setUnlocalizedName("superDef").setTextureName("scapecraft:superdef");

		armaStaff = new Item().setUnlocalizedName("armaStaff").setTextureName("scapecraft:ArmaStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);
		guthixStaff = new Item().setUnlocalizedName("guthixStaff").setTextureName("scapecraft:GuthixStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);
		saraStaff = new Item().setUnlocalizedName("saraStaff").setTextureName("scapecraft:SaraStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);
		zammyStaff = new Item().setUnlocalizedName("zammyStaff").setTextureName("scapecraft:ZammyStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);

		GameRegistry.registerItem(santaHelmet, "santaHelmet");

		GameRegistry.registerItem(phatHelmet, "phatHelmet");

		for(Map.Entry<String, Item> item : equipmentSets.entrySet())
		{
			GameRegistry.registerItem(item.getValue(), item.getKey());
		}


		GameRegistry.registerItem(stoneHelmet, "stoneHelmet");
		GameRegistry.registerItem(stonePlatebody, "stonePlatebody");
		GameRegistry.registerItem(stonePlatelegs, "stonePlatelegs");
		GameRegistry.registerItem(stoneBoots, "stoneBoots");
		/*end armor*/

		GameRegistry.registerItem(stake, "stake");
		GameRegistry.registerItem(pitchFork, "pitchFork");

		GameRegistry.registerItem(dryMace, "dryMace");
		GameRegistry.registerItem(dryRapier, "dryRapier");
		GameRegistry.registerItem(dryLong, "dryLong");

		GameRegistry.registerItem(dragonPickaxeg, "dragonPickaxeg");

		GameRegistry.registerItem(bronzeIngot, "bronzeIngot");
		GameRegistry.registerItem(steelIngot, "steelIngot");
		GameRegistry.registerItem(mithrilIngot, "mithrilIngot");
		GameRegistry.registerItem(adamantIngot, "adamantIngot");
		GameRegistry.registerItem(runeIngot, "runeIngot");
		GameRegistry.registerItem(graniteLump, "graniteLump");
		GameRegistry.registerItem(greenDLeather, "greenDLeather");
		GameRegistry.registerItem(greenDHide, "greenDHide");
		GameRegistry.registerItem(blackDLeather, "blackDLeather");
		GameRegistry.registerItem(blackDHide, "blackDHide");
		GameRegistry.registerItem(stick, "stick");
		GameRegistry.registerItem(magicFruit, "magicFruit");
		GameRegistry.registerItem(cabbagePieUncooked, "cabbagePieUncooked");
		GameRegistry.registerItem(meatPieUncooked, "meatPieUncooked");
		GameRegistry.registerItem(applePieUncooked, "applePieUncooked");
		GameRegistry.registerItem(fishPieUncooked, "fishPieUncooked");
		GameRegistry.registerItem(cutCabbage, "cutCabbage");
		GameRegistry.registerItem(cabbagePie, "cabbagePie");
		GameRegistry.registerItem(fishPie, "fishPie");
		GameRegistry.registerItem(meatPie, "meatPie");
		GameRegistry.registerItem(applePie, "applePie");
		GameRegistry.registerItem(beer, "beer");
		GameRegistry.registerItem(questItem, "questItem");
		GameRegistry.registerItem(doorKey, "doorKey");
		GameRegistry.registerItem(scapecraftSpawnEgg, "scapecraftSpawnEgg");

		GameRegistry.registerItem(saraBrew, "saraBrew");
		GameRegistry.registerItem(superRestore, "superRestore");
		GameRegistry.registerItem(superStr, "superStr");
		GameRegistry.registerItem(superDef, "superDef");

		GameRegistry.registerItem(armaStaff, "armaStaff");
		GameRegistry.registerItem(guthixStaff, "guthixStaff");
		GameRegistry.registerItem(saraStaff, "saraStaff");
		GameRegistry.registerItem(zammyStaff, "zammyStaff");

		OreDictionary.registerOre("ingotBronze", bronzeIngot);
		OreDictionary.registerOre("ingotSteel", steelIngot);
		OreDictionary.registerOre("ingotMithril", mithrilIngot);
		OreDictionary.registerOre("ingotAdamant", adamantIngot);
		OreDictionary.registerOre("ingotRune", runeIngot);

		OreDictionary.registerOre("stickWood", new ItemStack(stick, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("stickWoodStrongOak", stick.getStackFromName("strongOak"));
		OreDictionary.registerOre("stickWoodWillow", stick.getStackFromName("willow"));
		OreDictionary.registerOre("stickWoodMaple", stick.getStackFromName("maple"));
		OreDictionary.registerOre("stickWoodYew", stick.getStackFromName("yew"));
		OreDictionary.registerOre("stickWoodMagic", stick.getStackFromName("magic"));

		try
		{
			GameRegistry.addSubstitutionAlias("minecraft:item_frame", GameRegistry.Type.ITEM, scapecraftItemFrame);
		} catch (ExistingSubstitutionException e)
		{
			e.printStackTrace();
		}

		Items.iron_ingot.setTextureName("scapecraft:ironIngot");
	}

	public static void setToolLevels(NBTTagList tools)
	{
		toolLevels = new HashMap<Item, Integer>();
		for(int i = 0; i < tools.tagCount(); i++)
		{
			NBTTagCompound tag = tools.getCompoundTagAt(i);
			Item item = GameData.getItemRegistry().getObject(tag.getString("string"));
			if(item == null)
			{
				System.out.println("Got null for " + tag.getString("string"));
				continue;
			}
			toolLevels.put(item, tag.getInteger("number"));
		}
	}
}
