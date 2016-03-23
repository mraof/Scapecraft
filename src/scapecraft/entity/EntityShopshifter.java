package scapecraft.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import scapecraft.Scapecraft;
import scapecraft.client.gui.GuiHandler;
import scapecraft.item.ScapecraftItems;

import java.util.ArrayList;

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
		stock.add(new ItemStack(ScapecraftItems.equipmentSets.get("runeAxe"), 64));
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
			player.openGui(Scapecraft.instance, GuiHandler.GuiId.SHOP.ordinal(), worldObj, mobSpawnerX, mobSpawnerY, mobSpawnerZ);
		}
		return true;
	}

	@Override
	public boolean isAIEnabled()
	{
		return false;
	}

	@Override
	public void setMob(String mobName)
	{
		super.setMob(mobName);
		if(!worldObj.isRemote)
		{
			ArrayList<Drop> drops = this.mobSpawner == null ? ScapecraftEntities.getDrops(this.getClass()) : this.mobSpawner.getDrops(this);
			if(drops.size() > 0)
			{
				Drop drop = drops.get(rand.nextInt(drops.size()));
				this.copiedMob.setCurrentItemOrArmor(0, drop.stack.copy());
			}
		}
	}
}
