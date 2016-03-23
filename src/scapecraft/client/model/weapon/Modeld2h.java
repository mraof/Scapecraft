package scapecraft.client.model.weapon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Modeld2h extends ModelBase
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
	ModelRenderer a19;
	ModelRenderer a20;
	ModelRenderer Shape1;

	public Modeld2h()
	{
		textureWidth = 128;
		textureHeight = 64;

		a1 = new ModelRenderer(this, 55, 42);
		a1.addBox(0F, -3F, 0F, 3, 17, 4);
		a1.setRotationPoint(1F, 3F, 0F);
		a1.setTextureSize(128, 64);
		a1.mirror = true;
		setRotation(a1, 0F, 0F, 0F);
		a2 = new ModelRenderer(this, 15, 56);
		a2.addBox(0F, 0F, 0F, 15, 3, 4);
		a2.setRotationPoint(-5.5F, -3F, 0F);
		a2.setTextureSize(128, 64);
		a2.mirror = true;
		setRotation(a2, 0F, 0F, 0F);
		a3 = new ModelRenderer(this, 15, 48);
		a3.addBox(0F, 0F, 0F, 8, 3, 4);
		a3.setRotationPoint(-11.5F, -6F, 0F);
		a3.setTextureSize(128, 64);
		a3.mirror = true;
		setRotation(a3, 0F, 0F, 0.418879F);
		a4 = new ModelRenderer(this, 15, 40);
		a4.addBox(0F, 0F, 0F, 8, 3, 4);
		a4.setRotationPoint(8F, -2.7F, 0F);
		a4.setTextureSize(128, 64);
		a4.mirror = true;
		setRotation(a4, 0F, 0F, -0.418879F);
		a5 = new ModelRenderer(this, 100, 0);
		a5.addBox(0F, 0F, 0F, 5, 20, 2);
		a5.setRotationPoint(0F, -23F, 1F);
		a5.setTextureSize(128, 64);
		a5.mirror = true;
		setRotation(a5, 0F, 0F, 0F);
		a6 = new ModelRenderer(this, 61, 0);
		a6.addBox(0F, 0F, 0F, 2, 11, 2);
		a6.setRotationPoint(5F, -14F, 1F);
		a6.setTextureSize(128, 64);
		a6.mirror = true;
		setRotation(a6, 0F, 0F, 0.1745329F);
		a7 = new ModelRenderer(this, 52, 0);
		a7.addBox(0F, 0F, 0F, 2, 11, 2);
		a7.setRotationPoint(-2F, -14F, 1F);
		a7.setTextureSize(128, 64);
		a7.mirror = true;
		setRotation(a7, 0F, 0F, -0.1745329F);
		a8 = new ModelRenderer(this, 34, 0);
		a8.addBox(0F, 0F, 0F, 2, 11, 2);
		a8.setRotationPoint(0F, -24.9F, 1F);
		a8.setTextureSize(128, 64);
		a8.mirror = true;
		setRotation(a8, 0F, 0F, 0.1745329F);
		a9 = new ModelRenderer(this, 43, 0);
		a9.addBox(0F, 0F, 0F, 2, 11, 2);
		a9.setRotationPoint(3F, -24F, 1F);
		a9.setTextureSize(128, 64);
		a9.mirror = true;
		setRotation(a9, 0F, 0F, -0.1745329F);
		a10 = new ModelRenderer(this, 25, 0);
		a10.addBox(0F, 0F, 0F, 2, 11, 2);
		a10.setRotationPoint(5F, -34F, 1F);
		a10.setTextureSize(128, 64);
		a10.mirror = true;
		setRotation(a10, 0F, 0F, 0.1745329F);
		a11 = new ModelRenderer(this, 85, 0);
		a11.addBox(0F, 0F, 0F, 5, 20, 2);
		a11.setRotationPoint(0F, -43F, 1F);
		a11.setTextureSize(128, 64);
		a11.mirror = true;
		setRotation(a11, 0F, 0F, 0F);
		a12 = new ModelRenderer(this, 16, 0);
		a12.addBox(0F, 0F, 0F, 2, 11, 2);
		a12.setRotationPoint(-2F, -34F, 1F);
		a12.setTextureSize(128, 64);
		a12.mirror = true;
		setRotation(a12, 0F, 0F, -0.1745329F);
		a13 = new ModelRenderer(this, 61, 14);
		a13.addBox(0F, 0F, -1F, 2, 11, 2);
		a13.setRotationPoint(0F, -44.9F, 2F);
		a13.setTextureSize(128, 64);
		a13.mirror = true;
		setRotation(a13, 0F, 0F, 0.1745329F);
		a14 = new ModelRenderer(this, 16, 14);
		a14.addBox(0F, 0F, 0F, 2, 11, 2);
		a14.setRotationPoint(3F, -44F, 1F);
		a14.setTextureSize(128, 64);
		a14.mirror = true;
		setRotation(a14, 0F, 0F, -0.1745329F);
		a15 = new ModelRenderer(this, 70, 0);
		a15.addBox(0F, 0F, 0F, 5, 23, 2);
		a15.setRotationPoint(0F, -66F, 1F);
		a15.setTextureSize(128, 64);
		a15.mirror = true;
		setRotation(a15, 0F, 0F, 0F);
		a16 = new ModelRenderer(this, 25, 14);
		a16.addBox(0F, 0F, 0F, 2, 11, 2);
		a16.setRotationPoint(0.2F, -65.9F, 1F);
		a16.setTextureSize(128, 64);
		a16.mirror = true;
		setRotation(a16, 0F, 0F, 0.1745329F);
		a17 = new ModelRenderer(this, 52, 14);
		a17.addBox(0F, -3F, -2F, 2, 11, 2);
		a17.setRotationPoint(-1F, -52F, 3F);
		a17.setTextureSize(128, 64);
		a17.mirror = true;
		setRotation(a17, 0F, 0F, -0.1745329F);
		a18 = new ModelRenderer(this, 43, 14);
		a18.addBox(0F, 0F, -1F, 2, 11, 2);
		a18.setRotationPoint(5F, -55F, 2F);
		a18.setTextureSize(128, 64);
		a18.mirror = true;
		setRotation(a18, 0F, 0F, 0.1745329F);
		a19 = new ModelRenderer(this, 34, 14);
		a19.addBox(0F, 0F, 0F, 2, 11, 2);
		a19.setRotationPoint(3F, -65F, 1F);
		a19.setTextureSize(128, 64);
		a19.mirror = true;
		setRotation(a19, 0F, 0F, -0.1745329F);
		a20 = new ModelRenderer(this, 0, 0);
		a20.addBox(0F, 0F, 0F, 3, 60, 4);
		a20.setRotationPoint(1F, -63F, 0F);
		a20.setTextureSize(128, 64);
		a20.mirror = true;
		setRotation(a20, 0F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape1.setRotationPoint(0F, 0F, 0F);
		Shape1.setTextureSize(128, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
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
		a19.render(f5);
		a20.render(f5);
		Shape1.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
