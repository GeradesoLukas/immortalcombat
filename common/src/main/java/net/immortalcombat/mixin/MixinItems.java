package net.immortalcombat.mixin;

import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Items.class)
public class MixinItems {

    //@ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item$Properties;stacksTo(I)Lnet/minecraft/world/item/Item$Properties;", ordinal = 0),
    //        slice = @Slice( from = @At(value = "NEW", target = "Lnet/minecraft/world/item/PotionItem;<init>(Lnet/minecraft/world/item/Item$Properties;)V")))
    //private static int init(int i) {
    //    return 8;
    //}
}
