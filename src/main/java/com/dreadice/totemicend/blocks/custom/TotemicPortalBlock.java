package com.dreadice.totemicend.blocks.custom;

import com.dreadice.totemicend.items.modItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class TotemicPortalBlock extends Block {

    public static final int MIN_CHARGES = 0;
    public static final int MAX_CHARGES = 8;
    public static final IntegerProperty PORTAL_BLOCK_CHARGES = IntegerProperty.create("charges", 0, 8);

    public TotemicPortalBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PORTAL_BLOCK_CHARGES, Integer.valueOf(0)));
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if (pState.getValue(PORTAL_BLOCK_CHARGES) == MAX_CHARGES) {
            maxChargeUse(pPlayer, pLevel, pPos, pState);
        }

        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (pHand == InteractionHand.MAIN_HAND && !isChargeFuel(itemstack) && isChargeFuel(pPlayer.getItemInHand(InteractionHand.OFF_HAND))) {
            return InteractionResult.PASS;
        } else if (isChargeFuel(itemstack) && canBeCharged(pState)) {
            charge(pPlayer, pLevel, pPos, pState);
            if (!pPlayer.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else if (pState.getValue(PORTAL_BLOCK_CHARGES) == MIN_CHARGES) {
            return InteractionResult.PASS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    private static boolean isChargeFuel(ItemStack pStack) {
        return pStack.is(modItems.CRYSTALISED_TOTEMIC_SHARD.get());
    }

    private static boolean canBeCharged(BlockState pState) {
        return pState.getValue(PORTAL_BLOCK_CHARGES) < MAX_CHARGES;
    }

    //Method that is Called when the Portal Block needs to be Charged
    public static void charge(@Nullable Entity player, Level level, BlockPos pos, BlockState blockState) {
        BlockState blockstate = blockState.setValue(PORTAL_BLOCK_CHARGES, Integer.valueOf(blockState.getValue(PORTAL_BLOCK_CHARGES) + 1));
        level.setBlock(pos, blockstate, 3);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
        level.playSound((Player)null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.RESPAWN_ANCHOR_CHARGE, SoundSource.BLOCKS, 1.0F, 1.0F);
        if (blockstate.getValue(PORTAL_BLOCK_CHARGES) == MAX_CHARGES) {
            level.playSound((Player)null, pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.END_PORTAL_SPAWN, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

    }

    public static  void maxChargeUse(@Nullable Entity player, Level level, BlockPos pos, BlockState blockState) {
        BlockState usedPortalCharge = blockState.setValue(PORTAL_BLOCK_CHARGES, 0);
        level.setBlock(pos, usedPortalCharge , 3);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, usedPortalCharge));
        level.playSound((Player)null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(PORTAL_BLOCK_CHARGES);
    }

    //Spawn Particles Randomly if the Totemic Portal Block is at Max Charges
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(PORTAL_BLOCK_CHARGES) == MAX_CHARGES) {
            if (pRandom.nextInt(100) == 0) {
                pLevel.playSound((Player)null, (double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, SoundEvents.RESPAWN_ANCHOR_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F);
            }

            double d0 = (double)pPos.getX() + 0.5D + (0.5D - pRandom.nextDouble());
            double d1 = (double)pPos.getY() + 1.0D;
            double d2 = (double)pPos.getZ() + 0.5D + (0.5D - pRandom.nextDouble());
            double d3 = (double)pRandom.nextFloat() * 0.04D;

            DustParticleOptions particle = new DustParticleOptions(Vec3.fromRGB24(87212114).toVector3f(), 1f);
            pLevel.addParticle(particle, d0, d1, d2, 0.0D, d3, 0.0D);
        }
    }

}
