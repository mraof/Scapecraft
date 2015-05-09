package scapecraft.world.gen.feature;

import java.util.Random;

import net.minecraft.world.World;

import scapecraft.block.ScapecraftBlocks;

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
			world.setBlock(x, y + yOffset, z, ScapecraftBlocks.willowLog);
		setBlocks(world, x - 1, y + height + 1, z - 1, x + 1, y + height + 1, z + 1, ScapecraftBlocks.willowLeaves);
		for(int yOffset = 1; yOffset <= height; yOffset++) 
		{
			for(int xOffset = -2; xOffset <= 2; xOffset++)
			{
				for(int zOffset = -2; zOffset <= 2; zOffset++)
				{
					if(rand.nextInt(height - yOffset + 1) < 2 && world.getBlock(x + xOffset, y + yOffset, z + zOffset).isReplaceable(world, x + xOffset, y + yOffset, z + zOffset))
					{
						world.setBlock(x + xOffset, y + yOffset, z + zOffset, ScapecraftBlocks.willowLeaves);
					}
				}
			}
		}
		return true;
	}
}
