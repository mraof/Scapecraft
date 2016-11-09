package scapecraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

/**
 * Created by mraof on 2016 March 02.
 */
public class ItemBlockBlockSpawner extends ItemBlock
{
    public ItemBlockBlockSpawner(Block block)
    {
        super(block);
        this.setHasSubtypes(true);
        this.setRegistryName(block.getRegistryName());
    }
}
