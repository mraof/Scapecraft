package scapecraft.inventory;

import net.minecraft.block.BlockAnvil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.world.World;

public class ContainerUnbreakingRepair extends ContainerRepair
{
	World theWorld;
	
	private int x;
	private int y;
	private int z;

	public ContainerUnbreakingRepair(InventoryPlayer inventory, final World world, final int x, final int y, final int z, EntityPlayer player)
	{
		super(inventory, world, x, y, z, player);
		this.theWorld = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.theWorld.getBlock(this.x, this.y, this.z) instanceof BlockAnvil && player.getDistanceSq((double) this.x + 0.5D, (double) this.y + 0.5D, (double) this.z + 0.5D) <= 64.0D;
	}
}
