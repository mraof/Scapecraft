package scapecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class EntitySergeantGrimspike extends EntityScapecraft implements IRangedAttackMob
{
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 0.25F, 60, 10.0F);
	private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.31F, false);
	private float moveSpeed;

	

	public EntitySergeantGrimspike(World par1World)
	{
		super(par1World);

		this.moveSpeed = 0.3F;
		this.isImmuneToFire = true;

		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos1.class, this.moveSpeed, false));

		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos2.class, this.moveSpeed, false));

		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos3.class, this.moveSpeed, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTormentedDemon.class, 0, true));

		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWhiteKnight.class, 0, true));

		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGreenDragon.class, 0, true));

		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGuard.class, 0, true));

		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));

		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKQ2.class, 0, true));

		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKQ.class, 0, true));

		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWizard.class, 0, true));

		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHeroKnight.class, 0, true));

		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKing.class, 0, true));

		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKingsGuard.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBarbarian.class, 0, true));

		if (par1World != null && !par1World.isRemote)

		{
			this.setCombatTask();
		}

	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12.0D);
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
		return EnumCreatureAttribute.UNDEAD;
	}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() != Potion.poison.id && super.isPotionApplicable(par1PotionEffect);
	}

	public void setCombatTask()
	{
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.removeTask(this.aiArrowAttack);
		this.tasks.addTask(4, this.aiArrowAttack);

	}

	@Override
	public boolean isBurning()
	{
		return false;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase,
			float f) {
		EntityArrow var2 = new EntityArrow(this.worldObj, this, entitylivingbase, 5.6F, 12.0F);


		this.worldObj.spawnEntityInWorld(var2);

	}

}
