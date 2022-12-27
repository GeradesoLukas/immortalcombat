package net.immortalcombat;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.function.Predicate;

public class CommonExpectPlatform {

    @ExpectPlatform
    public static EnchantmentCategory createCategory(String name, Predicate<Item> delegate) {
        throw new AssertionError();

    }
}
