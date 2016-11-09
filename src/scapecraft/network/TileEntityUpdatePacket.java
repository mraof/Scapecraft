package scapecraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityUpdatePacket implements IMessage
{
	public NBTTagCompound tagCompound;
	public TileEntityUpdatePacket(){}

	@SideOnly(Side.CLIENT)
	public TileEntityUpdatePacket(TileEntity te)
	{
		tagCompound = new NBTTagCompound();
		te.writeToNBT(tagCompound);
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		tagCompound = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeTag(buf, tagCompound);
	}

	public static class Handler implements IMessageHandler<TileEntityUpdatePacket, IMessage>
	{
		@Override
		public IMessage onMessage(TileEntityUpdatePacket message, MessageContext ctx)
		{
			EntityPlayer player = ctx.getServerHandler().playerEntity;

			if (player != null && player.capabilities.isCreativeMode)
			{
				player.worldObj.getTileEntity(new BlockPos(message.tagCompound.getInteger("x"), message.tagCompound.getInteger("y"), message.tagCompound.getInteger("z"))).readFromNBT(message.tagCompound);
				player.worldObj.getTileEntity(new BlockPos(message.tagCompound.getInteger("x"), message.tagCompound.getInteger("y"), message.tagCompound.getInteger("z"))).markDirty();
			}

			return null;
		}
	}
}
