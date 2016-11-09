package scapecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;

/**
 * Created by mraof on 2016 March 24 at 6:53 PM.
 */
public class SpawnerCommand extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "spawners";
    }

    @Override
    public String getCommandUsage(ICommandSender sender)
    {
        return "commands.spawners.usage";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if(args.length == 0)
        {
            for (Object obj : sender.getEntityWorld().loadedTileEntityList)
            {
                if (obj instanceof TileEntityScapecraftMobSpawner)
                {
                    sender.addChatMessage(new TextComponentString(String.format("%s, r: %d, max %d, %s", ((TileEntityScapecraftMobSpawner) obj).getPos(), ((TileEntityScapecraftMobSpawner) obj).radius, ((TileEntityScapecraftMobSpawner) obj).maxSpawn, ((TileEntityScapecraftMobSpawner) obj).entityName)));
                }
            }
        }
    }
}
