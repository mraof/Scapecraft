package scapecraft.world.gen.dungeon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
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
		return FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(Scapecraft.dungeonDimensionId);
	}

	@Override
	public void placeInPortal(Entity entity, float rotationYaw)
	{
		if(entity.worldObj.provider.getDimension() != Scapecraft.dungeonDimensionId)
		{
			dungeonPortalX = entity.posX;
			dungeonPortalZ = entity.posZ;
			Dungeon dungeon = new Dungeon((EntityPlayer) entity, 4);
			Dungeon.dungeons.add(dungeon);
			dungeon.begin();
			entity.setPosition(dungeon.startX, 1.5D, dungeon.startZ);
		}
		else
		{
			entity.setPosition(dungeonPortalX, FMLCommonHandler.instance().getMinecraftServerInstance().getEntityWorld().getTopSolidOrLiquidBlock(new BlockPos((int) dungeonPortalX, 0, (int) dungeonPortalZ)).getY(), dungeonPortalZ);
		}
	}
}
