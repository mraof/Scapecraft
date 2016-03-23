package scapecraft.item;

import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import scapecraft.Scapecraft;

import java.lang.reflect.Field;

public class ItemTeletab extends Item implements ICommandSender
{
	private String warp;
	Field recentlyHitField;

	public ItemTeletab(String warp)
	{
		super();
		this.warp = warp;
		this.setCreativeTab(Scapecraft.tabScapecraftMisc);
		if(recentlyHitField == null)
		{
			try
			{
				try
				{
					recentlyHitField = EntityLivingBase.class.getDeclaredField("recentlyHit");
				}
				catch (Exception e)
				{
					recentlyHitField = EntityLivingBase.class.getDeclaredField("field_70718_bc");
				}
				recentlyHitField.setAccessible(true);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		try
		{
			if(!world.isRemote && MinecraftServer.getServer() != null && (Integer) recentlyHitField.get(player) > 0)
			{
				MinecraftServer.getServer().getCommandManager().executeCommand(this, "warp " + warp + " " + player.getCommandSenderName());
				itemStack.stackSize--;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return itemStack;
	}

	@Override
	public String getCommandSenderName()
	{
		return "Server";
	}

	@Override
	public IChatComponent getFormattedCommandSenderName()
	{
		return new ChatComponentText(this.getCommandSenderName());
	}

	@Override
	public void addChatMessage(IChatComponent message) {
	}

	@Override
	public boolean canCommandSenderUseCommand(int permissionLevel, String command)
	{
		return true;
	}

	@Override
	public ChunkCoordinates getCommandSenderPosition()
	{
		return new ChunkCoordinates(0, 0, 0);
	}

	@Override
	public World getEntityWorld()
	{
		if(MinecraftServer.getServer() != null)
		{
			return MinecraftServer.getServer().getEntityWorld();
		}
		else
		{
			return Minecraft.getMinecraft().thePlayer.worldObj;
		}
	}
}
