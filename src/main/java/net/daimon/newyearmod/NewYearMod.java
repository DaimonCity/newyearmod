package net.daimon.newyearmod;

import net.daimon.newyearmod.itemgroup.NewYearItemGroup;
import net.fabricmc.api.ModInitializer;

public class NewYearMod implements ModInitializer {
    public static final String MOD_ID = "newyearmod";

    @Override
    public void onInitialize() {

        ModItems.initialize();
        NewYearItemGroup.initialize();
    }
}
