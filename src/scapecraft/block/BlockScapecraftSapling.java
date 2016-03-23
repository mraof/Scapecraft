package scapecraft.block;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import scapecraft.Scapecraft;

import java.util.Random;

public class BlockScapecraftSapling extends BlockBush implements IGrowable
{
	public Class<? extends WorldGenerator> worldGenClass;
	public BlockScapecraftSapling(Class<? extends WorldGenerator> worldGenClass)
	{
		super();
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
		this.worldGenClass = worldGenClass;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if(!world.isRemote)
		{
			super.updateTick(world, x, y, z, random);
			if(world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0)
			{
				this.grow(world, x, y, z, random);
			}
		}
	}

	public void grow(World world, int x, int y, int z, Random random)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		if(metadata == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 4);
		}
		else
		{
			try {
				WorldGenerator worldGen = worldGenClass.getConstructor(boolean.class).newInstance(true);
				System.out.println(worldGen.generate(world, random, x, y, z));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean canFertilize(World worldIn, int x, int y, int z, boolean isClient)
	{
		return true;
	}

	@Override
	public boolean shouldFertilize(World worldIn, Random random, int x, int y, int z)
	{
		return worldIn.rand.nextFloat() < .25D;
	}

	@Override
	public void fertilize(World worldIn, Random random, int x, int y, int z)
	{
		this.grow(worldIn, x, y, z, random);
	}
}
	
