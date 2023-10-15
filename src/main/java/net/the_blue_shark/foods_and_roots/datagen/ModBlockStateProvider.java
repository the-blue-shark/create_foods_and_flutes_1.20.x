package net.the_blue_shark.foods_and_roots.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.the_blue_shark.foods_and_roots.FoodsAndRoots;
import net.the_blue_shark.foods_and_roots.block.ModBlocks;
import net.the_blue_shark.foods_and_roots.block.custom.BlueBerryBush;
import net.the_blue_shark.foods_and_roots.block.custom.CornCropBlock;
import net.the_blue_shark.foods_and_roots.block.custom.PepperCropBlock;

import java.util.function.Function;

import static net.minecraft.world.level.block.SweetBerryBushBlock.AGE;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FoodsAndRoots.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeBlueBerryBush((BushBlock) ModBlocks.BLUE_BERRY_BUSH.get(), "blue_berry_bush", "blue_berry_bush");
        makePepperCrop((CropBlock) ModBlocks.PEPPER_CROP.get(), "pepper_crop_stage", "pepper_crop_stage");
        makeCornCrop(((CropBlock) ModBlocks.CORN_CROP.get()), "corn_crop_stage", "corn_crop_stage");

        simpleBlockWithItem(ModBlocks.BUDDLEJA.get(), models().cross(blockTexture(ModBlocks.BUDDLEJA.get()).getPath(),
                blockTexture(ModBlocks.BUDDLEJA.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_BUDDLEJA.get(), models().singleTexture("potted_buddleja", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.BUDDLEJA.get())).renderType("cutout"));
    }
    public void makeBlueBerryBush(BushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> blueBerryBushStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] blueBerryBushStates(BlockState state, BushBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(AGE),
                new ResourceLocation(FoodsAndRoots.MOD_ID, "block/" + textureName + state.getValue(AGE))).renderType("cutout"));

        return models;
    }
    public void makePepperCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> PepperStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] PepperStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(((PepperCropBlock) block).getAgeProperty()),
                new ResourceLocation(FoodsAndRoots.MOD_ID, "block/" + textureName + state.getValue(((PepperCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeCornCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
                new ResourceLocation(FoodsAndRoots.MOD_ID, "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
