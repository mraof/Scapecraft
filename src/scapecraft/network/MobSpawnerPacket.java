package scapecraft.network;

import io.netty.buffer.ByteBuf;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MobSpawnerPacket implements IMessage, IMessageHandler<MobSpawnerPacket, IMessage>
{
	public NBTTagCompound tagCompound;
	public int dimensionId;
	public String username;
	public MobSpawnerPacket(){}

	@SideOnly(Side.CLIENT)
	public MobSpawnerPacket(TileEntity te)
	{
		tagCompound = new NBTTagCompound();
		te.writeToNBT(tagCompound);
		dimensionId = te.getWorld().provider.dimensionId;
		username = Minecraft.getMinecraft().thePlayer.getCommandSenderName();
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		tagCompound = ByteBufUtils.readTag(buf);
		dimensionId = buf.readInt();
		username = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		ByteBufUtils.writeTag(buf, tagCompound);
		buf.writeInt(dimensionId);
		ByteBufUtils.writeUTF8String(buf, username);
	}

	@Override
	public IMessage onMessage(MobSpawnerPacket message, MessageContext ctx)
	{
		EntityPlayer player = MinecraftServer.getServer().getConfigurationManager().getPlayerByUsername(message.username);

		if(player != null && player.capabilities.isCreativeMode)
			MinecraftServer.getServer().worldServers[message.dimensionId].getTileEntity(message.tagCompound.getInteger("x"), message.tagCompound.getInteger("y"), message.tagCompound.getInteger("z")).readFromNBT(message. tagCompound);

		return null;
	}
}
