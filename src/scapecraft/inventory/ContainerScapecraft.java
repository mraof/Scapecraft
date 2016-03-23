package scapecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

/**
 * Created by mraof on 2016 March 02.
 */
public abstract class ContainerScapecraft extends Container
{
    public InventoryScapecraft inventoryScapecraft;
    protected InventoryPlayer inventoryPlayer;
    public ArrayList<ItemStack> previewSlots = new ArrayList<ItemStack>();
    protected int xOffset;
    protected int yOffset;
    protected int resultCount = 0;
    public final static int PLAYER_INV_SIZE = 36;

    public ContainerScapecraft(InventoryScapecraft inventoryScapecraft)
    {
        this.inventoryScapecraft = inventoryScapecraft;
        xOffset = 8;
        yOffset = 8;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    protected void addPlayerInventory(InventoryPlayer inventoryPlayer)
    {
        this.inventoryPlayer = inventoryPlayer;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(inventoryPlayer, i * 9 + j + 9, j * 18 + xOffset, i * 18 + yOffset));
            }
        }

        for (int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(inventoryPlayer, i, i * 18 + xOffset, 58 + yOffset));
        }
    }

    /**/
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotNum)
    {
        ItemStack stack = null;
        Slot slot = (Slot) inventorySlots.get(slotNum);
        if(slot != null && slot.getHasStack())
        {
            ItemStack slotStack = slot.getStack();
            stack = slotStack.copy();
            int min = slotNum < PLAYER_INV_SIZE ? PLAYER_INV_SIZE : 0;
            int max = slotNum < PLAYER_INV_SIZE ? PLAYER_INV_SIZE + inventoryScapecraft.getSizeInventory() - resultCount : PLAYER_INV_SIZE;
            if(!this.mergeItemStack(slotStack, min, max, true))
            {
                return null;
            }
            if(slotStack.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
            if(stack.stackSize == slotStack.stackSize)
            {
                return null;
            }
            slot.onPickupFromSlot(player, slotStack);
        }

        return stack;
    }

    @Override
    public void putStackInSlot(int slot, ItemStack stack)
    {
        if(slot >= inventorySlots.size())
        {
            slot -= inventorySlots.size();
            previewSlots.set(slot, stack);
        }
        else
        {
            super.putStackInSlot(slot, stack);
        }
    }
}
