package net.immortalcombat.mixin;

import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(CrossbowItem.class)
public class CrossbowItemInvoker {

    @Invoker("getChargedProjectiles")
    public static List<ItemStack> getChargedProjectiles(ItemStack itemStack) {
     throw new AssertionError();
    }
}
