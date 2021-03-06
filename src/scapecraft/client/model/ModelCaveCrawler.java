package scapecraft.client.model;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelCaveCrawler extends ModelBase
{
	//fields
	ModelRenderer Body;
	ModelRenderer BackArmorPlate;
	ModelRenderer RBArmorSpike;
	ModelRenderer LBArmorSpike;
	ModelRenderer MiddleArmorPlate;
	ModelRenderer RMArmorSpike1;
	ModelRenderer RMArmorSpike2;
	ModelRenderer LMArmorSpike1;
	ModelRenderer LMArmorSpike2;
	ModelRenderer FrontArmorPlate;
	ModelRenderer RFArmorSpike1;
	ModelRenderer RFArmorSpike2;
	ModelRenderer LFArmorSpike1;
	ModelRenderer LFArmorSpike2;
	ModelRenderer Tail1;
	ModelRenderer Tail2;
	ModelRenderer Tail3;
	ModelRenderer Tail4;
	ModelRenderer RTailSpike1;
	ModelRenderer RTailSpike2;
	ModelRenderer LTailSpike1;
	ModelRenderer LTailSpike2;
	ModelRenderer TailArmor;
	ModelRenderer RFLeg1;
	ModelRenderer RFLeg2;
	ModelRenderer RFToe1;
	ModelRenderer RFToe2;
	ModelRenderer RFToe3;
	ModelRenderer RFToe4;
	ModelRenderer RMLeg1;
	ModelRenderer RMLeg2;
	ModelRenderer RMToe1;
	ModelRenderer RMToe2;
	ModelRenderer RMToe3;
	ModelRenderer RMToe4;
	ModelRenderer RBLeg1;
	ModelRenderer RBLeg2;
	ModelRenderer RBToe1;
	ModelRenderer RBToe2;
	ModelRenderer RBToe3;
	ModelRenderer RBToe4;
	ModelRenderer LFLeg1;
	ModelRenderer LFLeg2;
	ModelRenderer LFToe1;
	ModelRenderer LFToe2;
	ModelRenderer LFToe3;
	ModelRenderer LFToe4;
	ModelRenderer LMLeg1;
	ModelRenderer LMLeg2;
	ModelRenderer LMToe1;
	ModelRenderer LMToe2;
	ModelRenderer LMToe3;
	ModelRenderer LMToe4;
	ModelRenderer LBLeg1;
	ModelRenderer LBLeg2;
	ModelRenderer LBToe1;
	ModelRenderer LBToe2;
	ModelRenderer LBToe3;
	ModelRenderer LBToe4;
	ModelRenderer Head;
	ModelRenderer HeadArmorPlate;
	ModelRenderer REye;
	ModelRenderer LEye;
	ModelRenderer BottomHead;
	ModelRenderer Mouth;
	ModelRenderer Tongue;

	public ModelCaveCrawler()
	{
		textureWidth = 128;
		textureHeight = 64;

		Body = new ModelRenderer(this, 1, 41);
		Body.addBox(0F, 0F, 0F, 11, 5, 17);
		Body.setRotationPoint(-5.5F, 16F, -9F);
		Body.setTextureSize(128, 64);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		BackArmorPlate = new ModelRenderer(this, 59, 37);
		BackArmorPlate.addBox(0F, 0F, 0F, 6, 1, 3);
		BackArmorPlate.setRotationPoint(-3F, 15.4F, 3F);
		BackArmorPlate.setTextureSize(128, 64);
		BackArmorPlate.mirror = true;
		setRotation(BackArmorPlate, 0F, 0F, 0F);
		RBArmorSpike = new ModelRenderer(this, 113, 57);
		RBArmorSpike.addBox(-0.5F, -5F, -0.5F, 1, 5, 1);
		RBArmorSpike.setRotationPoint(-2F, 16F, 4F);
		RBArmorSpike.setTextureSize(128, 64);
		RBArmorSpike.mirror = true;
		setRotation(RBArmorSpike, -0.5235988F, 0F, 0F);
		LBArmorSpike = new ModelRenderer(this, 113, 57);
		LBArmorSpike.addBox(-0.5F, -5F, -0.5F, 1, 5, 1);
		LBArmorSpike.setRotationPoint(2F, 16F, 4F);
		LBArmorSpike.setTextureSize(128, 64);
		LBArmorSpike.mirror = true;
		setRotation(LBArmorSpike, -0.5235988F, 0F, 0F);
		MiddleArmorPlate = new ModelRenderer(this, 59, 50);
		MiddleArmorPlate.addBox(0F, 0F, 0F, 7, 1, 4);
		MiddleArmorPlate.setRotationPoint(-3.5F, 15.4F, -2F);
		MiddleArmorPlate.setTextureSize(128, 64);
		MiddleArmorPlate.mirror = true;
		setRotation(MiddleArmorPlate, 0F, 0F, 0F);
		RMArmorSpike1 = new ModelRenderer(this, 113, 49);
		RMArmorSpike1.addBox(-0.5F, -5F, -0.5F, 1, 5, 1);
		RMArmorSpike1.setRotationPoint(-2.5F, 16F, -0.5F);
		RMArmorSpike1.setTextureSize(128, 64);
		RMArmorSpike1.mirror = true;
		setRotation(RMArmorSpike1, -0.5235988F, 0F, 0F);
		RMArmorSpike2 = new ModelRenderer(this, 119, 59);
		RMArmorSpike2.addBox(-0.5F, -7.7F, -1.8F, 1, 3, 1);
		RMArmorSpike2.setRotationPoint(-2.5F, 16F, -0.5F);
		RMArmorSpike2.setTextureSize(128, 64);
		RMArmorSpike2.mirror = true;
		setRotation(RMArmorSpike2, -0.7853982F, 0F, 0F);
		LMArmorSpike1 = new ModelRenderer(this, 113, 49);
		LMArmorSpike1.addBox(-0.5F, -5F, -0.5F, 1, 5, 1);
		LMArmorSpike1.setRotationPoint(2.5F, 16F, -0.5F);
		LMArmorSpike1.setTextureSize(128, 64);
		LMArmorSpike1.mirror = true;
		setRotation(LMArmorSpike1, -0.5235988F, 0F, 0F);
		LMArmorSpike2 = new ModelRenderer(this, 119, 59);
		LMArmorSpike2.addBox(-0.5F, -7.7F, -1.8F, 1, 3, 1);
		LMArmorSpike2.setRotationPoint(2.5F, 16F, -0.5F);
		LMArmorSpike2.setTextureSize(128, 64);
		LMArmorSpike2.mirror = true;
		setRotation(LMArmorSpike2, -0.7853982F, 0F, 0F);
		FrontArmorPlate = new ModelRenderer(this, 59, 57);
		FrontArmorPlate.addBox(0F, 0F, 0F, 8, 1, 5);
		FrontArmorPlate.setRotationPoint(-4F, 15.4F, -8F);
		FrontArmorPlate.setTextureSize(128, 64);
		FrontArmorPlate.mirror = true;
		setRotation(FrontArmorPlate, 0F, 0F, 0F);
		RFArmorSpike1 = new ModelRenderer(this, 119, 52);
		RFArmorSpike1.addBox(-0.5F, -4F, -0.5F, 1, 4, 1);
		RFArmorSpike1.setRotationPoint(-3F, 16F, -6F);
		RFArmorSpike1.setTextureSize(128, 64);
		RFArmorSpike1.mirror = true;
		setRotation(RFArmorSpike1, -0.3490659F, 0F, 0F);
		RFArmorSpike2 = new ModelRenderer(this, 119, 45);
		RFArmorSpike2.addBox(-0.5F, -7.5F, -1.8F, 1, 4, 1);
		RFArmorSpike2.setRotationPoint(-3F, 16F, -6F);
		RFArmorSpike2.setTextureSize(128, 64);
		RFArmorSpike2.mirror = true;
		setRotation(RFArmorSpike2, -0.6981317F, 0F, 0F);
		LFArmorSpike1 = new ModelRenderer(this, 119, 52);
		LFArmorSpike1.addBox(-0.5F, -4F, -0.5F, 1, 4, 1);
		LFArmorSpike1.setRotationPoint(3F, 16F, -6F);
		LFArmorSpike1.setTextureSize(128, 64);
		LFArmorSpike1.mirror = true;
		setRotation(LFArmorSpike1, -0.3490659F, 0F, 0F);
		LFArmorSpike2 = new ModelRenderer(this, 119, 45);
		LFArmorSpike2.addBox(-0.5F, -7.5F, -1.8F, 1, 4, 1);
		LFArmorSpike2.setRotationPoint(3F, 16F, -6F);
		LFArmorSpike2.setTextureSize(128, 64);
		LFArmorSpike2.mirror = true;
		setRotation(LFArmorSpike2, -0.6981317F, 0F, 0F);
		Tail1 = new ModelRenderer(this, 87, 56);
		Tail1.addBox(0F, 0F, 0F, 9, 4, 3);
		Tail1.setRotationPoint(-4.5F, 16.5F, 7F);
		Tail1.setTextureSize(128, 64);
		Tail1.mirror = true;
		setRotation(Tail1, -0.1396263F, 0F, 0F);
		Tail2 = new ModelRenderer(this, 87, 47);
		Tail2.addBox(0F, -0.2F, 3F, 6, 4, 3);
		Tail2.setRotationPoint(-3F, 16.5F, 7F);
		Tail2.setTextureSize(128, 64);
		Tail2.mirror = true;
		setRotation(Tail2, -0.2268928F, 0F, 0F);
		Tail3 = new ModelRenderer(this, 87, 38);
		Tail3.addBox(0F, -0.5F, 5F, 4, 3, 4);
		Tail3.setRotationPoint(-2F, 17F, 7F);
		Tail3.setTextureSize(128, 64);
		Tail3.mirror = true;
		setRotation(Tail3, -0.296706F, 0F, 0F);
		Tail4 = new ModelRenderer(this, 87, 29);
		Tail4.addBox(0.5F, 0.7F, 7.5F, 3, 2, 5);
		Tail4.setRotationPoint(-2F, 17.5F, 7F);
		Tail4.setTextureSize(128, 64);
		Tail4.mirror = true;
		setRotation(Tail4, -0.1570796F, 0F, 0F);
		RTailSpike1 = new ModelRenderer(this, 113, 44);
		RTailSpike1.addBox(-0.5F, -2F, 0F, 1, 2, 1);
		RTailSpike1.setRotationPoint(-0.5F, 20F, 16.5F);
		RTailSpike1.setTextureSize(128, 64);
		RTailSpike1.mirror = true;
		setRotation(RTailSpike1, -0.1570796F, 0F, -0.3490659F);
		RTailSpike2 = new ModelRenderer(this, 113, 44);
		RTailSpike2.addBox(-0.5F, -2F, 0F, 1, 2, 1);
		RTailSpike2.setRotationPoint(-0.5F, 20F, 18F);
		RTailSpike2.setTextureSize(128, 64);
		RTailSpike2.mirror = true;
		setRotation(RTailSpike2, -0.1570796F, 0F, -0.3490659F);
		LTailSpike1 = new ModelRenderer(this, 113, 44);
		LTailSpike1.addBox(-0.5F, -2F, 0F, 1, 2, 1);
		LTailSpike1.setRotationPoint(0.5F, 20F, 16.5F);
		LTailSpike1.setTextureSize(128, 64);
		LTailSpike1.mirror = true;
		setRotation(LTailSpike1, -0.1570796F, 0F, 0.3490659F);
		LTailSpike2 = new ModelRenderer(this, 113, 44);
		LTailSpike2.addBox(-0.5F, -2F, 0F, 1, 2, 1);
		LTailSpike2.setRotationPoint(0.5F, 20F, 18F);
		LTailSpike2.setTextureSize(128, 64);
		LTailSpike2.mirror = true;
		setRotation(LTailSpike2, -0.1570796F, 0F, 0.3490659F);
		TailArmor = new ModelRenderer(this, 59, 30);
		TailArmor.addBox(0F, 0F, 0F, 4, 1, 4);
		TailArmor.setRotationPoint(-2F, 16.3F, 8.4F);
		TailArmor.setTextureSize(128, 64);
		TailArmor.mirror = true;
		setRotation(TailArmor, -0.2268928F, 0F, 0F);
		RFLeg1 = new ModelRenderer(this, 29, 13);
		RFLeg1.addBox(-4F, -0.5F, -2F, 4, 4, 4);
		RFLeg1.setRotationPoint(-3.5F, 19F, -5.5F);
		RFLeg1.setTextureSize(128, 64);
		RFLeg1.mirror = true;
		setRotation(RFLeg1, 0F, 0F, 0F);
		RFLeg2 = new ModelRenderer(this, 47, 16);
		RFLeg2.addBox(-3.5F, 3F, -1.5F, 3, 2, 3);
		RFLeg2.setRotationPoint(-3.5F, 19F, -5.5F);
		RFLeg2.setTextureSize(128, 64);
		RFLeg2.mirror = true;
		setRotation(RFLeg2, 0F, 0F, 0F);
		RFToe1 = new ModelRenderer(this, 7, 4);
		RFToe1.addBox(-4.5F, 4F, -1F, 1, 1, 2);
		RFToe1.setRotationPoint(-3.5F, 19F, -5.5F);
		RFToe1.setTextureSize(128, 64);
		RFToe1.mirror = true;
		setRotation(RFToe1, 0F, 0F, 0F);
		RFToe2 = new ModelRenderer(this, 1, 5);
		RFToe2.addBox(-5F, 4F, -0.5F, 1, 1, 1);
		RFToe2.setRotationPoint(-3.5F, 19F, -5.5F);
		RFToe2.setTextureSize(128, 64);
		RFToe2.mirror = true;
		setRotation(RFToe2, 0F, 0F, 0F);
		RFToe3 = new ModelRenderer(this, 7, 4);
		RFToe3.addBox(-0.5F, 4F, -1F, 1, 1, 2);
		RFToe3.setRotationPoint(-3.5F, 19F, -5.5F);
		RFToe3.setTextureSize(128, 64);
		RFToe3.mirror = true;
		setRotation(RFToe3, 0F, 0F, 0F);
		RFToe4 = new ModelRenderer(this, 1, 5);
		RFToe4.addBox(0F, 4F, -0.5F, 1, 1, 1);
		RFToe4.setRotationPoint(-3.5F, 19F, -5.5F);
		RFToe4.setTextureSize(128, 64);
		RFToe4.mirror = true;
		setRotation(RFToe4, 0F, 0F, 0F);
		RMLeg1 = new ModelRenderer(this, 29, 13);
		RMLeg1.addBox(-4F, -0.5F, -2F, 4, 4, 4);
		RMLeg1.setRotationPoint(-3.5F, 19F, 0F);
		RMLeg1.setTextureSize(128, 64);
		RMLeg1.mirror = true;
		setRotation(RMLeg1, 0F, 0F, 0F);
		RMLeg2 = new ModelRenderer(this, 47, 16);
		RMLeg2.addBox(-3.5F, 3F, -1.5F, 3, 2, 3);
		RMLeg2.setRotationPoint(-3.5F, 19F, 0F);
		RMLeg2.setTextureSize(128, 64);
		RMLeg2.mirror = true;
		setRotation(RMLeg2, 0F, 0F, 0F);
		RMToe1 = new ModelRenderer(this, 7, 4);
		RMToe1.addBox(-4.5F, 4F, -1F, 1, 1, 2);
		RMToe1.setRotationPoint(-3.5F, 19F, 0F);
		RMToe1.setTextureSize(128, 64);
		RMToe1.mirror = true;
		setRotation(RMToe1, 0F, 0F, 0F);
		RMToe2 = new ModelRenderer(this, 1, 5);
		RMToe2.addBox(-5F, 4F, -0.5F, 1, 1, 1);
		RMToe2.setRotationPoint(-3.5F, 19F, 0F);
		RMToe2.setTextureSize(128, 64);
		RMToe2.mirror = true;
		setRotation(RMToe2, 0F, 0F, 0F);
		RMToe3 = new ModelRenderer(this, 7, 4);
		RMToe3.addBox(-0.5F, 4F, -1F, 1, 1, 2);
		RMToe3.setRotationPoint(-3.5F, 19F, 0F);
		RMToe3.setTextureSize(128, 64);
		RMToe3.mirror = true;
		setRotation(RMToe3, 0F, 0F, 0F);
		RMToe4 = new ModelRenderer(this, 1, 5);
		RMToe4.addBox(0F, 4F, -0.5F, 1, 1, 1);
		RMToe4.setRotationPoint(-3.5F, 19F, 0F);
		RMToe4.setTextureSize(128, 64);
		RMToe4.mirror = true;
		setRotation(RMToe4, 0F, 0F, 0F);
		RBLeg1 = new ModelRenderer(this, 29, 13);
		RBLeg1.addBox(-4F, -0.5F, -2F, 4, 4, 4);
		RBLeg1.setRotationPoint(-3.5F, 19F, 5.5F);
		RBLeg1.setTextureSize(128, 64);
		RBLeg1.mirror = true;
		setRotation(RBLeg1, 0F, 0F, 0F);
		RBLeg2 = new ModelRenderer(this, 47, 16);
		RBLeg2.addBox(-3.5F, 3F, -1.5F, 3, 2, 3);
		RBLeg2.setRotationPoint(-3.5F, 19F, 5.5F);
		RBLeg2.setTextureSize(128, 64);
		RBLeg2.mirror = true;
		setRotation(RBLeg2, 0F, 0F, 0F);
		RBToe1 = new ModelRenderer(this, 7, 4);
		RBToe1.addBox(-4.5F, 4F, -1F, 1, 1, 2);
		RBToe1.setRotationPoint(-3.5F, 19F, 5.5F);
		RBToe1.setTextureSize(128, 64);
		RBToe1.mirror = true;
		setRotation(RBToe1, 0F, 0F, 0F);
		RBToe2 = new ModelRenderer(this, 1, 5);
		RBToe2.addBox(-5F, 4F, -0.5F, 1, 1, 1);
		RBToe2.setRotationPoint(-3.5F, 19F, 5.5F);
		RBToe2.setTextureSize(128, 64);
		RBToe2.mirror = true;
		setRotation(RBToe2, 0F, 0F, 0F);
		RBToe3 = new ModelRenderer(this, 7, 4);
		RBToe3.addBox(-0.5F, 4F, -1F, 1, 1, 2);
		RBToe3.setRotationPoint(-3.5F, 19F, 5.5F);
		RBToe3.setTextureSize(128, 64);
		RBToe3.mirror = true;
		setRotation(RBToe3, 0F, 0F, 0F);
		RBToe4 = new ModelRenderer(this, 1, 5);
		RBToe4.addBox(0F, 4F, -0.5F, 1, 1, 1);
		RBToe4.setRotationPoint(-3.5F, 19F, 5.5F);
		RBToe4.setTextureSize(128, 64);
		RBToe4.mirror = true;
		setRotation(RBToe4, 0F, 0F, 0F);
		LFLeg1 = new ModelRenderer(this, 29, 3);
		LFLeg1.addBox(0F, -0.5F, -2F, 4, 4, 4);
		LFLeg1.setRotationPoint(3.5F, 19F, -5.5F);
		LFLeg1.setTextureSize(128, 64);
		LFLeg1.mirror = true;
		setRotation(LFLeg1, 0F, 0F, 0F);
		LFLeg2 = new ModelRenderer(this, 47, 5);
		LFLeg2.addBox(0.5F, 3F, -1.5F, 3, 2, 3);
		LFLeg2.setRotationPoint(3.5F, 19F, -5.5F);
		LFLeg2.setTextureSize(128, 64);
		LFLeg2.mirror = true;
		setRotation(LFLeg2, 0F, 0F, 0F);
		LFToe1 = new ModelRenderer(this, 15, 4);
		LFToe1.addBox(3.5F, 4F, -1F, 1, 1, 2);
		LFToe1.setRotationPoint(3.5F, 19F, -5.5F);
		LFToe1.setTextureSize(128, 64);
		LFToe1.mirror = true;
		setRotation(LFToe1, 0F, 0F, 0F);
		LFToe2 = new ModelRenderer(this, 1, 5);
		LFToe2.addBox(4F, 4F, -0.5F, 1, 1, 1);
		LFToe2.setRotationPoint(3.5F, 19F, -5.5F);
		LFToe2.setTextureSize(128, 64);
		LFToe2.mirror = true;
		setRotation(LFToe2, 0F, 0F, 0F);
		LFToe3 = new ModelRenderer(this, 15, 4);
		LFToe3.addBox(-0.5F, 4F, -1F, 1, 1, 2);
		LFToe3.setRotationPoint(3.5F, 19F, -5.5F);
		LFToe3.setTextureSize(128, 64);
		LFToe3.mirror = true;
		setRotation(LFToe3, 0F, 0F, 0F);
		LFToe4 = new ModelRenderer(this, 1, 5);
		LFToe4.addBox(-1F, 4F, -0.5F, 1, 1, 1);
		LFToe4.setRotationPoint(3.5F, 19F, -5.5F);
		LFToe4.setTextureSize(128, 64);
		LFToe4.mirror = true;
		setRotation(LFToe4, 0F, 0F, 0F);
		LMLeg1 = new ModelRenderer(this, 29, 3);
		LMLeg1.addBox(0F, -0.5F, -2F, 4, 4, 4);
		LMLeg1.setRotationPoint(3.5F, 19F, 0F);
		LMLeg1.setTextureSize(128, 64);
		LMLeg1.mirror = true;
		setRotation(LMLeg1, 0F, 0F, 0F);
		LMLeg2 = new ModelRenderer(this, 47, 5);
		LMLeg2.addBox(0.5F, 3F, -1.5F, 3, 2, 3);
		LMLeg2.setRotationPoint(3.5F, 19F, 0F);
		LMLeg2.setTextureSize(128, 64);
		LMLeg2.mirror = true;
		setRotation(LMLeg2, 0F, 0F, 0F);
		LMToe1 = new ModelRenderer(this, 15, 4);
		LMToe1.addBox(3.5F, 4F, -1F, 1, 1, 2);
		LMToe1.setRotationPoint(3.5F, 19F, 0F);
		LMToe1.setTextureSize(128, 64);
		LMToe1.mirror = true;
		setRotation(LMToe1, 0F, 0F, 0F);
		LMToe2 = new ModelRenderer(this, 1, 5);
		LMToe2.addBox(4F, 4F, -0.5F, 1, 1, 1);
		LMToe2.setRotationPoint(3.5F, 19F, 0F);
		LMToe2.setTextureSize(128, 64);
		LMToe2.mirror = true;
		setRotation(LMToe2, 0F, 0F, 0F);
		LMToe3 = new ModelRenderer(this, 15, 4);
		LMToe3.addBox(-0.5F, 4F, -1F, 1, 1, 2);
		LMToe3.setRotationPoint(3.5F, 19F, 0F);
		LMToe3.setTextureSize(128, 64);
		LMToe3.mirror = true;
		setRotation(LMToe3, 0F, 0F, 0F);
		LMToe4 = new ModelRenderer(this, 1, 5);
		LMToe4.addBox(-1F, 4F, -0.5F, 1, 1, 1);
		LMToe4.setRotationPoint(3.5F, 19F, 0F);
		LMToe4.setTextureSize(128, 64);
		LMToe4.mirror = true;
		setRotation(LMToe4, 0F, 0F, 0F);
		LBLeg1 = new ModelRenderer(this, 29, 3);
		LBLeg1.addBox(0F, -0.5F, -2F, 4, 4, 4);
		LBLeg1.setRotationPoint(3.5F, 19F, 5.5F);
		LBLeg1.setTextureSize(128, 64);
		LBLeg1.mirror = true;
		setRotation(LBLeg1, 0F, 0F, 0F);
		LBLeg2 = new ModelRenderer(this, 47, 5);
		LBLeg2.addBox(0.5F, 3F, -1.5F, 3, 2, 3);
		LBLeg2.setRotationPoint(3.5F, 19F, 5.5F);
		LBLeg2.setTextureSize(128, 64);
		LBLeg2.mirror = true;
		setRotation(LBLeg2, 0F, 0F, 0F);
		LBToe1 = new ModelRenderer(this, 15, 4);
		LBToe1.addBox(3.5F, 4F, -1F, 1, 1, 2);
		LBToe1.setRotationPoint(3.5F, 19F, 5.5F);
		LBToe1.setTextureSize(128, 64);
		LBToe1.mirror = true;
		setRotation(LBToe1, 0F, 0F, 0F);
		LBToe2 = new ModelRenderer(this, 1, 5);
		LBToe2.addBox(4F, 4F, -0.5F, 1, 1, 1);
		LBToe2.setRotationPoint(3.5F, 19F, 5.5F);
		LBToe2.setTextureSize(128, 64);
		LBToe2.mirror = true;
		setRotation(LBToe2, 0F, 0F, 0F);
		LBToe3 = new ModelRenderer(this, 15, 4);
		LBToe3.addBox(-0.5F, 4F, -1F, 1, 1, 2);
		LBToe3.setRotationPoint(3.5F, 19F, 5.5F);
		LBToe3.setTextureSize(128, 64);
		LBToe3.mirror = true;
		setRotation(LBToe3, 0F, 0F, 0F);
		LBToe4 = new ModelRenderer(this, 1, 5);
		LBToe4.addBox(-1F, 4F, -0.5F, 1, 1, 1);
		LBToe4.setRotationPoint(3.5F, 19F, 5.5F);
		LBToe4.setTextureSize(128, 64);
		LBToe4.mirror = true;
		setRotation(LBToe4, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 1, 31);
		Head.addBox(0F, 0F, 0F, 8, 4, 5);
		Head.setRotationPoint(-4F, 16.1F, -14F);
		Head.setTextureSize(128, 64);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		HeadArmorPlate = new ModelRenderer(this, 87, 21);
		HeadArmorPlate.addBox(0F, 0F, -6F, 9, 1, 6);
		HeadArmorPlate.setRotationPoint(-4.5F, 15.8F, -8.5F);
		HeadArmorPlate.setTextureSize(128, 64);
		HeadArmorPlate.mirror = true;
		setRotation(HeadArmorPlate, 0.0523599F, 0F, 0F);
		REye = new ModelRenderer(this, 61, 10);
		REye.addBox(-1F, 0F, -3F, 1, 2, 3);
		REye.setRotationPoint(-3.2F, 17.1F, -10.2F);
		REye.setTextureSize(128, 64);
		REye.mirror = true;
		setRotation(REye, 0.0872665F, 0F, 0F);
		LEye = new ModelRenderer(this, 61, 16);
		LEye.addBox(0F, 0F, -3F, 1, 2, 3);
		LEye.setRotationPoint(3.2F, 17.1F, -10.2F);
		LEye.setTextureSize(128, 64);
		LEye.mirror = true;
		setRotation(LEye, 0.0872665F, 0F, 0F);
		BottomHead = new ModelRenderer(this, 1, 9);
		BottomHead.addBox(0F, 0F, -7F, 6, 3, 7);
		BottomHead.setRotationPoint(-3F, 17F, -13F);
		BottomHead.setTextureSize(128, 64);
		BottomHead.mirror = true;
		setRotation(BottomHead, 0F, 0F, 0F);
		Mouth = new ModelRenderer(this, 29, 31);
		Mouth.addBox(0F, 0F, -8F, 6, 3, 5);
		Mouth.setRotationPoint(-3F, 17F, -16F);
		Mouth.setTextureSize(128, 64);
		Mouth.mirror = true;
		setRotation(Mouth, 0F, 0F, 0F);
		Tongue = new ModelRenderer(this, 29, 23);
		Tongue.addBox(0F, 0F, -8F, 2, 1, 5);
		Tongue.setRotationPoint(-1F, 17.9F, -20.9F);
		Tongue.setTextureSize(128, 64);
		Tongue.mirror = true;
		setRotation(Tongue, 0.0349066F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Body.render(f5);
		BackArmorPlate.render(f5);
		RBArmorSpike.render(f5);
		LBArmorSpike.render(f5);
		MiddleArmorPlate.render(f5);
		RMArmorSpike1.render(f5);
		RMArmorSpike2.render(f5);
		LMArmorSpike1.render(f5);
		LMArmorSpike2.render(f5);
		FrontArmorPlate.render(f5);
		RFArmorSpike1.render(f5);
		RFArmorSpike2.render(f5);
		LFArmorSpike1.render(f5);
		LFArmorSpike2.render(f5);
		Tail1.render(f5);
		Tail2.render(f5);
		Tail3.render(f5);
		Tail4.render(f5);
		RTailSpike1.render(f5);
		RTailSpike2.render(f5);
		LTailSpike1.render(f5);
		LTailSpike2.render(f5);
		TailArmor.render(f5);
		RFLeg1.render(f5);
		RFLeg2.render(f5);
		RFToe1.render(f5);
		RFToe2.render(f5);
		RFToe3.render(f5);
		RFToe4.render(f5);
		RMLeg1.render(f5);
		RMLeg2.render(f5);
		RMToe1.render(f5);
		RMToe2.render(f5);
		RMToe3.render(f5);
		RMToe4.render(f5);
		RBLeg1.render(f5);
		RBLeg2.render(f5);
		RBToe1.render(f5);
		RBToe2.render(f5);
		RBToe3.render(f5);
		RBToe4.render(f5);
		LFLeg1.render(f5);
		LFLeg2.render(f5);
		LFToe1.render(f5);
		LFToe2.render(f5);
		LFToe3.render(f5);
		LFToe4.render(f5);
		LMLeg1.render(f5);
		LMLeg2.render(f5);
		LMToe1.render(f5);
		LMToe2.render(f5);
		LMToe3.render(f5);
		LMToe4.render(f5);
		LBLeg1.render(f5);
		LBLeg2.render(f5);
		LBToe1.render(f5);
		LBToe2.render(f5);
		LBToe3.render(f5);
		LBToe4.render(f5);
		Head.render(f5);
		HeadArmorPlate.render(f5);
		REye.render(f5);
		LEye.render(f5);
		BottomHead.render(f5);
		Mouth.render(f5);
		Tongue.render(f5);
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

		RFLeg1.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RFLeg2.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RFToe1.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RFToe2.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RFToe3.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RFToe4.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;

		RMLeg1.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RMLeg2.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RMToe1.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RMToe2.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RMToe3.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RMToe4.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;

		RBLeg1.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RBLeg2.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RBToe1.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RBToe2.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RBToe3.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;
		RBToe4.rotateAngleX = MathHelper.cos(f * 1F) * 0.7F * f1;

		LFLeg1.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LFLeg2.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LFToe1.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LFToe2.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LFToe3.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LFToe4.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;

		LMLeg1.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LMLeg2.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LMToe1.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LMToe2.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LMToe3.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LMToe4.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;

		LBLeg1.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LBLeg2.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LBToe1.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LBToe2.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LBToe3.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
		LBToe4.rotateAngleX = MathHelper.cos(f * 1F + (float)Math.PI) * 0.7F * f1;
	}

}
