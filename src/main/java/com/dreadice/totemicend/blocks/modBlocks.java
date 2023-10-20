package com.dreadice.totemicend.blocks;

import com.dreadice.totemicend.TotemicEnd;
import com.dreadice.totemicend.blocks.custom.TotemicPortalBlock;
import com.dreadice.totemicend.items.modItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class modBlocks {
    public static ToIntFunction<BlockState> TotemBlockLevel= BlockState -> 7;
    //Function to make the Totem Bock's Light Level 7
    public static ToIntFunction<BlockState> TotemShardOreLevel= BlockState -> 3;


    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TotemicEnd.MOD_ID);

    public static final RegistryObject<Block> TOTEM_BLOCK = registerBlock("totem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)
                    .sound(SoundType.LODESTONE)
                    .lightLevel(TotemBlockLevel)));

    public static final RegistryObject<Block> TOTEM_FRAGMENT_ORE = registerBlock("totem_fragment_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).lightLevel(TotemShardOreLevel), UniformInt.of(5, 9)));

    public static final RegistryObject<Block> REINFORCED_TOTEM_BLOCK = registerBlock("reinforced_totem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.REINFORCED_DEEPSLATE)));

    public static final RegistryObject<Block> TOTEMIC_PORTAL = registerBlock("totemic_portal",
            () -> new TotemicPortalBlock(BlockBehaviour.Properties.of().noLootTable().noOcclusion().strength(55.0F, 1200.0F)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return modItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
