package scapecraft.network;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

import scapecraft.entity.EntityShopshifter;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ShopGuiPacket implements IMessage, IMessageHandler<ShopGuiPacket, IMessage>
{
	ArrayList<ItemStack> stock;

	public ShopGuiPacket(){}

	public ShopGuiPacket(EntityShopshifter entity)
	{
		stock = entity.stock;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
	}

	@Override
	public IMessage onMessage(ShopGuiPacket message, MessageContext ctx)
	{
		return null;
	}
}
