package scapecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;
import java.util.Arrays;

/**
 * Created by mraof on 2016 March 02.
 */
public class InventoryScapecraft implements IInventory
{
    ItemStack[] inventory;
    int[] fields = new int[0];

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

    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
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
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return true;
    }

    @Override
    public int getField(int id) {
        return this.fields[id];
    }

    @Override
    public void setField(int id, int value)
    {
        this.fields[id] = value;
    }

    @Override
    public int getFieldCount() {
        return this.fields.length;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString()
    {
        return "InventoryScapecraft{" +
               "inventory=" + Arrays.toString(inventory) +
               ", name='" + name + '\'' +
               '}';
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns true if this thing is named
     */
    @Override
    public boolean hasCustomName() {
        return false;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentString(name);
    }
}
