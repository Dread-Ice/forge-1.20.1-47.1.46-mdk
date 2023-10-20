package com.dreadice.totemicend.event;

import com.dreadice.totemicend.TotemicEnd;
import com.dreadice.totemicend.entity.client.ModModelLayers;
import com.dreadice.totemicend.entity.client.TotemicGolemModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TotemicEnd.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvent {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.TOTEMIC_GOLEM_LAYER, TotemicGolemModel::createBodyLayer);
    }

}
