package scapecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import scapecraft.Scapecraft;
import scapecraft.client.gui.GuiHandler;
import scapecraft.entity.Drop;
import scapecraft.entity.ScapecraftEntities;
import scapecraft.inventory.ContainerMobDrops;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;
import scapecraft.util.Config;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mraof on 2016 March 05 at 7:00 PM.
 */
public class DropsCommand extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "drops";
    }

    @Override
    public String getCommandUsage(ICommandSender sender)
    {
        return "/drops [mob]";
    }

    @Override
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        EntityPlayerMP player = getCommandSenderAsPlayer(sender);
        Class<? extends Entity> mobClass = args.length > 0 ? ScapecraftEntities.entityNames.get(args[0].toLowerCase()) : null;
        TileEntityScapecraftMobSpawner te = null;
        int start = 0;
        if(mobClass == null)
        {
            te = (TileEntityScapecraftMobSpawner) sender.getEntityWorld().getTileEntity(sender.getPosition().add(0, -1, 0));
        }
        else
        {
            start = 1;
        }
        if(mobClass == null && te == null)
        {
            throw new WrongUsageException("Invalid mob name and not standing on a spawner");
        }
        if(args.length >= 2 && "money".equalsIgnoreCase(args[start]))
        {
            start++;
            if (args.length == start)
            {
                if (te != null)
                {
                    sender.addChatMessage(new TextComponentString(Arrays.toString(te.getMoneyDrops(null))));
                }
                else
                {
                    sender.addChatMessage(new TextComponentString(Arrays.toString(ScapecraftEntities.getMoneyDrops(mobClass))));
                }
                return;
            }
            int[] money;
            if ("reset".equalsIgnoreCase(args[start]))
            {
                money = Config.moneyDrops.containsKey(mobClass) ? Config.moneyDrops.get(mobClass) : null;
            }
            else
            {
                money = new int[args.length - start];
                for (int i = 0; i < money.length; i++)
                {
                    money[i] = Integer.parseInt(args[i + start]);
                }
            }
            if(mobClass == null)
            {
                te.moneyDrops = money;
            }
            else
            {
                ScapecraftEntities.setMoney(mobClass, money);
            }
            return;
        }
        player.openGui(Scapecraft.instance, GuiHandler.GuiId.DROPS.ordinal(), sender.getEntityWorld(), sender.getPosition().getX(), sender.getPosition().getY(), sender.getPosition().getZ());
        ContainerMobDrops containerMobDrops = (ContainerMobDrops) player.openContainer;
        ArrayList<Drop> drops;
        if (args.length > start && "reset".equalsIgnoreCase(args[start]))
        {
            if(mobClass == null)
            {
                te.drops = null;
                te.markDirty();
            }
            else
            {
                ScapecraftEntities.setDrops(mobClass, Config.drops.get(mobClass));
            }
        }
        if (mobClass == null)
        {
            containerMobDrops.target = te;
            drops = te.getDrops(null);
        }
        else
        {
            drops = ScapecraftEntities.getDrops(mobClass);
            containerMobDrops.target = mobClass;
        }
        for (int i = 0, dropsSize = drops.size(); i < dropsSize; i++)
        {
            Drop drop = drops.get(i);
            System.out.println(drops.get(i));
            containerMobDrops.inventoryDrops.setInventorySlotContents(i, drop.stack == null ? null : drop.stack.copy());
            containerMobDrops.inventoryDrops.chances.set(i, drop.chance);
        }
        System.out.println(containerMobDrops);
    }
}
