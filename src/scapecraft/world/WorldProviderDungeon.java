package scapecraft.world;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

import scapecraft.world.gen.ChunkProviderDungeon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderDungeon extends WorldProvider
{
	private ChunkProviderDungeon provider;

	@Override
	public IChunkProvider createChunkGenerator()
	{
		if(provider == null)
		{
			provider = new ChunkProviderDungeon(this.worldObj, this.worldObj.getSeed());
		}

		return provider;
	}

	@Override
	public String getDimensionName()
	{
		return "Dungeon";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean getWorldHasVoidParticles()
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public double getVoidFogYFactor()
	{
		return 0D;
	}

	@Override
	public boolean canDoLightning(Chunk chunk)
	{
		return false;
	}

	@Override
	public boolean canDoRainSnowIce(Chunk chunk)
	{
		return false;
	}

	@Override
	protected void generateLightBrightnessTable()
	{
		this.lightBrightnessTable = new float[] {1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F, 1F};
	}
}
