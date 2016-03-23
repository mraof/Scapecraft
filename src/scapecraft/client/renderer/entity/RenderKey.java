package scapecraft.client.renderer.entity;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderKey extends Render
{
	public RenderKey()
	{
		this.shadowSize = 0.15F;
		this.shadowOpaque = 0.1F;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float f, float f1)
	{
		//EntityKey key = (EntityKey) entity;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_I(0x33C3B1, 128);
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		tessellator.addVertexWithUV(0.0D - 0.5D, 0.0D, 0.0D, (double)0, 0.25);
		tessellator.addVertexWithUV(1.0D - 0.5D, 0.0D, 0.0D, 0.25, 0.25);
		tessellator.addVertexWithUV(1.0D - 0.5D, 1.0D, 0.0D, 0.25, (double)0);
		tessellator.addVertexWithUV(0.0D - 0.5D, 1.0D, 0.0D, (double)0, (double)0);
		tessellator.draw();
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return null;
	}
}
