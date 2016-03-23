package scapecraft.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Drop
{
	public final ItemStack stack;
	public final int chance;
	public final boolean custom;

	public Drop(ItemStack stack, int chance, boolean custom)
	{
		this.stack = stack;
		this.chance = chance;
		this.custom = custom;
	}

	public NBTTagCompound toNBT()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("price", chance);
		nbt.setBoolean("custom", custom);
		nbt.setTag("stack", stack.writeToNBT(new NBTTagCompound()));
		return nbt;
	}

	public static Drop fromNBT(NBTTagCompound nbt)
	{
		return new Drop(ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("stack")), nbt.getInteger("price"), nbt.getBoolean("custom"));
	}

	@Override
	public String toString()
	{
		return "Drop{" +
			   "stack=" + stack +
			   ", price=" + chance +
			   ", custom=" + custom +
			   '}';
	}
}

