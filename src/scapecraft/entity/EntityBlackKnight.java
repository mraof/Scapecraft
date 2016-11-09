package scapecraft.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import scapecraft.item.ScapecraftItems;

public class EntityBlackKnight extends EntityScapecraft
{
	private static final ItemStack defaultHeldItem = new ItemStack(ScapecraftItems.equipmentSets.get("blackSword"), 1);

	public EntityBlackKnight(World par1World)
	{
		super(par1World);

		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBarbarian.class, EntityBlackDragon.class, EntityBlackDragon.class, EntityFarmer.class, EntityGreenDragon.class, EntityGuard.class, EntityHeroKnight.class, EntityKQ.class, EntityKQ2.class, EntityKing.class, EntityKingsGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityPlayer.class, EntityTormentedDemon.class, EntityWhiteKnight.class, EntityWizard.class);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
	}

	@Override
	protected SoundEvent getHurtSound()
	{
		//return "mob.villager.defaulthurt";
		return SoundEvents.ENTITY_VILLAGER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		//return "mob.villager.defaultdeath";
		return SoundEvents.ENTITY_VILLAGER_DEATH;
	}

	@Override
	public void addArmor()
	{
			this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(ScapecraftItems.equipmentSets.get("blackBoots")));
			this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(ScapecraftItems.equipmentSets.get("blackPlatelegs")));
			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(ScapecraftItems.equipmentSets.get("blackPlatebody")));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(ScapecraftItems.equipmentSets.get("blackHelmet")));
	}

	@Override
	public ItemStack getHeldItemMainhand()
	{
		return defaultHeldItem;
	}

}
