package scapecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

@SideOnly(Side.CLIENT)
public class GuiHealth extends Gui
{
	private Minecraft mc = Minecraft.getMinecraft();
	private static ResourceLocation statIcons = new ResourceLocation("scapecraft", "textures/gui/StatIcons.png");
	public static int balance = 0;
	public static int realBalance = 0;

	public void drawHealthBar(ScaledResolution resolution)
	{
		int width = resolution.getScaledWidth();
		int height = resolution.getScaledHeight();
		this.mc.mcProfiler.startSection("health");
		
		float maxHealth = (float) this.mc.thePlayer.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getAttributeValue();
		float health = this.mc.thePlayer.getHealth();
		float absorb = this.mc.thePlayer.getAbsorptionAmount();
		health += absorb;
		int green = ((int) (health / maxHealth * 0xFF)) << 8;
		int healthColor = ((green > 0x00FF00 ? 0x00FF00 : green & 0x00FF00) | ((green & 0xFF0000) >> 9) | ((maxHealth - health > 0 ? (int) ((maxHealth - health) / maxHealth * 0xFF) << 16 : 0) & 0xFF0000)) & 0xFFFFFF;
		if(this.mc.thePlayer.isPotionActive(MobEffects.POISON))
		{
			healthColor = healthColor & 0xcccccc;
		}
		if(this.mc.thePlayer.isPotionActive(MobEffects.WITHER))
		{
			healthColor = healthColor & 0x444444;
		}

		int x = width / 2 - 83;
		int y = height - GuiIngameForge.left_height;

		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		this.mc.getTextureManager().bindTexture(statIcons);
		this.drawTexturedModalRect(width - 118, y + 18, 16, 0, 16, 16);
		//this.drawTexturedModalRect(width - 118, y + 3, 64, 0, 16, 16);
		//this.drawTexturedModalRect(width - 118, y + 18, 32, 0, 16, 16);
		if(balance != realBalance)
		{
			int difference = (realBalance - balance);
			balance += difference / 20 + Math.signum(difference);
		}
		if(Stats.clientStats.get(Stat.ATTACK) != null)
		{
			//this.mc.fontRendererObj.drawStringWithShadow("Special: " + Stats.getEnergy(Minecraft.getMinecraft().thePlayer) + "/" + 100, x, y - 10, 0xFFFFFF);
			Integer combatLevel = Stats.getCombatLevel(mc.thePlayer);
			this.mc.fontRendererObj.drawStringWithShadow("Combat: " + combatLevel, width - 100, y + 22, 0xFFFFFF);
			this.mc.fontRendererObj.drawStringWithShadow("Money: " + balance, width - 100, y + 7, 0xFFFFFF);
		}
		this.mc.fontRendererObj.drawStringWithShadow("HP: " + String.format("%.1f", health) + "/" + maxHealth, x, y, healthColor);
		GL11.glColor4f(1, 1, 1, 1);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glPopMatrix();

		mc.getTextureManager().bindTexture(Gui.ICONS);
		GuiIngameForge.left_height += 20;

		this.mc.mcProfiler.endSection();
	}
}
