package scapecraft.entity;

import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import scapecraft.event.ItemFrameEvent;

/**
 * Created by mraof on 2016 March 02.
 */
public class EntityScapecraftItemFrame extends EntityItemFrame
{

    public EntityScapecraftItemFrame(World world)
    {
        super(world);
    }

    public EntityScapecraftItemFrame(World world, int p_i1591_2_, int p_i1591_3_, int p_i1591_4_, int p_i1591_5_)
    {
        super(world, p_i1591_2_, p_i1591_3_, p_i1591_4_, p_i1591_5_);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        ItemFrameEvent.Attack event = new ItemFrameEvent.Attack((int) this.posX, (int) this.posY, (int) this.posZ, this.worldObj, this, source);
        return !MinecraftForge.EVENT_BUS.post(event) && super.attackEntityFrom(source, amount);
    }

    @Override
    public boolean interactFirst(EntityPlayer player)
    {
        ItemFrameEvent.Interact event = new ItemFrameEvent.Interact((int) this.posX, (int) this.posY, (int) this.posZ, this.worldObj, this, player);
        return !MinecraftForge.EVENT_BUS.post(event) && super.interactFirst(player);

    }
}
