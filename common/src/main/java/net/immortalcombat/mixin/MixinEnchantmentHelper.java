package net.immortalcombat.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.List;

@Mixin(EnchantmentHelper.class)
public class MixinEnchantmentHelper {

    private static Enchantment enchantment;

    @ModifyVariable(
            method = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getAvailableEnchantmentResults(ILnet/minecraft/world/item/ItemStack;Z)Ljava/util/List;",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/Enchantment;isTreasureOnly()Z")
    )
    private static Enchantment captureEnchantment(Enchantment originalenchantment) {
        enchantment = originalenchantment;
        return originalenchantment;
    }

    @ModifyExpressionValue(
            method = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getAvailableEnchantmentResults(ILnet/minecraft/world/item/ItemStack;Z)Ljava/util/List;",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentCategory;canEnchant(Lnet/minecraft/world/item/Item;)Z"))
    private static boolean modifyCondition(boolean original, int i, ItemStack itemStack) {
        if(enchantment.canEnchant(itemStack)) {
            System.out.println("Heya");
                return true;
    }
        else return original;
    }
}
