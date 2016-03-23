package scapecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import java.util.Arrays;

/**
 * Created by mraof on 2016 March 02.
 */
public class InventoryScapecraft implements IInventory
{
    ItemStack[] inventory;

    protected String name = "Scapecraft";

    public InventoryScapecraft(int size)
    {
         inventory = new ItemStack[size];
    }

    @Override
    public int getSizeInventory()
    {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slotIn)
    {
        return inventory[slotIn];
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        if(inventory[index] == null)
        {
            return null;
        }

        ItemStack result = inventory[index].copy();
        if(inventory[index].stackSize > count)
        {
            inventory[index].stackSize -= count;
            result.stackSize = count;
        }
        else
        {
            setInventorySlotContents(index, null);
        }
        return result;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index)
    {
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        inventory[index] = stack;
    }

    public void setInventoryName(String name)
    {
        this.name = name;
    }

    @Override
    public String getInventoryName()
    {
        return name;
    }

    @Override
    public boolean isCustomInventoryName()
    {
        return true;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public void markDirty()
    {

    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return true;
    }

    @Override
    public void openChest()
    {

    }

    @Override
    public void closeChest()
    {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return true;
    }

    @Override
    public String toString()
    {
        return "InventoryScapecraft{" +
               "inventory=" + Arrays.toString(inventory) +
               ", name='" + name + '\'' +
               '}';
    }
}
