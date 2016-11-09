package scapecraft.world.gen.feature;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scapecraft.block.ScapecraftBlocks;

import java.util.Random;

public class WorldGenMagicTree extends WorldGenScapecraft
{
	public WorldGenMagicTree(boolean doBlockNotify)
	{
		super(doBlockNotify);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		int height = rand.nextInt(3) + 3;
		for(int yOffset = 0; yOffset <= height; yOffset++)
		{
			setBlock(world, pos.add(0, yOffset, 0), ScapecraftBlocks.magicLog.getDefaultState(), ScapecraftBlocks.magicTreeSpawn);
		}
		setBlocks(world, pos.add(0 - 1, height + 1, 0 - 1), pos.add(1, height + 1, 1), ScapecraftBlocks.magicLeaves);
		setBlocks(world, pos.add(0 - 2, height - 1, 0 - 2), pos.add(2, height, 2), ScapecraftBlocks.magicLeaves);
		return true;
	}
}
