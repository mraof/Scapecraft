package scapecraft.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityBot extends EntityScapecraft
{
	private static final ItemStack defaultHeldItem = new ItemStack(Items.wooden_axe, 1);

	public EntityBot(World par1World)
	{
		super(par1World);
		this.isImmuneToFire = true;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.350D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
	}

	@Override
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
