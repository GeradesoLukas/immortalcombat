package net.immortalcombat.mixin;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Player.class)
public class MixinPlayer {

    private int lastSelectedSlot;
    @Shadow private ItemStack lastItemInMainHand;

    //@Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;matches(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)Z"), locals = LocalCapture.CAPTURE_FAILHARD)
    //private void init(CallbackInfo ci, int i, double d, ItemStack itemStack) {
    //    if (itemStack == this.lastItemInMainHand && itemStack.getItem() instanceof CrossbowItem) {
    //        ((Player) ((Object) this)).getCooldowns().addCooldown(itemStack.getItem(), 10);
    //    }
    //}
}
