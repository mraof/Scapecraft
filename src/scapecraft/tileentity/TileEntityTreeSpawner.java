package scapecraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

/**
 * Created by mraof on 2016 January 23.
 * Same as the standard block spawner, but stores a list of blocks created by the spawner
 */
public class TileEntityTreeSpawner extends TileEntityBlockSpawner implements GenTracker
{
    public ArrayList<BlockPos> spawnedBlocks = new ArrayList<BlockPos>();
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        NBTTagList blockTagList = new NBTTagList();
        for(BlockPos pos : spawnedBlocks)
        {
            blockTagList.appendTag(new NBTTagIntArray(new int[]{pos.getX(), pos.getY(), pos.getZ()}));
        }
        compound.setTag("spawnedBlocks", blockTagList);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        spawnedBlocks.clear();
        NBTTagList blockTagList = compound.getTagList("spawnedBlocks", 11);
        for(int i = 0; i < blockTagList.tagCount(); i++)
        {
            int[] pos = blockTagList.getIntArrayAt(i);
            spawnedBlocks.add(new BlockPos(pos[0], pos[1], pos[2]));
        }
    }

    @Override
    public void addSpawnedBlock(Block block, BlockPos pos)
    {
        //System.out.println(block + " " + x + " " + y + " " + z);
        spawnedBlocks.add(pos);
        //System.out.println(spawnedBlocks);
    }

    public BlockPos removeSpawnedBlock(Block block)
    {
        System.out.println(block + " " + spawnedBlocks.size());
        if(block != null)
        {
            for (int i = spawnedBlocks.size() - 1; i >= 0; i--)
            {
                BlockPos pos = spawnedBlocks.get(i);
                if(this.worldObj.getBlockState(pos).getBlock() == block)
                {
                    return spawnedBlocks.remove(i);
                }
            }
        }
        else if(spawnedBlocks.size() > 0)
        {
            return spawnedBlocks.remove(spawnedBlocks.size() - 1);
        }
        return null;
    }
}
