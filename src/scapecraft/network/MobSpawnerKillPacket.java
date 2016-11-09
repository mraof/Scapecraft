package scapecraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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
		x = te.getPos().getX();
		y = te.getPos().getY();
		z = te.getPos().getZ();
		dimensionId = te.getWorld().provider.getDimension();
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
				TileEntity te = FMLCommonHandler.instance().getMinecraftServerInstance().worldServers[message.dimensionId].getTileEntity(new BlockPos(message.x, message.y, message.z));
				if (te instanceof TileEntityScapecraftMobSpawner)
				{
					Set<Integer> spawnedIds = new LinkedHashSet<Integer>(((TileEntityScapecraftMobSpawner) te).spawnedIds);
					for (Integer entityId : spawnedIds)
					{
						Entity entity = te.getWorld().getEntityByID(entityId);
						if(entity != null)
						{
							entity.setDead();
						}
						else
						{
							((TileEntityScapecraftMobSpawner) te).spawnedIds.remove(entityId);
						}
					}
				}
			}

			return null;
		}
	}
}
