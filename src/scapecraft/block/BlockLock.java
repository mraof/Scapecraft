package scapecraft.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLock extends BlockScapecraft
{
	Item key;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public BlockLock(Item key)
	{
		super(Material.glass);
		this.setBlockUnbreakable();
		this.key = key;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity)
	{
		if(world.getBlockMetadata(x, y, z) == 0)
			super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isBlockSolid(IBlockAccess world, int x, int y, int z, int side)
	{
		return true;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1);
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		return world.getBlock(x, y, z) != this;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if(!world.isRemote && world.getBlockMetadata(x, y, z) != 0)
			world.setBlockMetadataWithNotify(x, y, z, 0, 3);

	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if(world.getBlockMetadata(x, y, z) == 0 && player.inventory.consumeInventoryItem(key))
		{
			world.setBlockMetadataWithNotify(x, y, z, 1, 3);
			world.scheduleBlockUpdate(x, y, z, this, 400);
		}

		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return icons[meta & 1];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		icons = new IIcon[2];
		icons[0] = iconRegister.registerIcon("scapecraft:KeyBlock");
		icons[1] = iconRegister.registerIcon("scapecraft:Clear");
	}
}
