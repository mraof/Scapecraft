package scapecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import scapecraft.Scapecraft;
import scapecraft.entity.Drop;
import scapecraft.entity.ScapecraftEntities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

//Config class the won't be changed by ConfigPacket
public class Config
{
	public static Configuration config;
	public static boolean requireLevels = true;
	public static NBTTagList blockLevels;
	public static NBTTagList toolLevels;
	public static int dungeonDimensionId;
	public static int dungeonProviderId;
	public static boolean useConfigDrops = false;
	public static double multiplier = 0;
	//Defaults
	public static HashMap<Class<? extends Entity>, ArrayList<Drop>> drops = new HashMap<Class<? extends Entity>, ArrayList<Drop>>();
	public static HashMap<Class<? extends Entity>, int[]> moneyDrops = new HashMap<Class<? extends Entity>, int[]>();

	public static void loadConfig(Configuration config)
	{
		Config.config = config;
		config.load();
		Scapecraft.requireLevels = requireLevels = config.getBoolean("requireLevels", "Levels", true, "Use level requirements");
		Pattern stringIntPair = Pattern.compile("^.* \\d*$");
		blockLevels = readStringIntPairs(config.get("Levels", "blockLevels", new String[] {
			"iron_ore 10",
			"Scapecraft:bluriteOre 10",
			"coal_ore 25",
			"Scapecraft:mithrilOre 50",
			"diamond_ore 40",
			"redstone_ore 40",
			"Scapecraft:adamantOre 60",
			"Scapecraft:runeOre 70",
			"emerald_ore 70",
			"Scapecraft:strongOakLog 15",
			"Scapecraft:willowLog 30",
			"Scapecraft:mapleLog 45",
			"Scapecraft:yewLog 60",
			"Scapecraft:magicLog 75",
		}, "Levels required to break blocks", stringIntPair));
		toolLevels = readStringIntPairs(config.get("Levels", "toolLevels", new String[] {
			"iron_pickaxe 10",
			"Scapecraft:blackPickaxe 20",
			  "Scapecraft:whitePickaxe 20", //Don't have these yet
			"Scapecraft:mithrilPickaxe 30",
			"Scapecraft:adamantPickaxe 40",
			"Scapecraft:runePickaxe 50",
			"Scapecraft:dragonPickaxe 60",
			"Scapecraft:dragonPickaxeg 70",
			"iron_axe 10",
			"Scapecraft:blackAxe 20",
			"Scapecraft:whiteAxe 20",
			"Scapecraft:mithrilAxe 30",
			"Scapecraft:adamantAxe 40",
			"Scapecraft:runeAxe 50",
			"Scapecraft:dragonAxe 60",
		}, "Levels required to use tools", stringIntPair));

		//TODO make ConfigPacket send these
		Scapecraft.dungeonDimensionId = dungeonDimensionId = config.getInt("dungeonDimensionId", "Dimensions", 27, -128, 500, "Dimension Id of dungeon dimension");
		Scapecraft.dungeonProviderId = dungeonProviderId = config.getInt("dungeonProviderId", "Dimensions", 27, -128, 500, "Provider Id of dungeon dimension");
		useConfigDrops = config.getBoolean("useConfigDrops", "Mobs", false, "Use drops from the configuration file instead of the default ones, setting to false resets to the default");
		multiplier = config.getFloat("multiplier", "Levels", 1, 0.01F, 100F, "Multiplier for xp per level");

		config.save();

	}

	private static NBTTagList readStringIntPairs(Property prop)
	{
		NBTTagList tagList = new NBTTagList();
		for(String value : prop.getStringList())
		{
			String[] pair = value.split(" ");
			NBTTagCompound tagCompound = new NBTTagCompound();
			tagCompound.setString("string", pair[0]);
			System.out.printf("From \"%s\", \"%s\" is \"%s\", parsed as %d\n", value, pair[0], pair[1], Integer.parseInt(pair[1]));
			tagCompound.setInteger("number", Integer.parseInt(pair[1]));
			tagList.appendTag(tagCompound);
		}
		return tagList;
	}

	public static void loadDrops(NBTTagCompound nbt)
	{
		ScapecraftEntities.addDrops();
		drops.putAll(ScapecraftEntities.drops);
		moneyDrops.putAll(ScapecraftEntities.moneyDrops);
		NBTTagList dropList = nbt.getTagList("drops", nbt.getId());
		for(int i = 0; i < dropList.tagCount(); i++)
		{
			NBTTagCompound tagCompound = dropList.getCompoundTagAt(i);
			Class<? extends Entity> mobClass = ScapecraftEntities.entityNames.get(tagCompound.getString("name").toLowerCase());
			if(mobClass != null)
			{
				NBTTagList currentDrops = tagCompound.getTagList("drops", nbt.getId());
				ArrayList<Drop> drops = new ArrayList<Drop>();
				for(int j = 0; j < currentDrops.tagCount(); j++)
				{
					drops.add(Drop.fromNBT(currentDrops.getCompoundTagAt(j)));
				}
				ScapecraftEntities.setDrops(mobClass, drops);
			}
		}
		NBTTagList moneyList = nbt.getTagList("money", nbt.getId());
		for(int i = 0; i < moneyList.tagCount(); i++)
		{
			NBTTagCompound tagCompound = moneyList.getCompoundTagAt(i);
			Class<? extends Entity> mobClass = ScapecraftEntities.entityNames.get(tagCompound.getString("name").toLowerCase());
			if(mobClass != null)
			{
				ScapecraftEntities.setMoney(mobClass, moneyList.getIntArrayAt(i));
			}
		}
	}

	public static void saveDrops(NBTTagCompound nbt)
	{
		NBTTagList dropList = new NBTTagList();
		HashMap<Class<? extends Entity>, String> classNames = new HashMap<Class<? extends Entity>, String>();
		for (Map.Entry<String, Class<? extends Entity>> entry : ScapecraftEntities.entityNames.entrySet())
		{
			classNames.put(entry.getValue(), entry.getKey());
		}
		for (Map.Entry<Class<? extends Entity>, ArrayList<Drop>> entry : ScapecraftEntities.drops.entrySet())
		{
			String name = classNames.get(entry.getKey());
			NBTTagCompound tagCompound = new NBTTagCompound();
			NBTTagList currentDrops = new NBTTagList();
			for(Drop drop : entry.getValue())
			{
				currentDrops.appendTag(drop.toNBT());
			}
			if(!entry.getValue().equals(drops.get(entry)))
			{
				tagCompound.setString("name", name);
				tagCompound.setTag("drops", currentDrops);
				dropList.appendTag(tagCompound);
			}
		}
		nbt.setTag("drops", dropList);
		NBTTagList moneyList = new NBTTagList();
		for(Map.Entry<Class<? extends Entity>, int[]> entry : ScapecraftEntities.moneyDrops.entrySet())
		{
			if(moneyDrops.get(entry.getKey()) != entry.getValue())
			{
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setString("name", classNames.get(entry.getKey()));
				tagCompound.setIntArray("money", entry.getValue());
				moneyList.appendTag(tagCompound);
			}
		}
		nbt.setTag("money", moneyList);
	}
}
