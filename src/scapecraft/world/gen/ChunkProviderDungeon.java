package scapecraft.world.gen;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderDungeon implements IChunkProvider
{
	public World world;
	public long seed;

	public ChunkProviderDungeon(World world, long seed)
	{
		this.world = world;
		this.seed = seed;
	}

	@Override
	public boolean chunkExists(int chunkX, int chunkZ) 
	{
		return true;
	}

	@Override
	public Chunk provideChunk(int chunkX, int chunkZ)
	{
		Block[] chunkBlocks = new Block[65536];
		byte[] chunkMetadata = new byte[65536];
		Chunk chunk = new Chunk(this.world, chunkBlocks, chunkMetadata, chunkX, chunkZ);
		return chunk;
	}

	@Override
	public Chunk loadChunk(int chunkX, int chunkZ) 
	{
		return this.provideChunk(chunkX, chunkZ);
	}

	@Override
	public void populate(IChunkProvider var1, int chunkX, int chunkZ)
	{
	}

	@Override
	public boolean saveChunks(boolean var1, IProgressUpdate var2)
	{
		return true;
	}

	@Override
	public boolean unloadQueuedChunks()
	{
		return false;
	}

	@Override
	public boolean canSave()
	{
		return true;
	}

	@Override
	public String makeString()
	{
		return "Chatland";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getPossibleCreatures(EnumCreatureType var1, int var2, int var3, int var4) 
	{
		return null;
	}

	@Override
	public int getLoadedChunkCount()
	{
		return 0;
	}

	@Override
	public void recreateStructures(int var1, int var2)
	{
	}

	@Override
	public void saveExtraData()
	{
	}

	@Override
	public ChunkPosition findClosestStructure(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_)
	{
		return null;
	}
}
