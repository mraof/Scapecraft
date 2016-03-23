package scapecraft.client.model.weapon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChaoticMaul extends ModelBase
{
	//fields
	ModelRenderer a1;
	ModelRenderer a2;
	ModelRenderer a3;
	ModelRenderer a4;
	ModelRenderer a5;
	ModelRenderer a6;
	ModelRenderer a7;
	ModelRenderer a8;
	ModelRenderer a9;
	ModelRenderer a10;
	ModelRenderer a11;
	ModelRenderer a12;
	ModelRenderer a13;
	ModelRenderer a14;
	ModelRenderer a15;
	ModelRenderer a16;
	ModelRenderer a17;
	ModelRenderer a18;

	public ModelChaoticMaul()
	{
		textureWidth = 128;
		textureHeight = 64;

		a1 = new ModelRenderer(this, 108, 0);
		a1.addBox(0F, 0F, 0F, 5, 25, 5);
		a1.setRotationPoint(-2F, -61F, -2F);
		a1.setTextureSize(128, 64);
		a1.mirror = true;
		setRotation(a1, 0F, 0F, 0F);
		a2 = new ModelRenderer(this, 88, 0);
		a2.addBox(-1F, 0F, 0F, 5, 25, 5);
		a2.setRotationPoint(-2F, -36F, -2F);
		a2.setTextureSize(128, 64);
		a2.mirror = true;
		setRotation(a2, 0F, 0F, 0.1047198F);
		a3 = new ModelRenderer(this, 68, 0);
		a3.addBox(-0.7F, -1F, 0F, 5, 25, 5);
		a3.setRotationPoint(-5F, -11F, -2F);
		a3.setTextureSize(128, 64);
		a3.mirror = true;
		setRotation(a3, 0F, 0F, 0.1396263F);
		a4 = new ModelRenderer(this, 68, 30);
		a4.addBox(0F, 0F, 0F, 7, 15, 7);
		a4.setRotationPoint(-3F, -50F, -3F);
		a4.setTextureSize(128, 64);
		a4.mirror = true;
		setRotation(a4, 0F, 0F, 0.0698132F);
		a5 = new ModelRenderer(this, 0, 47);
		a5.addBox(-6F, 0F, 0F, 9, 8, 9);
		a5.setRotationPoint(-4F, 4F, -4F);
		a5.setTextureSize(128, 64);
		a5.mirror = true;
		setRotation(a5, 0F, 0F, 0.122173F);
		a6 = new ModelRenderer(this, 96, 30);
		a6.addBox(0F, 0F, 0F, 9, 8, 9);
		a6.setRotationPoint(-4F, -69F, -4F);
		a6.setTextureSize(128, 64);
		a6.mirror = true;
		setRotation(a6, 0F, 0F, 0F);
		a7 = new ModelRenderer(this, 46, 4);
		a7.addBox(-2F, -8F, 0F, 1, 1, 1);
		a7.setRotationPoint(0F, 0F, 0F);
		a7.setTextureSize(128, 64);
		a7.mirror = true;
		setRotation(a7, 0F, 0F, 0F);
		a8 = new ModelRenderer(this, 56, 53);
		a8.addBox(0F, 0F, 0F, 19, 6, 5);
		a8.setRotationPoint(-7F, -68F, -2F);
		a8.setTextureSize(128, 64);
		a8.mirror = true;
		setRotation(a8, 0F, 0F, 0F);
		a9 = new ModelRenderer(this, 38, 24);
		a9.addBox(0F, 0F, 0F, 6, 19, 9);
		a9.setRotationPoint(9F, -74F, -4F);
		a9.setTextureSize(128, 64);
		a9.mirror = true;
		setRotation(a9, 0F, 0F, 0F);
		a10 = new ModelRenderer(this, 0, 0);
		a10.addBox(0F, 0F, 0F, 6, 17, 5);
		a10.setRotationPoint(13F, -73F, -2F);
		a10.setTextureSize(128, 64);
		a10.mirror = true;
		setRotation(a10, 0F, 0F, 0F);
		a11 = new ModelRenderer(this, 22, 0);
		a11.addBox(0F, 0F, 0F, 2, 2, 2);
		a11.setRotationPoint(15F, -75F, 3F);
		a11.setTextureSize(128, 64);
		a11.mirror = true;
		setRotation(a11, 0F, 0F, 0F);
		a12 = new ModelRenderer(this, 54, 0);
		a12.addBox(-3F, 0F, -0.5F, 2, 2, 2);
		a12.setRotationPoint(0F, 0F, 0F);
		a12.setTextureSize(128, 64);
		a12.mirror = true;
		setRotation(a12, 0F, 0F, 0F);
		a13 = new ModelRenderer(this, 46, 0);
		a13.addBox(-3F, -5F, -0.5F, 2, 2, 2);
		a13.setRotationPoint(0F, 0F, 0F);
		a13.setTextureSize(128, 64);
		a13.mirror = true;
		setRotation(a13, 0F, 0F, 0F);
		a14 = new ModelRenderer(this, 38, 0);
		a14.addBox(0F, 0F, 0F, 2, 2, 2);
		a14.setRotationPoint(16F, -63F, -4F);
		a14.setTextureSize(128, 64);
		a14.mirror = true;
		setRotation(a14, 0F, 0F, 0F);
		a15 = new ModelRenderer(this, 38, 4);
		a15.addBox(0F, 0F, 0F, 2, 2, 2);
		a15.setRotationPoint(16F, -57F, 3F);
		a15.setTextureSize(128, 64);
		a15.mirror = true;
		setRotation(a15, 0F, 0F, 0F);
		a16 = new ModelRenderer(this, 30, 0);
		a16.addBox(0F, 0F, 0F, 2, 2, 2);
		a16.setRotationPoint(18F, -67F, 2F);
		a16.setTextureSize(128, 64);
		a16.mirror = true;
		setRotation(a16, 0F, 0F, 0F);
		a17 = new ModelRenderer(this, 0, 27);
		a17.addBox(0F, 0F, -2F, 6, 15, 5);
		a17.setRotationPoint(-11F, -72F, 0F);
		a17.setTextureSize(128, 64);
		a17.mirror = true;
		setRotation(a17, 0F, 0F, 0F);
		a18 = new ModelRenderer(this, 36, 53);
		a18.addBox(0F, 0F, 0F, 5, 6, 5);
		a18.setRotationPoint(-2F, -73F, -2F);
		a18.setTextureSize(128, 64);
		a18.mirror = true;
		setRotation(a18, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		a1.render(f5);
		a2.render(f5);
		a3.render(f5);
		a4.render(f5);
		a5.render(f5);
		a6.render(f5);
		a7.render(f5);
		a8.render(f5);
		a9.render(f5);
		a10.render(f5);
		a11.render(f5);
		a12.render(f5);
		a13.render(f5);
		a14.render(f5);
		a15.render(f5);
		a16.render(f5);
		a17.render(f5);
		a18.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
