package scapecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import scapecraft.Scapecraft;
import scapecraft.event.WorldProtectionHandler;
import scapecraft.tileentity.TileEntityBlockSpawner;
import scapecraft.util.Stat;

public class BlockBlockSpawner extends Block implements ITileEntityProvider, WorldProtectionHandler.IRegionBlock
{
	public IBlockState fullBlock;
	int xp;
	public int regenTime;
	//metadata when the block is done growing
	public int fullSize = 15;
	public Stat stat = Stat.MINING;
	//metadata for the fullBlock
	public int fullMeta = 0;

	public BlockBlockSpawner(Block fullBlock, int regenTime, int xp)
	{
		super(fullBlock.getDefaultState().getMaterial());
		this.fullBlock = fullBlock.getDefaultState();
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
		this.regenTime = regenTime * 20;
		this.xp = xp;
		this.setHarvestLevel(fullBlock.getHarvestTool(fullBlock.getDefaultState()), fullBlock.getHarvestLevel(fullBlock.getDefaultState()));
	}

	public BlockBlockSpawner(Block fullBlock, int regenTime)
	{
		this(fullBlock, regenTime, 0);
	}

	public void onFullyGrown(World world, BlockPos pos)
	{
	}

	public int getRegenTime()
	{
		return regenTime;
	}

	@Override
	public void onPlayerBreakBlock(PlayerEvent.BreakSpeed event)
	{

	}

	@Override
	public void onBlockExploded(World world, BlockPos pos, Explosion explosion)
	{
		//Don't get destroyed, don't do anything
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing the block.
	 *
	 * @param worldIn
	 * @param meta
	 */
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityBlockSpawner();
	}
}
