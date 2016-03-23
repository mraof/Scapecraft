package scapecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import scapecraft.item.ScapecraftItems;

public class EntityBlackKnight extends EntityScapecraft
{
	private static final ItemStack defaultHeldItem = new ItemStack(ScapecraftItems.equipmentSets.get("blackSword"), 1);

	public EntityBlackKnight(World par1World)
	{
		super(par1World);

		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBarbarian.class, EntityBlackDragon.class, EntityBlackDragon.class, EntityFarmer.class, EntityGreenDragon.class, EntityGuard.class, EntityHeroKnight.class, EntityKQ.class, EntityKQ2.class, EntityKing.class, EntityKingsGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityPlayer.class, EntityTormentedDemon.class, EntityWhiteKnight.class, EntityWizard.class);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
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
			this.setCurrentItemOrArmor(1, new ItemStack(ScapecraftItems.equipmentSets.get("blackBoots")));
			this.setCurrentItemOrArmor(2, new ItemStack(ScapecraftItems.equipmentSets.get("blackPlatelegs")));
			this.setCurrentItemOrArmor(3, new ItemStack(ScapecraftItems.equipmentSets.get("blackPlatebody")));
			this.setCurrentItemOrArmor(4, new ItemStack(ScapecraftItems.equipmentSets.get("blackHelmet")));
			this.equipmentDropChances[4] = 0.0F;
	}

	@Override
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

}
