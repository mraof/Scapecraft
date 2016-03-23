package scapecraft.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import scapecraft.entity.EntityScapecraftItemFrame;

/**
 * Created by mraof on 2016 March 02.
 */
public class ItemFrameEvent extends Event
{
    public final int x;
    public final int y;
    public final int z;
    public final World world;

    public ItemFrameEvent(int x, int y, int z, World world)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.world = world;
    }

    @Cancelable
    public static class Place extends ItemFrameEvent
    {
        public final EntityPlayer entityPlayer;
        public Place(int x, int y, int z, World world, EntityPlayer entityPlayer)
        {
            super(x, y, z, world);
            this.entityPlayer = entityPlayer;
        }
    }

    @Cancelable
    public static class Attack extends ItemFrameEvent
    {
        public final EntityScapecraftItemFrame entityScapecraftItemFrame;
        public final DamageSource source;

        public Attack(int x, int y, int z, World world, EntityScapecraftItemFrame entityScapecraftItemFrame, DamageSource source)
        {
            super(x, y, z, world);
            this.entityScapecraftItemFrame = entityScapecraftItemFrame;
            this.source = source;
        }
    }

    @Cancelable
    public static class Interact extends ItemFrameEvent
    {
        public final EntityScapecraftItemFrame entityScapecraftItemFrame;
        public final EntityPlayer entityPlayer;

        public Interact(int x, int y, int z, World world, EntityScapecraftItemFrame entityScapecraftItemFrame, EntityPlayer player)
        {
            super(x, y, z, world);
            this.entityScapecraftItemFrame = entityScapecraftItemFrame;
            this.entityPlayer = player;
        }
    }
}
