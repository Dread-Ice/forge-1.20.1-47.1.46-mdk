package com.dreadice.totemicend.entity.client;

import com.dreadice.totemicend.TotemicEnd;
import com.dreadice.totemicend.entity.entities.TotemicGolemEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TotemicGolemRenderer extends MobRenderer<TotemicGolemEntity, TotemicGolemModel<TotemicGolemEntity>> {
    public TotemicGolemRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TotemicGolemModel<>(pContext.bakeLayer(ModModelLayers.TOTEMIC_GOLEM_LAYER)), 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(TotemicGolemEntity pEntity) {
        return new ResourceLocation(TotemicEnd.MOD_ID, "textures/entity/totemic_golem.png");
    }

    @Override
    public void render(TotemicGolemEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
