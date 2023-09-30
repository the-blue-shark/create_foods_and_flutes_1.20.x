package net.the_blue_shark.foods_and_flutes.datagen;



import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.the_blue_shark.foods_and_flutes.FoodsAndFlutes;
import net.the_blue_shark.foods_and_flutes.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FoodsAndFlutes.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {


    }
}