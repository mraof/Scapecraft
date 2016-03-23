package scapecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.client.gui.GuiHandler;
import scapecraft.tileentity.TileEntitySmithingAnvil;

/**
 * Created by mraof on 2016 March 02.
 */
public class BlockSmithingAnvil extends BlockContainer
{
    protected BlockSmithingAnvil()
    {
        super(Material.iron);
        this.setBlockUnbreakable();
        this.setCreativeTab(Scapecraft.tabScapecraftBlock);
        this.setUnlocalizedName("smithingAnvil");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntitySmithingAnvil();
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, int x, int y, int z, int side)
    {
        return true;
    }

    @Override
    public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
    {
        if(!worldIn.isRemote)
        {
            TileEntity tileEntity = worldIn.getTileEntity(x, y, z);
            if (tileEntity instanceof TileEntitySmithingAnvil && !player.isSneaking())
            {
                player.openGui(Scapecraft.instance, GuiHandler.GuiId.SMITHING.ordinal(), worldIn, x, y, z);
                return true;
            }
        }
        return false;
    }
}
