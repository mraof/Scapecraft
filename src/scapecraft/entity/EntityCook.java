package scapecraft.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import scapecraft.item.ScapecraftItems;

public class EntityCook extends EntityScapecraft
{
	public EntityCook(World par1World)
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

		if (itemstack != null && itemstack.getItem() == Items.cake && !par1EntityPlayer.capabilities.isCreativeMode)
		{
			if (itemstack.stackSize-- == 1)
			{
				par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(ScapecraftItems.questPoint2));
				par1EntityPlayer.addChatComponentMessage(new ChatComponentText("\u00a7ELumbridge Cook: Thank you, I don't actually have any reward for you, but I never promised one, next time be more careful with who you help"));

			}
			else if (!par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ScapecraftItems.questPoint2)))
			{
				par1EntityPlayer.entityDropItem(new ItemStack(ScapecraftItems.questPoint2, 1, 0), 0.5F);
			}
			return true;
		}

		else
			par1EntityPlayer.addChatComponentMessage(new ChatComponentText("\u00a7ELumbridge Cook: Please bring me a cake, the Duke's Birthday is soon and I can't work out how to make one on minecraft, who uses raw wheat in cooking?"));

		return super.interact(par1EntityPlayer);
	}

	@Override
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
