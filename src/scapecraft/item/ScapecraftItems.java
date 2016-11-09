package scapecraft.item;

import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ExistingSubstitutionException;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import scapecraft.Scapecraft;
import scapecraft.ScapecraftRecipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static net.minecraft.inventory.EntityEquipmentSlot.*;

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
		set.put(name + "Helmet", new ItemArmorScapecraft(level, damage * .15f, HEAD, name + "Helmet"));
		set.put(name + "FullHelm", new ItemArmorScapecraft(level, damage * .17f, HEAD, name + "FullHelm"));
		set.put(name + "Chainbody", new ItemArmorScapecraft(level, damage * .18f, CHEST, name + "Chainbody"));
		set.put(name + "Platebody", new ItemArmorScapecraft(level, damage * .2f, CHEST, name + "Platebody"));
		set.put(name + "Platelegs", new ItemArmorScapecraft(level, damage * .2f, LEGS, name + "Platelegs"));
		set.put(name + "Plateskirt", new ItemArmorScapecraft(level, damage * .2f, LEGS, name + "Plateskirt"));
		set.put(name + "Boots", new ItemArmorScapecraft(level, damage * .1f, FEET, name + "Boots"));
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
		bronzeIngot = new Item().setUnlocalizedName("bronzeIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);
		steelIngot = new Item().setUnlocalizedName("steelIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);
		mithrilIngot = new Item().setUnlocalizedName("mithrilIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);
		adamantIngot = new Item().setUnlocalizedName("adamantIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);
		runeIngot = new Item().setUnlocalizedName("runeIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);

		graniteLump = new Item().setUnlocalizedName("graniteLump").setCreativeTab(Scapecraft.tabScapecraftMisc);
		greenDLeather = new Item().setUnlocalizedName("greenDLeather").setCreativeTab(Scapecraft.tabScapecraftMisc);
		greenDHide = new Item().setUnlocalizedName("greenDHide").setCreativeTab(Scapecraft.tabScapecraftMisc);
		blackDLeather = new Item().setUnlocalizedName("blackDLeather").setCreativeTab(Scapecraft.tabScapecraftMisc);
		blackDHide = new Item().setUnlocalizedName("blackDHide").setCreativeTab(Scapecraft.tabScapecraftMisc);

		stick = new ItemMulti("stick");
		stick.addSubItems("strongOak", "willow", "maple", "yew", "magic");

		/*strongOakStick = new Item().setUnlocalizedName("strongOakStick").setCreativeTab(Scapecraft.tabScapecraftMisc);
		willowStick = new Item().setUnlocalizedName("willowStick").setCreativeTab(Scapecraft.tabScapecraftMisc);
		mapleStick = new Item().setUnlocalizedName("mapleStick").setCreativeTab(Scapecraft.tabScapecraftMisc);
		yewStick = new Item().setUnlocalizedName("yewStick").setCreativeTab(Scapecraft.tabScapecraftMisc);
		magicStick = new Item().setUnlocalizedName("magicStick").setCreativeTab(Scapecraft.tabScapecraftMisc);*/
		magicFruit = new ItemFood(20, false).setUnlocalizedName("magicFruit").setCreativeTab(Scapecraft.tabScapecraftMisc);
		cabbagePieUncooked = new Item().setUnlocalizedName("cabbagePieUncooked").setCreativeTab(Scapecraft.tabScapecraftMisc);
		meatPieUncooked = new Item().setUnlocalizedName("meatPieUncooked").setCreativeTab(Scapecraft.tabScapecraftMisc);
		applePieUncooked = new Item().setUnlocalizedName("applePieUncooked").setCreativeTab(Scapecraft.tabScapecraftMisc);
		fishPieUncooked = new Item().setUnlocalizedName("fishPieUncooked").setCreativeTab(Scapecraft.tabScapecraftMisc);
		cutCabbage = new ItemFood(2, true).setAlwaysEdible().setUnlocalizedName("cutCabbage").setCreativeTab(Scapecraft.tabScapecraftMisc);
		cabbagePie = new ItemScapecraftFood(5);
		cabbagePie.setAlwaysEdible().setUnlocalizedName("cabbagePie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		fishPie = new ItemScapecraftFood(20);
		fishPie.setAlwaysEdible().setUnlocalizedName("fishPie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		meatPie = new ItemScapecraftFood(15);
		meatPie.setAlwaysEdible().setUnlocalizedName("meatPie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		applePie = new ItemScapecraftFood(10);
		applePie.setAlwaysEdible().setUnlocalizedName("applePie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		beer = new ItemScapecraftFood(2);
		beer.setAlwaysEdible().setUnlocalizedName("beer").setCreativeTab(Scapecraft.tabScapecraftMisc);
		questItem = new ItemMulti("quest");
		questItem.setUnlocalizedName("questItem").setCreativeTab(Scapecraft.tabScapecraftMisc);
		questItem.addSubItems("ratTail");

		tombKey = new Item().setUnlocalizedName("tombKey").setCreativeTab(Scapecraft.tabScapecraftMisc);
		doorKey = new Item().setUnlocalizedName("doorKey").setCreativeTab(Scapecraft.tabScapecraftMisc);
		garlic = new Item().setUnlocalizedName("garlic").setCreativeTab(Scapecraft.tabScapecraftMisc);
		scapecraftSpawnEgg = new ItemScapecraftSpawnEgg();
		scapecraftItemFrame = new ItemScapecraftItemFrame();
		scapecraftItemFrame.setUnlocalizedName("frame");

		createMetalSet("bronze", 1, 5, bronzeIngot, 1);
		createMetalSet("iron", 10, Items.IRON_INGOT, 15);
		createMetalSet("steel", 20, steelIngot, 30);
		createMetalSet("white", 25, null, 0);
		createMetalSet("black", 25, null, 0);
		createMetalSet("mithril", 30, mithrilIngot, 45);
		createMetalSet("adamant", 40, adamantIngot, 60);
		createMetalSet("rune", 50, runeIngot, 75);
		createMetalSet("dragon", 60, null, 0);
		for(Item item : createMetalSet("dragonC", 60, null, 0))
		{
			item.setMaxDamage(item.getMaxDamage() / 25);
		}

		createBows("strongOak", 10, 5, Items.IRON_INGOT, 20);
		createBows("willow", 20, 5, steelIngot, 35);
		createBows("maple", 30, 5, mithrilIngot, 50);
		createBows("yew", 40, 5, adamantIngot, 65);
		createBows("magic", 50, 5, runeIngot, 80);

		equipmentSets.put("graniteHelmet", new ItemArmorScapecraft(55, 55 * .15f, HEAD, "graniteHelmet"));
		equipmentSets.put("granitePlatebody", new ItemArmorScapecraft(55, 55 * .2f, CHEST, "granitePlatebody"));
		equipmentSets.put("granitePlatelegs", new ItemArmorScapecraft(55, 55 * .2f, LEGS, "granitePlatelegs"));
		equipmentSets.put("graniteBoots", new ItemArmorScapecraft(55, 55 * .1f, FEET, "graniteBoots"));

		//Aesthetic armor
		santaHelmet = new ItemArmorScapecraft(0, 0, HEAD, "santaHelmet");

		phatHelmet = new ItemArmorColored(0, 0, HEAD, "phatHelmet")
				.addColor("white", 0xFFFFFF)
				.addColor("red", 0xFF0000)
				.addColor("yellow", 0xFFFF00)
				.addColor("orange", 0xFF9900)
				.addColor("blue", 0x0000FF)
				.addColor("green", 0x00FF00)
				.addColor("purple", 0xFF99FF)
				.addColor("cyan", 0x00FFFF)
				.addColor("black", 0x111111);

		stoneHelmet = new ItemArmorScapecraft(0, 0, HEAD, "stoneHelmet");
		stonePlatebody = new ItemArmorScapecraft(0, 0, CHEST, "stonePlatebody");
		stonePlatelegs = new ItemArmorScapecraft(0, 0, LEGS, "stonePlatelegs");
		stoneBoots = new ItemArmorScapecraft(0, 0, FEET, "stoneBoots");

		pitchFork = new ItemWeapon(6, "pitchFork", 4);
		stake = new ItemWeapon(8, "stake", 10);

		dryMace = new ItemDryWeapon(5F, "dryMace");
		dryRapier = new ItemDryWeapon(10F, "dryRapier");
		dryLong = new ItemDryWeapon(15F, "dryLong");

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
			ahrimStaff = new Item().setUnlocalizedName("ahrimStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);

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

		saraBrew = new ItemScapecraftPotion(new PotionEffect(MobEffects.REGENERATION, 600, 1));
		saraBrew.setUnlocalizedName("saraBrew");
		superRestore = new ItemScapecraftPotion(new PotionEffect(MobEffects.SATURATION, 600, 1), new PotionEffect(MobEffects.SPEED, 600, 0));
		superRestore.setUnlocalizedName("superRestore");
		superStr = new ItemScapecraftPotion(new PotionEffect(MobEffects.STRENGTH, 600, 0));
		superStr.setUnlocalizedName("superStr");
		superDef = new ItemScapecraftPotion(new PotionEffect(MobEffects.RESISTANCE, 600, 1));
		superDef.setUnlocalizedName("superDef");

		armaStaff = new Item().setUnlocalizedName("armaStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);
		guthixStaff = new Item().setUnlocalizedName("guthixStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);
		saraStaff = new Item().setUnlocalizedName("saraStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);
		zammyStaff = new Item().setUnlocalizedName("zammyStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);

		bronzeIngot.setRegistryName("bronzeIngot");
		steelIngot.setRegistryName("steelIngot");
		mithrilIngot.setRegistryName("mithrilIngot");
		adamantIngot.setRegistryName("adamantIngot");
		runeIngot.setRegistryName("runeIngot");
		graniteLump.setRegistryName("graniteLump");
		greenDLeather.setRegistryName("greenDLeather");
		greenDHide.setRegistryName("greenDHide");
		blackDLeather.setRegistryName("blackDLeather");
		blackDHide.setRegistryName("blackDHide");
		magicFruit.setRegistryName("magicFruit");
		cabbagePieUncooked.setRegistryName("cabbagePieUncooked");
		meatPieUncooked.setRegistryName("meatPieUncooked");
		applePieUncooked.setRegistryName("applePieUncooked");
		fishPieUncooked.setRegistryName("fishPieUncooked");
		cutCabbage.setRegistryName("cutCabbage");
		cabbagePie.setRegistryName("cabbagePie");
		fishPie.setRegistryName("fishPie");
		meatPie.setRegistryName("meatPie");
		applePie.setRegistryName("applePie");
		beer.setRegistryName("beer");
		doorKey.setRegistryName("doorKey");
		scapecraftSpawnEgg.setRegistryName("scapecraftSpawnEgg");

		saraBrew.setRegistryName("saraBrew");
		superRestore.setRegistryName("superRestore");
		superStr.setRegistryName("superStr");
		superDef.setRegistryName("superDef");

		armaStaff.setRegistryName("armaStaff");
		guthixStaff.setRegistryName("guthixStaff");
		saraStaff.setRegistryName("saraStaff");
		zammyStaff.setRegistryName("zammyStaff");

		GameRegistry.register(santaHelmet);

		GameRegistry.register(phatHelmet);

		for(Map.Entry<String, Item> item : equipmentSets.entrySet())
		{
			GameRegistry.register(item.getValue());
		}


		GameRegistry.register(stoneHelmet);
		GameRegistry.register(stonePlatebody);
		GameRegistry.register(stonePlatelegs);
		GameRegistry.register(stoneBoots);
		/*end armor*/

		GameRegistry.register(stake);
		GameRegistry.register(pitchFork);

		GameRegistry.register(dryMace);
		GameRegistry.register(dryRapier);
		GameRegistry.register(dryLong);

		GameRegistry.register(dragonPickaxeg);

		GameRegistry.register(stick);
		GameRegistry.register(questItem);

		GameRegistry.register(bronzeIngot);
		GameRegistry.register(steelIngot);
		GameRegistry.register(mithrilIngot);
		GameRegistry.register(adamantIngot);
		GameRegistry.register(runeIngot);
		GameRegistry.register(graniteLump);
		GameRegistry.register(greenDLeather);
		GameRegistry.register(greenDHide);
		GameRegistry.register(blackDLeather);
		GameRegistry.register(blackDHide);
		GameRegistry.register(magicFruit);
		GameRegistry.register(cabbagePieUncooked);
		GameRegistry.register(meatPieUncooked);
		GameRegistry.register(applePieUncooked);
		GameRegistry.register(fishPieUncooked);
		GameRegistry.register(cutCabbage);
		GameRegistry.register(cabbagePie);
		GameRegistry.register(fishPie);
		GameRegistry.register(meatPie);
		GameRegistry.register(applePie);
		GameRegistry.register(beer);
		GameRegistry.register(doorKey);
		GameRegistry.register(scapecraftSpawnEgg);

		GameRegistry.register(saraBrew);
		GameRegistry.register(superRestore);
		GameRegistry.register(superStr);
		GameRegistry.register(superDef);

		GameRegistry.register(armaStaff);
		GameRegistry.register(guthixStaff);
		GameRegistry.register(saraStaff);
		GameRegistry.register(zammyStaff);

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

/*		try
		{
			GameRegistry.addSubstitutionAlias("minecraft:item_frame", GameRegistry.Type.ITEM, scapecraftItemFrame);
		} catch (ExistingSubstitutionException e)
		{
			e.printStackTrace();
		}*/
	}

	public static void setToolLevels(NBTTagList tools)
	{
		toolLevels = new HashMap<Item, Integer>();
		for(int i = 0; i < tools.tagCount(); i++)
		{
			NBTTagCompound tag = tools.getCompoundTagAt(i);
			Item item = Item.REGISTRY.getObject(new ResourceLocation(tag.getString("string")));
			if(item == null)
			{
				System.out.println("Got null for " + tag.getString("string"));
				continue;
			}
			toolLevels.put(item, tag.getInteger("number"));
		}
	}
}
