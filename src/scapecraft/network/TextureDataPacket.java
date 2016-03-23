package scapecraft.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.ResourceLocation;
import scapecraft.Scapecraft;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mraof on 2016 March 02.
 */
public class TextureDataPacket implements IMessage
{
    public HashMap<String, byte[]> textures;
    private HashMap<String, Long> cache;

    public TextureDataPacket(){}

    public TextureDataPacket(HashMap<String, byte[]> textures, HashMap<String, Long> cache)
    {
        this.textures = textures;
        this.cache = cache;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        textures = new HashMap<String, byte[]>();
        cache = new HashMap<String, Long>();
        short size = buf.readShort();
        for(short i = 0; i < size; i++)
        {
            String name = ByteBufUtils.readUTF8String(buf);
            cache.put(name, buf.readLong());
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
            buf.writeLong(cache.get(texture.getKey()));
            buf.writeInt(texture.getValue().length);
            buf.writeBytes(texture.getValue());
        }
    }

	public static class Handler implements IMessageHandler<TextureDataPacket, IMessage>
	{
		@SideOnly(Side.CLIENT)
		@Override
		public IMessage onMessage(TextureDataPacket message, MessageContext ctx)
		{
            for(Map.Entry<String, byte[]> entry : message.textures.entrySet())
            {
                Scapecraft.proxy.cacheResource(new ResourceLocation(entry.getKey()), entry.getValue(), message.cache.get(entry.getKey()));
            }
            Scapecraft.proxy.saveCache();
            return null;
		}
	}
}
