package scapecraft.compat.forgeessentials;

import com.forgeessentials.api.economy.Wallet;
import scapecraft.economy.EconomyHandler;

import java.util.UUID;

/**
 * Created by mraof on 2016 March 25 at 4:38 AM.
 */
public class ScapecraftWallet implements Wallet
{
    private final UUID uuid;

    public ScapecraftWallet(UUID uuid)
    {

        this.uuid = uuid;
    }

    @Override
    public long get()
    {
        return (long) EconomyHandler.getBalance(uuid);
    }

    @Override
    public void set(long value)
    {
        EconomyHandler.deposit(uuid, -EconomyHandler.getBalance(uuid));
        EconomyHandler.deposit(uuid, value);
    }

    @Override
    public void add(long amount)
    {
        EconomyHandler.deposit(uuid, amount);
    }

    @Override
    public void add(double amount)
    {
        EconomyHandler.deposit(uuid, amount);
    }

    @Override
    public boolean covers(long value)
    {
        return EconomyHandler.getBalance(uuid) >= value;
    }

    @Override
    public boolean withdraw(long value)
    {
        if(EconomyHandler.getBalance(uuid) < value)
        {
            return false;
        }
        EconomyHandler.deposit(uuid, -value);
        return true;
    }
}
