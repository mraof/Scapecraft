package scapecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mraof on 2016 March 02.
 */
public class ItemArmorColored extends ItemArmorScapecraft
{
    ArrayList<ItemStack> subItems = new ArrayList<ItemStack>();

    public ItemArmorColored(int level, float damageReduction, EntityEquipmentSlot type, String armorName)
    {
        super(level, damageReduction, type, armorName);
    }

    @Override
    public boolean hasColor(ItemStack stack)
    {
        return true;
    }

    @Override
    public int getColor(ItemStack stack)
    {
        return stack.hasTagCompound() ? stack.getTagCompound().getInteger("color") : 0xFFFFFF;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return getUnlocalizedName() + (stack.hasTagCompound() ? "." + stack.getTagCompound().getString("colorName") : "white");
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List subItems)
    {
        //noinspection unchecked
        subItems.addAll(this.subItems);
    }

    public ItemArmorColored addColor(String colorName, int color)
    {
        ItemStack stack = new ItemStack(this);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("color", color);
        tag.setString("colorName", colorName);
        stack.setTagCompound(tag);
        subItems.add(stack);
        return this;
    }
}
