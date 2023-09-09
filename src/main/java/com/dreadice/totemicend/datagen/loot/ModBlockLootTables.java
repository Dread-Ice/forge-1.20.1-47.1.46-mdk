package com.dreadice.totemicend.datagen.loot;

import com.dreadice.totemicend.blocks.modBlocks;
import com.dreadice.totemicend.items.modItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(modBlocks.TOTEM_BLOCK.get());

        this.add(modBlocks.TOTEM_FRAGMENT_ORE.get(),
                block -> createOreDrop(modBlocks.TOTEM_FRAGMENT_ORE.get(), modItems.TOTEM_FRAGMENT.get()));

        this.dropOther(modBlocks.REINFORCED_TOTEM_BLOCK.get(), Items.AIR);


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return modBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
