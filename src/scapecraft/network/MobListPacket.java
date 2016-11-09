package scapecraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scapecraft.Scapecraft;
import scapecraft.entity.ScapecraftEntities;

import java.io.File;

/**
 * Created by mraof on 2016 March 02.
 */
public class MobListPacket implements IMessage
{
    public NBTTagList dynamicMobs;

    public MobListPacket(){}

    public MobListPacket(NBTTagList dynamicMobs)
    {
        this.dynamicMobs = dynamicMobs;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        dynamicMobs = ByteBufUtils.readTag(buf).getTagList("tag", 10);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        NBTTagCompound mobCompound = new NBTTagCompound();
        mobCompound.setTag("tag", dynamicMobs);
        ByteBufUtils.writeTag(buf, mobCompound);
    }

    public static class Handler implements IMessageHandler<MobListPacket, IMessage>
    {
        @SideOnly(Side.CLIENT)
        @Override
        public IMessage onMessage(MobListPacket message, MessageContext ctx)
        {
            for(int i = 0; i < message.dynamicMobs.tagCount(); i++)
            {
                ScapecraftEntities.registerDynamicMob(message.dynamicMobs.getCompoundTagAt(i));
            }
            Scapecraft.proxy.setCacheDir(new File(new File(Scapecraft.configDir, "scCache"), Minecraft.getMinecraft().getCurrentServerData() == null ? "" : Minecraft.getMinecraft().getCurrentServerData().serverName));
            return null;
        }
    }
}
