package scapecraft.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
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

	public void setBlock(World world, BlockPos pos, IBlockState blockState)
	{
		world.setBlockState(pos, blockState, 3);
		//System.out.println(genTracker);
		if(genTracker != null)
		{
			genTracker.addSpawnedBlock(blockState.getBlock(), pos);
		}
	}

	public void setBlock(World world, BlockPos pos, IBlockState blockState, Block dontReplace)
	{
		if(world.getBlockState(pos).getBlock() != dontReplace)
		{
			world.setBlockState(pos, blockState, 3);
			//System.out.println(genTracker);
			if (genTracker != null)
			{
				genTracker.addSpawnedBlock(blockState.getBlock(), pos);
			}
		}
	}

	public void setBlocks(World world, BlockPos min, BlockPos max, Block block)
	{
		this.setBlocks(world, min, max, block.getDefaultState(), false);
	}

	public void setBlocks(World world, BlockPos min, BlockPos max, IBlockState blockState)
	{
		this.setBlocks(world, min, max, blockState, false);
	}

	public void setBlocks(World world, BlockPos min, BlockPos max, IBlockState blockState, boolean replace)
	{
		for(BlockPos pos : BlockPos.getAllInBox(min, max)) {
			if (world.getBlockState(pos).getBlock().isReplaceable(world, pos)) {
				setBlock(world, pos, blockState);
			}
		}
	}
}
