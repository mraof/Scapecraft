package scapecraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChunkCoordinates;

import java.util.ArrayList;

/**
 * Created by mraof on 2016 January 23.
 * Same as the standard block spawner, but stores a list of blocks created by the spawner
 */
public class TileEntityTreeSpawner extends TileEntityBlockSpawner implements GenTracker
{
    public ArrayList<ChunkCoordinates> spawnedBlocks = new ArrayList<ChunkCoordinates>();
    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        NBTTagList blockTagList = new NBTTagList();
        for(ChunkCoordinates coordinates : spawnedBlocks)
        {
            blockTagList.appendTag(new NBTTagIntArray(new int[]{coordinates.posX, coordinates.posY, coordinates.posZ}));
        }
        compound.setTag("spawnedBlocks", blockTagList);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        spawnedBlocks.clear();
        NBTTagList blockTagList = compound.getTagList("spawnedBlocks", 11);
        for(int i = 0; i < blockTagList.tagCount(); i++)
        {
            int[] coordinates = blockTagList.getIntArrayAt(i);
            spawnedBlocks.add(new ChunkCoordinates(coordinates[0], coordinates[1], coordinates[2]));
        }
    }

    @Override
    public void addSpawnedBlock(Block block, int x, int y, int z)
    {
        //System.out.println(block + " " + x + " " + y + " " + z);
        spawnedBlocks.add(new ChunkCoordinates(x, y, z));
        //System.out.println(spawnedBlocks);
    }

    public ChunkCoordinates removeSpawnedBlock(Block block)
    {
        System.out.println(block + " " + spawnedBlocks.size());
        if(block != null)
        {
            for (int i = spawnedBlocks.size() - 1; i >= 0; i--)
            {
                ChunkCoordinates coords = spawnedBlocks.get(i);
                if(this.worldObj.getBlock(coords.posX, coords.posY, coords.posZ) == block)
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
