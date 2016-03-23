package scapecraft.world.gen.feature;

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
	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		int height = rand.nextInt(4) + 5;
		for(int yOffset = 0; yOffset <= height; yOffset++)
		{
			setBlock(world, x, y + yOffset, z, ScapecraftBlocks.yewLog, 0, ScapecraftBlocks.yewTreeSpawn);
		}
		setBlocks(world, x - 1, y + height + 1, z - 1, x + 1, y + height + 1, z + 1, ScapecraftBlocks.yewLeaves);
		setBlocks(world, x - 2, y + height - 3, z - 2, x + 2, y + height, z + 2, ScapecraftBlocks.yewLeaves);
		return true;
	}
}
