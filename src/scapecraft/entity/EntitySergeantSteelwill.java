package scapecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySergeantSteelwill extends EntityScapecraft
{
	private int field_40152_d;

	

	public EntitySergeantSteelwill(World par1World)
	{
		super(par1World);
		this.isImmuneToFire = true;
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12.0D);
	}


	public String getEntityName()
	{
		return "Sergeant Steelwill";
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	protected String getHurtSound()
	{
		return "mob.villager.defaulthurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.villager.defaultdeath";
	}
	/**
	 * Plays step sound at given x, y, z for the entity
	 */
	protected void playStepSound(int var1, int var2, int var3, int var4)
	{
		this.worldObj.playSoundAtEntity(this, "mob.villager.default", 0.15F, 1.0F);
	}

	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
	 */
	protected void attackEntity(Entity par1Entity, float par2)
	{
		if (attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > boundingBox.minY && par1Entity.boundingBox.minY < boundingBox.maxY)
		{
			attackTime = 10;
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
					attackTime = 40;
					//func_40148_a(true); /* THIS METHOD MAY DIFFER. CHECK NEAR BOTTOM OF CLASS */
				}
				else if (field_40152_d <= 4)
				{
					attackTime = 6;
				}
				else
				{
					attackTime = 70;
					field_40152_d = 0;
					//func_40148_a(false);
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

	public boolean isBurning()
	{
		return false;
	}



	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
	}


	public void onLivingUpdate()
	{
		if(ticksExisted > 30 * 20) setDead(); 
		super.onLivingUpdate();
	}

	@Override
	public int getXpValue()
	{
		return 100;
	}
}
