package scapecraft.block;

import net.minecraft.block.BlockLog;
import scapecraft.Scapecraft;

public class BlockScapecraftLog extends BlockLog
{
	public BlockScapecraftLog()
	{
		super();
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
	}

	public BlockScapecraftLog setHarvest(String tool, int level)
	{
		this.setHarvestLevel(tool, level);
		return this;
	}
}
