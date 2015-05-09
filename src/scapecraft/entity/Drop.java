package scapecraft.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Drop
{
	public ItemStack stack;
	public int chance;
	public boolean custom;

	public Drop(ItemStack stack, int chance, boolean custom)
	{
		this.stack = stack;
		this.chance = chance;
		this.custom = custom;
	}

	public NBTTagCompound toNBT()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("chance", chance);
		nbt.setBoolean("custom", custom);
		nbt.setTag("stack", stack.writeToNBT(new NBTTagCompound()));
		return nbt;
	}

	public static Drop fromNBT(NBTTagCompound nbt)
	{
		Drop drop = new Drop(ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("stack")), nbt.getInteger("chance"), nbt.getBoolean("custom"));
		return drop;
	}
}

