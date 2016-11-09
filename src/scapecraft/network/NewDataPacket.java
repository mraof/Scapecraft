package scapecraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import scapecraft.Scapecraft;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mraof on 2016 March 02.
 */
public class NewDataPacket implements IMessage
{
    public HashMap<String, byte[]> textures;

    public NewDataPacket(){}

    public NewDataPacket(HashMap<String, byte[]> textures)
    {
        this.textures = textures;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        textures = new HashMap<String, byte[]>();
        short size = buf.readShort();
        for(short i = 0; i < size; i++)
        {
            String name = ByteBufUtils.readUTF8String(buf);
            byte[] textureData = new byte[buf.readInt()];
            buf.readBytes(textureData);
            textures.put(name, textureData);
        }
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeShort(textures.size());
        for(Map.Entry<String, byte[]> texture : textures.entrySet())
        {
            ByteBufUtils.writeUTF8String(buf, texture.getKey());
            buf.writeInt(texture.getValue().length);
            buf.writeBytes(texture.getValue());
        }
    }

	public static class Handler implements IMessageHandler<NewDataPacket, IMessage>
	{
		@Override
		public IMessage onMessage(NewDataPacket message, MessageContext ctx)
		{
            if(!ctx.getServerHandler().playerEntity.canCommandSenderUseCommand(2, "filegui"))
            {
                return null;
            }
            long cacheId = System.currentTimeMillis();
            HashMap<String, Long> cacheIds = new HashMap<String, Long>();
            for(Map.Entry<String, byte[]> entry : message.textures.entrySet())
            {
                Scapecraft.proxy.cacheResource(new ResourceLocation(entry.getKey()), entry.getValue(), cacheId);
                cacheIds.put(entry.getKey(), cacheId);
            }
            Scapecraft.proxy.saveCache();
            TextureDataPacket packet = new TextureDataPacket(message.textures, cacheIds);
            Scapecraft.network.sendToAll(packet);
            return null;
		}
	}
}
