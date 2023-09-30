package net.the_blue_shark.foods_and_flutes.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.the_blue_shark.foods_and_flutes.FoodsAndFlutes;
import net.the_blue_shark.foods_and_flutes.item.ModItems;
import net.the_blue_shark.foods_and_flutes.loot.AddItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, FoodsAndFlutes.MOD_ID);
    }

    @Override
    protected void start() {

        add("horse_meat_from_horse", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/horse")).build(),
                LootItemRandomChanceCondition.randomChance(0.30f).build()}, ModItems.HORSE_MEAT.get()));

        add("corn_from_village_chests", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village_plains_house")).build() }, ModItems.CORN.get()));


    }
}
