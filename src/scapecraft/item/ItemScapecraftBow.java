package scapecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scapecraft.Scapecraft;

import java.util.List;

//TODO reimplement bows with level requirement
public class ItemScapecraftBow extends ItemBow
{
	private final float damage;
	private final int level;
	String textureName;
	boolean hasModel = false;
	int speed;
	Item ammo;

	public ItemScapecraftBow(float damage, String name, int level, double speed)
	{
		this.damage = (float) (speed / 2 + 0.5) * damage;
		this.setMaxDamage((int) (damage * 25));
		this.level = level;
		this.setCreativeTab(Scapecraft.tabScapecraftWeapon);
		this.textureName = name;
		this.setUnlocalizedName(name);
		this.speed = (int) (20 * speed);
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean advancedTooltips)
	{
		super.addInformation(itemStack, player, lines, advancedTooltips);
		lines.add(I18n.translateToLocal("bow.speed") + " " + speed / 20D);
	}

}
