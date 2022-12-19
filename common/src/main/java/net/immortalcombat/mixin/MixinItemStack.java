package net.immortalcombat.mixin;

import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ItemStack.class)
public class MixinItemStack {
    /**
     * @author GeradesoLukas
     * @reason Sets Repair Cost to zero, to balance the game
     */
    @Overwrite
    public int getBaseRepairCost() {
        return 0;
    }
}
