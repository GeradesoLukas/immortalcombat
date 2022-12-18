package net.immortalcombat.enchantments;

import net.immortalcombat.ImmortalCombat;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.phys.Vec3;

public class PullingEnchantment extends Enchantment {
    public PullingEnchantment(Enchantment.Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot... equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }


    private static double getPullStrength(ItemStack stack) {
        int level = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.PULLING.get(), stack);
        return 0.1 * (level+1);
    }


    public static void pullEntity(Entity target, FishingHook hook, ItemStack fishingStack) {
        Entity owner = hook.getOwner();
        if (owner != null) {
            Vec3 vec3 = (new Vec3(owner.getX() - hook.getX(), owner.getY() - hook.getY(), owner.getZ() - hook.getZ())).scale(getPullStrength(fishingStack));
            target.setDeltaMovement(target.getDeltaMovement().add(vec3));
        }
    }
}
