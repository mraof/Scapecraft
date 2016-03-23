package scapecraft.item;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import scapecraft.util.Stat;

import java.util.Set;

public class ItemScapecraftAxe extends ItemScapecraftTool
{
	private static final Set<Block> effectiveBlocks = Sets.newHashSet(Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin);

	public ItemScapecraftAxe(float damage, int level, String name)
	{
		super(damage, level, effectiveBlocks);
		this.toolClass = "axe";
		this.skill = Stat.WOODCUTTING;
		this.setUnlocalizedName(name);
		this.setTextureName("scapecraft:" + name);
	}

	@Override
	public float getStrVsBlock(ItemStack itemStack, Block block)
	{
		return block.getMaterial() != Material.wood && block.getMaterial() != Material.plants && block.getMaterial() != Material.vine ? super.getStrVsBlock(itemStack, block) : this.efficiencyOnProperMaterial;
	}
}
