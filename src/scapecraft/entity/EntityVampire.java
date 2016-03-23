package scapecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import scapecraft.item.ScapecraftItems;

public class EntityVampire extends EntityScapecraft
{
	private float moveSpeed;
	
	public EntityVampire(World par1World)
	{
		super(par1World);
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos1.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos1.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos2.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos2.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos3.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos3.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTormentedDemon.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityTormentedDemon.class, this.moveSpeed, false));
		this.moveSpeed = 0.5F;
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWolf.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityOcelot.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityHellhound.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWhiteKnight.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWhiteKnight.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGreenDragon.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityGreenDragon.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGuard.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityGuard.class, this.moveSpeed, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKQ2.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKQ2.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKQ.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKQ.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWizard.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWizard.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHeroKnight.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityHeroKnight.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKing.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKing.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKingsGuard.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKingsGuard.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityFarmer.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityFarmer.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBarbarian.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityBarbarian.class, this.moveSpeed, false));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50000.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.50D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
	}
	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, (byte) 0);

	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		float var1 = this.getBrightness(1.0F);

		if (var1 < 0.5F)
		{
			double var2 = 16.0D;
			return this.worldObj.getClosestVulnerablePlayerToEntity(this, var2);
		}
		else
		{
			return null;
		}
	}


	/**
	 * Returns the sound this mob makes while it's alive.
	 protected String getLivingSound()
	 {
	 return "mob.villager.default";
	 }

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return "mob.villager.defaulthurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return "mob.villager.defaultdeath";
	}

	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
	 */
	@Override
	protected void attackEntity(Entity par1Entity, float par2)
	{
		float var3 = this.getBrightness(1.0F);

		if (var3 > 0.5F && this.rand.nextInt(100) == 0)
		{
			this.entityToAttack = null;
		}
		else
		{
			if (par2 > 2.0F && par2 < 6.0F && this.rand.nextInt(10) == 0)
			{
				if (this.onGround)
				{
					double var4 = par1Entity.posX - this.posX;
					double var6 = par1Entity.posZ - this.posZ;
					float var8 = MathHelper.sqrt_double(var4 * var4 + var6 * var6);
					this.motionX = var4 / (double)var8 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
					this.motionZ = var6 / (double)var8 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
					this.motionY = 0.4000000059604645D;
				}
			}
			else
			{
				super.attackEntity(par1Entity, par2);
			}
		}
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	} 

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() != Potion.poison.id && super.isPotionApplicable(par1PotionEffect);
	}

	private static final ItemStack defaultHeldItem;
	@Override
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	static
	{
		defaultHeldItem = new ItemStack(ScapecraftItems.equipmentSets.get("blackSword"), 1);
	}

	@Override
	public void damageEntity(DamageSource source, float damage)
	{
		if(source.getSourceOfDamage() instanceof EntityLivingBase && ((EntityLivingBase) source.getSourceOfDamage()).getHeldItem().getItem() == ScapecraftItems.stake)
		{
			damage *= 600;
		}
		super.damageEntity(source, damage);
	}
}
