package scapecraft.economy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import scapecraft.Scapecraft;
import scapecraft.economy.market.Listing;
import scapecraft.economy.market.PlayerLister;
import scapecraft.network.MoneyPacket;

import java.util.*;

public class ScapecraftEconomy implements Economy
{
	HashMap<UUID, Double> balances = new HashMap<UUID, Double>();
	private TreeSet<Listing> listings = new TreeSet<Listing>();

	@Override
	public double getBalance(UUID uuid)
	{
		Double balance = balances.get(uuid);

		return balance == null ? 0 : balance;
	}

	public void setBalance(UUID uuid, double amount)
	{
		balances.put(uuid, amount);
		for(World world : MinecraftServer.getServer().worldServers)
		{
			EntityPlayer player;
			if((player = world.getPlayerEntityByUUID(uuid)) != null)
			{
				MoneyPacket packet = new MoneyPacket(amount);
				Scapecraft.network.sendTo(packet, (EntityPlayerMP) player);
				break;
			}
		}
	}

	@Override
	public double deposit(UUID uuid, double amount)
	{
		Double balance = balances.get(uuid);
		if(balance == null)
		{
			balance = 0D;
		}
		balances.put(uuid, balance + amount);
		return balances.get(uuid);
	}

	@Override
	public double getBankBalance(String bankname)
	{
		return 0;
	}

	@Override
	public double depositBank(String bankname, double amount)
	{
		return 0;
	}

	public void writeToNBT(NBTTagCompound tagCompound)
	{
		NBTTagList players = tagCompound.getTagList("players", 10);
		HashMap<UUID, Double> map = new HashMap<UUID, Double>(balances);
		for(int i = 0; i < players.tagCount(); i++)
		{
			NBTTagCompound playerTag = players.getCompoundTagAt(i);
			UUID uuid = UUID.fromString(playerTag.getString("uuid"));
			Double balance = map.remove(uuid);
			if(balance == null)
			{
				balance = 0D;
			}
			playerTag.setDouble("balance", balance);
		}
		for(Map.Entry<UUID, Double> entry : map.entrySet())
		{
			NBTTagCompound playerTag = new NBTTagCompound();
			playerTag.setString("uuid", entry.getKey().toString());
			playerTag.setDouble("balance", entry.getValue());
			players.appendTag(playerTag);
		}
		tagCompound.setTag("players", players);
		NBTTagList listingList = new NBTTagList();
		for(Listing listing : listings)
		{
			listingList.appendTag(listing.toNBT());
		}
		tagCompound.setTag("listings", listingList);
		//System.out.println(tagCompound);
	}

	public void readFromNBT(NBTTagCompound tagCompound)
	{
		balances = new HashMap<UUID, Double>();
		if(tagCompound.getString("version").isEmpty())
		{
			NBTTagList balancesNBT = tagCompound.getTagList("balances", Constants.NBT.TAG_COMPOUND);
			if (balancesNBT == null)
			{
				return;
			}


			for (int i = 0; i < balancesNBT.tagCount(); i++)
			{
				NBTTagCompound currentTag = balancesNBT.getCompoundTagAt(i);
				balances.put(UUID.fromString(currentTag.getString("uuid")), currentTag.getDouble("balance"));
			}
		}
		else
		{
			NBTTagList players = tagCompound.getTagList("players", 10);
			for(int i = 0; i < players.tagCount(); i++)
			{
				NBTTagCompound playerTag = players.getCompoundTagAt(i);
				setBalance(UUID.fromString(playerTag.getString("uuid")), playerTag.getDouble("balance"));
			}
		}
		System.out.println(balances);
		listings = new TreeSet<Listing>();
		NBTTagList listingList = tagCompound.getTagList("listings", 10);
		for(int i = 0; i < listingList.tagCount(); i++)
		{
			Listing listing = Listing.fromNBT(listingList.getCompoundTagAt(i));
			listing.lister = PlayerLister.fromNBT(listingList.getCompoundTagAt(i).getCompoundTag("lister"));
			listings.add(listing);
		}
	}

	public TreeSet<Listing> getGlobalMarket()
	{
		for (Iterator<? extends Listing> iterator = listings.iterator(); iterator.hasNext(); )
		{
			Listing listing = iterator.next();
			if(listing.stock <= 0)
			{
				iterator.remove();
			}
		}
		return listings;
	}
}
