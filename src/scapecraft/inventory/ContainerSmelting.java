package scapecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import scapecraft.tileentity.TileEntitySmeltingFurnace;
import scapecraft.util.SmeltingRecipe;

/**
 * Created by mraof on 2016 March 02.
 */
public class ContainerSmelting extends ContainerScapecraft
{
    private final TileEntitySmeltingFurnace te;
    private int progress = 0;
    private int time = 1;
    private SmeltingRecipe recipe = null;

    public ContainerSmelting(InventoryPlayer inventoryPlayer, InventoryScapecraft inventoryScapecraft, TileEntitySmeltingFurnace te)
    {
        super(inventoryScapecraft);
        this.te = te;
        this.yOffset = 51;
        inventoryScapecraft.setInventoryName("Smelting");
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

    @Override
    public void onCraftGuiOpened(ICrafting iCrafting)
    {
        super.onCraftGuiOpened(iCrafting);
        TileEntitySmeltingFurnace.Result result = te.getResult(inventoryPlayer.player.getUniqueID());
        this.progress = result.progress;
        iCrafting.sendProgressBarUpdate(this, 0, this.progress);
        if(result.recipe != null)
        {
            this.time = result.recipe.getTime();
            iCrafting.sendProgressBarUpdate(this, 1, this.time);
            iCrafting.sendSlotContents(this, inventorySlots.size(), recipe.getResult());
        }
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        TileEntitySmeltingFurnace.Result result = te.getResult(inventoryPlayer.player.getUniqueID());
        if(this.progress != result.progress)
        {
            this.progress = result.progress;
            for (Object crafter : this.crafters)
            {
                System.out.println(this.progress + " ");
                ((ICrafting) crafter).sendProgressBarUpdate(this, 0, this.progress);
            }
        }
        if(result.recipe != this.recipe)
        {
            this.recipe = result.recipe;
            if(result.recipe != null)
            {
                this.time = result.recipe.getTime();
                for (Object crafter : this.crafters)
                {
                    if (crafter instanceof EntityPlayerMP)
                    {
                        ((EntityPlayerMP) crafter).isChangingQuantityOnly = false;
                    }
                    ((ICrafting) crafter).sendProgressBarUpdate(this, 1, this.time);
                    ((ICrafting) crafter).sendSlotContents(this, inventorySlots.size(), recipe.getResult());
                }
            }
            else
            {
                for (Object crafter : this.crafters)
                {
                    if (crafter instanceof EntityPlayerMP)
                    {
                        ((EntityPlayerMP) crafter).isChangingQuantityOnly = false;
                    }
                    ((ICrafting) crafter).sendSlotContents(this, inventorySlots.size(), null);
                }
            }
        }
    }

    @Override
    public ItemStack slotClick(int slotId, int clickedButton, int mode, EntityPlayer player)
    {
        ItemStack stack = super.slotClick(slotId, clickedButton, mode, player);
        if(te != null)
        {
            te.onInventoryChanged(player.getUniqueID());
        }
        return stack;
    }

    @Override
    public void updateProgressBar(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.progress = value;
                break;
            case 1:
                this.time = value;
                break;
        }
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
        return 16 * progress / time;
    }
}
