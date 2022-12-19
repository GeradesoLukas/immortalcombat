package net.immortalcombat.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.immortalcombat.ImmortalCombatClient;

public class ImmortalCombatFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ImmortalCombatClient.init();
    }
}
