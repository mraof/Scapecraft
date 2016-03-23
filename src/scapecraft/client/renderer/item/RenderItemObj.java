package scapecraft.client.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

/**
 * Created by mraof on 2016 March 02.
 */
public class RenderItemObj implements IItemRenderer
{
    private final IModelCustom model;
    private final ResourceLocation texture;
    public float scale;
    float rotationZ = 40;

    public RenderItemObj(String modelName, String textureName)
    {
        this.model = AdvancedModelLoader.loadModel(new ResourceLocation("scapecraft", "models/" + modelName + ".obj"));
        this.texture = new ResourceLocation("scapecraft", "textures/models/" + textureName + ".png");
        try
        {
            Minecraft.getMinecraft().getResourceManager().getResource(this.texture);
        } catch (IOException e)
        {
            System.err.printf("Missing obj texture: %s%n", this.texture);
        }
    }

    /**
     * Checks if this renderer should handle a specific item's render type
     *
     * @param item The item we are trying to render
     * @param type A render type to check if this renderer handles
     * @return true if this renderer should handle the given render type,
     * otherwise false
     */

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return type != ItemRenderType.INVENTORY;
    }

    /**
     * Checks if certain helper functionality should be executed for this renderer.
     * See ItemRendererHelper for more info
     *
     * @param type   The render type
     * @param item   The ItemStack being rendered
     * @param helper The type of helper functionality to be ran
     * @return True to run the helper functionality, false to not.
     */
    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return false;
    }

    /**
     * Called to do the actual rendering, see ItemRenderType for details on when specific
     * types are run, and what extra data is passed into the data parameter.
     *
     * @param type The render type
     * @param item The ItemStack being rendered
     * @param data Extra Type specific data
     */
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        GL11.glTranslatef(0.75f, 0.17f, 0);
        GL11.glRotatef(rotationZ, 0.0F, 0.0F, 1.0F);
        model.renderAll();
        GL11.glPopMatrix();
    }
}
