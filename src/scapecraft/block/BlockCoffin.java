package scapecraft.block;

import net.minecraft.block.material.Material;

public class BlockCoffin extends BlockScapecraft
{
	public BlockCoffin()
	{
		super(Material.WOOD);
		this.setUnlocalizedName("coffin");
	}

/*	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if(!worldIn.isRemote && player.getHeldItem(EnumHand.MAIN_HAND) != null && player.getHeldItem(EnumHand.MAIN_HAND).getItem() == ScapecraftItems.garlic)
		{
			EntityVampire entity = new EntityVampire(worldIn);
			entity.setLocationAndAngles(x, y + 1, z, 0F, 0F);
			worldIn.spawnEntityInWorld(entity);
			player.getHeldItem(EnumHand.MAIN_HAND).stackSize--;
			return true;
		}
		return false;
	}*/
}
