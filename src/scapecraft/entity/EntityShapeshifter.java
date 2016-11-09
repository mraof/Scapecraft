package scapecraft.entity;

import com.mojang.authlib.GameProfile;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

import java.util.ArrayList;
import java.util.Random;

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
		{
			this.setMob("Wizard");
		}
		else
		{
			this.setMob(mobName);
		}
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.1D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 1D));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	}

	public static String randomMobName()
	{
		int index = staticRand.nextInt(ScapecraftEntities.entities.size() + 1);
		if(index == ScapecraftEntities.entities.size())
		{
			return "@p";
		}
		else
		{
			return ScapecraftEntities.entities.get(index);
		}
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
		if(tagCompound.getCompoundTag("copiedMob") != null)
		{
			this.copiedMob.readEntityFromNBT(tagCompound.getCompoundTag("copiedMob"));
		}
	}

	public void setMob(String mobName)
	{
		if(mobName.isEmpty())
		{
			mobName = randomMobName();
		}
		try
		{
			this.mobName = mobName;
			if(mobName.startsWith("@p"))
			{
				if(mobName.length() == 2)
				{
					mobName = "@p" + selectRandomUsername();
				}
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

		if(copiedMob != null)
		{
			this.mobName = mobName;
			this.addTargets(copiedMob.getClass());
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(copiedMob.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getAttributeValue());
		}
		else
		{
			System.err.println("Shapeshifter has null mob for " + mobName + " at " + this.posX + ", " + this.posY + ", " + this.posZ + " on " + (worldObj.isRemote ? "Client" : "Server"));
			setMob(randomMobName());
		}
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2D);
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
		for(int i = 0; i < EntityEquipmentSlot.values().length; i++)
		{
			NBTTagCompound stackCompound = new NBTTagCompound();
			if(copiedMob.getItemStackFromSlot(EntityEquipmentSlot.values()[i]) != null)
			{
				copiedMob.getItemStackFromSlot(EntityEquipmentSlot.values()[i]).writeToNBT(stackCompound);
			}
			tagList.appendTag(stackCompound);
		}
		tagCompound.setTag("Equipment", tagList);
		if(copiedMob instanceof EntityGenericBiped)
		{
			NBTTagCompound profileNBT = new NBTTagCompound();
			NBTUtil.writeGameProfile(profileNBT, ((EntityGenericBiped)copiedMob).profile);
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
		for(int i = 0; i < EntityEquipmentSlot.values().length; i++)
		{
			copiedMob.setItemStackToSlot(EntityEquipmentSlot.values()[i], ItemStack.loadItemStackFromNBT(tagList.getCompoundTagAt(i)));
		}
		if(copiedMob instanceof EntityGenericBiped)
		{
			((EntityGenericBiped)copiedMob).profile = NBTUtil.readGameProfileFromNBT(tagCompound.getCompoundTag("Profile"));
			((EntityGenericBiped)copiedMob).name = ((EntityGenericBiped)copiedMob).profile.getName(); 
		}
	}

	@Override
	public String getName()
	{
		if(worldObj != null && worldObj.isRemote)
		{
			return copiedMob.getName();
		}
		return I18n.translateToLocalFormatted("entity.Scapecraft.Shapeshifter.mob", copiedMob.getName());
	}

	@Override
	public void setCustomNameTag(String name)
	{
		super.setCustomNameTag(name);
		if(this.copiedMob instanceof EntityLiving)
		{
			this.copiedMob.setCustomNameTag(name);
		}
	}

	@Override
	public String getCustomNameTag()
	{
		if(this.copiedMob instanceof EntityLiving)
		{
			return this.copiedMob.getCustomNameTag();
		}
		else
		{
			return super.getCustomNameTag();
		}
	}

	@Override
	public boolean hasCustomName()
	{
		if(this.copiedMob instanceof EntityLiving)
		{
			return this.copiedMob.hasCustomName();
		}
		else
		{
			return super.hasCustomName();
		}
	}

	@Override
	public boolean getAlwaysRenderNameTag()
	{
		if(this.copiedMob instanceof EntityLiving)
		{
			return this.copiedMob.getAlwaysRenderNameTag();
		}
		else
		{
			return super.getAlwaysRenderNameTag();
		}
	}

	public static String selectRandomUsername()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("mraof");
		for(String name : FMLCommonHandler.instance().getMinecraftServerInstance().getAllUsernames())
		{
			if(!names.contains(name))
			{
				names.add(name);
			}
		}
		return names.get(staticRand.nextInt(names.size()));
	}

	@Override
	public void parseSpawnArgument(String arg, String value)
	{
		super.parseSpawnArgument(arg, value);
		if("mob".equalsIgnoreCase(arg))
		{
			this.setMob(value);
		}
	}

	@Override
	public void setLevel(int level)
	{
		super.setLevel(level);
		if(copiedMob instanceof EntityScapecraft)
		{
			EntityScapecraft entityScapecraft = (EntityScapecraft) copiedMob;
			entityScapecraft.setLevel(level);
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(copiedMob.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getAttributeValue());
			this.setHealth(copiedMob.getMaxHealth());
			this.defense = entityScapecraft.getDefense();
		}
	}

	@Override
	public void setTexture(int textureNum)
	{
		if(copiedMob instanceof EntityScapecraft)
		{
			((EntityScapecraft) copiedMob).setTexture(textureNum);
		}
	}
}
