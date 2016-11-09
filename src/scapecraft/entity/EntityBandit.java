package scapecraft.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import scapecraft.entity.ai.EntityAIAttackWithDistance;
import scapecraft.item.ScapecraftItems;

public class EntityBandit extends EntityScapecraft
{
	public EntityBandit(World par1World)
	{
		super(par1World);
		this.setSize(3, 1.5f);
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackWithDistance(this, 1.1, 1.44));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityBarbarian.class, EntityFarmer.class, EntityGreenDragon.class, EntityGuard.class, EntityHeroKnight.class, EntityKQ.class, EntityKQ2.class, EntityKing.class, EntityKingsGuard.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityPlayer.class, EntityTormentedDemon.class, EntityWhiteKnight.class, EntityWizard.class);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
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
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotion() != MobEffects.POISON && super.isPotionApplicable(par1PotionEffect);
	}

	private static final ItemStack defaultHeldItem = new ItemStack(ScapecraftItems.equipmentSets.get("blackSword"), 1);

	@Override
	public ItemStack getHeldItemMainhand()
	{
		return defaultHeldItem;
	}

}
