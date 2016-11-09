package scapecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHangingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
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
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemFrameEvent.Place event = new ItemFrameEvent.Place(pos, world, player);
        if(MinecraftForge.EVENT_BUS.post(event) || (facing == EnumFacing.UP) || (facing == EnumFacing.DOWN) || !player.canPlayerEdit(pos, facing, stack))
        {
            return EnumActionResult.FAIL;
        }
        EntityScapecraftItemFrame entity = new EntityScapecraftItemFrame(world, pos, facing);
        if(entity.onValidSurface())
        {
            if(!world.isRemote)
            {
                world.spawnEntityInWorld(entity);
            }
            stack.stackSize--;
        }
        return EnumActionResult.SUCCESS;
    }
}
