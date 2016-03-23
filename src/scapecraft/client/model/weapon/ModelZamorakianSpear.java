package scapecraft.client.model.weapon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelZamorakianSpear extends ModelBase
{
	//fields
	ModelRenderer Handle;
	ModelRenderer BottomBack1;
	ModelRenderer BottomBack2;
	ModelRenderer BottomBack3;
	ModelRenderer BottomBack4;
	ModelRenderer MiddleBack1;
	ModelRenderer MiddleBack2;
	ModelRenderer MiddleBack3;
	ModelRenderer MiddleBack4;
	ModelRenderer MiddleBack5;
	ModelRenderer MiddleBack6;
	ModelRenderer Front1;
	ModelRenderer Front2;
	ModelRenderer Front3;
	ModelRenderer Front4;
	ModelRenderer Front5;
	ModelRenderer BackBottomPoint;
	ModelRenderer BackTopPoint;
	ModelRenderer FrontBottomPoint;
	ModelRenderer FrontTopPoint;

	public ModelZamorakianSpear()
	{
		textureWidth = 128;
		textureHeight = 64;

		Handle = new ModelRenderer(this, 11, 1);
		Handle.addBox(-0.5F, 0F, -0.5F, 1, 40, 1);
		Handle.setRotationPoint(0F, -11F, 0F);
		BottomBack1 = new ModelRenderer(this, 0, 0);
		BottomBack1.addBox(-0.5F, 2F, 0F, 1, 1, 2);
		BottomBack1.setRotationPoint(0F, -8F, 0F);
		BottomBack1.rotateAngleX = 0.0174533F;
		BottomBack2 = new ModelRenderer(this, 0, 0);
		BottomBack2.addBox(-0.5F, -1.2F, 2.6F, 1, 1, 2);
		BottomBack2.setRotationPoint(0F, -8F, 0F);
		BottomBack2.rotateAngleX = -1.22173F;
		BottomBack3 = new ModelRenderer(this, 0, 0);
		BottomBack3.addBox(-0.5F, 3.9F, 1.7F, 1, 2, 1);
		BottomBack3.setRotationPoint(0F, -8F, 0F);
		BottomBack4 = new ModelRenderer(this, 0, 0);
		BottomBack4.addBox(-0.5F, 1.8F, 0.7F, 1, 1, 2);
		BottomBack4.setRotationPoint(0F, -8F, 0F);
		BottomBack4.rotateAngleX = -0.2792527F;
		MiddleBack1 = new ModelRenderer(this, 0, 0);
		MiddleBack1.addBox(-0.5F, 0F, 0.2F, 1, 1, 1);
		MiddleBack1.setRotationPoint(0F, -8F, 0F);
		MiddleBack1.rotateAngleX = -0.5410521F;
		MiddleBack2 = new ModelRenderer(this, 0, 0);
		MiddleBack2.addBox(-0.5F, -1.4F, 0F, 1, 2, 1);
		MiddleBack2.setRotationPoint(0F, -8F, 0F);
		MiddleBack3 = new ModelRenderer(this, 0, 0);
		MiddleBack3.addBox(-0.5F, -1.7F, -0.5F, 1, 1, 3);
		MiddleBack3.setRotationPoint(0F, -8F, 0F);
		MiddleBack4 = new ModelRenderer(this, 0, 0);
		MiddleBack4.addBox(-0.5F, -3F, 0F, 1, 1, 2);
		MiddleBack4.setRotationPoint(0F, -8F, 0F);
		MiddleBack4.rotateAngleX = -0.9948377F;
		MiddleBack5 = new ModelRenderer(this, 0, 0);
		MiddleBack5.addBox(-0.5F, 0F, 2.6F, 1, 2, 1);
		MiddleBack5.setRotationPoint(0F, -8F, 0F);
		MiddleBack6 = new ModelRenderer(this, 0, 0);
		MiddleBack6.addBox(-0.5F, -2F, -1.3F, 1, 1, 1);
		MiddleBack6.setRotationPoint(0F, -8F, 0F);
		MiddleBack6.rotateAngleX = -0.7853982F;
		Front1 = new ModelRenderer(this, 0, 0);
		Front1.addBox(-0.5F, -1.7F, 0F, 1, 1, 1);
		Front1.setRotationPoint(0F, -8F, 0F);
		Front1.rotateAngleX = 0.7853982F;
		Front2 = new ModelRenderer(this, 0, 0);
		Front2.addBox(-0.5F, -1.3F, -2.6F, 1, 1, 2);
		Front2.setRotationPoint(0F, -8F, 0F);
		Front3 = new ModelRenderer(this, 0, 0);
		Front3.addBox(-0.5F, -3.4F, -2.2F, 1, 2, 1);
		Front3.setRotationPoint(0F, -8F, 0F);
		Front3.rotateAngleX = 0.4537856F;
		Front4 = new ModelRenderer(this, 0, 0);
		Front4.addBox(-0.5F, -2.4F, -3.78F, 1, 1, 1);
		Front4.setRotationPoint(0F, -8F, 0F);
		Front4.rotateAngleX = -0.1919862F;
		Front5 = new ModelRenderer(this, 0, 0);
		Front5.addBox(-0.5F, -0.8F, -1F, 1, 2, 1);
		Front5.setRotationPoint(0F, -8F, 0F);
		Front5.rotateAngleX = 0.4014257F;
		BackBottomPoint = new ModelRenderer(this, 0, 0);
		BackBottomPoint.addBox(-0.5F, -5F, -0.9F, 1, 2, 1);
		BackBottomPoint.setRotationPoint(0F, -8F, 0F);
		BackBottomPoint.rotateAngleX = -0.1396263F;
		BackTopPoint = new ModelRenderer(this, 0, 0);
		BackTopPoint.addBox(-0.5F, -7.8F, 0.3F, 1, 3, 1);
		BackTopPoint.setRotationPoint(0F, -8F, 0F);
		BackTopPoint.rotateAngleX = 0.1047198F;
		FrontBottomPoint = new ModelRenderer(this, 0, 0);
		FrontBottomPoint.addBox(-0.5F, -5F, -0.1F, 1, 2, 1);
		FrontBottomPoint.setRotationPoint(0F, -8F, 0F);
		FrontBottomPoint.rotateAngleX = 0.1396263F;
		FrontTopPoint = new ModelRenderer(this, 0, 0);
		FrontTopPoint.addBox(-0.5F, -7.8F, -1.3F, 1, 3, 1);
		FrontTopPoint.setRotationPoint(0F, -8F, 0F);
		FrontTopPoint.rotateAngleX = -0.1047198F;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		Handle.render(f5);
		BottomBack1.render(f5);
		BottomBack2.render(f5);
		BottomBack3.render(f5);
		BottomBack4.render(f5);
		MiddleBack1.render(f5);
		MiddleBack2.render(f5);
		MiddleBack3.render(f5);
		MiddleBack4.render(f5);
		MiddleBack5.render(f5);
		MiddleBack6.render(f5);
		Front1.render(f5);
		Front2.render(f5);
		Front3.render(f5);
		Front4.render(f5);
		Front5.render(f5);
		BackBottomPoint.render(f5);
		BackTopPoint.render(f5);
		FrontBottomPoint.render(f5);
		FrontTopPoint.render(f5);
	}

}
