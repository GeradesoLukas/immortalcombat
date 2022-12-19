package net.immortalcombat.forge;

import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import net.immortalcombat.ImmortalCombat;
import net.immortalcombat.ImmortalCombatClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ImmortalCombat.MODID)
public class ImmortalCombatForge {
    public ImmortalCombatForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(ImmortalCombat.MODID, FMLJavaModLoadingContext.get().getModEventBus());
        ImmortalCombat.init();

        if(Platform.getEnv() == Dist.CLIENT) {
            ImmortalCombatClient.init();
        }
    }
}
