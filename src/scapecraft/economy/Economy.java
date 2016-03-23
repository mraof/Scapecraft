package scapecraft.economy;

import java.util.UUID;


public interface Economy
{
	double getBalance(UUID uuid);
	double deposit(UUID uuid, double amount);
	double getBankBalance(String bankname);
	double depositBank(String bankname, double amount);
}
