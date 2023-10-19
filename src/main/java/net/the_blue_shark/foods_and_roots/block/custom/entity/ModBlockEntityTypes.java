package net.the_blue_shark.foods_and_roots.block.custom.entity;import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.the_blue_shark.foods_and_roots.FoodsAndRoots;
import net.the_blue_shark.foods_and_roots.block.ModBlocks;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FoodsAndRoots.MOD_ID);

   /** public static final RegistryObject<BlockEntityType<CuttingBoardBlockEntity>> CUTTING_BOARD = TILES.register("cutting_board",
            () -> BlockEntityType.Builder.of(CuttingBoardBlockEntity::new, ModBlocks.CUTTING_BOARD.get()).build(null)); */
}

