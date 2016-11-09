package scapecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import scapecraft.item.ScapecraftItems;

public class EntityHighMage extends EntityScapecraft implements IRangedAttackMob
{
/*	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 0.25F, 40, 10.0F);*/
	private int spawnvar = 1;

	public EntityHighMage(World par1World)
	{
		super(par1World);

		float moveSpeed = 0.1F;

		this.isImmuneToFire = true;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, moveSpeed, false));
		this.tasks.addTask(5, new EntityAIWander(this, moveSpeed));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));

		this.addTargets(EntityBarbarian.class, EntityGuard.class, EntityHellhound.class, EntityKing.class, EntityKingsGuard.class, EntityPlayer.class, EntityTormentedDemon.class, EntityWhiteKnight.class, EntityWither.class, EntityWizard.class);

	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
	}

	@Override
	protected boolean canDespawn()
	{
		return true;
	}

	protected EntityBlackKnight createInstance()
	{
		return new EntityBlackKnight(this.worldObj);
	}

	@Override
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

	@Override
	protected SoundEvent getHurtSound()
	{
		//return "mob.villager.defaulthurt";
		return SoundEvents.ENTITY_VILLAGER_HURT;
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected SoundEvent getDeathSound()
	{
		//return "mob.villager.defaultdeath";
		return SoundEvents.ENTITY_VILLAGER_DEATH;
	}

	private static final ItemStack defaultHeldItem;
	@Override
	public ItemStack getHeldItemMainhand()
	{
		return defaultHeldItem;
	}

	static
	{
		defaultHeldItem = new ItemStack(ScapecraftItems.armaStaff, 1);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase, float f) {
/*		EntityArrow var2 = new EntityArrow(this.worldObj, this, entitylivingbase, 25.0F, 12.0F);
		this.worldObj.spawnEntityInWorld(var2);*/
	}

	protected EntityEliteBlackKnight createInstance2()
	{
		return new EntityEliteBlackKnight(this.worldObj);
	}
	@Override
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
		super.onLivingUpdate();
	}
}
