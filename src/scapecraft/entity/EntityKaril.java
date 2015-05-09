package scapecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

public class EntityKaril extends EntityScapecraft implements IRangedAttackMob
{
	public EntityKaril(World par1World)
	{
		super(par1World);
		this.setSize(0.9F, 2.8F);
		this.isImmuneToFire = true;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBarbarian.class, EntityBlackDragon.class, EntityFarmer.class, EntityGuard.class, EntityHellhound.class, EntityKing.class, EntityKingsGuard.class, EntityPlayer.class, EntityTD.class, EntityWhiteKnight.class, EntityWither.class, EntityWizard.class);
		this.tasks.addTask(4, new EntityAIArrowAttack(this, 0.25F, 18, 20.0F));
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.36D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(11.0D);
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected String getHurtSound()
	{
		return "mob.villager.defaulthurt";
	}

	@Override
	protected String getDeathSound()
	{
		return "mob.villager.defaultdeath";
	}
	public int getTotalArmorValue()
	{
		return 10;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase, float f)
	{
		EntityArrow var2 = new EntityArrow(this.worldObj, this, entitylivingbase, 4.0F, 12.0F);
		this.worldObj.spawnEntityInWorld(var2);
	}
}
