package scapecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;
import scapecraft.entity.EntityScapecraft;

public class RenderBipedScapecraft extends RenderBiped
{
	float scale = 1F;
	
	public RenderBipedScapecraft()
	{
		super(new ModelBiped(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return ((EntityScapecraft)entity).getTexture();
	}

	public RenderBipedScapecraft setScale(float scale)
	{
		this.scale = scale;
		return this;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityLiving, float f)
	{
		float currentScale = scale * ((EntityScapecraft)entityLiving).getScale();
		GL11.glScalef(currentScale, currentScale, currentScale);
	}

	@Override
	protected void passSpecialRender(EntityLivingBase entity, double x, double y, double z)
	{
		if(MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Pre(entity, this, x, y, z)))
		{
			return;
		}
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);

		double distance = entity.getDistanceSqToEntity(this.renderManager.livingPlayer);
		float range = entity.isSneaking() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;

		if(distance < (double)(range * range) && this.renderManager.livingPlayer.canEntityBeSeen(entity))
		{
			RenderHelpers.renderNametagWithLevel(entity, x, y, z, this, this.renderManager, ((EntityScapecraft) entity).getLevel());
		}
		MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Post(entity, this, x, y, z));
	}
}
