package scapecraft.item;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import scapecraft.util.Stat;

import java.util.Set;

public class ItemScapecraftPickaxe extends ItemScapecraftTool
{
	private static final Set<Block> effectiveBlocks = Sets.newHashSet(Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail);

	public ItemScapecraftPickaxe(float damage, int level, String name)
	{
		super(damage, level, effectiveBlocks);
		this.toolClass = "pickaxe";
		this.skill = Stat.MINING;
		this.setUnlocalizedName(name);
		this.setTextureName("scapecraft:" + name);
	}

	@Override
	public boolean canItemHarvestBlock(Block block)
	{
		return block == Blocks.obsidian ? 3 == 3 : (block != Blocks.diamond_block && block != Blocks.diamond_ore ? (block != Blocks.emerald_ore && block != Blocks.emerald_block ? (block != Blocks.gold_block && block != Blocks.gold_ore ? (block != Blocks.iron_block && block != Blocks.iron_ore ? (block != Blocks.lapis_block && block != Blocks.lapis_ore ? (block != Blocks.redstone_ore && block != Blocks.lit_redstone_ore ? (block.getMaterial() == Material.rock || (block.getMaterial() == Material.iron || block.getMaterial() == Material.anvil)) : 3 >= 2) : 3 >= 1) : 3 >= 1) : 3 >= 2) : 3 >= 2) : 3 >= 2);
	}

	@Override
	public float getStrVsBlock(ItemStack itemStack, Block block)
	{
		return block.getMaterial() != Material.iron && block.getMaterial() != Material.anvil && block.getMaterial() != Material.rock ? super.getStrVsBlock(itemStack, block) : this.efficiencyOnProperMaterial;
	}
}
