package com.mike.pruebamod.painting;

import com.mike.pruebamod.PruebaMod;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPintings {
    public static final DeferredRegister<Motive> PAINTING_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, PruebaMod.MOD_ID);

    //Primer cuadro añadido
    public static final RegistryObject<Motive> KAMARON =
            PAINTING_MOTIVES.register("kamaron", () -> new Motive(16, 16));

    public static final RegistryObject<Motive> FOTON =
            PAINTING_MOTIVES.register("foton", () -> new Motive(32, 48));

    public static void register(IEventBus eventBus){
        PAINTING_MOTIVES.register(eventBus);
    }
}


