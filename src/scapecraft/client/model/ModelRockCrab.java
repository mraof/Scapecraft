package scapecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelRockCrab extends ModelBase
{
	//fields
	ModelRenderer Body;
	ModelRenderer B1LegH;
	ModelRenderer B1LegV;
	ModelRenderer B2LegH;
	ModelRenderer B2LegV;
	ModelRenderer B3LegH;
	ModelRenderer B3LegV;
	ModelRenderer B4LegH;
	ModelRenderer B4LegV;
	ModelRenderer F1LegH;
	ModelRenderer F1LegV;
	ModelRenderer F2LegH;
	ModelRenderer F2LegV;
	ModelRenderer F3LegH;
	ModelRenderer F3LegV;
	ModelRenderer F4LegH;
	ModelRenderer F4LegV;
	ModelRenderer BackArm;
	ModelRenderer BClaw1;
	ModelRenderer BClaw2;
	ModelRenderer FrontArm;
	ModelRenderer FClaw1;
	ModelRenderer FClaw2;
	ModelRenderer RockBase;
	ModelRenderer Rock1;
	ModelRenderer Rock2;
	ModelRenderer Rock3;
	ModelRenderer Rock4;
	ModelRenderer Rock5;
	ModelRenderer Rock6;

	public ModelRockCrab()
	{
		textureWidth = 64;
		textureHeight = 32;

		Body = new ModelRenderer(this, 1, 25);
		Body.addBox(0F, 0F, 0F, 8, 2, 4);
		Body.setRotationPoint(-4F, 19F, -2F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		B1LegH = new ModelRenderer(this, 1, 19);
		B1LegH.addBox(-0.5F, -0.5F, 1F, 1, 1, 4);
		B1LegH.setRotationPoint(3F, 21F, 0F);
		B1LegH.setTextureSize(64, 32);
		B1LegH.mirror = true;
		setRotation(B1LegH, 0F, 0.2617994F, 0F);
		B1LegV = new ModelRenderer(this, 12, 19);
		B1LegV.addBox(-0.5F, -0.5F, 4F, 1, 4, 1);
		B1LegV.setRotationPoint(3F, 21F, 0F);
		B1LegV.setTextureSize(64, 32);
		B1LegV.mirror = true;
		setRotation(B1LegV, 0F, 0.2617994F, 0F);
		B2LegH = new ModelRenderer(this, 1, 19);
		B2LegH.addBox(-0.5F, -0.5F, 1F, 1, 1, 4);
		B2LegH.setRotationPoint(1F, 21F, 0F);
		B2LegH.setTextureSize(64, 32);
		B2LegH.mirror = true;
		setRotation(B2LegH, 0F, 0.0872665F, 0F);
		B2LegV = new ModelRenderer(this, 12, 19);
		B2LegV.addBox(-0.5F, -0.5F, 4F, 1, 4, 1);
		B2LegV.setRotationPoint(1F, 21F, 0F);
		B2LegV.setTextureSize(64, 32);
		B2LegV.mirror = true;
		setRotation(B2LegV, 0F, 0.0872665F, 0F);
		B3LegH = new ModelRenderer(this, 1, 19);
		B3LegH.addBox(-0.5F, -0.5F, 1F, 1, 1, 4);
		B3LegH.setRotationPoint(-1F, 21F, 0F);
		B3LegH.setTextureSize(64, 32);
		B3LegH.mirror = true;
		setRotation(B3LegH, 0F, -0.0872665F, 0F);
		B3LegV = new ModelRenderer(this, 12, 19);
		B3LegV.addBox(-0.5F, -0.5F, 4F, 1, 4, 1);
		B3LegV.setRotationPoint(-1F, 21F, 0F);
		B3LegV.setTextureSize(64, 32);
		B3LegV.mirror = true;
		setRotation(B3LegV, 0F, -0.0872665F, 0F);
		B4LegH = new ModelRenderer(this, 1, 19);
		B4LegH.addBox(-0.5F, -0.5F, 1F, 1, 1, 4);
		B4LegH.setRotationPoint(-3F, 21F, 0F);
		B4LegH.setTextureSize(64, 32);
		B4LegH.mirror = true;
		setRotation(B4LegH, 0F, -0.2617994F, 0F);
		B4LegV = new ModelRenderer(this, 12, 19);
		B4LegV.addBox(-0.5F, -0.5F, 4F, 1, 4, 1);
		B4LegV.setRotationPoint(-3F, 21F, 0F);
		B4LegV.setTextureSize(64, 32);
		B4LegV.mirror = true;
		setRotation(B4LegV, 0F, -0.2617994F, 0F);
		F1LegH = new ModelRenderer(this, 1, 19);
		F1LegH.addBox(-0.5F, -0.5F, -5F, 1, 1, 4);
		F1LegH.setRotationPoint(3F, 21F, 0F);
		F1LegH.setTextureSize(64, 32);
		F1LegH.mirror = true;
		setRotation(F1LegH, 0F, -0.2617994F, 0F);
		F1LegV = new ModelRenderer(this, 12, 19);
		F1LegV.addBox(-0.5F, -0.5F, -5F, 1, 4, 1);
		F1LegV.setRotationPoint(3F, 21F, 0F);
		F1LegV.setTextureSize(64, 32);
		F1LegV.mirror = true;
		setRotation(F1LegV, 0F, -0.2617994F, 0F);
		F2LegH = new ModelRenderer(this, 1, 19);
		F2LegH.addBox(-0.5F, -0.5F, -5F, 1, 1, 4);
		F2LegH.setRotationPoint(1F, 21F, 0F);
		F2LegH.setTextureSize(64, 32);
		F2LegH.mirror = true;
		setRotation(F2LegH, 0F, -0.0872665F, 0F);
		F2LegV = new ModelRenderer(this, 12, 19);
		F2LegV.addBox(-0.5F, -0.5F, -5F, 1, 4, 1);
		F2LegV.setRotationPoint(1F, 21F, 0F);
		F2LegV.setTextureSize(64, 32);
		F2LegV.mirror = true;
		setRotation(F2LegV, 0F, -0.0872665F, 0F);
		F3LegH = new ModelRenderer(this, 1, 19);
		F3LegH.addBox(-0.5F, -0.5F, -5F, 1, 1, 4);
		F3LegH.setRotationPoint(-1F, 21F, 0F);
		F3LegH.setTextureSize(64, 32);
		F3LegH.mirror = true;
		setRotation(F3LegH, 0F, 0.0872665F, 0F);
		F3LegV = new ModelRenderer(this, 12, 19);
		F3LegV.addBox(-0.5F, -0.5F, -5F, 1, 4, 1);
		F3LegV.setRotationPoint(-1F, 21F, 0F);
		F3LegV.setTextureSize(64, 32);
		F3LegV.mirror = true;
		setRotation(F3LegV, 0F, 0.0872665F, 0F);
		F4LegH = new ModelRenderer(this, 1, 19);
		F4LegH.addBox(-0.5F, -0.5F, -5F, 1, 1, 4);
		F4LegH.setRotationPoint(-3F, 21F, 0F);
		F4LegH.setTextureSize(64, 32);
		F4LegH.mirror = true;
		setRotation(F4LegH, 0F, 0.2617994F, 0F);
		F4LegV = new ModelRenderer(this, 12, 19);
		F4LegV.addBox(-0.5F, -0.5F, -5F, 1, 4, 1);
		F4LegV.setRotationPoint(-3F, 21F, 0F);
		F4LegV.setTextureSize(64, 32);
		F4LegV.mirror = true;
		setRotation(F4LegV, 0F, 0.2617994F, 0F);
		BackArm = new ModelRenderer(this, 26, 25);
		BackArm.addBox(-3F, -0.5F, -0.5F, 2, 1, 1);
		BackArm.setRotationPoint(-3F, 21F, 1F);
		BackArm.setTextureSize(64, 32);
		BackArm.mirror = true;
		setRotation(BackArm, 0F, 0.2617994F, 0F);
		BClaw1 = new ModelRenderer(this, 26, 28);
		BClaw1.addBox(-1.5F, -0.4F, -0.6F, 2, 1, 1);
		BClaw1.setRotationPoint(-5.5F, 21F, 2F);
		BClaw1.setTextureSize(64, 32);
		BClaw1.mirror = true;
		setRotation(BClaw1, 0F, 0.6108652F, 0F);
		BClaw2 = new ModelRenderer(this, 26, 28);
		BClaw2.addBox(-2F, -0.4F, -1F, 2, 1, 1);
		BClaw2.setRotationPoint(-5.5F, 21F, 2F);
		BClaw2.setTextureSize(64, 32);
		BClaw2.mirror = true;
		setRotation(BClaw2, 0F, -0.3490659F, 0F);
		FrontArm = new ModelRenderer(this, 26, 25);
		FrontArm.addBox(-3F, -0.5F, -0.5F, 2, 1, 1);
		FrontArm.setRotationPoint(-3F, 21F, -1F);
		FrontArm.setTextureSize(64, 32);
		FrontArm.mirror = true;
		setRotation(FrontArm, 0F, -0.2617994F, 0F);
		FClaw1 = new ModelRenderer(this, 26, 28);
		FClaw1.addBox(-2F, -0.4F, -0.7F, 2, 1, 1);
		FClaw1.setRotationPoint(-5.5F, 21F, -1.5F);
		FClaw1.setTextureSize(64, 32);
		FClaw1.mirror = true;
		setRotation(FClaw1, 0F, -0.6108652F, 0F);
		FClaw2 = new ModelRenderer(this, 26, 28);
		FClaw2.addBox(-1.5F, -0.4F, -0.5F, 2, 1, 1);
		FClaw2.setRotationPoint(-5.5F, 21F, -1.5F);
		FClaw2.setTextureSize(64, 32);
		FClaw2.mirror = true;
		setRotation(FClaw2, 0F, 0.3490659F, 0F);
		RockBase = new ModelRenderer(this, 29, 1);
		RockBase.addBox(0F, 0F, 0F, 9, 1, 8);
		RockBase.setRotationPoint(-4.5F, 19.2F, -4F);
		RockBase.setTextureSize(64, 32);
		RockBase.mirror = true;
		setRotation(RockBase, 0F, 0F, 0F);
		Rock1 = new ModelRenderer(this, 43, 16);
		Rock1.addBox(-1F, -6F, 0F, 2, 7, 8);
		Rock1.setRotationPoint(4F, 18.7F, -4F);
		Rock1.setTextureSize(64, 32);
		Rock1.mirror = true;
		setRotation(Rock1, 0F, 0F, -0.2617994F);
		Rock2 = new ModelRenderer(this, 43, 16);
		Rock2.addBox(-1F, -6F, 0F, 2, 7, 8);
		Rock2.setRotationPoint(-4F, 18.7F, -4F);
		Rock2.setTextureSize(64, 32);
		Rock2.mirror = true;
		setRotation(Rock2, 0F, 0F, 0.2617994F);
		Rock3 = new ModelRenderer(this, 17, 14);
		Rock3.addBox(-2.5F, -7F, 0F, 6, 7, 3);
		Rock3.setRotationPoint(-0.5F, 19.5F, -4.5F);
		Rock3.setTextureSize(64, 32);
		Rock3.mirror = true;
		setRotation(Rock3, -0.1570796F, 0F, 0F);
		Rock4 = new ModelRenderer(this, 17, 14);
		Rock4.addBox(-2.5F, -7F, -3F, 6, 7, 3);
		Rock4.setRotationPoint(-0.5F, 19.5F, 4.5F);
		Rock4.setTextureSize(64, 32);
		Rock4.mirror = true;
		setRotation(Rock4, 0.1745329F, 0F, 0F);
		Rock5 = new ModelRenderer(this, 1, 2);
		Rock5.addBox(0F, 0F, 0F, 6, 5, 5);
		Rock5.setRotationPoint(-3F, 14F, -3.6F);
		Rock5.setTextureSize(64, 32);
		Rock5.mirror = true;
		setRotation(Rock5, 0.7853982F, 0F, 0F);
		Rock6 = new ModelRenderer(this, 1, 1);
		Rock6.addBox(0F, -4F, 0F, 5, 5, 6);
		Rock6.setRotationPoint(-2.8F, 13F, -3F);
		Rock6.setTextureSize(64, 32);
		Rock6.mirror = true;
		setRotation(Rock6, 0F, 0F, 0.7853982F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Body.render(f5);
		B1LegH.render(f5);
		B1LegV.render(f5);
		B2LegH.render(f5);
		B2LegV.render(f5);
		B3LegH.render(f5);
		B3LegV.render(f5);
		B4LegH.render(f5);
		B4LegV.render(f5);
		F1LegH.render(f5);
		F1LegV.render(f5);
		F2LegH.render(f5);
		F2LegV.render(f5);
		F3LegH.render(f5);
		F3LegV.render(f5);
		F4LegH.render(f5);
		F4LegV.render(f5);
		BackArm.render(f5);
		BClaw1.render(f5);
		BClaw2.render(f5);
		FrontArm.render(f5);
		FClaw1.render(f5);
		FClaw2.render(f5);
		RockBase.render(f5);
		Rock1.render(f5);
		Rock2.render(f5);
		Rock3.render(f5);
		Rock4.render(f5);
		Rock5.render(f5);
		Rock6.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		setRotationAngles(f, f1, f2, f3, f4, f5, null);

		F1LegH.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		F1LegV.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;

		F2LegH.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		F2LegV.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;

		F3LegH.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		F3LegV.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;

		F4LegH.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		F4LegV.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;


		B1LegH.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		B1LegH.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;

		B2LegH.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		B2LegH.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;

		B3LegH.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		B3LegH.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;

		B4LegH.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		B4LegH.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
	}

}
