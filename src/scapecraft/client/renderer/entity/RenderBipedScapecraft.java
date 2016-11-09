package scapecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;
import scapecraft.entity.EntityScapecraft;

public class RenderBipedScapecraft extends RenderBiped<EntityScapecraft>
{
	float scale = 1F;
	
	public RenderBipedScapecraft(RenderManager manager, ModelBiped model, float shadowSize)
	{
		super(manager, model, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityScapecraft entity)
	{
		return entity.getTexture();
	}

	public RenderBipedScapecraft setScale(float scale)
	{
		this.scale = scale;
		return this;
	}

	@Override
	protected void preRenderCallback(EntityScapecraft entityLiving, float f)
	{
		float currentScale = scale * entityLiving.getScale();
		GL11.glScalef(currentScale, currentScale, currentScale);
	}

	@Override
	public void renderName(EntityScapecraft entity, double x, double y, double z)
	{
		if(MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Pre<EntityScapecraft>(entity, this, x, y, z)))
		{
			return;
		}
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);

		double distance = entity.getDistanceSqToEntity(this.renderManager.renderViewEntity);
		float range = entity.isSneaking() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;

		if(distance < (double)(range * range) && entity.canEntityBeSeen(this.renderManager.renderViewEntity))
		{
			RenderHelpers.renderNametagWithLevel(entity, x, y, z, this, this.renderManager, entity.getLevel());
		}
		MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Post<EntityScapecraft>(entity, this, x, y, z));
	}
}
