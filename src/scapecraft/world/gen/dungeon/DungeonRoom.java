package scapecraft.world.gen.dungeon;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import scapecraft.entity.MobSpawner;

public class DungeonRoom implements MobSpawner
{
	Dungeon dungeon;
	Random rand = new Random();
	int dir = 0;
	public int roomSize = 9;
	public int roomX;
	public int roomZ;
	public int exits; //x+ 1 z+ 2 x- 4 z- 8
	public boolean generated = false;
	public ArrayList<RoomFeature> features = new ArrayList<RoomFeature>();
	public ArrayList<Entity> roomMobs = new ArrayList<Entity>();

	public DungeonRoom(Dungeon dungeon, int roomX, int roomZ)
	{
		this.dungeon = dungeon;
		this.roomX = roomX;
		this.roomZ = roomZ;
	}

	public void generate()
	{
		World world = DungeonTeleporter.getDungeonWorld();
		generated = true;
		if(world.isRemote)
		{
			return;
		}
		int x = dungeon.minX + roomX * 21;
		int z = dungeon.minZ + roomZ * 21;
		System.out.println("Generating room at " + roomX + " (" + x + "), " + roomZ + " (" + z + ")");
		int y = 1;
		for(int xPos = x - roomSize; xPos <= x + roomSize; xPos++)
		{
			for(int zPos = z - roomSize; zPos <= z + roomSize; zPos++)
			{
				world.setBlock(xPos, y - 1, zPos, dungeon.dungeonBlock);
				int yPos = y;
				if(Math.abs(zPos - z) == roomSize || Math.abs(xPos - x) == roomSize)
				{
					for(; yPos < y + 10; yPos++)
					{
						world.setBlock(xPos, yPos, zPos, dungeon.dungeonBlock);
					}
				}
				else
				{
					for(; yPos < y + 10; yPos++)
					{
						world.setBlockToAir(xPos, yPos, zPos);
					}
				}
			}
		}
		if((exits & 1) != 0)
		{
			setBlocks(world, x + roomSize + 1, 0, z - 2, x + roomSize + 1, 4, z + 2, dungeon.dungeonBlock);
			setBlocksToAir(world, x + roomSize, 1, z - 1, x + roomSize + 1, 3, z + 1);
		}
		if((exits & 2) != 0)
		{
			setBlocks(world, x - 2, 0, z + roomSize + 1, x + 2, 4, z + roomSize + 1, dungeon.dungeonBlock);
			setBlocksToAir(world, x - 1, 1, z + roomSize, x + 1, 3, z + roomSize + 1);
		}
		if((exits & 4) != 0)
		{
			setBlocks(world, x - roomSize - 1, 0, z - 2, x - roomSize - 1, 4, z + 2, dungeon.dungeonBlock);
			setBlocksToAir(world, x - roomSize - 1, 1, z - 1, x - roomSize, 3, z + 1);
		}
		if((exits & 8) != 0)
		{
			setBlocks(world, x - 2, 0, z - roomSize - 1, x + 2, 4, z - roomSize - 1, dungeon.dungeonBlock);
			setBlocksToAir(world, x - 1, 1, z - roomSize - 1, x + 1, 3, z - roomSize);
		}
		for(RoomFeature feature : features)
		{
			feature.generate(world, this, x, z);
		}
	}

	public static void setBlocks(World world, int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, Block block)
	{
		setBlocks(world, xMin, yMin, zMin, xMax, yMax, zMax, block, 0);
	}

	public static void setBlocks(World world, int xMin, int yMin, int zMin, int xMax, int yMax, int zMax, Block block, int metadata)
	{
		for(int y = yMin; y <= yMax; y++)
		{
			for(int x = xMin; x <= xMax; x++)
			{
				for(int z = zMin; z <= zMax; z++)
				{
					world.setBlock(x, y, z, block, metadata, 3);
				}
			}
		}
	}

	public static void setBlocksToAir(World world, int xMin, int yMin, int zMin, int xMax, int yMax, int zMax)
	{
		for(int y = yMin; y <= yMax; y++)
		{
			for(int x = xMin; x <= xMax; x++)
			{
				for(int z = zMin; z <= zMax; z++)
				{
					world.setBlockToAir(x, y, z);
				}
			}
		}
	}

	@Override
	public void onSpawnedDeath(Entity entity)
	{
		roomMobs.remove(entity);
		System.out.println(entity.getCommandSenderName() + " in room " + roomX + ", " + roomZ + " has been killed");
	}
}
