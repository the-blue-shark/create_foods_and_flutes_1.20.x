package net.the_blue_shark.foods_and_flutes.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.the_blue_shark.foods_and_flutes.FoodsAndFlutes;
import net.the_blue_shark.foods_and_flutes.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FoodsAndFlutes.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItem(ModItems.BANANA);
        simpleItem(ModItems.PEAR);

        simpleItem(ModItems.BEER);
        simpleItem(ModItems.PEPPER);
        simpleItem(ModItems.POP_CORN);
        simpleItem(ModItems.CORN);


    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FoodsAndFlutes.MOD_ID,"item/" + item.getId().getPath()));
    }
}
