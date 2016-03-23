package scapecraft.world.gen.feature;

import net.minecraft.world.World;
import scapecraft.block.ScapecraftBlocks;

import java.util.Random;

public class WorldGenWillowTree extends WorldGenScapecraft
{
	public WorldGenWillowTree(boolean doBlockNotify)
	{
		super(doBlockNotify);
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		int height = rand.nextInt(4) + 5;
		for(int yOffset = 0; yOffset <= height; yOffset++)
		{
			setBlock(world, x, y + yOffset, z, ScapecraftBlocks.willowLog, 0, ScapecraftBlocks.willowTreeSpawn);
		}
		setBlocks(world, x - 1, y + height + 1, z - 1, x + 1, y + height + 1, z + 1, ScapecraftBlocks.willowLeaves);
		for(int yOffset = 1; yOffset <= height; yOffset++) 
		{
			for(int xOffset = -2; xOffset <= 2; xOffset++)
			{
				for(int zOffset = -2; zOffset <= 2; zOffset++)
				{
					if(rand.nextInt(height - yOffset + 1) < 2 && world.getBlock(x + xOffset, y + yOffset, z + zOffset).isReplaceable(world, x + xOffset, y + yOffset, z + zOffset))
					{
						setBlock(world, x + xOffset, y + yOffset, z + zOffset, ScapecraftBlocks.willowLeaves, 0);
					}
				}
			}
		}
		return true;
	}
}
