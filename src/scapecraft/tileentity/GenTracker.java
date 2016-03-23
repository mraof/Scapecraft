package scapecraft.tileentity;

import net.minecraft.block.Block;

/**
 * Created by mraof on 2016 March 02.
 */
public interface GenTracker
{
    void addSpawnedBlock(Block block, int x, int y, int z);
}
