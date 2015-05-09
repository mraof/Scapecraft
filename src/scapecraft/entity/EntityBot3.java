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
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import scapecraft.item.ScapecraftItems;

public class EntityBot3 extends EntityScapecraft
{
	private static final ItemStack defaultHeldItem = new ItemStack(ScapecraftItems.whip, 1);
	public EntityBot3(World par1World)
	{
		super(par1World);
		this.setSize(this.width * 2.0F, this.height * 2.0F);
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBlackDragon.class, EntityBlackKnight.class, EntityBot.class, EntityCreeper.class, EntityDarkwizard.class, EntityFarmer.class, EntityGoblin.class, EntityGreenDragon.class, EntityKQ.class, EntityKQ2.class, EntityLesserDemon.class, EntityScorpion.class, EntityTheif.class);
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
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
	public void addArmor()
	{
		this.setCurrentItemOrArmor(4, new ItemStack(ScapecraftItems.addyHelmet));
		this.setCurrentItemOrArmor(2, new ItemStack(ScapecraftItems.runeLeggings));
		this.setCurrentItemOrArmor(3, new ItemStack(ScapecraftItems.runeChestplate));
		this.equipmentDropChances[4] = 0.0F;
	}

	@Override
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	@Override
	public int getXpValue()
	{
		return 0;
	}
}
