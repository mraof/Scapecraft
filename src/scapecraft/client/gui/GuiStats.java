package scapecraft.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

@SideOnly(Side.CLIENT)
public class GuiStats extends GuiScreen
{
	//This isn't finished yet
	protected static final ResourceLocation guiBackground = new ResourceLocation("scapecraft", "textures/gui/Spawner.png");
	protected static final int guiWidth = 176;
	protected static final int guiHeight = 176;
	protected int left = 0;
	protected int top = 0;
	protected static ResourceLocation statsIcons = new ResourceLocation("scapecraft", "textures/gui/StatIcons.png");
	public static int currentTab = 0;

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@Override
	public void initGui()
	{
		System.out.println("Init Gui");
		left = this.width / 2 - guiWidth / 2;
		top = this.height / 2 - guiHeight / 2;
		//this.fontRendererObj = mc.fontRendererObj;
	}

	@Override
	public void drawScreen(int x, int y, float f)
	{
		this.drawDefaultBackground();
		for(int i = 0; i < 2; i++)
		{
			if(i == currentTab)
			{
				GL11.glColor4f(1F, 1F, 1F, 1F);
			}
			else
			{
				GL11.glColor4f(0.7f, 0.7f, 0.7f, 1f);
			}
			this.mc.getTextureManager().bindTexture(guiBackground);
			this.drawTexturedModalRect(left + i * 26 + 4, top - 21, 48, 0, 24, 21);
			this.mc.getTextureManager().bindTexture(statsIcons);
			drawStatIcon(left + i * 26 + 8, top - 17, i);
		}
		this.mc.getTextureManager().bindTexture(guiBackground);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		drawBackgroundTexture(left, top);
		super.drawScreen(x, y, f);
	}

	@Override
	protected void mouseClicked(int x, int y, int button) throws IOException {
		super.mouseClicked(x, y, button);
		System.out.println(button + " at: " + x + " " + y);
		if(button == 0 && x > left && x < left + guiWidth && y < top && y > top - 21 && (x - left - 4) % 26 <= 24)
		{
			System.out.println(x + " " + y + " " + ((x - 4) / 26));
			switch ((x - left - 4) / 26)
			{
				case 0:
					this.mc.displayGuiScreen(new GuiStatList());
					break;
				case 1:
					this.mc.displayGuiScreen(new GuiXpSplit());
					break;
			}
		}
	}

	private void drawBackgroundTexture(int x, int y)
	{
		int currentX = x;
		this.drawTexturedModalRect(x, y, 0, 0, 16, 16);
		for(currentX += 16; currentX + 16 < x + guiWidth; currentX += 16)
		{
			this.drawTexturedModalRect(currentX, y, 16, 0, 16, 16);
		}
		this.drawTexturedModalRect(x + guiWidth - 16, y, 32, 0, 16, 16);
		currentX = x;

		for(int currentY = y + 16; currentY + 16 < y + guiHeight; currentY += 16)
		{
			this.drawTexturedModalRect(x, currentY, 0, 16, 16, 16);
			for(currentX += 16; currentX + 16 < x + guiWidth; currentX += 16)
			{
				this.drawTexturedModalRect(currentX, currentY, 16, 16, 16, 16);
			}
			this.drawTexturedModalRect(x + guiWidth - 16, currentY, 32, 16, 16, 16);
			currentX = x;
		}

		this.drawTexturedModalRect(x, y + guiHeight - 16, 0, 32, 16, 16);
		for(currentX += 16; currentX + 16 < x + guiWidth; currentX += 16)
		{
			this.drawTexturedModalRect(currentX, y + guiHeight - 16, 16, 32, 16, 16);
		}
		this.drawTexturedModalRect(x + guiWidth - 16, y + guiHeight - 16, 32, 32, 16, 16);
	}

	public void drawStatIcon(int x, int y, int number)
	{
		this.drawTexturedModalRect(x, y, (number % 16) * 16, (number / 16) * 16, 16, 16);
	}
}
