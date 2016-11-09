package scapecraft.client.renderer.entity;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;
import scapecraft.entity.EntityGenericBiped;

import java.util.Map;

public class RenderGenericBiped extends RenderBiped<EntityGenericBiped>
{
	public RenderGenericBiped(RenderManager manager)
	{
		super(manager, new ModelBiped(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGenericBiped entity)
	{
		ResourceLocation texture = AbstractClientPlayer.getLocationSkin(entity.getName());
		
		if(entity.profile != null)
		{
			Minecraft minecraft = Minecraft.getMinecraft();
			@SuppressWarnings("rawtypes")
			Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = minecraft.getSkinManager().loadSkinFromCache(entity.profile);

			if(map.containsKey(MinecraftProfileTexture.Type.SKIN))
			{
				texture = minecraft.getSkinManager().loadSkin(map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN);
			}
		}
		return texture;
	}

	@Override
	public void renderName(EntityGenericBiped entity, double x, double y, double z)
	{
		if(MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Pre<EntityGenericBiped>(entity, this, x, y, z)))
		{
			return;
		}
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);

		float f1 = 0.0266666688F;
		double distance = entity.getDistanceSqToEntity(this.renderManager.renderViewEntity);
		float range = entity.isSneaking() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;

		if(distance < (double)(range * range))
		{
			String s = entity.getDisplayName().getFormattedText();
			this.renderEntityName(entity, x, y, z, s, f1);
		}

		MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Post<EntityGenericBiped>(entity, this, x, y, z));
	}
}
