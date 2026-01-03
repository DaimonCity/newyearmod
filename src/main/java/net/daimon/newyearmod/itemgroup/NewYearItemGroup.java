package net.daimon.newyearmod.itemgroup;

import net.daimon.newyearmod.ModItems;
import net.daimon.newyearmod.NewYearMod;
import net.daimon.newyearmod.food.ShishkinLes;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public final class NewYearItemGroup {
    public static final ItemGroup NEW_YEAR_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.WATER_OF_SHISHEK))
            .displayName(Text.translatable("itemGroup." + NewYearMod.MOD_ID + ".new_year_group"))
            .entries((context, entries) -> {
                entries.add(ModItems.WATER_OF_SHISHEK);
                entries.add(ModItems.WHITE_TEDDY);
            })
            .build();


    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(NewYearMod.MOD_ID, "new_year_group"), NEW_YEAR_GROUP);
    }
}
