package scapecraft.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import scapecraft.event.LevelUpEvent;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

public class StatsPacket implements IMessage
{
	long xpValues[] = new long[Stat.values().length];
	public StatsPacket(){}

	public StatsPacket(EntityPlayer player)
	{
		for(int i = 0; i < Stat.values().length; i++)
		{
			xpValues[i] = Stats.getXp(player, Stat.values()[i]);
		}
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		for(int i = 0; i < Stat.values().length; i++)
		{
			xpValues[i] = buf.readLong();
		}
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		for(int i = 0; i < Stat.values().length; i++)
		{
			buf.writeLong(xpValues[i]);
		}
	}

	public static class Handler implements IMessageHandler<StatsPacket, IMessage>
	{
		@SideOnly(Side.CLIENT)
		@Override
		public IMessage onMessage(StatsPacket message, MessageContext ctx)
		{
			for (int i = 0; i < Stat.values().length; i++)
			{
				int level = 0;
				if(Stats.clientStats.containsKey(Stat.values()[i]))
				{
					level = Stats.getLevel(Minecraft.getMinecraft().thePlayer, Stat.values()[i]);
				}
				Stats.setXp(Minecraft.getMinecraft().thePlayer, Stat.values()[i], message.xpValues[i]);
				if(level > 0 && level < Stats.getLevel(Minecraft.getMinecraft().thePlayer, Stat.values()[i]))
				{
					MinecraftForge.EVENT_BUS.post(new LevelUpEvent(Minecraft.getMinecraft().thePlayer, Stat.values()[i], Stats.getLevel(Minecraft.getMinecraft().thePlayer, Stat.values()[i])));
				}
			}
			return null;
		}
	}
}
