package scapecraft.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;

import java.util.LinkedHashSet;
import java.util.Set;

public class MobSpawnerKillPacket implements IMessage
{
	public int x;
	public int y;
	public int z;
	public int dimensionId;
	public MobSpawnerKillPacket(){}

	@SideOnly(Side.CLIENT)
	public MobSpawnerKillPacket(TileEntity te)
	{
		x = te.xCoord;
		y = te.yCoord;
		z = te.zCoord;
		dimensionId = te.getWorld().provider.dimensionId;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		dimensionId = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeInt(dimensionId);
	}

	public static class Handler implements IMessageHandler<MobSpawnerKillPacket, IMessage>
	{
		@Override
		public IMessage onMessage(MobSpawnerKillPacket message, MessageContext ctx)
		{
			EntityPlayer player = ctx.getServerHandler().playerEntity;

			if (player != null && player.capabilities.isCreativeMode)
			{
				TileEntity te = MinecraftServer.getServer().worldServers[message.dimensionId].getTileEntity(message.x, message.y, message.z);
				if (te instanceof TileEntityScapecraftMobSpawner)
				{
					Set<Integer> spawnedIds = new LinkedHashSet<Integer>(((TileEntityScapecraftMobSpawner) te).spawnedIds);
					for (int entityId : spawnedIds)
					{
						te.getWorld().getEntityByID(entityId).setDead();
					}
				}
			}

			return null;
		}
	}
}
