package scapecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import scapecraft.item.ScapecraftItems;


public class EntityKos3 extends EntityScapecraft
{
	private static final ItemStack defaultHeldItem = new ItemStack(ScapecraftItems.fremSwordf, 1);
	int spawnvar = 1;

	public EntityKos3(World par1World)
	{
		super(par1World);
		this.isImmuneToFire = true;
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBlackDragon.class, EntityGreenDragon.class, EntityGuard.class, EntityHeroKnight.class, EntityKQ.class, EntityKing.class, EntityKingsGuard.class, EntityLavaBlock.class, EntityPlayer.class, EntityTD.class, EntityWhiteKnight.class, EntityWizard.class);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1337.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.27D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(80.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.7D);
	}

	@Override
	public int getTotalArmorValue()
	{
		return 16;
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
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
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if (super.attackEntityAsMob(par1Entity))
		{
			if (par1Entity instanceof EntityLivingBase)
			{
				par1Entity.setFire(20);
			}

			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	protected EntityKos4 createInstance()
	{
		return new EntityKos4(this.worldObj);
	}

	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
	}
	public boolean isBurning()
	{
		return false;
	}

	public void onLivingUpdate()
	{
		spawnvar++;

		if (spawnvar >= 20)
		{
			if(!worldObj.isRemote)
			{
				int j = 1;

				for (int k = 0; k < j; ++k)
				{
					float f = ((float)(k % 2) - 0.5F) * (float)1 / 4.0F;
					float f1 = ((float)(k / 2) - 0.5F) * (float)1 / 4.0F;
					EntityKos4 entityKos4 = this.createInstance();
					entityKos4.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D+1, this.posZ + (double)f1+4, this.rand.nextFloat() * 360.0F, 0.0F);
					this.worldObj.spawnEntityInWorld(entityKos4);
				}
			}
			spawnvar = 0;

		}
		super.onLivingUpdate();
	}

	@Override
	public int getXpValue()
	{
		return 668;
	}
}
