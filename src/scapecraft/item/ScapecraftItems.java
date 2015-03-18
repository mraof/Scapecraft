package scapecraft.item;

import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import scapecraft.Scapecraft;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

public class ScapecraftItems
{
	public static HashMap<Item, Integer> toolLevels;
	public static Item santaHelmet;

	public static Item phatHelmet;

	public static Item wphatHelmet;

	public static Item yphatHelmet;

	public static Item gphatHelmet;

	public static Item rphatHelmet;

	public static Item pphatHelmet;

	public static Item dragonFullHelm;

	public static Item dragonHelmet;
	public static Item dragonChestplate;
	public static Item dragonLeggings;
	public static Item dragonBoots;

	public static Item blackHelmet;
	public static Item blackChestplate;
	public static Item blackLeggings;
	public static Item blackBoots;

	public static Item whiteHelmet;
	public static Item whiteChestplate;
	public static Item whiteLeggings;
	public static Item whiteBoots;

	public static Item guardChestplate;

	public static Item bronzeHelmet;
	public static Item bronzeChestplate;
	public static Item bronzeLeggings;
	public static Item bronzeBoots;

	public static Item mithHelmet;
	public static Item mithChestplate;
	public static Item mithLeggings;
	public static Item mithBoots;

	public static Item addyHelmet;
	public static Item addyChestplate;
	public static Item addyLeggings;
	public static Item addyBoots;

	public static Item runeHelmet;
	public static Item runeChestplate;
	public static Item runeLeggings;
	public static Item runeBoots;

	public static Item runegHelmet;
	public static Item runegChestplate;
	public static Item runegLeggings;
	public static Item runegBoots;

	public static Item graniteHelmet;
	public static Item graniteChestplate;
	public static Item graniteLeggings;
	public static Item graniteBoots;

	public static Item blackgHelmet;
	public static Item blackgChestplate;
	public static Item blackgLeggings;
	public static Item blackgBoots;

	public static Item toragHelmet;
	public static Item toragChestplate;
	public static Item toragLeggings;
	public static Item toragBoots;

	public static Item veracHelmet;
	public static Item veracChestplate;
	public static Item veracLeggings;
	public static Item veracBoots;

	public static Item guthanHelmet;
	public static Item guthanChestplate;
	public static Item guthanLeggings;
	public static Item guthanBoots;

	public static Item dharokHelmet;
	public static Item dharokChestplate;
	public static Item dharokLeggings;
	public static Item dharokBoots;

	public static Item karilHelmet;
	public static Item karilChestplate;
	public static Item karilLeggings;
	public static Item karilBoots;

	public static Item ahrimHelmet;
	public static Item ahrimChestplate;
	public static Item ahrimLeggings;
	public static Item ahrimBoots;

	public static Item akrisaeHelmet;
	public static Item akrisaeChestplate;
	public static Item akrisaeLeggings;
	public static Item akrisaeBoots;


	public static Item greendHelmet;
	public static Item greendChestplate;
	public static Item greendLeggings;
	public static Item greendBoots;

	public static Item blackdHelmet;
	public static Item blackdChestplate;
	public static Item blackdLeggings;
	public static Item blackdBoots;


	public static Item dragonlHelmet;
	public static Item dragonlChestplate;
	public static Item dragonlLeggings;
	public static Item dragonlBoots;

	public static Item bandosHelmet;
	public static Item bandosChestplate;
	public static Item bandosLeggings;
	public static Item bandosBoots;
	public static Item stoneHelmet;
	public static Item stoneChestplate;
	public static Item stoneLeggings;
	public static Item stoneBoots;


	public static Item dragonCHelmet;
	public static Item dragonCChestplate;
	public static Item dragonCLeggings;
	public static Item dragonCBoots;

	public static Item neitiznotHelmet;
	/*end armor*/

	public static Item bronzeSword;
	public static Item mithSword;
	public static Item addySword;
	public static Item runeSword;
	public static Item blackSword;
	public static Item whiteSword;
	public static Item blackHalberd;
	public static Item chicken;
	public static Item keris;
	public static Item korasis;
	public static Item stake;
	public static Item cutlass;
	public static Item dragon2hSword;
	public static Item dragonLongsword;
	public static Item dragonCScimmy;
	public static Item pitchFork;
	public static Item fremSword;
	public static Item fremSwordf;
	public static Item chaoticRapier;
	public static Item chaoticMaul;
	public static Item chaoticLongsword;

	public static Item bronzeHammer;
	public static Item ironHammer;
	public static Item mithHammer;
	public static Item addyHammer;
	public static Item runeHammer;

	public static Item dryMace;
	public static Item dryRapier;
	public static Item dryLong;

	public static Item whip;
	public static Item dragonScimmy;
	public static Item DBA;
	public static Item DD;
	public static Item DDS;
	public static Item saraSword;
	public static Item vestaSword;
	public static Item AGS;
	public static Item BGS;
	public static Item SGS;
	public static Item ZGS;

	public static Item toragHammer;
	public static Item veracFlail;
	public static Item guthanSpear;
	public static Item dharokAxe;
	public static Item akrisaeMace;

	public static Item bronzeShovel;
	public static Item mithShovel;
	public static Item addyShovel;
	public static Item runeShovel;
	public static Item dragonShovel;
	public static Item bronzePickaxe;
	public static Item mithPickaxe;
	public static Item addyPickaxe;
	public static Item runePickaxe;
	public static Item dragonPickaxe;
	public static Item dragonPickaxeg;
	public static Item bronzeAxe;
	public static Item mithAxe;
	public static Item addyAxe;
	public static Item runeAxe;
	public static Item dragonAxe;
	public static Item bronzeHoe;
	public static Item mithHoe;
	public static Item addyHoe;
	public static Item runeHoe;
	public static Item dragonHoe;

