package scapecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import scapecraft.Scapecraft;

import java.util.List;

public class BlockScapecraftLeaves extends BlockLeaves
{
	protected Block sapling;
	protected Item fruit = null;
	
	public BlockScapecraftLeaves(Block sapling)
	{
		super();
		this.setCreativeTab(Scapecraft.tabScapecraftBlock);
		this.sapling = sapling;
	}

	public BlockScapecraftLeaves(Block sapling, Item fruit)
	{
		this(sapling);
		this.fruit = fruit;
	}

	@Override
	public BlockPlanks.EnumType getWoodType(int meta) {
		return BlockPlanks.EnumType.BIRCH;
	}

	/**
	 * Performs the shear function on this object.
	 * This is called for both client, and server.
	 * The object should perform all actions related to being sheared,
	 * except for dropping of the items, and removal of the block.
	 * As those are handled by ItemShears itself.
	 * <p>
	 * Returns a list of items that resulted from the shearing process.
	 * <p>
	 * For entities, they should trust there internal location information
	 * over the values passed into this function.
	 *
	 * @param item    The itemstack that is being used, Possible to be null
	 * @param world   The current world
	 * @param pos     If this is a block, the block's position in world.
	 * @param fortune The fortune level of the shears being used
	 * @return A ArrayList containing all items from this shearing. Possible to be null.
	 */
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return null;
	}
}
