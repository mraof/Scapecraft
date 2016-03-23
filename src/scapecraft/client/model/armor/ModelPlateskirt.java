package scapecraft.client.model.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by mraof on 2016 March 21 at 8:54 PM.
 */
public class ModelPlateskirt extends ModelBiped
{
    ModelRenderer left;
    ModelRenderer right;
    public ModelPlateskirt()
    {
        super();
        left = new ModelRenderer(this);
        left.addBox(-3F, -0.5F, -3F, 6, 6, 6);
        left.mirror = true;
        bipedLeftLeg.addChild(left);
        right = new ModelRenderer(this);
        right.addBox(-3F, -0.5F, -3F, 6, 6, 6);
        right.setTextureOffset(0, 24);
        right.mirror = true;
        bipedRightLeg.addChild(right);
    }

    @Override
    public void setRotationAngles(float time, float far, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entity)
    {
        super.setRotationAngles(time, far, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, entity);
        left.rotateAngleY = -bipedLeftLeg.rotateAngleX / 2;
        right.rotateAngleY = left.rotateAngleY;
    }
}
