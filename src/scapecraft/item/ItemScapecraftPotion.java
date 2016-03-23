package scapecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import scapecraft.Scapecraft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemScapecraftPotion extends Item
{
	public List<PotionEffect> effects = new ArrayList<PotionEffect>();

	public ItemScapecraftPotion(PotionEffect... effects)
	{
		Collections.addAll(this.effects, effects);
		this.setCreativeTab(Scapecraft.tabScapecraftMisc);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.drink;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		return false;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 32;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player)
	{
		if(!player.capabilities.isCreativeMode)
		{
			stack.stackSize--;
		}

		if(!world.isRemote)
		{
			for(PotionEffect effect : effects)
			{
				player.addPotionEffect(new PotionEffect(effect));
			}
		}

		return stack;
	}
}
