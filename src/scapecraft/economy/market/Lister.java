package scapecraft.economy.market;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by mraof on 2016 March 14 at 5:24 PM.
 */
public interface Lister
{
    void deposit(double amount);
    double balance();

    NBTTagCompound toNBT();
}
