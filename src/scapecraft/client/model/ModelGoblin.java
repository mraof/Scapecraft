package scapecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGoblin extends ModelBase
{
	//fields
	private final ModelRenderer foot1;
	private final ModelRenderer foot2;
	private final ModelRenderer shin2;
	private final ModelRenderer shin1;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer lowerBody;
	private final ModelRenderer upperBody;
	private final ModelRenderer arm1;
	private final ModelRenderer wrist1;
	private final ModelRenderer hand1;
	private final ModelRenderer arm2;
	private final ModelRenderer wrist2;
	private final ModelRenderer hand2;
	private final ModelRenderer neck;
	private final ModelRenderer head;
	private final ModelRenderer ear1;
	private final ModelRenderer ear2;

	public ModelGoblin()
	{
		textureWidth = 128;
		textureHeight = 64;

		foot1 = new ModelRenderer(this, 107, 55);
		foot1.addBox(-2F, 7F, -5F, 4, 2, 6);
		foot1.setRotationPoint(-6F, 15F, -4F);
		setRotation(foot1, 0F, 0F, 0F);
		foot2 = new ModelRenderer(this, 107, 55);
		foot2.addBox(-2F, 7F, -5F, 4, 2, 6);
		foot2.setRotationPoint(6F, 15F, -4F);
		setRotation(foot2, 0F, 0F, 0F);
		shin2 = new ModelRenderer(this, 119, 43);
		shin2.addBox(-1F, 0F, -1F, 2, 8, 2);
		shin2.setRotationPoint(6F, 15F, -4F);
		setRotation(shin2, 0.4363323F, 0F, 0F);
		shin1 = new ModelRenderer(this, 119, 43);
		shin1.addBox(-1F, 0F, -1F, 2, 8, 2);
		shin1.setRotationPoint(-6F, 15F, -4F);
		setRotation(shin1, 0.4363323F, 0F, 0F);
		leg1 = new ModelRenderer(this, 119, 31);
		leg1.addBox(-1F, 0F, -1F, 2, 8, 2);
		leg1.setRotationPoint(-5F, 9F, -1F);
		setRotation(leg1, -0.4363323F, 0.4886922F, -0.0698132F);
		leg2 = new ModelRenderer(this, 119, 31);
		leg2.addBox(-1F, 0F, -1F, 2, 8, 2);
		leg2.setRotationPoint(5F, 9F, -1F);
		setRotation(leg2, -0.4363323F, -0.4886922F, 0.0698132F);
		lowerBody = new ModelRenderer(this, 2, 45);
		lowerBody.addBox(-5F, -4F, -3F, 12, 12, 6);
		lowerBody.setRotationPoint(-1F, 2F, 0F);
		setRotation(lowerBody, 0.1047198F, 0F, 0F);
		upperBody = new ModelRenderer(this, 2, 28);
		upperBody.addBox(-9F, -3.5F, -3.5F, 18, 7, 7);
		upperBody.setRotationPoint(0F, 0F, 0F);
		setRotation(upperBody, 0.2617994F, 0F, 0F);
		arm1 = new ModelRenderer(this, 99, 28);
		arm1.addBox(-2F, 0F, -1F, 2, 10, 2);
		arm1.setRotationPoint(-8F, -3F, 0F);
		setRotation(arm1, 0.5061455F, -0.3316126F, 0.5585054F);
		wrist1 = new ModelRenderer(this, 90, 42);
		wrist1.addBox(-1F, 0F, -1F, 2, 10, 2);
		wrist1.setRotationPoint(-14F, 3F, 3F);
		setRotation(wrist1, -0.6283185F, 0F, 0F);
		hand1 = new ModelRenderer(this, 84, 56);
		hand1.addBox(-2F, 0F, -6F, 4, 1, 6);
		hand1.setRotationPoint(-14F, 10F, -2F);
		setRotation(hand1, 0.6283185F, 0F, 0F);
		arm2 = new ModelRenderer(this, 90, 28);
		arm2.addBox(0F, 0F, -1F, 2, 10, 2);
		arm2.setRotationPoint(8F, -3F, 0F);
		setRotation(arm2, 0.5061455F, 0.3316126F, -0.5585054F);
		wrist2 = new ModelRenderer(this, 90, 42);
		wrist2.addBox(-1F, 0F, -1F, 2, 10, 2);
		wrist2.setRotationPoint(14F, 3F, 3F);
		setRotation(wrist2, -0.6283185F, 0F, 0F);
		hand2 = new ModelRenderer(this, 84, 56);
		hand2.addBox(-2F, 0F, -6F, 4, 1, 6);
		hand2.setRotationPoint(14F, 10F, -2F);
		setRotation(hand2, 0.6283185F, 0F, 0F);
		neck = new ModelRenderer(this, 42, 55);
		neck.addBox(-2F, -4F, -2F, 6, 4, 4);
		neck.setRotationPoint(-1F, -2F, -2F);
		setRotation(neck, 1.247446F, 0F, 0F);
		head = new ModelRenderer(this, 56, 31);
		head.addBox(-4F, -5F, -5F, 8, 11, 5);
		head.setRotationPoint(0F, -3F, -5F);
		setRotation(head, -0.2230717F, 0F, 0F);
		ear1 = new ModelRenderer(this, 4, 14);
		ear1.addBox(-1.5F, -9F, -0.5F, 3, 9, 1);
		ear1.setRotationPoint(-3F, -3F, -7F);
		setRotation(ear1, -0.296706F, -1.518436F, 0.5934119F);
		ear2 = new ModelRenderer(this, 13, 14);
		ear2.addBox(-1.5F, -9F, -0.5F, 3, 9, 1);
		ear2.setRotationPoint(3F, -3F, -7F);
		setRotation(ear2, 0.296706F, -1.518436F, 0.5934119F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		foot1.renderWithRotation(f5);
		foot2.renderWithRotation(f5);
		shin2.renderWithRotation(f5);
		shin1.renderWithRotation(f5);
		leg1.renderWithRotation(f5);
		leg2.renderWithRotation(f5);
		lowerBody.renderWithRotation(f5);
		upperBody.renderWithRotation(f5);
		arm1.renderWithRotation(f5);
		wrist1.renderWithRotation(f5);
		hand1.renderWithRotation(f5);
		arm2.renderWithRotation(f5);
		wrist2.renderWithRotation(f5);
		hand2.renderWithRotation(f5);
		neck.renderWithRotation(f5);
		head.renderWithRotation(f5);
		ear1.renderWithRotation(f5);
		ear2.renderWithRotation(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	private void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		setRotationAngles(f, f1, f2, f3, f4, f5, null);
		shin2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.0F * f1;
		shin1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
		foot2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.0F * f1;
		foot1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
	}

}
