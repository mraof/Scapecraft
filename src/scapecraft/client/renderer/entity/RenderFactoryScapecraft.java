package scapecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import scapecraft.entity.EntityScapecraft;

/**
 * Created by mraof on 2016 July 04 at 11:12 PM.
 */
public class RenderFactoryScapecraft implements IRenderFactory<EntityScapecraft>
{
    private final ModelBase model;
    private float shadowSize = 0.5F;
    private float scale = 1.0F;
    private float x = 0F;
    private float y = 0F;
    private float z = 0F;

    public RenderFactoryScapecraft(ModelBase model)
    {
        this.model = model;
    }

    @Override
    public Render<? super EntityScapecraft> createRenderFor(RenderManager manager)
    {
        RenderEntityScapecraft renderer = new RenderEntityScapecraft(manager, model, shadowSize);
        renderer.setScale(scale);
        renderer.setOffset(x, y, z);
        return renderer;
    }

    public RenderFactoryScapecraft setShadowSize(float shadowSize)
    {
        this.shadowSize = shadowSize;
        return this;
    }

    public RenderFactoryScapecraft setScale(float scale)
    {
        this.scale = scale;
        return this;
    }

    public RenderFactoryScapecraft setOffset(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }
}
