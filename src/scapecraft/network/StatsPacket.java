package scapecraft.network;

import io.netty.buffer.ByteBuf;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import scapecraft.Stats;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StatsPacket implements IMessage, IMessageHandler<StatsPacket, IMessage>
{

	private int combatXp;
	private int agilityXp;
	private int miningXp;
	private int woodcuttingXp;
	private int combatLevel;
	private int agilityLevel;
	private int miningLevel;
	private int woodcuttingLevel;
	private int energy;

	public StatsPacket(){}

	public StatsPacket(EntityPlayer player)
	{
		combatXp = Stats.getStat(player, "combatxp");
		agilityXp = Stats.getStat(player, "agilityxp");
		miningXp = Stats.getStat(player, "miningxp");
		woodcuttingXp = Stats.getStat(player, "woodcuttingxp");
		combatLevel = Stats.getStat(player, "combatLevel");
		agilityLevel = Stats.getStat(player, "agilityLevel");
		miningLevel = Stats.getStat(player, "miningLevel");
		woodcuttingLevel = Stats.getStat(player, "woodcuttingLevel");
		energy = Stats.getEnergy(player);
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		combatXp = buf.readInt();
		agilityXp = buf.readInt();
		miningXp = buf.readInt();
		woodcuttingXp = buf.readInt();
		combatLevel = buf.readInt();
		agilityLevel = buf.readInt();
		miningLevel = buf.readInt();
		woodcuttingLevel = buf.readInt();
		energy = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(combatXp);
		buf.writeInt(agilityXp);
		buf.writeInt(miningXp);
		buf.writeInt(woodcuttingXp);
		buf.writeInt(combatLevel);
		buf.writeInt(agilityLevel);
		buf.writeInt(miningLevel);
		buf.writeInt(woodcuttingLevel);
		buf.writeInt(energy);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IMessage onMessage(StatsPacket message, MessageContext ctx)
	{
		Stats.setStat(Minecraft.getMinecraft().thePlayer, "combatxp", message.combatXp);
		Stats.setStat(Minecraft.getMinecraft().thePlayer, "agilityxp", message.agilityXp);
		Stats.setStat(Minecraft.getMinecraft().thePlayer, "miningxp", message.miningXp);
		Stats.setStat(Minecraft.getMinecraft().thePlayer, "woodcuttingxp", message.woodcuttingXp);
		Stats.setStat(Minecraft.getMinecraft().thePlayer, "combatLevel", message.combatLevel);
		Stats.setStat(Minecraft.getMinecraft().thePlayer, "agilityLevel", message.agilityLevel);
		Stats.setStat(Minecraft.getMinecraft().thePlayer, "miningLevel", message.miningLevel);
		Stats.setStat(Minecraft.getMinecraft().thePlayer, "woodcuttingLevel", message.woodcuttingLevel);
		Stats.setStat(Minecraft.getMinecraft().thePlayer, "energy", message.energy);
		return null;
	}
}
