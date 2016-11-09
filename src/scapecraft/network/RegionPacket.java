package scapecraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import scapecraft.event.WorldProtectionHandler;

/**
 * Created by mraof on 2016 March 02.
 */
public class RegionPacket implements IMessage
{
    NBTTagCompound tagCompound;
    public RegionPacket()
    {
        tagCompound = new NBTTagCompound();
        WorldProtectionHandler.getInstance().writeToNBT(tagCompound);
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

    public static class Handler implements IMessageHandler<RegionPacket, IMessage>
    {

        @Override
        public IMessage onMessage(RegionPacket message, MessageContext ctx)
        {
            WorldProtectionHandler.getInstance().readFromNBT(message.tagCompound);
            return null;
        }
    }
}
