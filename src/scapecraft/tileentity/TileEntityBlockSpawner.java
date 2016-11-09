package scapecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityBlockSpawner extends TileEntity implements ITickable
{
	public long startTime = 0L;
	public int uses = -1;
	public boolean growing = true;

	@Override
	public void update()
	{
/*		if(this.growing && this.worldObj != null && !this.worldObj.isRemote && this.worldObj.getTotalWorldTime() % 20L == 0L)
		{
			IBlockState blockState = (BlockBlockSpawner) this.worldObj.getBlockState(this.pos);
			if(startTime == 0L)
			{
				startTime = FMLCommonHandler.instance().getMinecraftServerInstance().getEntityWorld().getTotalWorldTime();
				return;
			}
			int metadata;
			if((metadata = worldObj.getBlockMetadata(this.pos)) == blockState.fullSize)
			{
				this.growing = false;
				return;
			}
			if(blockState.getRegenTime() < 320)
			{
				worldObj.setBlockMetadataWithNotify(this.pos, metadata + 320 / blockState.getRegenTime() > blockState.fullSize ? blockState.fullSize : metadata + 320 / blockState.getRegenTime(), 3);
				return;
			}

			if((FMLCommonHandler.instance().getMinecraftServerInstance().getEntityWorld().getTotalWorldTime() - startTime) * 16 / blockState.getRegenTime() > metadata)
			{
				worldObj.setBlockMetadataWithNotify(this.pos, metadata + 1, 3);
				if(metadata + 1 == blockState.fullSize)
				{
					this.growing = false;
					blockState.onFullyGrown(this.worldObj, this.pos);
				}

				for(Object obj : worldObj.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(this.pos, this.pos.add(1, 1, 1))))
				{
					EntityLivingBase entity = (EntityLivingBase) obj;
					entity.setPosition(entity.posX, entity.posY + 0.2, entity.posZ);
				}
			}
		}*/
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setLong("startTime", startTime);
		compound.setInteger("uses", uses);
		compound.setBoolean("growing", growing);
		compound.setBoolean("updated", true);
		return compound;
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
