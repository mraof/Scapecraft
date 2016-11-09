package scapecraft.block;

import net.minecraft.block.material.Material;

public class BlockAgility extends BlockScapecraft
{
	int xp;

	public BlockAgility(int xp)
	{
		super(Material.ROCK);
		this.xp = xp;
		this.setUnlocalizedName("agilityBlock" + xp);
		this.setBlockUnbreakable();
	}

/*	@Override
	public boolean canProvidePower()
	{
		return true;
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess world, BlockPos pos, int side)
	{
		return world.getBlockMetadata(x, y, z) * 15;
	}

	@Override
	public int isProvidingStrongPower(IBlockAccess world, BlockPos pos, int side)
	{
		return world.getBlockMetadata(x, y, z) * 15;
	}

	@Override
	public void updateTick(World world, BlockPos pos, Random random)
	{
		if(!world.isRemote && world.getBlockMetadata(x, y, z) != 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 0, 3);
		}

	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if(!world.isRemote && world.getBlockMetadata(x, y, z) == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 3);
			world.scheduleBlockUpdate(x, y, z, this, 40);
			Stats.addXp(player, Stat.AGILITY, xp);
		}

		return true;
	}*/
}
