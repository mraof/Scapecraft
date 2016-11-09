package scapecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import scapecraft.item.QualityItem;
import scapecraft.tileentity.TileEntitySmithingAnvil;
import scapecraft.util.SmithingRecipe;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.util.ArrayList;

/**
 * Created by mraof on 2016 March 02.
 */
public class ContainerSmithing extends ContainerScapecraft
{
    final int FIELD_PROGRESS = 0;
    final int FIELD_TIME = 1;
    private final TileEntitySmithingAnvil te;
    private SmithingRecipe recipe = null;
    private ArrayList<SmithingRecipe> recipes = null;
    private InventoryScapecraft recipeInventory;
    private int level = 0;
    private int oldLevel = 0;

    public ContainerSmithing(InventoryPlayer inventoryPlayer, InventoryScapecraft inventoryScapecraft, TileEntitySmithingAnvil te)
    {
        super(inventoryScapecraft);
        yOffset = 69;
        this.te = te;
        addPlayerInventory(inventoryPlayer);
        addSlotToContainer(new Slot(inventoryScapecraft, 0, 53, 42));
        addSlotToContainer(new Slot(inventoryScapecraft, 1, 71, 42));
        addSlotToContainer(new Slot(inventoryScapecraft, 2, 107, 42));
        recipeInventory = new InventoryScapecraft(18);
        if(this.te != null)
        {
            oldLevel = level = Stats.getLevel(inventoryPlayer.player, Stat.SMITHING);
            TileEntitySmithingAnvil.Result result = te.getResult(inventoryPlayer.player.getUniqueID());
            this.inventoryScapecraft.setField(FIELD_PROGRESS, result.progress);
            this.recipes = result.recipes;
            if(this.recipes != null)
            {
                for (int i = 0; i < this.recipes.size(); i++)
                {
                    ItemStack stack = this.recipes.get(i).getResult();
                    if(stack.getItem() instanceof QualityItem)
                    {
                        stack.setTagCompound(new NBTTagCompound());
                        stack.getTagCompound().setInteger("level", level);
                    }
                    recipeInventory.setInventorySlotContents(i, stack);
                }
            }
        }
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                addSlotToContainer(new SlotPreview(recipeInventory, i * 9 + j, j * 18 + 8, i * 18 + 4));
            }
        }
        resultCount = 1;
        previewSlots.add(new ItemStack(Items.IRON_INGOT));
        previewSlots.add(new ItemStack(Items.STICK));
        previewSlots.add(null);
    }

    public ContainerSmithing(InventoryPlayer inventoryPlayer, InventoryScapecraft inventoryScapecraft)
    {
        this(inventoryPlayer, inventoryScapecraft, null);
    }

    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.inventoryScapecraft);
        listener.sendSlotContents(this, inventorySlots.size(), recipe.getResult());
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges()
    {
        if(te == null)
        {
            return;
        }

        TileEntitySmithingAnvil.Result result = te.getResult(inventoryPlayer.player.getUniqueID());
        if(this.recipes != result.recipes || oldLevel != level)
        {
            oldLevel = level = Stats.getLevel(inventoryPlayer.player, Stat.SMITHING);
            this.recipes = result.recipes;
            for(int i = 0; i < 18; i++)
            {
                ItemStack stack = this.recipes != null && i < this.recipes.size() ? this.recipes.get(i).getResult() : null;
                if(stack != null && stack.getItem() instanceof QualityItem)
                {
                    stack.setTagCompound(new NBTTagCompound());
                    stack.getTagCompound().setInteger("level", level);
                }
                recipeInventory.setInventorySlotContents(i, stack);
            }
            for (IContainerListener listener : this.listeners)
            {
                if (listener instanceof EntityPlayerMP)
                {
                    ((EntityPlayerMP) listener).isChangingQuantityOnly = false;
                }
            }
        }

        super.detectAndSendChanges();

        if(this.inventoryScapecraft.getField(FIELD_PROGRESS) != result.progress)
        {
            this.inventoryScapecraft.setField(FIELD_PROGRESS, result.progress);
            for (IContainerListener listener : this.listeners)
            {
                listener.sendProgressBarUpdate(this, 0, this.inventoryScapecraft.getField(FIELD_PROGRESS));
            }
        }
        if(result.getRecipe() != this.recipe)
        {
            this.recipe = result.getRecipe();
            if(result.getRecipe() != null)
            {
                this.inventoryScapecraft.setField(FIELD_TIME, result.getRecipe().getTime());
                for (IContainerListener listener : this.listeners)
                {
                    if (listener instanceof EntityPlayerMP)
                    {
                        ((EntityPlayerMP) listener).isChangingQuantityOnly = false;
                    }
                    listener.sendProgressBarUpdate(this, 1, this.inventoryScapecraft.getField(FIELD_TIME));
                    listener.sendSlotContents(this, inventorySlots.size() + 2, recipe.getResult());
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
                    listener.sendSlotContents(this, inventorySlots.size() + 2, null);
                }
            }
        }
    }

    @Override
    public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player)
    {
        if(slotId >= inventoryScapecraft.getSizeInventory() + PLAYER_INV_SIZE)
        {
            slotId -= inventoryScapecraft.getSizeInventory() + PLAYER_INV_SIZE;
            if(te != null)
            {
                te.getResult(inventoryPlayer.player.getUniqueID()).setRecipe(slotId);
            }
            return null;
        }
        else
        {
            ItemStack stack = super.slotClick(slotId, dragType, clickTypeIn, player);
            if (te != null)
            {
                te.onInventoryChanged(this.inventoryPlayer.player.getUniqueID());
                oldLevel = level;
                level = Stats.getLevel(this.inventoryPlayer.player, Stat.SMITHING);
            }
            return stack;
        }
    }

    @Override
    public Slot getSlot(int slot)
    {
        if(slot >= inventorySlots.size())
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
