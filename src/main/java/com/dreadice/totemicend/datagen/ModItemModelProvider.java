package com.dreadice.totemicend.datagen;

import com.dreadice.totemicend.TotemicEnd;
import com.dreadice.totemicend.items.modItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TotemicEnd.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(modItems.TOTEM_DUST);
        simpleItem(modItems.CRYSTALISED_TOTEMIC_SHARD);
        simpleItem(modItems.TOTEM_FRAGMENT);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TotemicEnd.MOD_ID,"item/" + item.getId().getPath()));
    }
}