package scapecraft.item;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import java.util.Set;

public class ItemScapecraftShovel extends ItemScapecraftTool
{
	private static final Set<Block> effectiveBlocks = Sets.newHashSet(Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium);

	public ItemScapecraftShovel(float damageVsEntity, int level, String name)
	{
		super(damageVsEntity, level, effectiveBlocks);
		this.toolClass = "shovel";
		this.setUnlocalizedName(name);
		this.setTextureName("scapecraft:" + name);
	}
	@Override
	public boolean canItemHarvestBlock(Block block)
	{
		return block == Blocks.snow_layer || block == Blocks.snow;
	}
}
