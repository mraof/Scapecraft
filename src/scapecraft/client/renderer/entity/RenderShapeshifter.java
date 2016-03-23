package scapecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import scapecraft.entity.EntityShapeshifter;

public class RenderShapeshifter extends Render
{

	@Override
	public void doRender(Entity entity, double x, double y, double z, float f, float f1)
	{
		RenderManager.instance.getEntityRenderObject(((EntityShapeshifter) entity).copiedMob)
				.doRender(((EntityShapeshifter)entity).copiedMob, x, y, z, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}
}
