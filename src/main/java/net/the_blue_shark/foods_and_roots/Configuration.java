package net.the_blue_shark.foods_and_roots;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber
public class Configuration
{
    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    // COMMON

    public static ForgeConfigSpec.DoubleValue CUTTING_BOARD_FORTUNE_BONUS;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();


        CUTTING_BOARD_FORTUNE_BONUS = COMMON_BUILDER.comment("How much of a bonus (in percentage) should each level of Fortune grant to Cutting Board chances? Set it to 0.0 to disable this.")
                .defineInRange("cuttingBoardFortuneBonus", 0.1, 0.0, 1.0);

        COMMON_CONFIG = COMMON_BUILDER.build();

        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }
}
