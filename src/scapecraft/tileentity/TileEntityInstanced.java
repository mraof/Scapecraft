package scapecraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import scapecraft.inventory.InventoryScapecraft;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mraof on 2016 March 02.
 */
public abstract class TileEntityInstanced extends TileEntity
{
    protected HashMap<UUID, InventoryScapecraft> inventories = new HashMap<UUID, InventoryScapecraft>();

    protected abstract InventoryScapecraft createInventory();

    public InventoryScapecraft getInventory(EntityPlayer player)
    {
        this.markDirty();
        if(!inventories.containsKey(player.getUniqueID()))
        {
            inventories.put(player.getUniqueID(), createInventory());
        }
        return inventories.get(player.getUniqueID());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        inventories.clear();
        NBTTagList inventoryTagList = compound.getTagList("inventories", 10);
        for(int i = 0; i < inventoryTagList.tagCount(); i++)
        {
            NBTTagCompound inventoryTagCompound = inventoryTagList.getCompoundTagAt(i);
            UUID uuid = UUID.fromString(inventoryTagCompound.getString("uuid"));
            InventoryScapecraft inventory = new InventoryScapecraft(inventoryTagCompound.getInteger("size"));
            NBTTagList slotTagList = inventoryTagCompound.getTagList("inventory", 10);
            for(int j = 0; j < slotTagList.tagCount(); j++)
            {
                inventory.setInventorySlotContents(slotTagList.getCompoundTagAt(j).getInteger("Slot"), ItemStack.loadItemStackFromNBT(slotTagList.getCompoundTagAt(j)));
            }
            inventories.put(uuid, inventory);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        NBTTagList inventoryTagList = new NBTTagList();
        for(Map.Entry<UUID, InventoryScapecraft> entry : inventories.entrySet())
        {
            NBTTagCompound inventoryTagCompound = new NBTTagCompound();
            NBTTagList slotTagList = new NBTTagList();
            for(int i = 0; i < entry.getValue().getSizeInventory(); i++)
            {
                if(entry.getValue().getStackInSlot(i) != null)
                {
                    NBTTagCompound slotTagCompound = new NBTTagCompound();
                    slotTagCompound.setByte("Slot", (byte) i);
                    entry.getValue().getStackInSlot(i).writeToNBT(slotTagCompound);
                    slotTagList.appendTag(slotTagCompound);
                }
            }
            if(slotTagList.tagCount() != 0) //Don't store empty inventories
            {
                inventoryTagCompound.setInteger("size", entry.getValue().getSizeInventory());
                inventoryTagCompound.setString("uuid", entry.getKey().toString());
                inventoryTagCompound.setTag("inventory", slotTagList);
                inventoryTagList.appendTag(inventoryTagCompound);
            }
        }
        compound.setTag("inventories", inventoryTagList);
    }
}
