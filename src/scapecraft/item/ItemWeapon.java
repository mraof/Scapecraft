package scapecraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import scapecraft.Scapecraft;
import scapecraft.Stats;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWeapon extends ItemSword
{
	protected float weaponDamage;
	protected final ScapecraftToolMaterial toolMaterial;
	protected final String name;

	public ItemWeapon(ScapecraftToolMaterial toolMaterial, float baseDamage, String name)
	{
		super(ToolMaterial.GOLD);
		this.toolMaterial = toolMaterial;
		this.setMaxDurability(toolMaterial.getMaxUses());
		this.weaponDamage = baseDamage + toolMaterial.getDamageVsEntity();
		System.out.println(weaponDamage);
		this.name = name;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Scapecraft.tabScapecraftWeapon);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Multimap getItemAttributeModifiers()
	{
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", (double)this.weaponDamage, 0));
		return multimap;
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("scapecraft:" + name);
	}

	/* Not 100% sure what this is for, but it isn't unused */
	@Override
	public float func_150931_i()
	{
		return this.toolMaterial.getDamageVsEntity();
	}

	@Override
	public int getItemEnchantability()
	{
		return this.toolMaterial.getEnchantability();
	}

	@Override
	public String getToolMaterialName()
	{
		return this.toolMaterial.toString();
	}

	@Override
	public boolean getIsRepairable(ItemStack itemstack, ItemStack itemstack2)
	{
		return false; //TODO is this right?
	}

	public void onEntityHurt(LivingHurtEvent event)
	{
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean advancedTooltips)
	{
		super.addInformation(itemStack, player, lines, advancedTooltips);
		if(Scapecraft.requireLevels)
		{
			lines.add(StatCollector.translateToLocal("weapon.minlevel") + " " + toolMaterial.getMinLevel());
		}
	}

	public boolean unableToUse(EntityLivingBase entityLiving)
	{
		if(entityLiving instanceof EntityPlayer)
		{
			if(Scapecraft.requireLevels && Stats.getCombatLevel((EntityPlayer) entityLiving) < this.toolMaterial.getMinLevel() && !((EntityPlayer) entityLiving).capabilities.isCreativeMode)
			{
				return true;
			}
		}
		return false;
	}
	//Don't swing the weapon normally, this is also where custom attacking can start
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		return unableToUse(entityLiving);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity target)
	{
		return unableToUse(player);
	}
}
