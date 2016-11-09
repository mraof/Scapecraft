package scapecraft.world.gen.feature;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scapecraft.block.ScapecraftBlocks;

import java.util.Random;

public class WorldGenYewTree extends WorldGenScapecraft
{
	public WorldGenYewTree(boolean doBlockNotify)
	{
		super(doBlockNotify);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		int height = rand.nextInt(4) + 5;
		for(int yOffset = 0; yOffset <= height; yOffset++)
		{
			setBlock(world, pos.add(0, yOffset, 0), ScapecraftBlocks.yewLog.getDefaultState(), ScapecraftBlocks.yewTreeSpawn);
		}
		setBlocks(world, pos.add(0 - 1, 0 + height + 1, 0 - 1), pos.add(0 + 1, 0 + height + 1, 0 + 1), ScapecraftBlocks.yewLeaves);
		setBlocks(world, pos.add(0 - 2, 0 + height - 3, 0 - 2), pos.add(0 + 2, 0 + height, 0 + 2), ScapecraftBlocks.yewLeaves);
		return true;
	}
}
