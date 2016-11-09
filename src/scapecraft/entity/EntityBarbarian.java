package scapecraft.entity;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import scapecraft.entity.ai.EntityAIAttackWithDistance;
import scapecraft.entity.ai.EntityAIHurtByLevelTarget;
import scapecraft.item.ScapecraftItems;

public class EntityBarbarian extends EntityScapecraft
{
	public EntityBarbarian(World par1World)
	{
		super(par1World);

		this.targetTasks.addTask(1, new EntityAIHurtByLevelTarget(this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackWithDistance(this, 1.1, 1.44));
		this.tasks.addTask(5, new EntityAIWander(this, 1));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityAhrim.class, EntityAkrisae.class, EntityBlackDragon.class, EntityBlackGuard.class, EntityBlackKnight.class, EntityCreeper.class, EntityDarkwizard.class, EntityDharok.class, EntityEliteBlackKnight.class, EntityGeneralGraardor.class, EntityGoblin.class, EntityGreenDragon.class, EntityGuthan.class, EntityHellhound.class, EntityHighMage.class, EntityKQ.class, EntityKQ2.class, EntityKaril.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityLesserDemonUgly.class, EntityLesserDemon.class, EntityScorpion.class, EntitySergeantGrimspike.class, EntitySergeantSteelwill.class, EntitySergeantStrongstack.class, EntitySkeleton.class, EntitySpider.class, EntityTormentedDemon.class, EntityThief.class, EntityTorag.class, EntityVerac.class, EntityWither.class, EntityZombie.class);
	}

	@Override
	protected SoundEvent getAmbientSound()
	{
		//return "mob.villager.default";
		return SoundEvents.ENTITY_VILLAGER_AMBIENT;
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

	private static final ItemStack defaultHeldItem = new ItemStack(ScapecraftItems.equipmentSets.get("steelHammer"), 1);


	@Override
	public ItemStack getHeldItemMainhand()
	{
		return defaultHeldItem;
	}

}
