package scapecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import scapecraft.entity.Drop;
import scapecraft.entity.EntityScapecraft;
import scapecraft.entity.ScapecraftEntities;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;

import java.util.ArrayList;

public class ContainerMobDrops extends ContainerScapecraft
{
    public Object target;
    public InventoryDrops inventoryDrops;
    ArrayList<Integer> chances = new ArrayList<Integer>();
    public ContainerMobDrops(InventoryPlayer inventoryPlayer)
    {
        super(new InventoryDrops());
        System.out.println(inventoryPlayer.player);
        this.yOffset = 8;
        addPlayerInventory(inventoryPlayer);
        inventoryDrops = ((InventoryDrops) this.inventoryScapecraft);
        inventoryDrops.container = this;
        addSlotToContainer(new Slot(inventoryDrops, 0, 181, 5));
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotNum)
    {
        ItemStack stack = null;
        Slot slot = inventorySlots.get(slotNum);
        if(slot != null && slot.getHasStack())
        {
            if (slotNum < PLAYER_INV_SIZE)
            {
                ItemStack slotStack = slot.getStack();
                stack = slotStack.copy();
                putStackInSlot(PLAYER_INV_SIZE + inventoryScapecraft.getSizeInventory() - 1, slotStack);
                slot.putStack(null);
            }
            else
            {
                this.mergeItemStack(slot.getStack(), 0, PLAYER_INV_SIZE - 1, true);
                if (slot.getStack().stackSize == 0)
                {
                    slot.putStack(null);
                }
            }
        }
        return stack;
    }

    public void removeSlot(int index)
    {
        inventorySlots.remove(PLAYER_INV_SIZE + index);
        inventoryItemStacks.remove(inventoryItemStacks.size() - 1);
        chances.remove(index);
        for(int i = index + PLAYER_INV_SIZE; i < inventorySlots.size(); i++)
        {
            Slot oldSlot = inventorySlots.remove(i);
            Slot newSlot = new Slot(inventoryDrops, oldSlot.getSlotIndex() - 1, oldSlot.xDisplayPosition, oldSlot.yDisplayPosition - 26);
            newSlot.slotNumber = oldSlot.slotNumber - 1;
            //noinspection unchecked
            inventorySlots.add(i, newSlot);
        }
    }

    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.inventoryScapecraft);
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        while (chances.size() > inventoryDrops.chances.size())
        {
            chances.remove(chances.size() - 1);
        }
        for (int i = 0; i < chances.size(); i++)
        {
            if(!chances.get(i).equals(inventoryDrops.chances.get(i)))
            {
                chances.set(i, inventoryDrops.chances.get(i));
                for (IContainerListener listener : this.listeners)
                {
                    listener.sendProgressBarUpdate(this, i, chances.get(i));
                }
            }
        }
    }

    //Override to make public
    @Override
    public Slot addSlotToContainer(Slot slot)
    {
        return super.addSlotToContainer(slot);
    }

    @Override
    public String toString()
    {
        return "ContainerMobDrops{" +
               "target=" + target +
               ", inventoryDrops=" + inventoryDrops +
               ", chances=" + chances +
               '}';
    }

    public void applyDrops(ArrayList<Drop> drops)
    {
        System.out.println(target + " " + drops);
        if(target instanceof TileEntityScapecraftMobSpawner)
        {
            ((TileEntityScapecraftMobSpawner) target).drops = drops;
            ((TileEntityScapecraftMobSpawner) target).markDirty();
        }
        else if(target instanceof Class && EntityScapecraft.class.isAssignableFrom((Class<?>) target))
        {
            //noinspection unchecked
            ScapecraftEntities.setDrops((Class<? extends EntityScapecraft>) target, drops);
        }
    }
}
