package com.mike.pruebamod.painting;

import com.mike.pruebamod.PruebaMod;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<Motive> PAINTING_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, PruebaMod.MOD_ID);

    //Primer cuadro añadido
    public static final RegistryObject<Motive> KAMARON =
            PAINTING_MOTIVES.register("kamaron", () -> new Motive(320, 320));

    public static final RegistryObject<Motive> FOTON =
            PAINTING_MOTIVES.register("foton", () -> new Motive(32, 48));

    public static final RegistryObject<Motive> KNEKRO =
            PAINTING_MOTIVES.register("knekro", () -> new Motive(16, 16));

    public static final RegistryObject<Motive> NYA =
            PAINTING_MOTIVES.register("nya", () -> new Motive(32, 32));

    public static void register(IEventBus eventBus){
        PAINTING_MOTIVES.register(eventBus);
    }
}


