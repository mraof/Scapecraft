package scapecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHangingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import scapecraft.entity.EntityScapecraftItemFrame;
import scapecraft.event.ItemFrameEvent;

/**
 * Created by mraof on 2016 March 02.
 */
public class ItemScapecraftItemFrame extends ItemHangingEntity
{
    public ItemScapecraftItemFrame()
    {
        super(EntityScapecraftItemFrame.class);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        ItemFrameEvent.Place event = new ItemFrameEvent.Place(x, y, z, world, player);
        if(MinecraftForge.EVENT_BUS.post(event) || (side == 0) || (side == 1) || !player.canPlayerEdit(x, y, z, side, stack))
        {
            return false;
        }
        EntityScapecraftItemFrame entity = new EntityScapecraftItemFrame(world, x, y, z, Direction.facingToDirection[side]);
        if(entity.onValidSurface())
        {
            if(!world.isRemote)
            {
                world.spawnEntityInWorld(entity);
            }
            stack.stackSize--;
        }
        return true;
    }
}
