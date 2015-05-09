package scapecraft.world.gen.dungeon;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class KeyDoorRoomFeature extends RoomFeature
{
	int color;
	int direction;
	public KeyDoorRoomFeature(int color, int direction)
	{
		this.color = color;
		this.direction = direction;
	}
	@Override
	public void generate(World world, DungeonRoom room, int x, int z)
	{
		System.out.println("Direction is " + direction);
		if(direction == 1)
		{
			DungeonRoom.setBlocks(world, x + room.roomSize, 1, z - 1, x + room.roomSize, 10, z + 1, Blocks.wool, color);
		}
		if(direction == 2)
		{
			DungeonRoom.setBlocks(world, x - 1, 1, z + room.roomSize, x + 1, 10, z + room.roomSize, Blocks.wool, color);
		}
		if(direction == 4)
		{
			DungeonRoom.setBlocks(world, x - room.roomSize, 1, z - 1, x - room.roomSize, 10, z + 1, Blocks.wool, color);
		}
		if(direction == 8)
		{
			DungeonRoom.setBlocks(world, x - 1, 1, z - room.roomSize, x + 1, 10, z - room.roomSize, Blocks.wool, color);
		}
	}
}
