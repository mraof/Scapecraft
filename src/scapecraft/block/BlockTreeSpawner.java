package scapecraft.block;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockTreeSpawner extends BlockBlockSpawner
{
	private WorldGenerator treeGen;
	private int fullMetadata = 0;

	public BlockTreeSpawner(Block fullBlock, int regenTime, WorldGenerator treeGen)
	{
		this(fullBlock, regenTime, treeGen, 0);
	}

	public BlockTreeSpawner(Block fullBlock, int regenTime, WorldGenerator treeGen, int xp)
	{
		super(fullBlock, regenTime);
		this.treeGen = treeGen;
		this.stat = "woodcutting";
	}

	@Override
	public void onFullyGrown(World world, int x, int y, int z)
	{
		NBTTagCompound tileEntityNBT = new NBTTagCompound();
		world.getTileEntity(x, y, z).writeToNBT(tileEntityNBT);
		int metadata = world.getBlockMetadata(x, y, z);
		world.setBlockToAir(x, y, z);
		treeGen.generate(world, world.rand, x, y, z);
		world.setBlock(x, y, z, this, metadata, 3);
		world.getTileEntity(x, y, z).readFromNBT(tileEntityNBT);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta)
	{
		int top = y;
		for(; top < 256 && world.getBlock(x, top + 1, z).equals(this.fullBlock); top++);
		if(top != y)
		{
			this.fullBlock.harvestBlock(world, player, x, y, z, fullMetadata);
			world.setBlockToAir(x, top, z);
		}
		else
			super.harvestBlock(world, player, x, y, z, fullMetadata);
	}
}
