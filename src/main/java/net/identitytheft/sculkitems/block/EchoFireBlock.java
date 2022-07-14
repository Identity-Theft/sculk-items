package net.identitytheft.sculkitems.block;

import net.identitytheft.sculkitems.SculkItems;
import net.minecraft.block.*;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldEvents;

public class EchoFireBlock
	extends AbstractFireBlock {
	public EchoFireBlock(Settings settings) {
		super(settings, 2);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		World world = ctx.getWorld();
		BlockPos blockPos = ctx.getBlockPos();

		Block fireBlock = world.getBlockState(blockPos).getBlock();
		Block block = world.getBlockState(blockPos.down()).getBlock();

		if (block != Blocks.AIR)
			return ModBlocks.ECHO_FIRE.getDefaultState();

		return fireBlock.getDefaultState();
	}

	public static boolean canPlaceAt(World world, BlockPos blockPos, BlockState blockState) {
		return isSculk(blockState) && world.getBlockState(blockPos).isAir();
	}

	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos blockPos, BlockState oldState, boolean notify) {
		//region End Portal Check
		BlockPos endFramePos = blockPos.north(2);
		BlockState endFrameState = world.getBlockState(endFramePos);
		BlockState portalCenter = world.getBlockState(blockPos);

		if (endFrameState.isOf(Blocks.END_PORTAL_FRAME) && endFrameState.get(EndPortalFrameBlock.EYE)) {
			SculkItems.LOGGER.info("Found End Portal Frame");

			BlockPattern.Result result = EndPortalFrameBlock.getCompletedFramePattern().searchAround(world, endFramePos);

			if (result != null && portalCenter.isOf(ModBlocks.ECHO_FIRE)) {
				SculkItems.LOGGER.info("Found completed portal");

				BlockPos blockPos2 = result.getFrontTopLeft().add(-3, 0, -3);
				for (int i = 0; i < 3; ++i) {
					for (int j = 0; j < 3; ++j) {
						world.setBlockState(blockPos2.add(i, 0, j), Blocks.END_PORTAL.getDefaultState(), Block.NOTIFY_LISTENERS);
					}
				}
				world.syncGlobalEvent(WorldEvents.END_PORTAL_OPENED, blockPos2.add(1, 0, 1), 0);
			}
		}
		//endregion
	}

	public static BlockState getState(World world, BlockPos blockPos) {

		return ModBlocks.ECHO_FIRE.getDefaultState();
	}

	private static boolean isSculk(BlockState state) {
		return state.getBlock() == ModBlocks.REINFORCED_SCULK;
	}

	@Override
	protected boolean isFlammable(BlockState state) {
		return true;
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		if (direction == Direction.DOWN && !canPlaceAt((World) world, pos, state)) {
			return Blocks.AIR.getDefaultState();
		}
		return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
	}
}

