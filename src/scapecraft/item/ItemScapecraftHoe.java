package scapecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import scapecraft.Scapecraft;

import java.util.List;

public class ItemScapecraftHoe extends ItemHoe implements QualityItem
{
	int level;
	public ItemScapecraftHoe(int level, String name)
	{
		super(ToolMaterial.GOLD);
		this.setCreativeTab(Scapecraft.tabScapecraftTool);
		this.setMaxDurability((level * level / 2 + 50) * 2);
		this.level = level;
		this.setUnlocalizedName(name);
		this.setTextureName("scapecraft:" + name);
	}

	@Override
	public int getMaxDamage(ItemStack stack)
	{
		int durability = this.getMaxDurability();
		if (stack.getTagCompound() != null && stack.getTagCompound().hasKey("level"))
		{
			durability = (this.getMaxDurability() + (2 * this.level * (stack.getTagCompound().getInteger("level") - this.level)));
			if (durability < this.getMaxDurability())
			{
				durability = this.getMaxDurability();
			}
		}
		return durability;
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean advancedTooltips)
	{
		super.addInformation(itemStack, player, lines, advancedTooltips);

		if(itemStack.getTagCompound() != null && itemStack.getTagCompound().hasKey("source"))
		{
			lines.add(itemStack.getTagCompound().getString("source"));
		}
		lines.add("Uses remaining: " + (this.getMaxDamage(itemStack) - itemStack.getMetadata()));
	}
}
