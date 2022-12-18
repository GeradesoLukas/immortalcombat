package net.immortalcombat.enchantments;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.immortalcombat.ImmortalCombat;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ModEnchantments {


    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ImmortalCombat.MODID, Registry.ENCHANTMENT_REGISTRY);
    public static final RegistrySupplier<Enchantment> PULLING = ENCHANTMENTS.register("pulling", ()-> new PullingEnchantment(
            Enchantment.Rarity.UNCOMMON, EnchantmentCategory.FISHING_ROD , EquipmentSlot.MAINHAND
    ));

    public static final RegistrySupplier<Enchantment> FROST_ASPECT = ENCHANTMENTS.register("frost_aspect", ()-> new FrostAspectEnchantment(
            Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON , EquipmentSlot.MAINHAND
    ));

}
