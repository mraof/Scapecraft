package scapecraft.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;
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
