package net.immortalcombat.item;

import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.immortalcombat.mixin.CrossbowItemInvoker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;

@Environment(EnvType.CLIENT)
public class ModItemProperties {

    public static void register() {
        ItemPropertiesRegistry.register(Items.CROSSBOW,new ResourceLocation("spectral"), (stack, level, living, id)  -> living != null && CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, Items.SPECTRAL_ARROW) ? 1.0f : 0.0f);
        ItemPropertiesRegistry.register(Items.CROSSBOW,new ResourceLocation("tipped"), (stack, level, living, id)  -> living != null && CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, Items.TIPPED_ARROW) ? 1.0f : 0.0f);
        ItemPropertiesRegistry.register(Items.CROSSBOW,new ResourceLocation("tipped_color"), (stack, level, living, id)  -> {
            ItemStack arrow = CrossbowItemInvoker.getChargedProjectiles(stack).get(0);
            Potion potion = PotionUtils.getPotion(stack);
            int color = potion.getEffects().stream().findFirst().get().getEffect().getColor();

            return color;
        });
    }
}
