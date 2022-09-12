package com.mike.pruebamod.block;

import com.mike.pruebamod.PruebaMod;
import com.mike.pruebamod.block.custom.AmethystWaterPipe;
import com.mike.pruebamod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    private static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PruebaMod.MOD_ID);

//Primer bloque registrado
    public static final RegistryObject<Block> MEAT_BLOCK = registerBlock("meat_block", ()->new Block(BlockBehaviour.Properties.of(Material.NETHER_WOOD)
            .strength(1f).sound(SoundType.HONEY_BLOCK)), PruebaMod.PRUEBA_TAB);

    public static final RegistryObject<Block> PITORE = registerBlock("pito_ore", ()->new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)), PruebaMod.PRUEBA_TAB);

    public static final RegistryObject<Block> AMETHYST_WATER_PIPE = registerBlock("amethyst_water_pipe", ()->new AmethystWaterPipe(BlockBehaviour.Properties.of(Material.GLASS)
            .strength(0.5f).sound(SoundType.GLASS).noOcclusion().lightLevel(
                    (state) -> state.getValue(AmethystWaterPipe.ISOFF) ? 0:8)), PruebaMod.PRUEBA_TAB);



//Metodos necesarios para los bloques
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(),new Item.Properties().tab(tab) ));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
