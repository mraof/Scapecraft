package scapecraft.compat;

import scapecraft.compat.dynmap.DynmapHandler;

/**
 * Created by mraof on 2016 February 05.
 * Class for compatibility with other mods
 */
public class Compat
{
    public static boolean dynmap = false;
    public static void loadCompatibility()
    {
        try
        {
            Class.forName("org.dynmap.DynmapCommonAPIListener");
            System.out.println("Dynmap found");
            (new DynmapHandler()).init();
        } catch (Throwable e)
        {
            System.out.println("Dynmap not found");
            //e.printStackTrace();
        }
    }
}
