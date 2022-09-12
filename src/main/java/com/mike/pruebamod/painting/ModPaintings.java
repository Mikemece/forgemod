package com.mike.pruebamod.painting;

import com.mike.pruebamod.PruebaMod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, PruebaMod.MOD_ID);

    //Primer cuadro añadido
    public static final RegistryObject<PaintingVariant> KAMARON =
            PAINTING_MOTIVES.register("kamaron", () -> new PaintingVariant(320, 320));

    public static final RegistryObject<PaintingVariant> FOTON =
            PAINTING_MOTIVES.register("foton", () -> new PaintingVariant(32, 48));

    public static final RegistryObject<PaintingVariant> KNEKRO =
            PAINTING_MOTIVES.register("knekro", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> NYA =
            PAINTING_MOTIVES.register("nya", () -> new PaintingVariant(32, 32));

    public static void register(IEventBus eventBus){
        PAINTING_MOTIVES.register(eventBus);
    }
}


