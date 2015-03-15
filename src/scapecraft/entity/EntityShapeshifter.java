package scapecraft.entity;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.EntityLiving;
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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityShapeshifter extends EntityScapecraft implements IEntityAdditionalSpawnData
{
	public EntityLivingBase copiedMob;
	public String mobName;
	private static Random staticRand = new Random();

	public EntityShapeshifter(World world)
	{
		this(world, "");
	}

	public EntityShapeshifter(World world, String mobName)
	{
		super(world);

		if(world == null)
			this.setMob("Wizard");
		else
			this.setMob(mobName);
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, true, false, this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.1D, false)); 
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	}

	public static String randomMobName()
	{
		int index = staticRand.nextInt(ScapecraftEntities.entities.size() + 1);
		if(index == ScapecraftEntities.entities.size())
			return "@p";
		else
			return ScapecraftEntities.entities.get(index);
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound)
	{
		super.writeEntityToNBT(tagCompound);
		tagCompound.setString("mobName", mobName);
		NBTTagCompound copiedMobNBT = new NBTTagCompound();
		this.copiedMob.writeEntityToNBT(copiedMobNBT);
		tagCompound.setTag("copiedMob", copiedMobNBT);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompound)
	{
		super.readEntityFromNBT(tagCompound);
		this.setMob(tagCompound.getString("mobName"));
		if(tagCompound.getCompoundTag("copiedMob") == null);
		this.copiedMob.readEntityFromNBT(tagCompound.getCompoundTag("copiedMob"));
	}

	public void setMob(String mobName)
	{
		if(mobName.isEmpty())
			mobName = randomMobName();
		try
		{
			this.mobName = mobName;
			if(mobName.startsWith("@p"))
			{
				if(mobName.length() == 2)
					mobName = "@p" + selectRandomUsername();
				copiedMob = new EntityGenericBiped(this.worldObj);
				if(!worldObj.isRemote)
				{
					((EntityGenericBiped) copiedMob).setGameProfile(new GameProfile(null, mobName.substring(2)));
					((EntityGenericBiped) copiedMob).addRandomEquipment();
				}
			}
			else
			{
				this.copiedMob = ScapecraftEntities.spawnScapecraftEntity(mobName, this.worldObj);
			}

			this.setSize(copiedMob.width, copiedMob.height);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		this.mobName = mobName;
		this.addTargets(copiedMob.getClass());
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(copiedMob.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue());
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2D);
	}

	@Override
	public void setWorld(World world)
	{
		super.setWorld(world);
		copiedMob.setWorld(world);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if(source.getSourceOfDamage() != null && !(source.getSourceOfDamage() instanceof EntityShapeshifter))
		{
			amount /= 2;
			source.getSourceOfDamage().attackEntityFrom(DamageSource.causeMobDamage(this), amount);
		}
		return super.attackEntityFrom(source, amount);
	}

	@Override
	protected void updateArmSwingProgress()
	{
		super.updateArmSwingProgress();
		copiedMob.swingProgressInt = this.swingProgressInt;
		copiedMob.isSwingInProgress = this.isSwingInProgress;
		copiedMob.swingProgress = this.swingProgress;
	}

	@Override
	public void moveEntityWithHeading(float strafe, float forward)
	{
		super.moveEntityWithHeading(strafe, forward);
		copiedMob.prevLimbSwingAmount = this.prevLimbSwingAmount;
		copiedMob.limbSwingAmount = this.limbSwingAmount;
		copiedMob.limbSwing = this.limbSwing;
	}

	@Override
	public void setLocationAndAngles(double x, double y, double z, float yaw, float pitch)
	{
		super.setLocationAndAngles(x, y, z, yaw, pitch);
		copiedMob.setLocationAndAngles(x, y, z, yaw, pitch);
	}

	@Override
	public void onEntityUpdate()
	{
		super.onEntityUpdate();
		copiedMob.posX = this.posX;
		copiedMob.posY = this.posY;
		copiedMob.posZ = this.posZ;
		copiedMob.hurtTime = this.hurtTime;
		copiedMob.deathTime = this.deathTime;
		copiedMob.rotationPitch = this.rotationPitch;
		copiedMob.rotationYaw = this.rotationYaw;
		copiedMob.rotationYawHead = this.rotationYawHead;
		copiedMob.renderYawOffset = this.renderYawOffset;
		copiedMob.prevRotationPitch = this.prevRotationPitch;
		copiedMob.prevRotationYaw = this.prevRotationYaw;
		copiedMob.prevRotationYawHead = this.prevRotationYawHead;
		copiedMob.prevRenderYawOffset = this.prevRenderYawOffset;
	}

	@Override
	public void writeSpawnData(ByteBuf data)
	{
		ByteBufUtils.writeUTF8String(data, this.mobName);
		NBTTagCompound tagCompound = new NBTTagCompound();
		NBTTagList tagList = new NBTTagList();
		for(int i = 0; i < copiedMob.getInventory().length; i++)
		{
			NBTTagCompound stackCompound = new NBTTagCompound();
			if(copiedMob.getInventory()[i] != null)
				copiedMob.getInventory()[i].writeToNBT(stackCompound);
			tagList.appendTag(stackCompound);
		}
		tagCompound.setTag("Equipment", tagList);
		if(copiedMob instanceof EntityGenericBiped)
		{
			NBTTagCompound profileNBT = new NBTTagCompound();
			NBTUtil.writeGameProfileToNBT(profileNBT, ((EntityGenericBiped)copiedMob).profile);
			tagCompound.setTag("Profile", profileNBT);
		}
		ByteBufUtils.writeTag(data, tagCompound);
	}

	@Override
	public void readSpawnData(ByteBuf data)
	{
		this.mobName = ByteBufUtils.readUTF8String(data);
		this.setMob(mobName);
		NBTTagCompound tagCompound = ByteBufUtils.readTag(data);
		NBTTagList tagList = tagCompound.getTagList("Equipment", 10);
		for(int i = 0; i < copiedMob.getInventory().length; i++)
		{
			copiedMob.getInventory()[i] = ItemStack.loadItemStackFromNBT(tagList.getCompoundTagAt(i));
		}
		if(copiedMob instanceof EntityGenericBiped)
		{
			((EntityGenericBiped)copiedMob).profile = NBTUtil.readGameProfileFromNBT(tagCompound.getCompoundTag("Profile"));
			((EntityGenericBiped)copiedMob).name = ((EntityGenericBiped)copiedMob).profile.getName(); 
		}
	}

	@Override
	public int getXpValue()
	{
		return 100;
	}

	@Override
	public String getCommandSenderName()
	{
		if(worldObj.isRemote)
			return copiedMob.getCommandSenderName();
		return StatCollector.translateToLocalFormatted("entity.Scapecraft.Shapeshifter.mob", copiedMob.getCommandSenderName());
	}

	@Override
	public void setCustomNameTag(String name)
	{
		if(this.copiedMob instanceof EntityLiving)
			((EntityLiving)this.copiedMob).setCustomNameTag(name);
		else
			super.setCustomNameTag(name);
	}

	@Override
	public String getCustomNameTag()
	{
		if(this.copiedMob instanceof EntityLiving)
			return ((EntityLiving)this.copiedMob).getCustomNameTag();
		else
			return super.getCustomNameTag();
	}

	@Override
	public boolean hasCustomNameTag()
	{
		if(this.copiedMob instanceof EntityLiving)
			return ((EntityLiving)this.copiedMob).hasCustomNameTag();
		else
			return super.hasCustomNameTag();
	}

	@Override
	public boolean getAlwaysRenderNameTag()
	{
		if(this.copiedMob instanceof EntityLiving)
			return ((EntityLiving)this.copiedMob).getAlwaysRenderNameTag();
		else
			return super.getAlwaysRenderNameTag();
	}

	public static String selectRandomUsername()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("mraof");
		for(String name : MinecraftServer.getServer().getAllUsernames())
		{
			if(!names.contains(name))
			{
				names.add(name);
			}
		}
		return names.get(staticRand.nextInt(names.size()));
	}

	@Override
	public void onSpawnerSpawn(ArrayList<String> args)
	{
		for(int i = 1; i < args.size(); i++)
		{
			if(args.get(i).startsWith("mob="))
				this.setMob(args.get(i).substring(4));
		}
	}
}
