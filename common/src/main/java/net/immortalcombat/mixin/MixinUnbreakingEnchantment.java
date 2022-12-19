package net.immortalcombat.mixin;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.*;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DigDurabilityEnchantment.class)
public class MixinUnbreakingEnchantment extends Enchantment {


    protected MixinUnbreakingEnchantment(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot[] equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }


    @Override
    protected boolean checkCompatibility(Enchantment enchantment) {
        return !(enchantment instanceof MendingEnchantment);
    }
}
