package scapecraft.block;

import net.minecraft.block.Block;
import scapecraft.util.Stat;

/**
 * Created by mraof on 2016 March 02.
 */
public class BlockCropSpawner extends BlockBlockSpawner
{
    public BlockCropSpawner(Block fullBlock, int regenTime, int xp)
    {
        super(fullBlock, regenTime, xp);
        this.stat = Stat.FARMING;
        this.fullSize = 7;
        this.fullMeta = 7;
    }
}
