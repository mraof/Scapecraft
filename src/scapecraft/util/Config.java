package scapecraft.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import org.apache.commons.lang3.ArrayUtils;

import scapecraft.Scapecraft;
import scapecraft.entity.Drop;
import scapecraft.entity.EntityScapecraft;
import scapecraft.entity.ScapecraftEntities;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

//Config class the won't be changed by ConfigPacket
public class Config
{
	public static Configuration config;
	public static boolean requireLevels = true;
	public static NBTTagList blockLevels;
	public static NBTTagList toolLevels;
	public static HashMap<String, ArrayList<Integer>> spawnBlocks;
	public static int dungeonDimensionId;
	public static int dungeonProviderId;
	public static boolean useConfigDrops = false;

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
			"Scapecraft:mithOre 50",
			"diamond_ore 40",
			"redstone_ore 40",
			"Scapecraft:addyOre 60",
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
			/*"Scapecraft:blackPickaxe 20",
			  "Scapecraft:whitePickaxe 20",*/ //Don't have these yet
			"Scapecraft:mithPickaxe 30",
			"Scapecraft:addyPickaxe 40",
			"Scapecraft:runePickaxe 50",
			"Scapecraft:dragonPickaxe 60",
			"Scapecraft:dragonPickaxeg 70",
			"iron_axe 10",
			"Scapecraft:blackAxe 20",
			"Scapecraft:whiteAxe 20",
			"Scapecraft:mithAxe 30",
			"Scapecraft:addyAxe 40",
			"Scapecraft:runeAxe 50",
			"Scapecraft:dragonAxe 60",
		}, "Levels required to use tools", stringIntPair));

		//TODO make ConfigPacket send these
		Scapecraft.dungeonDimensionId = dungeonDimensionId = config.getInt("dungeonDimensionId", "Dimensions", 27, -128, 500, "Dimension Id of dungeon dimension");
		Scapecraft.dungeonProviderId = dungeonProviderId = config.getInt("dungeonProviderId", "Dimensions", 27, -128, 500, "Provider Id of dungeon dimension");
		useConfigDrops = config.getBoolean("useConfigDrops", "Mobs", false, "Use drops from the configuration file instead of the default ones, setting to false resets to the default");

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

	@SuppressWarnings("unchecked")
	public static void loadDrops()
	{
		if(!useConfigDrops)
		{
			ScapecraftEntities.addDrops();
		}

		Configuration mobConfig = new Configuration(new File(config.getConfigFile().getParentFile(), "ScapecraftMobs.cfg"));
		mobConfig.load();
		for(String entityName : ScapecraftEntities.entities)
		{
			entityName = entityName.toLowerCase();
			String[] drops;
			if(EntityScapecraft.drops.get(ScapecraftEntities.entityNames.get(entityName)) != null)
			{
				drops = new String[EntityScapecraft.drops.get(ScapecraftEntities.entityNames.get(entityName)).size()];
			}
			else
			{
				drops = new String[] {};
			}
			for(int i = 0; i < drops.length; i++)
			{
				Drop drop = EntityScapecraft.drops.get(ScapecraftEntities.entityNames.get(entityName)).get(i);
				drops[i] = drop.chance + " " + GameRegistry.findUniqueIdentifierFor(drop.stack.getItem()) + " " + drop.stack.stackSize + " " + drop.stack.getMetadata();
			}
			Pattern dropPattern = Pattern.compile("^\\d+ .*[ \\d*,][ \\d*,]$");
			drops = mobConfig.get(entityName, "Drops", drops, "Item drops for the mob (format: rarity item count metadata)", dropPattern).getStringList();
			int[] moneyDrops = {};
			if(EntityScapecraft.moneyDrops.get(ScapecraftEntities.entityNames.get(entityName)) != null)
			{
				moneyDrops = ArrayUtils.toPrimitive((Integer[]) EntityScapecraft.moneyDrops.get(ScapecraftEntities.entityNames.get(entityName)).toArray());
			}
			moneyDrops = mobConfig.get(entityName, "moneyDrops", moneyDrops, "Money drops for the mob").getIntList();
			if(useConfigDrops)
			{
				Class<? extends EntityScapecraft> entityClass = (Class<? extends EntityScapecraft>) ScapecraftEntities.entityNames.get(entityName);
				for(String dropString : drops)
				{
					String[] dropArgs = dropString.split(" ");
					int chance = Integer.parseInt(dropArgs[0]);
					Item item = GameData.getItemRegistry().getObject(dropArgs[1]);
					int stackSize = 1;
					int metadata = 0;
					if(dropArgs.length >= 3)
					{
						stackSize = Integer.parseInt(dropArgs[2]);
						if(dropArgs.length >= 4)
						{
							metadata = Integer.parseInt(dropArgs[3]);
						}
					}
					if(item != null)
					{
						EntityScapecraft.addDrop(entityClass, chance, new ItemStack(item, stackSize, metadata));
					}
					else
					{
						System.out.println("Invalid item in " + dropString);
					}
				}
				EntityScapecraft.setMoney(entityClass, ArrayUtils.toObject(moneyDrops));

			}
		}
		mobConfig.save();
	}
}
