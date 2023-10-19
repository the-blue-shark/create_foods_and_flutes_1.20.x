package net.the_blue_shark.foods_and_roots.crafting.ingredient;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.nbt.TagParser;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.the_blue_shark.foods_and_roots.FoodsAndRoots;

import java.lang.module.Configuration;

public class ChanceResult
{
/** public static final ChanceResult EMPTY = new ChanceResult(ItemStack.EMPTY, 1);

    private final ItemStack stack;
    private final float chance;

    public ChanceResult(ItemStack stack, float chance) {
        this.stack = stack;
        this.chance = chance;
    }

    public ItemStack getStack() {
        return stack;
    }

    public float getChance() {
        return chance;
    }

    public ItemStack rollOutput(RandomSource rand, int fortuneLevel) {
        int outputAmount = stack.getCount();
        double fortuneBonus = Configuration.CUTTING_BOARD_FORTUNE_BONUS.get() * fortuneLevel;
        for (int roll = 0; roll < stack.getCount(); roll++)
            if (rand.nextFloat() > chance + fortuneBonus)
                outputAmount--;
        if (outputAmount == 0)
            return ItemStack.EMPTY;
        ItemStack out = stack.copy();
        out.setCount(outputAmount);
        return out;
    }

    public JsonElement serialize() {
        JsonObject json = new JsonObject();

        ResourceLocation resourceLocation = ForgeRegistries.ITEMS.getKey(stack.getItem());
        json.addProperty("item", resourceLocation.toString());

        int count = stack.getCount();
        if (count != 1)
            json.addProperty("count", count);
        if (stack.hasTag())
            json.add("nbt", new JsonParser().parse(stack.getTag().toString()));
        if (chance != 1)
            json.addProperty("chance", chance);
        return json;
    }

    public static ChanceResult deserialize(JsonElement je) {
        if (!je.isJsonObject())
            throw new JsonSyntaxException("Must be a json object");

        JsonObject json = je.getAsJsonObject();
        String itemId = GsonHelper.getAsString(json, "item");
        int count = GsonHelper.getAsInt(json, "count", 1);
        float chance = GsonHelper.getAsFloat(json, "chance", 1);
        ItemStack itemstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemId)), count);

        if (GsonHelper.isValidPrimitive(json, "nbt")) {
            try {
                JsonElement element = json.get("nbt");
                itemstack.setTag(TagParser.parseTag(
                        element.isJsonObject() ? FoodsAndRoots.GSON.toJson(element) : GsonHelper.convertToString(element, "nbt")));
            }
            catch (CommandSyntaxException e) {
                e.printStackTrace();
            }
        }

        return new ChanceResult(itemstack, chance);
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeItem(getStack());
        buf.writeFloat(getChance());
    }

    public static ChanceResult read(FriendlyByteBuf buf) {
        return new ChanceResult(buf.readItem(), buf.readFloat());
    }
 */
}