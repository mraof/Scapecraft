package scapecraft.client.renderer.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;
import scapecraft.client.Resources;
import scapecraft.client.model.block.ModelBlockStall;
import scapecraft.tileentity.TileEntityStall;

//TODO rewrite this and make it able to rotate
public class RenderStall extends TileEntitySpecialRenderer<TileEntityStall>
{

	private final ModelBlockStall model;

	public RenderStall()
	{
		this.model = new ModelBlockStall();
	}

	@Override
	public void renderTileEntityAt(TileEntityStall te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		//The PushMatrix tells the renderer to "start" doing something.
		GL11.glPushMatrix();
		//This is setting the initial location.
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		// float scale1 = 1.75F;
		// GL11.glScalef(scale1,scale1,scale1);

		Minecraft.getMinecraft().renderEngine.bindTexture(Resources.TEXTURE_BLOCKSTALL);

		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
