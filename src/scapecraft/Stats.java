package scapecraft;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

import scapecraft.network.StatsPacket;

public class Stats
{
	public static HashMap<String, Integer> clientStats = new HashMap<String, Integer>();

	public static int getLevelFromXp(int xp)
	{
		int level = 0;
		for(;xp >= (1000 * Math.pow(1.1, level) + 50 * level - 1000); level++);
		return level;
	}
		
	public static void addXp(EntityPlayer player, String stat, int amount)
	{
		setStat(player, stat + "Level", getLevelFromXp(getStat(player, stat + "xp") + amount));
		addStat(player, stat + "xp", amount);
		System.out.println(player.getDisplayName() + " gained " + amount + " " + stat + " xp,and is now level " + getStat(player, stat + "Level") + " (" + getStat(player, stat + "xp") + "xp)");
	}

	public static void addEnergy(EntityPlayer player, int amount)
	{
		addStat(player, "energy", amount);
	}

	public static int getCombatLevel(EntityPlayer player)
	{
		return getStat(player, "combatLevel");
	}

	public static int getAgilityLevel(EntityPlayer player)
	{
		return getStat(player, "agilityLevel");
	}

	public static int getMiningLevel(EntityPlayer player)
	{
		return getStat(player, "miningLevel");
	}

	public static int getAgilityxp(EntityPlayer player)
	{
		return getStat(player, "agilityxp");
	}


	public static int getCombatxp(EntityPlayer player)
	{
		return getStat(player, "combatxp");
	}

	public static int getEnergy(EntityPlayer player)
	{
		return getStat(player, "energy");
	}
	public static int getMiningxp(EntityPlayer player)
	{
		return getStat(player, "miningxp");
	}

	public static int getStat(EntityPlayer player, String stat)
	{
		if(player.worldObj.isRemote && clientStats.get(stat) != null)
			return clientStats.get(stat);
		else
			return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger(stat);
	}

	public static void addStat(EntityPlayer player, String stat, int amount)
	{
		addStat(player, stat, amount, true);
	}

	public static void addStat(EntityPlayer player, String stat, int amount, boolean update) //Should only be used on the server
	{
		NBTTagCompound persistedNBT = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		persistedNBT.setInteger(stat, persistedNBT.getInteger(stat) + amount);
		player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistedNBT);
		if(update && !player.worldObj.isRemote)
			Scapecraft.network.sendTo(new StatsPacket(player), (EntityPlayerMP) player);
	}
	
	public static void setStat(EntityPlayer player, String stat, int amount)
	{
		if(player.worldObj.isRemote)
			clientStats.put(stat, amount);
		else
		{
			NBTTagCompound persistedNBT = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
			persistedNBT.setInteger(stat, amount);
			player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistedNBT);
		}
	}
}
