package scapecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockInvisibleLight extends BlockScapecraft
{
	@SideOnly(Side.CLIENT)
	public static IIcon[] icons;

	public BlockInvisibleLight()
	{
		super(Material.glass);
		this.setUnlocalizedName("invisibleLight");
		this.setBlockUnbreakable();
		this.setResistance(6000000F);
		this.setLightLevel(1.0F);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isBlockSolid(IBlockAccess world, int x, int y, int z, int side)
	{
		return false;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}

	@Override
	public void setBlockBoundsForItemRender()
	{
		if(Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
		else
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta)
	{
		if(Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode)
		{
			return icons[1];
		}
		else
		{
			return icons[0];
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		icons = new IIcon[2];
		icons[0] = iconRegister.registerIcon("scapecraft:Clear");
		icons[1] = iconRegister.registerIcon("scapecraft:Light");
	}
}
