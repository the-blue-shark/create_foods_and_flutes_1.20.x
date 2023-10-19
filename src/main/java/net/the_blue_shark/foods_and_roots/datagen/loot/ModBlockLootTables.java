package net.the_blue_shark.foods_and_roots.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.the_blue_shark.foods_and_roots.block.ModBlocks;
import net.the_blue_shark.foods_and_roots.block.custom.BlueBerryBush;
import net.the_blue_shark.foods_and_roots.block.custom.CornCropBlock;
import net.the_blue_shark.foods_and_roots.block.custom.PepperCropBlock;
import net.the_blue_shark.foods_and_roots.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CORN_CRATE.get());
        this.dropSelf(ModBlocks.BANANA_CRATE.get());
        this.dropSelf(ModBlocks.BUDDLEJA.get());
        this.dropSelf(ModBlocks.ORANGE_LILY.get());
        this.dropSelf(ModBlocks.APPLE_TREE_SAPLING.get());

        //potted
        this.add(ModBlocks.POTTED_BUDDLEJA.get(), createPotFlowerItemTable(ModBlocks.BUDDLEJA.get()));
        this.add(ModBlocks.POTTED_ORANGE_LILY.get(), createPotFlowerItemTable(ModBlocks.ORANGE_LILY.get()));

        LootItemCondition.Builder lootitemcondition$builder4 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.APPLE_LEAVES.get());

        this.add(ModBlocks.APPLE_LEAVES.get(), createCropDrops(ModBlocks.APPLE_LEAVES.get(),
                Items.APPLE, Items.APPLE, lootitemcondition$builder4));


        LootItemCondition.Builder lootitemcondition$builder3 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.BLUE_BERRY_BUSH.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PepperCropBlock.AGE, 3));

        this.add(ModBlocks.BLUE_BERRY_BUSH.get(), createCropDrops(ModBlocks.BLUE_BERRY_BUSH.get(),
                ModItems.BLUE_BERRIES.get(), ModItems.BLUE_BERRIES.get(), lootitemcondition$builder3));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.PEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PepperCropBlock.AGE, 5));

        this.add(ModBlocks.PEPPER_CROP.get(), createCropDrops(ModBlocks.PEPPER_CROP.get(),
                ModItems.PEPPER.get(), ModItems.PEPPER_SEEDS.get(), lootitemcondition$builder));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 6));

        this.add(ModBlocks.CORN_CROP.get(), createCropDrops(ModBlocks.CORN_CROP.get(),
                ModItems.CORN_SEEDS.get(), ModItems.CORN.get(), lootitemcondition$builder2));

    }


    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}