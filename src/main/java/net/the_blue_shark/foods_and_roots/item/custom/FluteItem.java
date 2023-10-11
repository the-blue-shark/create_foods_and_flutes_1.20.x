package net.the_blue_shark.foods_and_roots.item.custom;



import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

import java.util.Properties;

public class FluteItem extends Item {

    public FluteItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            for(int i =0; i <= positionClicked.getY() + 64; i++) {
                
            }
        }


        return InteractionResult.SUCCESS;

    }

    @Override
    public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        super.onDestroyed(itemEntity, damageSource);
    }

}

