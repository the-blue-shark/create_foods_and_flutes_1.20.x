package net.the_blue_shark.foods_and_flutes.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.the_blue_shark.foods_and_flutes.FoodsAndFlutes;
import net.the_blue_shark.foods_and_flutes.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FoodsAndFlutes.MOD_ID);

    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            () -> new Item(new Item.Properties().food(ModFoods.CORN)));
    public static final RegistryObject<Item> POP_CORN = ITEMS.register("pop_corn",
            () -> new Item(new Item.Properties().food(ModFoods.POP_CORN)));

    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CORN_PLANT.get(), new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
