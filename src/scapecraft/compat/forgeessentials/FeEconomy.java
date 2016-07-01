package scapecraft.compat.forgeessentials;

import com.forgeessentials.api.UserIdent;
import com.forgeessentials.api.economy.Economy;
import com.forgeessentials.api.economy.Wallet;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by mraof on 2016 March 25 at 4:34 AM.
 */
public class FeEconomy implements Economy
{
    private HashMap<UUID, ScapecraftWallet> wallets = new HashMap<UUID, ScapecraftWallet>();
    @Override
    public Wallet getWallet(UserIdent player)
    {
        if(!wallets.containsKey(player.getUuid()))
        {
            wallets.put(player.getUuid(), new ScapecraftWallet(player.getUuid()));
        }
        return wallets.get(player.getUuid());
    }

    @Override
    public String currency(long amount)
    {
        return "";
    }

    @Override
    public String toString(long amount)
    {
        return Long.toString(amount);
    }

}
