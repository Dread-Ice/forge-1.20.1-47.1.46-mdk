package com.dreadice.totemicend.items;

import com.dreadice.totemicend.TotemicEnd;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class modItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TotemicEnd.MOD_ID);

    public static final RegistryObject<Item> TOTEM_DUST = ITEMS.register("totem_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOTEM_SHARD = ITEMS.register("totem_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTALISED_TOTEMIC_SHARD = ITEMS.register("crystalised_totemic_shard",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
