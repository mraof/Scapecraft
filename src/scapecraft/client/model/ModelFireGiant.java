package scapecraft.client.model;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelFireGiant extends ModelBase
{
	//fields
	ModelRenderer LFoot;
	ModelRenderer LLeg;
	ModelRenderer LThigh;
	ModelRenderer RFoot;
	ModelRenderer RLeg;
	ModelRenderer RThigh;
	ModelRenderer BottomBody;
	ModelRenderer UpperBody;
	ModelRenderer LPek;
	ModelRenderer RPek;
	ModelRenderer LShoulder;
	ModelRenderer LArm;
	ModelRenderer LWrist;
	ModelRenderer LHand;
	ModelRenderer RShoulder;
	ModelRenderer RArm;
	ModelRenderer RWrist;
	ModelRenderer RHand;
	ModelRenderer LNeck;
	ModelRenderer RNeck;
	ModelRenderer MNeck;
	ModelRenderer Head;
	ModelRenderer LSmallSpike;
	ModelRenderer LLargeSpike;
	ModelRenderer RSmallSpike;
	ModelRenderer RLargeSpike;
	ModelRenderer LeftCollar1;
	ModelRenderer BackCollar;
	ModelRenderer LeftCollar2;
	ModelRenderer LeftCollar3;
	ModelRenderer LeftCollar4;
	ModelRenderer LeftCollar5;
	ModelRenderer RightCollar1;
	ModelRenderer RightCollar2;
	ModelRenderer RightCollar3;
	ModelRenderer RightCollar4;
	ModelRenderer RightCollar5;
	ModelRenderer BackLeftCollar1;
	ModelRenderer BackLeftCollar2;
	ModelRenderer BackLeftCollar3;
	ModelRenderer BackRightCollar1;
	ModelRenderer BackRightCollar2;
	ModelRenderer BackRightCollar3;
	ModelRenderer Flame1;
	ModelRenderer Flame2;
	ModelRenderer Flame3;
	ModelRenderer Flame4;

	public ModelFireGiant()
	{
		textureWidth = 128;
		textureHeight = 128;

		LFoot = new ModelRenderer(this, 1, 52);
		LFoot.addBox(-6.5F, 13F, -6F, 5, 3, 8);
		LFoot.setRotationPoint(0F, 8F, 3F);
		LFoot.setTextureSize(128, 128);
		LFoot.mirror = true;
		setRotation(LFoot, 0F, 0F, 0F);
		LLeg = new ModelRenderer(this, 1, 38);
		LLeg.addBox(-6F, 7F, -2.5F, 4, 8, 4);
		LLeg.setRotationPoint(0F, 8F, 3F);
		LLeg.setTextureSize(128, 128);
		LLeg.mirror = true;
		setRotation(LLeg, 0F, 0F, 0F);
		LThigh = new ModelRenderer(this, 1, 22);
		LThigh.addBox(-6.5F, 0F, -3F, 5, 8, 5);
		LThigh.setRotationPoint(0F, 8F, 3F);
		LThigh.setTextureSize(128, 128);
		LThigh.mirror = true;
		setRotation(LThigh, 0F, 0F, 0F);
		RFoot = new ModelRenderer(this, 30, 52);
		RFoot.addBox(1.5F, 13F, -6F, 5, 3, 8);
		RFoot.setRotationPoint(0F, 8F, 3F);
		RFoot.setTextureSize(128, 128);
		RFoot.mirror = true;
		setRotation(RFoot, 0F, 0F, 0F);
		RLeg = new ModelRenderer(this, 30, 38);
		RLeg.addBox(2F, 7F, -2.5F, 4, 8, 4);
		RLeg.setRotationPoint(0F, 8F, 3F);
		RLeg.setTextureSize(128, 128);
		RLeg.mirror = true;
		setRotation(RLeg, 0F, 0F, 0F);
		RThigh = new ModelRenderer(this, 30, 22);
		RThigh.addBox(1.5F, 0F, -3F, 5, 8, 5);
		RThigh.setRotationPoint(0F, 8F, 3F);
		RThigh.setTextureSize(128, 128);
		RThigh.mirror = true;
		setRotation(RThigh, 0F, 0F, 0F);
		BottomBody = new ModelRenderer(this, 49, 1);
		BottomBody.addBox(0F, 0F, 0F, 13, 8, 7);
		BottomBody.setRotationPoint(-6.5F, 0F, -1F);
		BottomBody.setTextureSize(128, 128);
		BottomBody.mirror = true;
		setRotation(BottomBody, 0F, 0F, 0F);
		UpperBody = new ModelRenderer(this, 1, 1);
		UpperBody.addBox(0F, 0F, 0F, 15, 12, 8);
		UpperBody.setRotationPoint(-7.5F, -12F, -1.5F);
		UpperBody.setTextureSize(128, 128);
		UpperBody.mirror = true;
		setRotation(UpperBody, 0F, 0F, 0F);
		LPek = new ModelRenderer(this, 91, 1);
		LPek.addBox(0F, 0F, 0F, 7, 7, 2);
		LPek.setRotationPoint(-7.4F, -12F, -1.5F);
		LPek.setTextureSize(128, 128);
		LPek.mirror = true;
		setRotation(LPek, -0.0872665F, 0F, 0F);
		RPek = new ModelRenderer(this, 110, 1);
		RPek.addBox(0F, 0F, 0F, 7, 7, 2);
		RPek.setRotationPoint(0.4F, -12F, -1.5F);
		RPek.setTextureSize(128, 128);
		RPek.mirror = true;
		setRotation(RPek, -0.0872665F, 0F, 0F);
		LShoulder = new ModelRenderer(this, 58, 47);
		LShoulder.addBox(-5F, 0F, -2F, 5, 10, 5);
		LShoulder.setRotationPoint(-7.5F, -12F, 2F);
		LShoulder.setTextureSize(128, 128);
		LShoulder.mirror = true;
		setRotation(LShoulder, 0.2617994F, 0F, 0.0872665F);
		LArm = new ModelRenderer(this, 58, 30);
		LArm.addBox(-4.5F, 6F, 4.4F, 4, 11, 4);
		LArm.setRotationPoint(-7.5F, -12F, 2F);
		LArm.setTextureSize(128, 128);
		LArm.mirror = true;
		setRotation(LArm, -0.418879F, 0F, 0.0872665F);
		LWrist = new ModelRenderer(this, 58, 21);
		LWrist.addBox(-4F, 14F, 4.9F, 3, 4, 3);
		LWrist.setRotationPoint(-7.5F, -12F, 2F);
		LWrist.setTextureSize(128, 128);
		LWrist.mirror = true;
		setRotation(LWrist, -0.418879F, 0F, 0.0872665F);
		LHand = new ModelRenderer(this, 72, 18);
		LHand.addBox(-4.5F, 18F, 4.4F, 4, 3, 4);
		LHand.setRotationPoint(-7.5F, -12F, 2F);
		LHand.setTextureSize(128, 128);
		LHand.mirror = true;
		setRotation(LHand, -0.418879F, 0F, 0.0872665F);
		RShoulder = new ModelRenderer(this, 58, 76);
		RShoulder.addBox(0F, 0F, -2F, 5, 10, 5);
		RShoulder.setRotationPoint(7.5F, -12F, 2F);
		RShoulder.setTextureSize(128, 128);
		RShoulder.mirror = true;
		setRotation(RShoulder, 0.1745329F, 0F, -0.0872665F);
		RArm = new ModelRenderer(this, 58, 30);
		RArm.addBox(0.5F, 7.5F, 3F, 4, 11, 4);
		RArm.setRotationPoint(7.5F, -12F, 2F);
		RArm.setTextureSize(128, 128);
		RArm.mirror = true;
		setRotation(RArm, -0.296706F, 0F, -0.0872665F);
		RWrist = new ModelRenderer(this, 58, 21);
		RWrist.addBox(1F, 16.5F, 3.4F, 3, 4, 3);
		RWrist.setRotationPoint(7.5F, -12F, 2F);
		RWrist.setTextureSize(128, 128);
		RWrist.mirror = true;
		setRotation(RWrist, -0.296706F, 0F, -0.0872665F);
		RHand = new ModelRenderer(this, 90, 18);
		RHand.addBox(0.5F, 19.5F, 2.9F, 4, 3, 4);
		RHand.setRotationPoint(7.5F, -12F, 2F);
		RHand.setTextureSize(128, 128);
		RHand.mirror = true;
		setRotation(RHand, -0.296706F, 0F, -0.0872665F);
		LNeck = new ModelRenderer(this, 78, 27);
		LNeck.addBox(0F, 0F, 0F, 7, 4, 5);
		LNeck.setRotationPoint(-6F, -12F, 0F);
		LNeck.setTextureSize(128, 128);
		LNeck.mirror = true;
		setRotation(LNeck, 0F, 0F, -0.6108652F);
		RNeck = new ModelRenderer(this, 78, 27);
		RNeck.addBox(-7F, 0F, 0F, 7, 4, 5);
		RNeck.setRotationPoint(6F, -12F, 0F);
		RNeck.setTextureSize(128, 128);
		RNeck.mirror = true;
		setRotation(RNeck, 0F, 0F, 0.6108652F);
		MNeck = new ModelRenderer(this, 80, 38);
		MNeck.addBox(0F, 0F, 0F, 5, 3, 5);
		MNeck.setRotationPoint(-2.5F, -16F, 0F);
		MNeck.setTextureSize(128, 128);
		MNeck.mirror = true;
		setRotation(MNeck, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 85, 48);
		Head.addBox(0F, 0F, 0F, 6, 7, 7);
		Head.setRotationPoint(-3F, -23F, -1.7F);
		Head.setTextureSize(128, 128);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		LSmallSpike = new ModelRenderer(this, 104, 37);
		LSmallSpike.addBox(-6.8F, 5F, 0F, 3, 1, 1);
		LSmallSpike.setRotationPoint(-7.5F, -12F, 2F);
		LSmallSpike.setTextureSize(128, 128);
		LSmallSpike.mirror = true;
		setRotation(LSmallSpike, 0.2617994F, 0F, 0.0872665F);
		LLargeSpike = new ModelRenderer(this, 104, 41);
		LLargeSpike.addBox(-7.8F, 2F, 0F, 4, 2, 2);
		LLargeSpike.setRotationPoint(-7.5F, -12F, 2F);
		LLargeSpike.setTextureSize(128, 128);
		LLargeSpike.mirror = true;
		setRotation(LLargeSpike, 0.2617994F, 0F, 0.0872665F);
		RSmallSpike = new ModelRenderer(this, 104, 37);
		RSmallSpike.addBox(3.8F, 5F, 0F, 3, 1, 1);
		RSmallSpike.setRotationPoint(7.5F, -12F, 2F);
		RSmallSpike.setTextureSize(128, 128);
		RSmallSpike.mirror = true;
		setRotation(RSmallSpike, 0.1745329F, 0F, -0.0872665F);
		RLargeSpike = new ModelRenderer(this, 104, 41);
		RLargeSpike.addBox(3.8F, 2F, 0F, 4, 2, 2);
		RLargeSpike.setRotationPoint(7.5F, -12F, 2F);
		RLargeSpike.setTextureSize(128, 128);
		RLargeSpike.mirror = true;
		setRotation(RLargeSpike, 0.1745329F, 0F, -0.0872665F);
		LeftCollar1 = new ModelRenderer(this, 36, 66);
		LeftCollar1.addBox(0F, 0F, -4F, 1, 2, 8);
		LeftCollar1.setRotationPoint(-7.8F, -12.7F, 2.5F);
		LeftCollar1.setTextureSize(128, 128);
		LeftCollar1.mirror = true;
		setRotation(LeftCollar1, 0F, 0F, 0F);
		BackCollar = new ModelRenderer(this, 1, 66);
		BackCollar.addBox(0F, 0F, 0F, 15, 2, 1);
		BackCollar.setRotationPoint(-7.5F, -12.7F, 5.8F);
		BackCollar.setTextureSize(128, 128);
		BackCollar.mirror = true;
		setRotation(BackCollar, 0F, 0F, 0F);
		LeftCollar2 = new ModelRenderer(this, 57, 66);
		LeftCollar2.addBox(0F, -1F, -3F, 1, 2, 6);
		LeftCollar2.setRotationPoint(-7.8F, -12.7F, 2.5F);
		LeftCollar2.setTextureSize(128, 128);
		LeftCollar2.mirror = true;
		setRotation(LeftCollar2, 0F, 0F, 0.0523599F);
		LeftCollar3 = new ModelRenderer(this, 73, 66);
		LeftCollar3.addBox(0F, -2F, -2F, 1, 2, 4);
		LeftCollar3.setRotationPoint(-7.8F, -12.7F, 2.5F);
		LeftCollar3.setTextureSize(128, 128);
		LeftCollar3.mirror = true;
		setRotation(LeftCollar3, 0F, 0F, 0.1047198F);
		LeftCollar4 = new ModelRenderer(this, 85, 66);
		LeftCollar4.addBox(0F, -3F, -1F, 1, 2, 2);
		LeftCollar4.setRotationPoint(-7.8F, -12.7F, 2.5F);
		LeftCollar4.setTextureSize(128, 128);
		LeftCollar4.mirror = true;
		setRotation(LeftCollar4, 0F, 0F, 0.1570796F);
		LeftCollar5 = new ModelRenderer(this, 93, 66);
		LeftCollar5.addBox(0F, -4F, -0.5F, 1, 2, 1);
		LeftCollar5.setRotationPoint(-7.8F, -12.7F, 2.5F);
		LeftCollar5.setTextureSize(128, 128);
		LeftCollar5.mirror = true;
		setRotation(LeftCollar5, 0F, 0F, 0.2094395F);
		RightCollar1 = new ModelRenderer(this, 36, 66);
		RightCollar1.addBox(-1F, 0F, -4F, 1, 2, 8);
		RightCollar1.setRotationPoint(7.8F, -12.7F, 2.5F);
		RightCollar1.setTextureSize(128, 128);
		RightCollar1.mirror = true;
		setRotation(RightCollar1, 0F, 0F, 0F);
		RightCollar2 = new ModelRenderer(this, 57, 66);
		RightCollar2.addBox(-1F, -1F, -3F, 1, 2, 6);
		RightCollar2.setRotationPoint(7.8F, -12.7F, 2.5F);
		RightCollar2.setTextureSize(128, 128);
		RightCollar2.mirror = true;
		setRotation(RightCollar2, 0F, 0F, -0.0523599F);
		RightCollar3 = new ModelRenderer(this, 73, 66);
		RightCollar3.addBox(-1F, -2F, -2F, 1, 2, 4);
		RightCollar3.setRotationPoint(7.8F, -12.7F, 2.5F);
		RightCollar3.setTextureSize(128, 128);
		RightCollar3.mirror = true;
		setRotation(RightCollar3, 0F, 0F, -0.1047198F);
		RightCollar4 = new ModelRenderer(this, 85, 66);
		RightCollar4.addBox(-1F, -3F, -1F, 1, 2, 2);
		RightCollar4.setRotationPoint(7.8F, -12.7F, 2.5F);
		RightCollar4.setTextureSize(128, 128);
		RightCollar4.mirror = true;
		setRotation(RightCollar4, 0F, 0F, -0.1570796F);
		RightCollar5 = new ModelRenderer(this, 93, 66);
		RightCollar5.addBox(-1F, -4F, -0.5F, 1, 2, 1);
		RightCollar5.setRotationPoint(7.8F, -12.7F, 2.5F);
		RightCollar5.setTextureSize(128, 128);
		RightCollar5.mirror = true;
		setRotation(RightCollar5, 0F, 0F, -0.2094395F);
		BackLeftCollar1 = new ModelRenderer(this, 1, 71);
		BackLeftCollar1.addBox(0F, 0F, 0F, 3, 2, 1);
		BackLeftCollar1.setRotationPoint(-5.5F, -13.7F, 5.8F);
		BackLeftCollar1.setTextureSize(128, 128);
		BackLeftCollar1.mirror = true;
		setRotation(BackLeftCollar1, 0F, 0F, 0F);
		BackLeftCollar2 = new ModelRenderer(this, 1, 76);
		BackLeftCollar2.addBox(0F, 0F, 0F, 2, 2, 1);
		BackLeftCollar2.setRotationPoint(-5F, -14.7F, 5.8F);
		BackLeftCollar2.setTextureSize(128, 128);
		BackLeftCollar2.mirror = true;
		setRotation(BackLeftCollar2, 0F, 0F, 0F);
		BackLeftCollar3 = new ModelRenderer(this, 1, 81);
		BackLeftCollar3.addBox(0F, -1F, 0F, 1, 2, 1);
		BackLeftCollar3.setRotationPoint(-4.5F, -14.7F, 5.8F);
		BackLeftCollar3.setTextureSize(128, 128);
		BackLeftCollar3.mirror = true;
		setRotation(BackLeftCollar3, 0F, 0F, 0F);
		BackRightCollar1 = new ModelRenderer(this, 1, 71);
		BackRightCollar1.addBox(0F, 0F, 0F, 3, 2, 1);
		BackRightCollar1.setRotationPoint(2.5F, -13.7F, 5.8F);
		BackRightCollar1.setTextureSize(128, 128);
		BackRightCollar1.mirror = true;
		setRotation(BackRightCollar1, 0F, 0F, 0F);
		BackRightCollar2 = new ModelRenderer(this, 1, 76);
		BackRightCollar2.addBox(0F, 0F, 0F, 2, 2, 1);
		BackRightCollar2.setRotationPoint(3F, -14.7F, 5.8F);
		BackRightCollar2.setTextureSize(128, 128);
		BackRightCollar2.mirror = true;
		setRotation(BackRightCollar2, 0F, 0F, 0F);
		BackRightCollar3 = new ModelRenderer(this, 1, 81);
		BackRightCollar3.addBox(0F, -1F, 0F, 1, 2, 1);
		BackRightCollar3.setRotationPoint(3.5F, -14.7F, 5.8F);
		BackRightCollar3.setTextureSize(128, 128);
		BackRightCollar3.mirror = true;
		setRotation(BackRightCollar3, 0F, 0F, 0F);
		Flame1 = new ModelRenderer(this, 104, 28);
		Flame1.addBox(0F, 0F, 0F, 5, 1, 6);
		Flame1.setRotationPoint(-2.5F, -24F, -1.2F);
		Flame1.setTextureSize(128, 128);
		Flame1.mirror = true;
		setRotation(Flame1, 0F, 0F, 0F);
		Flame2 = new ModelRenderer(this, 108, 20);
		Flame2.addBox(0F, 0F, 0F, 4, 1, 5);
		Flame2.setRotationPoint(-2F, -25F, -0.7F);
		Flame2.setTextureSize(128, 128);
		Flame2.mirror = true;
		setRotation(Flame2, 0F, 0F, 0F);
		Flame3 = new ModelRenderer(this, 110, 12);
		Flame3.addBox(0F, 0F, 0F, 3, 1, 4);
		Flame3.setRotationPoint(-1.5F, -26F, -0.2F);
		Flame3.setTextureSize(128, 128);
		Flame3.mirror = true;
		setRotation(Flame3, 0F, 0F, 0F);
		Flame4 = new ModelRenderer(this, 96, 12);
		Flame4.addBox(0F, 0F, 0F, 2, 1, 3);
		Flame4.setRotationPoint(-1F, -27F, 0.3F);
		Flame4.setTextureSize(128, 128);
		Flame4.mirror = true;
		setRotation(Flame4, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		LFoot.render(f5);
		LLeg.render(f5);
		LThigh.render(f5);
		RFoot.render(f5);
		RLeg.render(f5);
		RThigh.render(f5);
		BottomBody.render(f5);
		UpperBody.render(f5);
		LPek.render(f5);
		RPek.render(f5);
		LShoulder.render(f5);
		LArm.render(f5);
		LWrist.render(f5);
		LHand.render(f5);
		RShoulder.render(f5);
		RArm.render(f5);
		RWrist.render(f5);
		RHand.render(f5);
		LNeck.render(f5);
		RNeck.render(f5);
		MNeck.render(f5);
		Head.render(f5);
		LSmallSpike.render(f5);
		LLargeSpike.render(f5);
		RSmallSpike.render(f5);
		RLargeSpike.render(f5);
		LeftCollar1.render(f5);
		BackCollar.render(f5);
		LeftCollar2.render(f5);
		LeftCollar3.render(f5);
		LeftCollar4.render(f5);
		LeftCollar5.render(f5);
		RightCollar1.render(f5);
		RightCollar2.render(f5);
		RightCollar3.render(f5);
		RightCollar4.render(f5);
		RightCollar5.render(f5);
		BackLeftCollar1.render(f5);
		BackLeftCollar2.render(f5);
		BackLeftCollar3.render(f5);
		BackRightCollar1.render(f5);
		BackRightCollar2.render(f5);
		BackRightCollar3.render(f5);
		Flame1.render(f5);
		Flame2.render(f5);
		Flame3.render(f5);
		Flame4.render(f5);
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
		LFoot.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
		LLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
		LThigh.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;

		RFoot.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.0F * f1;
		RLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.0F * f1;
		RThigh.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.0F * f1;
	}

}
