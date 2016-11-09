package scapecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import scapecraft.tileentity.TileEntitySmeltingFurnace;
import scapecraft.util.SmeltingRecipe;

import javax.annotation.Nullable;

/**
 * Created by mraof on 2016 March 02.
 */
public class ContainerSmelting extends ContainerScapecraft
{
    final int FIELD_PROGRESS = 0;
    final int FIELD_TIME = 1;
    private final TileEntitySmeltingFurnace te;
    private SmeltingRecipe recipe = null;

    public ContainerSmelting(InventoryPlayer inventoryPlayer, InventoryScapecraft inventoryScapecraft, TileEntitySmeltingFurnace te)
    {
        super(inventoryScapecraft);
        this.te = te;
        this.yOffset = 51;
        inventoryScapecraft.setInventoryName("Smelting");
        inventoryScapecraft.fields = new int[2];
        addPlayerInventory(inventoryPlayer);
        addSlotToContainer(new Slot(inventoryScapecraft, 0, 53, 20));
        addSlotToContainer(new Slot(inventoryScapecraft, 1, 71, 20));
        addSlotToContainer(new Slot(inventoryScapecraft, 2, 107, 20));
        resultCount = 1;
        previewSlots.add(null);
    }

    public ContainerSmelting(InventoryPlayer inventoryPlayer, InventoryScapecraft inventoryScapecraft)
    {
        this(inventoryPlayer, inventoryScapecraft, null);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        TileEntitySmeltingFurnace.Result result = te.getResult(inventoryPlayer.player.getUniqueID());
        if(this.inventoryScapecraft.getField(FIELD_PROGRESS) != result.progress)
        {
            this.inventoryScapecraft.setField(FIELD_PROGRESS, result.progress);
            for (IContainerListener listener : this.listeners)
            {
                listener.sendProgressBarUpdate(this, 0, this.inventoryScapecraft.getField(FIELD_PROGRESS));
            }
        }
        if(result.recipe != this.recipe)
        {
            this.recipe = result.recipe;
            if(result.recipe != null)
            {
                this.inventoryScapecraft.setField(FIELD_TIME, result.recipe.getTime());
                for (IContainerListener listener : this.listeners)
                {
                    if (listener instanceof EntityPlayerMP)
                    {
                        ((EntityPlayerMP) listener).isChangingQuantityOnly = false;
                    }
                    listener.sendProgressBarUpdate(this, 1, this.inventoryScapecraft.getField(FIELD_TIME));
                    listener.sendSlotContents(this, inventorySlots.size(), recipe.getResult());
                }
            }
            else
            {
                for (IContainerListener listener : this.listeners)
                {
                    if (listener instanceof EntityPlayerMP)
                    {
                        ((EntityPlayerMP) listener).isChangingQuantityOnly = false;
                    }
                    listener.sendSlotContents(this, inventorySlots.size(), null);
                }
            }
        }
    }

    @Nullable
    @Override
    public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player)
    {
        ItemStack stack = super.slotClick(slotId, dragType, clickTypeIn, player);
        if(te != null)
        {
            te.onInventoryChanged(player.getUniqueID());
        }
        return stack;
    }

    @Override
    public Slot getSlot(int slot)
    {
        if(slot == inventorySlots.size())
        {
            return null;
        }
        return super.getSlot(slot);
    }

    public int getProgress()
    {
        return 16 * this.inventoryScapecraft.getField(FIELD_PROGRESS) / this.inventoryScapecraft.getField(FIELD_TIME);
    }
}
