package scapecraft.entity;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
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


public class EntityGeneralGraardor extends EntityScapecraft
{
	public EntityGeneralGraardor(World par1World)
	{
		super(par1World);
		this.setSize(3.3F, 8.0F);

		this.isImmuneToFire = true;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityPlayer.class, EntityKrilTsutsaroth.class, EntityZilyana.class, EntityBlackDragon.class, EntityGreenDragon.class, EntityGuard.class, EntityHeroKnight.class, EntityKQ.class, EntityKQ2.class, EntityKing.class, EntityKingsGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityPlayer.class, EntityTD.class, EntityWhiteKnight.class, EntityWizard.class);

	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.31D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50.0D);
	}

	public int getTotalArmorValue()
	{
		return 13;
	}

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
		return 1800;
	}

	@Override
	public void onSpawnerSpawn(ArrayList<String> args)
	{
		super.onSpawnerSpawn(args);
		Entity minion = new EntitySergeantGrimspike(this.worldObj);
		minion.setLocationAndAngles(this.posX, this.posY, this.posZ, 0F, 0F);
		this.worldObj.spawnEntityInWorld(minion);
		minion = new EntitySergeantSteelwill(this.worldObj);
		minion.setLocationAndAngles(this.posX, this.posY, this.posZ, 0F, 0F);
		this.worldObj.spawnEntityInWorld(minion);
		minion = new EntitySergeantStrongstack(this.worldObj);
		minion.setLocationAndAngles(this.posX, this.posY, this.posZ, 0F, 0F);
		this.worldObj.spawnEntityInWorld(minion);
	}
}
