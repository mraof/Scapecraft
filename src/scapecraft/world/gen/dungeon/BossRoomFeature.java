package scapecraft.world.gen.dungeon;

import net.minecraft.world.World;

import scapecraft.entity.EntityShapeshifter;

public class BossRoomFeature extends RoomFeature
{
	public BossRoomFeature()
	{
	}
	@Override
	public void generate(World world, DungeonRoom room, int x, int z)
	{
		EntityShapeshifter boss = new EntityShapeshifter(world);
		boss.setPosition(x, 2, z);
		room.roomMobs.add(boss);
		boss.mobSpawner = room;
		boss.setLevel(50);
		boss.setHealth(boss.getMaxHealth());
		world.spawnEntityInWorld(boss);
	}
}
