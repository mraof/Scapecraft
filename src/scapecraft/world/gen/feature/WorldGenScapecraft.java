package scapecraft.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import scapecraft.tileentity.GenTracker;

public abstract class WorldGenScapecraft extends WorldGenerator
{
	public GenTracker genTracker = null;
	public WorldGenScapecraft(boolean doBlockNotify)
	{
		super(doBlockNotify);
	}

	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		world.setBlock(x, y, z, block, metadata, 3);
		System.out.println(genTracker);
		if(genTracker != null)
		{
			genTracker.addSpawnedBlock(block, x, y, z);
		}
	}

	public void setBlock(World world, int x, int y, int z, Block block, int metadata, Block dontReplace)
	{
		if(world.getBlock(x, y, z) != dontReplace)
		{
			world.setBlock(x, y, z, block, metadata, 3);
			System.out.println(genTracker);
			if (genTracker != null)
			{
				genTracker.addSpawnedBlock(block, x, y, z);
			}
		}
	}

	public void setBlocks(World world, int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, Block block)
	{
		this.setBlocks(world, xMin, yMin, zMin, xMax, yMax, zMax, block, 0, false);
	}

	public void setBlocks(World world, int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, Block block, int metadata)
	{
		this.setBlocks(world, xMin, yMin, zMin, xMax, yMax, zMax, block, metadata, false);
	}

	public void setBlocks(World world, int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, Block block, int metadata, boolean replace)
	{
		for(int x = xMin; x <= xMax; x++)
		{
			for (int z = zMin; z <= zMax; z++)
			{
				for (int y = yMin; y <= yMax; y++)
				{
					if (world.getBlock(x, y, z).isReplaceable(world, x, y, z))
					{
						setBlock(world, x, y, z, block, metadata);
					}
				}
			}
		}
	}
}
