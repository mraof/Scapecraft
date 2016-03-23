package scapecraft.client.model.weapon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDryrapier extends ModelBase
{
	//fields
	ModelRenderer hilt_1;
	ModelRenderer hilt_2;
	ModelRenderer hilt_3;
	ModelRenderer mid_section;
	ModelRenderer mid_section_2;
	ModelRenderer mid_section_3;
	ModelRenderer mid_section_4;
	ModelRenderer blade_start;
	ModelRenderer mid_blade;
	ModelRenderer tip;
	ModelRenderer blue_1;
	ModelRenderer edge_1;
	ModelRenderer edge_2;
	ModelRenderer edge_3;
	ModelRenderer edge_4;
	ModelRenderer blue_2;

	public ModelDryrapier()
	{
		textureWidth = 128;
		textureHeight = 128;

		hilt_1 = new ModelRenderer(this, 33, 11);
		hilt_1.addBox(0F, 0F, 0F, 8, 1, 8);
		hilt_1.setRotationPoint(-4F, 22F, -4F);
		hilt_1.setTextureSize(128, 128);
		hilt_1.mirror = true;
		setRotation(hilt_1, 0F, 0F, 0F);
		hilt_2 = new ModelRenderer(this, 33, 0);
		hilt_2.addBox(0F, 0F, 0F, 6, 3, 6);
		hilt_2.setRotationPoint(-3F, 19F, -3F);
		hilt_2.setTextureSize(128, 128);
		hilt_2.mirror = true;
		setRotation(hilt_2, 0F, 0F, 0F);
		hilt_3 = new ModelRenderer(this, 0, 104);
		hilt_3.addBox(0F, 0F, 0F, 4, 19, 4);
		hilt_3.setRotationPoint(-2F, 0F, -2F);
		hilt_3.setTextureSize(128, 128);
		hilt_3.mirror = true;
		setRotation(hilt_3, 0F, 0F, 0F);
		mid_section = new ModelRenderer(this, 33, 21);
		mid_section.addBox(0F, 0F, 0F, 12, 3, 12);
		mid_section.setRotationPoint(-6F, 0F, -6F);
		mid_section.setTextureSize(128, 128);
		mid_section.mirror = true;
		setRotation(mid_section, 0F, 0F, 0F);
		mid_section_2 = new ModelRenderer(this, 33, 37);
		mid_section_2.addBox(0F, 0F, 0F, 10, 2, 10);
		mid_section_2.setRotationPoint(-5F, -2F, -5F);
		mid_section_2.setTextureSize(128, 128);
		mid_section_2.mirror = true;
		setRotation(mid_section_2, 0F, 0F, 0F);
		mid_section_3 = new ModelRenderer(this, 33, 21);
		mid_section_3.addBox(0F, 0F, 0F, 8, 2, 8);
		mid_section_3.setRotationPoint(-4F, -4F, -4F);
		mid_section_3.setTextureSize(128, 128);
		mid_section_3.mirror = true;
		setRotation(mid_section_3, 0F, 0F, 0F);
		mid_section_4 = new ModelRenderer(this, 33, 51);
		mid_section_4.addBox(0F, 0F, 0F, 6, 5, 6);
		mid_section_4.setRotationPoint(-3F, -9F, -3F);
		mid_section_4.setTextureSize(128, 128);
		mid_section_4.mirror = true;
		setRotation(mid_section_4, 0F, 0F, 0F);
		blade_start = new ModelRenderer(this, 33, 63);
		blade_start.addBox(0F, 0F, 0F, 4, 13, 4);
		blade_start.setRotationPoint(-2F, -22F, -2F);
		blade_start.setTextureSize(128, 128);
		blade_start.mirror = true;
		setRotation(blade_start, 0F, 0F, 0F);
		mid_blade = new ModelRenderer(this, 33, 82);
		mid_blade.addBox(0F, -5F, 0F, 3, 8, 3);
		mid_blade.setRotationPoint(-1.5F, -30F, -1.5F);
		mid_blade.setTextureSize(128, 128);
		mid_blade.mirror = true;
		setRotation(mid_blade, 0F, 0F, 0F);
		tip = new ModelRenderer(this, 13, 30);
		tip.addBox(0F, -56F, 0F, 2, 20, 2);
		tip.setRotationPoint(-1F, -11F, -1F);
		tip.setTextureSize(128, 128);
		tip.mirror = true;
		setRotation(tip, 0F, 0F, 0F);
		blue_1 = new ModelRenderer(this, 14, 21);
		blue_1.addBox(0F, 0F, 0F, 3, 5, 3);
		blue_1.setRotationPoint(-1.5F, -27F, -1.5F);
		blue_1.setTextureSize(128, 128);
		blue_1.mirror = true;
		setRotation(blue_1, 0F, 0F, 0F);
		edge_1 = new ModelRenderer(this, 0, 14);
		edge_1.addBox(0F, 0F, 0F, 1, 12, 2);
		edge_1.setRotationPoint(-0.5F, -8F, -4F);
		edge_1.setTextureSize(128, 128);
		edge_1.mirror = true;
		setRotation(edge_1, -0.296706F, 0F, 0F);
		edge_2 = new ModelRenderer(this, 7, 0);
		edge_2.addBox(0F, 0F, 0F, 1, 12, 2);
		edge_2.setRotationPoint(-0.5F, -8F, 2F);
		edge_2.setTextureSize(128, 128);
		edge_2.mirror = true;
		setRotation(edge_2, 0.296706F, 0F, 0F);
		edge_3 = new ModelRenderer(this, 0, 0);
		edge_3.addBox(0F, 0F, 0F, 2, 12, 1);
		edge_3.setRotationPoint(-4F, -8F, -0.5F);
		edge_3.setTextureSize(128, 128);
		edge_3.mirror = true;
		setRotation(edge_3, 0F, 0F, 0.296706F);
		edge_4 = new ModelRenderer(this, 7, 15);
		edge_4.addBox(0F, 0F, 0F, 2, 12, 1);
		edge_4.setRotationPoint(2F, -7.5F, -0.5F);
		edge_4.setTextureSize(128, 128);
		edge_4.mirror = true;
		setRotation(edge_4, 0F, 0F, -0.296706F);
		blue_2 = new ModelRenderer(this, 0, 29);
		blue_2.addBox(0F, -1F, 0F, 3, 12, 3);
		blue_2.setRotationPoint(-1.5F, -46F, -1.5F);
		blue_2.setTextureSize(128, 128);
		blue_2.mirror = true;
		setRotation(blue_2, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		hilt_1.render(f5);
		hilt_2.render(f5);
		hilt_3.render(f5);
		mid_section.render(f5);
		mid_section_2.render(f5);
		mid_section_3.render(f5);
		mid_section_4.render(f5);
		blade_start.render(f5);
		mid_blade.render(f5);
		tip.render(f5);
		blue_1.render(f5);
		edge_1.render(f5);
		edge_2.render(f5);
		edge_3.render(f5);
		edge_4.render(f5);
		blue_2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}


}
