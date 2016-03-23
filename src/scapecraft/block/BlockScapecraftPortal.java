package scapecraft.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import scapecraft.tileentity.TileEntityScapecraftPortal;

/**
 * Created by mraof on 2016 March 10 at 1:40 PM.
 */
public class BlockScapecraftPortal extends BlockScapecraft implements ITileEntityProvider
{
    public BlockScapecraftPortal()
    {
        super(Material.portal);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityScapecraftPortal();
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
}
