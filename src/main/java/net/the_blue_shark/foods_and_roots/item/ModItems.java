package net.the_blue_shark.foods_and_roots.item;

import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.the_blue_shark.foods_and_roots.FoodsAndRoots;
import net.the_blue_shark.foods_and_roots.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FoodsAndRoots.MOD_ID);
    //Food
    public static final RegistryObject<Item> BLUE_BERRIES = ITEMS.register("blue_berries",
            () -> new ItemNameBlockItem(ModBlocks.BLUE_BERRY_BUSH.get(),new  Item.Properties().food(Foods.SWEET_BERRIES)));
    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            () -> new Item(new Item.Properties().food(ModFoods.CORN)));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(ModFoods.BANANA)));
    public static final RegistryObject<Item> POP_CORN = ITEMS.register("pop_corn",
            () -> new BowlFoodItem(new Item.Properties().food(ModFoods.POP_CORN)));

    public static final RegistryObject<Item> CORN_BOWL = ITEMS.register("corn_bowl",
            () -> new BowlFoodItem(new Item.Properties().food(ModFoods.CORN_BOWL)));
    public static final RegistryObject<Item> PEAR = ITEMS.register("pear",
            () -> new Item(new Item.Properties().food(ModFoods.PEAR)));
    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper",
            () -> new Item(new Item.Properties().food(ModFoods.HOT_PEPPER)));
    public static final RegistryObject<Item> BEER = ITEMS.register("beer",
            () -> new Item(new Item.Properties().food(ModFoods.BEER)));

    public static final RegistryObject<Item> HORSE_MEAT = ITEMS.register("horse_meat",
            () -> new Item(new Item.Properties().food(Foods.PORKCHOP)));

    //Seeds
    public static final RegistryObject<Item> PEPPER_SEEDS = ITEMS.register("pepper_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PEPPER_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(), new Item.Properties()));

    //Other Items
    public static final RegistryObject<Item> FLUTE = ITEMS.register("flute",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
