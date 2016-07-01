package scapecraft.command;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;
import com.ibm.icu.util.BytesTrie;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.util.*;

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
		if(args.length < 2)
		{
			return;
		}
		EntityPlayerMP player = null;
		UUID uuid;
		try
		{
			player = getPlayer(sender, args[0]);
			uuid = player.getUniqueID();
		}
		catch (PlayerNotFoundException e)
		{
			uuid = Stats.getUUID(args[0].toLowerCase());
		}

		if("list".equalsIgnoreCase(args[1]))
		{
			if ("*".equals(args[0]))
			{
				BiMap<UUID, String> nameUUIDs = Stats.uuidNames.inverse();
				if (args.length >= 3)
				{
					Stat stat = Stat.valueOf(args[2].toUpperCase());
					ImmutableSortedMap.Builder<Integer, String> statValues = new ImmutableSortedMap.Builder<Integer, String>(Ordering.natural());

					for (Map.Entry<UUID, HashMap<Stat, Stats>> entry : Stats.serverStats.entrySet())
					{
						String name = entry.getKey().toString();
						if (nameUUIDs.containsKey(entry.getKey()))
						{
							name = nameUUIDs.get(entry.getKey());
						}
						statValues.put(Stats.getLevel(entry.getKey(), stat), name);
					}

					for (Map.Entry<Integer, String> entry : statValues.build().entrySet())
					{
						sender.addChatMessage(new ChatComponentText(entry.getValue()));
					}
				}
				else
				{
					for (Map.Entry<UUID, HashMap<Stat, Stats>> entry : Stats.serverStats.entrySet())
					{
						String message = entry.getKey().toString();
						if (nameUUIDs.containsKey(entry.getKey()))
						{
							message = nameUUIDs.get(entry.getKey());
						}

						for (Map.Entry<Stat, Stats> statsEntry : entry.getValue().entrySet())
						{
							message += " " + statsEntry.getKey() + " " + statsEntry.getValue().level;
						}
						sender.addChatMessage(new ChatComponentText(message));
					}
				}

			}
			else
			{
				String message = args[0];
				for (Map.Entry<Stat, Stats> statsEntry : Stats.serverStats.get(uuid).entrySet())
				{
					message += " " + statsEntry.getKey() + " " + statsEntry.getValue().level;
				}
				sender.addChatMessage(new ChatComponentText(message));
			}
			return;
		}
		if(args.length < 3)
		{
			return;
		}
		if(uuid == null)
		{
			throw new PlayerNotFoundException();
		}
		if("get".equalsIgnoreCase(args[1]))
		{
			if(player != null)
			{
				sender.addChatMessage(new ChatComponentText(player.getCommandSenderName() + " is level " + Stats.getLevel(player, Stat.valueOf(args[2].toUpperCase())) + " (" + Stats.getXp(player, Stat.valueOf(args[2].toUpperCase())) + "xp) for " + args[2]));
			}
			else
			{
				sender.addChatMessage(new ChatComponentText(args[0] + " is level " + Stats.getLevel(uuid, Stat.valueOf(args[2].toUpperCase())) + " (" + Stats.getXp(uuid, Stat.valueOf(args[2].toUpperCase())) + "xp) for " + args[2]));
			}
		}
		else if("set".equalsIgnoreCase(args[1]) && args.length >= 4)
		{
			Stat stat = Stat.valueOf(args[2].toUpperCase());
			if (player != null)
			{
				Stats.setXp(player, stat, Long.parseLong(args[3]));
				sender.addChatMessage(new ChatComponentText(player.getCommandSenderName() + " is level " + Stats.getLevel(player, Stat.valueOf(args[2].toUpperCase())) + " (" + Stats.getXp(player, Stat.valueOf(args[2].toUpperCase())) + "xp) for " + args[2]));
			}
			else
			{
				Stats.setXp(uuid, stat, Long.parseLong(args[3]));
				sender.addChatMessage(new ChatComponentText(args[0] + " is level " + Stats.getLevel(uuid, Stat.valueOf(args[2].toUpperCase())) + " (" + Stats.getXp(uuid, Stat.valueOf(args[2].toUpperCase())) + "xp) for " + args[2]));
			}
		}
		else if("add".equalsIgnoreCase(args[1]) && args.length >= 4)
		{
			Stat stat = Stat.valueOf(args[2].toUpperCase());
			if (player != null)
			{
				Stats.addXp(player, stat, Long.parseLong(args[3]));
				sender.addChatMessage(new ChatComponentText(player.getCommandSenderName() + " is level " + Stats.getLevel(player, Stat.valueOf(args[2].toUpperCase())) + " (" + Stats.getXp(player, Stat.valueOf(args[2].toUpperCase())) + "xp) for " + args[2]));
			}
			else
			{
				Stats.addXp(uuid, stat, Long.parseLong(args[3]));
				sender.addChatMessage(new ChatComponentText(args[0] + " is level " + Stats.getLevel(uuid, Stat.valueOf(args[2].toUpperCase())) + " (" + Stats.getXp(uuid, Stat.valueOf(args[2].toUpperCase())) + "xp) for " + args[2]));
			}
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

