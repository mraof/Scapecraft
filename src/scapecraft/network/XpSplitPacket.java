package scapecraft.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import scapecraft.util.Stats;

public class XpSplitPacket implements IMessage
{
	int attack;
	int strength;
	int meleeDefense;
	int ranged;
	int rangedDefense;
	int magic;
	int magicDefense;

	public XpSplitPacket(){}

	public XpSplitPacket(int attack, int strength, int meleeDefense, int ranged, int rangedDefense, int magic, int magicDefense)
	{
		this.attack = attack;
		this.strength = strength;
		this.meleeDefense = meleeDefense;
		this.ranged = ranged;
		this.rangedDefense = rangedDefense;
		this.magic = magic;
		this.magicDefense = magicDefense;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		attack = buf.readInt() & 0xFF; //Less than 256, but more importantly, can never be negative
		strength = buf.readInt() & 0xFF;
		meleeDefense = buf.readInt() & 0xFF;
		ranged = buf.readInt() & 0xFF;
		rangedDefense = buf.readInt() & 0xFF;
		magic = buf.readInt() & 0xFF;
		magicDefense = buf.readInt() & 0xFF;
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(attack);
		buf.writeInt(strength);
		buf.writeInt(meleeDefense);
		buf.writeInt(ranged);
		buf.writeInt(rangedDefense);
		buf.writeInt(magic);
		buf.writeInt(magicDefense);
	}

	public static class Handler implements IMessageHandler<XpSplitPacket, IMessage>
	{
		@Override
		public IMessage onMessage(XpSplitPacket message, MessageContext ctx)
		{
			int meleeConstitution = 120 - message.attack - message.meleeDefense - message.strength;
			int rangedConstitution = 120 - message.ranged - message.rangedDefense;
			int magicConstitution = 120 - message.magic - message.magicDefense;
			if(meleeConstitution >= 0 && rangedConstitution >= 0 && magicConstitution >= 0)
			{
				Stats.setCombatSplit(ctx.getServerHandler().playerEntity, meleeConstitution, message.attack, message.strength, message.meleeDefense, rangedConstitution, message.ranged, message.rangedDefense, magicConstitution, message.magic, message.magicDefense);
			}
			return null;
		}
	}
}
