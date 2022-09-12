package com.mike.pruebamod.block.entity;
import com.mike.pruebamod.PruebaMod;
import com.mike.pruebamod.block.ModBlocks;
import com.mike.pruebamod.block.entity.custom.AWPEntity;
import com.mike.pruebamod.block.entity.custom.WaterPipeEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PruebaMod.MOD_ID);



    public static final RegistryObject<BlockEntityType<AWPEntity>> WATER_PIPE_ENTITY =
            BLOCK_ENTITIES.register("water_pipe_entity", () ->
                    BlockEntityType.Builder.of(AWPEntity::new,
                            ModBlocks.AMETHYST_WATER_PIPE.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
