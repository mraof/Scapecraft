package scapecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.obj.WavefrontObject;
import org.lwjgl.opengl.GL11;

/**
 * Created by mraof on 2016 March 02.
 */
public class ModelBlueDragon extends ModelBase
{
    private final WavefrontObject model;
    public ModelBlueDragon()
    {
        model = (WavefrontObject) AdvancedModelLoader.loadModel(new ResourceLocation("scapecraft", "models/Test.obj"));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        GL11.glPushMatrix();
        GL11.glRotatef(180, 0, 0, 1);
        GL11.glScalef(f5, f5, f5);
        model.groupObjects.get(0).render();
        model.groupObjects.get(1).render();
        /*model.renderPart("a");
        model.renderPart("b");*/
        GL11.glPopMatrix();
    }
}
