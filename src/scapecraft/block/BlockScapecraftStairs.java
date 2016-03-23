package scapecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import scapecraft.Scapecraft;

public class BlockScapecraftStairs extends BlockStairs
{
	public boolean beaconBase = false;

	public BlockScapecraftStairs(Block block)
	{
		super(block, 0);
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
	}
}
