package scapecraft.world.gen.feature;

import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class WorldGenOakTree extends WorldGenScapecraft
{
	WorldGenTrees vanillaOakTreeGen;
	public WorldGenOakTree(boolean doBlockNotify)
	{
		super(doBlockNotify);
		vanillaOakTreeGen = new WorldGenTrees(true);
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		world.setBlock(x, y, z, Blocks.dirt);
		for(int yOffset = 0; yOffset < 8; yOffset++)
		{
			if(world.getBlock(x, y + yOffset, z) instanceof BlockLeaves)
			{
				world.setBlockToAir(x, y + yOffset, z);
			}
		}
		vanillaOakTreeGen.generate(world, rand, x, y, z);
		return true;
	}
}
