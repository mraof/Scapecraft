package scapecraft.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import scapecraft.inventory.ContainerSmithing;
import scapecraft.inventory.InventoryScapecraft;

/**
 * Created by mraof on 2016 March 02.
 */
public class GuiSmithing extends GuiContainerScapecraft
{
    private final ResourceLocation background = new ResourceLocation("scapecraft", "textures/gui/Smithing.png");
    public GuiSmithing(InventoryPlayer inventoryPlayer, InventoryScapecraft inventory)
    {
        super(new ContainerSmithing(inventoryPlayer, inventory));
        this.ySize = 151;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(background);
        this.drawTexturedModalRect((this.width - this.xSize) / 2, (this.height - this.ySize) / 2, 0, 0, this.xSize, this.ySize);
        this.drawTexturedModalRect(this.guiLeft + 89, this.guiTop + 42, this.xSize, 0, ((ContainerSmithing)containerScapecraft).getProgress(), 16);
        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    }
}
