package net.immortalcombat.fabric.mixin;

import net.immortalcombat.fabric.EnumExtender;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Arrays;

@Mixin(EnchantmentCategory.class)
public class MixinEnchantmentCategory {

    //@SuppressWarnings("ShadowTarget")
    //@Shadow
    //@Mutable
    //@Final
    //private static EnchantmentCategory[] VALUEARRAY;
    //private MixinEnchantmentCategory(String valueName, int ordinal,  Object... arguments) {
    //    throw new AssertionError();
    //}
    //static {
    //    EnumExtender.register(EnchantmentCategory.class, (name, args) -> {
    //        EnchantmentCategory entry = (EnchantmentCategory) (Object) new MixinEnchantmentCategory(name,  args);
    //        VALUEARRAY = Arrays.copyOf(VALUEARRAY, VALUEARRAY.length + 1);
    //        return VALUEARRAY[VALUEARRAY.length - 1] = entry;
    //    });
    //}

}
