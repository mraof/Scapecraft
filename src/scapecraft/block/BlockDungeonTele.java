package scapecraft.block;

import net.minecraft.block.material.Material;

public class BlockDungeonTele extends BlockScapecraft
{
	public BlockDungeonTele()
	{
		super(Material.PORTAL);
		this.setUnlocalizedName("dungeonTele");
	}

/*	@Override
	public boolean onBlockActivated(World world, BlockPos pos, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if(!world.isRemote)
		{
			if(Dungeon.teleporter == null)
			{
				Dungeon.teleporter = new DungeonTeleporter();
			}
			if(!(player.worldObj.provider.dimensionId == Scapecraft.dungeonDimensionId))
			{
				FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, Scapecraft.dungeonDimensionId, Dungeon.teleporter);
			}
			else
			{
				FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, 0, Dungeon.teleporter);
			}
			player.timeUntilPortal = 200;
		}
		return true;
	}*/
}
