package scapecraft.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.MinecraftForge;
import scapecraft.Scapecraft;
import scapecraft.event.LevelUpEvent;
import scapecraft.network.StatsPacket;

import java.util.*;

public class Stats
{
	public static final HashMap<Stat, Stats> clientStats = new HashMap<Stat, Stats>();
	public static final HashMap<UUID, HashMap<Stat, Stats>> serverStats = new HashMap<UUID, HashMap<Stat, Stats>>();
	public static final HashMap<UUID, HashMap<Stat, HashMap<Stat, Integer>>> combatSplit = new HashMap<UUID, HashMap<Stat, HashMap<Stat, Integer>>>();
	public static HashBiMap<String, UUID> uuidNames = HashBiMap.create();
	public static double multiplier = 1;
	public final long xp;
	public final int level;
	private static long xpValues[];

	public static void setXpValues(double multiplier)
	{
		Stats.multiplier = multiplier;
		ArrayList<Long> xpList = new ArrayList<Long>();
		xpList.add(0L); //level 0
		xpList.add(0L); //level 1 doesn't require any xp either
		int level = 1;
		xpList.add(10L * (long) (multiplier * ((Math.pow(1.1, level) * 100) + 5 * level - 100)));
		for(level++; xpList.get(level) > xpList.get(level - 1); level++)
		{
			xpList.add(10L * (long) (multiplier * ((Math.pow(1.1, level) * 100) + 5 * level - 100)));
		}
		xpValues = new long[xpList.size()];
		for(int i = 0; i < xpList.size(); i++)
		{
			xpValues[i] = xpList.get(i);
		}
		System.out.println(xpList + " " + Arrays.toString(xpValues));
	}
	private Stats(long xp)
	{
		this.xp = xp;
		this.level = getLevelFromXp(xp);
	}

	private static int getLevelFromXp(long xp)
	{
		int level = 0;
		while (xp >= getXpForLevel(level + 1) && level < xpValues.length - 1)
		{
			level++;
		}
		return level;
	}

	public static long getXpForLevel(int level)
	{
		return xpValues[level];
	}

	public static void addXp(EntityPlayer player, Stat stat, long amount)
	{
		if(getLevel(player, stat) < getLevelFromXp(setXp(player, stat, getXp(player, stat) + amount)))
		{
			MinecraftForge.EVENT_BUS.post(new LevelUpEvent(player, stat, getLevel(player, stat)));
		}
		uuidNames.put(player.getName(), player.getUniqueID());
		//System.out.println(player.getDisplayName() + " gained " + amount + " " + stat + " xp,and is now level " + getLevel(player, stat) + " (" + getXp(player, stat) + "xp)");
	}

	public static void addXp(UUID uuid, Stat stat, long amount)
	{
		setXp(uuid, stat, getXp(uuid, stat) + amount);
		//System.out.println(player.getDisplayName() + " gained " + amount + " " + stat + " xp,and is now level " + getLevel(player, stat) + " (" + getXp(player, stat) + "xp)");
	}

	public static int getCombatLevel(EntityPlayer player)
	{
		int attackLevel = getLevel(player, Stat.ATTACK) + getLevel(player, Stat.STRENGTH) / 2;
		if(getLevel(player, Stat.RANGED) > attackLevel)
		{
			attackLevel = getLevel(player, Stat.RANGED);
		}
		if(getLevel(player, Stat.MAGIC) > attackLevel)
		{
			attackLevel = getLevel(player, Stat.RANGED);
		}
		return (attackLevel + getLevel(player, Stat.CONSTITUTION) + getLevel(player, Stat.DEFENSE)) / 3;
	}

	public static int getLevel(EntityPlayer player, Stat stat)
	{
		if(player.worldObj.isRemote && clientStats.get(stat) != null)
		{
			return clientStats.get(stat).level;
		}
		else
		{
			uuidNames.put(player.getName(), player.getUniqueID());
			return serverStats.get(player.getUniqueID()).get(stat).level;
		}
	}

	public static int getLevel(UUID uuid, Stat stat)
	{
		return serverStats.get(uuid).get(stat).level;
	}

	public static long getXp(EntityPlayer player, Stat stat)
	{
		if(player.worldObj.isRemote && clientStats.get(stat) != null)
		{
			return clientStats.get(stat).xp;
		}
		else
		{
			uuidNames.put(player.getName(), player.getUniqueID());
			return serverStats.get(player.getUniqueID()).get(stat).xp;
		}
	}

	public static long getXp(UUID uuid, Stat stat)
	{
		return serverStats.get(uuid).get(stat).xp;
	}

