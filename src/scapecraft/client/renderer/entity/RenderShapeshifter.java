package scapecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import scapecraft.entity.EntityShapeshifter;

public class RenderShapeshifter extends Render<EntityShapeshifter>
{
	public RenderShapeshifter(RenderManager renderManager)
	{
		super(renderManager);
	}

	@Override
	public void doRender(EntityShapeshifter entity, double x, double y, double z, float f, float f1)
	{
		renderManager.getEntityRenderObject(entity.copiedMob)
				.doRender(entity.copiedMob, x, y, z, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityShapeshifter entity)
	{
		return null;
	}
}
