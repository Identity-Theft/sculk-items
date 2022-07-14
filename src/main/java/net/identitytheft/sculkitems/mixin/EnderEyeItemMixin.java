package net.identitytheft.sculkitems.mixin;

import net.identitytheft.sculkitems.block.ModBlocks;
import net.identitytheft.sculkitems.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderEyeItem.class)
public abstract class EnderEyeItemMixin {

	@Inject(method = "useOnBlock", at = @At("TAIL"))
	public void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
		BlockPos blockPos = context.getBlockPos();
		World world = context.getWorld();
		BlockState blockState = world.getBlockState(blockPos);

		if (blockState.isOf(Blocks.END_PORTAL_FRAME)) {
			BlockPattern.Result result = Util.canSpawnEndFrameSculk(EndPortalFrameBlock.EYE, EndPortalFrameBlock.FACING).searchAround(world, blockPos);

			if (result != null) {
				BlockPos sculkPos = result.getFrontTopLeft().add(-2,-1,-2);
				BlockState sculkState = ModBlocks.REINFORCED_SCULK.getDefaultState();
				BlockState beforeSculk = world.getBlockState(sculkPos);

				Block.pushEntitiesUpBeforeBlockChange(beforeSculk, sculkState, world, sculkPos);
				world.setBlockState(sculkPos, sculkState, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);

				double d;
				double e;
				double f;

				ServerWorld serverWorld = (ServerWorld) world;
				Random random = Random.create();

				for (int i = 0; i < 20; ++i) {
					d = (double)sculkPos.getX() + random.nextDouble();
					e = (double)(sculkPos.getY() + 1) - random.nextDouble() * (double)0.1f;
					f = (double)sculkPos.getZ() + random.nextDouble();
					serverWorld.spawnParticles(ParticleTypes.FLAME, d, e, f, 1, 0, 0, 0, 1);
				}
			}
		}
	}
}
