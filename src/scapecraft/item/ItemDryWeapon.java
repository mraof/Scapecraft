package scapecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

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
	public void onEntityHurt(LivingHurtEvent event)
	{
		if(!(event.entityLiving instanceof EntityPlayer))
		{
			event.ammount += extraDamage;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean advancedTooltips)
	{
		super.addInformation(itemStack, player, lines, advancedTooltips);
		lines.add("+" + extraDamage + " " + StatCollector.translateToLocal("weapon.dryboost"));
	}
}
