package net.daimon.newyearmod;

import net.daimon.newyearmod.itemgroup.NewYearItemGroup;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import java.util.HashMap;
import java.util.Map;

public class NewYearMod implements ModInitializer {
    public static final String MOD_ID = "newyearmod";
    public static Map<String, Boolean> TeddyWasSelected =  new HashMap<>();
    @Override
    public void onInitialize() {
        ModItems.initialize();
        NewYearItemGroup.initialize();

        ServerTickEvents.END_SERVER_TICK.register((MinecraftServer server) -> {
            if (server.getOverworld().isClient()) return;

            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                boolean teddy = TeddyWasSelected.get(player.getUuidAsString());

                boolean hasWhiteTeddy =
                        player.getMainHandStack().isOf(ModItems.WHITE_TEDDY) ||
                                player.getOffHandStack().isOf(ModItems.WHITE_TEDDY);
                StatusEffectInstance effect = new StatusEffectInstance(
                        StatusEffects.REGENERATION,
                        -1,
                        0,
                        true,
                        true
                );


                if (hasWhiteTeddy && !teddy) {
                    if (!player.hasStatusEffect(StatusEffects.REGENERATION)) {
                        player.addStatusEffect(effect);
                        TeddyWasSelected.put(player.getUuidAsString(), true);
                    }
                } else if (teddy && !hasWhiteTeddy) {
                    player.removeStatusEffect(StatusEffects.REGENERATION);
                    TeddyWasSelected.put(player.getUuidAsString(), false);
                }
            }
        });
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
            if (handler.getPlayer().getWorld().isClient()) return;
            ServerPlayerEntity player = handler.getPlayer();

            if (TeddyWasSelected.get(player.getUuidAsString())) {
                player.removeStatusEffect(StatusEffects.REGENERATION);
                TeddyWasSelected.put(player.getUuidAsString(), false);
            }

        } );
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            if (handler.getPlayer().getWorld().isClient()) return;

            ServerPlayerEntity player = handler.getPlayer();
            TeddyWasSelected.put(player.getUuidAsString(), false);
        });



    }
}
