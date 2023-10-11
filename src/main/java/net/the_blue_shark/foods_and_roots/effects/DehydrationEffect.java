package net.the_blue_shark.foods_and_roots.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class DehydrationEffect extends MobEffect {
    public DehydrationEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        Level level = entity.level();

        // Check if the entity is in the Nether
        if (level.dimension() == Level.NETHER) {
            // Apply fire to the entity
            entity.setSecondsOnFire(1);// You can adjust the duration as needed
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
