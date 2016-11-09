package scapecraft.world.gen.feature;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import scapecraft.block.ScapecraftBlocks;

import java.util.Random;

public class WorldGenOakTree extends WorldGenScapecraft
{
	WorldGenTrees vanillaOakTreeGen;
	public WorldGenOakTree(boolean doBlockNotify)
	{
		super(doBlockNotify);
		vanillaOakTreeGen = new WorldGenTrees(true);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		int height = rand.nextInt(2) + 4;
		for(int yOffset = 0; yOffset <= height; yOffset++)
		{
			setBlock(world, pos.add(0, yOffset, 0), Blocks.LOG.getDefaultState(), ScapecraftBlocks.oakTreeSpawn);
		}
		setBlocks(world, pos.add(0 - 1, height + 1, 0), pos.add(1, height + 1, 0), Blocks.LEAVES);
		setBlocks(world, pos.add(0, height + 1, 0 - 1), pos.add(0, height + 1, 1), Blocks.LEAVES);
		setBlocks(world, pos.add(0 - 1, height, 0 - rand.nextInt(2)), pos.add(1, height, rand.nextInt(2)), Blocks.LEAVES);
		setBlocks(world, pos.add(0 - rand.nextInt(2), height, 0 - 1), pos.add(rand.nextInt(2), height, 1), Blocks.LEAVES);
		setBlocks(world, pos.add(0 - 2, height - 2, 0 - 1 - rand.nextInt(2)), pos.add(2, height - 1, 1 + rand.nextInt(2)), Blocks.LEAVES);
		setBlocks(world, pos.add(0 - 1 - rand.nextInt(2), height - 2, 0 - 2), pos.add(1 + rand.nextInt(2), height - 1, 2), Blocks.LEAVES);
		return true;
	}
}
