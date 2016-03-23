package scapecraft.economy.market;

import net.minecraft.nbt.NBTTagCompound;
import scapecraft.economy.EconomyHandler;

import java.util.UUID;

/**
 * Created by mraof on 2016 March 14 at 5:26 PM.
 */
public class PlayerLister implements Lister
{
    public String name;
    public UUID uuid;

    public PlayerLister(UUID uuid, String name)
    {
        this.uuid = uuid;
        this.name = name;
    }

    @Override
    public void deposit(double amount)
    {
        EconomyHandler.deposit(uuid, amount);
    }

    @Override
    public double balance()
    {
        return EconomyHandler.getBalance(uuid);
    }

    @Override
    public NBTTagCompound toNBT()
    {
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setString("name", name);
        tagCompound.setString("uuid", uuid.toString());
        return tagCompound;
    }

    public static PlayerLister fromNBT(NBTTagCompound tagCompound)
    {
        return new PlayerLister(UUID.fromString(tagCompound.getString("uuid")), tagCompound.getString("name"));
    }

    @Override
    public String toString()
    {
        return "PlayerLister{" +
               "name='" + name + '\'' +
               ", uuid=" + uuid +
               '}';
    }
}
