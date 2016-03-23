package scapecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import scapecraft.entity.ai.EntityAIHurtByLevelTarget;
import scapecraft.entity.ai.EntityAILevelTarget;


public class EntityGoblin extends EntityScapecraft
{
	public EntityGoblin(World par1World)
	{
		super(par1World);

		//noinspection unchecked
		this.targetTasks.addTask(1, new EntityAIHurtByLevelTarget(this, EntityGoblin.class));
		//noinspection unchecked
		this.targetTasks.addTask(2, new EntityAILevelTarget(this, true, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBlackDragon.class, EntityFarmer.class, EntityGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityTormentedDemon.class, EntityZombie.class);
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

}
