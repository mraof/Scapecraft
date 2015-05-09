package scapecraft.world.gen.dungeon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import scapecraft.Scapecraft;

public class DungeonTeleporter extends Teleporter
{
	public static double dungeonPortalX;
	public static double dungeonPortalZ;
	public DungeonTeleporter()
	{
		super(getDungeonWorld());
	}

	public static WorldServer getDungeonWorld()
	{
		return MinecraftServer.getServer().worldServerForDimension(Scapecraft.dungeonDimensionId);
	}

	@Override
	public void placeInPortal(Entity entity, double x, double y, double z, float f)
	{
		if(entity.worldObj.provider.dimensionId != Scapecraft.dungeonDimensionId)
		{
			dungeonPortalX = x;
			dungeonPortalZ = z;
			Dungeon dungeon = new Dungeon((EntityPlayer) entity, 4);
			Dungeon.dungeons.add(dungeon);
			dungeon.begin();
			entity.setPosition(dungeon.startX, 1.5D, dungeon.startZ);
		}
		else
		{
			entity.setPosition(dungeonPortalX, MinecraftServer.getServer().getEntityWorld().getTopSolidOrLiquidBlock((int) dungeonPortalX, (int) dungeonPortalZ), dungeonPortalZ);
		}
	}
}
