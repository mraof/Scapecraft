package scapecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBlackDragon extends EntityScapecraft
{
	public EntityBlackDragon(World par1World)
	{
		super(par1World);

		this.setSize(6f, 4f);
		this.isImmuneToFire = true;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBlackGuard.class, EntityBlackKnight.class, EntityCreeper.class, EntityFarmer.class, EntityGoblin.class, EntityGuard.class, EntityHeroKnight.class, EntityKing.class, EntityKingsGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityPlayer.class, EntityScorpion.class, EntitySkeleton.class, EntitySpider.class, EntityTormentedDemon.class, EntityThief.class, EntityWhiteKnight.class, EntityWizard.class, EntityZombie.class);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(25.0D);
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected String getLivingSound()
	{
		return "mob.enderdragon.growl";
	}

	@Override
	protected String getHurtSound()
	{
		return "mob.enderdragon.hit";
	}

	@Override
	protected String getDeathSound()
	{
		return "mob.enderdragon.hit";
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.4F;
	}

}
