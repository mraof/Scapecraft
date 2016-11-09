package scapecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import scapecraft.economy.EconomyHandler;

import java.util.UUID;

/**
 * Created by mraof on 2016 March 12 at 2:24 AM.
 */
public class MoneyCommand extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "money";
    }

    @Override
    public String getCommandUsage(ICommandSender sender)
    {
        return "/money";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if(args.length == 0 || !sender.canCommandSenderUseCommand(2, "money"))
        {
            double balance = 0;
            if(sender instanceof EntityPlayerMP)
            {
                balance = EconomyHandler.getBalance(((EntityPlayerMP) sender).getUniqueID());
            }
            sender.addChatMessage(new TextComponentString("Balance: " + balance));
        }
        else
        {
            UUID uuid = null;
            int offset = 0;
            if(!args[0].matches("^[-\\d]\\d*$"))
            {
                EntityPlayerMP player = getPlayer(server, sender, args[0]);
                if(player != null)
                {
                    uuid = player.getUniqueID();
                }
                offset++;
            }
            else if(sender instanceof EntityPlayerMP)
            {
                uuid = ((EntityPlayerMP) sender).getUniqueID();
            }
            if(uuid == null)
            {
                throw new WrongUsageException("Not a player");
            }
            if(args.length > offset)
            {
                if("check".equalsIgnoreCase(args[offset]))
                {
                    if(EconomyHandler.getBalance(uuid) < Double.parseDouble(args[offset + 1]))
                    {
                        throw new CommandException("commands.stat.failed"); //Have to throw an exception to say the command failed for some reason
                    }
                }
                else
                {
                    EconomyHandler.deposit(uuid, Double.parseDouble(args[offset]));
                }
            }
            else
            {
                sender.addChatMessage(new TextComponentString("Balance: " + EconomyHandler.getBalance(uuid)));
            }
        }
    }
}
