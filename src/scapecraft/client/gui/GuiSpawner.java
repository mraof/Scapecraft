package scapecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import scapecraft.Scapecraft;
import scapecraft.entity.EntityScapecraft;
import scapecraft.entity.ScapecraftEntities;
import scapecraft.network.MobSpawnerKillPacket;
import scapecraft.network.TileEntityUpdatePacket;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;

import java.io.IOException;

public class GuiSpawner extends GuiScreen
{
	int lastTime = 0;
	EntityScapecraft entity = null;
	String entityName;
	int texture = 0;
	private static final ResourceLocation guiBackground = new ResourceLocation("scapecraft", "textures/gui/Spawner.png");

	private static final int guiWidth = 300;
	private static final int guiHeight = 120;

	private final Minecraft mc;
	private final TileEntityScapecraftMobSpawner te;
	private GuiTextField entityNameTextField;
	private GuiNumberField spawnIntervalNumberField;
	private GuiNumberField maxSpawnNumberField;
	private GuiNumberField textureNumberField;
	private GuiNumberField radiusNumberField;

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
		this.entityNameTextField = new GuiTextField(0, this.fontRendererObj, this.width / 2 - 120, yOffset + 6, 265, 20);
		this.entityNameTextField.setFocused(true);
		this.entityNameTextField.setMaxStringLength(120);
		this.entityNameTextField.setText(this.te.entityName);

		this.spawnIntervalNumberField = new GuiNumberField(1, this.fontRendererObj, this.width / 2 - 40, yOffset + 30, 40, 20);
		this.spawnIntervalNumberField.setValue(this.te.spawnInterval / 20);
		this.spawnIntervalNumberField.setMin(1);

		this.maxSpawnNumberField = new GuiNumberField(2, this.fontRendererObj, this.width / 2 + 80, yOffset + 30, 40, 20);
		this.maxSpawnNumberField.setValue(this.te.maxSpawn);
		this.maxSpawnNumberField.setMin(1);

		this.textureNumberField = new GuiNumberField(3, this.fontRendererObj, this.width / 2 + 80, yOffset + 50, 40, 20);
		this.textureNumberField.setValue(this.te.texture);
		this.textureNumberField.setMin(-1);

		this.radiusNumberField = new GuiNumberField(4, this.fontRendererObj, this.width / 2 - 40, yOffset + 50, 40, 20);
		this.radiusNumberField.setValue(this.te.radius);
		this.radiusNumberField.setMin(0);

