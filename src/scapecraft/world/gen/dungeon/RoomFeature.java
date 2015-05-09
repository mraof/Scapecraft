package scapecraft.world.gen.dungeon;

import net.minecraft.world.World;

public abstract class RoomFeature
{
	public abstract void generate(World world, DungeonRoom room, int x, int z);
}
