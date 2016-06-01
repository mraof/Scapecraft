package scapecraft.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import scapecraft.Scapecraft;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mraof on 2016 March 02.
 */
public class CacheListPacket implements IMessage
{
    public HashMap<String, Long> cache;
    public CacheListPacket(){}

    public CacheListPacket(HashMap<String, Long> cache)
    {
        this.cache = cache;
    }
    @Override
    public void fromBytes(ByteBuf buf)
    {
        System.out.println("fromBytes");
        cache = new HashMap<String, Long>();
        int size = buf.readInt();
        for (int i = 0; i < size; i++)
        {
            cache.put(ByteBufUtils.readUTF8String(buf), buf.readLong());
        }
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        System.out.println("toBytes");
        buf.writeInt(cache.size());
        for (Map.Entry<String, Long> entry : cache.entrySet())
        {
            ByteBufUtils.writeUTF8String(buf, entry.getKey());
            buf.writeLong(entry.getValue());
        }
    }

    public static class Handler implements IMessageHandler<CacheListPacket, IMessage>
    {
        //Send only the files they don't have
        @Override
        public IMessage onMessage(CacheListPacket message, MessageContext ctx)
        {
            HashMap<String, byte[]> textures = new HashMap<String, byte[]>();
            HashMap<String, Long> cache = new HashMap<String, Long>();
            for (Map.Entry<String, Long> entry : Scapecraft.proxy.cache.entrySet())
            {
                if(!entry.getValue().equals(message.cache.get(entry.getKey())) && Scapecraft.proxy.textureData.containsKey(entry.getKey()))
                {
                    textures.put(entry.getKey(), Scapecraft.proxy.textureData.get(entry.getKey()));
                    cache.put(entry.getKey(), entry.getValue());
                }
            }
            System.out.println(cache);
            return new TextureDataPacket(textures, cache);
        }
    }
}
