package net.immortalcombat.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(MobEffect.class)
public class MixinMobEffect {

    //@ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z", ordinal = 2), method = "applyEffectTick", index = 1)
    //private float modifyHarm(float f) {
    //    return f *= 0.5;
    //    //return 4.0f;
    //}

    //@ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z", ordinal = 0), method = "applyInstantenousEffect", index = 1)
    //private float modifyHarm2(float f) {
    //    return f *= 0.5;
    //    //return 4.0f;
    //}

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z", ordinal = 2), method = "applyEffectTick")
    private boolean hurtRedirectHarm(LivingEntity instance, DamageSource damageSource, float f,  LivingEntity useless2, int amp) {
        return instance.hurt(damageSource, 3<< amp);
    }
    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z", ordinal = 0), method = "applyInstantenousEffect")
    private boolean hurtRedirectHarm2(LivingEntity instance, DamageSource damageSource, float f, @Nullable Entity directEntity, @Nullable Entity indirectEntity, LivingEntity useless2, int amp, double useless3) {
        return instance.hurt(damageSource, 3<< amp);
    }

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z", ordinal = 1), method = "applyInstantenousEffect")
    private boolean hurtRedirectHarm3(LivingEntity instance, DamageSource damageSource, float f, @Nullable Entity directEntity, @Nullable Entity indirectEntity, LivingEntity useless2, int amp, double useless3) {
        return instance.hurt(DamageSource.indirectMagic(directEntity, indirectEntity), 3<< amp);
    }


}
