package scapecraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.client.gui.GuiHandler;
import scapecraft.tileentity.TileEntitySmeltingFurnace;

import javax.annotation.Nullable;

/**
 * Created by mraof on 2016 March 02.
 */
public class BlockSmeltingFurnace extends BlockContainer
{
    public BlockSmeltingFurnace()
    {
        super(Material.IRON);
        this.setBlockUnbreakable();
        this.setCreativeTab(Scapecraft.tabScapecraftBlock);
        this.setUnlocalizedName("smeltingFurnace");
        this.setLightLevel(14);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntitySmeltingFurnace();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if (!player.isSneaking() && tileEntity instanceof TileEntitySmeltingFurnace)
        {
            if (!worldIn.isRemote)
            {
                player.openGui(Scapecraft.instance, GuiHandler.GuiId.SMELTING.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
            }
            return true;
        }
        return false;
    }
}
