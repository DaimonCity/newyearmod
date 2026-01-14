package net.daimon.newyearmod.item;

import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class WhiteTeddy extends Item {
    public WhiteTeddy() {
        super(new Item.Settings()
                .maxCount(1)
                .rarity(Rarity.UNCOMMON)
        );
    }

}
