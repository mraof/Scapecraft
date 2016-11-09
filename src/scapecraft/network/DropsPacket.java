package scapecraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import scapecraft.entity.Drop;
import scapecraft.inventory.ContainerMobDrops;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mraof on 2016 March 06 at 4:31 AM.
 */
public class DropsPacket implements IMessage
{
    public ArrayList<Drop> drops = new ArrayList<Drop>();
    public DropsPacket(){}

    public DropsPacket(List<Drop> drops)
    {
        this.drops = new ArrayList<Drop>(drops);
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        int size = buf.readInt();
        drops.ensureCapacity(size);
        for (int i = 0; i < size; i++)
        {
            drops.add(Drop.fromNBT(ByteBufUtils.readTag(buf)));
        }
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(drops.size());
        for(Drop drop : drops)
        {
            ByteBufUtils.writeTag(buf, drop.toNBT());
        }
    }

    public static class Handler implements IMessageHandler<DropsPacket, IMessage>
    {

        @Override
        public IMessage onMessage(DropsPacket message, MessageContext ctx)
        {
            System.out.println(ctx.getServerHandler().playerEntity.openContainer);
            System.out.println(ctx.getServerHandler().playerEntity);
            if(ctx.getServerHandler().playerEntity.openContainer instanceof ContainerMobDrops)
            {
                ((ContainerMobDrops) ctx.getServerHandler().playerEntity.openContainer).applyDrops(message.drops);
            }
            return null;
        }
    }
}
