package scapecraft.entity;

import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import scapecraft.item.ScapecraftItems;

public class EntityGenericBiped extends EntityLiving
{
	private String[] prefixes = new String[] {"bronze", "iron", "steel", "black", "white", "mithril", "adamant", "rune", "dragon"};
	public String name = "";
	public GameProfile profile = null;

	public EntityGenericBiped(World world)
	{
		super(world);
	}

	@Override
	public String getName()
	{
		return name;
	}

	public void setGameProfile(GameProfile profile)
	{
		if(!profile.isComplete() || !profile.getProperties().containsKey("textures"))
		{
			GameProfile cachedProfile = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerProfileCache().getGameProfileForUsername(profile.getName());
			if(cachedProfile != null)
			{
				if(Iterables.getFirst(cachedProfile.getProperties().get("textures"), (Object)null) == null)
				{
					cachedProfile = FMLCommonHandler.instance().getMinecraftServerInstance().getMinecraftSessionService().fillProfileProperties(cachedProfile, true);
				}
				profile = cachedProfile;
			}
		}

		this.profile = profile;
		this.name = profile.getName();
	}

	public void addRandomEquipment()
	{
		if(!worldObj.isRemote && FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(this.name) != null)
		{
			EntityPlayer player = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(this.name);
			for(EntityEquipmentSlot slot : EntityEquipmentSlot.values())
			{
				this.setItemStackToSlot(slot, player.getItemStackFromSlot(slot));
			}
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getAttributeValue());
		}
		else
		{
			String prefix = prefixes[rand.nextInt(prefixes.length)];
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ScapecraftItems.equipmentSets.get(prefix + "Sword")));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(ScapecraftItems.equipmentSets.get(prefix + "Helmet")));
			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(ScapecraftItems.equipmentSets.get(prefix + "Platebody")));
			this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(ScapecraftItems.equipmentSets.get(prefix + "Platelegs")));
			this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(ScapecraftItems.equipmentSets.get(prefix + "Boots")));
		}
	}

	@Override
	public String getCustomNameTag()
	{
		return this.name;
	}

	@Override
	public boolean hasCustomName()
	{
		return this.name.length() > 0;
	}

	@Override
	public boolean getAlwaysRenderNameTag()
	{
		return hasCustomName();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound)
	{
		super.writeEntityToNBT(tagCompound);
		NBTTagCompound profileNBT = new NBTTagCompound();
		NBTUtil.writeGameProfile(profileNBT, this.profile);
		tagCompound.setTag("Profile", profileNBT);
		tagCompound.setString("name", this.name);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompound)
	{
		super.readEntityFromNBT(tagCompound);
		if(tagCompound.getCompoundTag("Profile") != null)
		{
			this.profile = NBTUtil.readGameProfileFromNBT(tagCompound.getCompoundTag("Profile"));
		}
		this.name = tagCompound.getString("name");
	}
}
