package scapecraft.client.settings;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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
        if(statsKey.isPressed())
        {
            System.out.println(statsKey.getKeyDescription() + " pressed");
            FMLCommonHandler.instance().showGuiScreen(GuiStats.currentTab == 0 ? new GuiStatList() : new GuiXpSplit());
            //player.openGui(Scapecraft.instance, GuiHandler.GuiId.STATS.ordinal(), player.worldObj, 0, 0, 0);
        }
    }
}
