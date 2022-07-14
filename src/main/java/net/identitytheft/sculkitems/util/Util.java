package net.identitytheft.sculkitems.util;

import com.google.common.base.Predicates;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.Direction;

public class Util {
	private static BlockPattern COMPLETED_FRAME;

	public static BlockPattern canSpawnEndFrameSculk(BooleanProperty EYE, DirectionProperty FACING) {
		if (COMPLETED_FRAME == null) {
			COMPLETED_FRAME = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?")
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
				.build();
		}

		return COMPLETED_FRAME;
	}
}
