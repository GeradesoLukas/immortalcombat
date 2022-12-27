package net.immortalcombat.enchantments;

import com.google.common.collect.ImmutableList;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.function.Predicate;

import static net.immortalcombat.CommonExpectPlatform.createCategory;

public class ModEnchantmentCategories {

    public static final EnchantmentCategory CROSSBOW_AND_TRIDENT = createCategory("CROSSBOW_AND_TRIDENT", item -> item instanceof CrossbowItem || item instanceof TridentItem);

















    //@SuppressWarnings("ConstantConditions")
    //public static EnchantmentCategory createEnchantmentCategory(String internalName, Predicate<Item> canApplyTo) {
    //    // we can use any enum constant, we just need a concrete implementation of the abstract enum class
    //    // this needs to be the same class though as the one we add this interface to via mixins
    //    new EnumAppender<>(EnchantmentCategory.class, EnchantmentCategory.VANISHABLE.getClass(), ImmutableList.of()).addEnumConstant(internalName).apply();
    //    EnchantmentCategory value = EnchantmentCategory.valueOf(internalName);
    //    // some post-processing, not setting this will let the default behavior of VANISHABLE run
    //    // need to cast to object for some reason as compilation fails otherwise under random circumstances
    //    ((ExtensibleEnchantmentCategory) (Object) value).setCanApplyTo(canApplyTo);
    //    return value;
    //}
}
