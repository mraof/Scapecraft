package scapecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.MathHelper;
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

	public String getEntityName()
	{
		return "Iron Dragon";
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.550D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
	}

	@Override
	protected String getLivingSound()
	{
		return "mob.enderdragon.growl";
	}

	@Override
	protected String getHurtSound()
	{
		return "mob.enderdragon.hit";
	}
	@Override
	protected String getDeathSound()
	{
		return "mob.enderdragon.hit";
	}

	//TODO Make this attack better
	@Override
	protected void attackEntity(Entity par1Entity, float par2)
	{
		if (attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > boundingBox.minY && par1Entity.boundingBox.minY < boundingBox.maxY)
		{
			attackTime = 5;
			attackEntityAsMob(par1Entity);
		}
		else if (par2 < 30F)
		{
			double d = par1Entity.posX - posX;
			double d1 = (par1Entity.boundingBox.minY + (double)(par1Entity.height / 2.0F)) - (posY + (double)(height / 2.0F));
			double d2 = par1Entity.posZ - posZ;

			if (attackTime == 0)
			{
				field_40152_d++;

				if (field_40152_d == 1)
				{
					attackTime = 20;
				}
				else if (field_40152_d <= 4)
				{
					attackTime = 2;
				}
				else
				{
					attackTime = 33;
					field_40152_d = 0;
				}

				if (field_40152_d > 1)
				{
					float f = MathHelper.sqrt_float(par2) * 0.5F;
					worldObj.playAuxSFXAtEntity(null, 1009, (int)posX, (int)posY, (int)posZ, 0);

					for (int i = 0; i < 1; i++)
					{
						EntityLargeFireball entitylargefireball = new EntityLargeFireball(worldObj, this, d + rand.nextGaussian() * (double)f, d1, d2 + rand.nextGaussian() * (double)f);
						entitylargefireball.posY = posY + (double)(height / 2.0F) + 0.5D;
						worldObj.spawnEntityInWorld(entitylargefireball);
					}
				}
			}

			rotationYaw = (float)((Math.atan2(d2, d) * 180D) / Math.PI) - 90F;
			hasAttacked = true;
		}
	}

	@Override
	public boolean isBurning()
	{
		return false;
	}

	@Override
	public int getXpValue()
	{
		return 100;
	}
}
