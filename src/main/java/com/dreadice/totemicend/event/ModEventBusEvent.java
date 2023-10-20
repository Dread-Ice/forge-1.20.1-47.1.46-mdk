package com.dreadice.totemicend.event;

import com.dreadice.totemicend.TotemicEnd;
import com.dreadice.totemicend.entity.ModEntities;
import com.dreadice.totemicend.entity.entities.TotemicGolemEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TotemicEnd.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvent {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.TOTEMICGOLEM.get(), TotemicGolemEntity.createAttributes().build());
    }

}