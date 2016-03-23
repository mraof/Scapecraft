package scapecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import scapecraft.Scapecraft;

import java.io.IOException;
import java.util.List;

public class ItemArmorScapecraft extends ItemArmor implements QualityItem
{
	public String armorName;
	private static ArmorMaterial fakeMaterial = EnumHelper.addArmorMaterial("SCAPECRAFTARMOR", 1000, new int[] {1, 1, 1, 1}, 1); //Values are all totally arbitrary
	@SideOnly(Side.CLIENT)
	public ModelBiped armorModel;
	protected float damageReduction;
	protected int minLevel;

	public String textureName;
	protected double healthBoost = 0;

	public ItemArmorScapecraft(int level, float damageReduction, int type, String armorName)
	{
		super(fakeMaterial, type, type);
		this.minLevel = level;
		this.damageReduction = damageReduction;
		this.armorName = armorName;
		this.setUnlocalizedName(armorName);
		this.setCreativeTab(Scapecraft.tabScapecraftArmor);
		this.setMaxDurability((level / 5 + 1) * 125);
		this.textureName = "scapecraft:textures/armor/" + armorName + ".png";
	}

	@Override
	public boolean hasColor(ItemStack stack)
	{
		return true;
	}

	@Override
	public int getColorFromItemStack(ItemStack stack, int pass)
	{
		return this.getColor(stack);
	}

	@Override
	public int getColor(ItemStack stack)
	{
		return 0xFFFFFF;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return "overlay".equals(type) && stack.hasTagCompound() && stack.getTagCompound().hasKey("overlay") ? stack.getTagCompound().getString("overlay") : this.textureName;
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconReg) 
	{
		itemIcon = iconReg.registerIcon("scapecraft:" + armorName);
		try
		{
			Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(textureName));
		} catch (IOException e)
		{
			System.err.printf("Missing armor texture: %s%n", textureName);
		}
	}

	//Overriding ItemArmor for using ScapecraftArmorMaterial instead of ArmorMaterial


	/**
	 * Return the enchantability factor of the item, most of the time is based on material.
	 */
	@Override
	public int getItemEnchantability()
	{
		return 0;
	}

	/**
	 * Return whether this item is repairable in an anvil.
	 */
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return false;
	}
	//Special armor effects

	public void onWearerAttack(LivingHurtEvent event)
	{
	}

	public int getMinLevel()
	{
		return this.minLevel;
	}

	public double getHealthBoost()
	{
		return this.healthBoost;
	}

	@Override
	public int getMaxDamage(ItemStack stack)
	{
		int durability = this.getMaxDurability();
		if (stack.getTagCompound() != null)
		{
			durability = this.getMaxDurability() + (2 * this.minLevel * (stack.getTagCompound().getInteger("level") - this.minLevel));
			if (durability < this.getMaxDurability() / 3)
			{
				durability = this.getMaxDurability() / 3;
			}
		}
		return durability;
	}

	/*
	public ScapecraftArmorMaterial getScapecraftArmorMaterial()
	{
		return this.material;
	}
	*/

	/*
	public static boolean isWearingFullSet(EntityPlayer entity, ScapecraftArmorMaterial material)
	{
		boolean fullSet = true;
		for(int i = 0; i <= 3; i++)
		{
			if(entity.getCurrentArmor(i) == null || !(entity.getCurrentArmor(i).getItem() instanceof ItemArmorScapecraft) || ((ItemArmorScapecraft) entity.getCurrentArmor(i).getItem()).getScapecraftArmorMaterial() != material)
				fullSet = false;
		}
		return fullSet;
	}

	public boolean isWearingFullSet(EntityPlayer entity)
	{
		return isWearingFullSet(entity, this.material);
	}
	*/

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean advancedTooltips)
	{
		super.addInformation(itemStack, player, lines, advancedTooltips);
		lines.add(StatCollector.translateToLocal("weapon.minlevel") + " " + this.getMinLevel());
		lines.add(StatCollector.translateToLocal("armor.healthboost") + " " + this.getHealthBoost());

		if(itemStack.getTagCompound() != null)
		{
			lines.add(itemStack.getTagCompound().getString("source"));
		}
		lines.add("Uses remaining: " + (this.getMaxDamage(itemStack) - itemStack.getMetadata()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		if(armorModel == null)
		{
			return super.getArmorModel(entityLiving, itemStack, armorSlot);
		}

		armorModel.bipedHead.showModel = armorSlot == 0;
		armorModel.bipedHeadwear.showModel = armorSlot == 0;
		armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
		armorModel.bipedRightArm.showModel = armorSlot == 1;
		armorModel.bipedLeftArm.showModel = armorSlot == 1;
		armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
		armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;

		armorModel.isSneak = entityLiving.isSneaking();
		armorModel.isRiding = entityLiving.isRiding();
		armorModel.isChild = entityLiving.isChild();
		armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 :0;
		if(entityLiving instanceof EntityPlayer)
		{
			armorModel.aimedBow = ((EntityPlayer)entityLiving).getItemInUseDuration() > 2;
		}
		return armorModel;
	}

	public float getDamageReduction()
	{
		return damageReduction;
	}
}
