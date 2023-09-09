package com.dreadice.totemicend.datagen;

import com.dreadice.totemicend.TotemicEnd;
import com.dreadice.totemicend.blocks.modBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TotemicEnd.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(modBlocks.TOTEM_BLOCK);
        blockWithItem(modBlocks.TOTEM_FRAGMENT_ORE);
        blockWithItem(modBlocks.REINFORCED_TOTEM_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}