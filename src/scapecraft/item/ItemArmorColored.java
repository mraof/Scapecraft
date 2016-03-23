package scapecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
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

    public ItemArmorColored(int level, float damageReduction, int type, String armorName)
    {
        super(level, damageReduction, type, armorName);
    }

    @Override
    public boolean hasColor(ItemStack stack)
    {
        return true;
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int pass)
    {
        return this.getColor(stack);
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

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "overlay".equals(type) ? "scapecraft:textures/blocks/Clear.png" : this.textureName;
    }
}
