package com.dreadice.totemicend.entity.client;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.dreadice.totemicend.entity.animations.ModAnimationDefinitions;
import com.dreadice.totemicend.entity.entities.TotemicGolemEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.fml.common.Mod;

public class TotemicGolemModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart TotemicGolem;

	public TotemicGolemModel(ModelPart root) {
		this.TotemicGolem = root.getChild("TotemicGolem");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition TotemicGolem = partdefinition.addOrReplaceChild("TotemicGolem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Head = TotemicGolem.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -39.0F, -1.0F));

		PartDefinition nose = Head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(24, 0).addBox(-8.0F, -37.0F, -7.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 39.0F, 1.0F));

		PartDefinition body = TotemicGolem.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(-7.0F, -22.0F, 1.0F));

		PartDefinition upper = body.addOrReplaceChild("upper", CubeListBuilder.create().texOffs(0, 40).addBox(-16.0F, -34.0F, -4.0F, 18.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 22.0F, -1.0F));

		PartDefinition lower = body.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(0, 70).addBox(-12.0F, -22.0F, -1.5F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 22.0F, -1.0F));

		PartDefinition ArmL = TotemicGolem.addOrReplaceChild("ArmL", CubeListBuilder.create().texOffs(60, 21).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-18.0F, -31.0F, 2.0F));

		PartDefinition ArmR = TotemicGolem.addOrReplaceChild("ArmR", CubeListBuilder.create().texOffs(60, 58).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -31.0F, 2.0F));

		PartDefinition LegL = TotemicGolem.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(37, 0).addBox(-3.0F, -2.0F, -2.5F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, -15.0F, 1.5F));

		PartDefinition LegR = TotemicGolem.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(60, 0).addBox(-3.0F, -2.0F, -2.5F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -15.0F, 1.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(ModAnimationDefinitions.MODEL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((TotemicGolemEntity) entity).attackAnimationState, ModAnimationDefinitions.MODEL_ATTACK_AUTO1, ageInTicks, 2.5f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		TotemicGolem.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return TotemicGolem;
	}
}