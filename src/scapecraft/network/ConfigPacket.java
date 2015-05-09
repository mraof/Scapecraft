package scapecraft.network;

import io.netty.buffer.ByteBuf;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import scapecraft.Scapecraft;
import scapecraft.block.ScapecraftBlocks;
import scapecraft.item.ScapecraftItems;
import scapecraft.util.Config;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ConfigPacket implements IMessage
{
	public NBTTagList blockLevels;
	public NBTTagList toolLevels;
	public boolean requireLevels;

	public ConfigPacket()
	{
		blockLevels = Config.blockLevels;
		toolLevels = Config.toolLevels;
		requireLevels = Config.requireLevels;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		requireLevels = buf.readBoolean();
		blockLevels = ByteBufUtils.readTag(buf).getTagList("tag", 10);
		toolLevels = ByteBufUtils.readTag(buf).getTagList("tag", 10);
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		NBTTagCompound blockCompound = new NBTTagCompound();
		blockCompound.setTag("tag", blockLevels);
		NBTTagCompound toolCompound = new NBTTagCompound();
		toolCompound.setTag("tag", toolLevels);
		buf.writeBoolean(requireLevels);
		ByteBufUtils.writeTag(buf, blockCompound);
		ByteBufUtils.writeTag(buf, toolCompound);
	}

	public class Handler implements IMessageHandler<ConfigPacket, IMessage>
	{
		@Override
		public IMessage onMessage(ConfigPacket message, MessageContext ctx)
		{
			Scapecraft.requireLevels = message.requireLevels;
			ScapecraftBlocks.setBlockLevels(message.blockLevels);
			ScapecraftItems.setToolLevels(message.toolLevels);
			return null;
		}
	}
}
