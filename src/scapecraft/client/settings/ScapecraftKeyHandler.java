package scapecraft.client.settings;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import scapecraft.client.gui.GuiStatList;
import scapecraft.client.gui.GuiStats;
import scapecraft.client.gui.GuiXpSplit;

/**
 * Created by mraof on 2016 March 02 at 5:36 PM.
 */
@SideOnly(Side.CLIENT)
public class ScapecraftKeyHandler
{
    KeyBinding statsKey;

    public ScapecraftKeyHandler()
    {
        statsKey = new KeyBinding("key.scapecraft.stats", Keyboard.KEY_R, "key.categories.scapecraft");
        ClientRegistry.registerKeyBinding(statsKey);
    }

    @SubscribeEvent
    public void onTick(InputEvent.KeyInputEvent event)
    {
        if(statsKey.getIsKeyPressed())
        {
            System.out.println(statsKey.getKeyDescription() + " pressed");
            FMLCommonHandler.instance().showGuiScreen(GuiStats.currentTab == 0 ? new GuiStatList() : new GuiXpSplit());
            //player.openGui(Scapecraft.instance, GuiHandler.GuiId.STATS.ordinal(), player.worldObj, 0, 0, 0);
        }
    }
}
