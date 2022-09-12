package com.mike.pruebamod.block.custom;
import com.mike.pruebamod.block.entity.ModBlockEntities;
import com.mike.pruebamod.block.entity.custom.AWPEntity;
import com.mike.pruebamod.block.entity.custom.WaterPipeEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;


public class AmethystWaterPipe extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty ISOFF =BooleanProperty.create("ison");

    public AmethystWaterPipe(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE =  Block.box(5, 0, 5, 11, 16, 11);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    /* FACING */

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(ISOFF);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof AWPEntity) {
                ((AWPEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }



    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            boolean isOff = pState.getValue(ISOFF);
            boolean recipe = AWPEntity.hasRecipe((AWPEntity) entity);

            //Si está encendida y se le da con un mechero se apaga
            if(pPlayer.getItemInHand(pHand).getItem()==Items.FLINT_AND_STEEL && !isOff) {
                pLevel.setBlock(pPos, pState.setValue(ISOFF, true),3);

            //Si tiene la receta dentro y se le da con un mechero se enciende
            }else if(pPlayer.getItemInHand(pHand).getItem()==Items.FLINT_AND_STEEL && recipe) {
                pLevel.setBlock(pPos, pState.setValue(ISOFF, false),3);

            //Si está encendida y se le da con algo que no sea mechero se fuma
            }else if(!isOff && pPlayer.getItemInHand(pHand).getItem()!=Items.FLINT_AND_STEEL && recipe) {
                AWPEntity.craftItem((AWPEntity) entity);
                pPlayer.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,500,2));

            //Si se intenta fumar cuando no tiene materiales, se apaga
            }else if(!isOff && pPlayer.getItemInHand(pHand).getItem()!=Items.FLINT_AND_STEEL && !recipe){
                pLevel.setBlock(pPos, pState.setValue(ISOFF, true),3);

            //Si no ocurre nada de lo anterior accedemos al inventario
            }else{
                if (entity instanceof AWPEntity) {
                    NetworkHooks.openScreen(((ServerPlayer) pPlayer), (AWPEntity) entity, pPos);
                } else {
                    throw new IllegalStateException("Our Container provider is missing!");
                }
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new AWPEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.WATER_PIPE_ENTITY.get(),
                AWPEntity::tick);
    }
}