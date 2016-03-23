package scapecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import scapecraft.Scapecraft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mraof on 2016 March 02 at 11:35 PM.
 */
public class ItemMulti extends Item
{
    private final String baseName;
    protected ArrayList<ItemStack> subItems = new ArrayList<ItemStack>();
    protected ArrayList<String> names = new ArrayList<String>();
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemMulti(String baseName)
    {
        this.baseName = baseName;
        this.setUnlocalizedName(baseName);
        setCreativeTab(Scapecraft.tabScapecraftMisc);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List subItems)
    {
        //noinspection unchecked
        subItems.addAll(this.subItems);
    }

    public void addSubItems(String... names)
    {
        for(String name : names)
        {
            ItemStack stack = new ItemStack(this, 1, subItems.size());
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setString("intended", name);
            subItems.add(stack);
            this.names.add(name);
        }
    }

    public ItemStack getStackFromName(String name)
    {
        return names.contains(name) ? subItems.get(names.indexOf(name)).copy() : null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata)
    {
        return icons[metadata % icons.length];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return getUnlocalizedName() + "." + names.get(stack.getMetadata() % names.size());
    }

    @Override
    public void registerIcons(IIconRegister register)
    {
        icons = new IIcon[names.size()];
        for(int i = 0; i < names.size(); i++)
        {
            icons[i] = register.registerIcon("scapecraft:" + baseName + "/" + names.get(i));
        }
    }
}
