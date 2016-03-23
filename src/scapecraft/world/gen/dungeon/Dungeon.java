package scapecraft.world.gen.dungeon;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;

import java.util.ArrayList;
import java.util.Random;

public class Dungeon
{
	public static ArrayList<Dungeon> dungeons = new ArrayList<Dungeon>();
	public static DungeonTeleporter teleporter;
	public int minX;
	public int minZ;
	public int maxX;
	public int maxZ;
	public int size;
	public int startX;
	public int startZ;
	public DungeonRoom[][] rooms;
	Random rand = new Random();
	public Block dungeonBlock = Blocks.stonebrick;
	public Dungeon(EntityPlayer player, int size)
	{
		minX = 0;
		minZ = 0;
		maxX = size * 21;
		maxZ = size * 21;
		for(int i = 0; i < dungeons.size(); i++)
		{
			Dungeon dungeon = dungeons.get(i);
			if((minX < dungeon.maxX || maxX > dungeon.minX) && (minZ < dungeon.maxZ || maxZ > dungeon.maxZ))
			{
				if(rand.nextBoolean())
				{
					minX += dungeon.maxX - dungeon.minX + 16;
					maxX += dungeon.maxX - dungeon.minX + 16;
				}
				else
				{
					minZ += dungeon.maxZ - dungeon.minZ + 16;
					maxZ += dungeon.maxZ - dungeon.minZ + 16;
				}
				i = 0;
			}
		}
		this.size = size;
		rooms = new DungeonRoom[size][size];
		System.out.printf("Dungeon created %d, %d, %d, %d\n", minX, minZ, maxX, maxZ);
	}

	public void begin()
	{
		int x = rand.nextInt(size);
		int z = rand.nextInt(size);
		int startRoomX = x;
		int startRoomZ = z;
		startX = minX + x * 21; 
		startZ = minZ + z * 21; 
		System.out.println(startX + " " + startZ);
		rooms[x][z] = new DungeonRoom(this, x, z); //Starting room
		ArrayList<DungeonRoom> waitingRooms = new ArrayList<DungeonRoom>();
		waitingRooms.add(rooms[x][z]);
		rooms[x][z].features.add(new StartRoomFeature());
		ArrayList<Integer> keys = new ArrayList<Integer>();
		int keyColor = 0;
		while(waitingRooms.size() != 0)
		{
			x = waitingRooms.get(0).roomX;
			z = waitingRooms.get(0).roomZ;
			int exits = 0;
			if(x - 1 >= 0 && rooms[x - 1][z] == null && rand.nextInt(size) > waitingRooms.size() - 2)
			{
				rooms[x - 1][z] = new DungeonRoom(this, x - 1, z);
				rooms[x - 1][z].exits = 1;
				rooms[x][z].exits |= 4;
				waitingRooms.add(rooms[x - 1][z]);
				exits++;
				if(!keys.isEmpty() && rand.nextInt(waitingRooms.size() - 1) == 0)
				{
					rooms[x][z].features.add(new KeyDoorRoomFeature(keys.remove(0), 4));
				}
			}
			if(x + 1 < size && rooms[x + 1][z] == null && rand.nextInt(size) > waitingRooms.size() - 2)
			{
				rooms[x + 1][z] = new DungeonRoom(this, x + 1, z);
				rooms[x + 1][z].exits = 4;
				rooms[x][z].exits |= 1;
				waitingRooms.add(rooms[x + 1][z]);
				exits++;
				if(!keys.isEmpty() && rand.nextInt(waitingRooms.size() - 1) == 0)
				{
					rooms[x][z].features.add(new KeyDoorRoomFeature(keys.remove(0), 1));
				}
			}
			if(z - 1 >= 0 && rooms[x][z - 1] == null && rand.nextInt(size) > waitingRooms.size() - 2)
			{
				rooms[x][z - 1] = new DungeonRoom(this, x, z - 1);
				rooms[x][z - 1].exits = 2;
				rooms[x][z].exits |= 8;
				waitingRooms.add(rooms[x][z - 1]);
				exits++;
				if(!keys.isEmpty() && rand.nextInt(waitingRooms.size() - 1) == 0)
				{
					rooms[x][z].features.add(new KeyDoorRoomFeature(keys.remove(0), 8));
				}
			}
			if(z + 1 < size && rooms[x][z + 1] == null && rand.nextInt(size) > waitingRooms.size() - 2)
			{
				rooms[x][z + 1] = new DungeonRoom(this, x, z + 1);
				rooms[x][z + 1].exits = 8;
				rooms[x][z].exits |= 2;
				waitingRooms.add(rooms[x][z + 1]);
				exits++;
				if(!keys.isEmpty() && rand.nextInt(waitingRooms.size() - 1) == 0)
				{
					rooms[x][z].features.add(new KeyDoorRoomFeature(keys.remove(0), 2));
				}
			}
			if(exits == 0) //dead end
			{
				if(waitingRooms.size() > 1) //not end of dungeon
				{
					if(keyColor < 16 )
					{
						rooms[x][z].features.add(new KeyRoomFeature(keyColor));
						keys.add(keyColor);
						keyColor++;
					}
				}
				else
				{
					rooms[x][z].features.add(new BossRoomFeature());
				}
			}
			waitingRooms.remove(0);
		}
		rooms[startRoomX][startRoomZ].generate();
	}

	public void generateRoom(int x, int z)
	{
		x = (x + 9) / 21 - minX;
		z = (z + 9) / 21 - minZ;
		if(this.getRoom(x, z) != null && !this.getRoom(x, z).generated)
		{
			rooms[x][z].generate();
		}
	}

	public void end()
	{
	}

	public DungeonRoom getRoom(int roomX, int roomZ)
	{
		return (roomX < 0 || roomZ < 0 || roomX >= this.size || roomZ >= this.size) ? null : this.rooms[roomX][roomZ];
	}
}
