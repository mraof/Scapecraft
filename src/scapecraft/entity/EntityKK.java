package scapecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityKK extends EntityScapecraft 
{
	public EntityKK(World par1World)
	{
		super(par1World);
		this.setSize(this.width * 3.5F, this.height * 3.0F);
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBarbarian.class, EntityBlackDragon.class, EntityBlackKnight.class, EntityCreeper.class, EntityEliteBlackKnight.class, EntityFarmer.class, EntityGoblin.class, EntityGuard.class, EntityHeroKnight.class, EntityKing.class, EntityKingsGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityPlayer.class, EntityScorpion.class, EntitySkeleton.class, EntitySpider.class, EntityTormentedDemon.class, EntityThief.class, EntityWhiteKnight.class, EntityWither.class, EntityWizard.class, EntityZombie.class);
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10000.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);   
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected String getLivingSound()
	{
		return "mob.spider.say";
	}

	@Override
	protected String getHurtSound()
	{
		return "mob.spider.say";
	}

	@Override
	protected String getDeathSound()
	{
		return "mob.spider.death";
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.4F;
	}

	@Override
	protected boolean canDespawn()
	{
		return true;
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float damage)
	{
		if(!worldObj.isRemote && rand.nextFloat() * damage > 5)
		{ 
			float f = -0.125f;
			float f1 = -0.125f;
			EntityKKspawn entityKKspawn = new EntityKKspawn(this.worldObj);

			entityKKspawn.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D, this.posZ + (double)f1, this.rand.nextFloat() * 360.0F, 0.0F);
			this.worldObj.spawnEntityInWorld(entityKKspawn);    
		}

		return super.attackEntityFrom(par1DamageSource, damage);
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.ARTHROPOD;
	}

}
