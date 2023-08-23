package net.the_blue_shark.foods_and_flutes.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CORN = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.6f).build();
    public static final FoodProperties POP_CORN = new FoodProperties.Builder().nutrition(6)
            .saturationMod(1.0f).build();


}
