package com.mike.pruebamod.event;


import com.mike.pruebamod.PruebaMod;
import com.mike.pruebamod.block.ModBlocks;
import com.mike.pruebamod.screen.ModMenuTypes;
import com.mike.pruebamod.screen.WaterPipeScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = PruebaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value= Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event){

        MenuScreens.register(ModMenuTypes.WATER_PIPE_MENU.get(), WaterPipeScreen::new);
    }
}
