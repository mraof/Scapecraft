package scapecraft.event;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scapecraft.Scapecraft;
import scapecraft.block.ScapecraftBlocks;
import scapecraft.client.ClientProxy;
import scapecraft.economy.EconomyHandler;
import scapecraft.entity.ScapecraftEntities;
import scapecraft.item.ItemArmorScapecraft;
import scapecraft.item.ItemScapecraftTool;
import scapecraft.item.ItemWeapon;
import scapecraft.item.ScapecraftItems;
import scapecraft.network.ConfigPacket;
import scapecraft.network.MobListPacket;
import scapecraft.network.RegionPacket;
import scapecraft.network.StatsPacket;
import scapecraft.util.CombatXpHelper;
import scapecraft.util.Config;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class ScapecraftEventHandler
{
	HashMap<String, Item[]> inventories = new HashMap<String, Item[]>();

	@SubscribeEvent
	public void onHurt(LivingHurtEvent event)
	{
		float amount = event.getAmount();
		if(event.getSource().getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
			for(ItemStack armor : player.getArmorInventoryList())
			{
				if(armor != null && armor.getItem() instanceof ItemArmorScapecraft)
				{
					((ItemArmorScapecraft) armor.getItem()).onWearerAttack(event);
				}
			}
			if(!event.getSource().isProjectile()) //Melee attack
			{
				if (player.fallDistance > 0.0F && !player.onGround && !player.isOnLadder() && !player.isInWater() && !player.isPotionActive(MobEffects.BLINDNESS) && player.getRidingEntity() == null)
				{
					amount /= 1.5; // Cancel critical hits
				}
				if(amount > 1.1)
				{
					amount--; //remove damage from punch
				}
				float strengthBuff = Stats.getLevel(player, Stat.STRENGTH) / 2f;
				int levelDifference = 10;
				double speedMultiplier = 1;
				ItemStack heldStack = player.getHeldItem(EnumHand.MAIN_HAND);
				if (heldStack != null && heldStack.getItem() instanceof ItemWeapon)
				{
					ItemWeapon weapon = (ItemWeapon) heldStack.getItem();
					amount = weapon.onEntityHurt(player, amount);
					speedMultiplier = weapon.getAttackTime() / 2 + 0.5;
					levelDifference = Stats.getLevel(player, Stat.ATTACK) - weapon.getMinLevel();
				}
				strengthBuff *= speedMultiplier;
				amount += strengthBuff;
				float minDamage = amount * 0.8f; //Default average is the normal damage
				float maxDamage = amount * 1.2f; //Default average is the normal damage
				if (levelDifference < 10)
				{
					minDamage *= 1 - ((10 - levelDifference) / 40);
				} else
				{
					maxDamage *= 1 + (levelDifference - 10) / (amount / speedMultiplier) / 2;
				}
				amount = minDamage + player.getRNG().nextFloat() * (maxDamage - minDamage);
			}
		}
		if(amount > 0 && !event.getSource().isUnblockable() && event.getEntityLiving() instanceof EntityPlayer && !Scapecraft.cauldron)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			event.getSource().setDamageBypassesArmor();
			amount = applyPlayerDefense(player, amount);
			//System.out.println(amount);
		}
		event.setAmount(amount);
	}

	public float applyPlayerDefense(EntityPlayer player, float amount)
	{
		float protection = 0;
		for(ItemStack stack : player.getArmorInventoryList())
		{
			Item armor;
			if((stack != null && (armor = stack.getItem()) instanceof ItemArmor))
			{
				float lastProtection = protection;
				if(armor instanceof ItemArmorScapecraft)
				{
					protection += ((ItemArmorScapecraft)armor).getDamageReduction();
				}
				else
				{
					protection += ((ItemArmor) armor).damageReduceAmount / 2;
				}
				if(lastProtection != protection)
				{
					stack.damageItem(1, player);
					if (stack.stackSize == 0)
					{
						player.setItemStackToSlot(((ItemArmor) armor).getEquipmentSlot(), null);
					}
				}
			}
		}
		float defenseModifier = Stats.getLevel(player, Stat.DEFENSE) - protection;
		protection += player.getRNG().nextFloat() * defenseModifier - defenseModifier / 2;
		if(protection > 0)
		{
			amount = (amount > (protection + 1)) ? (amount - protection) : (amount / protection);
		}
		return amount;
	}

	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event)
	{
		if(event.getEntity() instanceof EntityPlayer && !event.getEntity().worldObj.isRemote)
		{
			EntityPlayer player = (EntityPlayer) event.getEntity();

			if(Stats.getLevel(player, Stat.AGILITY) > 20)
			{
				player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 50, 1));
			}
			else if(Stats.getLevel(player, Stat.AGILITY) > 10)
			{
				player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 50, 0));
			}
			if(Stats.getLevel(player, Stat.AGILITY) > 25)
			{
				setMoveSpeed(player, .14F);
			}
			else if(Stats.getLevel(player, Stat.AGILITY) > 15)
			{
				setMoveSpeed(player, .12F);
			}

			boolean invChanged = false;
			if(inventories.get(player.getName()) == null)
			{
				invChanged = true;
			}
			else
			{
				for(int i = 0; i <= 3; i++)
				{
					if (inventories.get(player.getName())[i] != (player.inventory.armorInventory[i] != null ? player.inventory.armorInventory[i].getItem() : null))
					{
						invChanged = true;
					}
				}
			}
			if(invChanged)
			{
				updateHealth(player);
			}
		}
	}

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event)
	{
		/* if(event.entityLiving instanceof XpDropper)
		   {
		   ((XpDropper) event.entityLiving).giveXp();
		   } */
		if(event.getSource().getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
			if(player.capabilities.isCreativeMode)
			{
				return;
			}
			Stats.addXp(player, Stat.ATTACK, CombatXpHelper.getAmount(event.getEntityLiving()));
		}
	}

	@SubscribeEvent
	public void onWorldSave(WorldEvent.Save event)
	{
		World world = event.getWorld();
		if(world.provider.getDimension() != 0)
		{
			return;
		}

		File dataFile = world.getSaveHandler().getMapFileFromName("ScapecraftData");
		if(dataFile != null)
		{
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("version", Scapecraft.version);

			Stats.writeToNBT(nbt);

			if(EconomyHandler.scEconomy != null)
			{
				EconomyHandler.scEconomy.writeToNBT(nbt);
			}
			WorldProtectionHandler.getInstance().writeToNBT(nbt);

			try {
				CompressedStreamTools.writeCompressed(nbt, new FileOutputStream(dataFile));
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

		dataFile = world.getSaveHandler().getMapFileFromName("ScapecraftDrops");
		if(dataFile != null)
		{
			NBTTagCompound nbt = new NBTTagCompound();
			Config.saveDrops(nbt);
			try {
				CompressedStreamTools.writeCompressed(nbt, new FileOutputStream(dataFile));
			} catch(IOException e) {
				e.printStackTrace();
			}

		}
	}

	@SubscribeEvent
	public void onPlayerSpawn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent event)
	{
		//System.out.println("Respawned");
		Scapecraft.network.sendTo(new StatsPacket(event.player), (EntityPlayerMP) event.player);

		updateHealth(event.player);

		EconomyHandler.getBalance(event.player.getUniqueID());
	}

	@SubscribeEvent
	public void onPlayerChangeDimension(PlayerChangedDimensionEvent event)
	{
		//System.out.println("Changed dimension");
		updateHealth(event.player);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onHealthRender(RenderGameOverlayEvent.Pre event)
	{
		if((event.getType() == RenderGameOverlayEvent.ElementType.HEALTH))
		{
			event.setCanceled(true);
			ClientProxy.guiHealth.drawHealthBar(event.getResolution());
		}
		if(event.getType() == RenderGameOverlayEvent.ElementType.ARMOR)
		{
			event.setCanceled(true);
		}
	}

	public void setMoveSpeed(EntityPlayer player, float speed)
	{
		if(player.capabilities.getWalkSpeed() == speed)
		{
			return;
		}
		NBTTagCompound capabilities = new NBTTagCompound();
		player.capabilities.writeCapabilitiesToNBT(capabilities);
		capabilities.getCompoundTag("abilities").setFloat("walkSpeed", speed);
		player.capabilities.readCapabilitiesFromNBT(capabilities);
	}

	public void updateHealth(EntityPlayer player)
	{
		double maxHealth = 20 + Stats.getLevel(player, Stat.CONSTITUTION) * 4;
		Item[] newInv = new Item[4];
		for(int i = 0; i < 4; i++)
		{
			newInv[i] = player.inventory.armorInventory[i] != null ? player.inventory.armorInventory[i].getItem() : null;
			if(newInv[i] != null && newInv[i] instanceof ItemArmorScapecraft)
			{
				if(Scapecraft.requireLevels && !player.capabilities.isCreativeMode && ((ItemArmorScapecraft) newInv[i]).getMinLevel() > Stats.getLevel(player, Stat.DEFENSE))
				{
					if(!player.worldObj.isRemote)
					{
						player.entityDropItem(player.inventory.armorInventory[i], 0F).setOwner(player.getName());
					}
					newInv[i] = null;
					player.inventory.armorInventory[i] = null;
					continue;
				}
				maxHealth += ((ItemArmorScapecraft) newInv[i]).getHealthBoost(); 
			}
		}
		inventories.put(player.getName(), newInv);
		player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(maxHealth);
		if(player.getHealth() > maxHealth)
		{
			player.setHealth((float) maxHealth);
		}
		//System.out.println(maxHealth + " " + entityPlayer.getHealth());

	}

	@SubscribeEvent
	public void onPlayerBreakBlock(PlayerEvent.BreakSpeed event)
	{
		//TODO make this work right for block spawners
		IBlockState state = event.getState();
		Block block = state.getBlock();
		Stat blockStat = (state.getMaterial() == Material.WOOD ? Stat.WOODCUTTING : Stat.MINING);
		Stat toolStat = Stat.MINING;
		ItemStack heldStack = event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND);
		if(heldStack != null)
		{
			Item item = heldStack.getItem();
			toolStat = ((item instanceof ItemScapecraftTool) ? ((ItemScapecraftTool) item).skill : ((item instanceof ItemAxe) ? Stat.WOODCUTTING : Stat.MINING));
		}
		if(Scapecraft.requireLevels && 
				(heldStack != null &&
				ScapecraftItems.toolLevels.containsKey(heldStack.getItem()) &&
				ScapecraftItems.toolLevels.get(heldStack.getItem()) > Stats.getLevel(event.getEntityPlayer(), toolStat)) ||
				ScapecraftBlocks.blockLevels.get(block) != null &&
				Stats.getLevel(event.getEntityPlayer(), blockStat) < ScapecraftBlocks.blockLevels.get(block))
		{
			event.setNewSpeed(-1);
		}
	}

	@SubscribeEvent
	public void onPlayerLogin(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event)
	{
		//System.out.println("Logged in");
		Stats.initStats(event.player);
		ConfigPacket configPacket = new ConfigPacket(event.player);
		Scapecraft.network.sendTo(configPacket, (EntityPlayerMP) event.player);
		MobListPacket mobListPacket = new MobListPacket(ScapecraftEntities.dynamicMobs);
		Scapecraft.network.sendTo(mobListPacket, (EntityPlayerMP) event.player);
		RegionPacket regionPacket = new RegionPacket();
		Scapecraft.network.sendTo(regionPacket, (EntityPlayerMP) event.player);
	}

	@SubscribeEvent
	public void onLevelUp(LevelUpEvent event)
	{
		if(event.player.worldObj.isRemote && event.level % 5 == 0)
		{
			Minecraft.getMinecraft().renderGlobal.loadRenderers();
			ScapecraftBlocks.levelWalls.get(event.stat.toString().toLowerCase() + "LevelWall");
		}
		else
		{
			ITextComponent levelUpMessage = new TextComponentString("You have leveled up to " + event.level + " in " + event.stat.toString().toLowerCase());
			event.player.addChatMessage(levelUpMessage);
			if (event.level == 100)
			{
				ITextComponent text = new TextComponentString(event.player.getName() + " has achieved level 100 in " + event.stat.toString().toLowerCase());
				FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().sendChatMsg(text);
			}
			if (event.stat == Stat.CONSTITUTION)
			{
				updateHealth(event.player);
			}


		}
	}
}
