package scapecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import scapecraft.entity.EntityDrop;

public class TestingCommand extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "testing";
	}

	@Override
	public String getCommandUsage(ICommandSender sender)
	{
		return "commands.testing.usage";
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
		EntityDrop drop = new EntityDrop(player.worldObj);
		System.out.println(player.worldObj.loadedTileEntityList.size());
		for (Object obj : player.worldObj.loadedTileEntityList)
		{
			if (obj instanceof IInventory)
			{
				System.out.println(((TileEntity) obj).getPos() + " " + obj.getClass());
				IInventory inventory = (IInventory) obj;
				for (int i = 0; i < inventory.getSizeInventory(); i++)
				{
					if (inventory.getStackInSlot(i) != null)
					{
						EntityItem entityItem = new EntityItem(player.worldObj);
						entityItem.setEntityItemStack(inventory.getStackInSlot(i).copy());
						drop.addItem(entityItem);
						inventory.setInventorySlotContents(i, null);
						inventory.getStackInSlot(i);
					}
				}
			}
		}
		drop.setPosition(player.posX, player.posY, player.posZ);
		player.worldObj.spawnEntityInWorld(drop);
	}
}

