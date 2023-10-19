package net.the_blue_shark.foods_and_roots.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.the_blue_shark.foods_and_roots.FoodsAndRoots;
import net.the_blue_shark.foods_and_roots.block.ModBlocks;
import net.the_blue_shark.foods_and_roots.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FoodsAndRoots.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItem(ModItems.BANANA);
        simpleItem(ModItems.PEAR);

        simpleItem(ModItems.BEER);
        simpleItem(ModItems.PEPPER);
        simpleItem(ModItems.POP_CORN);
        simpleItem(ModItems.CORN);
        simpleItem(ModItems.CORN_BOWL);
        simpleItem(ModItems.HORSE_MEAT);
        simpleItem(ModItems.BLUE_BERRIES);
        simpleItem(ModItems.NORI);
        simpleItem(ModItems.SUSHI);

        simpleItem(ModItems.PEPPER_SEEDS);
        simpleItem(ModItems.CORN_SEEDS);

        simpleBlockItemBlockTexture(ModBlocks.BUDDLEJA);
        simpleBlockItemBlockTexture(ModBlocks.ORANGE_LILY);

        simpleBlockItemBlockTexture(ModBlocks.APPLE_TREE_SAPLING);


    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FoodsAndRoots.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FoodsAndRoots.MOD_ID,"block/" + item.getId().getPath()));
    }
}
