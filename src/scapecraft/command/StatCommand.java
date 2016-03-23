package scapecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

public class StatCommand extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "stat";
	}

	@Override
	public String getCommandUsage(ICommandSender sender)
	{
		return "commands.stat.usage";
	}

	@Override
	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args)
	{
		if(args.length < 3)
		{
			return;
		}
		EntityPlayerMP player = getPlayer(sender, args[0]);
		if("get".equalsIgnoreCase(args[1]))
		{
			getCommandSenderAsPlayer(sender).addChatMessage(new ChatComponentText(player.getCommandSenderName() + " is level " + Stats.getLevel(player, Stat.valueOf(args[2].toUpperCase())) + " (" + Stats.getXp(player, Stat.valueOf(args[2].toUpperCase())) + "xp) for " + args[2]));
		}
		else if("set".equalsIgnoreCase(args[1]) && args.length >= 4)
		{
			Stat stat = Stat.valueOf(args[2].toUpperCase());
			Stats.setXp(player, stat, Long.parseLong(args[3]));
			getCommandSenderAsPlayer(sender).addChatMessage(new ChatComponentText(player.getCommandSenderName() + " is level " + Stats.getLevel(player, Stat.valueOf(args[2].toUpperCase())) + " (" + Stats.getXp(player, Stat.valueOf(args[2].toUpperCase())) + "xp) for " + args[2]));
		}
		else if("add".equalsIgnoreCase(args[1]) && args.length >= 4)
		{
			Stat stat = Stat.valueOf(args[2].toUpperCase());
			Stats.addXp(player, stat, Long.parseLong(args[3]));
			getCommandSenderAsPlayer(sender).addChatMessage(new ChatComponentText(player.getCommandSenderName() + " is level " + Stats.getLevel(player, Stat.valueOf(args[2].toUpperCase())) + " (" + Stats.getXp(player, Stat.valueOf(args[2].toUpperCase())) + "xp) for " + args[2]));
		}
		else if("check".equalsIgnoreCase(args[1]) && args.length >= 4)
		{
			if(Stats.getLevel(player, Stat.valueOf(args[2].toUpperCase())) < Integer.parseInt(args[3]))
			{
				throw new CommandException("commands.stat.failed"); //Have to throw an exception to say the command failed for some reason
			}
		}
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index)
	{
		return index == 0;
	}
}

