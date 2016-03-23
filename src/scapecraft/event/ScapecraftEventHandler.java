package scapecraft.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.WorldEvent;
import scapecraft.Scapecraft;
import scapecraft.block.BlockBlockSpawner;
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
		if(event.source.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			for(int i = 0; i <= 3; i++)
			{
				if(player.getCurrentArmor(i) != null && player.getCurrentArmor(i).getItem() instanceof ItemArmorScapecraft)
				{
					((ItemArmorScapecraft) player.getCurrentArmor(i).getItem()).onWearerAttack(event);
				}
			}
			if(!event.source.isProjectile()) //Melee attack
			{
				if (player.fallDistance > 0.0F && !player.onGround && !player.isOnLadder() && !player.isInWater() && !player.isPotionActive(Potion.blindness) && player.ridingEntity == null)
				{
					event.ammount /= 1.5; // Cancel critical hits
				}
				if(event.ammount > 1.1)
				{
					event.ammount--; //remove damage from punch
				}
				float strengthBuff = Stats.getLevel(player, Stat.STRENGTH) / 2f;
				int levelDifference = 10;
				double speedMultiplier = 1;
				if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemWeapon)
				{
					ItemWeapon weapon = (ItemWeapon) player.getHeldItem().getItem();
					weapon.onEntityHurt(event);
					speedMultiplier = weapon.getAttackTime() / 2 + 0.5;
					levelDifference = Stats.getLevel(player, Stat.ATTACK) - weapon.getMinLevel();
				}
				strengthBuff *= speedMultiplier;
				event.ammount += strengthBuff;
				float minDamage = event.ammount * 0.8f; //Default average is the normal damage
				float maxDamage = event.ammount * 1.2f; //Default average is the normal damage
				if (levelDifference < 10)
				{
					minDamage *= 1 - ((10 - levelDifference) / 40);
				} else
				{
					maxDamage *= 1 + (levelDifference - 10) / (event.ammount / speedMultiplier) / 2;
				}
				event.ammount = minDamage + player.getRNG().nextFloat() * (maxDamage - minDamage);
			}
		}
		if(event.ammount > 0 && !event.source.isUnblockable() && event.entityLiving instanceof EntityPlayer && !Scapecraft.cauldron)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			event.source.setDamageBypassesArmor();
			event.ammount = applyPlayerDefense(player, event.ammount);
			//System.out.println(event.ammount);
		}
	}

	@SubscribeEvent
	public void onLivingAttack(LivingAttackEvent event)
	{
		if(Scapecraft.cauldron && event.entityLiving instanceof EntityPlayer && !event.source.isUnblockable())
		{
			event.setCanceled(true);
			event.source.setDamageBypassesArmor();
			System.out.println("Unblockable: " + event.source.isUnblockable());
			event.entityLiving.attackEntityFrom(event.source, 10 / .6f);
		}
	}

	public float applyPlayerDefense(EntityPlayer player, float amount)
	{
		float protection = 0;
		for(int i = 0; i < 4; i++)
		{
			Item armor;
			if((player.getCurrentArmor(i) != null && (armor = player.getCurrentArmor(i).getItem()) instanceof ItemArmor))
			{
				if(armor instanceof ItemArmorScapecraft)
				{
					protection += ((ItemArmorScapecraft)armor).getDamageReduction();
				}
				else
				{
					protection += ((ItemArmor) armor).damageReduceAmount / 2;
				}
				player.getCurrentArmor(i).damageItem(1, player);
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
		if(event.entity instanceof EntityPlayer && !event.entity.worldObj.isRemote)
		{
			EntityPlayer player = (EntityPlayer) event.entity;

			if(Stats.getLevel(player, Stat.AGILITY) > 20)
			{
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 50, 1));
			}
			else if(Stats.getLevel(player, Stat.AGILITY) > 10)
			{
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 50, 0));
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
			if(inventories.get(player.getCommandSenderName()) == null)
			{
				invChanged = true;
			}
			else
			{
				for(int i = 0; i <= 3; i++)
				{
					if (inventories.get(player.getCommandSenderName())[i] != (player.getCurrentArmor(i) != null ? player.getCurrentArmor(i).getItem() : null))
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
		if(event.source.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			if(player.capabilities.isCreativeMode)
			{
				return;
			}
			Stats.addXp(player, Stat.ATTACK, CombatXpHelper.getAmount(event.entityLiving));
		}
	}

	@SubscribeEvent
	public void onWorldSave(WorldEvent.Save event)
	{
		if(event.world.provider.dimensionId != 0)
		{
			return;
		}

		File dataFile = event.world.getSaveHandler().getMapFileFromName("ScapecraftData");
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

		dataFile = event.world.getSaveHandler().getMapFileFromName("ScapecraftDrops");
		if(dataFile != null && dataFile.exists())
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
	public void onPlayerSpawn(cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent event)
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
		if((event.type == RenderGameOverlayEvent.ElementType.HEALTH))
		{
			event.setCanceled(true);
			ClientProxy.guiHealth.drawHealthBar(event.resolution);
		}
		if(event.type == RenderGameOverlayEvent.ElementType.ARMOR)
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
			newInv[i] = player.getCurrentArmor(i) != null ? player.getCurrentArmor(i).getItem() : null;
			if(newInv[i] != null && newInv[i] instanceof ItemArmorScapecraft)
			{
				if(Scapecraft.requireLevels && !player.capabilities.isCreativeMode && ((ItemArmorScapecraft) newInv[i]).getMinLevel() > Stats.getLevel(player, Stat.DEFENSE))
				{
					if(!player.worldObj.isRemote)
					{
						player.entityDropItem(player.getCurrentArmor(i), 0F).setOwner(player.getCommandSenderName());
					}
					newInv[i] = null;
					player.inventory.armorInventory[i] = null;
					continue;
				}
				maxHealth += ((ItemArmorScapecraft) newInv[i]).getHealthBoost(); 
			}
		}
		inventories.put(player.getCommandSenderName(), newInv);
		player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(maxHealth);
		if(player.getHealth() > maxHealth)
		{
			player.setHealth((float) maxHealth);
		}
		//System.out.println(maxHealth + " " + entityPlayer.getHealth());

	}

	@SubscribeEvent
	public void onPlayerBreakBlock(PlayerEvent.BreakSpeed event)
	{
		Block block = event.block instanceof BlockBlockSpawner ? ((BlockBlockSpawner) event.block).fullBlock : event.block;
		Stat blockStat = (block.getMaterial() == Material.wood ? Stat.WOODCUTTING : Stat.MINING);
		Stat toolStat = Stat.MINING;
		if(event.entityPlayer.getHeldItem() != null)
		{
			Item item = event.entityPlayer.getHeldItem().getItem();
			toolStat = (item instanceof ItemScapecraftTool ? ((ItemScapecraftTool) item).skill : item instanceof ItemAxe ? Stat.WOODCUTTING : Stat.MINING);
		}
		if(Scapecraft.requireLevels && 
				(event.entityPlayer.getHeldItem() != null && 
				ScapecraftItems.toolLevels.containsKey(event.entityLiving.getHeldItem().getItem()) &&
				ScapecraftItems.toolLevels.get(event.entityPlayer.getHeldItem().getItem()) > Stats.getLevel(event.entityPlayer, toolStat)) ||
				ScapecraftBlocks.blockLevels.get(block) != null && 
				Stats.getLevel(event.entityPlayer, blockStat) < ScapecraftBlocks.blockLevels.get(block))
		{
			event.newSpeed = -1F;
		}
	}

	@SubscribeEvent
	public void onPlayerLogin(cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event)
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
			if (event.level == 100)
			{
				IChatComponent text = new ChatComponentText(event.player.getFormattedCommandSenderName() + " has achieved level 100 in " + event.stat.toString().toLowerCase());
				MinecraftServer.getServer().getConfigurationManager().sendChatMsg(text);
			}
			if (event.stat == Stat.CONSTITUTION)
			{
				updateHealth(event.player);
			}


		}
	}
}
