package net.immortalcombat;

import dev.architectury.event.events.common.InteractionEvent;
import net.immortalcombat.enchantments.ModEnchantments;
import net.immortalcombat.events.RightClickEvent;
import net.immortalcombat.mixin.MixinItemAccess;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PotionItem;

public class ImmortalCombat {
    public static final String MODID = "immortalcombat";
    // We can use this if we don't want to use DeferredRegister
    //public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MOD_ID));
    // Registering a new creative tab
    //public static final CreativeModeTab EXAMPLE_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "example_tab"), () ->
    //        new ItemStack(ExampleMod.EXAMPLE_ITEM.get()));
    
    //public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY);
    //public static final RegistrySupplier<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () ->
    //        new Item(new Item.Properties().tab(ExampleMod.EXAMPLE_TAB)));
    
    public static void init() {
        //ITEMS.register();
        loadStacking();

        InteractionEvent.RIGHT_CLICK_ITEM.register(RightClickEvent::register);

        ModEnchantments.ENCHANTMENTS.register();

        System.out.println(ExampleExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    public static void loadStacking() {
        for(Item item : Registry.ITEM) {
            if(item instanceof PotionItem) {
                setMax(item,8);
            }
        }
    }



    public static void setMax(Item item, int max) {
        if (max > 0) {
            ((MixinItemAccess) item).setMaxStackSize(max);
        }
    }
}
