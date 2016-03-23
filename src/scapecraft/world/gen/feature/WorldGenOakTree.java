package scapecraft.world.gen.feature;

import net.minecraft.init.Blocks;
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
	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		int height = rand.nextInt(2) + 4;
		for(int yOffset = 0; yOffset <= height; yOffset++)
		{
			setBlock(world, x, y + yOffset, z, Blocks.log, 0, ScapecraftBlocks.oakTreeSpawn);
		}
		setBlocks(world, x - 1, y + height + 1, z, x + 1, y + height + 1, z, Blocks.leaves);
		setBlocks(world, x, y + height + 1, z - 1, x, y + height + 1, z + 1, Blocks.leaves);
		setBlocks(world, x - 1, y + height, z - rand.nextInt(2), x + 1, y + height, z + rand.nextInt(2), Blocks.leaves);
		setBlocks(world, x - rand.nextInt(2), y + height, z - 1, x + rand.nextInt(2), y + height, z + 1, Blocks.leaves);
		setBlocks(world, x - 2, y + height - 2, z - 1 - rand.nextInt(2), x + 2, y + height - 1, z + 1 + rand.nextInt(2), Blocks.leaves);
		setBlocks(world, x - 1 - rand.nextInt(2), y + height - 2, z - 2, x + 1 + rand.nextInt(2), y + height - 1, z + 2, Blocks.leaves);
		return true;
	}
}
