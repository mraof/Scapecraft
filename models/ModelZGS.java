package models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelZGS extends ModelBase
{
  //fields
        ModelRenderer HandlePiece1;
        ModelRenderer HandlePiece2;
        ModelRenderer HandlePiece3;
        ModelRenderer HandlePiece4;
        ModelRenderer HandlePiece5;
        ModelRenderer HiltPiece1;
        ModelRenderer HiltPiece2;
        ModelRenderer HiltPiece3;
        ModelRenderer HiltPiece4;
        ModelRenderer HiltPiece5;
        ModelRenderer HiltPiece6;
        ModelRenderer HiltPiece7;
        ModelRenderer HIltPiece8;
        ModelRenderer HiltPiece9;
        ModelRenderer HiltPiece10;
        ModelRenderer HiltPiece11;
        ModelRenderer HiltPiece12;
        ModelRenderer HiltPiece13;
        ModelRenderer HiltPiece14;
        ModelRenderer HiltPiece15;
        ModelRenderer Spike1;
        ModelRenderer Spike2;
        ModelRenderer Spike3;
        ModelRenderer Spike4;
        ModelRenderer Spike5;
        ModelRenderer Spike6;
        ModelRenderer Spike7;
        ModelRenderer Spike8;
        ModelRenderer Blade;
        ModelRenderer BladeSpike1;
        ModelRenderer BladeSpike2;
        ModelRenderer BladeSpike3;
        ModelRenderer BladeSpike4;
        ModelRenderer Curve1;
        ModelRenderer Curve2;
        ModelRenderer Curve3;
        ModelRenderer Curve4;
        ModelRenderer Curve5;
        ModelRenderer Curve6;
        ModelRenderer Curve7;
        ModelRenderer Curve8;
        ModelRenderer BladeTip1;
        ModelRenderer BladeTip2;
        ModelRenderer BladeTipBody;
        ModelRenderer Symbol1;
        ModelRenderer Symbol2;
        ModelRenderer Symbol3;
        ModelRenderer Symbol4;
        ModelRenderer Symbol5;
        ModelRenderer Symbol6;
        ModelRenderer Symbol7;
        ModelRenderer Symobl8;
        ModelRenderer Shape1;
        ModelRenderer Shape2;
  
  public ModelZGS()
  {
        textureWidth = 128;
        textureHeight = 64;
        
          HandlePiece1 = new ModelRenderer(this, 102, 57);
          HandlePiece1.addBox(0F, 0F, 0F, 10, 4, 3);
          HandlePiece1.setRotationPoint(-5F, 10.1F, -1F);
          HandlePiece1.setTextureSize(128, 64);
          HandlePiece1.mirror = true;
          setRotation(HandlePiece1, 0F, 0F, 0F);
          HandlePiece2 = new ModelRenderer(this, 112, 49);
          HandlePiece2.addBox(0F, 0F, 0F, 7, 6, 1);
          HandlePiece2.setRotationPoint(-3.5F, 4F, 0F);
          HandlePiece2.setTextureSize(128, 64);
          HandlePiece2.mirror = true;
          setRotation(HandlePiece2, 0F, 0F, 0F);
          HandlePiece3 = new ModelRenderer(this, 116, 44);
          HandlePiece3.addBox(0F, 0F, 0F, 5, 4, 1);
          HandlePiece3.setRotationPoint(-2.5F, 0F, 0F);
          HandlePiece3.setTextureSize(128, 64);
          HandlePiece3.mirror = true;
          setRotation(HandlePiece3, 0F, 0F, 0F);
          HandlePiece4 = new ModelRenderer(this, 113, 39);
          HandlePiece4.addBox(0F, 0F, 0F, 7, 4, 1);
          HandlePiece4.setRotationPoint(-3.5F, -4F, 0F);
          HandlePiece4.setTextureSize(128, 64);
          HandlePiece4.mirror = true;
          setRotation(HandlePiece4, 0F, 0F, 0F);
          HandlePiece5 = new ModelRenderer(this, 116, 33);
          HandlePiece5.addBox(0F, 0F, 0F, 5, 5, 1);
          HandlePiece5.setRotationPoint(-2.5F, -9F, 0F);
          HandlePiece5.setTextureSize(128, 64);
          HandlePiece5.mirror = true;
          setRotation(HandlePiece5, 0F, 0F, 0F);
          HiltPiece1 = new ModelRenderer(this, 67, 59);
          HiltPiece1.addBox(0F, 0F, 0F, 11, 2, 3);
          HiltPiece1.setRotationPoint(-5.5F, -10F, -1F);
          HiltPiece1.setTextureSize(128, 64);
          HiltPiece1.mirror = true;
          setRotation(HiltPiece1, 0F, 0F, 0F);
          HiltPiece2 = new ModelRenderer(this, 75, 56);
          HiltPiece2.addBox(0F, 0F, 0F, 8, 1, 2);
          HiltPiece2.setRotationPoint(-13F, -9.5F, -0.5F);
          HiltPiece2.setTextureSize(128, 64);
          HiltPiece2.mirror = true;
          setRotation(HiltPiece2, 0F, 0F, 0F);
          HiltPiece3 = new ModelRenderer(this, 82, 53);
          HiltPiece3.addBox(0F, 0F, 0F, 4, 1, 2);
          HiltPiece3.setRotationPoint(-14.5F, -12.1F, -0.5F);
          HiltPiece3.setTextureSize(128, 64);
          HiltPiece3.mirror = true;
          setRotation(HiltPiece3, 0F, 0F, 0.9093165F);
          HiltPiece4 = new ModelRenderer(this, 84, 50);
          HiltPiece4.addBox(0F, 0F, 0F, 3, 1, 2);
          HiltPiece4.setRotationPoint(-15.3F, -11.5F, -0.5F);
          HiltPiece4.setTextureSize(128, 64);
          HiltPiece4.mirror = true;
          setRotation(HiltPiece4, 0F, 0F, -1.003822F);
          HiltPiece5 = new ModelRenderer(this, 82, 47);
          HiltPiece5.addBox(0F, 0F, 0F, 4, 1, 2);
          HiltPiece5.setRotationPoint(-7.3F, -12.6F, -0.5F);
          HiltPiece5.setTextureSize(128, 64);
          HiltPiece5.mirror = true;
          setRotation(HiltPiece5, 0F, 0F, 0.8552113F);
          HiltPiece6 = new ModelRenderer(this, 84, 44);
          HiltPiece6.addBox(0F, 0F, 0F, 3, 1, 2);
          HiltPiece6.setRotationPoint(-8.1F, -12F, -0.5F);
          HiltPiece6.setTextureSize(128, 64);
          HiltPiece6.mirror = true;
          setRotation(HiltPiece6, 0F, 0F, -1.264072F);
          HiltPiece7 = new ModelRenderer(this, 84, 41);
          HiltPiece7.addBox(0F, 0F, 0F, 3, 1, 2);
          HiltPiece7.setRotationPoint(-7.2F, -14.8F, -0.5F);
          HiltPiece7.setTextureSize(128, 64);
          HiltPiece7.mirror = true;
          setRotation(HiltPiece7, 0F, 0F, -0.7063347F);
          HIltPiece8 = new ModelRenderer(this, 86, 38);
          HIltPiece8.addBox(0F, 0F, 0F, 2, 1, 2);
          HIltPiece8.setRotationPoint(-4.9F, -16.8F, -0.5F);
          HIltPiece8.setTextureSize(128, 64);
          HIltPiece8.mirror = true;
          setRotation(HIltPiece8, 0F, 0F, 0.5205006F);
          HiltPiece9 = new ModelRenderer(this, 75, 56);
          HiltPiece9.addBox(0F, 0F, 0F, 8, 1, 2);
          HiltPiece9.setRotationPoint(5F, -9.5F, -0.5F);
          HiltPiece9.setTextureSize(128, 64);
          HiltPiece9.mirror = true;
          setRotation(HiltPiece9, 0F, 0F, 0F);
          HiltPiece10 = new ModelRenderer(this, 82, 53);
          HiltPiece10.addBox(0F, 0F, 0F, 4, 1, 2);
          HiltPiece10.setRotationPoint(12.2F, -9.1F, -0.5F);
          HiltPiece10.setTextureSize(128, 64);
          HiltPiece10.mirror = true;
          setRotation(HiltPiece10, 0F, 0F, -0.9093165F);
          HiltPiece11 = new ModelRenderer(this, 84, 50);
          HiltPiece11.addBox(0F, 0F, 0F, 3, 1, 2);
          HiltPiece11.setRotationPoint(13.9F, -14.2F, -0.5F);
          HiltPiece11.setTextureSize(128, 64);
          HiltPiece11.mirror = true;
          setRotation(HiltPiece11, 0F, 0F, 1.003826F);
          HiltPiece12 = new ModelRenderer(this, 82, 47);
          HiltPiece12.addBox(0F, 0F, 0F, 4, 1, 2);
          HiltPiece12.setRotationPoint(4.8F, -10F, -0.5F);
          HiltPiece12.setTextureSize(128, 64);
          HiltPiece12.mirror = true;
          setRotation(HiltPiece12, 0F, 0F, -0.8552113F);
          HiltPiece13 = new ModelRenderer(this, 84, 44);
          HiltPiece13.addBox(0F, 0F, 0F, 3, 1, 2);
          HiltPiece13.setRotationPoint(7.3F, -15.2F, -0.5F);
          HiltPiece13.setTextureSize(128, 64);
          HiltPiece13.mirror = true;
          setRotation(HiltPiece13, 0F, 0F, 1.264072F);
          HiltPiece14 = new ModelRenderer(this, 84, 41);
          HiltPiece14.addBox(0F, 0F, 0F, 3, 1, 2);
          HiltPiece14.setRotationPoint(5.1F, -17.1F, -0.5F);
          HiltPiece14.setTextureSize(128, 64);
          HiltPiece14.mirror = true;
          setRotation(HiltPiece14, 0F, 0F, 0.7063347F);
          HiltPiece15 = new ModelRenderer(this, 86, 38);
          HiltPiece15.addBox(0F, 0F, 0F, 2, 1, 2);
          HiltPiece15.setRotationPoint(3.3F, -16.2F, -0.5F);
          HiltPiece15.setTextureSize(128, 64);
          HiltPiece15.mirror = true;
          setRotation(HiltPiece15, 0F, 0F, -0.5204921F);
          Spike1 = new ModelRenderer(this, 55, 60);
          Spike1.addBox(0F, 0F, 0F, 2, 2, 2);
          Spike1.setRotationPoint(-5F, -10F, -0.5F);
          Spike1.setTextureSize(128, 64);
          Spike1.mirror = true;
          setRotation(Spike1, 0F, 0F, 0.7853982F);
          Spike2 = new ModelRenderer(this, 57, 57);
          Spike2.addBox(0F, 0F, 0F, 1, 1, 2);
          Spike2.setRotationPoint(-8F, -9.2F, -0.5F);
          Spike2.setTextureSize(128, 64);
          Spike2.mirror = true;
          setRotation(Spike2, 0F, 0F, 0.7853982F);
          Spike3 = new ModelRenderer(this, 57, 57);
          Spike3.addBox(0F, 0F, 0F, 1, 1, 2);
          Spike3.setRotationPoint(-10F, -9.2F, -0.5F);
          Spike3.setTextureSize(128, 64);
          Spike3.mirror = true;
          setRotation(Spike3, 0F, 0F, 0.7853982F);
          Spike4 = new ModelRenderer(this, 57, 57);
          Spike4.addBox(0F, 0F, 0F, 1, 1, 2);
          Spike4.setRotationPoint(-12.3F, -9.2F, -0.5F);
          Spike4.setTextureSize(128, 64);
          Spike4.mirror = true;
          setRotation(Spike4, 0F, 0F, 0.7853982F);
          Spike5 = new ModelRenderer(this, 55, 60);
          Spike5.addBox(0F, 0F, 0F, 2, 2, 2);
          Spike5.setRotationPoint(5F, -9.9F, -0.5F);
          Spike5.setTextureSize(128, 64);
          Spike5.mirror = true;
          setRotation(Spike5, 0F, 0F, 0.7853982F);
          Spike6 = new ModelRenderer(this, 57, 57);
          Spike6.addBox(0F, 0F, 0F, 1, 1, 2);
          Spike6.setRotationPoint(8F, -9.2F, -0.5F);
          Spike6.setTextureSize(128, 64);
          Spike6.mirror = true;
          setRotation(Spike6, 0F, 0F, 0.7853982F);
          Spike7 = new ModelRenderer(this, 57, 57);
          Spike7.addBox(0F, 0F, 0F, 1, 1, 2);
          Spike7.setRotationPoint(10F, -9.2F, -0.5F);
          Spike7.setTextureSize(128, 64);
          Spike7.mirror = true;
          setRotation(Spike7, 0F, 0F, 0.7853982F);
          Spike8 = new ModelRenderer(this, 57, 57);
          Spike8.addBox(0F, 0F, 0F, 1, 1, 2);
          Spike8.setRotationPoint(12.3F, -9.2F, -0.5F);
          Spike8.setTextureSize(128, 64);
          Spike8.mirror = true;
          setRotation(Spike8, 0F, 0F, 0.7853982F);
          Blade = new ModelRenderer(this, 25, 27);
          Blade.addBox(0F, 0F, 0F, 6, 35, 2);
          Blade.setRotationPoint(-3F, -45F, -0.5F);
          Blade.setTextureSize(128, 64);
          Blade.mirror = true;
          setRotation(Blade, 0F, 0F, 0F);
          BladeSpike1 = new ModelRenderer(this, 27, 19);
          BladeSpike1.addBox(0F, 0F, 0F, 3, 3, 2);
          BladeSpike1.setRotationPoint(-2.5F, -23F, -0.5F);
          BladeSpike1.setTextureSize(128, 64);
          BladeSpike1.mirror = true;
          setRotation(BladeSpike1, 0F, 0F, 0.7853982F);
          BladeSpike2 = new ModelRenderer(this, 27, 19);
          BladeSpike2.addBox(0F, 0F, 0F, 3, 3, 2);
          BladeSpike2.setRotationPoint(2.4F, -23F, -0.5F);
          BladeSpike2.setTextureSize(128, 64);
          BladeSpike2.mirror = true;
          setRotation(BladeSpike2, 0F, 0F, 0.7853982F);
          BladeSpike3 = new ModelRenderer(this, 27, 19);
          BladeSpike3.addBox(0F, 0F, 0F, 3, 3, 2);
          BladeSpike3.setRotationPoint(-2.5F, -30F, -0.5F);
          BladeSpike3.setTextureSize(128, 64);
          BladeSpike3.mirror = true;
          setRotation(BladeSpike3, 0F, 0F, 0.7853982F);
          BladeSpike4 = new ModelRenderer(this, 27, 19);
          BladeSpike4.addBox(0F, 0F, 0F, 3, 3, 2);
          BladeSpike4.setRotationPoint(2.4F, -30F, -0.5F);
          BladeSpike4.setTextureSize(128, 64);
          BladeSpike4.mirror = true;
          setRotation(BladeSpike4, 0F, 0F, 0.7853982F);
          Curve1 = new ModelRenderer(this, 53, 0);
          Curve1.addBox(0F, 0F, 0F, 5, 1, 2);
          Curve1.setRotationPoint(1F, -34F, -0.5F);
          Curve1.setTextureSize(128, 64);
          Curve1.mirror = true;
          setRotation(Curve1, 0F, 0F, -0.7068583F);
          Curve2 = new ModelRenderer(this, 42, 0);
          Curve2.addBox(0F, 0F, 0F, 3, 1, 2);
          Curve2.setRotationPoint(4.8F, -37.3F, -0.5F);
          Curve2.setTextureSize(128, 64);
          Curve2.mirror = true;
          setRotation(Curve2, 0F, 0F, -0.148353F);
          Curve3 = new ModelRenderer(this, 31, 0);
          Curve3.addBox(0F, 0F, 0F, 3, 1, 2);
          Curve3.setRotationPoint(7.8F, -37.7F, -0.5F);
          Curve3.setTextureSize(128, 64);
          Curve3.mirror = true;
          setRotation(Curve3, 0F, 0F, 0.4276057F);
          Curve4 = new ModelRenderer(this, 20, 0);
          Curve4.addBox(0F, 0F, 0F, 3, 1, 2);
          Curve4.setRotationPoint(10.6F, -36.5F, -0.5F);
          Curve4.setTextureSize(128, 64);
          Curve4.mirror = true;
          setRotation(Curve4, 0F, 0F, 1.199041F);
          Curve5 = new ModelRenderer(this, 53, 0);
          Curve5.addBox(0F, 0F, 0F, 5, 1, 2);
          Curve5.setRotationPoint(-5F, -37.4F, -0.5F);
          Curve5.setTextureSize(128, 64);
          Curve5.mirror = true;
          setRotation(Curve5, 0F, 0F, 0.7068583F);
          Curve6 = new ModelRenderer(this, 42, 0);
          Curve6.addBox(0F, 0F, 0F, 3, 1, 2);
          Curve6.setRotationPoint(-7.9F, -37.8F, -0.5F);
          Curve6.setTextureSize(128, 64);
          Curve6.mirror = true;
          setRotation(Curve6, 0F, 0F, 0.148353F);
          Curve7 = new ModelRenderer(this, 31, 0);
          Curve7.addBox(0F, 0F, 0F, 3, 1, 2);
          Curve7.setRotationPoint(-10.6F, -36.6F, -0.5F);
          Curve7.setTextureSize(128, 64);
          Curve7.mirror = true;
          setRotation(Curve7, 0F, 0F, -0.4276057F);
          Curve8 = new ModelRenderer(this, 20, 0);
          Curve8.addBox(0F, 0F, 0F, 3, 1, 2);
          Curve8.setRotationPoint(-11.7F, -33.8F, -0.5F);
          Curve8.setTextureSize(128, 64);
          Curve8.mirror = true;
          setRotation(Curve8, 0F, 0F, -1.199041F);
          BladeTip1 = new ModelRenderer(this, 0, 0);
          BladeTip1.addBox(0F, 0F, 0F, 4, 1, 2);
          BladeTip1.setRotationPoint(0.2F, -47.8F, -0.5F);
          BladeTip1.setTextureSize(128, 64);
          BladeTip1.mirror = true;
          setRotation(BladeTip1, 0F, 0F, 0.7853982F);
          BladeTip2 = new ModelRenderer(this, 0, 0);
          BladeTip2.addBox(0F, 0F, 0F, 4, 1, 2);
          BladeTip2.setRotationPoint(-3F, -45F, -0.5F);
          BladeTip2.setTextureSize(128, 64);
          BladeTip2.mirror = true;
          setRotation(BladeTip2, 0F, 0F, -0.7853982F);
          BladeTipBody = new ModelRenderer(this, 0, 4);
          BladeTipBody.addBox(0F, 0F, 0F, 4, 4, 2);
          BladeTipBody.setRotationPoint(0F, -48F, -0.5F);
          BladeTipBody.setTextureSize(128, 64);
          BladeTipBody.mirror = true;
          setRotation(BladeTipBody, 0F, 0F, 0.7853982F);
          Symbol1 = new ModelRenderer(this, 93, 0);
          Symbol1.addBox(0F, 0F, 0F, 16, 2, 2);
          Symbol1.setRotationPoint(-8F, 14F, -0.5F);
          Symbol1.setTextureSize(128, 64);
          Symbol1.mirror = true;
          setRotation(Symbol1, 0F, 0F, 0F);
          Symbol2 = new ModelRenderer(this, 118, 4);
          Symbol2.addBox(0F, 0F, 0F, 3, 6, 2);
          Symbol2.setRotationPoint(-2F, 16F, -0.5F);
          Symbol2.setTextureSize(128, 64);
          Symbol2.mirror = true;
          setRotation(Symbol2, 0F, 0F, 0F);
          Symbol3 = new ModelRenderer(this, 122, 12);
          Symbol3.addBox(0F, 0F, 0F, 2, 1, 1);
          Symbol3.setRotationPoint(-1.5F, 22F, 0F);
          Symbol3.setTextureSize(128, 64);
          Symbol3.mirror = true;
          setRotation(Symbol3, 0F, 0F, 0F);
          Symbol4 = new ModelRenderer(this, 124, 14);
          Symbol4.addBox(0F, 0F, 0F, 1, 1, 1);
          Symbol4.setRotationPoint(-1F, 23F, 0F);
          Symbol4.setTextureSize(128, 64);
          Symbol4.mirror = true;
          setRotation(Symbol4, 0F, 0F, 0F);
          Symbol5 = new ModelRenderer(this, 120, 17);
          Symbol5.addBox(0F, 0F, 0F, 2, 5, 2);
          Symbol5.setRotationPoint(9F, 16F, -0.5F);
          Symbol5.setTextureSize(128, 64);
          Symbol5.mirror = true;
          setRotation(Symbol5, 0F, 0F, 0F);
          Symbol6 = new ModelRenderer(this, 120, 17);
          Symbol6.addBox(0F, 0F, 0F, 1, 1, 1);
          Symbol6.setRotationPoint(9.5F, 21F, 0F);
          Symbol6.setTextureSize(128, 64);
          Symbol6.mirror = true;
          setRotation(Symbol6, 0F, 0F, 0F);
          Symbol7 = new ModelRenderer(this, 108, 4);
          Symbol7.addBox(0F, 0F, 0F, 2, 5, 2);
          Symbol7.setRotationPoint(-11.3F, 16.2F, -0.5F);
          Symbol7.setTextureSize(128, 64);
          Symbol7.mirror = true;
          setRotation(Symbol7, 0F, 0F, 0F);
          Symobl8 = new ModelRenderer(this, 108, 4);
          Symobl8.addBox(0F, 0F, 0F, 1, 1, 1);
          Symobl8.setRotationPoint(-10.8F, 21F, 0F);
          Symobl8.setTextureSize(128, 64);
          Symobl8.mirror = true;
          setRotation(Symobl8, 0F, 0F, 0F);
          Shape1 = new ModelRenderer(this, 95, 4);
          Shape1.addBox(0F, 0F, 0F, 4, 2, 2);
          Shape1.setRotationPoint(7.8F, 13.9F, -0.5F);
          Shape1.setTextureSize(128, 64);
          Shape1.mirror = true;
          setRotation(Shape1, 0F, 0F, 0.5934119F);
          Shape2 = new ModelRenderer(this, 95, 4);
          Shape2.addBox(0F, 0F, 0F, 4, 2, 2);
          Shape2.setRotationPoint(-11.3F, 16.2F, -0.5F);
          Shape2.setTextureSize(128, 64);
          Shape2.mirror = true;
          setRotation(Shape2, 0F, 0F, -0.5934119F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        HandlePiece1.render(f5);
        HandlePiece2.render(f5);
        HandlePiece3.render(f5);
        HandlePiece4.render(f5);
        HandlePiece5.render(f5);
        HiltPiece1.render(f5);
        HiltPiece2.render(f5);
        HiltPiece3.render(f5);
        HiltPiece4.render(f5);
        HiltPiece5.render(f5);
        HiltPiece6.render(f5);
        HiltPiece7.render(f5);
        HIltPiece8.render(f5);
        HiltPiece9.render(f5);
        HiltPiece10.render(f5);
        HiltPiece11.render(f5);
        HiltPiece12.render(f5);
        HiltPiece13.render(f5);
        HiltPiece14.render(f5);
        HiltPiece15.render(f5);
        Spike1.render(f5);
        Spike2.render(f5);
        Spike3.render(f5);
        Spike4.render(f5);
        Spike5.render(f5);
        Spike6.render(f5);
        Spike7.render(f5);
        Spike8.render(f5);
        Blade.render(f5);
        BladeSpike1.render(f5);
        BladeSpike2.render(f5);
        BladeSpike3.render(f5);
        BladeSpike4.render(f5);
        Curve1.render(f5);
        Curve2.render(f5);
        Curve3.render(f5);
        Curve4.render(f5);
        Curve5.render(f5);
        Curve6.render(f5);
        Curve7.render(f5);
        Curve8.render(f5);
        BladeTip1.render(f5);
        BladeTip2.render(f5);
        BladeTipBody.render(f5);
        Symbol1.render(f5);
        Symbol2.render(f5);
        Symbol3.render(f5);
        Symbol4.render(f5);
        Symbol5.render(f5);
        Symbol6.render(f5);
        Symbol7.render(f5);
        Symobl8.render(f5);
        Shape1.render(f5);
        Shape2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
	}

}