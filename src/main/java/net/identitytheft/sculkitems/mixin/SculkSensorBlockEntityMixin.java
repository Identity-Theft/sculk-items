package net.identitytheft.sculkitems.mixin;

import net.identitytheft.sculkitems.SculkItems;
import net.identitytheft.sculkitems.util.SculkItemsUtil;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SculkSensorBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.listener.GameEventListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SculkSensorBlockEntity.class)
public abstract class SculkSensorBlockEntityMixin {
	@Inject(method = "accept", at = @At("HEAD"), cancellable = true)
	public void accept(ServerWorld world, GameEventListener listener, BlockPos pos, GameEvent event, Entity entity, Entity sourceEntity, float distance, CallbackInfo ci) {
		BlockPos blockPos = SculkItemsUtil.getBlockEntityPosition((BlockEntity) (Object)this);
		if (SculkItems.CONFIG.playerStepDetector && (!(entity instanceof ServerPlayerEntity) || !event.equals(GameEvent.STEP)) && world.getBlockState(blockPos.down()).isOf(Blocks.NOTE_BLOCK)) {
			SculkItems.LOGGER.info("Step Detector moment");
			ci.cancel();
		}
	}
}