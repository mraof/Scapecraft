package scapecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockCabbage extends BlockScapecraft
{
	public BlockCabbage()
	{
		super(Material.plants);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldIn, int x, int y, int z)
	{
		return null;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return 1;
	}
}
