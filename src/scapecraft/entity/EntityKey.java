package scapecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityKey extends Entity
{
	public int number;
	public EntityKey(World world)
	{
		super(world);
	}

	@Override
	protected void entityInit()
	{
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompound)
	{
		this.number = tagCompound.getShort("Number");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound)
	{
		tagCompound.setShort("Number", (short) this.number);
	}
}
