package com.mike.pruebamod;

import com.mike.pruebamod.block.ModBlocks;
import com.mike.pruebamod.block.entity.ModBlockEntities;
import com.mike.pruebamod.item.ModItems;
import com.mike.pruebamod.networking.ModMessages;
import com.mike.pruebamod.painting.ModPaintings;
import com.mike.pruebamod.screen.ModMenuTypes;
import com.mike.pruebamod.screen.WaterPipeScreen;
import com.mike.pruebamod.sound.ModSounds;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PruebaMod.MOD_ID)
public class PruebaMod
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "pruebamod";
    public static final CreativeModeTab PRUEBA_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.IronAnalPlug.get());
        }
    };
    public PruebaMod()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModPaintings.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModSounds.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        // Register the enqueueIMC method for modloading

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ModMessages.register();
        });
        LOGGER.info("HELLO FROM PREINIT");
    }

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event){
            MenuScreens.register(ModMenuTypes.WATER_PIPE_MENU.get(), WaterPipeScreen::new);
    }

}
