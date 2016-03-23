package scapecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelZilyana extends ModelBase
{
	//fields
	ModelRenderer head;
	ModelRenderer backHair;
	ModelRenderer leftHairLock;
	ModelRenderer rightHairLock;
	ModelRenderer neck;
	ModelRenderer chest;
	ModelRenderer breasts;
	ModelRenderer belly;
	ModelRenderer hips;
	ModelRenderer leftShoulder;
	ModelRenderer rightShoulder;
	ModelRenderer leftArm;
	ModelRenderer rightArm;
	ModelRenderer leftUpperLeg;
	ModelRenderer rightUpperLeg;
	ModelRenderer leftKneecap;
	ModelRenderer rightKneecap;
	ModelRenderer leftLeg;
	ModelRenderer rightLeg;
	ModelRenderer leftWing;
	ModelRenderer rightWing;
	ModelRenderer bottomShield1;
	ModelRenderer bottomShield2;
	ModelRenderer bottomShield3;
	ModelRenderer bottomShield4;
	ModelRenderer bottomShield5;
	ModelRenderer bottomShield6;
	ModelRenderer bottomShield7;
	ModelRenderer bottomShield8;
	ModelRenderer upperPartShield;
	ModelRenderer shieldHandle1;
	ModelRenderer shieldHandle2;
	ModelRenderer shieldHandle3;
	ModelRenderer middleShieldPart;
	ModelRenderer sideShieldStalk1;
	ModelRenderer sideShieldStalk2;
	ModelRenderer shieldTopPart1;
	ModelRenderer shieldTopPart;
	ModelRenderer swordBlade1;
	ModelRenderer swordBlade2;
	ModelRenderer swordBlade3;
	ModelRenderer swordBlade4;
	ModelRenderer swordBlade5;
	ModelRenderer swordBlade6;
	ModelRenderer swordHandProtect;
	ModelRenderer swordHandle;
	ModelRenderer swordSquareBallPart2;
	ModelRenderer swordSquareBallPart;

	public ModelZilyana()
	{
		textureWidth = 256;
		textureHeight = 128;

		//body
		chest = new ModelRenderer(this, 0, 0);
		chest.addBox(0F, 0F, 0F, 12, 9, 8);
		chest.setRotationPoint(-6F, -27F, 0F);
		chest.mirror = true;
		setRotation(chest, 0F, 0F, 0F);
		breasts = new ModelRenderer(this, 69, 55);
		breasts.addBox(0F, 0F, 0F, 11, 6, 5);
		breasts.setRotationPoint(-5.5F, -26F, 0F);
		breasts.mirror = true;
		setRotation(breasts, -0.7853982F, 0F, 0F);
		belly = new ModelRenderer(this, 38, 55);
		belly.addBox(0F, 0F, 0F, 10, 11, 5);
		belly.setRotationPoint(-5F, -19F, 1.5F);
		belly.mirror = true;
		setRotation(belly, 0F, 0F, 0F);
		hips = new ModelRenderer(this, 34, 72);
		hips.addBox(0F, 0F, 0F, 12, 7, 8);
		hips.setRotationPoint(-6F, -8F, 0F);
		hips.mirror = true;
		setRotation(hips, 0F, 0F, 0F);

		//Right arm
		rightShoulder = new ModelRenderer(this, 0, 55);
		rightShoulder.addBox(0F, 0F, 0F, 4, 13, 5);
		rightShoulder.setRotationPoint(-6F, -27F, 0F);
		rightShoulder.mirror = true;
		setRotation(rightShoulder, 0F, 0F, 0.4014257F);
		rightArm = new ModelRenderer(this, 0, 55);
		rightArm.addBox(0F, 0F, -1.5F, 4, 13, 5);
		rightArm.setRotationPoint(-10.5F, -16F, 1.5F);
		rightArm.mirror = true;
		setRotation(rightArm, -0.2617994F, 0F, 0.1745329F);

		//Left arm
		leftShoulder = new ModelRenderer(this, 0, 55);
		leftShoulder.addBox(0F, 0F, 0F, 4, 12, 5);
		leftShoulder.setRotationPoint(3F, -24.6F, 2F);
		leftShoulder.mirror = true;
		setRotation(leftShoulder, 0F, 0F, -0.4014257F);
		leftArm = new ModelRenderer(this, 0, 55);
		leftArm.addBox(0F, 0F, 0F, 4, 13, 5);
		leftArm.setRotationPoint(7F, -16F, 2F);
		leftArm.mirror = true;
		setRotation(leftArm, -0.2617994F, 0F, -0.1745329F);

		//head
		head = new ModelRenderer(this, 50, 0);
		head.addBox(0F, 0F, 0F, 12, 12, 12);
		head.setRotationPoint(-6F, -41F, -2F);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 55);
		neck.addBox(0F, 0F, 0F, 6, 3, 6);
		neck.setRotationPoint(-3F, -29.53333F, 1F);
		neck.mirror = true;
		setRotation(neck, 0F, 0F, 0F);
		leftHairLock = new ModelRenderer(this, 160, 0);
		leftHairLock.addBox(0F, 0F, 0F, 2, 14, 2);
		leftHairLock.setRotationPoint(5F, -40F, -3F);
		leftHairLock.mirror = true;
		setRotation(leftHairLock, 0F, 0F, 0F);
		rightHairLock = new ModelRenderer(this, 160, 0);
		rightHairLock.addBox(0F, 0F, 0F, 2, 13, 2);
		rightHairLock.setRotationPoint(-7F, -40F, -3F);
		rightHairLock.mirror = true;
		setRotation(rightHairLock, 0F, 0F, 0F);
		backHair = new ModelRenderer(this, 160, 0);
		backHair.addBox(0F, 0F, 2F, 12, 21, 1);
		backHair.setRotationPoint(-6F, -41F, 8F);
		setRotation(backHair, 0.0349066F, 0F, 0F);
		backHair.mirror = false;

		//Sword
		swordSquareBallPart = new ModelRenderer(this, 104, 43);
		swordSquareBallPart.addBox(0F, 0.5F, 9.5F, 3, 2, 4);
		swordSquareBallPart.setRotationPoint(9F, -8F, -4F);
		swordSquareBallPart.mirror = true;
		setRotation(swordSquareBallPart, -0.2617994F, 0F, -0.1745329F);
		swordHandle = new ModelRenderer(this, 104, 37);
		swordHandle.addBox(0F, 0F, 2F, 3, 1, 15);
		swordHandle.setRotationPoint(9F, -8F, -8F);
		swordHandle.mirror = true;
		setRotation(swordHandle, -0.2617994F, 0F, -0.1745329F);
		swordSquareBallPart2 = new ModelRenderer(this, 104, 43);
		swordSquareBallPart2.addBox(-0.5F, -0.5F, 12F, 4, 4, 4);
		swordSquareBallPart2.setRotationPoint(9F, -8F, -4F);
		swordSquareBallPart2.mirror = true;
		setRotation(swordSquareBallPart2, -0.2617994F, 0F, -0.1745329F);
		swordBlade2 = new ModelRenderer(this, 99, 0);
		swordBlade2.addBox(1F, 0.5F, -30F, 1, 2, 32);
		swordBlade2.setRotationPoint(9F, -8F, -4F);
		swordBlade2.mirror = true;
		setRotation(swordBlade2, -0.2617994F, 0F, -0.1745329F);
		swordBlade1 = new ModelRenderer(this, 105, 39);
		swordBlade1.addBox(0F, -1.5F, 1.5F, 3, 6, 1);
		swordBlade1.setRotationPoint(9F, -8F, -4F);
		swordBlade1.mirror = true;
		setRotation(swordBlade1, -0.2617994F, 0F, -0.1745329F);
		swordHandProtect = new ModelRenderer(this, 104, 0);
		swordHandProtect.addBox(1F, -0.5F, -2.5F, 1, 4, 4);
		swordHandProtect.setRotationPoint(9F, -8F, -4F);
		swordHandProtect.mirror = true;
		setRotation(swordHandProtect, -0.2617994F, 0F, -0.1745329F);
		swordBlade3 = new ModelRenderer(this, 104, 0);
		swordBlade3.addBox(2F, 0.5F, -12F, 1, 1, 3);
		swordBlade3.setRotationPoint(9F, -1.7F, -7.5F);
		swordBlade3.mirror = true;
		setRotation(swordBlade3, -0.9599311F, 0F, -0.1745329F);
		swordBlade4 = new ModelRenderer(this, 99, 0);
		swordBlade4.addBox(1F, 1.5F, -28F, 1, 2, 24);
		swordBlade4.setRotationPoint(9F, -8F, -4F);
		swordBlade4.mirror = true;
		setRotation(swordBlade4, -0.2617994F, 0F, -0.1745329F);
		swordBlade5 = new ModelRenderer(this, 104, 0);
		swordBlade5.addBox(2F, -0.5F, -10F, 1, 1, 3);
		swordBlade5.setRotationPoint(9F, -2F, -4F);
		swordBlade5.mirror = true;
		setRotation(swordBlade5, -0.9599311F, 0F, -0.1745329F);
		swordBlade6 = new ModelRenderer(this, 104, 0);
		swordBlade6.addBox(2F, 0.5F, -12F, 1, 1, 3);
		swordBlade6.setRotationPoint(9F, -1.5F, -5F);
		swordBlade6.mirror = true;
		setRotation(swordBlade6, -0.9599311F, 0F, -0.1745329F);

		//Shield
		shieldTopPart = new ModelRenderer(this, 0, 27);
		shieldTopPart.addBox(0F, -0.5F, -4F, 1, 6, 2);
		shieldTopPart.setRotationPoint(-12.5F, -10F, -5F);
		shieldTopPart.mirror = true;
		setRotation(shieldTopPart, -0.2617994F, 0F, 0.1745329F);
		sideShieldStalk1 = new ModelRenderer(this, 0, 27);
		sideShieldStalk1.addBox(0F, 8F, -4F, 1, 2, 16);
		sideShieldStalk1.setRotationPoint(-12.5F, -10F, -5F);
		sideShieldStalk1.mirror = true;
		setRotation(sideShieldStalk1, -0.2617994F, 0F, 0.1745329F);
		middleShieldPart = new ModelRenderer(this, 0, 27);
		middleShieldPart.addBox(0F, -4F, -2F, 1, 13, 14);
		middleShieldPart.setRotationPoint(-12.5F, -10F, -5F);
		middleShieldPart.mirror = true;
		setRotation(middleShieldPart, -0.2617994F, 0F, 0.1745329F);
		shieldTopPart1 = new ModelRenderer(this, 0, 27);
		shieldTopPart1.addBox(0F, 0.25F, -4F, 1, 4, 1);
		shieldTopPart1.setRotationPoint(-12.5F, -10F, -6F);
		shieldTopPart1.mirror = true;
		setRotation(shieldTopPart1, -0.2617994F, 0F, 0.1745329F);
		shieldHandle1 = new ModelRenderer(this, 0, 77);
		shieldHandle1.addBox(-1F, 2F, 2F, 5, 2, 1);
		shieldHandle1.setRotationPoint(-11.5F, -10F, -5F);
		shieldHandle1.mirror = true;
		setRotation(shieldHandle1, -0.2617994F, 0F, 0.1745329F);
		bottomShield2 = new ModelRenderer(this, 0, 27);
		bottomShield2.addBox(0F, -1.5F, 15F, 1, 8, 1);
		bottomShield2.setRotationPoint(-12.5F, -10F, -5F);
		bottomShield2.mirror = true;
		setRotation(bottomShield2, -0.2617994F, 0F, 0.1745329F);
		bottomShield1 = new ModelRenderer(this, 0, 27);
		bottomShield1.addBox(0F, -3.5F, 12F, 1, 12, 2);
		bottomShield1.setRotationPoint(-12.5F, -10F, -5F);
		bottomShield1.mirror = true;
		setRotation(bottomShield1, -0.2617994F, 0F, 0.1745329F);
		bottomShield3 = new ModelRenderer(this, 0, 27);
		bottomShield3.addBox(0F, -2.5F, 14F, 1, 10, 1);
		bottomShield3.setRotationPoint(-12.5F, -10F, -5F);
		bottomShield3.mirror = true;
		setRotation(bottomShield3, -0.2617994F, 0F, 0.1745329F);
		upperPartShield = new ModelRenderer(this, 39, 25);
		upperPartShield.addBox(-1F, -3F, 0F, 1, 11, 11);
		upperPartShield.setRotationPoint(-12.5F, -10F, -5F);
		upperPartShield.mirror = true;
		setRotation(upperPartShield, -0.2617994F, 0F, 0.1745329F);
		bottomShield4 = new ModelRenderer(this, 0, 27);
		bottomShield4.addBox(0F, 0F, 16F, 1, 5, 1);
		bottomShield4.setRotationPoint(-12.5F, -10F, -5F);
		bottomShield4.mirror = true;
		setRotation(bottomShield4, -0.2617994F, 0F, 0.1745329F);
		bottomShield5 = new ModelRenderer(this, 85, 32);
		bottomShield5.addBox(-1F, 0F, 14F, 1, 5, 1);
		bottomShield5.setRotationPoint(-12.5F, -10F, -5F);
		bottomShield5.mirror = true;
		setRotation(bottomShield5, -0.2617994F, 0F, 0.1745329F);
		bottomShield6 = new ModelRenderer(this, 80, 30);
		bottomShield6.addBox(-1F, -1F, 13F, 1, 7, 1);
		bottomShield6.setRotationPoint(-12.5F, -10F, -5F);
		bottomShield6.mirror = true;
		setRotation(bottomShield6, -0.2617994F, 0F, 0.1745329F);
		bottomShield7 = new ModelRenderer(this, 66, 27);
		bottomShield7.addBox(-1F, 0.5F, -3F, 1, 4, 2);
		bottomShield7.setRotationPoint(-12.5F, -10F, -4F);
		bottomShield7.mirror = true;
		setRotation(bottomShield7, -0.2617994F, 0F, 0.1745329F);
		bottomShield8 = new ModelRenderer(this, 73, 27);
		bottomShield8.addBox(-1F, -2F, 11F, 1, 9, 2);
		bottomShield8.setRotationPoint(-12.5F, -10F, -5F);
		bottomShield8.mirror = true;
		setRotation(bottomShield8, -0.2617994F, 0F, 0.1745329F);
		sideShieldStalk2 = new ModelRenderer(this, 0, 27);
		sideShieldStalk2.addBox(0F, -5F, -4F, 1, 2, 16);
		sideShieldStalk2.setRotationPoint(-12.5F, -10F, -5F);
		sideShieldStalk2.mirror = true;
		setRotation(sideShieldStalk2, -0.2617994F, 0F, 0.1745329F);
		shieldHandle2 = new ModelRenderer(this, 0, 76);
		shieldHandle2.addBox(0F, 2F, 8F, 5, 2, 1);
		shieldHandle2.setRotationPoint(-11.5F, -10F, -5F);
		shieldHandle2.mirror = true;
		setRotation(shieldHandle2, -0.2617994F, 0F, 0.1745329F);
		shieldHandle3 = new ModelRenderer(this, 0, 77);
		shieldHandle3.addBox(4F, 2F, 2F, 1, 2, 7);
		shieldHandle3.setRotationPoint(-11.5F, -10F, -5F);
		shieldHandle3.mirror = true;
		setRotation(shieldHandle3, -0.2617994F, 0F, 0.1745329F);

		//Right leg
		rightLeg = new ModelRenderer(this, 78, 69);
		rightLeg.addBox(0F, 0F, -2.5F, 4, 13, 5);
		rightLeg.setRotationPoint(-4.5F, 9F, 3.0F);
		rightLeg.mirror = true;
		setRotation(rightLeg, 0F, 0F, 0.0174533F);
		rightUpperLeg = new ModelRenderer(this, 104, 55);
		rightUpperLeg.addBox(0F, 0F, -3F, 5, 12, 6);
		rightUpperLeg.setRotationPoint(-6F, -1.5F, 4F);
		rightUpperLeg.mirror = true;
		setRotation(rightUpperLeg, -0.0872665F, 0F, -0.0523599F);
		rightKneecap = new ModelRenderer(this, 17, 77);
		rightKneecap.addBox(0F, 0F, 0F, 4, 4, 4);
		rightKneecap.setRotationPoint(-4.7F, 8F, -1F);
		rightKneecap.mirror = true;
		setRotation(rightKneecap, 0F, 0F, -0.0523599F);

		//Left leg
		leftUpperLeg = new ModelRenderer(this, 104, 55);
		leftUpperLeg.addBox(0F, 0F, -3F, 5, 12, 6);
		leftUpperLeg.setRotationPoint(1F, -1.8F, 4F);
		leftUpperLeg.mirror = true;
		setRotation(leftUpperLeg, -0.0872665F, 0F, 0.0523599F);
		leftLeg = new ModelRenderer(this, 78, 69);
		leftLeg.addBox(0F, 0F, -2.5F, 4, 13, 5);
		leftLeg.setRotationPoint(0.5F, 9F, 3F);
		leftLeg.mirror = true;
		setRotation(leftLeg, 0F, 0F, 0.0174533F);
		leftKneecap = new ModelRenderer(this, 17, 77);
		leftKneecap.addBox(0F, 0F, 0F, 4, 4, 4);
		leftKneecap.setRotationPoint(0.7F, 8F, -1F);
		leftKneecap.mirror = true;
		setRotation(leftKneecap, 0F, 0F, 0.0523599F);

		//Wings
		setTextureOffset("Wing.Main", 0, 88);
		setTextureOffset("Wing.Part", 104, 76);
		rightWing = new ModelRenderer(this, "Wing");
		rightWing.mirror = true;
		rightWing.setRotationPoint(-3F, -24F, 7F);
		setRotation(rightWing, 0F, 0.4363323F, 0.4363323F);
		rightWing.addBox("Main", -25F, 0F, 0F, 25, 3, 1);
		rightWing.addBox("Part", -25F, 0F, 0F, 2, 45, 1);
		rightWing.addBox("Part", -19F, 0F, 0F, 2, 37, 1);
		rightWing.addBox("Part", -22F, 0F, 0F, 2, 41, 1);
		rightWing.addBox("Part", -16F, 0F, 0F, 2, 33, 1);
		rightWing.addBox("Part", -13F, 0F, 0F, 2, 29, 1);
		rightWing.addBox("Part", -10F, 0F, 0F, 2, 25, 1);
		rightWing.addBox("Part", -9F, 0F, 0.5F, 3, 23, 0);
		rightWing.addBox("Part", -7F, 0F, 0F, 2, 21, 1);
		rightWing.addBox("Part", -4F, 0F, 0F, 2, 17, 1);
		rightWing.addBox("Part", -6F, 0F, 0.5F, 3, 19, 0);
		rightWing.addBox("Part", -24F, 0F, 0.5F, 3, 43, 0);
		rightWing.addBox("Part", -12F, 0F, 0.5F, 3, 27, 0);
		rightWing.addBox("Part", -15F, 0F, 0.5F, 3, 31, 0);
		rightWing.addBox("Part", -18F, 0F, 0.5F, 3, 35, 0);
		rightWing.addBox("Part", -21F, 0F, 0.5F, 3, 39, 0);

		leftWing = new ModelRenderer(this, "Wing");
		leftWing.mirror = true;
		leftWing.setRotationPoint(3F, -24F, 7F);
		setRotation(leftWing, 0F, -0.4363323F, -0.4363323F);
		leftWing.addBox("Main", 0F, 0F, 0F, 25, 3, 1);
		leftWing.addBox("Part", 15F, 0F, 0.5F, 2, 35, 0);
		leftWing.addBox("Part", 20F, 0F, 0F, 2, 41, 1);
		leftWing.addBox("Part", 17F, 0F, 0F, 2, 37, 1);
		leftWing.addBox("Part", 14F, 0F, 0F, 2, 33, 1);
		leftWing.addBox("Part", 11F, 0F, 0F, 2, 29, 1);
		leftWing.addBox("Part", 8F, 0F, 0F, 2, 25, 1);
		leftWing.addBox("Part", 5F, 0F, 0F, 2, 21, 1);
		leftWing.addBox("Part", 2F, 0F, 0F, 2, 17, 1);
		leftWing.addBox("Part", 21F, 0F, 0.5F, 2, 43, 0);
		leftWing.addBox("Part", 23F, 0F, 0F, 2, 45, 1);
		leftWing.addBox("Part", 18F, 0F, 0.5F, 2, 39, 0);
		leftWing.addBox("Part", 3F, 0F, 0.5F, 2, 19, 0);
		leftWing.addBox("Part", 12F, 0F, 0.5F, 2, 31, 0);
		leftWing.addBox("Part", 9F, 0F, 0.5F, 2, 27, 0);
		leftWing.addBox("Part", 6F, 0F, 0.5F, 2, 23, 0);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		hips.render(f5);
		leftUpperLeg.render(f5);
		rightUpperLeg.render(f5);
		rightKneecap.render(f5);
		leftLeg.render(f5);
		chest.render(f5);
		belly.render(f5);
		rightShoulder.render(f5);
		rightArm.render(f5);
		leftShoulder.render(f5);
		leftArm.render(f5);
		breasts.render(f5);
		head.render(f5);
		neck.render(f5);
		leftHairLock.render(f5);
		rightHairLock.render(f5);
		backHair.render(f5);
		swordSquareBallPart.render(f5);
		shieldTopPart.render(f5);
		sideShieldStalk1.render(f5);
		middleShieldPart.render(f5);
		shieldTopPart1.render(f5);
		shieldHandle1.render(f5);
		bottomShield2.render(f5);
		bottomShield1.render(f5);
		bottomShield3.render(f5);
		upperPartShield.render(f5);
		bottomShield4.render(f5);
		bottomShield5.render(f5);
		bottomShield6.render(f5);
		bottomShield7.render(f5);
		bottomShield8.render(f5);
		sideShieldStalk2.render(f5);
		shieldHandle2.render(f5);
		shieldHandle3.render(f5);
		swordHandle.render(f5);
		swordSquareBallPart2.render(f5);
		swordBlade2.render(f5);
		swordBlade1.render(f5);
		swordHandProtect.render(f5);
		swordBlade3.render(f5);
		swordBlade4.render(f5);
		swordBlade5.render(f5);
		swordBlade6.render(f5);
		rightLeg.render(f5);
		leftKneecap.render(f5);
		rightWing.render(f5);
		leftWing.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float moveTime, float speed, float f2, float f3, float f4, float scale, Entity entity)
	{
		float pi = 3.1415926536F;
		moveTime *= 3;
		rightUpperLeg.rotateAngleX = (MathHelper.sin(moveTime / 40 * pi) / 2 - pi / 15) * speed;
		leftUpperLeg.rotateAngleX = (-MathHelper.sin(moveTime / 40 * pi) - pi / 15) * speed;

		float kneeAngle = MathHelper.sin((moveTime + 20) / 40 * pi) * speed;
		switch(((int) moveTime % 80) / 20)
		{
			case 0: //Left leg middle to front
			case 3: //Left leg back to middle
				leftLeg.rotateAngleX = leftUpperLeg.rotateAngleX + kneeAngle;
				rightLeg.rotateAngleX = rightUpperLeg.rotateAngleX - kneeAngle * MathHelper.sin((moveTime - 20) / 40 * pi) / 3;
				break;
			case 1: //Left leg front to middle
			case 2: //Left leg middle to back
				leftLeg.rotateAngleX = leftUpperLeg.rotateAngleX + kneeAngle * MathHelper.sin((moveTime + 20) / 40 * pi) / 3;
				rightLeg.rotateAngleX = rightUpperLeg.rotateAngleX - kneeAngle;
				break;
		}

		leftLeg.rotationPointZ = leftUpperLeg.rotationPointZ + MathHelper.sin(leftUpperLeg.rotateAngleX) * 10.8F;
		leftLeg.rotationPointY = leftUpperLeg.rotationPointY + MathHelper.cos(leftUpperLeg.rotateAngleX) * 10.8F;
		rightLeg.rotationPointZ = rightUpperLeg.rotationPointZ + MathHelper.sin(rightUpperLeg.rotateAngleX) * 10.8F;
		rightLeg.rotationPointY = rightUpperLeg.rotationPointY + MathHelper.cos(rightUpperLeg.rotateAngleX) * 10.8F;
		leftKneecap.rotationPointZ = leftLeg.rotationPointZ - 4;
		leftKneecap.rotationPointY = leftLeg.rotationPointY - 1;
		rightKneecap.rotationPointZ = rightLeg.rotationPointZ - 4;
		rightKneecap.rotationPointY = rightLeg.rotationPointY - 1;
	}
}
		
