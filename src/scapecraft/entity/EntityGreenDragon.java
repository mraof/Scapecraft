package scapecraft.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGreenDragon extends EntityScapecraft
{
	public EntityGreenDragon(World par1World)
	{
		super(par1World);

		this.setSize(this.width * 5.0F, this.height * 5.0F);
		this.isImmuneToFire = true;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBlackDragon.class, EntityFarmer.class, EntityGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityTormentedDemon.class, EntityBlackKnight.class, EntityCreeper.class, EntityFarmer.class, EntityGoblin.class, EntityGuard.class, EntityHeroKnight.class, EntityKing.class, EntityKingsGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityPlayer.class, EntityScorpion.class, EntitySkeleton.class, EntitySpider.class, EntityTormentedDemon.class, EntityThief.class, EntityWhiteKnight.class, EntityWizard.class, EntityZombie.class);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(130.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.24D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
	}


	@Override
	protected SoundEvent getAmbientSound()
	{
		//return "mob.enderdragon.growl";
		return SoundEvents.ENTITY_ENDERDRAGON_GROWL;
	}

	@Override
	protected SoundEvent getHurtSound()
	{
		//return "mob.enderdragon.hit";
		return SoundEvents.ENTITY_ENDERDRAGON_HURT;
	}

	@Override
	protected SoundEvent getDeathSound()
	{

		//return "mob.enderdragon.hit";
		return SoundEvents.ENTITY_ENDERDRAGON_DEATH;
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.4F;
	}

}
