package scapecraft.entity;

import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import scapecraft.event.ItemFrameEvent;

import javax.annotation.Nullable;

/**
 * Created by mraof on 2016 March 02.
 */
public class EntityScapecraftItemFrame extends EntityItemFrame
{
    public EntityScapecraftItemFrame(World world)
    {
        super(world);
    }

    public EntityScapecraftItemFrame(World world, BlockPos pos, EnumFacing facing)
    {
        super(world, pos, facing);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        ItemFrameEvent.Attack event = new ItemFrameEvent.Attack(this.hangingPosition, this.worldObj, this, source);
        return !MinecraftForge.EVENT_BUS.post(event) && super.attackEntityFrom(source, amount);
    }

    @Override
    public boolean processInitialInteract(EntityPlayer player, @Nullable ItemStack stack, EnumHand hand)
    {
        ItemFrameEvent.Interact event = new ItemFrameEvent.Interact(this.hangingPosition, this.worldObj, this, player);
        return !MinecraftForge.EVENT_BUS.post(event) && super.processInitialInteract(player, stack, hand);

    }
}
