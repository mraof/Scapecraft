package scapecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import scapecraft.economy.EconomyHandler;
import scapecraft.economy.market.Listing;
import scapecraft.economy.market.PlayerLister;

import java.util.TreeSet;
import java.util.UUID;

/**
 * Created by mraof on 2016 March 14 at 6:06 PM.
 */
public class SellCommand extends CommandBase
{

    @Override
    public String getCommandName()
    {
        return "sell";
    }

    @Override
    public String getCommandUsage(ICommandSender sender)
    {
        return "commands.sell.usage";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        if(args.length == 1)
        {
            int price = Integer.parseInt(args[0]);
            EntityPlayerMP player = getCommandSenderAsPlayer(sender);
            UUID uuid = player.getUniqueID();
            if(player.getHeldItem() != null && price >= 0)
            {
                ItemStack stack = player.getHeldItem();
                TreeSet<Listing> listings = EconomyHandler.scEconomy.getGlobalMarket();
                for(Listing listing : listings)
                {
                    if(listing.lister instanceof PlayerLister && ((PlayerLister) listing.lister).uuid.equals(uuid) && listing.price == price && ItemStack.areItemStacksEqual(listing.stack, stack))
                    {
                        listing.stock++;
                        player.inventory.decrStackSize(player.inventory.currentItem, stack.stackSize);
                        return;
                    }
                }
                Listing listing = new Listing(price, stack.copy(), true);
                listing.lister = new PlayerLister(uuid, player.getCommandSenderName());
                listing.stock = 1;
                listings.add(listing);
                player.inventory.decrStackSize(player.inventory.currentItem, stack.stackSize);
            }
        }
    }
}
