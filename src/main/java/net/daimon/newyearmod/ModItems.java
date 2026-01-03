package net.daimon.newyearmod;

import net.daimon.newyearmod.food.ShishkinLes;
import net.daimon.newyearmod.item.WhiteTeddy;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item WATER_OF_SHISHEK = register(
            new ShishkinLes(),
            "water_of_shishek"
    );

    public static final Item WHITE_TEDDY = register(
            new WhiteTeddy(),
            "white_teddy"
    );

    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(NewYearMod.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {
        CompostingChanceRegistry.INSTANCE.add(ModItems.WATER_OF_SHISHEK, 0.3f);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.WATER_OF_SHISHEK));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH)
                .register((itemGroup) -> itemGroup.add(ModItems.WATER_OF_SHISHEK));
    }

}
