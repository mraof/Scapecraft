package scapecraft.item;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scapecraft.Scapecraft;

import java.util.List;

import static net.minecraft.inventory.EntityEquipmentSlot.*;

public class ItemArmorScapecraft extends ItemArmor implements QualityItem
{
	public String armorName;
	private static ArmorMaterial fakeMaterial = EnumHelper.addArmorMaterial("SCAPECRAFTARMOR", "SCAPECRAFTARMOR", 1, new int[] {1, 1, 1, 1}, 1, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1); //Values are all totally arbitrary
	@SideOnly(Side.CLIENT)
	public ModelBiped armorModel;
	protected float damageReduction;
	protected int minLevel;

	public String textureName;
	protected double healthBoost = 0;

	public ItemArmorScapecraft(int level, float damageReduction, EntityEquipmentSlot type, String armorName)
	{
		super(fakeMaterial, type.getIndex(), type);
		this.minLevel = level;
		this.damageReduction = damageReduction;
		this.armorName = armorName;
		this.setUnlocalizedName(armorName);
		this.setRegistryName(armorName);
		this.setCreativeTab(Scapecraft.tabScapecraftArmor);
		this.setMaxDamage(damageReduction > 0 ? (level / 5 + 1) * 125 : 0);
		this.textureName = "scapecraft:textures/armor/" + armorName + ".png";
	}

	@Override
	public boolean hasColor(ItemStack stack)
	{
		return true;
	}

	@Override
	public int getColor(ItemStack stack)
	{
		return 0xFFFFFF;
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
		int durability = this.getMaxDamage();
		if (stack.getTagCompound() != null)
		{
			durability = this.getMaxDamage() + (2 * this.minLevel * (stack.getTagCompound().getInteger("level") - this.minLevel));
			if (durability < this.getMaxDamage() / 3)
			{
				durability = this.getMaxDamage() / 3;
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
		lines.add(I18n.translateToLocal("weapon.minlevel") + " " + this.getMinLevel());
		if(this.getHealthBoost() > 0)
		{
			lines.add(I18n.translateToLocal("armor.healthboost") + " " + this.getHealthBoost());
		}
		lines.add(I18n.translateToLocalFormatted("armor.defense", this.getDamageReduction()));

		if(itemStack.getTagCompound() != null)
		{
			lines.add(itemStack.getTagCompound().getString("source"));
		}
		lines.add("Uses remaining: " + (this.getMaxDamage(itemStack) - itemStack.getMetadata()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default)
	{
		if(armorModel == null)
		{
			return null;
		}

		armorModel.bipedHead.showModel = armorSlot == HEAD;
		armorModel.bipedHeadwear.showModel = armorSlot == HEAD;
		armorModel.bipedBody.showModel = armorSlot == CHEST || armorSlot == LEGS;
		armorModel.bipedRightArm.showModel = armorSlot == CHEST;
		armorModel.bipedLeftArm.showModel = armorSlot == CHEST;
		armorModel.bipedRightLeg.showModel = armorSlot == LEGS || armorSlot == FEET;
		armorModel.bipedLeftLeg.showModel = armorSlot == LEGS || armorSlot == FEET;

		armorModel.setModelAttributes(_default);

		return armorModel;
	}

	public float getDamageReduction()
	{
		return damageReduction;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return this.textureName;
	}
}
