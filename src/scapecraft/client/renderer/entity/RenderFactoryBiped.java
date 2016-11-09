package scapecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import scapecraft.entity.EntityScapecraft;

/**
 * Created by mraof on 2016 July 04 at 11:32 PM.
 */
public class RenderFactoryBiped implements IRenderFactory<EntityScapecraft>
{
    private final ModelBiped model;
    private float scale = 1.0F;

    public RenderFactoryBiped()
    {
        model = new ModelBiped();
    }

    @Override
    public Render<? super EntityScapecraft> createRenderFor(RenderManager manager)
    {
        RenderBipedScapecraft renderer = new RenderBipedScapecraft(manager, model, 0.5F * scale);
        renderer.setScale(scale);
        return renderer;
    }

    public RenderFactoryBiped setScale(float scale)
    {
        this.scale = scale;
        return this;
    }
}
