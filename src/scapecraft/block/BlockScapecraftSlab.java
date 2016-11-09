package scapecraft.block;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.ItemStack;
import scapecraft.Scapecraft;

/**
 * Created by mraof on 2016 March 15 at 11:12 PM.
 */
public class BlockScapecraftSlab extends BlockSlab
{
    private final boolean isFullBlock;

    public BlockScapecraftSlab(boolean isFullBlock)
    {
        super(Material.ROCK);
        this.isFullBlock = isFullBlock;
        this.setUnlocalizedName("scapecraftSlab");
        this.setCreativeTab(Scapecraft.tabScapecraftBlock);
        this.useNeighborBrightness = true;
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return this.getUnlocalizedName();
    }

    @Override
    public boolean isDouble() {
        return isFullBlock;
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return null;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return null;
    }
}
