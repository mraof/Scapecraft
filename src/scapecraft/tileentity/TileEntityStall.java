package scapecraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.TextComponentString;
import scapecraft.economy.EconomyHandler;

public class TileEntityStall extends TileEntity
{
	ItemStack itemStack = new ItemStack(Items.FISH);
	int price = 20;
	boolean infinite = true;

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		price = tagCompound.getInteger("price");
		itemStack = ItemStack.loadItemStackFromNBT(tagCompound.getCompoundTag("item"));
		if(itemStack == null)
		{
			itemStack = new ItemStack(Items.FISH);
			price = 20;
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("price", price);
		NBTTagCompound itemNBT = new NBTTagCompound();
		itemStack.writeToNBT(itemNBT);
		tagCompound.setTag("item", itemNBT);
		return itemNBT;
	}

	public boolean giveItem(EntityPlayer player)
	{
		if(!player.worldObj.isRemote)
		{
			if(EconomyHandler.getBalance(player.getUniqueID()) < price)
			{
				player.addChatMessage(new TextComponentString("Not enough money"));
				return false;
			}
			if(!player.inventory.addItemStackToInventory(itemStack))
			{
				player.addChatMessage(new TextComponentString("Not enough inventory space"));
				return false;
			}

			EconomyHandler.deposit(player.getUniqueID(), -price);
			return true;
		}

		return false;
	}
}
