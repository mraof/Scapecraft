package scapecraft.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scapecraft.Scapecraft;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.util.List;

public class ItemWeapon extends ItemSword implements QualityItem
{
	protected float weaponDamage;
	protected final String name;
	protected double attackTime = 1; //lower values are faster

	private int minLevel = 0;

	public ItemWeapon(float damage, String name, int level)
	{
		this(damage, name, level, 1);
	}

	public ItemWeapon(float damage, String name, int level, double attackTime)
	{
		super(ToolMaterial.GOLD);
		this.name = name;
		this.weaponDamage = (float) (attackTime / 2 + 0.5) * damage;
		this.setMaxDamage((int) (damage * 25));
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Scapecraft.tabScapecraftWeapon);
		this.minLevel = level;
		this.attackTime = attackTime;
		System.out.println(weaponDamage);
	}

	@Override
	public int getMaxDamage(ItemStack stack)
	{
		int durability = this.getMaxDamage();
		if (stack.getTagCompound() != null && stack.getTagCompound().hasKey("level"))
		{
			durability = (int) (this.getMaxDamage() + 2 * this.weaponDamage / this.attackTime * (stack.getTagCompound().getInteger("level") - this.minLevel));
			if (durability < this.getMaxDamage() / 2)
			{
				durability = this.getMaxDamage() / 2;
			}
		}
		return durability;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Multimap getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
	{
		Multimap multimap = HashMultimap.create();
		if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
		{
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.getWeaponDamage(), 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
		}
		return multimap;
	}

	@Override
	public int getItemEnchantability()
	{
		return 0;
	}

	@Override
	public boolean getIsRepairable(ItemStack itemstack, ItemStack itemstack2)
	{
		return false; //TODO is this right?
	}

	public float onEntityHurt(EntityLivingBase target, float amount)
	{
		target.hurtResistantTime = (int) (target.hurtResistantTime / 2 + target.hurtResistantTime / 2 * this.attackTime);
		return amount;
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean advancedTooltips)
	{
		super.addInformation(itemStack, player, lines, advancedTooltips);
		if(Scapecraft.requireLevels)
		{
			lines.add(I18n.translateToLocal("weapon.minlevel") + " " + this.minLevel);
		}
		if(itemStack.getTagCompound() != null && itemStack.getTagCompound().hasKey("source"))
		{
			lines.add(itemStack.getTagCompound().getString("source"));
		}
		lines.add("Uses remaining: " + (this.getMaxDamage(itemStack) - itemStack.getMetadata()));
	}

	public boolean unableToUse(EntityLivingBase entityLiving)
	{
		if(entityLiving instanceof EntityPlayer)
		{
			if(Scapecraft.requireLevels && Stats.getLevel((EntityPlayer) entityLiving, Stat.ATTACK) < this.minLevel && !((EntityPlayer) entityLiving).capabilities.isCreativeMode)
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

	public double getAttackTime()
	{
		return attackTime;
	}

	public float getWeaponDamage()
	{
		return weaponDamage;
	}

	public int getMinLevel()
	{
		return minLevel;
	}
}
