package net.immortalcombat.mixin;

import net.immortalcombat.enchantments.ModEnchantmentCategories;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.ArrowPiercingEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArrowPiercingEnchantment.class)
public abstract class MixinArrowPiercingEnchantment extends Enchantment {

    protected MixinArrowPiercingEnchantment(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot[] equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }

    @Override
    public boolean canEnchant(ItemStack itemStack) {
        if (itemStack.getItem() instanceof TridentItem) {
            return true;
        }
        return super.canEnchant(itemStack);
    }

    //@ModifyArg(at = @At("HEAD"),index = 1, method = "Lnet/minecraft/world/item/enchantment/ArrowPiercingEnchantment;<init>(Lnet/minecraft/world/item/enchantment/Enchantment$Rarity;[Lnet/minecraft/world/entity/EquipmentSlot;)V")
    //private static EnchantmentCategory modifyCategory(EnchantmentCategory category) {
    //    return ModEnchantmentCategories.CROSSBOW_AND_TRIDENT;
    //}
}
