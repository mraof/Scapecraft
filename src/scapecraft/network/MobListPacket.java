package scapecraft.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
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
