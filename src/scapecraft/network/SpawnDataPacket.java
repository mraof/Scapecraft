package scapecraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by mraof on 2016 March 02.
 */
public class SpawnDataPacket implements IMessage
{
    int entityId;
    IEntityAdditionalSpawnData entity;
    ByteBuf buf;
    public SpawnDataPacket() {}
    public SpawnDataPacket(Entity entity)
    {
        this.entityId = entity.getEntityId();
        this.entity = (IEntityAdditionalSpawnData) entity;
    }
    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.entityId = buf.readInt();
        this.buf = buf;
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.entityId);
        this.entity.writeSpawnData(buf);
    }

    public static class Handler implements IMessageHandler<SpawnDataPacket, IMessage>
    {
        @SideOnly(Side.CLIENT)
        @Override
        public IMessage onMessage(SpawnDataPacket message, MessageContext ctx)
        {
            Entity entity = Minecraft.getMinecraft().theWorld.getEntityByID(message.entityId);
            if(entity instanceof IEntityAdditionalSpawnData)
            {
                ((IEntityAdditionalSpawnData)entity).readSpawnData(message.buf);
            }
            return null;
        }
    }
}
