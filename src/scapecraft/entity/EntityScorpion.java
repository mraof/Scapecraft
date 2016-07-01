package scapecraft.entity;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import scapecraft.entity.ai.EntityAIAttackWithDistance;


public class EntityScorpion extends EntityScapecraft
{
	private float moveSpeed;

	public EntityScorpion(World par1World)
	{
		super(par1World);
		this.setSize(3, 2);

		this.moveSpeed = 0.6F;

		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.addTargets(EntityBarbarian.class, EntityGuard.class, EntityKQ2.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityPlayer.class, EntityTormentedDemon.class);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackWithDistance(this, this.moveSpeed, 2));
		this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));


	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.50D);
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, (byte) 0);
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

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.ARTHROPOD;
	}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() != Potion.poison.id && super.isPotionApplicable(par1PotionEffect);
	}
}
