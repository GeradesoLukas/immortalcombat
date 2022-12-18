package net.immortalcombat.mixin;

import net.immortalcombat.enchantments.PullingEnchantment;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FishingHook.class)
public class FishingHookMixin {

    //@ModifyArg(
    //        method = "pullEntity",
    //        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/phys/Vec3;scale(D)Lnet/minecraft/world/phys/Vec3;"))
    //private double injectPull(double d) {
    //    return 1;
    //}

    @Redirect(
            method = "retrieve",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/FishingHook;pullEntity(Lnet/minecraft/world/entity/Entity;)V"))
    private void injectPull(FishingHook instance, Entity target, ItemStack stack) {
        PullingEnchantment.pullEntity(target,instance,stack);
        //System.out.print("pulled Entity");
    }
}
