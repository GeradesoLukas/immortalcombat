package net.immortalcombat.mixin;

import net.minecraft.world.entity.projectile.ThrownTrident;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ThrownTrident.class)
public interface MixinThrownTridentAccess {
    @Mutable
    @Accessor
    void setDealtDamage(boolean b);
}
