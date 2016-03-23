package scapecraft.tileentity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import scapecraft.block.BlockBlockSpawner;

public class TileEntityBlockSpawner extends TileEntity
{
	public long startTime = 0L;
	public int uses = -1;
	public boolean growing = true;

	@Override
	public void updateEntity()
	{
		if(this.growing && this.worldObj != null && !this.worldObj.isRemote && this.worldObj.getTotalWorldTime() % 20L == 0L)
		{
			BlockBlockSpawner block = (BlockBlockSpawner) this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord);
			if(startTime == 0L)
			{
				startTime = MinecraftServer.getServer().getEntityWorld().getTotalWorldTime();
				return;
			}
			int metadata;
			if((metadata = worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord)) == block.fullSize)
			{
				this.growing = false;
				return;
			}
			if(block.getRegenTime() < 320)
			{
				worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, metadata + 320 / block.getRegenTime() > block.fullSize ? block.fullSize : metadata + 320 / block.getRegenTime(), 3);
				return;
			}

			if((MinecraftServer.getServer().getEntityWorld().getTotalWorldTime() - startTime) * 16 / block.getRegenTime() > metadata)
			{
				worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, metadata + 1, 3);
				if(metadata + 1 == block.fullSize)
				{
					this.growing = false;
					block.onFullyGrown(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
				}

				for(Object obj : worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord, this.xCoord, this.xCoord + 1, this.yCoord + 1, this.zCoord + 1)))
				{
					EntityLivingBase entity = (EntityLivingBase) obj;
					entity.setPosition(entity.posX, entity.posY + 0.2, entity.posZ);
				}
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setLong("startTime", startTime);
		compound.setInteger("uses", uses);
		compound.setBoolean("growing", growing);
		compound.setBoolean("updated", true);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.startTime = compound.getLong("startTime");
		this.uses = compound.getInteger("uses");
		this.growing = compound.getBoolean("growing");
		if(!compound.getBoolean("updated"))
		{
			this.uses = 50;
		}
	}
}
