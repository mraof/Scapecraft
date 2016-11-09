package scapecraft.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import scapecraft.inventory.InventoryScapecraft;
import scapecraft.util.SmeltingRecipe;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.util.*;

/**
 * Created by mraof on 2016 March 02.
 */
public class TileEntitySmeltingFurnace extends TileEntityInstanced implements ITickable
{
    private HashMap<UUID, Result> progressMap = new HashMap<UUID, Result>();

    @Override
    protected InventoryScapecraft createInventory()
    {
        return new InventoryScapecraft(3);
    }

    public Result getResult(UUID uuid)
    {
        if (!progressMap.containsKey(uuid))
        {
            progressMap.put(uuid, new Result());
        }
        return progressMap.get(uuid);
    }

    @Override
    public void update()
    {
        for(Map.Entry<UUID, InventoryScapecraft> entry : inventories.entrySet())
        {
            Result result = getResult(entry.getKey());
            if(result.recipe != null && this.worldObj.getPlayerEntityByUUID(entry.getKey()) != null && (entry.getValue().getStackInSlot(2) == null || (result.recipe.getResult().isItemEqual(entry.getValue().getStackInSlot(2)) && entry.getValue().getStackInSlot(2).stackSize < entry.getValue().getStackInSlot(2).getMaxStackSize())))
            {
                result.progress++;
                if(result.progress >= result.recipe.getTime())
                {
                    result.progress = 0;
                    ArrayList<ItemStack> ingredients = result.recipe.getIngredients();
                    for(int i = 0; i < 2; i++)
                    {
                        Iterator<ItemStack> it = ingredients.iterator();
                        while (it.hasNext())
                        {
                            ItemStack stack = it.next();

                            if(entry.getValue().getStackInSlot(i) != null && stack.isItemEqual(entry.getValue().getStackInSlot(i)))
                            {
                                entry.getValue().decrStackSize(i, stack.stackSize);
                                it.remove();
                            }
                        }
                    }
                    if(entry.getValue().getStackInSlot(2) == null)
                    {
                        entry.getValue().setInventorySlotContents(2, result.recipe.getResult().copy());
                    }
                    else
                    {
                        entry.getValue().getStackInSlot(2).stackSize++;
                    }
                    Stats.addXp(this.worldObj.getPlayerEntityByUUID(entry.getKey()), Stat.SMITHING, result.recipe.getXp());
                    onInventoryChanged(entry.getKey());
                }
            }
        }
    }

    public void onInventoryChanged(UUID uuid)
    {
        if(getResult(uuid).recipe != (getResult(uuid).recipe = SmeltingRecipe.getRecipe(inventories.get(uuid))))
        {
            if(getResult(uuid).recipe != null && getResult(uuid).recipe.getLevel() > Stats.getLevel(worldObj.getPlayerEntityByUUID(uuid), Stat.SMITHING))
            {
                getResult(uuid).recipe = null;
            }
            getResult(uuid).progress = 0;
        }
        this.markDirty();
    }

    public static class Result
    {
        public int progress = 0;
        public SmeltingRecipe recipe = null;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        for(UUID uuid : inventories.keySet())
        {
            onInventoryChanged(uuid);
        }
    }
}
