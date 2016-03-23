package scapecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import scapecraft.entity.EntityVampire;
import scapecraft.item.ScapecraftItems;

public class BlockCoffin extends BlockScapecraft
{
	public BlockCoffin()
	{
		super(Material.wood);
		this.setTextureName("scapecraft:coffin");
		this.setUnlocalizedName("coffin");
	}

	@Override
	public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if(!worldIn.isRemote && player.getHeldItem() != null && player.getHeldItem().getItem() == ScapecraftItems.garlic)
		{
			EntityVampire entity = new EntityVampire(worldIn);
			entity.setLocationAndAngles(x, y + 1, z, 0F, 0F);
			worldIn.spawnEntityInWorld(entity);
			player.getHeldItem().stackSize--;
			return true;
		}
		return false;
	}
}
