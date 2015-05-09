package scapecraft.entity;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import scapecraft.Scapecraft;
import scapecraft.item.ScapecraftItems;
import scapecraft.network.ShopGuiPacket;

public class EntityShopshifter extends EntityShapeshifter
{
	public ArrayList<ItemStack> stock = new ArrayList<ItemStack>();

	public EntityShopshifter(World world)
	{
		this(world, "");
	}

	public EntityShopshifter(World world, String mobName)
	{
		super(world, mobName);
		stock.add(new ItemStack(ScapecraftItems.runeAxe, 64));
		this.targetClasses.clear();
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if(source.getSourceOfDamage() != null && !(source.getSourceOfDamage() instanceof EntityShapeshifter))
		{
			source.getSourceOfDamage().attackEntityFrom(DamageSource.causeMobDamage(this), amount);
			amount = 0;
		}
		return super.attackEntityFrom(source, amount);
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		if(!worldObj.isRemote)
		{
				ShopGuiPacket packet = new ShopGuiPacket(this);
				Scapecraft.network.sendTo(packet, (EntityPlayerMP) player);
		}
		return true;
	}
}
