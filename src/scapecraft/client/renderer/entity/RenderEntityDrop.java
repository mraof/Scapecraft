package scapecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ResourceLocation;
import scapecraft.entity.EntityDrop;

/**
 * Created by mraof on 2016 March 02.
 */
public class RenderEntityDrop extends Render<EntityDrop>
{
    public RenderEntityDrop(RenderManager manager)
    {
        super(manager);
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0;
    }

    @Override
    public void doRender(EntityDrop entity, double x, double y, double z, float f, float f1)
    {
        this.renderLivingLabel(entity, entity.owner, x, y, z, 64);
        for(EntityItem item : entity.items)
        {
            this.renderManager.getEntityRenderObject(item).doRender(item, x, y, z, f, f1);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDrop entity)
    {
        return null;
    }
}
