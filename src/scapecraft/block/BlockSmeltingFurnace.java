package scapecraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.client.gui.GuiHandler;
import scapecraft.tileentity.TileEntitySmeltingFurnace;

/**
 * Created by mraof on 2016 March 02.
 */
public class BlockSmeltingFurnace extends BlockContainer
{
    public BlockSmeltingFurnace()
    {
        super(Material.iron);
        this.setBlockUnbreakable();
        this.setCreativeTab(Scapecraft.tabScapecraftBlock);
        this.setUnlocalizedName("smeltingFurnace");
        this.setTextureName("scapecraft:SmeltingFurnaceFront");
        this.setLightLevel(14);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntitySmeltingFurnace();
    }

    @Override
    public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
    {
        TileEntity tileEntity = worldIn.getTileEntity(x, y, z);
        if (!player.isSneaking() && tileEntity instanceof TileEntitySmeltingFurnace)
        {
            if (!worldIn.isRemote)
            {
                player.openGui(Scapecraft.instance, GuiHandler.GuiId.SMELTING.ordinal(), worldIn, x, y, z);
            }
            return true;
        }
        return false;
    }
}
