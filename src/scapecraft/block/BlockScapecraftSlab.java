package scapecraft.block;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import scapecraft.Scapecraft;

/**
 * Created by mraof on 2016 March 15 at 11:12 PM.
 */
public class BlockScapecraftSlab extends BlockSlab
{
    public BlockScapecraftSlab(boolean isFullBlock)
    {
        super(isFullBlock, Material.rock);
        this.setTextureName("scapecraft:SmeltingFurnaceSide");
        this.setUnlocalizedName("scapecraftSlab");
        this.setCreativeTab(Scapecraft.tabScapecraftBlock);
        this.useNeighborBrightness = true;
    }

    @Override
    public String getFullSlabName(int p_150002_1_)
    {
        return this.getUnlocalizedName();
    }
}
