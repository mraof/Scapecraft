package scapecraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

import scapecraft.Scapecraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemScapecraftBow extends ItemBow
{
	ScapecraftBowMaterial material;
	String textureName;
	IIcon[] icons = new IIcon[4];
	boolean hasModel = false;

	public ItemScapecraftBow(ScapecraftBowMaterial material, String textureName)
	{
		this.material = material;
		this.textureName = textureName;
		this.setUnlocalizedName(textureName);
		this.setCreativeTab(Scapecraft.tabScapecraftWeapon);
	}

	public ItemScapecraftBow setHasModel(boolean hasModel)
	{
		this.hasModel = hasModel;
		return this;
	}

	@Override
	public int getItemEnchantability(ItemStack itemStack)
	{
		return material.getEnchantability();
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int itemInUseCount)
	{
		int charge = this.getMaxItemUseDuration(itemStack) - itemInUseCount;

		ArrowLooseEvent event = new ArrowLooseEvent(player, itemStack, charge);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.isCanceled())
		{
			return;
		}
		charge = event.charge;

		boolean isInfinite = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0 || material.getAmmo() == null;

		if(isInfinite || player.inventory.hasItem(material.getAmmo()))
		{
			float force = (float)charge / material.getSpeed();
			force = (force * force + force * 2) / 3F;

			if((double)force < 0.1D)
			{
				return;
			}

			if(force > 1F)
			{
				force = 1F;
			}

			EntityArrow entityArrow = new EntityArrow(world, player, 2F * force);

			if(force == 1F)
			{
				entityArrow.setIsCritical(true);
			}

			int power = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, itemStack) - 1;
			entityArrow.setDamage(entityArrow.getDamage() + material.getDamage() + (double)power * 0.5D + 0.5D);
			int punch = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, itemStack);

			if(punch > 0)
			{
				entityArrow.setKnockbackStrength(punch);
			}

			if(EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemStack) > 0)
			{
				entityArrow.setFire(100);
			}

			itemStack.damageItem(1, player);
			world.playSoundAtEntity(player, "random.bow", 1F, 1F / (itemRand.nextFloat() * 0.4F + 1.2F) + force * 0.5F);

			if(isInfinite)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				player.inventory.consumeInventoryItem(material.getAmmo());
			}

			if(!world.isRemote)
			{
				world.spawnEntityInWorld(entityArrow);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		if(this.hasModel)
			this.icons[0] = iconRegister.registerIcon("scapecraft:" + textureName);

		for(int i = 0; i <= 3; i++)
		{
			if(!this.hasModel)
				this.icons[i] = iconRegister.registerIcon("scapecraft:" + textureName + "_" + i);
			else
				this.icons[i] = this.icons[0];
		}

		this.itemIcon = this.icons[0];
	}

	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if(useRemaining == 0)
			return this.icons[0];
		int duration = (int) ((stack.getMaxItemUseDuration() - useRemaining) * 4 / material.getSpeed());
		if(duration > 3)
			duration = 3;
		return this.icons[duration];
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean advancedTooltips)
	{
		super.addInformation(itemStack, player, lines, advancedTooltips);
		lines.add(StatCollector.translateToLocal("bow.speed") + " " + material.getSpeed() / 20);
	}
}
