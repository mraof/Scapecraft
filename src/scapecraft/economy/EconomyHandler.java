package scapecraft.economy;

import scapecraft.economy.market.Listing;

import java.util.TreeSet;
import java.util.UUID;

public class EconomyHandler
{
	private static Economy economy = null;
	public static ScapecraftEconomy scEconomy;

	public static void initEconomy()
	{
		try
		{
			economy = new VaultEconomy();
		}
		catch(Throwable e)
		{
			System.out.println("Vault not loaded");
			//e.printStackTrace();
			economy = scEconomy;
		}
	}

	public static double getBalance(UUID uuid)
	{
		if(economy == null)
		{
			return 0;
		}
		double balance = economy.getBalance(uuid);
		scEconomy.setBalance(uuid, balance);
		return balance;
	}

	public static double deposit(UUID uuid, double amount)
	{
		double balance = economy.deposit(uuid, amount);
		scEconomy.setBalance(uuid, economy.getBalance(uuid));
		return balance;
	}

	public static double getBankBalance(String bankname)
	{
		return economy.getBankBalance(bankname);
	}

	public static double depositBank(String bankname, double amount)
	{
		return economy.depositBank(bankname, amount);
	}

	public static TreeSet<Listing> getGlobalMarket()
	{
		return scEconomy.getGlobalMarket();
	}
}
