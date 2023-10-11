package net.the_blue_shark.foods_and_roots.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.the_blue_shark.foods_and_roots.FoodsAndRoots;
import net.the_blue_shark.foods_and_roots.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FoodsAndRoots.MOD_ID);

    public static final RegistryObject<CreativeModeTab> foods_and_roots_TAB = CREATIVE_MODE_TABS.register("foods_and_roots_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CORN.get()))
                    .title(Component.translatable("creativetab.foods_and_roots_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.CORN.get());
                        pOutput.accept(ModItems.CORN_BOWL.get());
                        pOutput.accept(ModItems.POP_CORN.get());
                        pOutput.accept(ModItems.BANANA.get());
                        pOutput.accept(ModItems.PEAR.get());
                        pOutput.accept(ModItems.BEER.get());
                        pOutput.accept(ModItems.HORSE_MEAT.get());
                        pOutput.accept(ModItems.PEPPER.get());
                        pOutput.accept(ModItems.BLUE_BERRIES.get());

                        pOutput.accept(ModItems.PEPPER_SEEDS.get());
                        pOutput.accept(ModItems.CORN_SEEDS.get());

                        pOutput.accept(ModBlocks.CORN_CRATE.get());

                        pOutput.accept(ModBlocks.BUDDLEJA.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
