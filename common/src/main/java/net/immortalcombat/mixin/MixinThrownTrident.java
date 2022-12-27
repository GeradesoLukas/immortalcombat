package net.immortalcombat.mixin;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownTrident.class)
public abstract class MixinThrownTrident extends AbstractArrow {
    protected MixinThrownTrident(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }
    @Shadow
    private boolean dealtDamage;

    @Inject(method = "onHitEntity", at = @At("TAIL"))
    protected void onHitEntity$tail(EntityHitResult rayTraceResult, CallbackInfo callback) {
        Entity entity = rayTraceResult.getEntity();
        int pierceLevel = this.getPierceLevel();
        if (pierceLevel > 0) {
            IntOpenHashSet piercedEntities = ((AccessorAbstractArrow) this).getPiercingIgnoreEntityIds();
            if (piercedEntities == null) {
                piercedEntities = new IntOpenHashSet(5);
                ((AccessorAbstractArrow) this).setPiercingIgnoreEntityIds(piercedEntities);
            }
            piercedEntities.add(entity.getId());

            if (piercedEntities.size() <= pierceLevel) {
                this.setDeltaMovement(this.getDeltaMovement().multiply(-100.0, -10.0, -100.0));
                this.dealtDamage = false;
            }
        }
    }

}
