package scapecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

/**
 * Should become transparent and allow the player to pass through for a bit after consuming the key
 **/
public class BlockLock extends BlockScapecraft
{
	Item key;

	public BlockLock(Item key)
	{
		super(Material.GLASS);
		this.setBlockUnbreakable();
		this.key = key;
	}

}
