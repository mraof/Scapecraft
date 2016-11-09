package scapecraft.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;
import scapecraft.entity.EntityScapecraftItemFrame;

/**
 * Created by mraof on 2016 March 02.
 */
public class ItemFrameEvent extends Event
{
    private final BlockPos pos;
    private final World world;

    public ItemFrameEvent(BlockPos pos, World world)
    {
        this.pos = pos;
        this.world = world;
    }

    public BlockPos getPos() {
        return pos;
    }

    public World getWorld() {
        return world;
    }

    @Cancelable
    public static class Place extends ItemFrameEvent
    {
        private final EntityPlayer entityPlayer;
        public Place(BlockPos pos, World world, EntityPlayer entityPlayer)
        {
            super(pos, world);
            this.entityPlayer = entityPlayer;
        }



        public EntityPlayer getEntityPlayer() {
            return entityPlayer;
        }
    }

    @Cancelable
    public static class Attack extends ItemFrameEvent
    {
        private final EntityScapecraftItemFrame entityScapecraftItemFrame;
        private final DamageSource source;

        public Attack(BlockPos pos, World world, EntityScapecraftItemFrame entityScapecraftItemFrame, DamageSource source)
        {
            super(pos, world);
            this.entityScapecraftItemFrame = entityScapecraftItemFrame;
            this.source = source;
        }

        public DamageSource getSource() {
            return source;
        }

        public EntityScapecraftItemFrame getEntityScapecraftItemFrame() {
            return entityScapecraftItemFrame;
        }
    }

    @Cancelable
    public static class Interact extends ItemFrameEvent
    {
        private final EntityScapecraftItemFrame entityScapecraftItemFrame;
        private final EntityPlayer entityPlayer;

        public Interact(BlockPos pos, World world, EntityScapecraftItemFrame entityScapecraftItemFrame, EntityPlayer player)
        {
            super(pos, world);
            this.entityScapecraftItemFrame = entityScapecraftItemFrame;
            this.entityPlayer = player;
        }

        public EntityPlayer getEntityPlayer() {
            return entityPlayer;
        }

        public EntityScapecraftItemFrame getEntityScapecraftItemFrame() {
            return entityScapecraftItemFrame;
        }
    }
}
