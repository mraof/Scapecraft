package scapecraft.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import scapecraft.item.ScapecraftItems;

public class EntityDoctor extends EntityScapecraft
{
	public EntityDoctor(World par1World)
	{
		super(par1World);

		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(9001.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected String getHurtSound()
	{
		return "mob.villager.defaulthurt";
	}

	@Override
	protected String getDeathSound()
	{
		return "mob.villager.defaultdeath";
	}

	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{

		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if (itemstack != null && itemstack.getItem() == ScapecraftItems.beer && !par1EntityPlayer.capabilities.isCreativeMode)
		{
			if (itemstack.stackSize-- == 1)
			{
				par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(ScapecraftItems.stake));
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("\u00a7EDr Harlow: Take this, it should allow you to kill the vampire, but you will still need your best armor"));

			}
			else if (!par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ScapecraftItems.stake)))
			{
				par1EntityPlayer.entityDropItem(new ItemStack(ScapecraftItems.stake, 1, 0), 0.5F);
			}

			return true;
		}



		else
			par1EntityPlayer.addChatComponentMessage(new ChatComponentText("\u00a7EDr Harlow: Bring me a beer and then we can talk"));

		return super.interact(par1EntityPlayer);
	}

	public int getTotalArmorValue()
	{
		return 999;
	}

	@Override
	public int getXpValue()
	{
		return 0;
	}
}
