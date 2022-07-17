package net.identitytheft.sculkitems.mixin;

import net.identitytheft.sculkitems.util.SculkItemsUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.SculkSensorBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SculkSensorBlock.class)
public abstract class SculkSensorBlockMixin {
	@Inject(method = "onSteppedOn", at = @At("HEAD"), cancellable = true)
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity, CallbackInfo ci) {
		if (entity instanceof LivingEntity livingEntity) {
			if (SculkItemsUtil.occlusionLevel(livingEntity) != 0) {
				ci.cancel();
			}
		}
	}
}
