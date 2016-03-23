package scapecraft.client.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

public class RenderItemWeapon implements IItemRenderer
{
	ModelBase model;
	ResourceLocation texture;
	public float scale;
	float rotationX = 0;
	float rotationY = 0;
	float rotationZ = 0;
	float offsetX = 0F;
	float offsetY = 0F;
	float offsetZ = 0F;

	public RenderItemWeapon(ModelBase model, ResourceLocation texture, float scale)
	{
		this(model, texture, scale, 0F);
	}

	public RenderItemWeapon(ModelBase model, ResourceLocation texture, float scale, float rotationZ)
	{
		this.model = model;
		this.texture = texture;
		this.scale = scale;
		this.rotationZ = rotationZ;
		try
		{
			Minecraft.getMinecraft().getResourceManager().getResource(this.texture);
		} catch (IOException e)
		{
			System.err.printf("Missing item texture: %s%n", this.texture);
		}
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return type != ItemRenderType.INVENTORY;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	public RenderItemWeapon setOffset(float x, float y, float z)
	{
		this.offsetX = x;
		this.offsetY = y;
		this.offsetZ = z;
		return this;
	}

	public RenderItemWeapon setRotation(float x, float y, float z)
	{
		this.rotationX = x;
		this.rotationY = y;
		this.rotationZ = z;
		return this;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();
		if(RenderManager.instance.renderEngine == null)
		{
			return;
		}

		switch(type)
		{
		case ENTITY:
			break;
		case EQUIPPED:
			break;
		case EQUIPPED_FIRST_PERSON:
			break;
		case INVENTORY:
			break;
		case FIRST_PERSON_MAP:
			//This is not a map, so it should never happen
		}

		RenderManager.instance.renderEngine.bindTexture(texture);
		GL11.glScalef(scale, scale, scale);
		GL11.glTranslatef(offsetX, offsetY, offsetZ);
		GL11.glRotatef(rotationZ, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(rotationY, -MathHelper.sin(rotationZ), MathHelper.cos(rotationZ), 0.0F);
		GL11.glRotatef(rotationX, 1.0F, 0.0F, 0.0F);
		model.render(null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
		GL11.glPopMatrix();
	}
}
