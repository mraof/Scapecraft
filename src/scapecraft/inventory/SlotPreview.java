package scapecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by mraof on 2016 March 02.
 */
public class SlotPreview extends Slot
{
    public SlotPreview(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_)
    {
        super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return false;
    }

    @Override
    public ItemStack decrStackSize(int count)
    {
        return null;
    }

    @Override
    public boolean canTakeStack(EntityPlayer player)
    {
        return false;
    }

    @Override
    public boolean canBeHovered()
    {
        return this.getHasStack();
    }

    @Override
    public int getSlotStackLimit()
    {
        return 0;
    }
}
