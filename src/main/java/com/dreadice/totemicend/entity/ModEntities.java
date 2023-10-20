package com.dreadice.totemicend.entity;

import com.dreadice.totemicend.TotemicEnd;
import com.dreadice.totemicend.entity.entities.TotemicGolemEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TotemicEnd.MOD_ID);

    public static final RegistryObject<EntityType<TotemicGolemEntity>> TOTEMICGOLEM =
            ENTITY_TYPES.register("totemic_golem", () -> EntityType.Builder.of(TotemicGolemEntity:: new, MobCategory.CREATURE)
                    .sized(1.25f,2.75f).build("totemic_golem"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
