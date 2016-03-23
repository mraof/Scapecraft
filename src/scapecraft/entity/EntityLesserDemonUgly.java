package scapecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityLesserDemonUgly extends EntityScapecraft
{
	private float moveSpeed;

	

	public EntityLesserDemonUgly(World par1World)
	{
		super(par1World);

		this.moveSpeed = 0.5F;
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBlackDragon.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityBlackDragon.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos1.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos1.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos2.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos2.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos3.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos3.class, this.moveSpeed, false));

		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTormentedDemon.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityTormentedDemon.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWolf.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityOcelot.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityHellhound.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBarbarian.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityBarbarian.class, this.moveSpeed, false));
		this.setSize(this.width * 2.0F, this.height * 2.0F);
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWhiteKnight.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWhiteKnight.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGuard.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityGuard.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWizard.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWizard.class, this.moveSpeed, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKing.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKing.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKingsGuard.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKingsGuard.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHeroKnight.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityHeroKnight.class, this.moveSpeed, false));

		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityFarmer.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityFarmer.class, this.moveSpeed, false));
	}


	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(80.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.60D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
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



	public boolean isBesideClimbableBlock()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
	 * false.
	 */
	@Override
	public boolean isOnLadder()
	{
		return this.isBesideClimbableBlock();
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		float var1 = this.getBrightness(1.0F);

		if (var1 < 100F)
		{
			double var2 = 16.0D;
			return this.worldObj.getClosestVulnerablePlayerToEntity(this, var2);
		}
		else
		{
			return null;
		}
	}

	@Override
	protected String getLivingSound()
	{
		return "mob.zombie.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound()
	{
		return "mob.zombie.hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return "mob.zombie.death";
	}



	@Override
	protected float getSoundVolume()
	{
		return 0.4F;
	}

	@Override
	protected boolean canDespawn()
	{
		return false;
	}

}
