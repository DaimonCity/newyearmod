package net.daimon.newyearmod.food;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import net.minecraft.util.UseAction;

public class ShishkinLes extends Item {

    public ShishkinLes() {
        super(new Item.Settings()
                .maxCount(16)
                .rarity(Rarity.RARE)
                .food(new FoodComponent.Builder()
                        .nutrition(4)
                        .saturationModifier(0.6f) // насыщение
                        .alwaysEdible()
                        .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 3200, 1), 1.0f)
                        .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 3), 1.0f)
                        .build()
                ));


    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
