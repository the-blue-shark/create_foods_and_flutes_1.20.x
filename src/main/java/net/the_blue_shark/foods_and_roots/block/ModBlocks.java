package net.the_blue_shark.foods_and_roots.block;

import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.the_blue_shark.foods_and_roots.FoodsAndRoots;
import net.the_blue_shark.foods_and_roots.block.custom.BlueBerryBush;
import net.the_blue_shark.foods_and_roots.block.custom.CornCropBlock;
import net.the_blue_shark.foods_and_roots.block.custom.CuttingBoardBlock;
import net.the_blue_shark.foods_and_roots.block.custom.PepperCropBlock;
import net.the_blue_shark.foods_and_roots.item.ModItems;
import net.the_blue_shark.foods_and_roots.worldgen.tree.AppleTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {

    //Code
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FoodsAndRoots.MOD_ID);


     //Bushes
     public static final RegistryObject<Block> BLUE_BERRY_BUSH = BLOCKS.register("blue_berry_bush",
             () -> new BlueBerryBush(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion().noCollission()));
     //Crops
     public static final RegistryObject<Block> PEPPER_CROP = BLOCKS.register("pepper_crop",
             () -> new PepperCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    //flowers
    public static final RegistryObject<Block>  ORANGE_LILY = registerBlock("orange_lily",
            () -> new FlowerBlock(() -> MobEffects.FIRE_RESISTANCE, 10, BlockBehaviour.Properties.copy(Blocks.POPPY).noOcclusion().noCollission()));

    public static final RegistryObject<Block>  POTTED_ORANGE_LILY = BLOCKS.register("potted_orange_lily",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.ORANGE_LILY,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));
    public static final RegistryObject<Block>  BUDDLEJA = registerBlock("buddleja",

            () -> new FlowerBlock(() -> MobEffects.HEALTH_BOOST, 2, BlockBehaviour.Properties.copy(Blocks.POPPY).noOcclusion().noCollission()));

    public static final RegistryObject<Block>  POTTED_BUDDLEJA = BLOCKS.register("potted_buddleja",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.BUDDLEJA,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()));

    //Blocks
    public static final RegistryObject<Block> CORN_CRATE = registerBlock("corn_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIED_KELP_BLOCK)));
    public static final RegistryObject<Block> BANANA_CRATE = registerBlock("banana_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIED_KELP_BLOCK)));

    public static final RegistryObject<Block> APPLE_LEAVES = registerBlock("apple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES))
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> APPLE_TREE_SAPLING = registerBlock("apple_tree_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    /** public static final RegistryObject<Block> CUTTING_BOARD = BLOCKS.register("cutting_board",
            () -> new CuttingBoardBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD))); */

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