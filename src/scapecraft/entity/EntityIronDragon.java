package scapecraft.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityIronDragon extends EntityScapecraft
{
	private int field_40152_d;
	public EntityIronDragon(World par1World)
	{
		super(par1World);

		this.isImmuneToFire = true;
		this.setSize(this.width * 6.0F, this.height * 2.0F);

	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.550D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
	}

	@Override
	protected SoundEvent getAmbientSound()
	{
		//return "mob.enderdragon.growl";
		return SoundEvents.ENTITY_ENDERDRAGON_GROWL;
	}

	@Override
	protected SoundEvent getHurtSound()
	{
		//return "mob.enderdragon.hit";
		return SoundEvents.ENTITY_ENDERDRAGON_HURT;
	}
	@Override
	protected SoundEvent getDeathSound()
	{
		//return "mob.enderdragon.hit";
		return SoundEvents.ENTITY_ENDERDRAGON_DEATH;
	}

	@Override
	public boolean isBurning()
	{
		return false;
	}

}
