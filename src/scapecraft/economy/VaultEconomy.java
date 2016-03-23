package scapecraft.economy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.UUID;

public class VaultEconomy implements Economy
{
	private Object economy;
	private Method getOfflinePlayerMethod;
	private Method getBalanceMethod;
	private Method depositPlayerMethod;
	private Method bankBalanceMethod;
	private Method bankDepositMethod;
	private Field balanceField;
	private Field amountField;

	@SuppressWarnings("unchecked")
	public VaultEconomy() throws Throwable
	{
		Class<?> bukkitClass = Class.forName("org.bukkit.Bukkit");
		Object servicesManager = Class.forName("org.bukkit.Server").getMethod("getServicesManager").invoke(bukkitClass.getMethod("getServer").invoke(null));
		for(Class<?> clazz : (Collection<Class<?>>) servicesManager.getClass().getMethod("getKnownServices").invoke(servicesManager))
		{
			if ("net.milkbowl.vault.economy.Economy".equals(clazz.getCanonicalName()))
			{
				//economy = clazz.cast(org.bukkit.Bukkit.getServer().getServicesManager().getRegistration(clazz).getProvider()); What it's doing with less reflection
				Object registration = servicesManager.getClass().getMethod("getRegistration", Class.class).invoke(servicesManager, clazz);
				economy = clazz.cast(registration.getClass().getMethod("getProvider").invoke(registration));

				getOfflinePlayerMethod = bukkitClass.getMethod("getOfflinePlayer", UUID.class);
				getBalanceMethod = clazz.getMethod("getBalance", Class.forName("org.bukkit.OfflinePlayer"));
				depositPlayerMethod = clazz.getMethod("depositPlayer", Class.forName("org.bukkit.OfflinePlayer"), double.class);
				bankBalanceMethod = clazz.getMethod("bankBalance", String.class);
				bankDepositMethod = clazz.getMethod("bankDeposit", String.class, double.class);
				Class<?> econResponseClass = bankBalanceMethod.getReturnType();
				balanceField = econResponseClass.getField("balance");
				amountField = econResponseClass.getField("amount");
				break;
			}
		}
	}

	@Override
	public double getBalance(UUID uuid)
	{
		try
		{
			return (Double) getBalanceMethod.invoke(economy, getOfflinePlayerMethod.invoke(null, uuid));
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public double deposit(UUID uuid, double amount)
	{
		try
		{
			return (Double) amountField.get(depositPlayerMethod.invoke(economy, getOfflinePlayerMethod.invoke(null, uuid), amount));
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public double getBankBalance(String bankname)
	{
		try
		{
			return (Double) balanceField.get(bankBalanceMethod.invoke(economy, bankname));
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public double depositBank(String bankname, double amount)
	{
		try
		{
			return (Double) amountField.get(bankDepositMethod.invoke(economy, bankname, amount));
		} catch (Exception e) {
			return 0;
		}
	}
}
