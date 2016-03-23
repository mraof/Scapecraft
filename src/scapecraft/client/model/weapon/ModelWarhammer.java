package scapecraft.client.model.weapon;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWarhammer extends ModelBase
{
	//fields
	ModelRenderer hammerTop;
	ModelRenderer back;
	ModelRenderer front;
	ModelRenderer base;
	ModelRenderer grip;
	ModelRenderer end1;
	ModelRenderer end2;

	public ModelWarhammer()
	{
		textureWidth = 64;
		textureHeight = 64;

		hammerTop = new ModelRenderer(this, 0, 0);
		hammerTop.addBox(-5F, -4F, -2.5F, 10, 4, 5);
		hammerTop.setRotationPoint(0, 4F, 0F);
		back = new ModelRenderer(this, 32, 0);
		back.addBox(-1F, -3F, -3.5F, 2, 6, 7);
		back.setRotationPoint(-5F, 2F, 0F);
		front = new ModelRenderer(this, 0, 10);
		front.addBox(0F, -3F, -4F, 2, 7, 8);
		front.setRotationPoint(5F, 1.5F, 0F);
		base = new ModelRenderer(this, 22, 11);
		base.addBox(-1F, 0F, -1F, 2, 18, 2);
		base.setRotationPoint(0F, 4F, 0F);
		grip = new ModelRenderer(this, 0, 26);
		grip.addBox(-1.5F, 0F, -1.5F, 3, 5, 3);
		grip.setRotationPoint(0F, 14F, 0F);
		end1 = new ModelRenderer(this, 0, 35);
		end1.addBox(-1.5F, 0F, -1.5F, 3, 1, 3);
		end1.setRotationPoint(0F, 22F, 0F);
		end2 = new ModelRenderer(this, 0, 40);
		end2.addBox(-2F, 0F, -2F, 4, 1, 4);
		end2.setRotationPoint(0, 23F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		hammerTop.render(f5);
		back.render(f5);
		front.render(f5);
		base.render(f5);
		grip.render(f5);
		end1.render(f5);
		end2.render(f5);
	}
}
