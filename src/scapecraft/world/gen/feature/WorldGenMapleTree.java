package scapecraft.world.gen.feature;

import net.minecraft.world.World;
import scapecraft.block.ScapecraftBlocks;

import java.util.Random;

public class WorldGenMapleTree extends WorldGenScapecraft
{
	public WorldGenMapleTree(boolean doBlockNotify)
	{
		super(doBlockNotify);
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		int height = rand.nextInt(3) + 6;
		for(int yOffset = 0; yOffset <= height; yOffset++)
		{
			setBlock(world, x, y + yOffset, z, ScapecraftBlocks.mapleLog, 0, ScapecraftBlocks.mapleTreeSpawn);
		}
		setBlocks(world, x - 1, y + height + 1, z - 1, x + 1, y + height + 1, z + 1, ScapecraftBlocks.mapleLeaves);
		setBlocks(world, x - 2, y + height - 4, z - 2, x + 2, y + height, z + 2, ScapecraftBlocks.mapleLeaves);
		return true;
	}
}

