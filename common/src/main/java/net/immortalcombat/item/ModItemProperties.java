package net.immortalcombat.item;

import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.immortalcombat.ImmortalCombat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Items;

public class ModItemProperties {

    public static void register() {
        ItemPropertiesRegistry.register(Items.CROSSBOW,new ResourceLocation("spectral"), (stack, level, living, id)  -> living != null && CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, Items.SPECTRAL_ARROW) ? 1.0f : 0.0f);
    }
}
