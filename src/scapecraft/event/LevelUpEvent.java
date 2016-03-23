package scapecraft.event;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;
import scapecraft.util.Stat;

/**
 * Created by mraof on 2016 March 02.
 */
public class LevelUpEvent extends Event
{
    EntityPlayer player;
    Stat stat;
    int level;

    public LevelUpEvent(EntityPlayer player, Stat stat, int level)
    {
        this.player = player;
        this.stat = stat;
        this.level = level;
    }
}
