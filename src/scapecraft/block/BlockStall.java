package scapecraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.tileentity.TileEntityStall;

public class BlockStall extends BlockContainer
{
	public BlockStall()
	{
		super(Material.GLASS);
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
		this.setUnlocalizedName("stall");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityStall();
	}

}
