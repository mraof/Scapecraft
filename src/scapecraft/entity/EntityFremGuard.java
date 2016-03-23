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

	@Override
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

	@Override
	public void addArmor()
	{
			this.setCurrentItemOrArmor(3, new ItemStack(ScapecraftItems.equipmentSets.get("runePlatebody")));
			this.setCurrentItemOrArmor(2, new ItemStack(ScapecraftItems.equipmentSets.get("runePlatelegs")));
			this.equipmentDropChances[4] = 0.0F;
	}
}
