package scapecraft.client.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;
import scapecraft.util.Stats;

/**
 * Created by mraof on 2016 March 02.
 */
public class RenderHelpers
{
    public static void renderNametagWithLevel(EntityLivingBase entity, double x, double y, double z, Render render, RenderManager renderManager, int level)
    {
            float f1 = 0.0266666688F;
            int playerLevel = Stats.getCombatLevel(Minecraft.getMinecraft().thePlayer);
            String label = entity.getFormattedCommandSenderName().getFormattedText() + " " + level;
            int color = playerLevel - level > 20 ? 0x00FF00 : playerLevel - level < -20 ? 0xFF0000 : ((playerLevel - level + 20) * 0xFF / 40) << 8 | ((level - playerLevel + 20) * 0xFF / 40) << 16;

            FontRenderer fontrenderer = render.getFontRendererFromRenderManager();
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.0F, (float) y + entity.height + 0.5F, (float) z);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
            GL11.glScalef(-f1, -f1, f1);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);

            fontrenderer.drawString(label, -fontrenderer.getStringWidth(label) / 2, 0, color);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glDepthMask(true);
            fontrenderer.drawString(label, -fontrenderer.getStringWidth(label) / 2, 0, color);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
    }
}
