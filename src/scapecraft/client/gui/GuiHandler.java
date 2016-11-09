package scapecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import scapecraft.economy.EconomyHandler;
import scapecraft.economy.market.Listing;
import scapecraft.entity.Drop;
import scapecraft.inventory.*;
import scapecraft.item.QualityItem;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;
import scapecraft.tileentity.TileEntitySmeltingFurnace;
import scapecraft.tileentity.TileEntitySmithingAnvil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuiHandler implements IGuiHandler
{
	public enum GuiId
	{
		SPAWNER,
		SMELTING,
		SMITHING,
		DROPS,
		SHOP,
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		switch (GuiId.values()[id])
		{
			case SMELTING:
				if(te instanceof TileEntitySmeltingFurnace)
				{
					return new ContainerSmelting(player.inventory, ((TileEntitySmeltingFurnace)te).getInventory(player), (TileEntitySmeltingFurnace) te);
				}
				break;
			case SMITHING:
				if(te instanceof TileEntitySmithingAnvil)
				{
					return new ContainerSmithing(player.inventory, ((TileEntitySmithingAnvil)te).getInventory(player), (TileEntitySmithingAnvil) te);
				}
				break;
			case DROPS:
				return new ContainerMobDrops(player.inventory);
			case SHOP:
				int tabNumber = 0;
				Collection<Listing> listings;
				if(player.openContainer instanceof ContainerShop)
				{
					tabNumber = ((ContainerShop) player.openContainer).tabNumber;
				}
				if(te instanceof TileEntityScapecraftMobSpawner && !((TileEntityScapecraftMobSpawner) te).getDrops(null).isEmpty())
				{
					listings = new ArrayList<Listing>();
					ArrayList<Drop> drops = new ArrayList<Drop>(((TileEntityScapecraftMobSpawner) te).getDrops(null));
					int level = 1;
					String entityName = ((TileEntityScapecraftMobSpawner) te).entityName.toLowerCase();
					Pattern pattern = Pattern.compile("\\blevel=\\d*\\b");
					Matcher matcher = pattern.matcher(entityName);
					if(matcher.matches())
					{
						level = Integer.parseInt(matcher.group().substring(6));
					}
					String name = "Shop";
					pattern = Pattern.compile("\\bname=.*\\b");
					matcher = pattern.matcher(entityName);
					if(matcher.matches())
					{
						name = matcher.group().substring(5);
					}
					else
					{
						pattern = Pattern.compile("\\bmob=.\\w*\\b");
						matcher = pattern.matcher(entityName);
						if (matcher.matches())
						{
							name = matcher.group().substring(4);
							if (name.charAt(0) == '@')
							{
								name = name.substring(2);
							}
						}
					}
					for (Drop drop : drops)
					{
						if (drop.stack.getItem() instanceof QualityItem)
						{
							ItemStack stack = drop.stack.copy();
							if (!stack.hasTagCompound())
							{
								stack.setTagCompound(new NBTTagCompound());
							}
							stack.getTagCompound().setInteger("level", level);
							stack.getTagCompound().setString("source", "Bought from " + name);
							drop = new Drop(stack, drop.chance, drop.custom);
						}
						listings.add(new Listing(Math.abs(drop.chance), drop.stack, drop.chance >= 0));
					}
				}
				else
				{
					listings = EconomyHandler.getGlobalMarket();
				}
				return new ContainerShop(player.inventory, listings, tabNumber, x, y, z);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		switch(GuiId.values()[id])
		{
			case SMELTING:
				return new GuiSmelting(player.inventory, new InventoryScapecraft(3));
			case SMITHING:
				return new GuiSmithing(player.inventory, new InventoryScapecraft(3));
			case SPAWNER:
				TileEntityScapecraftMobSpawner te = (TileEntityScapecraftMobSpawner) world.getTileEntity(new BlockPos(x, y, z));
				if(te != null)
				{
					return new GuiSpawner(Minecraft.getMinecraft(), te);
				}
				else
				{
					return null;
				}
			case DROPS:
				return new GuiMobDrops(new ContainerMobDrops(player.inventory));
			case SHOP:
				return new GuiShop(new ContainerShop(player.inventory, new ArrayList<Listing>(), 0, x, y, z));
			default:
				return null;
		}
	}
}
