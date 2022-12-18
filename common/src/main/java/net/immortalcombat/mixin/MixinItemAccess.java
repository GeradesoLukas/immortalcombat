package net.immortalcombat.mixin;

import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin (Item.class)
public interface MixinItemAccess {

    @Mutable
    @Accessor
    void setMaxStackSize(int size);
}
