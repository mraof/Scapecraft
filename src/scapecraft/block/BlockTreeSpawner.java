package scapecraft.block;

import net.minecraft.block.Block;
import scapecraft.util.Stat;
import scapecraft.world.gen.feature.WorldGenScapecraft;

public class BlockTreeSpawner extends BlockBlockSpawner
{
	private WorldGenScapecraft treeGen;

	public BlockTreeSpawner(Block fullBlock, int regenTime, WorldGenScapecraft treeGen)
	{
		this(fullBlock, regenTime, treeGen, 0);
	}

	public BlockTreeSpawner(Block fullBlock, int regenTime, WorldGenScapecraft treeGen, int xp)
	{
		super(fullBlock, regenTime, xp);
		this.treeGen = treeGen;
		this.stat = Stat.WOODCUTTING;
	}

/*	@Override
	public void onFullyGrown(World world, BlockPos pos)
	{
		fixTileEntity(world, pos);
		TileEntityTreeSpawner tileEntity = (TileEntityTreeSpawner) world.getTileEntity(pos);
		int metadata = world.getBlockMetadata(pos);
		//world.setBlockToAir(pos); //Why did I do this?
		treeGen.genTracker = tileEntity;
		treeGen.generate(world, world.rand, pos);
		treeGen.genTracker = null;
		NBTTagCompound tileEntityNBT = new NBTTagCompound();
		tileEntity.writeToNBT(tileEntityNBT);
		world.setBlockState(pos, this, metadata, 3);
		tileEntity.readFromNBT(tileEntityNBT);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta)
	{
		fixTileEntity(world, x, y, z);
		TileEntityTreeSpawner tileEntity = ((TileEntityTreeSpawner) world.getTileEntity(x, y, z));
		ChunkCoordinates coordinates = tileEntity.removeSpawnedBlock(this.fullBlock);
		//System.out.println(coordinates);
		if (coordinates != null)
		{
			Stats.addXp(player, stat, xp);
			this.fullBlock.harvestBlock(world, player, coordinates.posX, coordinates.posY, coordinates.posZ, fullMeta);
			world.setBlockToAir(coordinates.posX, coordinates.posY, coordinates.posZ);
		} else
		{
			while((coordinates = tileEntity.removeSpawnedBlock(null)) != null)
			{
				world.setBlockToAir(coordinates.posX, coordinates.posY, coordinates.posZ);
			}
			super.harvestBlock(world, player, x, y, z, fullMeta);
		}
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityTreeSpawner();
	}

	public void fixTileEntity(World world, int x, int y, int z)
	{
		if(world.getTileEntity(x, y, z).getClass() == TileEntityBlockSpawner.class)
		{
			NBTTagCompound tagCompound = new NBTTagCompound();
			world.getTileEntity(x, y, z).writeToNBT(tagCompound);
			TileEntityTreeSpawner treeSpawner = new TileEntityTreeSpawner();
			treeSpawner.readFromNBT(tagCompound);
			world.setTileEntity(x, y, z, treeSpawner);
		}
	}*/
}
