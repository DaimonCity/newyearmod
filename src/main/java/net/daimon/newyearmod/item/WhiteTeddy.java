package net.daimon.newyearmod.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.Objects;

public class WhiteTeddy extends Item {
    private boolean wasSelected = false;

    public WhiteTeddy() {
        super(new Item.Settings()
                .maxCount(1)
                .rarity(Rarity.UNCOMMON)
        );
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.REGENERATION, 40, 0, true, true);
        if (entity instanceof ServerPlayerEntity player) {

            boolean hasItem = player.getStackInHand(Hand.OFF_HAND).isOf(this) || selected;

            if (hasItem) {
                player.addStatusEffect(effect, player);
            }
        }
    }
}
