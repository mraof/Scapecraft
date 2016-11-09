package scapecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityKaril extends EntityScapecraft implements IRangedAttackMob
{
	public EntityKaril(World par1World)
	{
		super(par1World);
		this.setSize(0.9F, 2.8F);
		this.isImmuneToFire = true;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBarbarian.class, EntityBlackDragon.class, EntityFarmer.class, EntityGuard.class, EntityHellhound.class, EntityKing.class, EntityKingsGuard.class, EntityPlayer.class, EntityTormentedDemon.class, EntityWhiteKnight.class, EntityWither.class, EntityWizard.class);
/*		this.tasks.addTask(4, new EntityAIArrowAttack(this, 0.25F, 18, 20.0F));*/
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.36D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(11.0D);
	}


	@Override
	protected SoundEvent getHurtSound()
	{
		//return "mob.villager.defaulthurt";
		return SoundEvents.ENTITY_VILLAGER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		//return "mob.villager.defaultdeath";
		return SoundEvents.ENTITY_VILLAGER_DEATH;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase, float f)
	{
/*		EntityArrow var2 = new EntityArrow(this.worldObj, this, entitylivingbase, 4.0F, 12.0F);
		this.worldObj.spawnEntityInWorld(var2);*/
	}
}
