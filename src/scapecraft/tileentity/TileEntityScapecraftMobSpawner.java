package scapecraft.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import scapecraft.entity.EntityScapecraft;
import scapecraft.entity.ScapecraftEntities;

public class TileEntityScapecraftMobSpawner extends TileEntity
{
	public String entityName = "";
	public int spawnInterval = 1200;
	public int maxSpawn = 1;
	public List<Integer> spawnedIds = new ArrayList<Integer>();

	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		tagCompound.setString("entityName", entityName);
		tagCompound.setInteger("spawnInterval", spawnInterval);
		tagCompound.setInteger("maxSpawn", maxSpawn);
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		entityName = tagCompound.getString("entityName");
		spawnInterval = tagCompound.getInteger("spawnInterval");
		maxSpawn = tagCompound.getInteger("maxSpawn");
	}

	@Override
	public void updateEntity()
	{
		if(this.worldObj != null && !this.worldObj.isRemote && this.worldObj.getTotalWorldTime() % 20L == 0L)
		{
			if(spawnedIds.size() < this.maxSpawn)
			{
				if(this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) == 1)
				{
					this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 0, 3);
				}
				if(this.worldObj.getTotalWorldTime() % spawnInterval == 0L)
				{
					for(int i = 0; i < spawnedIds.size(); i++)
					{
						Entity entity = this.worldObj.getEntityByID(spawnedIds.get(i));
						if(entity == null || entity.isDead)
						{
							spawnedIds.remove(i);
							i--;

							if(spawnedIds.size() < maxSpawn && this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) == 1)
							{
								this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 0, 3);
							}
						}
					}

					String name = entityName;
					if(name == null || name.isEmpty())
					{
						return;
					}
					int index = -1;
					ArrayList<String> args = new ArrayList<String>();
					while((index = name.indexOf(' ')) != -1)
					{
						args.add(name.substring(0, index));
						name = name.substring(index + 1);
					}
					args.add(name);

					EntityScapecraft entity = ScapecraftEntities.spawnScapecraftEntity(args.get(0), this.worldObj);
					if(entity == null)
					{
						System.out.printf("Mob Spawner at %d, %d, %d spawned null entity \"%s\"\n", this.xCoord, this.yCoord, this.zCoord, entityName);
						return;
					}
					int y = this.yCoord + 1;
					while( y < 256 && this.worldObj.getBlock(this.xCoord, y, this.zCoord).isOpaqueCube())
					{
						y++;
					}
					entity.setLocationAndAngles(this.xCoord, y, this.zCoord, 0F, 0F);
					entity.onSpawnerSpawn(args);
					this.worldObj.spawnEntityInWorld(entity);
					spawnedIds.add(entity.getEntityId());
					entity.mobSpawner = this;
					if(spawnedIds.size() >= maxSpawn)
					{
						this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 1, 3);
					}
				}
			}
		}
	}

	public void onSpawnedDeath(EntityScapecraft entity)
	{
		for(int i = 0; i < this.spawnedIds.size(); i++)
		{
			if(this.spawnedIds.get(i) == entity.getEntityId())
			{
				spawnedIds.remove(i);
				if(this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) == 1)
				{
					this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 0, 3);
				}
				return;
			}
		}
	}
}
