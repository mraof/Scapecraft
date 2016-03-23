package scapecraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import scapecraft.inventory.InventoryScapecraft;
import scapecraft.item.QualityItem;
import scapecraft.util.SmithingRecipe;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mraof on 2016 March 02.
 */
public class TileEntitySmithingAnvil extends TileEntityInstanced
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
    public void updateEntity()
    {
        for(Map.Entry<UUID, InventoryScapecraft> entry : inventories.entrySet())
        {
            Result result = getResult(entry.getKey());
            EntityPlayer player;
            if(result.getRecipe() != null && (player = this.worldObj.getPlayerEntityByUUID(entry.getKey())) != null && (entry.getValue().getStackInSlot(2) == null || (result.getRecipe().getResult().isItemEqual(entry.getValue().getStackInSlot(2)) && entry.getValue().getStackInSlot(2).stackSize < entry.getValue().getStackInSlot(2).getMaxStackSize())))
            {
                result.progress++;
                if(result.progress >= result.getRecipe().getTime())
                {
                    result.progress = 0;
                    entry.getValue().decrStackSize(0, result.getRecipe().getIngotNum());
                    entry.getValue().decrStackSize(1, result.getRecipe().getStickNum());
                    if(entry.getValue().getStackInSlot(2) == null)
                    {
                        ItemStack stack = result.getRecipe().getResult().copy();
                        if(stack.getItem() instanceof QualityItem)
                        {
                            stack.setTagCompound(new NBTTagCompound());
                            stack.getTagCompound().setInteger("level", Stats.getLevel(player, Stat.SMITHING));
                            stack.getTagCompound().setString("source", "Smithed by " + player.getCommandSenderName());
                        }
                        entry.getValue().setInventorySlotContents(2, stack);
                    }
                    else
                    {
                        entry.getValue().getStackInSlot(2).stackSize++;
                    }
                    Stats.addXp(player, Stat.SMITHING, result.getRecipe().getXp());
                    onInventoryChanged(entry.getKey());
                }
            }
        }
    }

    public void onInventoryChanged(UUID uuid)
    {
        Result result = getResult(uuid);
        EntityPlayer player = this.worldObj.getPlayerEntityByUUID(uuid);
        result.recipes = SmithingRecipe.getRecipes(getInventory(player), player.capabilities.isCreativeMode ? 200 : Stats.getLevel(player, Stat.SMITHING));
        if(result.recipes == null || !result.recipes.contains(result.getRecipe()))
        {
            result.setRecipe(-1);
        }
    }

    public static class Result
    {
        public int progress = 0;
        public ArrayList<SmithingRecipe> recipes = new ArrayList<SmithingRecipe>();
        private SmithingRecipe recipe = null;

        public void setRecipe(int i)
        {
            recipe = recipes == null || i < 0 || i >= recipes.size() ? null : recipes.get(i);
            progress = 0;
        }

        public SmithingRecipe getRecipe()
        {
            return recipe;
        }
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
