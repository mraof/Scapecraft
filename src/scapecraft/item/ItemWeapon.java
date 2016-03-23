package scapecraft.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
		this.setMaxDurability((int) (damage * 25));
		this.setUnlocalizedName(name);
		this.setCreativeTab(Scapecraft.tabScapecraftWeapon);
		this.minLevel = level;
		this.attackTime = attackTime;
		System.out.println(weaponDamage);
	}

	@Override
	public int getMaxDamage(ItemStack stack)
	{
		int durability = this.getMaxDurability();
		if (stack.getTagCompound() != null && stack.getTagCompound().hasKey("level"))
		{
			durability = (int) (this.getMaxDurability() + 2 * this.weaponDamage / this.attackTime * (stack.getTagCompound().getInteger("level") - this.minLevel));
			if (durability < this.getMaxDurability() / 2)
			{
				durability = this.getMaxDurability() / 2;
			}
		}
		return durability;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Multimap getItemAttributeModifiers()
	{
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", (double)this.getWeaponDamage(), 0));
		return multimap;
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("scapecraft:" + name);
	}

	/* Return damage for looting mobs to determine if they should pick it up*/
	@Override
	public float func_150931_i()
	{
		return this.getWeaponDamage() - 4;
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

	public void onEntityHurt(LivingHurtEvent event)
	{
		event.entityLiving.hurtResistantTime *= this.attackTime;
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean advancedTooltips)
	{
		super.addInformation(itemStack, player, lines, advancedTooltips);
		if(Scapecraft.requireLevels)
		{
			lines.add(StatCollector.translateToLocal("weapon.minlevel") + " " + this.minLevel);
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
