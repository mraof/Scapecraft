package scapecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;


public class EntityGoblin extends EntityScapecraft
{
	public EntityGoblin(World par1World)
	{
		super(par1World);

		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBlackDragon.class, EntityFarmer.class, EntityGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityTD.class);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23D);
		this.setLevel(rand.nextInt(3) + 1);
	}

	@Override
	public void setLevel(int level)
	{
		super.setLevel(level);
		this.level = level;
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(18.0D + level * 2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.7D + level * .3);
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

	@Override
	public int getXpValue()
	{
		return 24 + level;
	}
}