	public static long setXp(EntityPlayer player, Stat stat, long amount)
	{
		System.out.println(player);
		if(player instanceof AbstractClientPlayer)
		{
			clientStats.put(stat, new Stats(amount));
		}
		else
		{
			serverStats.get(player.getUniqueID()).put(stat, new Stats(amount));
			uuidNames.put(player.getName(), player.getUniqueID());
			Scapecraft.network.sendTo(new StatsPacket(player), (EntityPlayerMP) player);
		}
		return amount;
	}

	public static long setXp(UUID uuid, Stat stat, long amount)
	{
		serverStats.get(uuid).put(stat, new Stats(amount));
		return amount;
	}

	public static void initStats(EntityPlayer player)
	{
		if(!serverStats.containsKey(player.getUniqueID()))
		{
			HashMap<Stat, Stats> stats = new HashMap<Stat, Stats>();
			for (Stat stat : Stat.values())
			{
				stats.put(stat, new Stats(0));
			}
			serverStats.put(player.getUniqueID(), stats);
		}
		if(player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).hasKey("combatxp"))
		{
			System.out.println(player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG));
			player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).removeTag("combatxp");
			player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).removeTag("combatLevel");
			serverStats.get(player.getUniqueID()).put(Stat.WOODCUTTING, new Stats(player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("woodcuttingxp")));
			player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).removeTag("woodcuttingxp");
			player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).removeTag("woodcuttingLevel");
			serverStats.get(player.getUniqueID()).put(Stat.MINING, new Stats(player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("miningxp")));
			player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).removeTag("miningxp");
			player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).removeTag("miningLevel");
			serverStats.get(player.getUniqueID()).put(Stat.AGILITY, new Stats(player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("agilityxp")));
			player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).removeTag("agilityxp");
			player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).removeTag("agilityLevel");
		}
		if(!combatSplit.containsKey(player.getUniqueID()))
		{
			setCombatSplit(player, 30, 30, 30, 30, 40, 40, 40, 40, 40, 40);
		}
		Scapecraft.network.sendTo(new StatsPacket(player), (EntityPlayerMP) player);
	}

	public static void writeToNBT(NBTTagCompound nbt)
	{
		BiMap<UUID, String> nameUUIDs = uuidNames.inverse();
		NBTTagList players = new NBTTagList();
		for(UUID uuid : serverStats.keySet())
		{
			NBTTagCompound playerCompound = new NBTTagCompound();
			playerCompound.setString("uuid", uuid.toString());
			if(nameUUIDs.containsKey(uuid))
			{
				playerCompound.setString("name", nameUUIDs.get(uuid));
			}
			NBTTagCompound statCompound = new NBTTagCompound();
			for (Stat stat : Stat.values())
			{
				statCompound.setLong(stat.toString(), serverStats.get(uuid).get(stat).xp);
			}
			playerCompound.setTag("stats", statCompound);
			if(combatSplit.containsKey(uuid))
			{
				NBTTagCompound combatSplitCompound = new NBTTagCompound();
				for (Stat type : combatSplit.get(uuid).keySet())
				{
					NBTTagCompound tagCompound = new NBTTagCompound();
					for (Map.Entry<Stat, Integer> entry : combatSplit.get(uuid).get(type).entrySet())
					{
						tagCompound.setInteger(entry.getKey().toString(), entry.getValue());
					}
					combatSplitCompound.setTag(type.toString(), tagCompound);
				}
				playerCompound.setTag("combatSplit", combatSplitCompound);
			}
			players.appendTag(playerCompound);
		}
		nbt.setTag("players", players);
	}

	public static void readFromNBT(NBTTagCompound nbt)
	{
		serverStats.clear();
		combatSplit.clear();
		NBTTagList players = nbt.getTagList("players", 10);
		for(int i = 0; i < players.tagCount(); i++)
		{
			NBTTagCompound playerCompound = players.getCompoundTagAt(i);
			NBTTagCompound statCompound = playerCompound.getCompoundTag("stats");
			UUID uuid = UUID.fromString(playerCompound.getString("uuid"));
			if(playerCompound.hasKey("name"))
			{
				uuidNames.put(playerCompound.getString("name"), uuid);
			}
			HashMap<Stat, Stats> stats = new HashMap<Stat, Stats>();
			for (Stat stat : Stat.values())
			{
				stats.put(stat, new Stats(statCompound.getLong(stat.toString())));
			}
			if(playerCompound.hasKey("combatSplit"))
			{
				HashMap<Stat, HashMap<Stat, Integer>> map = new HashMap<Stat, HashMap<Stat, Integer>>();
				NBTTagCompound combatSplitCompound = playerCompound.getCompoundTag("combatSplit");
				HashMap<Stat, Integer> currentMap = new HashMap<Stat, Integer>();
				currentMap.put(Stat.CONSTITUTION, combatSplitCompound.getCompoundTag(Stat.ATTACK.toString()).getInteger(Stat.CONSTITUTION.toString()));
				currentMap.put(Stat.ATTACK, combatSplitCompound.getCompoundTag(Stat.ATTACK.toString()).getInteger(Stat.ATTACK.toString()));
				currentMap.put(Stat.DEFENSE, combatSplitCompound.getCompoundTag(Stat.ATTACK.toString()).getInteger(Stat.DEFENSE.toString()));
				currentMap.put(Stat.STRENGTH, combatSplitCompound.getCompoundTag(Stat.ATTACK.toString()).getInteger(Stat.STRENGTH.toString()));
				map.put(Stat.ATTACK, currentMap);

				currentMap = new HashMap<Stat, Integer>();
				currentMap.put(Stat.CONSTITUTION, combatSplitCompound.getCompoundTag(Stat.RANGED.toString()).getInteger(Stat.CONSTITUTION.toString()));
				currentMap.put(Stat.RANGED, combatSplitCompound.getCompoundTag(Stat.RANGED.toString()).getInteger(Stat.RANGED.toString()));
				currentMap.put(Stat.DEFENSE, combatSplitCompound.getCompoundTag(Stat.RANGED.toString()).getInteger(Stat.DEFENSE.toString()));
				map.put(Stat.RANGED, currentMap);

				currentMap = new HashMap<Stat, Integer>();
				currentMap.put(Stat.CONSTITUTION, combatSplitCompound.getCompoundTag(Stat.MAGIC.toString()).getInteger(Stat.CONSTITUTION.toString()));
				currentMap.put(Stat.MAGIC, combatSplitCompound.getCompoundTag(Stat.MAGIC.toString()).getInteger(Stat.MAGIC.toString()));
				currentMap.put(Stat.DEFENSE, combatSplitCompound.getCompoundTag(Stat.MAGIC.toString()).getInteger(Stat.DEFENSE.toString()));
				map.put(Stat.MAGIC, currentMap);

				combatSplit.put(uuid, map);
			}

			serverStats.put(uuid, stats);
		}
	}

	public static void setCombatSplit(EntityPlayer player, int meleeConstitution, int attack, int strength, int meleeDefense, int rangedConstitution, int ranged, int rangedDefense, int magicConstitution, int magic, int magicDefense)
	{
		HashMap<Stat, HashMap<Stat, Integer>> map = new HashMap<Stat, HashMap<Stat, Integer>>();
		HashMap<Stat, Integer> attackMap = new HashMap<Stat, Integer>();
		attackMap.put(Stat.CONSTITUTION, meleeConstitution);
		attackMap.put(Stat.ATTACK, attack);
		attackMap.put(Stat.STRENGTH, strength);
		attackMap.put(Stat.DEFENSE, meleeDefense);

		HashMap<Stat, Integer> rangedMap = new HashMap<Stat, Integer>();
		rangedMap.put(Stat.CONSTITUTION, rangedConstitution);
		rangedMap.put(Stat.RANGED, ranged);
		rangedMap.put(Stat.DEFENSE, rangedDefense);

		HashMap<Stat, Integer> magicMap = new HashMap<Stat, Integer>();
		magicMap.put(Stat.CONSTITUTION, magicConstitution);
		magicMap.put(Stat.MAGIC, magic);
		magicMap.put(Stat.DEFENSE, magicDefense);

		map.put(Stat.ATTACK, attackMap);
		map.put(Stat.RANGED, rangedMap);
		map.put(Stat.MAGIC, magicMap);

		combatSplit.put(player.getUniqueID(), map);
	}

	public static void addCombatXp(EntityPlayer player, Stat type, int amount)
	{
		HashMap<Stat, Integer> map = combatSplit.get(player.getUniqueID()).get(type);
		for(Map.Entry<Stat, Integer> entry : map.entrySet())
		{
			addXp(player, entry.getKey(), amount * entry.getValue() / 120);
		}
	}

	public static int getCombatSplit(EntityPlayer player, Stat type, Stat stat)
	{
		return combatSplit.get(player.getUniqueID()).get(type).get(stat);
	}

	public static UUID getUUID(String name)
	{
		return uuidNames.get(name);
	}

	@Override
	public String toString()
	{
		return "Stats{" +
			   "xp=" + xp +
			   ", level=" + level +
			   '}';
	}
}
