package scapecraft.item;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import scapecraft.client.ClientProxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorBandos extends ItemArmorScapecraft
{
	public int[] damageBoosts = {3, 6, 2, 3};

	public ItemArmorBandos(ScapecraftArmorMaterial armorMaterial, int par3, int par4, String armornamePrefix)
	{
		super(armorMaterial, par3, par4, armornamePrefix);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		super.getArmorModel(entityLiving, itemStack, armorSlot);
		ModelBiped armorModel = (this.armorType == 1 || this.armorType == 3) ? ClientProxy.bandosChest : ClientProxy.bandosLegs;

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
	
	@Override
	public void onWearerAttack(LivingHurtEvent event)
	{
		if(!event.source.isProjectile())
		{
			event.ammount += damageBoosts[armorType];
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean advancedTooltips)
	{
		super.addInformation(itemStack, player, lines, advancedTooltips);
		lines.add(StatCollector.translateToLocal("armor.attackboost") +" +" + damageBoosts[this.armorType]);
	}
}
