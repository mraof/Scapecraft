package scapecraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scapecraft.Scapecraft;
import scapecraft.block.ScapecraftBlocks;
import scapecraft.client.gui.GuiHealth;
import scapecraft.economy.EconomyHandler;
import scapecraft.entity.ScapecraftEntities;
import scapecraft.item.ScapecraftItems;
import scapecraft.util.Config;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.io.File;

public class ConfigPacket implements IMessage
{
	public NBTTagList blockLevels;
	public NBTTagList toolLevels;
	public boolean requireLevels;
	public double multiplier;

	public NBTTagList dynamicMobs;

	int meleeConstitution;
	int attack;
	int strength;
	int meleeDefense;
	int rangedConstitution;
	int ranged;
	int rangedDefense;
	int magicConstitution;
	int magic;
	int magicDefense;

	int balance;

	public ConfigPacket(){}

	public ConfigPacket(EntityPlayer player)
	{
		blockLevels = Config.blockLevels;
		toolLevels = Config.toolLevels;
		requireLevels = Config.requireLevels;
		multiplier = Config.multiplier;

		this.dynamicMobs = ScapecraftEntities.dynamicMobs;

		meleeConstitution = Stats.getCombatSplit(player, Stat.ATTACK, Stat.CONSTITUTION);
		attack = Stats.getCombatSplit(player, Stat.ATTACK, Stat.ATTACK);
		strength = Stats.getCombatSplit(player, Stat.ATTACK, Stat.STRENGTH);
		meleeDefense = Stats.getCombatSplit(player, Stat.ATTACK, Stat.DEFENSE);

		rangedConstitution = Stats.getCombatSplit(player, Stat.RANGED, Stat.CONSTITUTION);
		ranged = Stats.getCombatSplit(player, Stat.RANGED, Stat.RANGED);
		rangedDefense = Stats.getCombatSplit(player, Stat.RANGED, Stat.DEFENSE);

		magicConstitution = Stats.getCombatSplit(player, Stat.MAGIC, Stat.CONSTITUTION);
		magic = Stats.getCombatSplit(player, Stat.MAGIC, Stat.MAGIC);
		magicDefense = Stats.getCombatSplit(player, Stat.MAGIC, Stat.DEFENSE);

		balance = (int) EconomyHandler.getBalance(player.getUniqueID());
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		requireLevels = buf.readBoolean();
		blockLevels = ByteBufUtils.readTag(buf).getTagList("tag", 10);
		toolLevels = ByteBufUtils.readTag(buf).getTagList("tag", 10);
		multiplier = buf.readDouble();

		dynamicMobs = ByteBufUtils.readTag(buf).getTagList("tag", 10);

		meleeConstitution = buf.readInt();
		attack = buf.readInt();
		strength = buf.readInt();
		meleeDefense = buf.readInt();
		rangedConstitution = buf.readInt();
		ranged = buf.readInt();
		rangedDefense = buf.readInt();
		magicConstitution = buf.readInt();
		magic = buf.readInt();
		magicDefense = buf.readInt();

		balance = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		NBTTagCompound blockCompound = new NBTTagCompound();
		blockCompound.setTag("tag", blockLevels);
		NBTTagCompound toolCompound = new NBTTagCompound();
		toolCompound.setTag("tag", toolLevels);
		buf.writeBoolean(requireLevels);
		ByteBufUtils.writeTag(buf, blockCompound);
		ByteBufUtils.writeTag(buf, toolCompound);
		buf.writeDouble(multiplier);

		NBTTagCompound mobCompound = new NBTTagCompound();
		mobCompound.setTag("tag", dynamicMobs);
		ByteBufUtils.writeTag(buf, mobCompound);

		buf.writeInt(meleeConstitution);
		buf.writeInt(attack);
		buf.writeInt(strength);
		buf.writeInt(meleeDefense);
		buf.writeInt(rangedConstitution);
		buf.writeInt(ranged);
		buf.writeInt(rangedDefense);
		buf.writeInt(magicConstitution);
		buf.writeInt(magic);
		buf.writeInt(magicDefense);

		buf.writeInt(balance);
	}

	public static class Handler implements IMessageHandler<ConfigPacket, IMessage>
	{
		@SideOnly(Side.CLIENT)
		@Override
		public IMessage onMessage(ConfigPacket message, MessageContext ctx)
		{
			Scapecraft.requireLevels = message.requireLevels;
			ScapecraftBlocks.setBlockLevels(message.blockLevels);
			ScapecraftItems.setToolLevels(message.toolLevels);
			if(Stats.multiplier != message.multiplier)
			{
				Stats.setXpValues(message.multiplier);
			}
			Stats.setCombatSplit(Minecraft.getMinecraft().thePlayer, message.meleeConstitution, message.attack, message.strength, message.meleeDefense, message.rangedConstitution, message.ranged, message.rangedDefense, message.magicConstitution, message.magic, message.magicDefense);

			GuiHealth.realBalance = GuiHealth.balance = message.balance;

			for(int i = 0; i < message.dynamicMobs.tagCount(); i++)
			{
				ScapecraftEntities.registerDynamicMob(message.dynamicMobs.getCompoundTagAt(i));
			}
			Scapecraft.proxy.setCacheDir(new File(new File(Scapecraft.configDir, "scCache"), Minecraft.getMinecraft().getCurrentServerData() == null ? "" : Minecraft.getMinecraft().getCurrentServerData().serverName));
			return new CacheListPacket(Scapecraft.proxy.cache);
		}
	}
}
