package scapecraft.item;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Sets;

public class ItemScapecraftAxe extends ItemScapecraftTool
{
	private static final Set<Block> effectiveBlocks = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});

	public ItemScapecraftAxe(ScapecraftToolMaterial material)
	{
		super(3F, material, effectiveBlocks);
		this.toolClass = "axe";
		this.setUnlocalizedName(toolMaterial + "Axe");
		this.skill = "woodcutting";
	}

	@Override
	public float getStrVsBlock(ItemStack itemStack, Block block)
	{
		return block.getMaterial() != Material.wood && block.getMaterial() != Material.plants && block.getMaterial() != Material.vine ? super.getStrVsBlock(itemStack, block) : this.efficiencyOnProperMaterial;
	}
}
