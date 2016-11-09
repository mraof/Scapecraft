package scapecraft.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import org.lwjgl.opengl.GL11;
import scapecraft.inventory.ContainerScapecraft;

/**
 * Created by mraof on 2016 March 02.
 */
public abstract class GuiContainerScapecraft extends GuiContainer
{
    ContainerScapecraft containerScapecraft;
    public GuiContainerScapecraft(ContainerScapecraft container)
    {
        super(container);
        this.containerScapecraft = container;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        if(containerScapecraft.previewSlots.size() > 0)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(this.guiLeft, this.guiTop, 0);
            this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.3F);
            int startSlot = containerScapecraft.inventoryScapecraft.getSizeInventory() - containerScapecraft.previewSlots.size() + ContainerScapecraft.PLAYER_INV_SIZE;
            for (int i = 0; i < containerScapecraft.previewSlots.size(); i++)
            {
                if (containerScapecraft.previewSlots.get(i) != null)
                {
                    itemRender.renderItemIntoGUI(containerScapecraft.previewSlots.get(i), containerScapecraft.getSlot(startSlot + i).xDisplayPosition, inventorySlots.getSlot(startSlot + i).yDisplayPosition);
                }
            }
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
        }
    }
}
