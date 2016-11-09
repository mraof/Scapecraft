package scapecraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
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
import scapecraft.Scapecraft;
import scapecraft.client.gui.GuiHandler;

public class TileEntityGuiPacket implements IMessage
{
	public NBTTagCompound tagCompound;
	public int guiId;
	public TileEntityGuiPacket(){}

	public TileEntityGuiPacket(TileEntity te, GuiHandler.GuiId gui)
	{
		tagCompound = new NBTTagCompound();
		te.writeToNBT(tagCompound);
		guiId = gui.ordinal();
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		tagCompound = ByteBufUtils.readTag(buf);
		guiId = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeTag(buf, tagCompound);
		buf.writeInt(guiId);
	}

	public static class Handler implements IMessageHandler<TileEntityGuiPacket, IMessage>
	{
		@SideOnly(Side.CLIENT)
		@Override
		public IMessage onMessage(TileEntityGuiPacket message, MessageContext ctx)
		{
			int x = message.tagCompound.getInteger("x");
			int y = message.tagCompound.getInteger("y");
			int z = message.tagCompound.getInteger("z");
			Minecraft.getMinecraft().thePlayer.worldObj.getTileEntity(new BlockPos(x, y, z)).readFromNBT(message.tagCompound);
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			player.openGui(Scapecraft.instance, message.guiId, player.worldObj, x, y, z);
			return null;
		}
	}
}
