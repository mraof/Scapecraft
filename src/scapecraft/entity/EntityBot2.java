package scapecraft.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import scapecraft.item.ScapecraftItems;

public class EntityBot2 extends EntityScapecraft
{
	public EntityBot2(World par1World)
	{
		super(par1World);
		this.isImmuneToFire = true;
	}
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.350D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
	}

	public boolean isAIEnabled()
	{
		return false;
	}

	@Override
	protected String getLivingSound()
	{
		return "mob.endermen.idle";
	}

	@Override
	protected String getHurtSound()
	{
		return "mob.endermen.hit";
	}

	@Override
	protected String getDeathSound()
	{
		return "mob.endermen.death";
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


	public void onLivingUpdate()
	{
		if(ticksExisted > 20 * 20) setDead(); 
		super.onLivingUpdate();
	}

	private static final ItemStack defaultHeldItem = new ItemStack(ScapecraftItems.dragonAxe, 1);
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
