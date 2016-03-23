package scapecraft.entity;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import scapecraft.Scapecraft;
import scapecraft.network.SpawnDataPacket;

import java.util.ArrayList;

/**
 * Created by mraof on 2016 March 02.
 */
public class EntityDrop extends Entity implements IEntityAdditionalSpawnData
{
    public ArrayList<EntityItem> items = new ArrayList<EntityItem>();
    public String owner = "";

    public EntityDrop(World p_i1711_1_)
    {
        super(p_i1711_1_);
        this.setSize(0.25F, 0.25F);
    }

    @Override
    protected void entityInit()
    {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompound)
    {
        owner = tagCompound.getString("owner");
        NBTTagList itemList = tagCompound.getTagList("items", 10);
        for(int i = 0; i < itemList.tagCount(); i++)
        {
            EntityItem entityItem = new EntityItem(this.worldObj);
            entityItem.readEntityFromNBT(itemList.getCompoundTagAt(i));
        }

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        tagCompound.setString("owner", owner);
        NBTTagList itemList = new NBTTagList();
        for(EntityItem entityItem : items)
        {
            NBTTagCompound itemCompound = new NBTTagCompound();
            entityItem.writeEntityToNBT(itemCompound);
            itemList.appendTag(itemCompound);
        }
    }

    public void addItem(EntityItem entityItem)
    {
        items.add(entityItem);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if(!items.isEmpty())
        {
            items.get(0).setPosition(this.posX, this.posY, this.posZ);
            items.get(0).onUpdate();
            this.setPosition(items.get(0).posX, items.get(0).posY, items.get(0).posZ);
            for (int i = 1; i < items.size(); i++)
            {
                items.get(i).onUpdate();
                items.get(i).setPosition(this.posX, this.posY, this.posZ);
                if(items.get(i).isDead)
                {
                    items.remove(i);
                    i--;
                }
            }
            if(items.get(0).isDead)
            {
                items.remove(0);
            }
        }
        if(items.isEmpty())
        {
            this.setDead();
        }
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityIn)
    {
        if(!this.worldObj.isRemote)
        {
            boolean update = false;
            for (EntityItem entityItem : items)
            {
                entityItem.onCollideWithPlayer(entityIn);
                update = update || entityItem.isDead;
            }
            if (update)
            {
                IMessage packet = new SpawnDataPacket(this);
                for(EntityPlayer player : ((WorldServer)this.worldObj).getEntityTracker().getTrackingPlayers(this))
                {
                    if(player instanceof  EntityPlayerMP)
                    {
                        Scapecraft.network.sendTo(packet, (EntityPlayerMP) player);
                    }
                }
            }
        }
    }

    /**
     * Called by the server when constructing the spawn packet.
     * Data should be added to the provided stream.
     *
     * @param buffer The packet data stream
     */
    @Override
    public void writeSpawnData(ByteBuf buffer)
    {
        NBTTagList itemTagList = new NBTTagList();
        NBTTagCompound tagCompound = new NBTTagCompound();
        for(EntityItem entityItem : items)
        {
            NBTTagCompound itemCompound = new NBTTagCompound();
            entityItem.writeEntityToNBT(itemCompound);
            itemTagList.appendTag(itemCompound);
        }
        tagCompound.setTag("items", itemTagList);
        tagCompound.setString("owner", owner);
        ByteBufUtils.writeTag(buffer, tagCompound);
    }

    @Override
    public void readSpawnData(ByteBuf additionalData)
    {
        items.clear();
        NBTTagCompound tagCompound = ByteBufUtils.readTag(additionalData);
        NBTTagList itemTagList = tagCompound.getTagList("items", 10);
        for(int i = 0; i < itemTagList.tagCount(); i++)
        {
            EntityItem entityItem = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ);
            entityItem.readEntityFromNBT(itemTagList.getCompoundTagAt(i));
            this.items.add(entityItem);
        }
        owner = tagCompound.getString("owner");
    }
}
