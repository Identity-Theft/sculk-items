package net.identitytheft.sculkitems.mixin;

import net.identitytheft.sculkitems.SculkItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.SculkSensorBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.PositionSource;
import net.minecraft.world.event.PositionSourceType;
import net.minecraft.world.event.Vibrations;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Vibrations.Callback.class)
public interface VibrationsCallback {
	@Shadow PositionSource getPositionSource();

	@Inject(method = "canAccept", at = @At("HEAD"), cancellable = true)
	private void canAccept(GameEvent gameEvent, GameEvent.Emitter emitter, CallbackInfoReturnable<Boolean> cir) {
		if ((Vibrations.Callback) (Object)this instanceof SculkSensorBlockEntity.Vib)
		Entity entity = emitter.sourceEntity();
		BlockState blockState = emitter.affectedState();

		PositionSource positionSource = getPositionSource();
		World world = ;
		Vec3d pos = positionSource.getPos()
		BlockPos blockPos = BlockPos.ofFloored(pos.getX(), pos.getY(), pos.getZ());

		SculkItems.LOGGER.info("{}", blockPos);

		if (SculkItems.CONFIG.playerStepDetector && positionSource.getType() == PositionSourceType.BLOCK
				&& world.getBlockState(blockPos.down()).isOf(Blocks.NOTE_BLOCK)
				&& (!(entity instanceof ServerPlayerEntity) || !gameEvent.equals(GameEvent.STEP))) {
			cir.setReturnValue(false);
		}
	}
}