package com.mike.pruebamod.block.entity.custom;

import com.mike.pruebamod.screen.WaterPipeMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class AWPEntity extends WaterPipeEntity implements MenuProvider {
    public AWPEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Cachimba Amatista");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new WaterPipeMenu(pContainerId, pPlayerInventory, this);
    }
}
