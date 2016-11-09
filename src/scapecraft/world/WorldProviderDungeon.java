package scapecraft.world;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scapecraft.world.gen.ChunkProviderDungeon;

public class WorldProviderDungeon extends WorldProvider
{
	private ChunkProviderDungeon provider;

	@Override
	public IChunkGenerator createChunkGenerator()
	{
		if(provider == null)
		{
			provider = new ChunkProviderDungeon(this.worldObj, this.worldObj.getSeed());
		}

		return provider;
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
	public DimensionType getDimensionType() {
		return null;
	}

	@Override
	protected void generateLightBrightnessTable()
	{
		for(int i = 0; i < this.lightBrightnessTable.length; i++)
		{
			this.lightBrightnessTable[i] = 1F;
		}
	}
}
