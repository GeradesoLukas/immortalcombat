package net.immortalcombat.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import java.util.ArrayList;

@Mixin(EnchantmentHelper.class)
public class MixinEnchantmentHelper {

    @ModifyExpressionValue(
            method = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getAvailableEnchantmentResults(ILnet/minecraft/world/item/ItemStack;Z)Ljava/util/List;",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentCategory;canEnchant(Lnet/minecraft/world/item/Item;)Z"))
    private static boolean modifyPose(boolean original, int i, ItemStack itemStack, boolean bl, ArrayList<EnchantmentInstance> list,  Item item, boolean bl2, Enchantment enchantment) {
        if(enchantment.canEnchant(itemStack)) {
            System.out.println("Heya");
                return true;
    }
        else return original;
    }
}
