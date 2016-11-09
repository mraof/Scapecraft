package scapecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import scapecraft.Scapecraft;

/**
 * Because for some reason Block's constructor is protected
 */
public class BlockScapecraft extends Block
{
	public boolean beaconBase = false;

	public BlockScapecraft(Material material)
	{
		super(material);
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
	}

	public BlockScapecraft setBeaconBase()
	{
		this.beaconBase = true;
		return this;
	}

	@Override
	public boolean isBeaconBase(IBlockAccess world, BlockPos pos, BlockPos beaconPos)
	{
		return this.beaconBase;
	}

	public BlockScapecraft setHarvest(String tool, int level)
	{
		this.setHarvestLevel(tool, level);
		return this;
	}

	public BlockScapecraft setSlipperiness(float slipperiness)
	{
		this.slipperiness = slipperiness;
		return this;
	}
}
