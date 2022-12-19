package net.immortalcombat.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.List;

@Mixin(ThrownPotion.class)
public class MixinThrownPotion {

    @Inject(at = @At("TAIL"), method = "applyWater",locals = LocalCapture.CAPTURE_FAILHARD)
    private void init(CallbackInfo ci, AABB aABB) {
        ThrownPotion potion = ((ThrownPotion) ((Object) this));
        List<LivingEntity> list3 = potion.level.getEntitiesOfClass(LivingEntity.class, aABB);
        for (LivingEntity living : list3) {
            living.clearFire();
        }
    }
}
