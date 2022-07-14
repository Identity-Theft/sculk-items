package net.identitytheft.sculkitems.mixin;

import com.google.common.base.Predicates;
import net.identitytheft.sculkitems.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndPortalFrameBlock.class)
public abstract class EndPortalFrameBlockMixin {

	@Shadow @Final public static BooleanProperty EYE;

	@Shadow @Final public static DirectionProperty FACING;

	@Shadow private static BlockPattern COMPLETED_FRAME;

	@Inject(method = "getCompletedFramePattern", at = @At("HEAD"))
	private static void getCompletedPatternFrame(CallbackInfoReturnable<BlockPattern> cir) {
		if (COMPLETED_FRAME == null) {
			COMPLETED_FRAME = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">?*?<", ">???<", "?^^^?")
				.where('?', CachedBlockPosition.matchesBlockState(BlockStatePredicate.ANY))
				.where('^', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.END_PORTAL_FRAME)
					.with(EYE, Predicates.equalTo(true))
					.with(FACING, Predicates.equalTo(Direction.SOUTH))))
				.where('>', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.END_PORTAL_FRAME)
					.with(EYE, Predicates.equalTo(true))
					.with(FACING, Predicates.equalTo(Direction.WEST))))
				.where('v', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.END_PORTAL_FRAME)
					.with(EYE, Predicates.equalTo(true))
					.with(FACING, Predicates.equalTo(Direction.NORTH))))
				.where('<', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(Blocks.END_PORTAL_FRAME)
					.with(EYE, Predicates.equalTo(true))
					.with(FACING, Predicates.equalTo(Direction.EAST))))
				.where('*', CachedBlockPosition.matchesBlockState(BlockStatePredicate.forBlock(ModBlocks.ECHO_FIRE)))
				.build();
		}
	}
}
