package scapecraft.command;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.MinecraftForgeClient;
import scapecraft.client.renderer.item.RenderItemWeapon;

public class WeaponModelCommand extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "weaponmodel";
	}

	@Override
	public String getCommandUsage(ICommandSender sender)
	{
		return "commands.weaponmodel.usage";
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
	{
		return true;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args)
	{
		IItemRenderer itemRenderer = MinecraftForgeClient.getItemRenderer(Minecraft.getMinecraft().thePlayer.getHeldItem(), ItemRenderType.EQUIPPED);
		if(itemRenderer instanceof RenderItemWeapon && args.length > 0)
		{
			if(args[0].toLowerCase().startsWith("o") && args.length == 4)
			{
				((RenderItemWeapon) itemRenderer).setOffset(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
			}
			else if(args[0].toLowerCase().startsWith("r") && args.length == 4)
			{
				((RenderItemWeapon) itemRenderer).setRotation(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
			}
			else if(args[0].toLowerCase().startsWith("s") && args.length == 2)
			{
				((RenderItemWeapon) itemRenderer).scale = Float.parseFloat(args[1]);
			}

		}
		else if(args.length == 2 && args[0].toLowerCase().startsWith("m"))
		{
			try
			{
				Object model = Class.forName("scapecraft.client.model." + args[1]).newInstance();
				if(model instanceof ModelBase)
				{
					MinecraftForgeClient.registerItemRenderer(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem(), new RenderItemWeapon((ModelBase) model, new ResourceLocation("scapecraft", "NOTSET"), 1F, 220F));
				}
			}
			catch(Exception ignored)
			{
			}
		}
	}
}

