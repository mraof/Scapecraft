package scapecraft.world.gen.dungeon;

import scapecraft.block.ScapecraftBlocks;

import net.minecraft.world.World;

public class StartRoomFeature extends RoomFeature
{
	public StartRoomFeature()
	{
	}
	@Override
	public void generate(World world, DungeonRoom room, int x, int z)
	{
		world.setBlock(x, 1, z, ScapecraftBlocks.dungeonTele);
	}
}
