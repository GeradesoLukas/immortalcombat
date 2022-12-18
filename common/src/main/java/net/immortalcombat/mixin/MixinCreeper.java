package net.immortalcombat.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Creeper.class)
public class MixinCreeper extends Monster {


    protected MixinCreeper(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }
}
