package scapecraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

/**
 * Created by mraof on 2016 March 02.
 */
public interface GenTracker
{
    void addSpawnedBlock(Block block, BlockPos pos);
}
