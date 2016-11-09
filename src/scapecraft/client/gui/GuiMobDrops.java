package scapecraft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import scapecraft.Scapecraft;
import scapecraft.entity.Drop;
import scapecraft.inventory.ContainerMobDrops;
import scapecraft.inventory.ContainerScapecraft;
import scapecraft.network.DropsPacket;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mraof on 2016 March 05 at 3:42 PM.
 */
public class GuiMobDrops extends GuiContainerScapecraft
{
    private final ResourceLocation background = new ResourceLocation("scapecraft", "textures/gui/Drops.png");
    private final ContainerMobDrops container;
    private int yOffset = 0;
    ArrayList<GuiNumberField> chances = new ArrayList<GuiNumberField>();
    GuiButton saveButton;
    public GuiMobDrops(ContainerMobDrops container)
    {
        super(container);
        this.container = container;
        this.xSize = 262;
        this.ySize = 90;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui()
    {
        super.initGui();
        for(int i = 0; i < chances.size(); i++)
        {
            chances.get(i).yPosition = guiTop + yOffset + 26 * i + 4;
        }
        saveButton = new GuiButton(0, guiLeft + 199, guiTop + chances.size() * 26 + 3, 59, 20, "Save");
        //noinspection unchecked
        buttonList.add(saveButton);
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int scroll = -Mouse.getEventDWheel() / 4;
        if(scroll != 0)
        {
            yOffset = ((yOffset - scroll) < 0) ? (((yOffset - scroll) > (((container.inventorySlots.size() - 1 - ContainerScapecraft.PLAYER_INV_SIZE) * -26) + this.ySize)) ? (yOffset - scroll) : (((inventorySlots.inventorySlots.size() - 1 - ContainerScapecraft.PLAYER_INV_SIZE) * -26) + this.ySize)) : 0;
            for(int i = 0; i < container.inventorySlots.size() - ContainerScapecraft.PLAYER_INV_SIZE; i++)
            {
                container.inventorySlots.get(i + ContainerScapecraft.PLAYER_INV_SIZE).yDisplayPosition = yOffset + 26 * (i) + 5;
            }
            for(int i = 0; i < chances.size(); i++)
            {
                chances.get(i).yPosition = guiTop + yOffset + 26 * i + 4;
            }
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(background);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, 176, this.ySize);
        int i;
        for(i = 0; i < container.inventorySlots.size() - ContainerScapecraft.PLAYER_INV_SIZE; i++)
        {
            this.drawTexturedModalRect(guiLeft + 176, 26 * i + yOffset + guiTop, 0, ySize, 86, 26);
        }
        int chanceSize = container.inventoryDrops.chances.size();
        while (chances.size() > chanceSize)
        {
            chances.remove(chances.size() - 1);
        }
        for(i = 0; i < chanceSize; i++)
        {
            if (i < container.inventoryDrops.chances.size())
            {
                if (chances.size() == i)
                {
                    chances.add(new GuiNumberField(i, this.fontRendererObj, guiLeft + 199, container.inventorySlots.get(i + ContainerScapecraft.PLAYER_INV_SIZE).yDisplayPosition + guiTop, 58, 18));
                    chances.get(i).setValue(container.inventoryDrops.chances.get(i));
                }
                if (!container.inventoryDrops.chances.get(i).equals(chances.get(i).value))
                {
                    chances.get(i).setValue(container.inventoryDrops.chances.get(i));
                    chances.get(i).yPosition = guiTop + yOffset + 26 * i + 4;
                }
                chances.get(i).drawTextBox();
            }
            saveButton.yPosition = guiTop + yOffset + 26 * chanceSize + 3;
        }
        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    }

    @Override
    protected void mouseClicked(int x, int y, int button) throws IOException {
        super.mouseClicked(x, y, button);
        for (GuiNumberField chance : chances)
        {
            chance.mouseClicked(x, y, button);
        }
    }

    @Override
    protected void keyTyped(char character, int key) throws IOException {
        super.keyTyped(character, key);
        for (int i = 0; i < chances.size(); i++)
        {
            container.inventoryDrops.chances.set(i, chances.get(i).keyTypedNumber(character, key));
        }
    }

    @Override
    protected void actionPerformed(GuiButton button)
    {
        ArrayList<Drop> drops = new ArrayList<Drop>();
        for (int i = 0; i < container.inventoryDrops.chances.size(); i++)
        {
            drops.add(new Drop(container.inventoryDrops.getStackInSlot(i), container.inventoryDrops.chances.get(i), true));
        }
        DropsPacket packet = new DropsPacket(drops);
        Scapecraft.network.sendToServer(packet);
    }
}
