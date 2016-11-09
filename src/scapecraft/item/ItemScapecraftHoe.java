package scapecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scapecraft.Scapecraft;

import java.util.List;

public class ItemScapecraftHoe extends ItemHoe implements QualityItem
{
	int level;
	public ItemScapecraftHoe(int level, String name)
	{
		super(ToolMaterial.GOLD);
		this.setCreativeTab(Scapecraft.tabScapecraftTool);
		this.setMaxDamage((level * level / 2 + 50) * 2);
		this.level = level;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}

	@Override
	public int getMaxDamage(ItemStack stack)
	{
		int durability = this.getMaxDamage();
		if (stack.getTagCompound() != null && stack.getTagCompound().hasKey("level"))
		{
			durability = (this.getMaxDamage() + (2 * this.level * (stack.getTagCompound().getInteger("level") - this.level)));
			if (durability < this.getMaxDamage())
			{
				durability = this.getMaxDamage();
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
