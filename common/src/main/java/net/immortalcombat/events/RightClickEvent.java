package net.immortalcombat.events;

import dev.architectury.event.CompoundEventResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.ThrowablePotionItem;

public class RightClickEvent {




    public static CompoundEventResult<ItemStack> register(Player player, InteractionHand interactionHand) {
        Item hand = player.getItemInHand(interactionHand).getItem();
        //if (hand instanceof ThrowablePotionItem) {
        //    player.getCooldowns().addCooldown(hand, 20);
        //}
        return CompoundEventResult.pass();
    }
}
