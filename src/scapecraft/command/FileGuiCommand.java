package scapecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import org.lwjgl.opengl.Display;
import scapecraft.client.gui.swing.FileUploadWindow;

import javax.swing.*;

/**
 * Created by mraof on 2016 March 02.
 */
public class FileGuiCommand extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "filegui";
    }

    @Override
    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender sender)
    {
        return "/filegui";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int x = Display.getX() + Display.getWidth() / 2 - 160;
                int y = Display.getY() + Display.getHeight() / 2 - 160;
                FileUploadWindow uploadWindow = new FileUploadWindow();
                uploadWindow.setBounds(x, y, 320, 320);
                uploadWindow.pack();
                uploadWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                uploadWindow.setVisible(true);
            }
        });
    }
}
