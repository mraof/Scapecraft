package scapecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;
import scapecraft.entity.EntityScapecraft;

public class RenderEntityScapecraft extends RenderLiving
{
	float scale = 1F;
	float xOffset = 0F;
	float yOffset = 0F;
	float zOffset = 0F;
	public RenderEntityScapecraft(ModelBase modelBase, float shadowSize)
	{
		super(modelBase, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return ((EntityScapecraft)entity).getTexture();
	}

	public RenderEntityScapecraft setScale(float scale)
	{
		this.scale = scale;
		return this;
	}

	public RenderEntityScapecraft setOffset(float x, float y, float z)
	{
		this.xOffset = x;
		this.yOffset = y;
		this.zOffset = z;
		return this;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityLiving, float f)
	{
		float currentScale = scale * ((EntityScapecraft)entityLiving).getScale();
		GL11.glScalef(currentScale, currentScale, currentScale);
		GL11.glTranslatef(xOffset, yOffset, zOffset);
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
