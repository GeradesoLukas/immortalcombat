package net.immortalcombat.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(TridentItem.class)
public class MixinTridentItem {

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;addFreshEntity(Lnet/minecraft/world/entity/Entity;)Z"), method = "releaseUsing", locals = LocalCapture.CAPTURE_FAILHARD)
    private void init(ItemStack itemStack, Level level, LivingEntity livingEntity, int i, CallbackInfo ci, Player player, int j, ThrownTrident thrownTrident) {
        int piercelevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PIERCING, itemStack);
        thrownTrident.setPierceLevel((byte) piercelevel);
        System.out.println("The Value is: " + piercelevel);

    }
}
