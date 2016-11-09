package scapecraft.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
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

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(9001.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
	}

	@Override
	protected SoundEvent getHurtSound()
	{
		//return "mob.villager.defaulthurt";
		return SoundEvents.ENTITY_VILLAGER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		//return "mob.villager.defaultdeath";
		return SoundEvents.ENTITY_VILLAGER_DEATH;
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack stack)
	{

		ItemStack itemstack = player.inventory.getCurrentItem();

		if (itemstack != null && itemstack.getItem() == ScapecraftItems.beer && !player.capabilities.isCreativeMode)
		{
			if (itemstack.stackSize-- == 1)
			{
				player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(ScapecraftItems.stake));
				player.addChatComponentMessage(new TextComponentString("\u00a7EDr Harlow: Take this, it should allow you to kill the vampire, but you will still need your best armor"));

			}
			else if (!player.inventory.addItemStackToInventory(new ItemStack(ScapecraftItems.stake)))
			{
				player.entityDropItem(new ItemStack(ScapecraftItems.stake, 1, 0), 0.5F);
			}

			return true;
		}



		else
		{
			player.addChatComponentMessage(new TextComponentString("\u00a7EDr Harlow: Bring me a beer and then we can talk"));
		}

		return super.processInteract(player, hand, stack);
	}
}
