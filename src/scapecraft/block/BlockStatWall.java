package scapecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import scapecraft.util.Stat;

import java.util.List;

public class BlockStatWall extends BlockScapecraft
{
	public Stat stat;
	public int[] colors = {0x00FF00, 0x11EE00, 0x22DD00, 0x33CC00, 0x44BB00, 0x55AA00, 0x669900, 0x778800, 0x887700, 0x996600, 0xAA5500, 0xBB4400, 0xCC3300, 0xDD2200, 0xEE1100, 0xFF0000};
	private static int renderPass = 0;

	public BlockStatWall(Stat stat)
	{
		super(Material.GLASS);
		this.stat = stat;
		this.setUnlocalizedName(stat.toString().toLowerCase() + "Wall");
		this.setBlockUnbreakable();
		this.setResistance(6000000F);
	}

/*	@SuppressWarnings("rawtypes")
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity)
	{
		if(!(entity instanceof EntityPlayer) || Stats.getLevel((EntityPlayer) entity, stat) < world.getBlockMetadata(x, y, z) * 5 + 10 && !((EntityPlayer)entity).capabilities.isCreativeMode)
		{
			super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
		}
	}*/

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List stacks)
	{
		for(int i = 0; i < 16; i++)
		{
			stacks.add(new ItemStack(item, 1, i));
		}
	}
}
