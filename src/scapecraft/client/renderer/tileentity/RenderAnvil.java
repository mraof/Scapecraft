package scapecraft.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created by mraof on 2016 March 02.
 */
public class RenderAnvil extends TileEntitySpecialRenderer
{
    private final IModelCustom model;
    private final ResourceLocation texture;

    public RenderAnvil()
    {
        model = AdvancedModelLoader.loadModel(new ResourceLocation("scapecraft", "models/Anvil.obj"));
        texture = new ResourceLocation("scapecraft", "textures/models/Anvil.png");
    }
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z);
        bindTexture(texture);
        model.renderAll();
        GL11.glPopMatrix();
    }
}
