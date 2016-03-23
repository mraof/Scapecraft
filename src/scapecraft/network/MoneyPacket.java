package scapecraft.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import scapecraft.client.gui.GuiHealth;

/**
 * Created by mraof on 2016 March 12 at 3:23 AM.
 */
public class MoneyPacket implements IMessage
{
    private double balance;

    public MoneyPacket(){}
    public MoneyPacket(double balance)
    {
        this.balance = balance;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        balance = buf.readDouble();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeDouble(balance);
    }

    public static class Handler implements IMessageHandler<MoneyPacket, IMessage>
    {

        @Override
        public IMessage onMessage(MoneyPacket message, MessageContext ctx)
        {
            GuiHealth.realBalance = (int) message.balance;
            return null;
        }
    }
}
