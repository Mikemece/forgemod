package com.mike.pruebamod.item;

import com.mike.pruebamod.PruebaMod;
import com.mike.pruebamod.item.custom.DiamondAnalPlugItem;
import com.mike.pruebamod.item.custom.IronAnalPlugItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //Esto es como una lista de items
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, PruebaMod.MOD_ID);

//primer objeto añadido
    public static final RegistryObject<Item> PITO = ITEMS.register("pito",
            ()-> new Item(new Item.Properties().tab(PruebaMod.PRUEBA_TAB)));

    public static final RegistryObject<Item> PITOcocina = ITEMS.register("pito_cooked",
            ()-> new Item(new Item.Properties().tab(PruebaMod.PRUEBA_TAB).food(ModFoods.PITO_QUEMAO)));

    public static final RegistryObject<Item> IronAnalPlug = ITEMS.register("iron_anal_plug",
            ()-> new IronAnalPlugItem(new Item.Properties().tab(PruebaMod.PRUEBA_TAB).durability(50)));

    public static final RegistryObject<Item> DiamondAnalPlug = ITEMS.register("diamond_anal_plug",
            ()-> new DiamondAnalPlugItem(new Item.Properties().tab(PruebaMod.PRUEBA_TAB).durability(150)));

    public static final RegistryObject<Item> MANGUERA = ITEMS.register("manguera",
            ()-> new Item(new Item.Properties().tab(PruebaMod.PRUEBA_TAB)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
