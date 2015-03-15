package scapecraft.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import scapecraft.item.ScapecraftItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityGuard extends EntityScapecraft
{
	public EntityGuard(World par1World)
	{
		super(par1World);
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.lifespan = 3600;
		this.addTargets(EntityAhrim.class, EntityAkrisae.class, EntityBlackDragon.class, EntityBlackGuard.class, EntityBlackKnight.class, EntityBot.class, EntityCreeper.class, EntityDarkwizard.class, EntityDharok.class, EntityEliteBlackKnight.class, EntityGeneralGraardor.class, EntityGoblin.class, EntityGreenDragon.class, EntityGuthan.class, EntityHellhound.class, EntityHighMage.class, EntityKQ.class, EntityKQ2.class, EntityKaril.class, EntityKos1.class, EntityKos2.class, EntityKos3.class, EntityLesserDemon.class, EntityLesserDemon2.class, EntityScorpion.class, EntitySergeantGrimspike.class, EntitySergeantSteelwill.class, EntitySergeantStrongstack.class, EntitySkeleton.class, EntitySpider.class, EntityTD.class, EntityTheif.class, EntityTorag.class, EntityVerac.class, EntityWither.class, EntityZombie.class);
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.27D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
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
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
	}

	@Override
	public void addArmor()
	{
		this.setCurrentItemOrArmor(4, new ItemStack(ScapecraftItems.bronzeHelmet));
		this.setCurrentItemOrArmor(3, new ItemStack(ScapecraftItems.guardChestplate));
		this.equipmentDropChances[4] = 0.0F;
	}

	private static final ItemStack defaultHeldItem = new ItemStack(Items.stone_sword, 1);

	@Override
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	@SideOnly(Side.CLIENT)	
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("\u00a7EGuard: Happy to help"));
		return super.interact(par1EntityPlayer);
	}

	@Override
	public int getXpValue()
	{
		return 35;
	}
}
