package scapecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import scapecraft.item.ScapecraftItems;

public class EntityHighMage extends EntityScapecraft implements IRangedAttackMob
{
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 0.25F, 40, 10.0F);
	private float moveSpeed;
	

	public EntityHighMage(World par1World)
	{
		super(par1World);

		this.moveSpeed = 0.1F;



		this.isImmuneToFire = true;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBarbarian.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGuard.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHellhound.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKing.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKingsGuard.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTD.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWhiteKnight.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWither.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWizard.class, 0, true));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityHellhound.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos1.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos2.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKos3.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityOcelot.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityTD.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWolf.class, this.moveSpeed, false));
		this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));



		if (par1World != null && !par1World.isRemote)
		{
			this.setCombatTask();
		}
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0D);
	}

	public String getEntityName()
	{
		return "High Mage";
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}
	@Override
	protected boolean canDespawn()
	{
		return true;
	}


	public boolean isAIEnabled()
	{
		return true;
	}
	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		super.onUpdate();


	}


	protected EntityBlackKnight createInstance()
	{
		return new EntityBlackKnight(this.worldObj);
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		Entity entity;
		entity = par1DamageSource.getSourceOfDamage();
		if (entity instanceof EntityArrow)
		{
			return false;
		}

		if(!worldObj.isRemote)
		{
			int j = 1;

			for (int k = 0; k < j; ++k)
			{
				float f = ((float)(k % 2) - 0.5F) * (float)1 / 4.0F;
				float f1 = ((float)(k / 2) - 0.5F) * (float)1 / 4.0F;
				EntityBlackKnight entityBlackKnight = this.createInstance();

				entityBlackKnight.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D, this.posZ + (double)f1, this.rand.nextFloat() * 360.0F, 0.0F);
				this.worldObj.spawnEntityInWorld(entityBlackKnight);


			}}

		return super.attackEntityFrom(par1DamageSource, par2);
	}

	protected String getHurtSound()
	{
		return "mob.villager.defaulthurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.villager.defaultdeath";
	}
	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	protected void playStepSound(int var1, int var2, int var3, int var4)
	{
		this.worldObj.playSoundAtEntity(this, "mob.villager.default", 0.15F, 1.0F);
	}

	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
	 */


	public int getTotalArmorValue()
	{
		return 13;
	}


	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
	}

	private static final ItemStack defaultHeldItem;
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	static
	{
		defaultHeldItem = new ItemStack(ScapecraftItems.armaStaff, 1);
	}

	public void setCombatTask()
	{
		this.tasks.removeTask(this.aiArrowAttack);
		this.tasks.addTask(4, this.aiArrowAttack);
	}



	public void attackEntityWithRangedAttack(EntityLiving entityliving, float f) {
		EntityArrow var2 = new EntityArrow(this.worldObj, this, entityliving, 15.0F, 12.0F);


		this.worldObj.spawnEntityInWorld(var2);
	}



	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase,
			float f) {
		EntityArrow var2 = new EntityArrow(this.worldObj, this, entitylivingbase, 25.0F, 12.0F);


		this.worldObj.spawnEntityInWorld(var2);

	}

	protected EntityEliteBlackKnight createInstance2()
	{
		return new EntityEliteBlackKnight(this.worldObj);
	}
	int spawnvar = 1;
	public void onLivingUpdate()
	{
		++spawnvar;

		if (spawnvar >= 300){
			if(!worldObj.isRemote)
			{
				int j = 1;

				for (int k = 0; k < j; ++k)
				{
					float f = ((float)(k % 2) - 0.5F) * (float)1 / 4.0F;
					float f1 = ((float)(k / 2) - 0.5F) * (float)1 / 4.0F;

					EntityEliteBlackKnight entityEliteBlackKnight = this.createInstance2();

					entityEliteBlackKnight.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D+1, this.posZ + (double)f1+4, this.rand.nextFloat() * 360.0F, 0.0F);
					this.worldObj.spawnEntityInWorld(entityEliteBlackKnight);
				}}

			spawnvar = 0;

		}
		if(ticksExisted > 600 * 20) setDead(); 
		super.onLivingUpdate();
	}	

	@Override
	public int getXpValue()
	{
		return 800; //TODO Make a better value
	}

}
