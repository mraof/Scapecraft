package scapecraft.world.gen.feature;

import java.util.Random;

import net.minecraft.world.World;

import scapecraft.block.ScapecraftBlocks;

public class WorldGenStrongOakTree extends WorldGenScapecraft
{
	public WorldGenStrongOakTree(boolean doBlockNotify)
	{
		super(doBlockNotify);
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		int height = rand.nextInt(2) + 5;
		for(int yOffset = 0; yOffset <= height; yOffset++) 
			world.setBlock(x, y + yOffset, z, ScapecraftBlocks.strongOakLog);
		setBlocks(world, x - 1, y + height + 1, z - 1, x + 1, y + height + 1, z + 1, ScapecraftBlocks.strongOakLeaves);
		setBlocks(world, x - 2, y + height - 3, z - 2, x + 2, y + height, z + 2, ScapecraftBlocks.strongOakLeaves);
		return true;
	}
}
