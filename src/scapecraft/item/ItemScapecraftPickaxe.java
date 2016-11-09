package scapecraft.item;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import scapecraft.util.Stat;

import java.util.Set;

public class ItemScapecraftPickaxe extends ItemScapecraftTool
{
	private static final Set<Block> effectiveBlocks = Sets.newHashSet(Blocks.COBBLESTONE, Blocks.DOUBLE_STONE_SLAB, Blocks.STONE_SLAB, Blocks.STONE, Blocks.SANDSTONE, Blocks.MOSSY_COBBLESTONE, Blocks.IRON_ORE, Blocks.IRON_BLOCK, Blocks.COAL_ORE, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.DIAMOND_ORE, Blocks.DIAMOND_BLOCK, Blocks.ICE, Blocks.NETHERRACK, Blocks.LAPIS_ORE, Blocks.LAPIS_BLOCK, Blocks.REDSTONE_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.RAIL, Blocks.DETECTOR_RAIL, Blocks.GOLDEN_RAIL, Blocks.ACTIVATOR_RAIL);

	public ItemScapecraftPickaxe(float damage, int level, String name)
	{
		super(damage, level, effectiveBlocks);
		this.toolClass = "pickaxe";
		this.skill = Stat.MINING;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}

	@Override
	public boolean canHarvestBlock(IBlockState blockState)
	{
		return blockState == Blocks.OBSIDIAN ? 3 == 3 : (blockState != Blocks.DIAMOND_BLOCK && blockState != Blocks.DIAMOND_ORE ? (blockState != Blocks.EMERALD_ORE && blockState != Blocks.EMERALD_BLOCK ? (blockState != Blocks.GOLD_BLOCK && blockState != Blocks.GOLD_ORE ? (blockState != Blocks.IRON_BLOCK && blockState != Blocks.IRON_ORE ? (blockState != Blocks.LAPIS_BLOCK && blockState != Blocks.LAPIS_ORE ? (blockState != Blocks.REDSTONE_ORE && blockState != Blocks.LIT_REDSTONE_ORE ? (blockState.getMaterial() == Material.ROCK || (blockState.getMaterial() == Material.IRON || blockState.getMaterial() == Material.ANVIL)) : 3 >= 2) : 3 >= 1) : 3 >= 1) : 3 >= 2) : 3 >= 2) : 3 >= 2);
	}

	@Override
	public float getStrVsBlock(ItemStack itemStack, IBlockState blockState)
	{
		return blockState.getMaterial() != Material.IRON && blockState.getMaterial() != Material.ANVIL && blockState.getMaterial() != Material.ROCK ? super.getStrVsBlock(itemStack, blockState) : this.efficiencyOnProperMaterial;
	}
}
