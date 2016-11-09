package scapecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import scapecraft.Scapecraft;

public class BlockScapecraftStairs extends BlockStairs
{
	public BlockScapecraftStairs(Block block)
	{
		super(block.getDefaultState());
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
	}
}
