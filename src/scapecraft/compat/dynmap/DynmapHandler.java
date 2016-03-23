package scapecraft.compat.dynmap;

import org.dynmap.DynmapCommonAPI;
import org.dynmap.DynmapCommonAPIListener;
import scapecraft.compat.Compat;

/**
 * Created by mraof on 2016 March 02.
 */
public class DynmapHandler extends DynmapCommonAPIListener
{
    public void init()
    {
        DynmapCommonAPIListener.register(this);
    }

    public static DynmapCommonAPI api = null;
    /**
     * Called when API becomes enabled, or during call to register listener if API is already enabled
     *
     * @param api - API interface (note: may be platform specific subclass, such as bukkit-specific API)
     */
    @Override
    public void apiEnabled(DynmapCommonAPI api)
    {
        DynmapHandler.api = api;
        Compat.dynmap = true;
    }
}
