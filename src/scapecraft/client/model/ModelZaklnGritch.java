package scapecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelZaklnGritch extends ModelBase
{
	//fields
	ModelRenderer RightFootRightToe;
	ModelRenderer RightFootLeftToe;
	ModelRenderer LeftFootLeftToe;
	ModelRenderer LeftFootRightToe;
	ModelRenderer RightHoof;
	ModelRenderer LeftHoof;
	ModelRenderer RightBottomLeg;
	ModelRenderer RightMiddleLeg;
	ModelRenderer LeftBottomLeg;
	ModelRenderer LeftMiddleLeg;
	ModelRenderer RightTopLeg;
	ModelRenderer LeftTopLeg;
	ModelRenderer BottomBody;
	ModelRenderer MiddleBody;
	ModelRenderer TopBody;
	ModelRenderer RightPec;
	ModelRenderer LeftPec;
	ModelRenderer LeftShoulder;
	ModelRenderer RightShoulder;
	ModelRenderer LeftTopArm;
	ModelRenderer RightBottomArm;
	ModelRenderer RightFrontFinger;
	ModelRenderer RightBackFinger;
	ModelRenderer RightThumb;
	ModelRenderer RightMiddleFinger;
	ModelRenderer RightHand;
	ModelRenderer RightTopArm;
	ModelRenderer LeftBottomArm;
	ModelRenderer LeftHand;
	ModelRenderer LeftThumb;
	ModelRenderer LeftFrontFinger;
	ModelRenderer LeftMiddleFinger;
	ModelRenderer LeftBackFinger;
	ModelRenderer Tail1;
	ModelRenderer Tail2;
	ModelRenderer Tail3;
	ModelRenderer Tail4;
	ModelRenderer Tail5;
	ModelRenderer Tail6;
	ModelRenderer TailHairTip;
	ModelRenderer TailHair;
	ModelRenderer Neck1;
	ModelRenderer Neck2;
	ModelRenderer Neck3;
	ModelRenderer Neck4;
	ModelRenderer Head;
	ModelRenderer LeftTopLip;
	ModelRenderer RightTopLip;
	ModelRenderer MiddleTopLip;
	ModelRenderer LeftTopJaw;
	ModelRenderer RightTopJaw;
	ModelRenderer BottomMouth;
	ModelRenderer BackMouth;
	ModelRenderer RightBottomLip;
	ModelRenderer LeftBottomLip;
	ModelRenderer FrontBottomLip;
	ModelRenderer RightMiddleLip;
	ModelRenderer RightConnectingLip;
	ModelRenderer LeftMiddleLip;
	ModelRenderer LeftConnectingLip;
	ModelRenderer RightTopTooth;
	ModelRenderer LeftTopTooth;
	ModelRenderer Tongue1;
	ModelRenderer Tongue2;
	ModelRenderer Tongue3;
	ModelRenderer Tongue4;
	ModelRenderer RightBottomTooth;
	ModelRenderer LeftBottomTooth;
	ModelRenderer RightBottomEar;
	ModelRenderer RightTopEar;
	ModelRenderer LeftBottomEar;
	ModelRenderer LeftTopEar;
	ModelRenderer RightBottomHorn;
	ModelRenderer RightTopHorn;
	ModelRenderer LeftBottomHorn;
	ModelRenderer LeftTopHorn;
	ModelRenderer RightNose;
	ModelRenderer LeftNose;
	ModelRenderer LeftMiddleJaw1;
	ModelRenderer LeftMiddleJaw2;
	ModelRenderer LeftMiddleJaw3;
	ModelRenderer RightMiddleJaw1;
	ModelRenderer RightMiddleJaw2;
	ModelRenderer RightMiddleJaw3;

	public ModelZaklnGritch()
	{
		textureWidth = 128;
		textureHeight = 64;

		RightFootRightToe = new ModelRenderer(this, 73, 1);
		RightFootRightToe.addBox(-8F, 22F, -5F, 2, 2, 5);
		RightFootRightToe.setRotationPoint(0F, 0F, 0F);
		RightFootRightToe.setTextureSize(128, 64);
		RightFootRightToe.mirror = true;
		RightFootLeftToe = new ModelRenderer(this, 73, 1);
		RightFootLeftToe.addBox(-5F, 22F, -5F, 2, 2, 5);
		RightFootLeftToe.setRotationPoint(0F, 0F, 0F);
		RightFootLeftToe.setTextureSize(128, 64);
		RightFootLeftToe.mirror = true;
		LeftFootLeftToe = new ModelRenderer(this, 73, 1);
		LeftFootLeftToe.addBox(6F, 22F, -5F, 2, 2, 5);
		LeftFootLeftToe.setRotationPoint(0F, 0F, 0F);
		LeftFootLeftToe.setTextureSize(128, 64);
		LeftFootLeftToe.mirror = true;
		LeftFootRightToe = new ModelRenderer(this, 73, 1);
		LeftFootRightToe.addBox(3F, 22F, -5F, 2, 2, 5);
		LeftFootRightToe.setRotationPoint(0F, 0F, 0F);
		LeftFootRightToe.setTextureSize(128, 64);
		LeftFootRightToe.mirror = true;
		RightHoof = new ModelRenderer(this, 73, 10);
		RightHoof.addBox(-7.5F, 21F, -4F, 4, 3, 4);
		RightHoof.setRotationPoint(0F, 0F, 0F);
		RightHoof.setTextureSize(128, 64);
		RightHoof.mirror = true;
		LeftHoof = new ModelRenderer(this, 73, 10);
		LeftHoof.addBox(3.5F, 21F, -4F, 4, 3, 4);
		LeftHoof.setRotationPoint(0F, 0F, 0F);
		LeftHoof.setTextureSize(128, 64);
		LeftHoof.mirror = true;
		RightBottomLeg = new ModelRenderer(this, 0, 0);
		RightBottomLeg.addBox(-7F, 12F, 8F, 3, 9, 3);
		RightBottomLeg.setRotationPoint(0F, 0F, 0F);
		RightBottomLeg.setTextureSize(128, 64);
		RightBottomLeg.mirror = true;
		setRotation(RightBottomLeg, -0.5235988F, 0F, 0F);
		RightMiddleLeg = new ModelRenderer(this, 0, 0);
		RightMiddleLeg.addBox(-7.5F, 7.4F, -5.8F, 4, 9, 4);
		RightMiddleLeg.setRotationPoint(0F, 0F, 0F);
		RightMiddleLeg.setTextureSize(128, 64);
		RightMiddleLeg.mirror = true;
		setRotation(RightMiddleLeg, 0.3490659F, 0F, 0F);
		LeftBottomLeg = new ModelRenderer(this, 0, 0);
		LeftBottomLeg.addBox(4F, 12F, 8F, 3, 9, 3);
		LeftBottomLeg.setRotationPoint(0F, 0F, 0F);
		LeftBottomLeg.setTextureSize(128, 64);
		LeftBottomLeg.mirror = true;
		setRotation(LeftBottomLeg, -0.5235988F, 0F, 0F);
		LeftMiddleLeg = new ModelRenderer(this, 0, 0);
		LeftMiddleLeg.addBox(3.5F, 7.4F, -5.8F, 4, 9, 4);
		LeftMiddleLeg.setRotationPoint(0F, 0F, 0F);
		LeftMiddleLeg.setTextureSize(128, 64);
		LeftMiddleLeg.mirror = true;
		setRotation(LeftMiddleLeg, 0.3490659F, 0F, 0F);
		RightTopLeg = new ModelRenderer(this, 0, 0);
		RightTopLeg.addBox(-8F, -0.6F, -1.6F, 5, 10, 5);
		RightTopLeg.setRotationPoint(0F, 0F, 0F);
		RightTopLeg.setTextureSize(128, 64);
		RightTopLeg.mirror = true;
		setRotation(RightTopLeg, -0.1745329F, 0F, 0F);
		LeftTopLeg = new ModelRenderer(this, 0, 0);
		LeftTopLeg.addBox(3F, -0.6F, -1.6F, 5, 10, 5);
		LeftTopLeg.setRotationPoint(0F, 0F, 0F);
		LeftTopLeg.setTextureSize(128, 64);
		LeftTopLeg.mirror = true;
		setRotation(LeftTopLeg, -0.1745329F, 0F, 0F);
		BottomBody = new ModelRenderer(this, 0, 0);
		BottomBody.addBox(0F, 0F, 0F, 16, 4, 5);
		BottomBody.setRotationPoint(-8F, -4F, -1.6F);
		BottomBody.setTextureSize(128, 64);
		BottomBody.mirror = true;
		MiddleBody = new ModelRenderer(this, 0, 0);
		MiddleBody.addBox(0F, 0F, 0F, 16, 4, 5);
		MiddleBody.setRotationPoint(-8F, -6.5F, -2.4F);
		MiddleBody.setTextureSize(128, 64);
		MiddleBody.mirror = true;
		setRotation(MiddleBody, 0.2617994F, 0F, 0F);
		TopBody = new ModelRenderer(this, 0, 0);
		TopBody.addBox(0F, 0F, 0F, 18, 8, 6);
		TopBody.setRotationPoint(-9F, -12.3F, -5.8F);
		TopBody.setTextureSize(128, 64);
		TopBody.mirror = true;
		setRotation(TopBody, 0.4363323F, 0F, 0F);
		RightPec = new ModelRenderer(this, 0, 0);
		RightPec.addBox(0F, 0F, 0F, 8, 5, 1);
		RightPec.setRotationPoint(-8.5F, -12.3F, -5.8F);
		RightPec.setTextureSize(128, 64);
		RightPec.mirror = true;
		setRotation(RightPec, 0.3665191F, 0F, 0F);
		LeftPec = new ModelRenderer(this, 0, 0);
		LeftPec.addBox(0F, 0F, 0F, 8, 5, 1);
		LeftPec.setRotationPoint(0.5F, -12.3F, -5.8F);
		LeftPec.setTextureSize(128, 64);
		LeftPec.mirror = true;
		setRotation(LeftPec, 0.3665191F, 0F, 0F);
		LeftShoulder = new ModelRenderer(this, 0, 0);
		LeftShoulder.addBox(0F, 0F, -1F, 7, 9, 7);
		LeftShoulder.setRotationPoint(9F, -15F, -5F);
		LeftShoulder.setTextureSize(128, 64);
		LeftShoulder.mirror = true;
		RightShoulder = new ModelRenderer(this, 0, 0);
		RightShoulder.addBox(-1F, 0F, -1F, 7, 9, 7);
		RightShoulder.setRotationPoint(-15F, -15F, -5F);
		RightShoulder.setTextureSize(128, 64);
		RightShoulder.mirror = true;
		setRotation(RightShoulder, -0.0872665F, 0F, 0F);
		LeftTopArm = new ModelRenderer(this, 0, 0);
		LeftTopArm.addBox(1F, 7.5F, 1F, 5, 9, 5);
		LeftTopArm.setRotationPoint(9F, -15F, -5F);
		LeftTopArm.setTextureSize(128, 64);
		LeftTopArm.mirror = true;
		setRotation(LeftTopArm, -0.1745329F, 0F, 0F);
		RightBottomArm = new ModelRenderer(this, 0, 0);
		RightBottomArm.addBox(0.5F, 15.4F, 5.8F, 4, 7, 4);
		RightBottomArm.setRotationPoint(-15F, -15F, -5F);
		RightBottomArm.setTextureSize(128, 64);
		RightBottomArm.mirror = true;
		setRotation(RightBottomArm, -0.4363323F, 0F, 0F);
		RightFrontFinger = new ModelRenderer(this, 90, 7);
		RightFrontFinger.addBox(-5.8F, 23.6F, 5.6F, 1, 4, 1);
		RightFrontFinger.setRotationPoint(-15F, -15F, -5F);
		RightFrontFinger.setTextureSize(128, 64);
		RightFrontFinger.mirror = true;
		setRotation(RightFrontFinger, -0.4363323F, 0F, -0.2617994F);
		RightBackFinger = new ModelRenderer(this, 90, 7);
		RightBackFinger.addBox(-6F, 23.6F, 8.6F, 1, 4, 1);
		RightBackFinger.setRotationPoint(-15F, -15F, -5F);
		RightBackFinger.setTextureSize(128, 64);
		RightBackFinger.mirror = true;
		setRotation(RightBackFinger, -0.4363323F, 0F, -0.2617994F);
		RightThumb = new ModelRenderer(this, 90, 1);
		RightThumb.addBox(2.8F, 23.6F, 6.3F, 1, 3, 2);
		RightThumb.setRotationPoint(-15F, -15F, -5F);
		RightThumb.setTextureSize(128, 64);
		RightThumb.mirror = true;
		setRotation(RightThumb, -0.4363323F, 0F, 0F);
		RightMiddleFinger = new ModelRenderer(this, 90, 7);
		RightMiddleFinger.addBox(-5.9F, 23.6F, 7.1F, 1, 4, 1);
		RightMiddleFinger.setRotationPoint(-15F, -15F, -5F);
		RightMiddleFinger.setTextureSize(128, 64);
		RightMiddleFinger.mirror = true;
		setRotation(RightMiddleFinger, -0.4363323F, 0F, -0.2617994F);
		RightHand = new ModelRenderer(this, 0, 0);
		RightHand.addBox(0.5F, 21.4F, 5.8F, 3, 3, 4);
		RightHand.setRotationPoint(-15F, -15F, -5F);
		RightHand.setTextureSize(128, 64);
		RightHand.mirror = true;
		setRotation(RightHand, -0.4363323F, 0F, 0F);
		RightTopArm = new ModelRenderer(this, 0, 0);
		RightTopArm.addBox(0F, 8.5F, 1F, 5, 9, 5);
		RightTopArm.setRotationPoint(-15F, -15F, -5F);
		RightTopArm.setTextureSize(128, 64);
		RightTopArm.mirror = true;
		setRotation(RightTopArm, -0.1745329F, 0F, 0F);
		LeftBottomArm = new ModelRenderer(this, 0, 0);
		LeftBottomArm.addBox(1.5F, 14.4F, 5.8F, 4, 7, 4);
		LeftBottomArm.setRotationPoint(9F, -15F, -5F);
		LeftBottomArm.setTextureSize(128, 64);
		LeftBottomArm.mirror = true;
		setRotation(LeftBottomArm, -0.4363323F, 0F, 0F);
		LeftHand = new ModelRenderer(this, 0, 0);
		LeftHand.addBox(2.5F, 20.4F, 5.8F, 3, 3, 4);
		LeftHand.setRotationPoint(9F, -15F, -5F);
		LeftHand.setTextureSize(128, 64);
		LeftHand.mirror = true;
		setRotation(LeftHand, -0.4363323F, 0F, 0F);
		LeftThumb = new ModelRenderer(this, 98, 1);
		LeftThumb.addBox(2.3F, 22.6F, 6.3F, 1, 3, 2);
		LeftThumb.setRotationPoint(9F, -15F, -5F);
		LeftThumb.setTextureSize(128, 64);
		LeftThumb.mirror = true;
		setRotation(LeftThumb, -0.4363323F, 0F, 0F);
		LeftFrontFinger = new ModelRenderer(this, 98, 7);
		LeftFrontFinger.addBox(10.5F, 21.4F, 4.9F, 1, 4, 1);
		LeftFrontFinger.setRotationPoint(9F, -15F, -5F);
		LeftFrontFinger.setTextureSize(128, 64);
		LeftFrontFinger.mirror = true;
		setRotation(LeftFrontFinger, -0.4363323F, 0F, 0.2617994F);
		LeftMiddleFinger = new ModelRenderer(this, 98, 7);
		LeftMiddleFinger.addBox(10.6F, 21.4F, 6.3F, 1, 4, 1);
		LeftMiddleFinger.setRotationPoint(9F, -15F, -5F);
		LeftMiddleFinger.setTextureSize(128, 64);
		LeftMiddleFinger.mirror = true;
		setRotation(LeftMiddleFinger, -0.4363323F, 0F, 0.2617994F);
		LeftBackFinger = new ModelRenderer(this, 98, 7);
		LeftBackFinger.addBox(10.7F, 21.4F, 7.9F, 1, 4, 1);
		LeftBackFinger.setRotationPoint(9F, -15F, -5F);
		LeftBackFinger.setTextureSize(128, 64);
		LeftBackFinger.mirror = true;
		setRotation(LeftBackFinger, -0.4363323F, 0F, 0.2617994F);
		Tail1 = new ModelRenderer(this, 0, 0);
		Tail1.addBox(0F, 0F, 0F, 2, 2, 3);
		Tail1.setRotationPoint(-1F, -2F, 2.9F);
		Tail1.setTextureSize(128, 64);
		Tail1.mirror = true;
		setRotation(Tail1, 0.1745329F, 0F, 0F);
		Tail2 = new ModelRenderer(this, 0, 0);
		Tail2.addBox(0F, 0.9F, 2.1F, 2, 2, 3);
		Tail2.setRotationPoint(-1F, -2F, 2.9F);
		Tail2.setTextureSize(128, 64);
		Tail2.mirror = true;
		setRotation(Tail2, 0.5235988F, 0F, 0F);
		Tail3 = new ModelRenderer(this, 0, 0);
		Tail3.addBox(0F, 2.4F, 3.6F, 2, 2, 3);
		Tail3.setRotationPoint(-1F, -2F, 2.9F);
		Tail3.setTextureSize(128, 64);
		Tail3.mirror = true;
		setRotation(Tail3, 0.8726646F, 0F, 0F);
		Tail4 = new ModelRenderer(this, 0, 0);
		Tail4.addBox(0F, 3.5F, 5.7F, 2, 2, 3);
		Tail4.setRotationPoint(-1F, -2F, 2.9F);
		Tail4.setTextureSize(128, 64);
		Tail4.mirror = true;
		setRotation(Tail4, 1.047198F, 0F, 0F);
		Tail5 = new ModelRenderer(this, 0, 0);
		Tail5.addBox(0F, 6.1F, 6.3F, 2, 2, 4);
		Tail5.setRotationPoint(-1F, -2F, 2.9F);
		Tail5.setTextureSize(128, 64);
		Tail5.mirror = true;
		setRotation(Tail5, 1.396263F, 0F, 0F);
		Tail6 = new ModelRenderer(this, 0, 0);
		Tail6.addBox(0F, 7F, 9.5F, 2, 2, 4);
		Tail6.setRotationPoint(-1F, -2F, 2.9F);
		Tail6.setTextureSize(128, 64);
		Tail6.mirror = true;
		setRotation(Tail6, 1.48353F, 0F, 0F);
		TailHairTip = new ModelRenderer(this, 50, 1);
		TailHairTip.addBox(0.5F, 7.5F, 12.5F, 1, 1, 5);
		TailHairTip.setRotationPoint(-1F, -2F, 2.9F);
		TailHairTip.setTextureSize(128, 64);
		TailHairTip.mirror = true;
		setRotation(TailHairTip, 1.48353F, 0F, 0F);
		TailHair = new ModelRenderer(this, 50, 8);
		TailHair.addBox(0F, 7F, 14F, 2, 2, 3);
		TailHair.setRotationPoint(-1F, -2F, 2.9F);
		TailHair.setTextureSize(128, 64);
		TailHair.mirror = true;
		setRotation(TailHair, 1.48353F, 0F, 0F);
		Neck1 = new ModelRenderer(this, 0, 0);
		Neck1.addBox(-3.5F, -1.2F, -2.5F, 7, 2, 5);
		Neck1.setRotationPoint(0F, -14F, -3.2F);
		Neck1.setTextureSize(128, 64);
		Neck1.mirror = true;
		setRotation(Neck1, 0.5235988F, 0F, 0F);
		Neck2 = new ModelRenderer(this, 0, 0);
		Neck2.addBox(-3.5F, -2.9F, -2.2F, 7, 3, 5);
		Neck2.setRotationPoint(0F, -14F, -3.2F);
		Neck2.setTextureSize(128, 64);
		Neck2.mirror = true;
		setRotation(Neck2, 0.9948377F, 0F, 0F);
		Neck3 = new ModelRenderer(this, 0, 0);
		Neck3.addBox(-3.5F, -4.6F, -1.3F, 7, 3, 5);
		Neck3.setRotationPoint(0F, -14F, -3.2F);
		Neck3.setTextureSize(128, 64);
		Neck3.mirror = true;
		setRotation(Neck3, 1.396263F, 0F, 0F);
		Neck4 = new ModelRenderer(this, 0, 0);
		Neck4.addBox(-3.5F, -4.5F, -5.7F, 7, 5, 2);
		Neck4.setRotationPoint(0F, -14F, -3.2F);
		Neck4.setTextureSize(128, 64);
		Neck4.mirror = true;
		Head = new ModelRenderer(this, 1, 17);
		Head.addBox(0F, 0F, 0F, 8, 5, 5);
		Head.setRotationPoint(-4F, -20F, -13F);
		Head.setTextureSize(128, 64);
		Head.mirror = true;
		LeftTopLip = new ModelRenderer(this, 107, 15);
		LeftTopLip.addBox(0F, 0F, 0F, 4, 1, 6);
		LeftTopLip.setRotationPoint(0.1F, -15.8F, -14F);
		LeftTopLip.setTextureSize(128, 64);
		LeftTopLip.mirror = true;
		RightTopLip = new ModelRenderer(this, 107, 7);
		RightTopLip.addBox(-4F, 0F, 0F, 4, 1, 6);
		RightTopLip.setRotationPoint(-0.1F, -15.8F, -14F);
		RightTopLip.setTextureSize(128, 64);
		RightTopLip.mirror = true;
		MiddleTopLip = new ModelRenderer(this, 110, 1);
		MiddleTopLip.addBox(0F, 0F, 0F, 1, 1, 1);
		MiddleTopLip.setRotationPoint(-0.5F, -15.8F, -14F);
		MiddleTopLip.setTextureSize(128, 64);
		MiddleTopLip.mirror = true;
		LeftTopJaw = new ModelRenderer(this, 30, 37);
		LeftTopJaw.addBox(0F, 0F, 0F, 1, 3, 5);
		LeftTopJaw.setRotationPoint(2.9F, -14.5F, -14F);
		LeftTopJaw.setTextureSize(128, 64);
		LeftTopJaw.mirror = true;
		setRotation(LeftTopJaw, 0.1745329F, 0F, 0F);
		RightTopJaw = new ModelRenderer(this, 30, 28);
		RightTopJaw.addBox(-1F, 0F, 0F, 1, 3, 5);
		RightTopJaw.setRotationPoint(-2.9F, -14.5F, -14F);
		RightTopJaw.setTextureSize(128, 64);
		RightTopJaw.mirror = true;
		setRotation(RightTopJaw, 0.1745329F, 0F, 0F);
		BottomMouth = new ModelRenderer(this, 1, 28);
		BottomMouth.addBox(0F, 0F, -3F, 6, 1, 8);
		BottomMouth.setRotationPoint(-3F, -7.6F, -11.8F);
		BottomMouth.setTextureSize(128, 64);
		BottomMouth.mirror = true;
		setRotation(BottomMouth, 1.047198F, 0F, 0F);
		BackMouth = new ModelRenderer(this, 29, 16);
		BackMouth.addBox(0F, 0F, -3F, 6, 4, 1);
		BackMouth.setRotationPoint(-3F, -15.4F, -6.4F);
		BackMouth.setTextureSize(128, 64);
		BackMouth.mirror = true;
		RightBottomLip = new ModelRenderer(this, 0, 0);
		RightBottomLip.addBox(0F, -1F, -4F, 1, 2, 9);
		RightBottomLip.setRotationPoint(-3.9F, -7.6F, -11.8F);
		RightBottomLip.setTextureSize(128, 64);
		RightBottomLip.mirror = true;
		setRotation(RightBottomLip, 1.047198F, 0F, 0F);
		LeftBottomLip = new ModelRenderer(this, 0, 0);
		LeftBottomLip.addBox(0F, -1F, -4F, 1, 2, 9);
		LeftBottomLip.setRotationPoint(2.9F, -7.6F, -11.8F);
		LeftBottomLip.setTextureSize(128, 64);
		LeftBottomLip.mirror = true;
		setRotation(LeftBottomLip, 1.047198F, 0F, 0F);
		FrontBottomLip = new ModelRenderer(this, 0, 0);
		FrontBottomLip.addBox(0F, -1F, -4F, 6, 2, 1);
		FrontBottomLip.setRotationPoint(-3F, -7.6F, -11.8F);
		FrontBottomLip.setTextureSize(128, 64);
		FrontBottomLip.mirror = true;
		setRotation(FrontBottomLip, 1.047198F, 0F, 0F);
		RightMiddleLip = new ModelRenderer(this, 0, 0);
		RightMiddleLip.addBox(0F, -6F, 0F, 1, 6, 2);
		RightMiddleLip.setRotationPoint(-3.9F, -6.9F, -13.4F);
		RightMiddleLip.setTextureSize(128, 64);
		RightMiddleLip.mirror = true;
		setRotation(RightMiddleLip, -0.3490659F, 0F, 0F);
		RightConnectingLip = new ModelRenderer(this, 0, 0);
		RightConnectingLip.addBox(0F, -3.5F, -1F, 1, 4, 2);
		RightConnectingLip.setRotationPoint(-3.9F, -11.9F, -9.4F);
		RightConnectingLip.setTextureSize(128, 64);
		RightConnectingLip.mirror = true;
		LeftMiddleLip = new ModelRenderer(this, 0, 0);
		LeftMiddleLip.addBox(0F, -6F, 0F, 1, 6, 2);
		LeftMiddleLip.setRotationPoint(2.9F, -6.9F, -13.4F);
		LeftMiddleLip.setTextureSize(128, 64);
		LeftMiddleLip.mirror = true;
		setRotation(LeftMiddleLip, -0.3490659F, 0F, 0F);
		LeftConnectingLip = new ModelRenderer(this, 0, 0);
		LeftConnectingLip.addBox(0F, -3.5F, -1F, 1, 4, 2);
		LeftConnectingLip.setRotationPoint(2.9F, -11.9F, -9.4F);
		LeftConnectingLip.setTextureSize(128, 64);
		LeftConnectingLip.mirror = true;
		RightTopTooth = new ModelRenderer(this, 115, 1);
		RightTopTooth.addBox(0F, 0F, 0F, 1, 3, 1);
		RightTopTooth.setRotationPoint(-2F, -15F, -13.7F);
		RightTopTooth.setTextureSize(128, 64);
		RightTopTooth.mirror = true;
		LeftTopTooth = new ModelRenderer(this, 115, 1);
		LeftTopTooth.addBox(0F, 0F, 0F, 1, 3, 1);
		LeftTopTooth.setRotationPoint(1F, -15F, -13.7F);
		LeftTopTooth.setTextureSize(128, 64);
		LeftTopTooth.mirror = true;
		Tongue1 = new ModelRenderer(this, 1, 38);
		Tongue1.addBox(1F, -1.4F, -3F, 4, 2, 8);
		Tongue1.setRotationPoint(-3F, -7.6F, -11.8F);
		Tongue1.setTextureSize(128, 64);
		Tongue1.mirror = true;
		setRotation(Tongue1, 1.047198F, 0F, 0F);
		Tongue2 = new ModelRenderer(this, 1, 49);
		Tongue2.addBox(1F, -1.4F, -5F, 4, 1, 3);
		Tongue2.setRotationPoint(-3F, -7.6F, -11.8F);
		Tongue2.setTextureSize(128, 64);
		Tongue2.mirror = true;
		setRotation(Tongue2, 1.047198F, 0F, 0F);
		Tongue3 = new ModelRenderer(this, 1, 54);
		Tongue3.addBox(1.5F, -2.6F, -7.4F, 3, 1, 3);
		Tongue3.setRotationPoint(-3F, -7.6F, -11.8F);
		Tongue3.setTextureSize(128, 64);
		Tongue3.mirror = true;
		setRotation(Tongue3, 1.308997F, 0F, 0F);
		Tongue4 = new ModelRenderer(this, 1, 59);
		Tongue4.addBox(2F, -2.6F, -10.3F, 2, 1, 3);
		Tongue4.setRotationPoint(-3F, -7.6F, -11.8F);
		Tongue4.setTextureSize(128, 64);
		Tongue4.mirror = true;
		setRotation(Tongue4, 1.308997F, 0F, 0F);
		RightBottomTooth = new ModelRenderer(this, 120, 1);
		RightBottomTooth.addBox(0.5F, -3F, -3F, 1, 3, 1);
		RightBottomTooth.setRotationPoint(-3F, -7.6F, -11.8F);
		RightBottomTooth.setTextureSize(128, 64);
		RightBottomTooth.mirror = true;
		setRotation(RightBottomTooth, 1.047198F, 0F, 0F);
		LeftBottomTooth = new ModelRenderer(this, 120, 1);
		LeftBottomTooth.addBox(4.5F, -3F, -3F, 1, 3, 1);
		LeftBottomTooth.setRotationPoint(-3F, -7.6F, -11.8F);
		LeftBottomTooth.setTextureSize(128, 64);
		LeftBottomTooth.mirror = true;
		setRotation(LeftBottomTooth, 1.047198F, 0F, 0F);
		RightBottomEar = new ModelRenderer(this, 0, 0);
		RightBottomEar.addBox(-1.7F, 0F, 0F, 2, 1, 1);
		RightBottomEar.setRotationPoint(-3.4F, -17F, -10F);
		RightBottomEar.setTextureSize(128, 64);
		RightBottomEar.mirror = true;
		RightTopEar = new ModelRenderer(this, 0, 0);
		RightTopEar.addBox(-3.3F, -1.1F, 0F, 2, 1, 1);
		RightTopEar.setRotationPoint(-3.4F, -17F, -10F);
		RightTopEar.setTextureSize(128, 64);
		RightTopEar.mirror = true;
		LeftBottomEar = new ModelRenderer(this, 0, 0);
		LeftBottomEar.addBox(-0.3F, 0F, 0F, 2, 1, 1);
		LeftBottomEar.setRotationPoint(3.4F, -17F, -10F);
		LeftBottomEar.setTextureSize(128, 64);
		LeftBottomEar.mirror = true;
		LeftTopEar = new ModelRenderer(this, 0, 0);
		LeftTopEar.addBox(1.3F, -1.1F, 0F, 2, 1, 1);
		LeftTopEar.setRotationPoint(3.4F, -17F, -10F);
		LeftTopEar.setTextureSize(128, 64);
		LeftTopEar.mirror = true;
		RightBottomHorn = new ModelRenderer(this, 64, 1);
		RightBottomHorn.addBox(0F, -4F, 0F, 2, 6, 2);
		RightBottomHorn.setRotationPoint(-4.3F, -18.5F, -12F);
		RightBottomHorn.setTextureSize(128, 64);
		RightBottomHorn.mirror = true;
		RightTopHorn = new ModelRenderer(this, 64, 10);
		RightTopHorn.addBox(0F, -6.1F, 1.9F, 2, 4, 2);
		RightTopHorn.setRotationPoint(-4.3F, -18.5F, -12F);
		RightTopHorn.setTextureSize(128, 64);
		RightTopHorn.mirror = true;
		setRotation(RightTopHorn, 0.6108652F, 0F, -1.047198F);
		LeftBottomHorn = new ModelRenderer(this, 64, 1);
		LeftBottomHorn.addBox(-2F, -4F, 0F, 2, 6, 2);
		LeftBottomHorn.setRotationPoint(4.3F, -18.5F, -12F);
		LeftBottomHorn.setTextureSize(128, 64);
		LeftBottomHorn.mirror = true;
		LeftTopHorn = new ModelRenderer(this, 64, 10);
		LeftTopHorn.addBox(-2F, -6.1F, 1.9F, 2, 4, 2);
		LeftTopHorn.setRotationPoint(4.3F, -18.5F, -12F);
		LeftTopHorn.setTextureSize(128, 64);
		LeftTopHorn.mirror = true;
		setRotation(LeftTopHorn, 0.6108652F, 0F, 1.047198F);
		RightNose = new ModelRenderer(this, 105, 1);
		RightNose.addBox(0F, 0F, -0.5F, 1, 2, 1);
		RightNose.setRotationPoint(-1.4F, -16.8F, -12.6F);
		RightNose.setTextureSize(128, 64);
		RightNose.mirror = true;
		LeftNose = new ModelRenderer(this, 105, 1);
		LeftNose.addBox(-1F, 0F, -0.5F, 1, 2, 1);
		LeftNose.setRotationPoint(1.4F, -16.8F, -12.6F);
		LeftNose.setTextureSize(128, 64);
		LeftNose.mirror = true;
		LeftMiddleJaw1 = new ModelRenderer(this, 0, 0);
		LeftMiddleJaw1.addBox(0F, -1F, -1F, 2, 2, 2);
		LeftMiddleJaw1.setRotationPoint(3F, -11.5F, -12F);
		LeftMiddleJaw1.setTextureSize(128, 64);
		LeftMiddleJaw1.mirror = true;
		LeftMiddleJaw2 = new ModelRenderer(this, 0, 0);
		LeftMiddleJaw2.addBox(1F, -0.5F, 0.5F, 4, 1, 1);
		LeftMiddleJaw2.setRotationPoint(3F, -11.5F, -12F);
		LeftMiddleJaw2.setTextureSize(128, 64);
		LeftMiddleJaw2.mirror = true;
		setRotation(LeftMiddleJaw2, 0F, 0.6320364F, 0F);
		LeftMiddleJaw3 = new ModelRenderer(this, 29, 22);
		LeftMiddleJaw3.addBox(-2F, -0.5F, -5.5F, 3, 1, 1);
		LeftMiddleJaw3.setRotationPoint(3F, -11.5F, -12F);
		LeftMiddleJaw3.setTextureSize(128, 64);
		LeftMiddleJaw3.mirror = true;
		setRotation(LeftMiddleJaw3, 0F, -1.047198F, 0F);
		RightMiddleJaw1 = new ModelRenderer(this, 0, 0);
		RightMiddleJaw1.addBox(-2F, -1F, -1F, 2, 2, 2);
		RightMiddleJaw1.setRotationPoint(-3F, -11.5F, -12F);
		RightMiddleJaw1.setTextureSize(128, 64);
		RightMiddleJaw1.mirror = true;
		RightMiddleJaw2 = new ModelRenderer(this, 0, 0);
		RightMiddleJaw2.addBox(-5F, -0.5F, 0.5F, 4, 1, 1);
		RightMiddleJaw2.setRotationPoint(-3F, -11.5F, -12F);
		RightMiddleJaw2.setTextureSize(128, 64);
		RightMiddleJaw2.mirror = true;
		setRotation(RightMiddleJaw2, 0F, -0.6320361F, 0F);
		RightMiddleJaw3 = new ModelRenderer(this, 29, 25);
		RightMiddleJaw3.addBox(-1F, -0.5F, -5.5F, 3, 1, 1);
		RightMiddleJaw3.setRotationPoint(-3F, -11.5F, -12F);
		RightMiddleJaw3.setTextureSize(128, 64);
		RightMiddleJaw3.mirror = true;
		setRotation(RightMiddleJaw3, 0F, 1.047198F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		RightFootRightToe.render(f5);
		RightFootLeftToe.render(f5);
		LeftFootLeftToe.render(f5);
		LeftFootRightToe.render(f5);
		RightHoof.render(f5);
		LeftHoof.render(f5);
		RightBottomLeg.render(f5);
		RightMiddleLeg.render(f5);
		LeftBottomLeg.render(f5);
		LeftMiddleLeg.render(f5);
		RightTopLeg.render(f5);
		LeftTopLeg.render(f5);
		BottomBody.render(f5);
		MiddleBody.render(f5);
		TopBody.render(f5);
		RightPec.render(f5);
		LeftPec.render(f5);
		LeftShoulder.render(f5);
		RightShoulder.render(f5);
		LeftTopArm.render(f5);
		RightBottomArm.render(f5);
		RightFrontFinger.render(f5);
		RightBackFinger.render(f5);
		RightThumb.render(f5);
		RightMiddleFinger.render(f5);
		RightHand.render(f5);
		RightTopArm.render(f5);
		LeftBottomArm.render(f5);
		LeftHand.render(f5);
		LeftThumb.render(f5);
		LeftFrontFinger.render(f5);
		LeftMiddleFinger.render(f5);
		LeftBackFinger.render(f5);
		Tail1.render(f5);
		Tail2.render(f5);
		Tail3.render(f5);
		Tail4.render(f5);
		Tail5.render(f5);
		Tail6.render(f5);
		TailHairTip.render(f5);
		TailHair.render(f5);
		Neck1.render(f5);
		Neck2.render(f5);
		Neck3.render(f5);
		Neck4.render(f5);
		Head.render(f5);
		LeftTopLip.render(f5);
		RightTopLip.render(f5);
		MiddleTopLip.render(f5);
		LeftTopJaw.render(f5);
		RightTopJaw.render(f5);
		BottomMouth.render(f5);
		BackMouth.render(f5);
		RightBottomLip.render(f5);
		LeftBottomLip.render(f5);
		FrontBottomLip.render(f5);
		RightMiddleLip.render(f5);
		RightConnectingLip.render(f5);
		LeftMiddleLip.render(f5);
		LeftConnectingLip.render(f5);
		RightTopTooth.render(f5);
		LeftTopTooth.render(f5);
		Tongue1.render(f5);
		Tongue2.render(f5);
		Tongue3.render(f5);
		Tongue4.render(f5);
		RightBottomTooth.render(f5);
		LeftBottomTooth.render(f5);
		RightBottomEar.render(f5);
		RightTopEar.render(f5);
		LeftBottomEar.render(f5);
		LeftTopEar.render(f5);
		RightBottomHorn.render(f5);
		RightTopHorn.render(f5);
		LeftBottomHorn.render(f5);
		LeftTopHorn.render(f5);
		RightNose.render(f5);
		LeftNose.render(f5);
		LeftMiddleJaw1.render(f5);
		LeftMiddleJaw2.render(f5);
		LeftMiddleJaw3.render(f5);
		RightMiddleJaw1.render(f5);
		RightMiddleJaw2.render(f5);
		RightMiddleJaw3.render(f5);
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

		LeftFootRightToe.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.5F * f1;	
		LeftFootLeftToe.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.5F * f1;
		LeftHoof.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.5F * f1;
		LeftBottomLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.5F * f1 + -0.523598776F;
		LeftMiddleLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.5F * f1 + 0.34906585F;	
		LeftTopLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.5F * f1 + -0.174532925F;    

		RightFootRightToe.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 0.5F * f1;
		RightFootLeftToe.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 0.5F * f1;
		RightHoof.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 0.5F * f1;
		RightBottomLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 0.5F * f1 + -0.523598776F;
		RightMiddleLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 0.5F * f1 + 0.34906585F;
		RightTopLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 0.5F * f1 + -0.174532925F;
	}

}
