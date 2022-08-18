package com.mike.pruebamod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties PITO_QUEMAO = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 2000, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 150, 2), 1.0F).alwaysEat().build();

}
