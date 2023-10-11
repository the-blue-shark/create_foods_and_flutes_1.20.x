package net.the_blue_shark.foods_and_roots.effects;

import net.the_blue_shark.foods_and_roots.FoodsAndRoots;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, FoodsAndRoots.MOD_ID);

    public static final RegistryObject<MobEffect> DEHYDRATION_EFFECT = MOB_EFFECTS.register("dehydration",
            () -> new DehydrationEffect(MobEffectCategory.HARMFUL, 13565951));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}