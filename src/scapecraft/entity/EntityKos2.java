package scapecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;


public class EntityKos2 extends EntityScapecraft
{
	public EntityKos2(World par1World)
	{
		super(par1World);

		this.isImmuneToFire = true;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBlackDragon.class, EntityGreenDragon.class, EntityGuard.class, EntityHeroKnight.class, EntityKQ.class, EntityKing.class, EntityKingsGuard.class, EntityLavaBlock.class, EntityPlayer.class, EntityTormentedDemon.class, EntityWhiteKnight.class, EntityWizard.class);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(500.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.38D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.6D);
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
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if (super.attackEntityAsMob(par1Entity))
		{
			if (par1Entity instanceof EntityLivingBase)
			{
				par1Entity.setFire(20);
			}

			return true;
		}
		else
		{
			return false;
		}
	}

	/*private static final ItemStack defaultHeldItem = new ItemStack(ScapecraftItems.fremSwordf, 1);
	@Override
	public ItemStack getHeldItemMainhand()
	{
		return defaultHeldItem;
	}*/

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

				EntityKos3 entityKos3 = new EntityKos3(this.worldObj);
				entityKos3.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D+1, this.posZ + (double)f1+4, this.rand.nextFloat() * 360.0F, 0.0F);
				this.worldObj.spawnEntityInWorld(entityKos3);
			}
		}
	}

	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotion() != MobEffects.POISON && super.isPotionApplicable(par1PotionEffect);
	}

	@Override
	public boolean isBurning()
	{
		return false;
	}

	@Override
	public void onLivingUpdate()
	{
		if (rand.nextInt(120) == 0 && !worldObj.isRemote)
		{
			EntityKos4 entityKos4 = new EntityKos4(this.worldObj);
			entityKos4.setLocationAndAngles(this.posX - 0.125, this.posY + 1.5D, this.posZ + 3.875, this.rand.nextFloat() * 360.0F, 0.0F);
			this.worldObj.spawnEntityInWorld(entityKos4);
		}
	}

}
