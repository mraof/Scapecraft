package scapecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import scapecraft.entity.ai.EntityAIHurtByLevelTarget;
import scapecraft.item.ScapecraftItems;

public class EntityGuard extends EntityScapecraft
{
	public EntityGuard(World par1World)
	{
		super(par1World);
		//noinspection unchecked
		EntityAIHurtByLevelTarget aiHurtByLevelTarget = new EntityAIHurtByLevelTarget(this, EntityGuard.class);
		aiHurtByLevelTarget.bravery = 3;
		this.targetTasks.addTask(1, aiHurtByLevelTarget);
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.addTargets(EntityAhrim.class, EntityAkrisae.class, EntityBlackDragon.class, EntityBlackGuard.class, EntityBlackKnight.class, EntityCreeper.class, EntityDarkwizard.class, EntityDharok.class, EntityEliteBlackKnight.class, EntityGeneralGraardor.class, EntityGoblin.class, EntityGreenDragon.class, EntityGuthan.class, EntityHellhound.class, EntityHighMage.class, EntityKQ.class, EntityKQ2.class, EntityKaril.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityLesserDemonUgly.class, EntityLesserDemon.class, EntityScorpion.class, EntitySergeantGrimspike.class, EntitySergeantSteelwill.class, EntitySergeantStrongstack.class, EntitySkeleton.class, EntitySpider.class, EntityTormentedDemon.class, EntityThief.class, EntityTorag.class, EntityVerac.class, EntityWither.class, EntityZombie.class);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.27D);
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
		this.setCurrentItemOrArmor(4, new ItemStack(ScapecraftItems.equipmentSets.get("bronzeHelmet")));
		this.setCurrentItemOrArmor(3, new ItemStack(ScapecraftItems.equipmentSets.get("ironChainbody")));
		this.equipmentDropChances[4] = 0.0F;
	}

	private static final ItemStack defaultHeldItem = new ItemStack(Items.stone_sword, 1);

	@Override
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

}
