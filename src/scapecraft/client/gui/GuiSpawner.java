package scapecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import scapecraft.Scapecraft;
import scapecraft.entity.ScapecraftEntities;
import scapecraft.network.MobSpawnerPacket;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;

public class GuiSpawner extends GuiScreen
{
	private static final ResourceLocation guiBackground = new ResourceLocation("scapecraft", "textures/gui/Spawner.png");

	private static final int guiWidth = 300;
	private static final int guiHeight = 120;

	private Minecraft mc;
	TileEntityScapecraftMobSpawner te;
	private GuiTextField entityNameTextField;
	private GuiTextField spawnIntervalTextField;
	private GuiTextField maxSpawnTextField;
	private GuiButton doneButton;

	public GuiSpawner(Minecraft mc, TileEntityScapecraftMobSpawner te)
	{
		super();

		this.mc = mc;
		this.fontRendererObj = mc.fontRendererObj;
		this.te = te;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui()
	{
		int yOffset = (this.height / 2) - (guiHeight / 2);
		this.entityNameTextField = new GuiTextField(this.fontRendererObj, this.width / 2 - 100, yOffset + 25, 200, 20);
		this.entityNameTextField.setFocused(true);
		this.entityNameTextField.setMaxStringLength(120);
		this.entityNameTextField.setText(this.te.entityName);

		this.spawnIntervalTextField = new GuiTextField(this.fontRendererObj, this.width / 2 - 40, yOffset + 50, 40, 20);
		this.spawnIntervalTextField.setText("" + this.te.spawnInterval / 20);

		this.maxSpawnTextField = new GuiTextField(this.fontRendererObj, this.width / 2 + 80, yOffset + 50, 40, 20);
		this.maxSpawnTextField.setText("" + this.te.maxSpawn);
		
		this.doneButton = new GuiButton(0, this.width / 2 - 20, yOffset + 75, 40, 20, I18n.format("gui.done", new Object[0]));
		this.buttonList.add(doneButton);
	}
	@Override
	public void drawScreen(int x, int y, float f1)
	{
		this.drawDefaultBackground();
		GL11.glColor4f(1F, 1F, 1F, 1F);
		this.mc.getTextureManager().bindTexture(guiBackground);
		int yOffset = (this.height / 2) - (guiHeight / 2);
		//Use localizable names instead
		this.drawBackgroundTexture((this.width / 2) - (guiWidth / 2), yOffset, 0, 0, guiWidth, guiHeight);
		fontRendererObj.drawString("Mob", (this.width / 2) - fontRendererObj.getStringWidth("Mob") / 2, yOffset + 10, 0x404040);
		fontRendererObj.drawString("Spawn Interval: ", (this.width / 2) - fontRendererObj.getStringWidth("Spawn Interval: ") - 40, yOffset + 55, 0x404040);
		fontRendererObj.drawString("Max Spawned: ", (this.width / 2) - fontRendererObj.getStringWidth("Max Spawned: ") + 80, yOffset + 55, 0x404040);
		this.entityNameTextField.drawTextBox();
		this.spawnIntervalTextField.drawTextBox();
		this.maxSpawnTextField.drawTextBox();
		super.drawScreen(x, y, f1);
	}
	@Override
	protected void keyTyped(char character, int key)
	{
		super.keyTyped(character, key);
		this.entityNameTextField.textboxKeyTyped(character, key);
		this.spawnIntervalTextField.textboxKeyTyped(character, key);
		this.maxSpawnTextField.textboxKeyTyped(character, key);
	}

	@Override
	protected void mouseClicked(int x, int y, int button)
	{
		super.mouseClicked(x, y, button);
		this.entityNameTextField.mouseClicked(x, y, button);
		this.spawnIntervalTextField.mouseClicked(x, y, button);
		this.maxSpawnTextField.mouseClicked(x, y, button);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if(button.id == 0)
		{
			if(entityNameTextField.getText().indexOf(' ') != -1 && !ScapecraftEntities.entityNames.containsKey(entityNameTextField.getText().toLowerCase().substring(0, entityNameTextField.getText().indexOf(' '))))
				return;
			te.entityName = entityNameTextField.getText();
			System.out.println(te.entityName);
			Integer spawnInterval = Integer.parseInt(spawnIntervalTextField.getText());
			if(spawnInterval != null)
			{
				te.spawnInterval = spawnInterval * 20;
			}
			Integer maxSpawn = Integer.parseInt(maxSpawnTextField.getText());
			if(maxSpawn != null)
			{
				te.maxSpawn = maxSpawn;
			}
			MobSpawnerPacket packet = new MobSpawnerPacket(te);
			Scapecraft.network.sendToServer(packet);

			this.mc.displayGuiScreen((GuiScreen)null);
		}
	}

	public void drawBackgroundTexture(int x, int y, int u, int v, int width, int height)
	{
		int currentX = x;
		this.drawTexturedModalRect(x, y, 0, 0, 16, 16);
		for(currentX += 16; currentX + 16 < x + width; currentX += 16)
		{
			this.drawTexturedModalRect(currentX, y, 16, 0, 16, 16);
		}
		this.drawTexturedModalRect(x + width - 16, y, 32, 0, 16, 16);
		currentX = x;

		for(int currentY = y + 16; currentY + 16 < y + height; currentY += 16)
		{
			this.drawTexturedModalRect(x, currentY, 0, 16, 16, 16);
			for(currentX += 16; currentX + 16 < x + width; currentX += 16)
			{
				this.drawTexturedModalRect(currentX, currentY, 16, 16, 16, 16);
			}
			this.drawTexturedModalRect(x + width - 16, currentY, 32, 16, 16, 16);
			currentX = x;
		}

		this.drawTexturedModalRect(x, y + height - 16, 0, 32, 16, 16);
		for(currentX += 16; currentX + 16 < x + width; currentX += 16)
		{
			this.drawTexturedModalRect(currentX, y + height - 16, 16, 32, 16, 16);
		}
		this.drawTexturedModalRect(x + width - 16, y + height - 16, 32, 32, 16, 16);
	}
}
