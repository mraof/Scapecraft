package scapecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;


public class EntityKos1 extends EntityScapecraft
{
	public EntityKos1(World par1World)
	{
		super(par1World);

		this.isImmuneToFire = true;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.addTargets(EntityBlackDragon.class, EntityGreenDragon.class, EntityGuard.class, EntityHeroKnight.class, EntityKQ.class, EntityKing.class, EntityKingsGuard.class, EntityLavaBlock.class, EntityPlayer.class, EntityTormentedDemon.class, EntityWhiteKnight.class, EntityWizard.class);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(250.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.38D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.6D);
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
	public void onDeath(DamageSource par1DamageSource) 
	{
		if(!worldObj.isRemote)
		{
			int j = 1;
			for (int k = 0; k < j; ++k)
			{
				float f = ((float)(k % 2) - 0.5F) * (float)1 / 4.0F;
				float f1 = ((float)(k / 2) - 0.5F) * (float)1 / 4.0F;
				EntityKos2 entityKos2 = new EntityKos2(this.worldObj);
				entityKos2.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D+1, this.posZ + (double)f1+4, this.rand.nextFloat() * 360.0F, 0.0F);
				this.worldObj.spawnEntityInWorld(entityKos2);
			}
		}
	}

}
