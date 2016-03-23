package scapecraft.tileentity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import scapecraft.entity.Drop;
import scapecraft.entity.EntityScapecraft;
import scapecraft.entity.MobSpawner;
import scapecraft.entity.ScapecraftEntities;
import scapecraft.util.Stats;

import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TileEntityScapecraftMobSpawner extends TileEntity implements MobSpawner
{
	public String entityName = "";
	public int spawnInterval = 1200;
	public int maxSpawn = 1;
	public int texture;
	public int radius;
	public LinkedHashSet<Integer> spawnedIds = new LinkedHashSet<Integer>();
	public DelayQueue<KillTime> killTimes = new DelayQueue<KillTime>();
	Random random = new Random();
	public ArrayList<Drop> drops = null;
	public int[] moneyDrops = null;

	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		tagCompound.setString("entityName", entityName);
		tagCompound.setInteger("spawnInterval", spawnInterval);
		tagCompound.setInteger("maxSpawn", maxSpawn);
		tagCompound.setInteger("texture", texture);
		tagCompound.setInteger("radius", radius);
		if(drops != null)
		{
			NBTTagList dropList = new NBTTagList();
			for (Drop drop : drops)
			{
				dropList.appendTag(drop.toNBT());
			}
			tagCompound.setTag("drops", dropList);
		}
		if(moneyDrops != null)
		{
			tagCompound.setIntArray("moneyDrops", moneyDrops);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		entityName = tagCompound.getString("entityName");
		spawnInterval = tagCompound.getInteger("spawnInterval");
		maxSpawn = tagCompound.getInteger("maxSpawn");
		texture = tagCompound.getInteger("texture");
		radius = tagCompound.getInteger("radius");
		if(tagCompound.hasKey("drops"))
		{
			drops = new ArrayList<Drop>();
			NBTTagList dropList = tagCompound.getTagList("drops", tagCompound.getId());
			for (int i = 0; i < dropList.tagCount(); i++)
			{
				drops.add(Drop.fromNBT(dropList.getCompoundTagAt(i)));
			}
		}
		if(tagCompound.hasKey("moneyDrops"))
		{
			moneyDrops = tagCompound.getIntArray("moneyDrops");
		}
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
				if(this.spawnInterval > 0 && this.worldObj.getTotalWorldTime() % spawnInterval == 0L)
				{
					Iterator<Integer> it = spawnedIds.iterator();
					while(it.hasNext())
					{
						Entity entity = this.worldObj.getEntityByID(it.next());
						if(entity == null || entity.isDead)
						{
							it.remove();
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
					int index;
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
					ArrayList<KillTime> expired = new ArrayList<KillTime>();
					killTimes.drainTo(expired);
					entity.setHero(killTimes.size() > random.nextInt(maxSpawn * 2));
					if(entity.isHero())
					{
						ArrayList<KillTime> nonExpired = new ArrayList<KillTime>(killTimes);
						killTimes.clear();
						int level = 0;
						for(KillTime killTime : nonExpired)
						{
							level += killTime.level;
						}
						level /= nonExpired.size();
						System.out.println("Hero level " + level);
						entity.minLevel = level;
						entity.maxLevel = level;
					}
					double angle = random.nextDouble() * 2 * Math.PI;
					double r = radius * random.nextDouble();
					int x = (int) (this.xCoord + (Math.sin(angle) * r));
					int y = this.yCoord + 1;
					int z = (int) (this.zCoord + (Math.cos(angle) * r));
					while( y < this.yCoord + radius && this.worldObj.getBlock(x, y, z).isOpaqueCube())
					{
						y++;
					}
					entity.setLocationAndAngles(x, y, z, 0F, 0F);
					entity.onSpawnerSpawn(args);
					entity.setTexture(texture);
					this.worldObj.spawnEntityInWorld(entity);
					this.addSpawned(entity);
				}
			}
		}
	}

	@Override
	public void onSpawnedDeath(Entity entity)
	{
		float totalDamage = 0;
		ArrayList<Float> levels = new ArrayList<Float>();
		for (Map.Entry<EntityPlayer, Float> entry : ((EntityScapecraft)entity).getRealAttackers().entrySet())
		{
			totalDamage += entry.getValue();
			levels.add(Stats.getCombatLevel(entry.getKey()) * entry.getValue());
		}
		float averageLevel = 0;
		for (float f : levels)
		{
			averageLevel += f / totalDamage;
		}
		if(averageLevel >= 1)
		{
			killTimes.add(new KillTime(MinecraftServer.getServer().getEntityWorld().getTotalWorldTime() + (this.maxSpawn / 2 * this.spawnInterval), (int) averageLevel));
		}
		Iterator<Integer> it = this.spawnedIds.iterator();
		while(it.hasNext())
		{
			if(it.next() == entity.getEntityId())
			{
				it.remove();
				if(this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) == 1)
				{
					this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 0, 3);
				}
				return;
			}
		}
	}

	@Override
	public ArrayList<Drop> getDrops(EntityScapecraft entity)
	{
		String name = entityName.toLowerCase();
		int index = entityName.indexOf(' ');
		if(index != -1)
		{
			name = entityName.substring(0, index);
		}
		return (drops == null) ? ((entity == null) ? ScapecraftEntities.getDrops(ScapecraftEntities.entityNames.get(name)) : ScapecraftEntities.getDrops(entity.getClass())) : drops;
	}

	@Override
	public int[] getMoneyDrops(EntityScapecraft entityScapecraft)
	{
		String name = entityName.toLowerCase();
		int index = entityName.indexOf(' ');
		if(index != -1)
		{
			name = entityName.substring(0, index);
		}
		Class<? extends Entity> mobClass = entityScapecraft == null ? ScapecraftEntities.entityNames.get(name) : entityScapecraft.getClass();
		return moneyDrops == null ? ScapecraftEntities.getMoneyDrops(mobClass) : moneyDrops;
	}

	public void addSpawned(EntityScapecraft entity)
	{
		this.spawnedIds.add(entity.getEntityId());
		entity.mobSpawner = this;
		entity.fromSpawner = true;
		entity.mobSpawnerX = this.xCoord;
		entity.mobSpawnerY = this.yCoord;
		entity.mobSpawnerZ = this.zCoord;
		if(spawnedIds.size() >= maxSpawn)
		{
			this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 1, 3);
		}
	}

	@SuppressWarnings("NullableProblems")
	private static class KillTime implements Delayed
	{
		private final long time;
		public final int level;

		private KillTime(long time, int level)
		{
			this.time = time;
			this.level = level;
		}

		/**
		 * Returns the remaining delay associated with this object, in the
		 * given time unit.
		 *
		 * @param unit the time unit
		 * @return the remaining delay; zero or negative values indicate
		 * that the delay has already elapsed
		 */
		@Override
		public long getDelay(TimeUnit unit)
		{
			return this.time - MinecraftServer.getServer().getEntityWorld().getTotalWorldTime();
		}

		@Override
		public int compareTo(Delayed o)
		{
			return o instanceof KillTime ? (int) (this.time - ((KillTime) o).time) : 0;
		}
	}
}
