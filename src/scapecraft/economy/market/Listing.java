package scapecraft.economy.market;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by mraof on 2016 March 14 at 5:02 PM.
 */
public class Listing
{
    public final int price;
    public final ItemStack stack;
    public int stock = 0;
    public Lister lister = null;
    public final boolean selling;

    public Listing(int price, ItemStack stack, boolean selling)
    {
        this.price = price;
        this.stack = stack;
        this.selling = selling;
    }

    public boolean buy()
    {
        if(lister == null)
        {
            return true;
        }
        if(stock == 0)
        {
            return false;
        }
        if (selling)
        {
            stock--;
            lister.deposit(price);
            return true;
        }
        else
        {
            if (lister.balance() >= price)
            {
                stock--;
                lister.deposit(-price);
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public NBTTagCompound toNBT()
    {
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setTag("lister", lister.toNBT());
        NBTTagCompound stackTag = new NBTTagCompound();
        stack.writeToNBT(stackTag);
        tagCompound.setTag("stack", stackTag);
        tagCompound.setInteger("price", price);
        tagCompound.setInteger("stock", stock);
        tagCompound.setBoolean("selling", selling);
        return tagCompound;
    }

    public static Listing fromNBT(NBTTagCompound tagCompound)
    {
        Listing listing = new Listing(tagCompound.getInteger("price"), ItemStack.loadItemStackFromNBT(tagCompound.getCompoundTag("stack")), tagCompound.getBoolean("selling"));
        listing.stock = tagCompound.getInteger("stock");
        return listing;
    }

    @Override
    public String toString()
    {
        return "Listing{" +
               "price=" + price +
               ", stack=" + stack +
               ", stock=" + stock +
               ", lister=" + lister +
               ", selling=" + selling +
               '}';
    }
}