		GuiButton doneButton = new GuiButton(0, this.width / 2 + 20, yOffset + 85, 40, 20, I18n.format("gui.done"));
		GuiButton killButton = new GuiButton(1, this.width / 2 - 60, yOffset + 85, 40, 20, I18n.format("gui.kill"));
		this.buttonList.add(doneButton);
		this.buttonList.add(killButton);
		updateEntityPreview();
	}
	@Override
	public void drawScreen(int x, int y, float f1)
	{
		this.drawDefaultBackground();
		GL11.glColor4f(1F, 1F, 1F, 1F);
		this.mc.getTextureManager().bindTexture(guiBackground);
		int yOffset = (this.height / 2) - (guiHeight / 2);
		//Use localizable names instead
		this.drawBackgroundTexture((this.width / 2) - (guiWidth / 2), yOffset);
		fontRendererObj.drawString("Mob: ", (this.width / 2) - fontRendererObj.getStringWidth("Mob: ") - 120, yOffset + 11, 0x404040);
		fontRendererObj.drawString("Spawn Interval: ", (this.width / 2) - fontRendererObj.getStringWidth("Spawn Interval: ") - 40, yOffset + 35, 0x404040);
		fontRendererObj.drawString("Max Spawned: ", (this.width / 2) - fontRendererObj.getStringWidth("Max Spawned: ") + 80, yOffset + 35, 0x404040);
		fontRendererObj.drawString("Radius: ", (this.width / 2) - fontRendererObj.getStringWidth("Radius: ") - 40, yOffset + 55, 0x404040);
		fontRendererObj.drawString("Texture: ", (this.width / 2) - fontRendererObj.getStringWidth("Texture: ") + 80, yOffset + 55, 0x404040);
		this.entityNameTextField.drawTextBox();
		this.spawnIntervalNumberField.drawTextBox();
		this.maxSpawnNumberField.drawTextBox();
		this.textureNumberField.drawTextBox();
		this.radiusNumberField.drawTextBox();
		if(entity != null)
		{
			int moveTime = (int) (Minecraft.getSystemTime() / 20 % 700);
			if(moveTime != lastTime)
			{
				entity.prevLimbSwingAmount = entity.limbSwingAmount;
				entity.limbSwingAmount = 0.4f;
				entity.limbSwing += entity.limbSwingAmount;
				lastTime = moveTime;
			}
			int xOffset;
			float rotation;
			if(moveTime < 300)
			{
				xOffset = moveTime;
				rotation = 90;
			}
			else if(moveTime < 350)
			{
				xOffset = 300;
				rotation = -(moveTime - 300) * 3.6F + 90;
			}
			else if(moveTime < 650)
			{
				xOffset = 650 - moveTime;
				rotation = 270;
			}
			else
			{
				xOffset = 0;
				rotation = (moveTime - 650) * 3.6F + 270;
			}

			float scaleFactor = 10;
			GL11.glPushMatrix();
			GL11.glTranslatef((this.width / 2 - (guiWidth / 2)) + xOffset, yOffset, 50);
			GL11.glScalef(scaleFactor, -scaleFactor, scaleFactor);
			GL11.glRotatef(rotation, 0, 1, 0);
			Minecraft.getMinecraft().getRenderManager().doRenderEntity(entity, 0.0D, 0.0D, 0.0D, 0F, 0F, false);
			GL11.glPopMatrix();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
		}
		super.drawScreen(x, y, f1);
	}

	@Override
	protected void keyTyped(char character, int key) throws IOException
	{
		super.keyTyped(character, key);
		if(this.entityNameTextField.textboxKeyTyped(character, key))
		{
			updateEntityPreview();
		}
		this.spawnIntervalNumberField.keyTypedNumber(character, key);
		this.maxSpawnNumberField.keyTypedNumber(character, key);
		this.textureNumberField.keyTypedNumber(character, key);
		if (texture != this.textureNumberField.value && (entity != null))
		{
			texture = this.textureNumberField.value;
			entity.setTexture(texture);
		}
		this.radiusNumberField.keyTypedNumber(character, key);
	}

	protected void updateEntityPreview()
	{
		String name = entityNameTextField.getText();
		if(name.indexOf(' ') != -1)
		{
			name = name.substring(0, name.indexOf(' '));
		}
		System.out.println(name + " " + entityName + " " + ScapecraftEntities.entities.contains(name) + " " + entity);
		if(!name.equals(entityName) && ScapecraftEntities.entities.contains(name))
		{
			entityName = name;
			try
			{
				entity = (EntityScapecraft) ScapecraftEntities.entityNames.get(entityName.toLowerCase()).getConstructor(new Class[] { World.class }).newInstance(new Object[] { null });
				entity.setWorld(Minecraft.getMinecraft().thePlayer.worldObj);
				this.textureNumberField.setMax(ScapecraftEntities.getTextureCount(entity.getClass()));
				texture = this.textureNumberField.value;
				entity.setTexture(texture);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void mouseClicked(int x, int y, int button) throws IOException
	{
		super.mouseClicked(x, y, button);
		this.entityNameTextField.mouseClicked(x, y, button);
		this.spawnIntervalNumberField.mouseClicked(x, y, button);
		this.maxSpawnNumberField.mouseClicked(x, y, button);
		this.textureNumberField.mouseClicked(x, y, button);
		this.radiusNumberField.mouseClicked(x, y, button);
	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		if(button.id == 0)
		{
			if (entityNameTextField.getText().indexOf(' ') != -1 && !ScapecraftEntities.entityNames.containsKey(entityNameTextField.getText().toLowerCase().substring(0, entityNameTextField.getText().indexOf(' '))))
			{
				return;
			}
			te.entityName = entityNameTextField.getText();
			int spawnInterval = spawnIntervalNumberField.value;
			te.spawnInterval = spawnInterval * 20;
			te.maxSpawn = maxSpawnNumberField.value;
			te.radius = radiusNumberField.value;
			te.texture = textureNumberField.value;
			TileEntityUpdatePacket packet = new TileEntityUpdatePacket(te);
			Scapecraft.network.sendToServer(packet);

			this.mc.displayGuiScreen(null);
		}
		else if(button.id == 1)
		{
			MobSpawnerKillPacket packet = new MobSpawnerKillPacket((te));
			Scapecraft.network.sendToServer(packet);
		}
	}

	private void drawBackgroundTexture(int x, int y)
	{
		int currentX = x;
		this.drawTexturedModalRect(x, y, 0, 0, 16, 16);
		for(currentX += 16; currentX + 16 < x + GuiSpawner.guiWidth; currentX += 16)
		{
			this.drawTexturedModalRect(currentX, y, 16, 0, 16, 16);
		}
		this.drawTexturedModalRect(x + GuiSpawner.guiWidth - 16, y, 32, 0, 16, 16);
		currentX = x;

		for(int currentY = y + 16; currentY + 16 < y + GuiSpawner.guiHeight; currentY += 16)
		{
			this.drawTexturedModalRect(x, currentY, 0, 16, 16, 16);
			for(currentX += 16; currentX + 16 < x + GuiSpawner.guiWidth; currentX += 16)
			{
				this.drawTexturedModalRect(currentX, currentY, 16, 16, 16, 16);
			}
			this.drawTexturedModalRect(x + GuiSpawner.guiWidth - 16, currentY, 32, 16, 16, 16);
			currentX = x;
		}

		this.drawTexturedModalRect(x, y + GuiSpawner.guiHeight - 16, 0, 32, 16, 16);
		for(currentX += 16; currentX + 16 < x + GuiSpawner.guiWidth; currentX += 16)
		{
			this.drawTexturedModalRect(currentX, y + GuiSpawner.guiHeight - 16, 16, 32, 16, 16);
		}
		this.drawTexturedModalRect(x + GuiSpawner.guiWidth - 16, y + GuiSpawner.guiHeight - 16, 32, 32, 16, 16);
	}
}
