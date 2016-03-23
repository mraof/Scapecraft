package scapecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.util.Random;

public class BlockAgility extends BlockScapecraft
{
	int xp;

	public BlockAgility(int xp)
	{
		super(Material.rock);
		this.xp = xp;
		this.setUnlocalizedName("agilityBlock" + xp);
		this.setTextureName("scapecraft:AgilityBlock");
		this.setBlockUnbreakable();
	}

	@Override
	public boolean canProvidePower()
	{
		return true;
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int side)
	{
		return world.getBlockMetadata(x, y, z) * 15;
	}

	@Override
	public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side)
	{
		return world.getBlockMetadata(x, y, z) * 15;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if(!world.isRemote && world.getBlockMetadata(x, y, z) != 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 0, 3);
		}

	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if(!world.isRemote && world.getBlockMetadata(x, y, z) == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 3);
			world.scheduleBlockUpdate(x, y, z, this, 40);
			Stats.addXp(player, Stat.AGILITY, xp);
		}

		return true;
	}
}
