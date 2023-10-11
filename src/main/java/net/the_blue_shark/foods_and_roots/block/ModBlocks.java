package net.the_blue_shark.foods_and_roots.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.the_blue_shark.foods_and_roots.FoodsAndRoots;
import net.the_blue_shark.foods_and_roots.block.custom.CornCropBlock;
import net.the_blue_shark.foods_and_roots.block.custom.PepperCropBlock;
import net.the_blue_shark.foods_and_roots.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    //Code
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FoodsAndRoots.MOD_ID);




     //Crops
     public static final RegistryObject<Block> PEPPER_CROP = BLOCKS.register("pepper_crop",
             () -> new PepperCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    //flowers
    public static final RegistryObject<Block>  BUDDLEJA = registerBlock("buddleja",
            () -> new FlowerBlock(() -> MobEffects.HEALTH_BOOST, 2, BlockBehaviour.Properties.copy(Blocks.POPPY).noOcclusion().noCollission()));

    public static final RegistryObject<Block>  POTTED_BUDDLEJA = BLOCKS.register("potted_buddleja",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.BUDDLEJA,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));

    //Sacks And Crates
    public static final RegistryObject<Block> CORN_CRATE = registerBlock("corn_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIED_KELP_BLOCK)));
    public static final RegistryObject<Block> BANANA_CRATE = registerBlock("banana_crate.json",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIED_KELP_BLOCK)));

    //Code
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}