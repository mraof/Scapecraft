package scapecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockRedstoneCost extends BlockScapecraft
{
	ItemStack cost;

	public BlockRedstoneCost(ItemStack cost)
	{
		super(Material.rock);
		this.cost = cost;
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
		for(int i = 0; i < player.inventory.mainInventory.length; i++)
		{
			if(player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == this.cost.getItem() && player.inventory.mainInventory[i].stackSize >= this.cost.stackSize)
			{
					if(!world.isRemote && world.getBlockMetadata(x, y, z) == 0)
					{
						world.setBlockMetadataWithNotify(x, y, z, 1, 3);
						world.scheduleBlockUpdate(x, y, z, this, 20);
					}
					player.inventory.mainInventory[i].stackSize -= this.cost.stackSize;
					return true;
			}
		}

		return false;
	}
}
