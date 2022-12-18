package net.immortalcombat.mixin;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

import static net.minecraft.world.item.ProjectileWeaponItem.ARROW_OR_FIREWORK;

@Mixin(CrossbowItem.class)
public class MixinCrossbowItem {

    @Inject(at = @At("HEAD"), method = "performShooting")
    private static void performShootingInject(Level level, LivingEntity livingEntity, InteractionHand interactionHand, ItemStack itemStack, float f, float g, CallbackInfo info) {

        if(livingEntity instanceof Player player) {
            player.getCooldowns().addCooldown(itemStack.getItem(), 10);
        }
    }

    @Inject(at = @At("RETURN"), method = "getAllSupportedProjectiles", cancellable = true)
    private void getAllSupportedProjectilesInject(CallbackInfoReturnable<Predicate<ItemStack>> cir) {
      cir.setReturnValue(ARROW_OR_FIREWORK);
    }

}
