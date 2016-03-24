package scapecraft.client.model.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by Mraof on 2016 March 02.
 */
public class ModelFullHelm extends ModelBiped
{
	public ModelFullHelm()
	{
		textureWidth = 64;
		textureHeight = 64;

		this.bipedHead = new ModelRenderer(this, 0, 31);
		this.bipedHead.addBox(-5F, -9F, -5F, 10, 10, 10);
		this.bipedHead.setRotationPoint(0F, 0F, 0F);

		/*FaceRS = new ModelRenderer(this, 1, 48);
		FaceRS.addBox(-5F, -8F, -4F, 1, 7, 8);
		FaceRS.setRotationPoint(0F, 0F, 0F);
		setRotation(FaceRS, 0F);
		ModelRenderer faceLS = new ModelRenderer(this, 1, 32);
		faceLS.addBox(4F, -8F, -4F, 1, 7, 8);
		faceLS.setRotationPoint(0F, 0F, 0F);
		setRotation(faceLS, 0F);
		ModelRenderer faceBS = new ModelRenderer(this, 20, 43);
		faceBS.addBox(-5F, -8F, 4F, 10, 7, 1);
		faceBS.setRotationPoint(0F, 0F, 0F);
		setRotation(faceBS, 0F);
		ModelRenderer faceTS = new ModelRenderer(this, 20, 52);
		faceTS.addBox(-5F, -9F, -5F, 10, 1, 10);
		faceTS.setRotationPoint(0F, 0F, 0F);
		setRotation(faceTS, 0F);
		ModelRenderer faceFB = new ModelRenderer(this, 20, 39);
		faceFB.addBox(-5F, -3F, -5F, 10, 2, 1);
		faceFB.setRotationPoint(0F, 0F, 0F);
		setRotation(faceFB, 0F);
		ModelRenderer faceFT = new ModelRenderer(this, 20, 35);
		faceFT.addBox(-5F, -8F, -5F, 10, 2, 1);
		faceFT.setRotationPoint(0F, 0F, 0F);
		setRotation(faceFT, 0F);
		ModelRenderer face1P = new ModelRenderer(this, 43, 42);
		face1P.addBox(-5F, -6F, -5F, 1, 3, 1);
		face1P.setRotationPoint(0F, 0F, 0F);
		setRotation(face1P, 0F);
		ModelRenderer face2P = new ModelRenderer(this, 50, 47);
		face2P.addBox(-3F, -6F, -5F, 1, 3, 1);
		face2P.setRotationPoint(0F, 0F, 0F);
		setRotation(face2P, 0F);
		ModelRenderer face3P = new ModelRenderer(this, 43, 47);
		face3P.addBox(-1F, -6F, -5F, 2, 3, 1);
		face3P.setRotationPoint(0F, 0F, 0F);
		setRotation(face3P, 0F);
		ModelRenderer face4P = new ModelRenderer(this, 48, 42);
		face4P.addBox(2F, -6F, -5F, 1, 3, 1);
		face4P.setRotationPoint(0F, 0F, 0F);
		setRotation(face4P, 0F);
		ModelRenderer face5P = new ModelRenderer(this, 55, 47);
		face5P.addBox(4F, -6F, -5F, 1, 3, 1);
		face5P.setRotationPoint(0F, 0F, 0F);
		setRotation(face5P, 0F);*/
		ModelRenderer top2nd = new ModelRenderer(this, 43, 35);
		top2nd.addBox(-2F, -10F, -1F, 4, 1, 4);
		top2nd.setRotationPoint(0F, 0F, 0F);
		setRotation(top2nd, 0F);
		ModelRenderer feather1st = new ModelRenderer(this, 34, 0);
		feather1st.addBox(-1F, -11F, 0F, 2, 1, 2);
		feather1st.setRotationPoint(0F, 0F, 0F);
		setRotation(feather1st, 0F);
		ModelRenderer feather2nd = new ModelRenderer(this, 34, 4);
		feather2nd.addBox(-0.5F, -12F, 0.5F, 1, 1, 1);
		feather2nd.setRotationPoint(0F, 0F, 0F);
		setRotation(feather2nd, 0F);
		ModelRenderer feather3rd = new ModelRenderer(this, 34, 8);
		feather3rd.addBox(-0.5F, -12.5F, -3.5F, 1, 1, 1);
		feather3rd.setRotationPoint(0F, 0F, 0F);
		setRotation(feather3rd, -0.3490659F);
		ModelRenderer feather4th = new ModelRenderer(this, 44, 0);
		feather4th.addBox(-1F, -14F, -4F, 2, 2, 2);
		feather4th.setRotationPoint(0F, 0F, 0F);
		setRotation(feather4th, -0.3490659F);
		ModelRenderer feather5th = new ModelRenderer(this, 43, 6);
		feather5th.addBox(-1.5F, -19F, -5.5F, 3, 6, 3);
		feather5th.setRotationPoint(0F, 0F, 0F);
		setRotation(feather5th, -0.4363323F);
		ModelRenderer feather6th = new ModelRenderer(this, 43, 17);
		feather6th.addBox(-1.5F, -13F, 12.5F, 3, 7, 3);
		feather6th.setRotationPoint(0F, 0F, 0F);
		setRotation(feather6th, 0.6108652F);
		ModelRenderer feather7th = new ModelRenderer(this, 33, 12);
		feather7th.addBox(-1F, -16F, 1.733333F, 2, 5, 2);
		feather7th.setRotationPoint(0F, 0F, 0F);
		setRotation(feather7th, -0.3490659F);
		ModelRenderer feather8th = new ModelRenderer(this, 33, 21);
		feather8th.addBox(-1F, -7.5F, 8.666667F, 2, 5, 2);
		feather8th.setRotationPoint(0F, 0F, 0F);
		setRotation(feather8th, 0.3490659F);

		/*FaceRS.addChild(faceLS);
		FaceRS.addChild(faceBS);
		FaceRS.addChild(faceTS);
		FaceRS.addChild(faceFB);
		FaceRS.addChild(faceFT);
		FaceRS.addChild(face1P);
		FaceRS.addChild(face2P);
		FaceRS.addChild(face3P);
		FaceRS.addChild(face4P);
		FaceRS.addChild(face5P);*/
		bipedHead.addChild(top2nd);
		bipedHead.addChild(feather1st);
		bipedHead.addChild(feather2nd);
		bipedHead.addChild(feather3rd);
		bipedHead.addChild(feather4th);
		bipedHead.addChild(feather5th);
		bipedHead.addChild(feather6th);
		bipedHead.addChild(feather7th);
		bipedHead.addChild(feather8th);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		bipedHead.render(f5);
		//FaceRS.render(f5);
	}

	private void setRotation(ModelRenderer model, float x)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = 0F;
		model.rotateAngleZ = 0F;
	}

}
