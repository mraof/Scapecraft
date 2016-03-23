package scapecraft.client.renderer.entity;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;
import scapecraft.entity.EntityGenericBiped;

import java.util.Map;

public class RenderGenericBiped extends RenderBiped
{
	public RenderGenericBiped()
	{
		super(new ModelBiped(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		ResourceLocation texture = AbstractClientPlayer.locationStevePng;
		
		if(((EntityGenericBiped)entity).profile != null)
		{
			Minecraft minecraft = Minecraft.getMinecraft();
			@SuppressWarnings("rawtypes")
			Map map = minecraft.getSkinManager().loadSkinFromCache(((EntityGenericBiped)entity).profile);

			if(map.containsKey(MinecraftProfileTexture.Type.SKIN))
			{
				texture = minecraft.getSkinManager().loadSkin((MinecraftProfileTexture)map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN);
			}
		}
		return texture;
	}

	@Override
	protected void passSpecialRender(EntityLivingBase entity, double x, double y, double z)
	{
		if(MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Pre(entity, this, x, y, z)))
		{
			return;
		}
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);

		float f1 = 0.0266666688F;
		double distance = entity.getDistanceSqToEntity(this.renderManager.livingPlayer);
		float range = entity.isSneaking() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;

		if(distance < (double)(range * range))
		{
			String s = entity.getFormattedCommandSenderName().getFormattedText();
			this.renderOffsetLivingLabel(entity, x, y, z, s, f1, distance);
		}

		MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Post(entity, this, x, y, z));
	}
}
