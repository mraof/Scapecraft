package scapecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentText;
import scapecraft.Scapecraft;
import scapecraft.event.WorldProtectionHandler;
import scapecraft.network.RegionPacket;

/**
 * Created by mraof on 2016 March 02.
 */
public class RegionCommand extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "region";
    }

    @Override
    public String getCommandUsage(ICommandSender sender)
    {
        return "commands.region.usage";
    }

    @Override
    public int getRequiredPermissionLevel()
	{
		return 2;
	}

    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        if(args.length == 0)
        {
            throw new WrongUsageException("commands.region.usage");
        }
        RegionPacket packet = null;
        if("get".equals(args[0]))
        {
            WorldProtectionHandler.Region region;
            if(args.length == 2)
            {
                region = WorldProtectionHandler.getInstance().getRegionByName(args[1]);
            }
            else
            {
                region = WorldProtectionHandler.getInstance().getRegion(sender.getEntityWorld().provider.dimensionId, sender.getCommandSenderPosition().posX, sender.getCommandSenderPosition().posY, sender.getCommandSenderPosition().posZ);
            }
            String text = String.format("%s: pve: %s, pvp: %s, editable: %s, noEntry: %s, keepInventorySize: %d, Areas: ", region.getName(), region.getPve(), region.getPvp(), region.isEditable(), region.isNoEntry(), region.getKeepInventorySize());
            for(int i = 0; i < region.getAreas().size(); i++)
            {
                int[] area = region.getAreas().get(i);
                text += "\n" + i + ": [d" + area[0] + " x" + area[1] + "," + area[2] + " y" + area[3] + "," + area[4] + " z" + area[5] + "," + area[6] + " t" + area[7] + "]";
            }

            for(String line : text.split("\n"))
            {
                sender.addChatMessage(new ChatComponentText(line));
            }
        }
        else if("create".equals(args[0]) && args.length == 2)
        {
            WorldProtectionHandler.getInstance().addRegion(args[1]);
            sender.addChatMessage(new ChatComponentText("Created region " + args[1]));
            packet = new RegionPacket();
        }
        else if("delete".equals(args[0]) && args.length == 2)
        {
            if ("default".equalsIgnoreCase(args[1]))
            {
                throw new WrongUsageException("Can't delete default region");
            }
            WorldProtectionHandler.getInstance().deleteRegion(args[1]);
            packet = new RegionPacket();
        }
        else if("set".equals(args[0]) && args.length >= 3)
        {
            WorldProtectionHandler.Region region;
            if(args.length == 4)
            {
                region = WorldProtectionHandler.getInstance().getRegionByName(args[3]);
            }
            else
            {
                region = WorldProtectionHandler.getInstance().getRegion(sender.getEntityWorld().provider.dimensionId, sender.getCommandSenderPosition().posX, sender.getCommandSenderPosition().posY, sender.getCommandSenderPosition().posZ);
            }
            if("name".equalsIgnoreCase(args[1]))
            {
                region.setName(args[2]);
            }
            else
            {
                if("editable".equalsIgnoreCase(args[1]))
                {
                    boolean flag = Boolean.parseBoolean(args[2]);
                    region.setEditable(flag);
                }
                else if("pvp".equalsIgnoreCase(args[1]))
                {
                    boolean flag = Boolean.parseBoolean(args[2]);
                    region.setPvp(flag);
                }
                else if("pve".equalsIgnoreCase(args[1]))
                {
                    boolean flag = Boolean.parseBoolean(args[2]);
                    region.setPve(flag);
                }
                else if("noentry".equalsIgnoreCase(args[1]))
                {
                    boolean flag = Boolean.parseBoolean(args[2]);
                    region.setNoEntry(flag);
                }
                else if("keepInventorySize".equalsIgnoreCase(args[1]))
                {
                    int flag = Integer.parseInt(args[2]);
                    region.setKeepInventorySize(flag);
                }
            }
            packet = new RegionPacket();
        }
        else if("list".equalsIgnoreCase(args[0]))
        {
            String text = "Regions:";
            for(WorldProtectionHandler.Region region : WorldProtectionHandler.getInstance().getRegions())
            {
                text += " " + region.getName();
            }
            sender.addChatMessage(new ChatComponentText(text));
        }
        else if(args.length >= 2 && "area".equals(args[0]))
        {
            WorldProtectionHandler.Region region;
            if("list".equals(args[1]))
            {
                if(args.length == 3)
                {
                    region = WorldProtectionHandler.getInstance().getRegionByName(args[2]);
                }
                else
                {
                    region = WorldProtectionHandler.getInstance().getRegion(sender.getEntityWorld().provider.dimensionId, sender.getCommandSenderPosition().posX, sender.getCommandSenderPosition().posY, sender.getCommandSenderPosition().posZ);
                }
                String text = "Areas: ";
                if(region != null)
                {
                    for (int i = 0; i < region.getAreas().size(); i++)
                    {
                        int[] area = region.getAreas().get(i);
                        text += "\n" + i + ": [d" + area[0] + " x" + area[1] + "," + area[2] + " y" + area[3] + "," + area[4] + " z" + area[5] + "," + area[6] + " t" + area[7] + "]";
                    }
                }

                for(String line : text.split("\n"))
                {
                    sender.addChatMessage(new ChatComponentText(line));
                }
            }
            else if("delete".equals(args[1]))
            {
                if(args.length == 4)
                {
                    region = WorldProtectionHandler.getInstance().getRegionByName(args[3]);
                }
                else
                {
                    region = WorldProtectionHandler.getInstance().getRegion(sender.getEntityWorld().provider.dimensionId, sender.getCommandSenderPosition().posX, sender.getCommandSenderPosition().posY, sender.getCommandSenderPosition().posZ);
                }
                int areaNum = 0;
                if(args.length >= 3)
                {
                    areaNum = Integer.parseInt(args[2]);
                }
                else
                {
                    int tier = -1;
                    for(int i = 0; i < region.getAreas().size(); i++)
                    {
                        if(region.getAreas().get(i)[7] > tier)
                        {
                            areaNum = i;
                        }
                    }
                }
                region.getAreas().remove(areaNum);
                packet = new RegionPacket();
            }
            else if("create".equals(args[1]) && args.length >= 10)
            {
                if(args.length == 11)
                {
                    region = WorldProtectionHandler.getInstance().getRegionByName(args[10]);
                }
                else
                {
                    region = WorldProtectionHandler.getInstance().getRegion(sender.getEntityWorld().provider.dimensionId, sender.getCommandSenderPosition().posX, sender.getCommandSenderPosition().posY, sender.getCommandSenderPosition().posZ);
                    if(region == null)
                    {
                        sender.addChatMessage(new ChatComponentText("Please include region at the end when not in a defined area"));
                        throw new WrongUsageException("commands.region.usage");
                    }
                }
                region.addArea(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]), Integer.parseInt(args[9]));
                int[] area = region.getAreas().get(region.getAreas().size() - 1);
                String text = region.getName() + ": " + (region.getAreas().size() - 1) + ": [d" + area[0] + " x" + area[1] + "," + area[2] + " y" + area[3] + "," + area[4] + " z" + area[5] + "," + area[6] + " t" + area[7] + "]";
                sender.addChatMessage(new ChatComponentText(text));
                packet = new RegionPacket();
            }
        }
        if(packet != null)
        {
            Scapecraft.network.sendToAll(packet);
        }
    }
}
