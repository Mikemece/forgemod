package com.mike.pruebamod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class IronAnalPlugItem extends Item {
    public IronAnalPlugItem(Properties pProperties) {
        super(pProperties);
    }

        @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100,1));
            player.getCooldowns().addCooldown(this, 200);
            player.getItemInHand(usedHand).hurtAndBreak(1, player , (playera)-> player.broadcastBreakEvent(usedHand));
        return super.use(level, player, usedHand);
    }
}
