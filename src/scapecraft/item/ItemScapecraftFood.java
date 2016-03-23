package scapecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemScapecraftFood extends ItemFood
{
	public int healAmount;

	public ItemScapecraftFood(int healAmount)
	{
		super(healAmount, 0.6f, true);
		this.healAmount = healAmount;
		this.setMaxStackSize(2);
	}

	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onFoodEaten(stack, world, player);
		if(!world.isRemote)
		{
			player.heal(healAmount);
		}
	}
}
