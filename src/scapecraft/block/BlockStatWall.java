package scapecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.util.List;

public class BlockStatWall extends BlockScapecraft
{
	public Stat stat;
	public int[] colors = {0x00FF00, 0x11EE00, 0x22DD00, 0x33CC00, 0x44BB00, 0x55AA00, 0x669900, 0x778800, 0x887700, 0x996600, 0xAA5500, 0xBB4400, 0xCC3300, 0xDD2200, 0xEE1100, 0xFF0000};
	private static int renderPass = 0;

	public BlockStatWall(Stat stat)
	{
		super(Material.glass);
		this.stat = stat;
		this.setUnlocalizedName(stat.toString().toLowerCase() + "Wall");
		this.setBlockUnbreakable();
		this.setResistance(6000000F);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity)
	{
		if(!(entity instanceof EntityPlayer) || Stats.getLevel((EntityPlayer) entity, stat) < world.getBlockMetadata(x, y, z) * 5 + 10 && !((EntityPlayer)entity).capabilities.isCreativeMode)
		{
			super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
		}
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

	@Override
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
	public int damageDropped(int meta)
	{
		return meta;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack itemStack)
	{
		world.setBlockMetadataWithNotify(x, y, z, itemStack.getMetadata() & 15, 3);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List stacks)
	{
		for(int i = 0; i < 16; i++)
		{
			stacks.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public int getRenderColor(int meta)
	{
		return renderPass == 0 ? 0xFFFFFF : colors[meta & 15];
	}

	@Override
	public int colorMultiplier(IBlockAccess world, int x, int y, int z)
	{
		if(y > 0 && renderPass == 0)
		{
			return world.getBlock(x, y - 1, z).colorMultiplier(world, x, y - 1, z);
		}
		return getRenderColor(world.getBlockMetadata(x, y, z));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess worldIn, int x, int y, int z, int side)
	{
		if(renderPass == 0 && y > 0)
		{
			if(!(Stats.getLevel(Minecraft.getMinecraft().thePlayer, stat) < worldIn.getBlockMetadata(x, y, z) * 5 + 10))
			{
				return BlockInvisibleLight.icons[0];
			}
			return worldIn.getBlock(x, y - 1, z).getIcon(worldIn, x, y - 1, z, side);
		}
		else
		{
			return this.blockIcon;
		}
	}

	//Render on both passes
	@Override
	public boolean canRenderInPass(int pass)
	{
		renderPass = pass;
		return true;
	}

	@Override
	public int getRenderBlockPass()
	{
		return 2;
	}

	@Override
	public void registerIcons(IIconRegister reg)
	{
		this.blockIcon = reg.registerIcon("scapecraft:stat/" + stat.toString());
	}
}
