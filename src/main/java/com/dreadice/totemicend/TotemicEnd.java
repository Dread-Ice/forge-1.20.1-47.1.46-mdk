package com.dreadice.totemicend;

import com.dreadice.totemicend.blocks.modBlocks;
import com.dreadice.totemicend.entity.ModEntities;
import com.dreadice.totemicend.entity.client.TotemicGolemRenderer;
import com.dreadice.totemicend.items.modItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TotemicEnd.MOD_ID)
public class TotemicEnd {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "totemicend";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public TotemicEnd() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modItems.register(modEventBus);
        modBlocks.register(modEventBus);
        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(modItems.TOTEM_DUST);
            event.accept(modItems.TOTEM_FRAGMENT);
            event.accept(modItems.CRYSTALISED_TOTEMIC_SHARD);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(modItems.TOTEMIC_SWORD);
            event.accept(modItems.TOTEMIC_AXE);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(modItems.TOTEMIC_SHOVEL);
            event.accept(modItems.TOTEMIC_PICKAXE);
            event.accept(modItems.TOTEMIC_PICKAXE);
            event.accept(modItems.TOTEMIC_HOE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.TOTEMICGOLEM.get(), TotemicGolemRenderer::new);

        }
    }
}
