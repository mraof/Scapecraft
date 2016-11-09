package scapecraft.world.gen.dungeon;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scapecraft.block.ScapecraftBlocks;

public class StartRoomFeature extends RoomFeature
{
	public StartRoomFeature()
	{
	}
	@Override
	public void generate(World world, DungeonRoom room, int x, int z)
	{
		world.setBlockState(new BlockPos(x, 1, z), ScapecraftBlocks.dungeonTele.getDefaultState());
	}
}
