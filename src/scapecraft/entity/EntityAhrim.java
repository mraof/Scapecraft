package scapecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class EntityAhrim extends EntityScapecraft
{
	private float moveSpeed;
	
	public EntityAhrim(World par1World)
	{
		super(par1World);
		this.setSize(this.width * 5.0F, this.height * 1.0F);
		this.moveSpeed = 0.5F;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.addTargets(EntityLivingBase.class, EntityBlackDragon.class, EntityFarmer.class, EntityGreenDragon.class, EntityGuard.class, EntityHeroKnight.class, EntityKQ.class, EntityKQ2.class, EntityKing.class, EntityKingsGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityPlayer.class, EntityTormentedDemon.class, EntityWhiteKnight.class, EntityWizard.class);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(90.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.50D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
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
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if (super.attackEntityAsMob(par1Entity))
		{
			if (par1Entity instanceof EntityLivingBase)
			{
				((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 3));
				((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.weakness.id, 500, 3));
				((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0));
			}

			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

}
