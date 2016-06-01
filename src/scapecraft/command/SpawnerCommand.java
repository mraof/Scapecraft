package scapecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.gen.ChunkProviderServer;
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
    public void processCommand(ICommandSender sender, String[] args)
    {
        if(args.length == 0)
        {
            for (Object obj : sender.getEntityWorld().loadedTileEntityList)
            {
                if (obj instanceof TileEntityScapecraftMobSpawner)
                {
                    sender.addChatMessage(new ChatComponentText(String.format("%d, %d, %d, r: %d, max %d, %s", ((TileEntityScapecraftMobSpawner) obj).xCoord, ((TileEntityScapecraftMobSpawner) obj).yCoord, ((TileEntityScapecraftMobSpawner) obj).zCoord, ((TileEntityScapecraftMobSpawner) obj).radius, ((TileEntityScapecraftMobSpawner) obj).maxSpawn, ((TileEntityScapecraftMobSpawner) obj).entityName)));
                }
            }
        }
    }
}
