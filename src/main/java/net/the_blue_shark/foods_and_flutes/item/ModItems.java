package net.the_blue_shark.foods_and_flutes.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.the_blue_shark.foods_and_flutes.FoodsAndFlutes;
import net.the_blue_shark.foods_and_flutes.block.ModBlocks;
import net.the_blue_shark.foods_and_flutes.item.ModFoods;
import net.the_blue_shark.foods_and_flutes.item.custom.FluteItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FoodsAndFlutes.MOD_ID);
    //Food
    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            () -> new Item(new Item.Properties().food(ModFoods.CORN)));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(ModFoods.BANANA)));
    public static final RegistryObject<Item> POP_CORN = ITEMS.register("pop_corn",
            () -> new Item(new Item.Properties().food(ModFoods.POP_CORN)));
    public static final RegistryObject<Item> PEAR = ITEMS.register("pear",
            () -> new Item(new Item.Properties().food(ModFoods.PEAR)));
    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper",
            () -> new Item(new Item.Properties().food(ModFoods.HOT_PEPPER)));
    public static final RegistryObject<Item> BEER = ITEMS.register("beer",
            () -> new Item(new Item.Properties().food(ModFoods.BEER)));

    public static final RegistryObject<Item> HORSE_MEAT = ITEMS.register("horse_meat",
            () -> new Item(new Item.Properties().food(Foods.PORKCHOP)));

    //Seeds


    //Other Items
    public static final RegistryObject<Item> FLUTE = ITEMS.register("flute",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
