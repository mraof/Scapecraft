package scapecraft.world.gen.feature;

import net.minecraft.util.math.BlockPos;
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
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		int height = rand.nextInt(4) + 5;
		for(int yOffset = 0; yOffset <= height; yOffset++)
		{
			setBlock(world, pos.add(0, yOffset, 0), ScapecraftBlocks.willowLog.getDefaultState(), ScapecraftBlocks.willowTreeSpawn);
		}
		setBlocks(world, pos.add(0 - 1, height + 1, 0 - 1), pos.add(1, height + 1, 1), ScapecraftBlocks.willowLeaves);
		for(int yOffset = 1; yOffset <= height; yOffset++) 
		{
			for(int xOffset = -2; xOffset <= 2; xOffset++)
			{
				for(int zOffset = -2; zOffset <= 2; zOffset++)
				{
					if(rand.nextInt(height - yOffset + 1) < 2 && world.getBlockState(pos.add(xOffset, yOffset, zOffset)).getBlock().isReplaceable(world, pos.add(xOffset, yOffset, zOffset)))
					{
						setBlock(world, pos.add(xOffset, yOffset, zOffset), ScapecraftBlocks.willowLeaves.getDefaultState());
					}
				}
			}
		}
		return true;
	}
}
