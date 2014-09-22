package scapecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKaril extends ModelBase
{
	//fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer Base;
	ModelRenderer RLimb1;
	ModelRenderer LLimb1;
	ModelRenderer LLimb2;
	ModelRenderer RLimb3;
	ModelRenderer BackTail1;
	ModelRenderer BackTail2;
	ModelRenderer BackTailCover1;
	ModelRenderer BackTailCover2;
	ModelRenderer Handle;
	ModelRenderer RBolt;
	ModelRenderer RBolt1;
	ModelRenderer RBolt2;
	ModelRenderer LBolt;
	ModelRenderer LBolt1;
	ModelRenderer LBolt2;
	ModelRenderer Stabilizer;
	ModelRenderer RBar;
	ModelRenderer LBar;
	ModelRenderer MiddleSight;
	ModelRenderer BackSight;
	ModelRenderer RightSight;
	ModelRenderer LeftSight;

	public ModelKaril()
	{
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this, 69, 17);
		head.addBox(-6F, -12F, -6F, 12, 12, 12);
		head.setRotationPoint(0F, -8F, 2F);
		head.setTextureSize(128, 128);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 73, 45);
		body.addBox(-6F, -6F, -4F, 12, 16, 8);
		body.setRotationPoint(0F, -2F, 2F);
		body.setTextureSize(128, 128);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 62, 72);
		rightarm.addBox(-6F, -1F, -4F, 6, 16, 8);
		rightarm.setRotationPoint(-6F, -7F, 2F);
		rightarm.setTextureSize(128, 128);
		rightarm.mirror = true;
		setRotation(rightarm, -0.7504916F, 0F, 0F);
		leftarm = new ModelRenderer(this, 95, 72);
		leftarm.addBox(0F, -1F, -4F, 6, 16, 8);
		leftarm.setRotationPoint(6F, -7F, 2F);
		leftarm.setTextureSize(128, 128);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 65, 100);
		rightleg.addBox(-3F, 0F, -4F, 6, 16, 8);
		rightleg.setRotationPoint(-3F, 8F, 2F);
		rightleg.setTextureSize(128, 128);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 95, 100);
		leftleg.addBox(-3F, 0F, -4F, 6, 16, 8);
		leftleg.setRotationPoint(3F, 8F, 2F);
		leftleg.setTextureSize(128, 128);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		Base = new ModelRenderer(this, 1, 107);
		Base.addBox(-5.5F, 4F, -28F, 5, 3, 17);
		Base.setRotationPoint(-6F, -7F, 2F);
		Base.setTextureSize(128, 128);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		RLimb1 = new ModelRenderer(this, 1, 94);
		RLimb1.addBox(-12.5F, 4.5F, -27F, 7, 2, 2);
		RLimb1.setRotationPoint(-6F, -7F, 2F);
		RLimb1.setTextureSize(128, 128);
		RLimb1.mirror = true;
		setRotation(RLimb1, 0F, 0F, 0F);
		LLimb1 = new ModelRenderer(this, 25, 94);
		LLimb1.addBox(-0.5F, 4.5F, -27F, 7, 2, 2);
		LLimb1.setRotationPoint(-6F, -7F, 2F);
		LLimb1.setTextureSize(128, 128);
		LLimb1.mirror = true;
		setRotation(LLimb1, 0F, 0F, 0F);
		LLimb2 = new ModelRenderer(this, 25, 85);
		LLimb2.addBox(4.5F, 4.5F, -25F, 2, 2, 4);
		LLimb2.setRotationPoint(-6F, -7F, 2F);
		LLimb2.setTextureSize(128, 128);
		LLimb2.mirror = true;
		setRotation(LLimb2, 0F, 0F, 0F);
		RLimb3 = new ModelRenderer(this, 1, 82);
		RLimb3.addBox(-12.5F, 4.5F, -25F, 2, 2, 4);
		RLimb3.setRotationPoint(-6F, -7F, 2F);
		RLimb3.setTextureSize(128, 128);
		RLimb3.mirror = true;
		setRotation(RLimb3, 0F, 0F, 0F);
		BackTail1 = new ModelRenderer(this, 1, 74);
		BackTail1.addBox(-4.5F, 4.5F, -11F, 3, 2, 3);
		BackTail1.setRotationPoint(-6F, -7F, 2F);
		BackTail1.setTextureSize(128, 128);
		BackTail1.mirror = true;
		setRotation(BackTail1, 0F, 0F, 0F);
		BackTail2 = new ModelRenderer(this, 25, 72);
		BackTail2.addBox(-4.5F, 3.5F, -8F, 3, 4, 4);
		BackTail2.setRotationPoint(-6F, -7F, 2F);
		BackTail2.setTextureSize(128, 128);
		BackTail2.mirror = true;
		setRotation(BackTail2, 0F, 0F, 0F);
		BackTailCover1 = new ModelRenderer(this, 1, 67);
		BackTailCover1.addBox(-5F, 3F, -4.7F, 4, 3, 1);
		BackTailCover1.setRotationPoint(-6F, -7F, 2F);
		BackTailCover1.setTextureSize(128, 128);
		BackTailCover1.mirror = true;
		setRotation(BackTailCover1, 0F, 0F, 0F);
		BackTailCover2 = new ModelRenderer(this, 25, 66);
		BackTailCover2.addBox(-5F, 4.4F, -6.2F, 4, 3, 1);
		BackTailCover2.setRotationPoint(-6F, -7F, 2F);
		BackTailCover2.setTextureSize(128, 128);
		BackTailCover2.mirror = true;
		setRotation(BackTailCover2, 0.2974289F, 0F, 0F);
		Handle = new ModelRenderer(this, 1, 53);
		Handle.addBox(-4.5F, 8F, -17F, 3, 3, 7);
		Handle.setRotationPoint(-6F, -7F, 2F);
		Handle.setTextureSize(128, 128);
		Handle.mirror = true;
		setRotation(Handle, -0.2230717F, 0F, 0F);
		RBolt = new ModelRenderer(this, 42, 88);
		RBolt.addBox(-6F, 4.4F, -16.4F, 2, 2, 2);
		RBolt.setRotationPoint(-6F, -7F, 2F);
		RBolt.setTextureSize(128, 128);
		RBolt.mirror = true;
		setRotation(RBolt, 0F, 0F, 0F);
		RBolt1 = new ModelRenderer(this, 42, 84);
		RBolt1.addBox(-6.2F, 4.9F, -15.9F, 1, 1, 1);
		RBolt1.setRotationPoint(-6F, -7F, 2F);
		RBolt1.setTextureSize(128, 128);
		RBolt1.mirror = true;
		setRotation(RBolt1, 0F, 0F, 0F);
		RBolt2 = new ModelRenderer(this, 42, 84);
		RBolt2.addBox(-6.2F, 0.7F, -10.7F, 1, 1, 1);
		RBolt2.setRotationPoint(-6F, -7F, 2F);
		RBolt2.setTextureSize(128, 128);
		RBolt2.mirror = true;
		setRotation(RBolt2, 0F, 0F, 0F);
		LBolt = new ModelRenderer(this, 42, 88);
		LBolt.addBox(-2F, 4.4F, -16.4F, 2, 2, 2);
		LBolt.setRotationPoint(-6F, -7F, 2F);
		LBolt.setTextureSize(128, 128);
		LBolt.mirror = true;
		setRotation(LBolt, 0F, 0F, 0F);
		LBolt1 = new ModelRenderer(this, 42, 84);
		LBolt1.addBox(-0.8F, 4.9F, -15.9F, 1, 1, 1);
		LBolt1.setRotationPoint(-6F, -7F, 2F);
		LBolt1.setTextureSize(128, 128);
		LBolt1.mirror = true;
		setRotation(LBolt1, 0F, 0F, 0F);
		LBolt2 = new ModelRenderer(this, 42, 84);
		LBolt2.addBox(-0.8F, 0.7F, -10.7F, 1, 1, 1);
		LBolt2.setRotationPoint(-6F, -7F, 2F);
		LBolt2.setTextureSize(128, 128);
		LBolt2.mirror = true;
		setRotation(LBolt2, 0F, 0F, 0F);
		Stabilizer = new ModelRenderer(this, 1, 46);
		Stabilizer.addBox(-6F, 0.2F, -11.2F, 6, 2, 2);
		Stabilizer.setRotationPoint(-6F, -7F, 2F);
		Stabilizer.setTextureSize(128, 128);
		Stabilizer.mirror = true;
		setRotation(Stabilizer, 0F, 0F, 0F);
		RBar = new ModelRenderer(this, 1, 35);
		RBar.addBox(-6.1F, -6F, -15.5F, 0, 1, 7);
		RBar.setRotationPoint(-6F, -7F, 2F);
		RBar.setTextureSize(128, 128);
		RBar.mirror = true;
		setRotation(RBar, 0.6806784F, 0F, 0F);
		LBar = new ModelRenderer(this, 1, 35);
		LBar.addBox(0.1F, -6F, -15.5F, 0, 1, 7);
		LBar.setRotationPoint(-6F, -7F, 2F);
		LBar.setTextureSize(128, 128);
		LBar.mirror = true;
		setRotation(LBar, 0.6806784F, 0F, 0F);
		MiddleSight = new ModelRenderer(this, 1, 32);
		MiddleSight.addBox(-4.5F, 3F, -25F, 3, 1, 0);
		MiddleSight.setRotationPoint(-6F, -7F, 2F);
		MiddleSight.setTextureSize(128, 128);
		MiddleSight.mirror = true;
		setRotation(MiddleSight, 0F, 0F, 0F);
		BackSight = new ModelRenderer(this, 1, 29);
		BackSight.addBox(-4F, 3F, -21F, 2, 1, 0);
		BackSight.setRotationPoint(-6F, -7F, 2F);
		BackSight.setTextureSize(128, 128);
		BackSight.mirror = true;
		setRotation(BackSight, 0F, 0F, 0F);
		RightSight = new ModelRenderer(this, 1, 23);
		RightSight.addBox(-5F, 2.5F, -27.8F, 1, 2, 1);
		RightSight.setRotationPoint(-6F, -7F, 2F);
		RightSight.setTextureSize(128, 128);
		RightSight.mirror = true;
		setRotation(RightSight, 0F, 0F, 0F);
		LeftSight = new ModelRenderer(this, 1, 23);
		LeftSight.addBox(-2F, 2.5F, -27.8F, 1, 2, 1);
		LeftSight.setRotationPoint(-6F, -7F, 2F);
		LeftSight.setTextureSize(128, 128);
		LeftSight.mirror = true;
		setRotation(LeftSight, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		head.renderWithRotation(f5);
		body.renderWithRotation(f5);
		rightarm.renderWithRotation(f5);
		leftarm.renderWithRotation(f5);
		rightleg.renderWithRotation(f5);
		leftleg.renderWithRotation(f5);
		Base.renderWithRotation(f5);
		RLimb1.renderWithRotation(f5);
		LLimb1.renderWithRotation(f5);
		LLimb2.renderWithRotation(f5);
		RLimb3.renderWithRotation(f5);
		BackTail1.renderWithRotation(f5);
		BackTail2.renderWithRotation(f5);
		BackTailCover1.renderWithRotation(f5);
		BackTailCover2.renderWithRotation(f5);
		Handle.renderWithRotation(f5);
		RBolt.renderWithRotation(f5);
		RBolt1.renderWithRotation(f5);
		RBolt2.renderWithRotation(f5);
		LBolt.renderWithRotation(f5);
		LBolt1.renderWithRotation(f5);
		LBolt2.renderWithRotation(f5);
		Stabilizer.renderWithRotation(f5);
		RBar.renderWithRotation(f5);
		LBar.renderWithRotation(f5);
		MiddleSight.renderWithRotation(f5);
		BackSight.renderWithRotation(f5);
		RightSight.renderWithRotation(f5);
		LeftSight.renderWithRotation(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
		leftarm.rotateAngleX = MathHelper.cos(f * .5F) * 0.7F * f1;
		rightarm.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + -0.750491578F;
		rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.0F * f1;
		leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
		Base.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		RLimb1.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		LLimb1.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		LLimb2.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		RLimb3.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;    
		BackTail1.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		BackTail2.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		BackTailCover1.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		BackTailCover2.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.297421558F;
		Handle.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + -0.223070532F;
		RBolt.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		RBolt1.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		RBolt2.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		LBolt.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		LBolt1.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		LBolt2.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		Stabilizer.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		RBar.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.680678408F;
		LBar.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.680678408F;
		MiddleSight.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		BackSight.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		RightSight.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
		LeftSight.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1;
	}

}