package scapecraft.client.renderer.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;
import scapecraft.client.Resources;
import scapecraft.client.model.block.ModelFire;


public class RenderFire extends TileEntitySpecialRenderer
{

	//The model of your block
	private final ModelFire model;

	public RenderFire() {
		this.model = new ModelFire();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 2.7F, (float) z + 0.5F);
		float scale1 = 1.75F;
		GL11.glScalef(scale1,scale1,scale1);
		Minecraft.getMinecraft().renderEngine.bindTexture(Resources.TEXTURE_FIRE);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
