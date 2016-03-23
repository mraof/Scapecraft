package scapecraft.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import scapecraft.item.ScapecraftItems;

public class EntityWizard extends EntityScapecraft implements IRangedAttackMob
{
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 0.25F, 60, 10.0F);
	private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.31F, false);
	private float moveSpeed;

	

	public EntityWizard(World par1World)
	{
		super(par1World);
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBlackGuard.class, 0, true));
		this.moveSpeed = 0.4F;
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBlackDragon.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos1.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos2.class, 0, true));   
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKos3.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWither.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHighMage.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTormentedDemon.class, 0, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWolf.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityOcelot.class, this.moveSpeed, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));      
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityEliteBlackKnight.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBlackKnight.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityThief.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCreeper.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySpider.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKQ2.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKQ.class, 0, true));        
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityDarkwizard.class, 0, true));        
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGreenDragon.class, 0, true));       
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGhast.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHellhound.class, 0, true));     
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySergeantGrimspike.class, 0, true));    
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySergeantSteelwill.class, 0, true));      
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySergeantStrongstack.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGeneralGraardor.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAhrim.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTorag.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVerac.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGuthan.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKaril.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityDharok.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAkrisae.class, 0, true));
		if (par1World != null && !par1World.isRemote)
		{
			this.setCombatTask();
		}
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.7D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, (byte) 0);
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

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound()
	{
		return "mob.villager.defaultdeath";
	}


	@Override
	public boolean isPotionApplicable(PotionEffect par1PotionEffect)
	{
		return par1PotionEffect.getPotionID() != Potion.poison.id && super.isPotionApplicable(par1PotionEffect);
	}

	private static final ItemStack defaultHeldItem;
	@Override
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	static
	{
		defaultHeldItem = new ItemStack(ScapecraftItems.saraStaff, 1);
	}




	public void setCombatTask()
	{
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.removeTask(this.aiArrowAttack);
		ItemStack itemstack = this.getHeldItem();

		if (itemstack != null && itemstack.getItem() == ScapecraftItems.saraStaff)
		{
			this.tasks.addTask(4, this.aiArrowAttack);
		}
		else
		{
			this.tasks.addTask(4, this.aiAttackOnCollide);
		}
	}


	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase,
			float f) {
		EntityArrow var2 = new EntityArrow(this.worldObj, this, entitylivingbase, 5.6F, 12.0F);


		this.worldObj.spawnEntityInWorld(var2);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean interact(EntityPlayer entityPlayer)
	{
		entityPlayer.addChatComponentMessage(new ChatComponentText("\u00a7EWizard: You assume my services are free..."
					+ "\u00a7F*You ignore the wizard's attempts to demand payment*"));
		return super.interact(entityPlayer);
	}

}
