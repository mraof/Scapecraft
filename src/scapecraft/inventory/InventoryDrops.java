package scapecraft.inventory;

import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mraof on 2016 March 05 at 3:58 PM.
 */
public class InventoryDrops extends InventoryScapecraft
{
    public ArrayList<Integer> chances = new ArrayList<Integer>();
    public ContainerMobDrops container;
    public InventoryDrops()
    {
        super(1);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        if (index == this.inventory.length - 1)
        {
            ArrayList<ItemStack> stacks = new ArrayList<ItemStack>(Arrays.asList(inventory));
            inventory = new ItemStack[stacks.size() + 1];
            stacks.add(null);
            chances.add(1);
            container.addSlotToContainer(new Slot(this, inventory.length - 1, 181, 26 * (stacks.size() - 1) + 5));
            container.chances.add(0);
            stacks.toArray(inventory);
        }
        else if(stack == null)
        {
            List<ItemStack> stacks = new ArrayList<ItemStack>(Arrays.asList(inventory));
            stacks.remove(index);
            chances.remove(index);
            inventory = new ItemStack[stacks.size()];
            container.removeSlot(index);
            stacks.toArray(inventory);
            return;
        }
        super.setInventorySlotContents(index, stack);
    }

    @Override
    public int getField(int id) {
        return this.chances.get(id);
    }

    @Override
    public void setField(int id, int value)
    {
        if(id == this.chances.size())
        {
            this.chances.add(id);
        }
        else
        {
            this.chances.set(id, value);
        }
    }

    @Override
    public int getFieldCount() {
        return this.fields.length;
    }

    @Override
    public String toString()
    {
        return "InventoryDrops{" +
               "chances=" + chances +
               "inventory=" + Arrays.toString(inventory) +
               '}';
    }
}
