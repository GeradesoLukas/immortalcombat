package net.immortalcombat.mixin;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;setHealth(F)V"), method = "heal", locals = LocalCapture.CAPTURE_FAILHARD)
    private void init(float healamount, CallbackInfo ci, float health) {
        LivingEntity entity = ((LivingEntity) ((Object) this));
        float maxhealth = entity.getMaxHealth();
        if(!(health >= maxhealth)) {
            System.out.println("Healed");
            if(entity.getLevel() instanceof ServerLevel serverLevel) {
                serverLevel.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.AMETHYST_BLOCK_CHIME, entity.getSoundSource(), 0.5f, 0.4f / (serverLevel.getRandom().nextFloat() * 0.4f + 0.8f));

                //serverLevel.playSound((Player)null, entity.getX(),entity.getY(), entity.getZ(), SoundEvents.AMETHYST_BLOCK_CHIME, entity.getSoundSource());
                //serverLevel.playLocalSound(entity.getX(),entity.getY(), entity.getZ(), SoundEvents.AMETHYST_BLOCK_CHIME, entity.getSoundSource(), 5.0f, 0.8f  * 0.3f, false);
                //entity.getLevel().playLocalSound(entity.getX(),entity.getY(), entity.getZ(), SoundEvents.AMETHYST_BLOCK_CHIME, entity.getSoundSource(), 5.0f, 0.8f  * 0.3f, false);
                serverLevel.sendParticles(ParticleTypes.HEART,entity.getX(),entity.getY(),entity.getZ(), 6,0.0, 0.0, 0.0, 1.0);
                        //(ParticleTypes.HEART,entity.getX(),entity.getY()+1, entity.getZ(), 1, 1, 1);
            }
        }
    }
}
