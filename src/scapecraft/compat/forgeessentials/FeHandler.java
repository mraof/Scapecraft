package scapecraft.compat.forgeessentials;

import com.forgeessentials.api.APIRegistry;

/**
 * Created by mraof on 2016 March 25 at 1:59 AM.
 */
public class FeHandler
{
    public void init()
    {
        APIRegistry.economy = new FeEconomy();
    }
}
