package scapecraft.item;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import java.util.Set;

public class ItemScapecraftShovel extends ItemScapecraftTool
{
	private static final Set<Block> effectiveBlocks = Sets.newHashSet(Blocks.GRASS, Blocks.DIRT, Blocks.SAND, Blocks.GRAVEL, Blocks.SNOW_LAYER, Blocks.SNOW, Blocks.CLAY, Blocks.FARMLAND, Blocks.SOUL_SAND, Blocks.MYCELIUM);

	public ItemScapecraftShovel(float damageVsEntity, int level, String name)
	{
		super(damageVsEntity, level, effectiveBlocks);
		this.toolClass = "shovel";
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
	@Override
	public boolean canHarvestBlock(IBlockState blockState)
	{
		return blockState == Blocks.SNOW_LAYER || blockState == Blocks.SNOW;
	}
}
