package scapecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ICrafting;
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
    private final TileEntitySmithingAnvil te;
    private int progress = 0;
    private int time = 1;
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
            this.progress = result.progress;
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
        previewSlots.add(new ItemStack(Items.iron_ingot));
        previewSlots.add(new ItemStack(Items.stick));
        previewSlots.add(null);
    }

    public ContainerSmithing(InventoryPlayer inventoryPlayer, InventoryScapecraft inventoryScapecraft)
    {
        this(inventoryPlayer, inventoryScapecraft, null);
    }

    @Override
    public void onCraftGuiOpened(ICrafting iCrafting)
    {
        super.onCraftGuiOpened(iCrafting);
        TileEntitySmithingAnvil.Result result = te.getResult(inventoryPlayer.player.getUniqueID());
        this.progress = result.progress;
        this.recipes = result.recipes;
        iCrafting.sendProgressBarUpdate(this, 0, this.progress);
        if(result.getRecipe() != null)
        {
            this.time = result.getRecipe().getTime();
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
            for (Object crafter : this.crafters)
            {
                if (crafter instanceof EntityPlayerMP)
                {
                    ((EntityPlayerMP) crafter).isChangingQuantityOnly = false;
                }
            }
        }

        super.detectAndSendChanges();

        if(this.progress != result.progress)
        {
            this.progress = result.progress;
            for (Object crafter : this.crafters)
            {
                ((ICrafting) crafter).sendProgressBarUpdate(this, 0, this.progress);
            }
        }
        if(result.getRecipe() != this.recipe)
        {
            this.recipe = result.getRecipe();
            if(result.getRecipe() != null)
            {
                this.time = result.getRecipe().getTime();
                for (Object crafter : this.crafters)
                {
                    if (crafter instanceof EntityPlayerMP)
                    {
                        ((EntityPlayerMP) crafter).isChangingQuantityOnly = false;
                    }
                    ((ICrafting) crafter).sendProgressBarUpdate(this, 1, this.time);
                    ((ICrafting) crafter).sendSlotContents(this, inventorySlots.size() + 2, recipe.getResult());
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
                    ((ICrafting) crafter).sendSlotContents(this, inventorySlots.size() + 2, null);
                }
            }
        }
    }

    @Override
    public ItemStack slotClick(int slotId, int clickedButton, int mode, EntityPlayer player)
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
            ItemStack stack = super.slotClick(slotId, clickedButton, mode, player);
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
        if(slot >= inventorySlots.size())
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
