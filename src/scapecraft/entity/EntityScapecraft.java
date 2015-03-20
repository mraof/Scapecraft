package scapecraft.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.command.IEntitySelector;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import scapecraft.Stats;
import scapecraft.economy.EconomyHandler;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;

public abstract class EntityScapecraft extends EntityMob implements XpDropper, IEntitySelector
{
	protected HashMap<EntityPlayer, Float> attackers = new HashMap<EntityPlayer, Float>();
	public static HashMap<Class<? extends EntityScapecraft>, ArrayList<Drop>> drops = new HashMap<Class<? extends EntityScapecraft>, ArrayList<Drop>>();
	public static HashMap<Class<? extends EntityScapecraft>, List<Integer>> moneyDrops = new HashMap<Class<? extends EntityScapecraft>, List<Integer>>();
	protected int lifespan;
	public Set<Class<? extends EntityLivingBase>> targetClasses = new HashSet<Class<? extends EntityLivingBase>>();
	public boolean passive = true;
	public TileEntityScapecraftMobSpawner mobSpawner = null;
	public int level = 1;

	public EntityScapecraft(World par1World) 
	{
		super(par1World);
		this.addArmor();
	}

	public void giveXp()
	{
		double money = moneyDrops.get(this.getClass()) != null && rand.nextInt(10) == 0 ? moneyDrops.get(this.getClass()).get(rand.nextInt(moneyDrops.get(this.getClass()).size())) : 0;
		float damageTaken = 0;
		for(Float damage : attackers.values())
		{
			damageTaken += damage;
		}

		for(Entry<EntityPlayer, Float> entry : attackers.entrySet())
		{
			Stats.addXp(entry.getKey(), "combat", (int) (damageTaken / entry.getValue() * this.getXpValue()));
			if(money > 0)
			{
				EconomyHandler.deposit(entry.getKey().getUniqueID(), damageTaken / entry.getValue() * money);
			}
		}
	}

	public int getXpValue()
	{
		return 0;
	}

	protected void dropFewItems(boolean recentlyHit, int looting)
	{
		if(drops.get(this.getClass()) != null && recentlyHit)
			for(Drop drop : drops.get(this.getClass()))
				if(rand.nextInt(drop.chance) == 0)
					entityDropItem(drop.stack.copy(), 1);
	}

	public static void addDrop(Class<? extends EntityScapecraft> entityClass, int chance, ItemStack stack)
	{
		addDrop(entityClass, new Drop(stack, chance, false));
	}

	public static void addDrop(Class<? extends EntityScapecraft> entityClass, Drop drop)
	{
		ArrayList<Drop> list = drops.get(entityClass);
		if(list == null)
			list = new ArrayList<Drop>();
		list.add(drop);
		drops.put(entityClass, list);
	}

	public static void setMoney(Class<? extends EntityScapecraft> entityClass, Integer... money)
	{
		moneyDrops.put(entityClass, Arrays.asList(money));
	}

	@Override
	public void onLivingUpdate()
	{
		if(lifespan != 0 && ticksExisted > lifespan && this.entityToAttack != null && !this.entityToAttack.isDead)
			setDead(); 
		super.onLivingUpdate();
	}

	@Override
	protected void attackEntity(Entity entity, float f)
	{
		if (this.attackTime <= 0 && f < 2.0F && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY)
		{
			this.attackTime = 20;
			this.attackEntityAsMob(entity);
		}
	}

	public float getAttackStrength(Entity entity)
	{
		float damage = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();

		if(entity instanceof EntityLivingBase)
			damage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)entity);

		return damage;
	}

	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		if(entity.attackEntityFrom(DamageSource.causeMobDamage(this), getAttackStrength(entity)))
		{
			if(entity instanceof EntityLivingBase)
			{
				int knockback = EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) entity);
				if(knockback > 0)
				{
					entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)knockback* 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)knockback* 0.5F));
					this.motionX *= 0.6D;
					this.motionZ *= 0.6D;
				}

				EnchantmentHelper.func_151384_a((EntityLivingBase) entity, this);
			}

			int fire = EnchantmentHelper.getFireAspectModifier(this) * 4;
			if(fire > 0)
				entity.setFire(fire);

			EnchantmentHelper.func_151385_b(this, entity);

			return true;
		}
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage)
	{
		float oldHealth = this.getHealth();
		boolean success = super.attackEntityFrom(source, damage);
		if(success && !this.worldObj.isRemote && source.getEntity() instanceof EntityPlayer && !((EntityPlayer) source.getEntity()).capabilities.isCreativeMode)
		{
			EntityPlayer attacker = (EntityPlayer) source.getEntity();
			if(attackers.get(attacker) == null)
			{
				attackers.put(attacker, oldHealth - this.getHealth());
			}
			else
			{
				attackers.put(attacker, attackers.get(attacker) + oldHealth - this.getHealth());
			}

			if(this.getHealth() <= 0)
			{
				this.giveXp();
			}
		}
		return success;
	}

	@Override
	public boolean isEntityApplicable(Entity entity)
	{
		if(entity instanceof EntityPlayer && !passive)
		{
			return true;
		}
		return targetClasses.contains(entity.getClass());
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		return passive ? null : super.findPlayerToAttack();
	}

	/*
	 * Object instead of Class to avoid warnings because java is weird
	 */
	@SuppressWarnings("unchecked")
	public void addTargets(Object... entityClasses)
	{
		for(Object entityClass : entityClasses)
		{
			if(entityClass.equals(EntityPlayer.class))
			{
				passive = false;
			}
			else if(EntityLivingBase.class.isAssignableFrom((Class<?>) entityClass))
			{
				targetClasses.add((Class<? extends EntityLivingBase>) entityClass);
			}
		}
	}

	public void onSpawnerSpawn(ArrayList<String> args)
	{
		for(int i = 1; i < args.size(); i++)
		{
			if(args.get(i).startsWith("level="))
			{
				try
				{
					String levels = args.get(i).substring(6);
					if(levels.contains("-"))
					{
						String[] levelRange = levels.split("-");
						level = Integer.parseInt(levelRange[0]) + rand.nextInt(Integer.parseInt(levelRange[1]) - Integer.parseInt(levelRange[0]));
					}
					else
					{
						level = Integer.parseInt(levels);
					}

					this.setLevel(level);
					this.setHealth(this.getMaxHealth());
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else if(args.get(i).startsWith("passive="))
			{
				passive = Boolean.valueOf(args.get(i).substring(8));
			}
		}
	}

	public void setLevel(int level)
	{
	}

	public void addArmor()
	{
	}

	@Override
	public void addRandomArmor()
	{
		this.addArmor();
		for(int i = 0; i < equipmentDropChances.length; i++)
		{
			equipmentDropChances[i] = 0F;
		}
	}

	@Override
	public void setEquipmentDropChance(int slot, float chance)
	{
		equipmentDropChances[slot] = 0F;
	}

	@Override
	protected void dropEquipment(boolean b, int i)
	{
	}

	@Override
	public void setDead()
	{
		super.setDead();
		if(mobSpawner != null && !worldObj.isRemote)
		{
			mobSpawner.onSpawnedDeath(this);
		}
	}

	@Override
	public int getExperiencePoints(EntityPlayer player)
	{
		return (int) Math.sqrt(this.getXpValue()) + 5;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound)
	{
		super.writeEntityToNBT(tagCompound);
		tagCompound.setInteger("level", level);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompound)
	{
		super.readEntityFromNBT(tagCompound);
		level = tagCompound.getInteger("level");
		if(level < 1)
		{
			level = 1;
		}
	}
}
