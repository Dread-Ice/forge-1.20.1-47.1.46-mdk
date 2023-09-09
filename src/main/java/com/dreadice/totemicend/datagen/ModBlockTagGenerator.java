package com.dreadice.totemicend.datagen;

import com.dreadice.totemicend.TotemicEnd;
import com.dreadice.totemicend.blocks.modBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TotemicEnd.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(modBlocks.TOTEM_BLOCK.get(),
                        modBlocks.TOTEM_FRAGMENT_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(modBlocks.TOTEM_BLOCK.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
