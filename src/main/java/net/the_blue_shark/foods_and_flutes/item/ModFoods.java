package net.the_blue_shark.foods_and_flutes.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CORN = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.3f).build();
    public static final FoodProperties POP_CORN = new FoodProperties.Builder().nutrition(5)
            .saturationMod(0.6f).build();


}
