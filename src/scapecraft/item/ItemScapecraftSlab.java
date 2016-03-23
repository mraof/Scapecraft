package scapecraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;
import scapecraft.block.BlockScapecraftSlab;

/**
 * Created by mraof on 2016 March 20 at 2:46 PM.
 * Exists because boolean isn't an object and messes up forge's registering
 */
public class ItemScapecraftSlab extends ItemSlab
{
    public ItemScapecraftSlab(Block p_i45355_1_, BlockScapecraftSlab p_i45355_2_, BlockScapecraftSlab p_i45355_3_, Boolean p_i45355_4_)
    {
        super(p_i45355_1_, p_i45355_2_, p_i45355_3_, p_i45355_4_);
    }
}
