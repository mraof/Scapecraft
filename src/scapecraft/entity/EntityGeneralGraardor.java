package scapecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.ArrayList;


public class EntityGeneralGraardor extends EntityScapecraft
{
	public EntityGeneralGraardor(World par1World)
	{
		super(par1World);
		this.setSize(3.3F, 8.0F);

		this.isImmuneToFire = true;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityPlayer.class, EntityKrilTsutsaroth.class, EntityZilyana.class, EntityBlackDragon.class, EntityGreenDragon.class, EntityGuard.class, EntityHeroKnight.class, EntityKQ.class, EntityKQ2.class, EntityKing.class, EntityKingsGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityPlayer.class, EntityTormentedDemon.class, EntityWhiteKnight.class, EntityWizard.class);

	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.31D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(50.0D);
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
