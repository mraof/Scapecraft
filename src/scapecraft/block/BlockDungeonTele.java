package scapecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.world.gen.dungeon.Dungeon;
import scapecraft.world.gen.dungeon.DungeonTeleporter;

public class BlockDungeonTele extends BlockScapecraft
{
	public BlockDungeonTele()
	{
		super(Material.portal);
		this.setTextureName("minecraft:portal");
		this.setUnlocalizedName("dungeonTele");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if(!world.isRemote)
		{
			if(Dungeon.teleporter == null)
			{
				Dungeon.teleporter = new DungeonTeleporter();
			}
			if(!(player.worldObj.provider.dimensionId == Scapecraft.dungeonDimensionId))
			{
				MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, Scapecraft.dungeonDimensionId, Dungeon.teleporter);
			}
			else
			{
				MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, 0, Dungeon.teleporter);
			}
			player.timeUntilPortal = 200;
		}
		return true;
	}
}
