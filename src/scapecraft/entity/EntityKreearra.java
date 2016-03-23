
package scapecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityKreearra extends EntityScapecraft
{

	public EntityKreearra(World par1World)
	{
		super(par1World);
		this.setSize(1.5F, 4F);
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false)); //speed argument of AI (1D in this case) is multiplied by the base value
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityPlayer.class, EntityZilyana.class, EntityGeneralGraardor.class, EntityKrilTsutsaroth.class);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(825D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50D);
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	protected void fall(float distance)
	{
	}

	@Override
	protected void updateFallState(double distanceFallenThisTick, boolean isOnGround)
	{
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate()
	{
		return true;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if(this.motionY < 0)
		{
			this.motionY *= 0.6000000238418579D;
		}
		else
		{
			this.motionY *= 1.1;
		}
	}
}
