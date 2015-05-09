package scapecraft.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import scapecraft.item.ScapecraftItems;

public class EntityFremGuard extends EntityScapecraft
{
	public EntityFremGuard(World par1World)
	{
		super(par1World);
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(9001.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
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

	public void addArmor()
	{

			this.setCurrentItemOrArmor(3, new ItemStack(ScapecraftItems.runegChestplate));
			this.setCurrentItemOrArmor(2, new ItemStack(ScapecraftItems.runegLeggings));
			this.equipmentDropChances[4] = 0.0F;
	}

	private static final ItemStack defaultHeldItem;
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	static
	{
		defaultHeldItem = new ItemStack(ScapecraftItems.fremSword, 1);
	}

	public int getTotalArmorValue()
	{
		return 999;
	}

	@Override
	public int getXpValue()
	{
		return 0;
	}



}
