package scapecraft.entity;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityKQ extends EntityScapecraft 
{
	public EntityKQ(World par1World)
	{
		super(par1World);

		this.setSize(this.width * 3.5F, this.height * 3.0F);
		this.addTargets(EntityBarbarian.class, EntityBlackDragon.class, EntityBlackKnight.class, EntityCreeper.class, EntityEliteBlackKnight.class, EntityFarmer.class, EntityGoblin.class, EntityGuard.class, EntityHeroKnight.class, EntityKing.class, EntityKingsGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityPlayer.class, EntityScorpion.class, EntitySkeleton.class, EntitySpider.class, EntityTD.class, EntityTheif.class, EntityWhiteKnight.class, EntityWither.class, EntityWizard.class, EntityZombie.class);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(500.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.42D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(40.0D);
	}
	public int getTotalArmorValue()
	{
		return 14;
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected String getLivingSound()
	{
		return "mob.spider.say";
	}

	@Override
	protected String getHurtSound()
	{
		return "mob.spider.say";
	}

	@Override
	protected String getDeathSound()
	{
		return "mob.spider.death";
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.4F;
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if(!worldObj.isRemote)
		{
			int j = 3;

			for (int k = 0; k < j; ++k)
			{
				if(rand.nextFloat() * par2 > 4)
				{
					float f = ((float)(k % 2) - 0.5F) * (float)1 / 4.0F;
					float f1 = ((float)(k / 2) - 0.5F) * (float)1 / 4.0F;
					EntityKQ2 entityKQ2 = new EntityKQ2(this.worldObj);

					entityKQ2.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D, this.posZ + (double)f1, this.rand.nextFloat() * 360.0F, 0.0F);
					this.worldObj.spawnEntityInWorld(entityKQ2);
					this.worldObj.spawnEntityInWorld(entityKQ2);
					this.worldObj.spawnEntityInWorld(entityKQ2);
				}
			}
		}

		return super.attackEntityFrom(par1DamageSource, par2);
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.ARTHROPOD;
	}

	@Override
	public int getXpValue()
	{
		return 2404;
	}
}
