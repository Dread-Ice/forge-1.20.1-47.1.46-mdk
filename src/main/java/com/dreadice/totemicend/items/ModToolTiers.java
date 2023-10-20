package com.dreadice.totemicend.items;

import com.dreadice.totemicend.TotemicEnd;
import com.dreadice.totemicend.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier TOTEMIC = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2500, 10f, 5f, 18,
                    ModTags.Blocks.NEEDS_TOTEMIC_TOOL, () -> Ingredient.of(modItems.CRYSTALISED_TOTEMIC_SHARD.get())),
            new ResourceLocation(TotemicEnd.MOD_ID, "totemic"), List.of(Tiers.NETHERITE), List.of());
}
