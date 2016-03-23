package scapecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ResourceLocation;
import scapecraft.entity.EntityDrop;

/**
 * Created by mraof on 2016 March 02.
 */
public class RenderEntityDrop extends Render
{
    public RenderEntityDrop()
    {
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float f, float f1)
    {
        EntityDrop entityDrop = (EntityDrop) entity;
        this.renderLivingLabel(entity, entityDrop.owner, x, y, z, 64);
        for(EntityItem item : entityDrop.items)
        {
            this.renderManager.renderEntityWithPosYaw(item, x, y, z, f, f1);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return null;
    }
}
