package scapecraft.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemDryWeapon extends ItemWeapon
 {
	public float extraDamage;
	public ItemDryWeapon(float extraDamage, String name)
	{
		super(75, name, 75, 1);
		this.extraDamage = extraDamage;
	}

	@Override
	public float onEntityHurt(EntityLivingBase target, float amount)
	{
		if(!(target instanceof EntityPlayer))
		{
			amount += extraDamage;
		}
		return super.onEntityHurt(target, amount);
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean advancedTooltips)
	{
		super.addInformation(itemStack, player, lines, advancedTooltips);
		lines.add("+" + extraDamage + " " + I18n.translateToLocal("weapon.dryboost"));
	}
}
