package net.immortalcombat.fabric;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.function.Predicate;

public class CommonExpectPlatformImpl {
    public static EnchantmentCategory createCategory(String name, Predicate<Item> delegate) {
        return EnumExtender.add(EnchantmentCategory.class,name,delegate);
    }
}
