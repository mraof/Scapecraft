package scapecraft.item;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import scapecraft.util.Stat;

import java.util.Set;

public class ItemScapecraftAxe extends ItemScapecraftTool
{
	private static final Set<Block> effectiveBlocks = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN);

	public ItemScapecraftAxe(float damage, int level, String name)
	{
		super(damage, level, effectiveBlocks);
		this.toolClass = "axe";
		this.skill = Stat.WOODCUTTING;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}

	@Override
	public float getStrVsBlock(ItemStack itemStack, IBlockState blockState)
	{
		return blockState.getMaterial() != Material.WOOD && blockState.getMaterial() != Material.PLANTS && blockState.getMaterial() != Material.VINE ? super.getStrVsBlock(itemStack, blockState) : this.efficiencyOnProperMaterial;
	}
}