	public static Item bronzeLump;
	public static Item mithLump;
	public static Item addyLump;
	public static Item runeLump;
	public static Item bronzeIngot;
	public static Item mithIngot;
	public static Item addyIngot;
	public static Item runeIngot;
	public static Item graniteLump;
	public static Item greenDLeather;
	public static Item greenDHide;
	public static Item blackDLeather;
	public static Item blackDHide;
	public static Item yewStick;
	public static Item magicStick;
	public static Item magicFruit;
	public static Item cabbagePieUncooked;
	public static Item meatPieUncooked;
	public static Item applePieUncooked;
	public static Item fishPieUncooked;
	public static Item cutCabbage;
	public static Item cabbagePie;
	public static Item fishPie;
	public static Item meatPie;
	public static Item applePie;
	public static Item beer;
	public static Item shard1;
	public static Item shard2;
	public static Item shard3;
	public static Item ratTail;
	public static Item note1;
	public static Item note2;
	public static Item questPoint;
	public static Item questPoint1;
	public static Item questPoint2;
	public static Item questPoint3;
	public static Item armadylHilt;
	public static Item bandosHilt;
	public static Item saradominHilt;
	public static Item zamorakHilt;
	public static Item hilt;
	public static Item veracKey;
	public static Item toragKey;
	public static Item dharokKey;
	public static Item karilKey;
	public static Item ahrimKey;
	public static Item guthanKey;
	public static Item akrisaeKey;
	public static Item tombKey;
	public static Item scapecraftSpawnEgg;
	public static Item bandosTab;
	public static Item barrowsTab;
	public static Item cathTab;
	public static Item faladorTab;
	public static Item hubTab;
	public static Item lumbridgeTab;
	public static Item tormentedDemonsTab;
	public static Item varrockTeletab;
	public static Item doorKey;
	public static Item boltRack;
	public static Item garlic;
	public static Item invincibilityPotion;

	public static Item yewBow;
	public static Item magicBow;
	public static Item darkBow;
	public static Item crystalBow;
	public static Item karilBow;

	public static Item saraBrew;
	public static Item superRestore;
	public static Item superStr;
	public static Item superDef;
	public static Item specPot;

	public static Item cracker;

	public static Item ahrimStaff;
 	public static Item armaStaff;
 	public static Item guthixStaff;
 	public static Item saraStaff;
 	public static Item zammyStaff;

	public static void registerItems()
	{

		santaHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.SANTA, 0, 0, "santa");

		phatHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.PHAT, 0, 0, "phat");

		wphatHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.WPHAT, 0, 0, "whitephat");

		yphatHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.YPHAT, 0, 0, "yellowphat");

		gphatHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.GPHAT, 0, 0, "greenphat");

		rphatHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.RPHAT, 0, 0, "redphat");

		pphatHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.PPHAT, 0, 0, "purplephat");

		dragonFullHelm = new ItemArmorScapecraft(ScapecraftArmorMaterial.DRAGON, 0, 0, "dragonFull");

		dragonHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.DRAGON, 0, 0, "dragon");
		dragonChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.DRAGON, 1, 1, "dragon");
		dragonLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.DRAGON, 2, 2, "dragon");
		dragonBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.DRAGON, 3, 3, "dragon");

		blackHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACK, 0, 0, "black");
		blackChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACK, 1, 1, "black");
		blackLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACK, 2, 2, "black");
		blackBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACK, 3, 3, "black");

		whiteHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.WHITE, 0, 0, "white");
		whiteChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.WHITE, 1, 1, "white");
		whiteLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.WHITE, 2, 2, "white");
		whiteBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.WHITE, 3, 3, "white");

		guardChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.BRONZE, 1, 1, "guard");

		bronzeHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.BRONZE, 0, 0, "bronze");
		bronzeChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.BRONZE, 1, 1, "bronze");
		bronzeLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.BRONZE, 2, 2, "bronze");
		bronzeBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.BRONZE, 3, 3, "bronze");

		mithHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.MITH, 0, 0, "mith");
		mithChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.MITH, 1, 1, "mith");
		mithLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.MITH, 2, 2, "mith");
		mithBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.MITH, 3, 3, "mith");

		addyHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.ADDY, 0, 0, "addy");
		addyChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.ADDY, 1, 1, "addy");
		addyLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.ADDY, 2, 2, "addy");
		addyBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.ADDY, 3, 3, "addy");

		runeHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.RUNE, 0, 0, "rune");
		runeChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.RUNE, 1, 1, "rune");
		runeLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.RUNE, 2, 2, "rune");
		runeBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.RUNE, 3, 3, "rune");

		runegHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.RUNEG, 0, 0, "runeg");
		runegChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.RUNEG, 1, 1, "runeg");
		runegLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.RUNEG, 2, 2, "runeg");
		runegBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.RUNEG, 3, 3, "runeg");

		graniteHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.GRANITE, 0, 0, "granite");
		graniteChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.GRANITE, 1, 1, "granite");
		graniteLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.GRANITE, 2, 2, "granite");
		graniteBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.GRANITE, 3, 3, "granite");

		blackgHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACKG, 0, 0, "blackg");
		blackgChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACKG, 1, 1, "blackg");
		blackgLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACKG, 2, 2, "blackg");
		blackgBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACKG, 3, 3, "blackg");

		toragHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.TORAG, 0, 0, "Torag");
		toragChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.TORAG, 1, 1, "Torag");
		toragLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.TORAG, 2, 2, "Torag");
		toragBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.TORAG, 3, 3, "Torag");

		veracHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.VERAC, 0, 0, "Verac");
		veracChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.VERAC, 1, 1, "Verac");
		veracLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.VERAC, 2, 2, "Verac");
		veracBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.VERAC, 3, 3, "Verac");

		guthanHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.GUTHAN, 0, 0, "Guthan");
		guthanChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.GUTHAN, 1, 1, "Guthan");
		guthanLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.GUTHAN, 2, 2, "Guthan");
		guthanBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.GUTHAN, 3, 3, "Guthan");

		dharokHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.DHAROK, 0, 0, "Dharok");
		dharokChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.DHAROK, 1, 1, "Dharok");
		dharokLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.DHAROK, 2, 2, "Dharok");
		dharokBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.DHAROK, 3, 3, "Dharok");

		karilHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.KARIL, 0, 0, "Karil");
		karilChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.KARIL, 1, 1, "Karil");
		karilLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.KARIL, 2, 2, "Karil");
		karilBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.KARIL, 3, 3, "Karil");

		ahrimHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.AHRIM, 0, 0, "Ahrim");
		ahrimChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.AHRIM, 1, 1, "Ahrim");
		ahrimLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.AHRIM, 2, 2, "Ahrim");
		ahrimBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.AHRIM, 3, 3, "Ahrim");

		akrisaeHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.AKRISAE, 0, 0, "Akrisae");
		akrisaeChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.AKRISAE, 1, 1, "Akrisae");
		akrisaeLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.AKRISAE, 2, 2, "Akrisae");
		akrisaeBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.AKRISAE, 3, 3, "Akrisae");


		greendHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.GREEND, 0, 0, "greend");
		greendChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.GREEND, 1, 1, "greend");
		greendLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.GREEND, 2, 2, "greend");
		greendBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.GREEND, 3, 3, "greend");

		blackdHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACKD, 0, 0, "blackd");
		blackdChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACKD, 1, 1, "blackd");
		blackdLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACKD, 2, 2, "blackd");
		blackdBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.BLACKD, 3, 3, "blackd");


		dragonlHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.DRAGONL, 0, 0, "dragonl");
		dragonlChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.DRAGONL, 1, 1, "dragonl");
		dragonlLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.DRAGONL, 2, 2, "dragonl");
		dragonlBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.DRAGONL, 3, 3, "dragonl");

		bandosHelmet = new ItemArmorBandos(ScapecraftArmorMaterial.BANDOS, 0, 0, "Bandos");
		bandosChestplate = new ItemArmorBandos(ScapecraftArmorMaterial.BANDOS, 1, 1, "Bandos");
		bandosLeggings = new ItemArmorBandos(ScapecraftArmorMaterial.BANDOS, 2, 2, "Bandos");
		bandosBoots = new ItemArmorBandos(ScapecraftArmorMaterial.BANDOS, 3, 3, "Bandos");
		stoneHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.STONE, 0, 0, "stone");
		stoneChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.STONE, 1, 1, "stone");
		stoneLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.STONE, 2, 2, "stone");
		stoneBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.STONE, 3, 3, "stone");


		dragonCHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.CDRAGON, 0, 0, "dragonC");
		dragonCChestplate = new ItemArmorScapecraft(ScapecraftArmorMaterial.CDRAGON, 1, 1, "dragonC");
		dragonCLeggings = new ItemArmorScapecraft(ScapecraftArmorMaterial.CDRAGON, 2, 2, "dragonC");
		dragonCBoots = new ItemArmorScapecraft(ScapecraftArmorMaterial.CDRAGON, 3, 3, "dragonC");

		neitiznotHelmet = new ItemArmorScapecraft(ScapecraftArmorMaterial.NEIT, 0, 0, "neitiznot");
		/*end armor*/

		bronzeSword = new ItemWeapon(ScapecraftToolMaterial.BRONZE, 4, "BronzeSword");
		mithSword = new ItemWeapon(ScapecraftToolMaterial.MITH, 4, "MithSword");
		addySword = new ItemWeapon(ScapecraftToolMaterial.ADDY, 4, "AddySword");
		runeSword = new ItemWeapon(ScapecraftToolMaterial.RUNE, 4, "RuneSword");
		blackSword = new ItemWeapon(ScapecraftToolMaterial.BLACK, 4, "BlackSword");
		whiteSword = new ItemWeapon(ScapecraftToolMaterial.BLACK, 4, "WhiteSword");
		blackHalberd = new ItemWeapon(ScapecraftToolMaterial.BLACKH, 4, "BlackHalberd");
		chicken = new ItemWeapon(ScapecraftToolMaterial.CHICKEN, 4, "Chicken");
		keris = new ItemWeapon(ScapecraftToolMaterial.KERIS, 4, "Keris");
		korasis = new ItemWeapon(ScapecraftToolMaterial.KORASIS, 4, "KorasiSword");
		stake = new ItemWeapon(ScapecraftToolMaterial.STAKE, 4, "Stake");
		dragon2hSword = new ItemWeapon(ScapecraftToolMaterial.WHIP, 4, "Dragon2hSword");
		dragonLongsword = new ItemWeapon(ScapecraftToolMaterial.DRAGON, 4, "DragonLongsword");
		dragonCScimmy = new ItemWeapon(ScapecraftToolMaterial.DRAGONC, 4, "DragonCScimmy");
		pitchFork = new ItemWeapon(ScapecraftToolMaterial.PITCHFORK, 4, "PitchFork");
		fremSword = new ItemWeapon(ScapecraftToolMaterial.FREM, 4, "FremSword");
		fremSwordf = new ItemWeapon(ScapecraftToolMaterial.FREMF, 4, "FremSwordf");
		chaoticRapier = new ItemWeapon(ScapecraftToolMaterial.CHAOTIC, 4F, "ChaoticRapier");
		chaoticMaul = new ItemWeapon(ScapecraftToolMaterial.CHAOTIC, 11F, "ChaoticMaul");
		chaoticLongsword = new ItemWeapon(ScapecraftToolMaterial.CHAOTIC, 7F, "ChaoticLongsword");

		cutlass = new ItemCutlass();

		bronzeHammer = new ItemHammer(ScapecraftToolMaterial.BRONZE, "BronzeHammer");
		ironHammer = new ItemHammer(ScapecraftToolMaterial.IRON, "IronHammer");
		mithHammer = new ItemHammer(ScapecraftToolMaterial.MITH, "MithHammer");
		addyHammer = new ItemHammer(ScapecraftToolMaterial.ADDY, "AddyHammer");
		runeHammer = new ItemHammer(ScapecraftToolMaterial.RUNE, "RuneHammer");

		dryMace = new ItemDryWeapon(5F, "DryMace");
		dryRapier = new ItemDryWeapon(10F, "DryRapier");
		dryLong = new ItemDryWeapon(15F, "DryLong");

		whip = new ItemSpecialWeapon(ScapecraftToolMaterial.WHIP, 4F, "Whip", 50);
		dragonScimmy = new ItemSpecialWeapon(ScapecraftToolMaterial.DRAGONS, 4, "DragonScimmy", 55);
		DBA = new ItemSpecialWeapon(ScapecraftToolMaterial.DRAGONB, 4, "DragonBattleAxe", 99);
		DD = new ItemSpecialWeapon(ScapecraftToolMaterial.DRAGOND, 4, "DragonDagger", 25);
		DDS = new ItemSpecialWeapon(ScapecraftToolMaterial.DRAGONDS, 4, "DragonDaggerS", 25);
		saraSword = new ItemSpecialWeapon(ScapecraftToolMaterial.SS, 4, "SaraSword", 99);
		vestaSword = new ItemSpecialWeapon(ScapecraftToolMaterial.VESTA, 4, "Vesta", 25);
		AGS = new ItemSpecialWeapon(ScapecraftToolMaterial.AGS, 4, "ArmadylGodsword", 50);
		BGS = new ItemSpecialWeapon(ScapecraftToolMaterial.BGS, 4, "BandosGodsword", 99);
		SGS = new ItemSpecialWeapon(ScapecraftToolMaterial.SGS, 4, "SaradominGodsword", 55);
		ZGS = new ItemSpecialWeapon(ScapecraftToolMaterial.ZGS, 4, "ZamorakGodsword", 75);

		toragHammer = new ItemSetWeapon(ScapecraftToolMaterial.TORAG, ScapecraftArmorMaterial.TORAG, "ToragHammer");
		veracFlail = new ItemSetWeapon(ScapecraftToolMaterial.VERAC, ScapecraftArmorMaterial.VERAC, "VeracFlail");
		guthanSpear = new ItemSetWeapon(ScapecraftToolMaterial.GUTHAN, ScapecraftArmorMaterial.GUTHAN, "GuthanSpear");
		dharokAxe = new ItemSetWeapon(ScapecraftToolMaterial.DHAROK, ScapecraftArmorMaterial.DHAROK, "DharokAxe");
		akrisaeMace = new ItemSetWeapon(ScapecraftToolMaterial.AKRISAE, ScapecraftArmorMaterial.AKRISAE, "AkrisaeMace");
		bronzeShovel = new ItemScapecraftShovel(ScapecraftToolMaterial.BRONZE).setTextureName("scapecraft:BronzeShovel");
		mithShovel = new ItemScapecraftShovel(ScapecraftToolMaterial.MITH).setTextureName("scapecraft:MithShovel");
		addyShovel = new ItemScapecraftShovel(ScapecraftToolMaterial.ADDY).setTextureName("scapecraft:AddyShovel");
		runeShovel = new ItemScapecraftShovel(ScapecraftToolMaterial.RUNE).setTextureName("scapecraft:RuneShovel");
		dragonShovel = new ItemScapecraftShovel(ScapecraftToolMaterial.DRAGON).setTextureName("scapecraft:DragonShovel");
		bronzePickaxe = new ItemScapecraftPickaxe(ScapecraftToolMaterial.BRONZE).setTextureName("scapecraft:BronzePickaxe");
		mithPickaxe = new ItemScapecraftPickaxe(ScapecraftToolMaterial.MITH).setTextureName("scapecraft:MithPickaxe");
		addyPickaxe = new ItemScapecraftPickaxe(ScapecraftToolMaterial.ADDY).setTextureName("scapecraft:AddyPickaxe");
		runePickaxe = new ItemScapecraftPickaxe(ScapecraftToolMaterial.RUNE).setTextureName("scapecraft:RunePickaxe");
		dragonPickaxe = new ItemScapecraftPickaxe(ScapecraftToolMaterial.DRAGON).setTextureName("scapecraft:DragonPickaxe");
		dragonPickaxeg = new ItemScapecraftPickaxe(ScapecraftToolMaterial.DRAGONG).setTextureName("scapecraft:DragonPickaxeg");
		runePickaxe = new ItemScapecraftPickaxe(ScapecraftToolMaterial.RUNE).setTextureName("scapecraft:RunePickaxe");
		bronzeAxe = new ItemScapecraftAxe(ScapecraftToolMaterial.BRONZE).setTextureName("scapecraft:BronzeAxe");
		mithAxe = new ItemScapecraftAxe(ScapecraftToolMaterial.MITH).setTextureName("scapecraft:MithAxe");
		addyAxe = new ItemScapecraftAxe(ScapecraftToolMaterial.ADDY).setTextureName("scapecraft:AddyAxe");
		runeAxe = new ItemScapecraftAxe(ScapecraftToolMaterial.RUNE).setTextureName("scapecraft:RuneAxe");
		dragonAxe = new ItemScapecraftAxe(ScapecraftToolMaterial.DRAGON).setTextureName("scapecraft:DragonAxe");
		bronzeHoe = new ItemScapecraftHoe(ScapecraftToolMaterial.BRONZE).setTextureName("scapecraft:BronzeHoe");
		mithHoe = new ItemScapecraftHoe(ScapecraftToolMaterial.MITH).setTextureName("scapecraft:MithHoe");
		addyHoe = new ItemScapecraftHoe(ScapecraftToolMaterial.ADDY).setTextureName("scapecraft:AddyHoe");
		runeHoe = new ItemScapecraftHoe(ScapecraftToolMaterial.RUNE).setTextureName("scapecraft:RuneHoe");
		dragonHoe = new ItemScapecraftHoe(ScapecraftToolMaterial.DRAGON).setTextureName("scapecraft:DragonHoe");

		bronzeLump = new Item().setTextureName("scapecraft:BronzeLump").setUnlocalizedName("bronzeLump").setCreativeTab(Scapecraft.tabScapecraftMisc);
		mithLump = new Item().setTextureName("scapecraft:MithLump").setUnlocalizedName("mithLump").setCreativeTab(Scapecraft.tabScapecraftMisc);
		addyLump = new Item().setTextureName("scapecraft:AddyLump").setUnlocalizedName("addyLump").setCreativeTab(Scapecraft.tabScapecraftMisc);
		runeLump = new Item().setTextureName("scapecraft:RuneLump").setUnlocalizedName("runeLump").setCreativeTab(Scapecraft.tabScapecraftMisc);
		bronzeIngot = new Item().setTextureName("scapecraft:BronzeIngot").setUnlocalizedName("bronzeIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);
		mithIngot = new Item().setTextureName("scapecraft:MithIngot").setUnlocalizedName("mithIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);
		addyIngot = new Item().setTextureName("scapecraft:AddyIngot").setUnlocalizedName("addyIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);
		runeIngot = new Item().setTextureName("scapecraft:RuneIngot").setUnlocalizedName("runeIngot").setCreativeTab(Scapecraft.tabScapecraftMisc);
		graniteLump = new Item().setUnlocalizedName("graniteLump").setTextureName("scapecraft:GraniteLump").setCreativeTab(Scapecraft.tabScapecraftMisc);
		greenDLeather = new Item().setUnlocalizedName("greenDLeather").setTextureName("scapecraft:GreenDLeather").setCreativeTab(Scapecraft.tabScapecraftMisc);
		greenDHide = new Item().setUnlocalizedName("greenDHide").setTextureName("scapecraft:GreenDHide").setCreativeTab(Scapecraft.tabScapecraftMisc);
		blackDLeather = new Item().setUnlocalizedName("blackDLeather").setTextureName("scapecraft:BlackDLeather").setCreativeTab(Scapecraft.tabScapecraftMisc);
		blackDHide = new Item().setUnlocalizedName("blackDHide").setTextureName("scapecraft:BlackDHide").setCreativeTab(Scapecraft.tabScapecraftMisc);
		yewStick = new Item().setUnlocalizedName("yewStick").setTextureName("scapecraft:YewStick").setCreativeTab(Scapecraft.tabScapecraftMisc);
		magicStick = new Item().setUnlocalizedName("magicStick").setTextureName("scapecraft:MagicStick").setCreativeTab(Scapecraft.tabScapecraftMisc);
		magicFruit = new ItemFood(20, false).setUnlocalizedName("magicFruit").setTextureName("scapecraft:MagicFruit").setCreativeTab(Scapecraft.tabScapecraftMisc);
		cabbagePieUncooked = new Item().setUnlocalizedName("cabbagePieUncooked").setTextureName("scapecraft:CabbagePie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		meatPieUncooked = new Item().setUnlocalizedName("meatPieUncooked").setTextureName("scapecraft:MeatPie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		applePieUncooked = new Item().setUnlocalizedName("applePieUncooked").setTextureName("scapecraft:ApplePie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		fishPieUncooked = new Item().setUnlocalizedName("fishPieUncooked").setTextureName("scapecraft:FishPie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		cutCabbage = new ItemFood(2, true).setAlwaysEdible().setUnlocalizedName("cutCabbage").setTextureName("scapecraft:CutCabbage").setCreativeTab(Scapecraft.tabScapecraftMisc);
		cabbagePie = new ItemScapecraftFood(3).setAlwaysEdible().setUnlocalizedName("cabbagePie").setTextureName("scapecraft:CabbagePie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		fishPie = new ItemScapecraftFood(12).setAlwaysEdible().setUnlocalizedName("fishPie").setTextureName("scapecraft:FishPie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		meatPie = new ItemScapecraftFood(5).setAlwaysEdible().setUnlocalizedName("meatPie").setTextureName("scapecraft:MeatPie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		applePie = new ItemScapecraftFood(4).setAlwaysEdible().setUnlocalizedName("applePie").setTextureName("scapecraft:ApplePie").setCreativeTab(Scapecraft.tabScapecraftMisc);
		beer = new ItemScapecraftFood(2).setAlwaysEdible().setUnlocalizedName("beer").setTextureName("scapecraft:Beer").setCreativeTab(Scapecraft.tabScapecraftMisc);
		shard1 = new Item().setUnlocalizedName("shard1").setTextureName("scapecraft:Shard1").setCreativeTab(Scapecraft.tabScapecraftMisc);
		shard2 = new Item().setUnlocalizedName("shard2").setTextureName("scapecraft:Shard2").setCreativeTab(Scapecraft.tabScapecraftMisc);
		shard3 = new Item().setUnlocalizedName("shard3").setTextureName("scapecraft:Shard3").setCreativeTab(Scapecraft.tabScapecraftMisc);
		ratTail = new Item().setUnlocalizedName("ratTail").setTextureName("scapecraft:RatTail").setCreativeTab(Scapecraft.tabScapecraftMisc);
		note1 = new Item().setUnlocalizedName("note1").setTextureName("scapecraft:goldnote1").setCreativeTab(Scapecraft.tabScapecraftMisc);
		note2 = new Item().setUnlocalizedName("note2").setTextureName("scapecraft:goldnote2").setCreativeTab(Scapecraft.tabScapecraftMisc);
		questPoint = new Item().setUnlocalizedName("questPoint").setTextureName("scapecraft:QuestPoint").setCreativeTab(Scapecraft.tabScapecraftMisc);
		questPoint1 = new Item().setUnlocalizedName("questPoint1").setTextureName("scapecraft:QuestPoint").setCreativeTab(Scapecraft.tabScapecraftMisc);
		questPoint2 = new Item().setUnlocalizedName("questPoint2").setTextureName("scapecraft:QuestPoint").setCreativeTab(Scapecraft.tabScapecraftMisc);
		questPoint3 = new Item().setUnlocalizedName("questPoint3").setTextureName("scapecraft:QuestPoint").setCreativeTab(Scapecraft.tabScapecraftMisc);
		armadylHilt = new Item().setUnlocalizedName("armadylHilt").setTextureName("scapecraft:ArmadylHilt").setCreativeTab(Scapecraft.tabScapecraftMisc);
		bandosHilt = new Item().setUnlocalizedName("bandosHilt").setTextureName("scapecraft:BandosHilt").setCreativeTab(Scapecraft.tabScapecraftMisc);
		saradominHilt = new Item().setUnlocalizedName("saradominHilt").setTextureName("scapecraft:SaradominHilt").setCreativeTab(Scapecraft.tabScapecraftMisc);
		zamorakHilt = new Item().setUnlocalizedName("zamorakHilt").setTextureName("scapecraft:ZamorakHilt").setCreativeTab(Scapecraft.tabScapecraftMisc);
		hilt = new Item().setUnlocalizedName("hilt").setTextureName("scapecraft:Hilt").setCreativeTab(Scapecraft.tabScapecraftMisc);
		veracKey = new Item().setUnlocalizedName("veracKey").setTextureName("scapecraft:Key1").setCreativeTab(Scapecraft.tabScapecraftMisc);
		toragKey = new Item().setUnlocalizedName("toragKey").setTextureName("scapecraft:Key1").setCreativeTab(Scapecraft.tabScapecraftMisc);
		dharokKey = new Item().setUnlocalizedName("dharokKey").setTextureName("scapecraft:Key1").setCreativeTab(Scapecraft.tabScapecraftMisc);
		karilKey = new Item().setUnlocalizedName("karilKey").setTextureName("scapecraft:Key1").setCreativeTab(Scapecraft.tabScapecraftMisc);
		ahrimKey = new Item().setUnlocalizedName("ahrimKey").setTextureName("scapecraft:Key1").setCreativeTab(Scapecraft.tabScapecraftMisc);
		guthanKey = new Item().setUnlocalizedName("guthanKey").setTextureName("scapecraft:Key1").setCreativeTab(Scapecraft.tabScapecraftMisc);
		akrisaeKey = new Item().setUnlocalizedName("akrisaeKey").setTextureName("scapecraft:Key1").setCreativeTab(Scapecraft.tabScapecraftMisc);
		tombKey = new Item().setUnlocalizedName("tombKey").setTextureName("scapecraft:Key2").setCreativeTab(Scapecraft.tabScapecraftMisc);
		doorKey = new Item().setUnlocalizedName("doorKey").setTextureName("scapecraft:Key2").setCreativeTab(Scapecraft.tabScapecraftMisc);
		boltRack = new Item().setUnlocalizedName("boltRack").setTextureName("scapecraft:BoltRack").setCreativeTab(Scapecraft.tabScapecraftMisc);
		garlic = new Item().setUnlocalizedName("garlic").setTextureName("scapecraft:Garlic").setCreativeTab(Scapecraft.tabScapecraftMisc);
		invincibilityPotion = new Item().setUnlocalizedName("invincibilityPotion").setTextureName("potion_bottle_empty").setCreativeTab(Scapecraft.tabScapecraftMisc);
		scapecraftSpawnEgg = new ItemScapecraftSpawnEgg().setTextureName("minecraft:spawn_egg");

		bandosTab = new ItemTeletab("bandos").setTextureName("scapecraft:bandosTab").setUnlocalizedName("bandosTab");
		barrowsTab = new ItemTeletab("barrows").setTextureName("scapecraft:barrowsTab").setUnlocalizedName("barrowsTab");
		cathTab = new ItemTeletab("cath").setTextureName("scapecraft:cathTab").setUnlocalizedName("cathTab");
		faladorTab = new ItemTeletab("falador").setTextureName("scapecraft:faladorTab").setUnlocalizedName("faladorTab");
		hubTab = new ItemTeletab("hub").setTextureName("scapecraft:hubTab").setUnlocalizedName("hubTab");
		lumbridgeTab = new ItemTeletab("lumbridge").setTextureName("scapecraft:lumbridgeTab").setUnlocalizedName("lumbridgeTab");
		tormentedDemonsTab = new ItemTeletab("tds").setTextureName("scapecraft:tormentedDemonsTab").setUnlocalizedName("tormentedDemonsTab");
		varrockTeletab = new ItemTeletab("varrock").setTextureName("scapecraft:varrockTab").setUnlocalizedName("varrockTab");

		yewBow = new ItemScapecraftBow(ScapecraftBowMaterial.YEW, "YewBow");
		magicBow = new ItemScapecraftBow(ScapecraftBowMaterial.MAGIC, "MagicBow");
		darkBow = new ItemScapecraftBow(ScapecraftBowMaterial.DARK, "DarkBow").setHasModel(true);
		crystalBow = new ItemScapecraftBow(ScapecraftBowMaterial.CRYSTAL, "CrystalBow");
		karilBow = new ItemScapecraftBow(ScapecraftBowMaterial.KARIL, "KarilCBow").setHasModel(true);

		saraBrew = new ItemScapecraftPotion(new PotionEffect(Potion.regeneration.id, 600, 1)).setUnlocalizedName("saraBrew").setTextureName("scapecraft:sarabrew");
		superRestore = new ItemScapecraftPotion(new PotionEffect(Potion.saturation.id, 600, 1), new PotionEffect(Potion.moveSpeed.id, 600, 0)).setUnlocalizedName("superRestore").setTextureName("scapecraft:superrestore");
		superStr = new ItemScapecraftPotion(new PotionEffect(Potion.damageBoost.id, 600, 0)).setUnlocalizedName("superStr").setTextureName("scapecraft:superstr");
		superDef = new ItemScapecraftPotion(new PotionEffect(Potion.resistance.id, 600, 1)).setUnlocalizedName("superDef").setTextureName("scapecraft:superdef");
		specPot = new ItemSpecialPotion().setUnlocalizedName("specPot").setTextureName("scapecraft:superdef");
		cracker = new ItemCracker();

		ahrimStaff = new Item().setUnlocalizedName("ahrimStaff").setTextureName("scapecraft:AhrimStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);
		armaStaff = new Item().setUnlocalizedName("armaStaff").setTextureName("scapecraft:ArmaStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);
		guthixStaff = new Item().setUnlocalizedName("guthixStaff").setTextureName("scapecraft:GuthixStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);
		saraStaff = new Item().setUnlocalizedName("saraStaff").setTextureName("scapecraft:SaraStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);
		zammyStaff = new Item().setUnlocalizedName("zammyStaff").setTextureName("scapecraft:ZammyStaff").setCreativeTab(Scapecraft.tabScapecraftWeapon);

		GameRegistry.registerItem(santaHelmet, "santaHelmet");

		GameRegistry.registerItem(phatHelmet, "phatHelmet");

		GameRegistry.registerItem(wphatHelmet, "wphatHelmet");

		GameRegistry.registerItem(yphatHelmet, "yphatHelmet");

		GameRegistry.registerItem(gphatHelmet, "gphatHelmet");

		GameRegistry.registerItem(rphatHelmet, "rphatHelmet");

		GameRegistry.registerItem(pphatHelmet, "pphatHelmet");

		GameRegistry.registerItem(dragonFullHelm, "dragonFullHelm");

		GameRegistry.registerItem(dragonHelmet, "dragonHelmet");
		GameRegistry.registerItem(dragonChestplate, "dragonChestplate");
		GameRegistry.registerItem(dragonLeggings, "dragonLeggings");
		GameRegistry.registerItem(dragonBoots, "dragonBoots");

		GameRegistry.registerItem(blackHelmet, "blackHelmet");
		GameRegistry.registerItem(blackChestplate, "blackChestplate");
		GameRegistry.registerItem(blackLeggings, "blackLeggings");
		GameRegistry.registerItem(blackBoots, "blackBoots");

		GameRegistry.registerItem(whiteHelmet, "whiteHelmet");
		GameRegistry.registerItem(whiteChestplate, "whiteChestplate");
		GameRegistry.registerItem(whiteLeggings, "whiteLeggings");
		GameRegistry.registerItem(whiteBoots, "whiteBoots");

		GameRegistry.registerItem(guardChestplate, "guardChestplate");

		GameRegistry.registerItem(bronzeHelmet, "bronzeHelmet");
		GameRegistry.registerItem(bronzeChestplate, "bronzeChestplate");
		GameRegistry.registerItem(bronzeLeggings, "bronzeLeggings");
		GameRegistry.registerItem(bronzeBoots, "bronzeBoots");

		GameRegistry.registerItem(mithHelmet, "mithHelmet");
		GameRegistry.registerItem(mithChestplate, "mithChestplate");
		GameRegistry.registerItem(mithLeggings, "mithLeggings");
		GameRegistry.registerItem(mithBoots, "mithBoots");

		GameRegistry.registerItem(addyHelmet, "addyHelmet");
		GameRegistry.registerItem(addyChestplate, "addyChestplate");
		GameRegistry.registerItem(addyLeggings, "addyLeggings");
		GameRegistry.registerItem(addyBoots, "addyBoots");

		GameRegistry.registerItem(runeHelmet, "runeHelmet");
		GameRegistry.registerItem(runeChestplate, "runeChestplate");
		GameRegistry.registerItem(runeLeggings, "runeLeggings");
		GameRegistry.registerItem(runeBoots, "runeBoots");

		GameRegistry.registerItem(runegHelmet, "runegHelmet");
		GameRegistry.registerItem(runegChestplate, "runegChestplate");
		GameRegistry.registerItem(runegLeggings, "runegLeggings");
		GameRegistry.registerItem(runegBoots, "runegBoots");

		GameRegistry.registerItem(graniteHelmet, "graniteHelmet");
		GameRegistry.registerItem(graniteChestplate, "graniteChestplate");
		GameRegistry.registerItem(graniteLeggings, "graniteLeggings");
		GameRegistry.registerItem(graniteBoots, "graniteBoots");

		GameRegistry.registerItem(blackgHelmet, "blackgHelmet");
		GameRegistry.registerItem(blackgChestplate, "blackgChestplate");
		GameRegistry.registerItem(blackgLeggings, "blackgLeggings");
		GameRegistry.registerItem(blackgBoots, "blackgBoots");

		GameRegistry.registerItem(toragHelmet, "toragHelmet");
		GameRegistry.registerItem(toragChestplate, "toragChestplate");
		GameRegistry.registerItem(toragLeggings, "toragLeggings");
		GameRegistry.registerItem(toragBoots, "toragBoots");

		GameRegistry.registerItem(veracHelmet, "veracHelmet");
		GameRegistry.registerItem(veracChestplate, "veracChestplate");
		GameRegistry.registerItem(veracLeggings, "veracLeggings");
		GameRegistry.registerItem(veracBoots, "veracBoots");

		GameRegistry.registerItem(guthanHelmet, "guthanHelmet");
		GameRegistry.registerItem(guthanChestplate, "guthanChestplate");
		GameRegistry.registerItem(guthanLeggings, "guthanLeggings");
		GameRegistry.registerItem(guthanBoots, "guthanBoots");

		GameRegistry.registerItem(dharokHelmet, "dharokHelmet");
		GameRegistry.registerItem(dharokChestplate, "dharokChestplate");
		GameRegistry.registerItem(dharokLeggings, "dharokLeggings");
		GameRegistry.registerItem(dharokBoots, "dharokBoots");

		GameRegistry.registerItem(karilHelmet, "karilHelmet");
		GameRegistry.registerItem(karilChestplate, "karilChestplate");
		GameRegistry.registerItem(karilLeggings, "karilLeggings");
		GameRegistry.registerItem(karilBoots, "karilBoots");

		GameRegistry.registerItem(ahrimHelmet, "ahrimHelmet");
		GameRegistry.registerItem(ahrimChestplate, "ahrimChestplate");
		GameRegistry.registerItem(ahrimLeggings, "ahrimLeggings");
		GameRegistry.registerItem(ahrimBoots, "ahrimBoots");

		GameRegistry.registerItem(akrisaeHelmet, "akrisaeHelmet");
		GameRegistry.registerItem(akrisaeChestplate, "akrisaeChestplate");
		GameRegistry.registerItem(akrisaeLeggings, "akrisaeLeggings");
		GameRegistry.registerItem(akrisaeBoots, "akrisaeBoots");


		GameRegistry.registerItem(greendHelmet, "greendHelmet");
		GameRegistry.registerItem(greendChestplate, "greendChestplate");
		GameRegistry.registerItem(greendLeggings, "greendLeggings");
		GameRegistry.registerItem(greendBoots, "greendBoots");

		GameRegistry.registerItem(blackdHelmet, "blackdHelmet");
		GameRegistry.registerItem(blackdChestplate, "blackdChestplate");
		GameRegistry.registerItem(blackdLeggings, "blackdLeggings");
		GameRegistry.registerItem(blackdBoots, "blackdBoots");

		GameRegistry.registerItem(dragonlHelmet, "dragonlHelmet");
		GameRegistry.registerItem(dragonlChestplate, "dragonlChestplate");
		GameRegistry.registerItem(dragonlLeggings, "dragonlLeggings");
		GameRegistry.registerItem(dragonlBoots, "dragonlBoots");

		GameRegistry.registerItem(bandosHelmet, "bandosHelmet");
		GameRegistry.registerItem(bandosChestplate, "bandosChestplate");
		GameRegistry.registerItem(bandosLeggings, "bandosLeggings");
		GameRegistry.registerItem(bandosBoots, "bandosBoots");
		GameRegistry.registerItem(stoneHelmet, "stoneHelmet");
		GameRegistry.registerItem(stoneChestplate, "stoneChestplate");
		GameRegistry.registerItem(stoneLeggings, "stoneLeggings");
		GameRegistry.registerItem(stoneBoots, "stoneBoots");

		GameRegistry.registerItem(dragonCHelmet, "dragonCHelmet");
		GameRegistry.registerItem(dragonCChestplate, "dragonCChestplate");
		GameRegistry.registerItem(dragonCLeggings, "dragonCLeggings");
		GameRegistry.registerItem(dragonCBoots, "dragonCBoots");

		GameRegistry.registerItem(neitiznotHelmet, "neitiznotHelmet");
		/*end armor*/

		GameRegistry.registerItem(bronzeSword, "bronzeSword");
		GameRegistry.registerItem(mithSword, "mithSword");
		GameRegistry.registerItem(addySword, "addySword");
		GameRegistry.registerItem(runeSword, "runeSword");
		GameRegistry.registerItem(blackSword, "blackSword");
		GameRegistry.registerItem(whiteSword, "whiteSword");
		GameRegistry.registerItem(blackHalberd, "blackHalberd");
		GameRegistry.registerItem(chicken, "chicken");
		GameRegistry.registerItem(keris, "keris");
		GameRegistry.registerItem(korasis, "korasis");
		GameRegistry.registerItem(stake, "stake");
		GameRegistry.registerItem(dragon2hSword, "dragon2hSword");
		GameRegistry.registerItem(dragonLongsword, "dragonLongsword");
		GameRegistry.registerItem(dragonCScimmy, "dragonCScimmy");
		GameRegistry.registerItem(pitchFork, "pitchFork");
		GameRegistry.registerItem(fremSword, "fremSword");
		GameRegistry.registerItem(fremSwordf, "fremSwordf");
		GameRegistry.registerItem(chaoticRapier, "chaoticRapier");
		GameRegistry.registerItem(chaoticMaul, "chaoticMaul");
		GameRegistry.registerItem(chaoticLongsword, "chaoticLongsword");

		GameRegistry.registerItem(cutlass, "cutlass");

		GameRegistry.registerItem(bronzeHammer, "bronzeHammer");
		GameRegistry.registerItem(ironHammer, "ironHammer");
		GameRegistry.registerItem(mithHammer, "mithHammer");
		GameRegistry.registerItem(addyHammer, "addyHammer");
		GameRegistry.registerItem(runeHammer, "runeHammer");

		GameRegistry.registerItem(dryMace, "dryMace");
		GameRegistry.registerItem(dryRapier, "dryRapier");
		GameRegistry.registerItem(dryLong, "dryLong");

		GameRegistry.registerItem(whip, "whip");
		GameRegistry.registerItem(dragonScimmy, "dragonScimmy");
		GameRegistry.registerItem(DBA, "DBA");
		GameRegistry.registerItem(DD, "DD");
		GameRegistry.registerItem(DDS, "DDS");
		GameRegistry.registerItem(saraSword, "saraSword");
		GameRegistry.registerItem(vestaSword, "vestaSword");
		GameRegistry.registerItem(AGS, "AGS");
		GameRegistry.registerItem(BGS, "BGS");
		GameRegistry.registerItem(SGS, "SGS");
		GameRegistry.registerItem(ZGS, "ZGS");

		GameRegistry.registerItem(toragHammer, "toragHammer");
		GameRegistry.registerItem(veracFlail, "veracFlail");
		GameRegistry.registerItem(guthanSpear, "guthanSpear");
		GameRegistry.registerItem(dharokAxe, "dharokAxe");
		GameRegistry.registerItem(akrisaeMace, "akrisaeMace");
		GameRegistry.registerItem(bronzeShovel, "bronzeShovel");
		GameRegistry.registerItem(mithShovel, "mithShovel");
		GameRegistry.registerItem(addyShovel, "addyShovel");
		GameRegistry.registerItem(runeShovel, "runeShovel");
		GameRegistry.registerItem(dragonShovel, "dragonShovel");
		GameRegistry.registerItem(bronzePickaxe, "bronzePickaxe");
		GameRegistry.registerItem(mithPickaxe, "mithPickaxe");
		GameRegistry.registerItem(addyPickaxe, "addyPickaxe");
		GameRegistry.registerItem(runePickaxe, "runePickaxe");
		GameRegistry.registerItem(dragonPickaxe, "dragonPickaxe");
		GameRegistry.registerItem(dragonPickaxeg, "dragonPickaxeg");
		GameRegistry.registerItem(bronzeAxe, "bronzeAxe");
		GameRegistry.registerItem(mithAxe, "mithAxe");
		GameRegistry.registerItem(addyAxe, "addyAxe");
		GameRegistry.registerItem(runeAxe, "runeAxe");
		GameRegistry.registerItem(dragonAxe, "dragonAxe");
		GameRegistry.registerItem(bronzeHoe, "bronzeHoe");
		GameRegistry.registerItem(mithHoe, "mithHoe");
		GameRegistry.registerItem(addyHoe, "addyHoe");
		GameRegistry.registerItem(runeHoe, "runeHoe");
		GameRegistry.registerItem(dragonHoe, "dragonHoe");

		GameRegistry.registerItem(bronzeLump, "bronzeLump");
		GameRegistry.registerItem(mithLump, "mithLump");
		GameRegistry.registerItem(addyLump, "addyLump");
		GameRegistry.registerItem(runeLump, "runeLump");
		GameRegistry.registerItem(bronzeIngot, "bronzeIngot");
		GameRegistry.registerItem(mithIngot, "mithIngot");
		GameRegistry.registerItem(addyIngot, "addyIngot");
		GameRegistry.registerItem(runeIngot, "runeIngot");
		GameRegistry.registerItem(graniteLump, "graniteLump");
		GameRegistry.registerItem(greenDLeather, "greenDLeather");
		GameRegistry.registerItem(greenDHide, "greenDHide");
		GameRegistry.registerItem(blackDLeather, "blackDLeather");
		GameRegistry.registerItem(blackDHide, "blackDHide");
		GameRegistry.registerItem(yewStick, "yewStick");
		GameRegistry.registerItem(magicStick, "magicStick");
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
		GameRegistry.registerItem(shard1, "shard1");
		GameRegistry.registerItem(shard2, "shard2");
		GameRegistry.registerItem(shard3, "shard3");
		GameRegistry.registerItem(ratTail, "ratTail");
		GameRegistry.registerItem(note1, "note1");
		GameRegistry.registerItem(note2, "note2");
		GameRegistry.registerItem(questPoint, "questPoint");
		GameRegistry.registerItem(questPoint1, "questPoint1");
		GameRegistry.registerItem(questPoint2, "questPoint2");
		GameRegistry.registerItem(questPoint3, "questPoint3");
		GameRegistry.registerItem(armadylHilt, "armadylHilt");
		GameRegistry.registerItem(bandosHilt, "bandosHilt");
		GameRegistry.registerItem(saradominHilt, "saradominHilt");
		GameRegistry.registerItem(zamorakHilt, "zamorakHilt");
		GameRegistry.registerItem(hilt, "hilt");
		GameRegistry.registerItem(veracKey, "veracKey");
		GameRegistry.registerItem(toragKey, "toragKey");
		GameRegistry.registerItem(dharokKey, "dharokKey");
		GameRegistry.registerItem(karilKey, "karilKey");
		GameRegistry.registerItem(ahrimKey, "ahrimKey");
		GameRegistry.registerItem(guthanKey, "guthanKey");
		GameRegistry.registerItem(akrisaeKey, "akrisaeKey");
		GameRegistry.registerItem(tombKey, "tombKey");
		GameRegistry.registerItem(doorKey, "doorKey");
		GameRegistry.registerItem(boltRack, "boltRack");
		GameRegistry.registerItem(garlic, "garlic");
		GameRegistry.registerItem(invincibilityPotion, "invincibilityPotion");
		GameRegistry.registerItem(scapecraftSpawnEgg, "scapecraftSpawnEgg");
		GameRegistry.registerItem(bandosTab, "bandosTab");
		GameRegistry.registerItem(barrowsTab, "barrowsTab");
		GameRegistry.registerItem(cathTab, "cathTab");
		GameRegistry.registerItem(faladorTab, "faladorTab");
		GameRegistry.registerItem(hubTab, "hubTab");
		GameRegistry.registerItem(lumbridgeTab, "lumbridgeTab");
		GameRegistry.registerItem(tormentedDemonsTab, "tormentedDemonsTab");
		GameRegistry.registerItem(varrockTeletab, "varrockTeletab");

		GameRegistry.registerItem(yewBow, "yewBow");
		GameRegistry.registerItem(magicBow, "magicBow");
		GameRegistry.registerItem(darkBow, "darkBow");
		GameRegistry.registerItem(crystalBow, "crystalBow");
		GameRegistry.registerItem(karilBow, "karilBow");

		GameRegistry.registerItem(saraBrew, "saraBrew");
		GameRegistry.registerItem(superRestore, "superRestore");
		GameRegistry.registerItem(superStr, "superStr");
		GameRegistry.registerItem(superDef, "superDef");
		GameRegistry.registerItem(specPot, "specPot");

		GameRegistry.registerItem(cracker, "cracker");

		GameRegistry.registerItem(ahrimStaff, "ahrimStaff"); 
		GameRegistry.registerItem(armaStaff, "armaStaff"); 
		GameRegistry.registerItem(guthixStaff, "guthixStaff"); 
		GameRegistry.registerItem(saraStaff, "saraStaff"); 
		GameRegistry.registerItem(zammyStaff, "zammyStaff");
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
