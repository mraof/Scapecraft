package scapecraft.client.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import scapecraft.entity.ScapecraftEntities;

public class RenderItemSpawnEgg implements IItemRenderer
{
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		if(ScapecraftEntities.entityObjects.size() <= item.getMetadata())
		{
			return;
		}

		Entity entity = ScapecraftEntities.entityObjects.get(item.getMetadata());
		entity.setWorld(Minecraft.getMinecraft().thePlayer.worldObj);
		GL11.glPushMatrix();
		if(type == ItemRenderType.INVENTORY)
		{
			float scaleFactor = 1F / (entity.height > entity.width ? entity.height : entity.width);
			GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
			GL11.glTranslatef(-entity.width / 2F, -entity.height / 2F, 0F);
		}
		RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, 0.05F);
		GL11.glPopMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}
}
