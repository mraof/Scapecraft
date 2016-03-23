package scapecraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.tileentity.TileEntityStall;

public class BlockStall extends BlockContainer
{
	public BlockStall()
	{
		super(Material.glass);
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
		this.setTextureName("scapecraft:Stall");
		this.setUnlocalizedName("stall");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return createTileEntity(world, metadata);
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityStall();
	}

	@Override
	public int getRenderType()
	{
		return -1;
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		TileEntityStall te = (TileEntityStall) world.getTileEntity(x, y, z);
		return te.giveItem(player);
	}
}
