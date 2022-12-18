package net.immortalcombat.fabric;

import net.immortalcombat.ImmortalCombat;
import net.fabricmc.api.ModInitializer;

public class ImmortalCombatFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ImmortalCombat.init();
    }
}
