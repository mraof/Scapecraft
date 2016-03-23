package scapecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
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

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta)
    {
        return fullBlock.getIcon(side, meta);
    }
}
