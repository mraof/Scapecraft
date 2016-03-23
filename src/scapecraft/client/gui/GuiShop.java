package scapecraft.client.gui;

import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import scapecraft.economy.market.Listing;
import scapecraft.inventory.ContainerScapecraft;
import scapecraft.inventory.ContainerShop;

public class GuiShop extends GuiContainerScapecraft
{
    private final ContainerShop container;
    private final ResourceLocation background = new ResourceLocation("scapecraft", "textures/gui/Shop.png");

    public GuiShop(ContainerShop container)
    {
        super(container);
        this.container = container;
        this.ySize = 223;
        this.xSize = 256;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        this.mc.getTextureManager().bindTexture(background);
        if(container.tabs > 1)
        {
            for(int i = 0; i < container.tabs; i++)
            {
                if(i == container.tabNumber)
                {
                    GL11.glColor4f(1, 1, 1, 1);
                }
                else
                {
                    GL11.glColor4f(.7f, .7f, .7f, 1);
                }
                this.drawTexturedModalRect(guiLeft + 2 + i * 26, guiTop - 21, 0, this.ySize, 24, 21);
            }
        }
        GL11.glColor4f(1, 1, 1, 1);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
        for (int i = ContainerScapecraft.PLAYER_INV_SIZE; i < ContainerShop.SECTION_SIZE * 2 + ContainerScapecraft.PLAYER_INV_SIZE; i++)
        {
            if(container.getSlot(i).getStack() != null)
            {
                Listing listing = container.listings[i - ContainerScapecraft.PLAYER_INV_SIZE];
                if(listing != null)
                {
                    String price = Integer.toString(listing.price);
                    fontRendererObj.drawStringWithShadow(price, guiLeft + container.getSlot(i).xDisplayPosition + 9 - fontRendererObj.getStringWidth(price) / 2, guiTop + container.getSlot(i).yDisplayPosition + 18, 0xFFFFFF);
                    if(listing.stock != 0)
                    {
                        String stock = Integer.toString(listing.stock);
                        fontRendererObj.drawStringWithShadow(stock, guiLeft + container.getSlot(i).xDisplayPosition + 20, guiTop + container.getSlot(i).yDisplayPosition + 5, 0xFFFFFF);
                    }
                }
            }
        }
        fontRendererObj.drawStringWithShadow("Buy", guiLeft + this.xSize / 2 - fontRendererObj.getStringWidth("Buy") / 2, guiTop + 4, 0x00FF44);
        fontRendererObj.drawStringWithShadow("Sell", guiLeft + this.xSize / 2 - fontRendererObj.getStringWidth("Sell") / 2, guiTop + 72, 0x00FF44);
    }
}
