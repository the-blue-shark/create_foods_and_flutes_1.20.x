package net.the_blue_shark.foods_and_roots.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.the_blue_shark.foods_and_roots.FoodsAndRoots;
import net.the_blue_shark.foods_and_roots.block.ModBlocks;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, FoodsAndRoots.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, FoodsAndRoots.MOD_ID);

    public static final RegistryObject<PoiType> HONEY_POI = POI_TYPES.register("honey_poi",
            () -> new PoiType(
                    ImmutableSet.copyOf(Blocks.BEEHIVE.getStateDefinition().getPossibleStates()),
                    1, 1)
    );

    public static final RegistryObject<VillagerProfession> BEE_KEEPER =
            VILLAGER_PROFESSIONS.register("beekeeper", () -> new VillagerProfession("beekeeper",
                    x -> x.get() == HONEY_POI.get(), x -> x.get() == HONEY_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_BUTCHER));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
