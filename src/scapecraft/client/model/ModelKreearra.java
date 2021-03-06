package scapecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKreearra extends ModelBase
{
	//fields
	ModelRenderer beak_curv;
	ModelRenderer neck_chest_connector;
	ModelRenderer head;
	ModelRenderer spike_base;
	ModelRenderer nek_1;
	ModelRenderer upper_leg_1;
	ModelRenderer front_part_foot_1;
	ModelRenderer lower_leg_part_1;
	ModelRenderer nail_1;
	ModelRenderer foot_1;
	ModelRenderer body_1;
	ModelRenderer fore_arm_bracket_1;
	ModelRenderer shoulder_1;
	ModelRenderer lower_shoulder_1;
	ModelRenderer hand_1;
	ModelRenderer finger_1;
	ModelRenderer fore_arm_1;
	ModelRenderer bracket_connection_1;
	ModelRenderer right_wing_feather_1;
	ModelRenderer left_wing_feather_1;
	ModelRenderer feather_between_bracket_1;
	ModelRenderer spike_1;
	ModelRenderer beak1;
	ModelRenderer head_chord_1;
	ModelRenderer back_feather_1;
	ModelRenderer beak_2;
	ModelRenderer spike_2;
	ModelRenderer nek_2;
	ModelRenderer front_part_foot_2;
	ModelRenderer upper_leg_2;
	ModelRenderer back_feather_2;
	ModelRenderer lower_leg_part_2;
	ModelRenderer nail_2;
	ModelRenderer foot_2;
	ModelRenderer shoulder_2;
	ModelRenderer lower_shoulder_2;
	ModelRenderer hand_2;
	ModelRenderer finger_2;
	ModelRenderer fore_arm_bracket_2;
	ModelRenderer fore_arm_2;
	ModelRenderer bracket_connection_2;
	ModelRenderer right_wing_feather_2;
	ModelRenderer left_wing_feather_2;
	ModelRenderer feather_between_bracket_2;
	ModelRenderer head_chord_2;
	ModelRenderer body_2;
	ModelRenderer beak_3;
	ModelRenderer nek_3;
	ModelRenderer nail_3;
	ModelRenderer finger_3;
	ModelRenderer fore_arm_bracket_3;
	ModelRenderer bracket_connection_3;
	ModelRenderer right_wing_feather_3;
	ModelRenderer left_wing_feather_3;
	ModelRenderer spike_3;
	ModelRenderer back_feather_3;
	ModelRenderer nail_4;
	ModelRenderer finger_4;
	ModelRenderer right_wing_feather_4;
	ModelRenderer fore_arm_bracket_4;
	ModelRenderer bracket_connection_4;
	ModelRenderer left_wing_feather_4;
	ModelRenderer back_feather_4;
	ModelRenderer nail_5;
	ModelRenderer finger_5;
	ModelRenderer fore_arm_bracket_5;
	ModelRenderer right_wing_feather_5;
	ModelRenderer bracket_connection_5;
	ModelRenderer left_wing_feather_5;
	ModelRenderer back_feather_5;
	ModelRenderer nail_6;
	ModelRenderer finger_6;
	ModelRenderer fore_arm_bracket_6;
	ModelRenderer right_wing_feather_6;
	ModelRenderer bracket_connection_6;
	ModelRenderer left_wing_feather_6;
	ModelRenderer back_feather_6;
	ModelRenderer nail_7;
	ModelRenderer finger_7;
	ModelRenderer right_wing_feather_7;
	ModelRenderer left_wing_feather_7;
	ModelRenderer back_feather_7;
	ModelRenderer nail_8;
	ModelRenderer finger_8;
	ModelRenderer right_wing_feather_8;
	ModelRenderer left_wing_feather_8;
	ModelRenderer nail_9;
	ModelRenderer right_wing_feather_9;
	ModelRenderer left_wing_feather_9;
	ModelRenderer nail_10;
	ModelRenderer right_wing_feather_10;
	ModelRenderer left_wing_feather_10;
	ModelRenderer nail_11;
	ModelRenderer right_wing_feather_11;
	ModelRenderer left_wing_feather_11;
	ModelRenderer nail_12;
	ModelRenderer right_wing_feather_12;
	ModelRenderer left_wing_feather_12;
	ModelRenderer right_wing_feather_13;
	ModelRenderer left_wing_feather_13;

	public ModelKreearra()
	{
		textureWidth = 256;
		textureHeight = 128;

		beak_2 = new ModelRenderer(this, 8, 117);
		beak_2.addBox(0F, 0F, 0F, 3, 2, 1);
		beak_2.setRotationPoint(-1F, -10F, -20F);
		beak_2.setTextureSize(256, 128);
		setRotation(beak_2, 0.4363323F, 0F, 0F);
		beak_3 = new ModelRenderer(this, 2, 116);
		beak_3.addBox(0F, 0F, 0F, 3, 1, 5);
		beak_3.setRotationPoint(-1F, -7F, -16F);
		beak_3.setTextureSize(256, 128);
		setRotation(beak_3, 0.8726646F, 0F, 0F);
		beak_curv = new ModelRenderer(this, 2, 116);
		beak_curv.addBox(0F, 0F, 0F, 3, 2, 5);
		beak_curv.setRotationPoint(-1F, -10F, -20F);
		beak_curv.setTextureSize(256, 128);
		setRotation(beak_curv, 0.8726646F, 0F, 0F);
		spike_2 = new ModelRenderer(this, 4, 59);
		spike_2.addBox(0F, -0.2F, 0F, 1, 5, 1);
		spike_2.setRotationPoint(0F, -16F, -15F);
		spike_2.setTextureSize(256, 128);
		setRotation(spike_2, 0.3490659F, 0F, 0F);
		nek_1 = new ModelRenderer(this, 31, 29);
		nek_1.addBox(0.5F, 0F, 0F, 6, 7, 6);
		nek_1.setRotationPoint(-3F, -14F, -12F);
		nek_1.setTextureSize(256, 128);
		setRotation(nek_1, -0.1745329F, 0F, 0F);
		nek_2 = new ModelRenderer(this, 28, 45);
		nek_2.addBox(0F, 0F, 0F, 7, 7, 7);
		nek_2.setRotationPoint(-3F, -13F, -6F);
		nek_2.setTextureSize(256, 128);
		setRotation(nek_2, -0.4363323F, 0F, 0F);
		neck_chest_connector = new ModelRenderer(this, 153, 16);
		neck_chest_connector.addBox(0F, 0F, 0F, 9, 5, 5);
		neck_chest_connector.setRotationPoint(-4F, -5F, -4.4F);
		neck_chest_connector.setTextureSize(256, 128);
		setRotation(neck_chest_connector, 0.4363323F, 0F, 0F);
		nek_3 = new ModelRenderer(this, 27, 62);
		nek_3.addBox(0F, 0F, 0F, 9, 9, 6);
		nek_3.setRotationPoint(-4F, -12F, -1F);
		nek_3.setTextureSize(256, 128);
		setRotation(nek_3, -0.5759587F, 0F, 0F);
		front_part_foot_2 = new ModelRenderer(this, 73, 8);
		front_part_foot_2.addBox(0F, 0F, 0F, 5, 6, 3);
		front_part_foot_2.setRotationPoint(-6.6F, 9.2F, 26F);
		front_part_foot_2.setTextureSize(256, 128);
		setRotation(front_part_foot_2, 0.4363323F, -0.1745329F, 0F);
		upper_leg_2 = new ModelRenderer(this, 63, 60);
		upper_leg_2.addBox(0F, 0F, 1F, 5, 5, 12);
		upper_leg_2.setRotationPoint(-5F, -2.5F, 17.6F);
		upper_leg_2.setTextureSize(256, 128);
		setRotation(upper_leg_2, -0.7853982F, -0.1745329F, 0F);
		upper_leg_1 = new ModelRenderer(this, 63, 60);
		upper_leg_1.addBox(0F, 0F, 0F, 5, 5, 12);
		upper_leg_1.setRotationPoint(1F, -2F, 18.6F);
		upper_leg_1.setTextureSize(256, 128);
		setRotation(upper_leg_1, -0.7853982F, 0.1745329F, 0F);
		back_feather_2 = new ModelRenderer(this, 84, 44);
		back_feather_2.addBox(0F, 0.6F, -0.2F, 5, 0, 13);
		back_feather_2.setRotationPoint(1.5F, -2.9F, 21.6F);
		back_feather_2.setTextureSize(256, 128);
		setRotation(back_feather_2, 0.1745329F, 0.1919862F, 0F);
		front_part_foot_1 = new ModelRenderer(this, 73, 7);
		front_part_foot_1.addBox(0F, 0F, 0F, 5, 7, 3);
		front_part_foot_1.setRotationPoint(2.3F, 8F, 25.8F);
		front_part_foot_1.setTextureSize(256, 128);
		setRotation(front_part_foot_1, 0.4363323F, 0.1745329F, 0F);
		lower_leg_part_1 = new ModelRenderer(this, 100, 64);
		lower_leg_part_1.addBox(0F, 0F, 0F, 5, 5, 8);
		lower_leg_part_1.setRotationPoint(1.9F, 5F, 23.6F);
		lower_leg_part_1.setTextureSize(256, 128);
		setRotation(lower_leg_part_1, 0F, 0.1745329F, 0F);
		lower_leg_part_2 = new ModelRenderer(this, 100, 64);
		lower_leg_part_2.addBox(0F, 0F, 0F, 5, 5, 8);
		lower_leg_part_2.setRotationPoint(-6.1F, 5.2F, 23.3F);
		lower_leg_part_2.setTextureSize(256, 128);
		setRotation(lower_leg_part_2, 0F, -0.1745329F, 0F);
		nail_8 = new ModelRenderer(this, 20, 60);
		nail_8.addBox(4F, 0F, 0F, 1, 2, 1);
		nail_8.setRotationPoint(-7F, 15.2F, 28.3F);
		nail_8.setTextureSize(256, 128);
		setRotation(nail_8, 0.4363323F, -0.1745329F, 0F);
		nail_2 = new ModelRenderer(this, 20, 60);
		nail_2.addBox(4F, 1F, -2F, 1, 1, 1);
		nail_2.setRotationPoint(2.8F, 14.8F, 28.5F);
		nail_2.setTextureSize(256, 128);
		setRotation(nail_2, 1.570796F, 0.1745329F, 0F);
		nail_5 = new ModelRenderer(this, 20, 60);
		nail_5.addBox(0F, 0F, 0F, 1, 2, 1);
		nail_5.setRotationPoint(2.8F, 15F, 28.6F);
		nail_5.setTextureSize(256, 128);
		setRotation(nail_5, 0.4363323F, 0.1745329F, 0F);
		nail_1 = new ModelRenderer(this, 20, 60);
		nail_1.addBox(4F, 0F, 0F, 1, 2, 1);
		nail_1.setRotationPoint(2.8F, 15F, 28.6F);
		nail_1.setTextureSize(256, 128);
		setRotation(nail_1, 0.4363323F, 0.1745329F, 0F);
		nail_6 = new ModelRenderer(this, 20, 60);
		nail_6.addBox(0F, 1F, -2F, 1, 1, 1);
		nail_6.setRotationPoint(2.8F, 14.8F, 28.5F);
		nail_6.setTextureSize(256, 128);
		setRotation(nail_6, 1.570796F, 0.1745329F, 0F);
		nail_4 = new ModelRenderer(this, 20, 60);
		nail_4.addBox(2F, 1F, -2F, 1, 1, 1);
		nail_4.setRotationPoint(2.8F, 14.8F, 28.5F);
		nail_4.setTextureSize(256, 128);
		setRotation(nail_4, 1.570796F, 0.1745329F, 0F);
		nail_3 = new ModelRenderer(this, 20, 60);
		nail_3.addBox(2F, 0F, 0F, 1, 2, 1);
		nail_3.setRotationPoint(2.8F, 15F, 28.6F);
		nail_3.setTextureSize(256, 128);
		setRotation(nail_3, 0.4363323F, 0.1745329F, 0F);
		foot_2 = new ModelRenderer(this, 63, 45);
		foot_2.addBox(0F, 0F, 0F, 5, 10, 3);
		foot_2.setRotationPoint(-7F, 5.2F, 28.3F);
		foot_2.setTextureSize(256, 128);
		setRotation(foot_2, 0F, -0.1745329F, 0F);
		nail_7 = new ModelRenderer(this, 20, 60);
		nail_7.addBox(4F, 0.9F, -1.8F, 1, 1, 1);
		nail_7.setRotationPoint(-7F, 15.2F, 28.3F);
		nail_7.setTextureSize(256, 128);
		setRotation(nail_7, 1.570796F, -0.1745329F, 0F);
		nail_10 = new ModelRenderer(this, 20, 60);
		nail_10.addBox(2F, 0F, 0F, 1, 2, 1);
		nail_10.setRotationPoint(-7F, 15.2F, 28.3F);
		nail_10.setTextureSize(256, 128);
		setRotation(nail_10, 0.4363323F, -0.1745329F, 0F);
		nail_12 = new ModelRenderer(this, 20, 60);
		nail_12.addBox(0F, 0F, 0F, 1, 2, 1);
		nail_12.setRotationPoint(-7F, 15.2F, 28.3F);
		nail_12.setTextureSize(256, 128);
		setRotation(nail_12, 0.4363323F, -0.1745329F, 0F);
		nail_11 = new ModelRenderer(this, 20, 60);
		nail_11.addBox(0F, 0.9F, -1.8F, 1, 1, 1);
		nail_11.setRotationPoint(-7F, 15.2F, 28.3F);
		nail_11.setTextureSize(256, 128);
		setRotation(nail_11, 1.570796F, -0.1745329F, 0F);
		nail_9 = new ModelRenderer(this, 20, 60);
		nail_9.addBox(2F, 0.9F, -1.8F, 1, 1, 1);
		nail_9.setRotationPoint(-7F, 15.2F, 28.3F);
		nail_9.setTextureSize(256, 128);
		setRotation(nail_9, 1.570796F, -0.1745329F, 0F);
		foot_1 = new ModelRenderer(this, 63, 45);
		foot_1.addBox(0F, 0F, 0F, 5, 10, 3);
		foot_1.setRotationPoint(2.8F, 5F, 28.6F);
		foot_1.setTextureSize(256, 128);
		setRotation(foot_1, 0F, 0.1745329F, 0F);
		body_1 = new ModelRenderer(this, 25, 82);
		body_1.addBox(0F, 1.5F, 0F, 12, 12, 15);
		body_1.setRotationPoint(-5.5F, -12F, 4F);
		body_1.setTextureSize(256, 128);
		setRotation(body_1, -0.5410521F, 0F, 0F);
		fore_arm_bracket_1 = new ModelRenderer(this, 0, 95);
		fore_arm_bracket_1.addBox(9F, -2F, -0.5F, 3, 6, 6);
		fore_arm_bracket_1.setRotationPoint(21F, -14.5F, 1F);
		fore_arm_bracket_1.setTextureSize(256, 128);
		setRotation(fore_arm_bracket_1, 1.047198F, 0.1745329F, -0.2617994F);
		shoulder_1 = new ModelRenderer(this, 0, 17);
		shoulder_1.addBox(-3F, 0F, 0F, 12, 5, 5);
		shoulder_1.setRotationPoint(6F, -8F, 1F);
		shoulder_1.setTextureSize(256, 128);
		setRotation(shoulder_1, 0.9599311F, 0.0872665F, -0.5235988F);
		shoulder_2 = new ModelRenderer(this, 0, 17);
		shoulder_2.addBox(-3F, 0F, 0F, 11, 5, 5);
		shoulder_2.setRotationPoint(-5.5F, -8F, 1F);
		shoulder_2.setTextureSize(256, 128);
		setRotation(shoulder_2, 0.6632251F, 0.0872665F, -2.617994F);
		lower_shoulder_2 = new ModelRenderer(this, 0, 18);
		lower_shoulder_2.addBox(-1F, 0.8F, -1.4F, 10, 4, 4);
		lower_shoulder_2.setRotationPoint(-12.5F, -11F, 3F);
		lower_shoulder_2.setTextureSize(256, 128);
		setRotation(lower_shoulder_2, 0.6632251F, -0.0174533F, -2.844887F);
		finger_8 = new ModelRenderer(this, 17, 11);
		finger_8.addBox(2F, -0.9666666F, -1.8F, 3, 1, 1);
		finger_8.setRotationPoint(-29.5F, -18F, 4F);
		finger_8.setTextureSize(256, 128);
		setRotation(finger_8, 0.6981317F, -0.4886922F, 2.806985F);
		finger_7 = new ModelRenderer(this, 27, 7);
		finger_7.addBox(6F, -3.966667F, 2.2F, 1, 5, 1);
		finger_7.setRotationPoint(-29.5F, -18F, 4F);
		finger_7.setTextureSize(256, 128);
		setRotation(finger_7, 0.6632251F, -0.0872665F, -2.96706F);
		finger_6 = new ModelRenderer(this, 27, 7);
		finger_6.addBox(6F, -3.966667F, 0.2F, 1, 5, 1);
		finger_6.setRotationPoint(-29.5F, -18F, 4F);
		finger_6.setTextureSize(256, 128);
		setRotation(finger_6, 0.6632251F, -0.0872665F, -2.96706F);
		finger_5 = new ModelRenderer(this, 27, 7);
		finger_5.addBox(6F, -3.966667F, -1.8F, 1, 5, 1);
		finger_5.setRotationPoint(-29.5F, -18F, 4F);
		finger_5.setTextureSize(256, 128);
		setRotation(finger_5, 0.6632251F, -0.0872665F, -2.96706F);
		hand_2 = new ModelRenderer(this, 43, 17);
		hand_2.addBox(1F, -1.966667F, -1.8F, 5, 3, 5);
		hand_2.setRotationPoint(-29.5F, -18F, 4F);
		hand_2.setTextureSize(256, 128);
		setRotation(hand_2, 0.6632251F, -0.0872665F, -2.96706F);
		finger_2 = new ModelRenderer(this, 34, 7);
		finger_2.addBox(28.6F, 2.5F, -1F, 1, 1, 5);
		finger_2.setRotationPoint(9F, -13.5F, 1F);
		finger_2.setTextureSize(256, 128);
		setRotation(finger_2, 1.047198F, 0.1570796F, -0.2094395F);
		finger_2.mirror = true;
		lower_shoulder_1 = new ModelRenderer(this, 0, 17);
		lower_shoulder_1.addBox(0F, 0F, 1F, 15, 4, 4);
		lower_shoulder_1.setRotationPoint(9F, -9.5F, 1F);
		lower_shoulder_1.setTextureSize(256, 128);
		setRotation(lower_shoulder_1, 0.9599311F, 0.122173F, -0.418879F);
		hand_1 = new ModelRenderer(this, 42, 17);
		hand_1.addBox(23.6F, 0.5F, 1F, 5, 5, 3);
		hand_1.setRotationPoint(9F, -13.5F, 1F);
		hand_1.setTextureSize(256, 128);
		setRotation(hand_1, 1.047198F, 0.1570796F, -0.2094395F);
		finger_3 = new ModelRenderer(this, 34, 7);
		finger_3.addBox(28.6F, 4.5F, -1F, 1, 1, 5);
		finger_3.setRotationPoint(9F, -13.5F, 1F);
		finger_3.setTextureSize(256, 128);
		setRotation(finger_3, 1.047198F, 0.1570796F, -0.2094395F);
		finger_4 = new ModelRenderer(this, 49, 7);
		finger_4.addBox(0F, 0F, 1F, 1, 1, 5);
		finger_4.setRotationPoint(35F, -17.5F, -3F);
		finger_4.setTextureSize(256, 128);
		setRotation(finger_4, 0.7504916F, -0.3839724F, -0.8726646F);
		finger_1 = new ModelRenderer(this, 34, 7);
		finger_1.addBox(28.6F, 0.5F, -1F, 1, 1, 5);
		finger_1.setRotationPoint(9F, -13.5F, 1F);
		finger_1.setTextureSize(256, 128);
		setRotation(finger_1, 1.047198F, 0.1570796F, -0.2094395F);
		fore_arm_1 = new ModelRenderer(this, 0, 17);
		fore_arm_1.addBox(0F, -1.5F, 0F, 12, 5, 5);
		fore_arm_1.setRotationPoint(21F, -14.5F, 1F);
		fore_arm_1.setTextureSize(256, 128);
		setRotation(fore_arm_1, 1.047198F, 0.1745329F, -0.2617994F);
		fore_arm_bracket_2 = new ModelRenderer(this, 0, 95);
		fore_arm_bracket_2.addBox(4.5F, -2F, -0.5F, 3, 6, 6);
		fore_arm_bracket_2.setRotationPoint(21F, -14.5F, 1F);
		fore_arm_bracket_2.setTextureSize(256, 128);
		setRotation(fore_arm_bracket_2, 1.047198F, 0.1745329F, -0.2617994F);
		fore_arm_2 = new ModelRenderer(this, 0, 17);
		fore_arm_2.addBox(-11F, -2.966667F, -2F, 12, 5, 5);
		fore_arm_2.setRotationPoint(-29.5F, -18F, 4F);
		fore_arm_2.setTextureSize(256, 128);
		setRotation(fore_arm_2, 0.6108652F, -0.122173F, -2.96706F);
		fore_arm_bracket_6 = new ModelRenderer(this, 0, 95);
		fore_arm_bracket_6.addBox(-11F, -3.5F, -2.5F, 3, 6, 6);
		fore_arm_bracket_6.setRotationPoint(-29.5F, -18F, 4F);
		fore_arm_bracket_6.setTextureSize(256, 128);
		setRotation(fore_arm_bracket_6, 0.6108652F, -0.122173F, -2.96706F);
		fore_arm_bracket_5 = new ModelRenderer(this, 0, 95);
		fore_arm_bracket_5.addBox(-6.5F, -3.5F, -2.5F, 3, 6, 6);
		fore_arm_bracket_5.setRotationPoint(-29.5F, -18F, 4F);
		fore_arm_bracket_5.setTextureSize(256, 128);
		setRotation(fore_arm_bracket_5, 0.6108652F, -0.122173F, -2.96706F);
		fore_arm_bracket_3 = new ModelRenderer(this, 0, 95);
		fore_arm_bracket_3.addBox(0F, -2F, -0.5F, 3, 6, 6);
		fore_arm_bracket_3.setRotationPoint(21F, -14.5F, 1F);
		fore_arm_bracket_3.setTextureSize(256, 128);
		setRotation(fore_arm_bracket_3, 1.047198F, 0.1745329F, -0.2617994F);
		bracket_connection_3 = new ModelRenderer(this, 140, 55);
		bracket_connection_3.addBox(-0.4F, -2F, -0.5F, 3, 2, 23);
		bracket_connection_3.setRotationPoint(22F, -15.5F, 6F);
		bracket_connection_3.setTextureSize(256, 128);
		setRotation(bracket_connection_3, 0.2443461F, 0.0872665F, -0.2617994F);
		bracket_connection_2 = new ModelRenderer(this, 140, 55);
		bracket_connection_2.addBox(4.1F, -2F, -0.5F, 3, 2, 23);
		bracket_connection_2.setRotationPoint(22F, -15.5F, 6F);
		bracket_connection_2.setTextureSize(256, 128);
		setRotation(bracket_connection_2, 0.2617994F, 0.1745329F, -0.2617994F);
		bracket_connection_1 = new ModelRenderer(this, 140, 55);
		bracket_connection_1.addBox(8.5F, -2F, -0.5F, 3, 2, 23);
		bracket_connection_1.setRotationPoint(22F, -15.5F, 6F);
		bracket_connection_1.setTextureSize(256, 128);
		setRotation(bracket_connection_1, 0.2617994F, 0.2617994F, -0.2617994F);
		right_wing_feather_1 = new ModelRenderer(this, 74, 2);
		right_wing_feather_1.addBox(9.5F, -1.5F, 1F, 29, 1, 2);
		right_wing_feather_1.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_1.setTextureSize(256, 128);
		setRotation(right_wing_feather_1, 0.2617994F, 0.1919862F, -0.2617994F);
		right_wing_feather_2 = new ModelRenderer(this, 75, 0);
		right_wing_feather_2.addBox(9.5F, -1.5F, 3F, 28, 1, 2);
		right_wing_feather_2.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_2.setTextureSize(256, 128);
		setRotation(right_wing_feather_2, 0.2617994F, 0.1919862F, -0.2617994F);
		right_wing_feather_10 = new ModelRenderer(this, 79, 0);
		right_wing_feather_10.addBox(9.5F, -1.5F, 18F, 8, 1, 2);
		right_wing_feather_10.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_10.setTextureSize(256, 128);
		setRotation(right_wing_feather_10, 0.2617994F, 0.1919862F, -0.2617994F);
		right_wing_feather_3 = new ModelRenderer(this, 74, 0);
		right_wing_feather_3.addBox(9.5F, -1.5F, 5F, 27, 1, 2);
		right_wing_feather_3.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_3.setTextureSize(256, 128);
		setRotation(right_wing_feather_3, 0.2617994F, 0.1919862F, -0.2617994F);
		right_wing_feather_4 = new ModelRenderer(this, 76, 0);
		right_wing_feather_4.addBox(9.5F, -1.5F, 7F, 25, 1, 2);
		right_wing_feather_4.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_4.setTextureSize(256, 128);
		setRotation(right_wing_feather_4, 0.2617994F, 0.1919862F, -0.2617994F);
		right_wing_feather_5 = new ModelRenderer(this, 76, 0);
		right_wing_feather_5.addBox(9.5F, -1.5F, 9F, 23, 1, 2);
		right_wing_feather_5.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_5.setTextureSize(256, 128);
		setRotation(right_wing_feather_5, 0.2617994F, 0.1919862F, -0.2617994F);
		right_wing_feather_6 = new ModelRenderer(this, 75, 0);
		right_wing_feather_6.addBox(9.5F, -1.5F, 11F, 21, 1, 2);
		right_wing_feather_6.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_6.setTextureSize(256, 128);
		setRotation(right_wing_feather_6, 0.2617994F, 0.1919862F, -0.2617994F);
		right_wing_feather_7 = new ModelRenderer(this, 76, 0);
		right_wing_feather_7.addBox(9.5F, -1.5F, 13F, 19, 1, 2);
		right_wing_feather_7.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_7.setTextureSize(256, 128);
		setRotation(right_wing_feather_7, 0.2617994F, 0.1919862F, -0.2617994F);
		right_wing_feather_8 = new ModelRenderer(this, 76, 0);
		right_wing_feather_8.addBox(9.5F, -1.5F, 15F, 16, 1, 2);
		right_wing_feather_8.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_8.setTextureSize(256, 128);
		setRotation(right_wing_feather_8, 0.2617994F, 0.1919862F, -0.2617994F);
		right_wing_feather_9 = new ModelRenderer(this, 79, 0);
		right_wing_feather_9.addBox(9.5F, -1.5F, 17F, 12, 1, 2);
		right_wing_feather_9.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_9.setTextureSize(256, 128);
		setRotation(right_wing_feather_9, 0.2617994F, 0.1919862F, -0.2617994F);
		right_wing_feather_12 = new ModelRenderer(this, 140, 88);
		right_wing_feather_12.addBox(-13.5F, -1.5F, -1.5F, 8, 1, 16);
		right_wing_feather_12.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_12.setTextureSize(256, 128);
		setRotation(right_wing_feather_12, 0.2617994F, 0.0872665F, -0.4014257F);
		right_wing_feather_12.mirror = true;
		fore_arm_bracket_4 = new ModelRenderer(this, 0, 95);
		fore_arm_bracket_4.addBox(-2F, -3.5F, -2.5F, 3, 6, 6);
		fore_arm_bracket_4.setRotationPoint(-29.5F, -18F, 4F);
		fore_arm_bracket_4.setTextureSize(256, 128);
		setRotation(fore_arm_bracket_4, 0.6108652F, -0.122173F, -2.96706F);
		bracket_connection_4 = new ModelRenderer(this, 140, 55);
		bracket_connection_4.addBox(0.3F, 0F, -0.5F, 3, 2, 23);
		bracket_connection_4.setRotationPoint(-31F, -19F, 7F);
		bracket_connection_4.setTextureSize(256, 128);
		setRotation(bracket_connection_4, 0.2443461F, -0.1745329F, 0.2094395F);
		left_wing_feather_10 = new ModelRenderer(this, 0, 0);
		left_wing_feather_10.addBox(-6.3F, -0.5F, 18.2F, 8, 1, 2);
		left_wing_feather_10.setRotationPoint(-31F, -18F, 7F);
		left_wing_feather_10.setTextureSize(256, 128);
		setRotation(left_wing_feather_10, 0.2443461F, -0.122173F, 0.2094395F);
		bracket_connection_6 = new ModelRenderer(this, 140, 55);
		bracket_connection_6.addBox(9.3F, 0F, 0.5F, 3, 2, 23);
		bracket_connection_6.setRotationPoint(-31F, -19F, 7F);
		bracket_connection_6.setTextureSize(256, 128);
		setRotation(bracket_connection_6, 0.2094395F, -0.0174533F, 0.2094395F);
		bracket_connection_5 = new ModelRenderer(this, 140, 55);
		bracket_connection_5.addBox(4.7F, 0F, 0F, 3, 2, 23);
		bracket_connection_5.setRotationPoint(-31F, -19F, 7F);
		bracket_connection_5.setTextureSize(256, 128);
		setRotation(bracket_connection_5, 0.2268928F, -0.0872665F, 0.2094395F);
		left_wing_feather_1 = new ModelRenderer(this, 0, 0);
		left_wing_feather_1.addBox(-27.3F, -0.5F, 0.2F, 28, 1, 2);
		left_wing_feather_1.setRotationPoint(-31F, -18F, 7F);
		left_wing_feather_1.setTextureSize(256, 128);
		setRotation(left_wing_feather_1, 0.2443461F, -0.122173F, 0.2094395F);
		left_wing_feather_2 = new ModelRenderer(this, 0, 0);
		left_wing_feather_2.addBox(-26.3F, -0.5F, 2.2F, 27, 1, 2);
		left_wing_feather_2.setRotationPoint(-31F, -18F, 7F);
		left_wing_feather_2.setTextureSize(256, 128);
		setRotation(left_wing_feather_2, 0.2443461F, -0.122173F, 0.2094395F);
		left_wing_feather_3 = new ModelRenderer(this, 0, 0);
		left_wing_feather_3.addBox(-25.3F, -0.5F, 4.2F, 26, 1, 2);
		left_wing_feather_3.setRotationPoint(-31F, -18F, 7F);
		left_wing_feather_3.setTextureSize(256, 128);
		setRotation(left_wing_feather_3, 0.2443461F, -0.122173F, 0.2094395F);
		left_wing_feather_4 = new ModelRenderer(this, 0, 0);
		left_wing_feather_4.addBox(-23.3F, -0.5F, 6.2F, 24, 1, 2);
		left_wing_feather_4.setRotationPoint(-31F, -18F, 7F);
		left_wing_feather_4.setTextureSize(256, 128);
		setRotation(left_wing_feather_4, 0.2443461F, -0.122173F, 0.2094395F);
		left_wing_feather_5 = new ModelRenderer(this, 0, 0);
		left_wing_feather_5.addBox(-21.3F, -0.5F, 8.2F, 23, 1, 2);
		left_wing_feather_5.setRotationPoint(-31F, -18F, 7F);
		left_wing_feather_5.setTextureSize(256, 128);
		setRotation(left_wing_feather_5, 0.2443461F, -0.122173F, 0.2094395F);
		left_wing_feather_6 = new ModelRenderer(this, 0, 0);
		left_wing_feather_6.addBox(-19.3F, -0.5F, 10.2F, 21, 1, 2);
		left_wing_feather_6.setRotationPoint(-31F, -18F, 7F);
		left_wing_feather_6.setTextureSize(256, 128);
		setRotation(left_wing_feather_6, 0.2443461F, -0.122173F, 0.2094395F);
		left_wing_feather_7 = new ModelRenderer(this, 0, 0);
		left_wing_feather_7.addBox(-16.3F, -0.5F, 12.2F, 18, 1, 2);
		left_wing_feather_7.setRotationPoint(-31F, -18F, 7F);
		left_wing_feather_7.setTextureSize(256, 128);
		setRotation(left_wing_feather_7, 0.2443461F, -0.122173F, 0.2094395F);
		left_wing_feather_8 = new ModelRenderer(this, 0, 0);
		left_wing_feather_8.addBox(-12.3F, -0.5F, 14.2F, 14, 1, 2);
		left_wing_feather_8.setRotationPoint(-31F, -18F, 7F);
		left_wing_feather_8.setTextureSize(256, 128);
		setRotation(left_wing_feather_8, 0.2443461F, -0.122173F, 0.2094395F);
		left_wing_feather_9 = new ModelRenderer(this, 0, 0);
		left_wing_feather_9.addBox(-9.3F, -0.5F, 16.2F, 10, 1, 2);
		left_wing_feather_9.setRotationPoint(-31F, -18F, 7F);
		left_wing_feather_9.setTextureSize(256, 128);
		setRotation(left_wing_feather_9, 0.2443461F, -0.122173F, 0.2094395F);
		feather_between_bracket_1 = new ModelRenderer(this, 72, 20);
		feather_between_bracket_1.addBox(-0.5F, -1.5F, 0.5F, 12, 1, 20);
		feather_between_bracket_1.setRotationPoint(22F, -15.5F, 6F);
		feather_between_bracket_1.setTextureSize(256, 128);
		setRotation(feather_between_bracket_1, 0.2617994F, 0.1919862F, -0.2617994F);
		right_wing_feather_13 = new ModelRenderer(this, 139, 90);
		right_wing_feather_13.addBox(-22.5F, -1.5F, -1.5F, 14, 1, 11);
		right_wing_feather_13.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_13.setTextureSize(256, 128);
		setRotation(right_wing_feather_13, 0.2617994F, 0.0872665F, -0.4014257F);
		right_wing_feather_11 = new ModelRenderer(this, 139, 87);
		right_wing_feather_11.addBox(-5.5F, -1.5F, -1.5F, 6, 1, 19);
		right_wing_feather_11.setRotationPoint(22F, -15.5F, 6F);
		right_wing_feather_11.setTextureSize(256, 128);
		setRotation(right_wing_feather_11, 0.2617994F, 0.0872665F, -0.4014257F);
		feather_between_bracket_2 = new ModelRenderer(this, 72, 19);
		feather_between_bracket_2.addBox(0.7F, -0.5F, 0F, 11, 1, 21);
		feather_between_bracket_2.setRotationPoint(-31F, -18F, 7F);
		feather_between_bracket_2.setTextureSize(256, 128);
		setRotation(feather_between_bracket_2, 0.2268928F, -0.0872665F, 0.2094395F);
		left_wing_feather_11 = new ModelRenderer(this, 140, 31);
		left_wing_feather_11.addBox(10.7F, -0.5F, -2F, 9, 1, 18);
		left_wing_feather_11.setRotationPoint(-31F, -18F, 7F);
		left_wing_feather_11.setTextureSize(256, 128);
		setRotation(left_wing_feather_11, 0.2268928F, -0.0872665F, 0.2617994F);
		left_wing_feather_13 = new ModelRenderer(this, 140, 39);
		left_wing_feather_13.addBox(26.7F, 2.8F, -2F, 9, 1, 10);
		left_wing_feather_13.setRotationPoint(-31F, -23F, 5F);
		left_wing_feather_13.setTextureSize(256, 128);
		setRotation(left_wing_feather_13, 0.2268928F, -0.0872665F, 0.3490659F);
		left_wing_feather_12 = new ModelRenderer(this, 140, 32);
		left_wing_feather_12.addBox(20.7F, 2.8F, -2F, 8, 1, 17);
		left_wing_feather_12.setRotationPoint(-31F, -23F, 5F);
		left_wing_feather_12.setTextureSize(256, 128);
		setRotation(left_wing_feather_12, 0.2268928F, -0.0872665F, 0.3490659F);
		head_chord_2 = new ModelRenderer(this, 0, 81);
		head_chord_2.addBox(0F, 1.5F, 0.3F, 3, 3, 6);
		head_chord_2.setRotationPoint(-1F, -16F, -5F);
		head_chord_2.setTextureSize(256, 128);
		setRotation(head_chord_2, -0.5235988F, 0F, 0F);
		spike_1 = new ModelRenderer(this, 0, 61);
		spike_1.addBox(0F, 0.3F, 0F, 1, 3, 1);
		spike_1.setRotationPoint(0F, -15F, -17F);
		spike_1.setTextureSize(256, 128);
		setRotation(spike_1, 0.5235988F, 0F, 0F);
		spike_3 = new ModelRenderer(this, 8, 61);
		spike_3.addBox(0F, 0.3F, 0F, 1, 3, 1);
		spike_3.setRotationPoint(0F, -17F, -13F);
		spike_3.setTextureSize(256, 128);
		setRotation(spike_3, 0F, 0F, 0F);
		head = new ModelRenderer(this, 0, 29);
		head.addBox(0F, 0F, 0F, 7, 7, 6);
		head.setRotationPoint(-3F, -13F, -17F);
		head.setTextureSize(256, 128);
		setRotation(head, 0.4363323F, 0F, 0F);
		beak1 = new ModelRenderer(this, 2, 116);
		beak1.addBox(0F, 0F, 0F, 3, 1, 5);
		beak1.setRotationPoint(-1F, -10F, -20F);
		beak1.setTextureSize(256, 128);
		setRotation(beak1, 0.4363323F, 0F, 0F);
		spike_base = new ModelRenderer(this, 0, 44);
		spike_base.addBox(0F, 0.2F, -0.4F, 3, 6, 6);
		spike_base.setRotationPoint(-1F, -14F, -17F);
		spike_base.setTextureSize(256, 128);
		setRotation(spike_base, 0.4363323F, 0F, 0F);
		head_chord_1 = new ModelRenderer(this, 0, 68);
		head_chord_1.addBox(0F, 0.2F, -0.4F, 3, 3, 7);
		head_chord_1.setRotationPoint(-1F, -16F, -12F);
		head_chord_1.setTextureSize(256, 128);
		setRotation(head_chord_1, -0.1745329F, 0F, 0F);
		body_2 = new ModelRenderer(this, 83, 83);
		body_2.addBox(0F, 0F, 0F, 12, 11, 13);
		body_2.setRotationPoint(-5.5F, -4.9F, 9.6F);
		body_2.setTextureSize(256, 128);
		setRotation(body_2, -0.1745329F, 0F, 0F);
		back_feather_4 = new ModelRenderer(this, 84, 45);
		back_feather_4.addBox(0F, 0.6F, 0F, 6, 0, 13);
		back_feather_4.setRotationPoint(-2.5F, -2.9F, 21.2F);
		back_feather_4.setTextureSize(256, 128);
		setRotation(back_feather_4, 0.1745329F, 0F, 0F);
		back_feather_6 = new ModelRenderer(this, 84, 46);
		back_feather_6.addBox(0F, 0.6F, 0F, 5, 0, 12);
		back_feather_6.setRotationPoint(-5.5F, -2.9F, 21.6F);
		back_feather_6.setTextureSize(256, 128);
		setRotation(back_feather_6, 0.1745329F, -0.1570796F, 0F);
		back_feather_1 = new ModelRenderer(this, 84, 44);
		back_feather_1.addBox(0F, 0.1F, 0F, 2, 1, 13);
		back_feather_1.setRotationPoint(4.5F, -2.9F, 21.6F);
		back_feather_1.setTextureSize(256, 128);
		setRotation(back_feather_1, 0.1745329F, 0.2617994F, 0F);
		back_feather_7 = new ModelRenderer(this, 84, 44);
		back_feather_7.addBox(0F, 0.1F, 0F, 2, 1, 13);
		back_feather_7.setRotationPoint(-5.5F, -2.9F, 21.6F);
		back_feather_7.setTextureSize(256, 128);
		setRotation(back_feather_7, 0.1745329F, -0.2617994F, 0F);
		back_feather_5 = new ModelRenderer(this, 84, 43);
		back_feather_5.addBox(0F, 0.1F, 0F, 2, 1, 14);
		back_feather_5.setRotationPoint(-2.5F, -2.9F, 21.6F);
		back_feather_5.setTextureSize(256, 128);
		setRotation(back_feather_5, 0.1745329F, -0.0872665F, 0F);
		back_feather_3 = new ModelRenderer(this, 84, 43);
		back_feather_3.addBox(0F, 0.1F, 0F, 2, 1, 14);
		back_feather_3.setRotationPoint(1.5F, -2.9F, 21.6F);
		back_feather_3.setTextureSize(256, 128);
		setRotation(back_feather_3, 0.1745329F, 0.0872665F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		beak_2.render(f5);
		beak_3.render(f5);
		beak_curv.render(f5);
		spike_2.render(f5);
		nek_1.render(f5);
		nek_2.render(f5);
		neck_chest_connector.render(f5);
		nek_3.render(f5);
		front_part_foot_2.render(f5);
		upper_leg_2.render(f5);
		upper_leg_1.render(f5);
		back_feather_2.render(f5);
		front_part_foot_1.render(f5);
		lower_leg_part_1.render(f5);
		lower_leg_part_2.render(f5);
		nail_8.render(f5);
		nail_2.render(f5);
		nail_5.render(f5);
		nail_1.render(f5);
		nail_6.render(f5);
		nail_4.render(f5);
		nail_3.render(f5);
		foot_2.render(f5);
		nail_7.render(f5);
		nail_10.render(f5);
		nail_12.render(f5);
		nail_11.render(f5);
		nail_9.render(f5);
		foot_1.render(f5);
		body_1.render(f5);
		fore_arm_bracket_1.render(f5);
		shoulder_1.render(f5);
		shoulder_2.render(f5);
		lower_shoulder_2.render(f5);
		finger_8.render(f5);
		finger_7.render(f5);
		finger_6.render(f5);
		finger_5.render(f5);
		hand_2.render(f5);
		finger_2.render(f5);
		lower_shoulder_1.render(f5);
		hand_1.render(f5);
		finger_3.render(f5);
		finger_4.render(f5);
		finger_1.render(f5);
		fore_arm_1.render(f5);
		fore_arm_bracket_2.render(f5);
		fore_arm_2.render(f5);
		fore_arm_bracket_6.render(f5);
		fore_arm_bracket_5.render(f5);
		fore_arm_bracket_3.render(f5);
		bracket_connection_3.render(f5);
		bracket_connection_2.render(f5);
		bracket_connection_1.render(f5);
		right_wing_feather_1.render(f5);
		right_wing_feather_2.render(f5);
		right_wing_feather_10.render(f5);
		right_wing_feather_3.render(f5);
		right_wing_feather_4.render(f5);
		right_wing_feather_5.render(f5);
		right_wing_feather_6.render(f5);
		right_wing_feather_7.render(f5);
		right_wing_feather_8.render(f5);
		right_wing_feather_9.render(f5);
		right_wing_feather_12.render(f5);
		fore_arm_bracket_4.render(f5);
		bracket_connection_4.render(f5);
		left_wing_feather_10.render(f5);
		bracket_connection_6.render(f5);
		bracket_connection_5.render(f5);
		left_wing_feather_1.render(f5);
		left_wing_feather_2.render(f5);
		left_wing_feather_3.render(f5);
		left_wing_feather_4.render(f5);
		left_wing_feather_5.render(f5);
		left_wing_feather_6.render(f5);
		left_wing_feather_7.render(f5);
		left_wing_feather_8.render(f5);
		left_wing_feather_9.render(f5);
		feather_between_bracket_1.render(f5);
		right_wing_feather_13.render(f5);
		right_wing_feather_11.render(f5);
		feather_between_bracket_2.render(f5);
		left_wing_feather_11.render(f5);
		left_wing_feather_13.render(f5);
		left_wing_feather_12.render(f5);
		head_chord_2.render(f5);
		spike_1.render(f5);
		spike_3.render(f5);
		head.render(f5);
		beak1.render(f5);
		spike_base.render(f5);
		head_chord_1.render(f5);
		body_2.render(f5);
		back_feather_4.render(f5);
		back_feather_6.render(f5);
		back_feather_1.render(f5);
		back_feather_7.render(f5);
		back_feather_5.render(f5);
		back_feather_3.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
