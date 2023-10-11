package net.the_blue_shark.foods_and_roots.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.the_blue_shark.foods_and_roots.effects.ModEffects;

public class ModFoods {
    public static final FoodProperties CORN = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.3f).build();

    public static final FoodProperties CORN_BOWL = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.4f).build();
    public static final FoodProperties POP_CORN = new FoodProperties.Builder().nutrition(5)
            .saturationMod(0.6f).build();
    public static final FoodProperties BANANA = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.3f).build();
    public static final FoodProperties PEAR = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.3f).build();
    public static final FoodProperties HOT_PEPPER = new FoodProperties.Builder().nutrition(6)
            .saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(ModEffects.DEHYDRATION_EFFECT.get(), 100), 0.1f).build();
    public static final FoodProperties BEER = new FoodProperties.Builder().nutrition(5).alwaysEat()
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100), 0.1f).effect(() -> new MobEffectInstance(MobEffects.POISON, 100), 0.01f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 0.7f).build();


}
