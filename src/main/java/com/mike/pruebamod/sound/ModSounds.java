package com.mike.pruebamod.sound;

import com.mike.pruebamod.PruebaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PruebaMod.MOD_ID);


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(PruebaMod.MOD_ID, name)));
    }

    //Primer sonido registrado
    public static RegistryObject<SoundEvent> WATER_PIPE_ON = registerSoundEvent("water_pipe_on");
    public static RegistryObject<SoundEvent> WATER_PIPE_SMOKE = registerSoundEvent("water_pipe_smoke");

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
