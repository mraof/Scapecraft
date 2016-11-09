package scapecraft.block;

import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import scapecraft.Scapecraft;

import java.util.Random;

public class BlockScapecraftSapling extends BlockSapling
{
	public Class<? extends WorldGenerator> worldGenClass;
	public BlockScapecraftSapling(Class<? extends WorldGenerator> worldGenClass)
	{
		super();
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
		this.worldGenClass = worldGenClass;
	}

	@Override
	public void generateTree(World world, BlockPos pos, IBlockState blockState, Random random) {
		try {
			WorldGenerator worldGen = worldGenClass.getConstructor(boolean.class).newInstance(true);
			System.out.println(worldGen.generate(world, random, pos));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
