package scapecraft.compat;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import net.minecraft.command.CommandHandler;
import scapecraft.command.SellCommand;
import scapecraft.compat.dynmap.DynmapHandler;
import scapecraft.compat.forgeessentials.FeHandler;

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
    public static void onServerStarted()
    {
        if(Loader.isModLoaded("ForgeEssentials"))
        {
            FMLCommonHandler.instance().getMinecraftServerInstance().getCommandManager().getCommands().remove("sell");
            ((CommandHandler)FMLCommonHandler.instance().getMinecraftServerInstance().getCommandManager()).registerCommand(new SellCommand());
            (new FeHandler()).init();
        }
    }
}
