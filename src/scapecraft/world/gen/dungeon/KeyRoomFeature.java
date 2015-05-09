package scapecraft.world.gen.dungeon;

import net.minecraft.world.World;

import scapecraft.entity.EntityKey;

public class KeyRoomFeature extends RoomFeature
{
	int number;
	public KeyRoomFeature(int number)
	{
		this.number = number;
	}
	@Override
	public void generate(World world, DungeonRoom room, int x, int z)
	{
		//EntitySheep sheep = new EntitySheep(world);
		//sheep.setPosition(x, 2, z);
		//sheep.setFleeceColor(number);
		//world.spawnEntityInWorld(sheep);
		EntityKey key = new EntityKey(world);
		key.setPosition(x, 1, z);
		key.number = number;
		world.spawnEntityInWorld(key);
	}
}
