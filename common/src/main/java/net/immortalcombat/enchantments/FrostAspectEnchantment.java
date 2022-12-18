package net.immortalcombat.enchantments;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.Random;

public class FrostAspectEnchantment extends Enchantment {

    protected FrostAspectEnchantment(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot... equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        if(!user.getLevel().isClientSide()) {
            if(level == 1) target.setTicksFrozen(180);
            else target.setTicksFrozen(240);
            Random random = user.getLevel().getRandom();
            //user.getLevel().addParticle(ParticleTypes.SNOWFLAKE, target.getX(), (double)(user.getOnPos().getY() + 1), target.getZ(), (double)(Mth.randomBetween(random, -1.0F, 1.0F) * 0.083333336F), 0.05000000074505806, (double)(Mth.randomBetween(random, -1.0F, 1.0F) * 0.083333336F));
        }
        super.doPostHurt(user,target,level);
    }

}
