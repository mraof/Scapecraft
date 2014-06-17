package models;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;



public class ModelDharok extends ModelBase
{
  //fields
    ModelRenderer BottomSpike;
    ModelRenderer TopSpike;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer HeadSpike;
    ModelRenderer Handle;
    ModelRenderer BottomRung;
    ModelRenderer MiddleRung;
    ModelRenderer TopRung;
    ModelRenderer AxeHeadBase;
    ModelRenderer AxeHeadSpike;
    ModelRenderer BackAxe1;
    ModelRenderer BackAxe2;
    ModelRenderer Faxe1;
    ModelRenderer FAxe2;
    ModelRenderer FAxe3;
    ModelRenderer FAxe4;
    ModelRenderer FAxe5;
    ModelRenderer FAxe6;
    ModelRenderer FAxe7;
    ModelRenderer FAxe8;
    ModelRenderer FAxe9;
    ModelRenderer FAxe10;
    ModelRenderer FillAxe1;
    ModelRenderer FillAxe2;
    ModelRenderer FillAxe3;
  
  public ModelDharok()
  {
	    textureWidth = 128;
	    textureHeight = 128;
	    
	      BottomSpike = new ModelRenderer(this, 115, 55);
	      BottomSpike.addBox(-8F, -2F, -1F, 3, 2, 2);
	      BottomSpike.setRotationPoint(-7F, -6F, 2F);
	      BottomSpike.setTextureSize(128, 128);
	      BottomSpike.mirror = true;
	      setRotation(BottomSpike, -0.6108652F, 0F, 0F);
	      TopSpike = new ModelRenderer(this, 115, 55);
	      TopSpike.addBox(-4F, -5F, -1F, 2, 3, 2);
	      TopSpike.setRotationPoint(-7F, -6F, 2F);
	      TopSpike.setTextureSize(128, 128);
	      TopSpike.mirror = true;
	      setRotation(TopSpike, -0.6108652F, 0F, 0F);
	      head = new ModelRenderer(this, 62, 48);
	      head.addBox(-6F, -12F, -6F, 12, 12, 12);
	      head.setRotationPoint(0F, -8F, 2F);
	      head.setTextureSize(128, 128);
	      head.mirror = true;
	      setRotation(head, 0F, 0F, 0F);
	      body = new ModelRenderer(this, 23, 102);
	      body.addBox(-6F, -8F, -4F, 12, 16, 8);
	      body.setRotationPoint(0F, 0F, 2F);
	      body.setTextureSize(128, 128);
	      body.mirror = true;
	      setRotation(body, 0F, 0F, 0F);
	      rightarm = new ModelRenderer(this, 67, 76);
	      rightarm.addBox(-5F, -2F, -4F, 6, 16, 8);
	      rightarm.setRotationPoint(-7F, -6F, 2F);
	      rightarm.setTextureSize(128, 128);
	      rightarm.mirror = true;
	      setRotation(rightarm, -0.6108652F, 0F, 0F);
	      leftarm = new ModelRenderer(this, 98, 76);
	      leftarm.addBox(-1F, -2F, -4F, 6, 16, 8);
	      leftarm.setRotationPoint(7F, -6F, 2F);
	      leftarm.setTextureSize(128, 128);
	      leftarm.mirror = true;
	      setRotation(leftarm, 0F, 0F, 0F);
	      rightleg = new ModelRenderer(this, 67, 102);
	      rightleg.addBox(-3F, 0F, -4F, 6, 16, 8);
	      rightleg.setRotationPoint(-3F, 8F, 2F);
	      rightleg.setTextureSize(128, 128);
	      rightleg.mirror = true;
	      setRotation(rightleg, 0F, 0F, 0F);
	      leftleg = new ModelRenderer(this, 98, 103);
	      leftleg.addBox(-3F, 0F, -4F, 6, 16, 8);
	      leftleg.setRotationPoint(3F, 8F, 2F);
	      leftleg.setTextureSize(128, 128);
	      leftleg.mirror = true;
	      setRotation(leftleg, 0F, 0F, 0F);
	      HeadSpike = new ModelRenderer(this, 115, 63);
	      HeadSpike.addBox(-1F, -13F, -8F, 2, 7, 2);
	      HeadSpike.setRotationPoint(0F, -8F, 2F);
	      HeadSpike.setTextureSize(128, 128);
	      HeadSpike.mirror = true;
	      setRotation(HeadSpike, -0.1487144F, 0F, 0F);
	      Handle = new ModelRenderer(this, 1, 22);
	      Handle.addBox(-3F, -20F, -13.9F, 2, 31, 2);
	      Handle.setRotationPoint(-7F, -6F, 2F);
	      Handle.setTextureSize(128, 128);
	      Handle.mirror = true;
	      setRotation(Handle, 0.9599311F, 0F, 0F);
	      BottomRung = new ModelRenderer(this, 10, 39);
	      BottomRung.addBox(-3.5F, 9.5F, -14.4F, 3, 2, 3);
	      BottomRung.setRotationPoint(-7F, -6F, 2F);
	      BottomRung.setTextureSize(128, 128);
	      BottomRung.mirror = true;
	      setRotation(BottomRung, 0.9599311F, 0F, 0F);
	      MiddleRung = new ModelRenderer(this, 10, 33);
	      MiddleRung.addBox(-3.5F, -9F, -14.4F, 3, 1, 3);
	      MiddleRung.setRotationPoint(-7F, -6F, 2F);
	      MiddleRung.setTextureSize(128, 128);
	      MiddleRung.mirror = true;
	      setRotation(MiddleRung, 0.9599311F, 0F, 0F);
	      TopRung = new ModelRenderer(this, 10, 26);
	      TopRung.addBox(-4F, -11F, -14.9F, 4, 1, 4);
	      TopRung.setRotationPoint(-7F, -6F, 2F);
	      TopRung.setTextureSize(128, 128);
	      TopRung.mirror = true;
	      setRotation(TopRung, 0.9599311F, 0F, 0F);
	      AxeHeadBase = new ModelRenderer(this, 1, 11);
	      AxeHeadBase.addBox(-3.5F, -19F, -14.4F, 3, 6, 3);
	      AxeHeadBase.setRotationPoint(-7F, -6F, 2F);
	      AxeHeadBase.setTextureSize(128, 128);
	      AxeHeadBase.mirror = true;
	      setRotation(AxeHeadBase, 0.9599311F, 0F, 0F);
	      AxeHeadSpike = new ModelRenderer(this, 10, 21);
	      AxeHeadSpike.addBox(-2.5F, -22F, -13.4F, 1, 3, 1);
	      AxeHeadSpike.setRotationPoint(-7F, -6F, 2F);
	      AxeHeadSpike.setTextureSize(128, 128);
	      AxeHeadSpike.mirror = true;
	      setRotation(AxeHeadSpike, 0.9599311F, 0F, 0F);
	      BackAxe1 = new ModelRenderer(this, 0, 0);
	      BackAxe1.addBox(-3F, -17F, -11.9F, 2, 2, 2);
	      BackAxe1.setRotationPoint(-7F, -6F, 2F);
	      BackAxe1.setTextureSize(128, 128);
	      BackAxe1.mirror = true;
	      setRotation(BackAxe1, 0.9599311F, 0F, 0F);
	      BackAxe2 = new ModelRenderer(this, 0, 0);
	      BackAxe2.addBox(-3F, -19.5F, 3.5F, 2, 4, 4);
	      BackAxe2.setRotationPoint(-7F, -6F, 2F);
	      BackAxe2.setTextureSize(128, 128);
	      BackAxe2.mirror = true;
	      setRotation(BackAxe2, 1.780236F, 0F, 0F);
	      Faxe1 = new ModelRenderer(this, 0, 0);
	      Faxe1.addBox(-3F, -17F, -16.9F, 2, 2, 3);
	      Faxe1.setRotationPoint(-7F, -6F, 2F);
	      Faxe1.setTextureSize(128, 128);
	      Faxe1.mirror = true;
	      setRotation(Faxe1, 0.9599311F, 0F, 0F);
	      FAxe2 = new ModelRenderer(this, 0, 0);
	      FAxe2.addBox(-3F, -22F, -10.4F, 2, 5, 1);
	      FAxe2.setRotationPoint(-7F, -6F, 2F);
	      FAxe2.setTextureSize(128, 128);
	      FAxe2.mirror = true;
	      setRotation(FAxe2, 1.219985F, 0F, 0F);
	      FAxe3 = new ModelRenderer(this, 0, 0);
	      FAxe3.addBox(-3F, -25.5F, -6.4F, 2, 3, 1);
	      FAxe3.setRotationPoint(-7F, -6F, 2F);
	      FAxe3.setTextureSize(128, 128);
	      FAxe3.mirror = true;
	      setRotation(FAxe3, 1.48353F, 0F, 0F);
	      FAxe4 = new ModelRenderer(this, 0, 0);
	      FAxe4.addBox(-3F, -3.7F, -26.8F, 2, 3, 1);
	      FAxe4.setRotationPoint(-7F, -6F, 2F);
	      FAxe4.setTextureSize(128, 128);
	      FAxe4.mirror = true;
	      setRotation(FAxe4, 0.2617994F, 0F, 0F);
	      FAxe5 = new ModelRenderer(this, 0, 0);
	      FAxe5.addBox(-3F, -17.8F, -20.1F, 2, 3, 1);
	      FAxe5.setRotationPoint(-7F, -6F, 2F);
	      FAxe5.setTextureSize(128, 128);
	      FAxe5.mirror = true;
	      setRotation(FAxe5, 0.9599311F, 0F, 0F);
	      FAxe6 = new ModelRenderer(this, 0, 0);
	      FAxe6.addBox(-3F, -22.5F, -10.9F, 2, 5, 1);
	      FAxe6.setRotationPoint(-7F, -6F, 2F);
	      FAxe6.setTextureSize(128, 128);
	      FAxe6.mirror = true;
	      setRotation(FAxe6, 1.448623F, 0F, 0F);
	      FAxe7 = new ModelRenderer(this, 0, 0);
	      FAxe7.addBox(-3F, 0.1F, -20.5F, 2, 2, 1);
	      FAxe7.setRotationPoint(-7F, -6F, 2F);
	      FAxe7.setTextureSize(128, 128);
	      FAxe7.mirror = true;
	      setRotation(FAxe7, 0.3316126F, 0F, 0F);
	      FAxe8 = new ModelRenderer(this, 0, 0);
	      FAxe8.addBox(-3F, -18.1F, -12F, 2, 2, 1);
	      FAxe8.setRotationPoint(-7F, -6F, 2F);
	      FAxe8.setTextureSize(128, 128);
	      FAxe8.mirror = true;
	      setRotation(FAxe8, 1.308997F, 0F, 0F);
	      FAxe9 = new ModelRenderer(this, 0, 0);
	      FAxe9.addBox(-3F, -14.8F, -17.4F, 2, 4, 1);
	      FAxe9.setRotationPoint(-7F, -6F, 2F);
	      FAxe9.setTextureSize(128, 128);
	      FAxe9.mirror = true;
	      setRotation(FAxe9, 0.9599311F, 0F, 0F);
	      FAxe10 = new ModelRenderer(this, 0, 0);
	      FAxe10.addBox(-3F, -1.8F, -22.6F, 2, 2, 1);
	      FAxe10.setRotationPoint(-7F, -6F, 2F);
	      FAxe10.setTextureSize(128, 128);
	      FAxe10.mirror = true;
	      setRotation(FAxe10, 0.2617994F, 0F, 0F);
	      FillAxe1 = new ModelRenderer(this, 0, 0);
	      FillAxe1.addBox(-3F, -18.2F, -16F, 2, 4, 2);
	      FillAxe1.setRotationPoint(-7F, -6F, 2F);
	      FillAxe1.setTextureSize(128, 128);
	      FillAxe1.mirror = true;
	      setRotation(FillAxe1, 1.134464F, 0F, 0F);
	      FillAxe2 = new ModelRenderer(this, 0, 0);
	      FillAxe2.addBox(-3F, -20.9F, -16.5F, 2, 4, 3);
	      FillAxe2.setRotationPoint(-7F, -6F, 2F);
	      FillAxe2.setTextureSize(128, 128);
	      FillAxe2.mirror = true;
	      setRotation(FillAxe2, 1.134464F, 0F, 0F);
	      FillAxe3 = new ModelRenderer(this, 0, 0);
	      FillAxe3.addBox(-3F, -21.9F, -15.3F, 2, 2, 1);
	      FillAxe3.setRotationPoint(-7F, -6F, 2F);
	      FillAxe3.setTextureSize(128, 128);
	      FillAxe3.mirror = true;
	      setRotation(FillAxe3, 1.134464F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    BottomSpike.renderWithRotation(f5);
    TopSpike.renderWithRotation(f5);
    head.renderWithRotation(f5);
    body.renderWithRotation(f5);
    rightarm.renderWithRotation(f5);
    leftarm.renderWithRotation(f5);
    rightleg.renderWithRotation(f5);
    leftleg.renderWithRotation(f5);
    HeadSpike.renderWithRotation(f5);
    Handle.renderWithRotation(f5);
    BottomRung.renderWithRotation(f5);
    MiddleRung.renderWithRotation(f5);
    TopRung.renderWithRotation(f5);
    AxeHeadBase.renderWithRotation(f5);
    AxeHeadSpike.renderWithRotation(f5);
    BackAxe1.renderWithRotation(f5);
    BackAxe2.renderWithRotation(f5);
    Faxe1.renderWithRotation(f5);
    FAxe2.renderWithRotation(f5);
    FAxe3.renderWithRotation(f5);
    FAxe4.renderWithRotation(f5);
    FAxe5.renderWithRotation(f5);
    FAxe6.renderWithRotation(f5);
    FAxe7.renderWithRotation(f5);
    FAxe8.renderWithRotation(f5);
    FAxe9.renderWithRotation(f5);
    FAxe10.renderWithRotation(f5);
    FillAxe1.renderWithRotation(f5);
    FillAxe2.renderWithRotation(f5);
    FillAxe3.renderWithRotation(f5);
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
	rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.0F * f1;
	leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
	
	rightarm.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + -0.610865238F;
	BottomSpike.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + -0.610865238F;
	TopSpike.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + -0.610865238F;
    Handle.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.959931089F;
    BottomRung.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.959931089F;
    MiddleRung.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.959931089F;
    TopRung.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.959931089F;
    AxeHeadBase.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.959931089F;
    AxeHeadSpike.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.959931089F;
    BackAxe1.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.959931089F;
    BackAxe2.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 1.780235837F;
    Faxe1.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.959931089F;
    FAxe2.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 1.219985147F;
    FAxe3.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 1.483529864F;
    FAxe4.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.261799388F;
    FAxe5.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.959931089F;
    FAxe6.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 1.448623279F;
    FAxe7.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.331612558F;
    FAxe8.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 1.308996939F;
    FAxe9.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.959931089F;
    FAxe10.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 0.261799388F;
    FillAxe1.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 1.134464014F;
    FillAxe2.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 1.134464014F;
    FillAxe3.rotateAngleX = MathHelper.cos(f * .5F + (float)Math.PI) * 0.7F * f1 + 1.134464014F;
  }

}