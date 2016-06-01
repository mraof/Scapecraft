package scapecraft.entity;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.client.gui.GuiHandler;
import scapecraft.item.ScapecraftItems;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;

import java.util.ArrayList;

public class EntityShopshifter extends EntityShapeshifter
{
	public ArrayList<ItemStack> stock = new ArrayList<ItemStack>();

	public EntityShopshifter(World world)
	{
		this(world, "");
	}

	public EntityShopshifter(World world, String mobName)
	{
		super(world, mobName);
		stock.add(new ItemStack(ScapecraftItems.equipmentSets.get("runeAxe"), 64));
		this.targetClasses.clear();
		this.targetTasks.taskEntries.clear();
		this.tasks.taskEntries.clear();
		this.tasks.addTask(5, new EntityAIWander(this, 0.2D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.xpBase = 0;
		this.xpGrowth = 0;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if(source != DamageSource.outOfWorld && !(source.getSourceOfDamage() instanceof EntityShapeshifter))
		{
			amount = 0;
			if(source.getSourceOfDamage() != null)
			{
				source.getSourceOfDamage().attackEntityFrom(DamageSource.causeMobDamage(this), amount);
			}
		}
		return super.attackEntityFrom(source, amount);
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		if(!worldObj.isRemote)
		{
			player.openGui(Scapecraft.instance, GuiHandler.GuiId.SHOP.ordinal(), worldObj, mobSpawnerX, mobSpawnerY, mobSpawnerZ);
		}
		return true;
	}

	@Override
	public void setMob(String mobName)
	{
		super.setMob(mobName);
		if(!worldObj.isRemote)
		{
			ArrayList<Drop> drops = this.mobSpawner == null ? ScapecraftEntities.getDrops(this.getClass()) : this.mobSpawner.getDrops(this);
			if(drops.size() > 0)
			{
				Drop drop = drops.get(rand.nextInt(drops.size()));
				this.copiedMob.setCurrentItemOrArmor(0, drop.stack.copy());
			}
		}
	}

	@Override
	public void onSpawnerSpawn(ArrayList<String> args)
	{
		super.onSpawnerSpawn(args);
		if(mobSpawner instanceof TileEntityScapecraftMobSpawner)
		{
			this.setHomeArea(this.mobSpawnerX, this.mobSpawnerY, this.mobSpawnerZ, ((TileEntityScapecraftMobSpawner) mobSpawner).radius);
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompound)
	{
		super.readEntityFromNBT(tagCompound);
	}

	@Override
	public void setWorld(World world)
	{
		super.setWorld(world);

		if(mobSpawner instanceof TileEntityScapecraftMobSpawner)
		{
			this.setHomeArea(this.mobSpawnerX, this.mobSpawnerY, this.mobSpawnerZ, ((TileEntityScapecraftMobSpawner) mobSpawner).radius);
		}
	}

	@Override
	protected void dropFewItems(boolean recentlyHit, int looting)
	{}
}
