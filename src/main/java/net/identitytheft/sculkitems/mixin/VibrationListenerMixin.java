package net.identitytheft.sculkitems.mixin;

import net.identitytheft.sculkitems.util.SculkItemsUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.listener.VibrationListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VibrationListener.Callback.class)
public interface VibrationListenerMixin {
	@Inject(method = "canAccept", at = @At("HEAD"), cancellable = true)
	private void canAccept(GameEvent gameEvent, GameEvent.Emitter emitter, CallbackInfoReturnable<Boolean> cir) {
		Entity entity = emitter.sourceEntity();
		if (entity instanceof LivingEntity livingEntity) {
			if (SculkItemsUtil.occlusionLevel(livingEntity) >= 1) {
				if (gameEvent.equals(GameEvent.STEP)) {
					cir.setReturnValue(false);
				}

				if (gameEvent.equals(GameEvent.SWIM)) {
					cir.setReturnValue(false);
				}

				if (gameEvent.equals(GameEvent.ELYTRA_GLIDE)) {
					cir.setReturnValue(false);
				}

				if (gameEvent.equals(GameEvent.HIT_GROUND)) {
					cir.setReturnValue(false);
				}

				if (gameEvent.equals(GameEvent.SPLASH)) {
					cir.setReturnValue(false);
				}
			}

			if (SculkItemsUtil.occlusionLevel(livingEntity) == 2) {
				if (gameEvent.equals(GameEvent.DRINK)) {
					cir.setReturnValue(false);
				}

				if (gameEvent.equals(GameEvent.PROJECTILE_SHOOT)) {
					cir.setReturnValue(false);
				}

				if (gameEvent.equals(GameEvent.ENTITY_INTERACT)) {
					cir.setReturnValue(false);
				}

				if (gameEvent.equals(GameEvent.EAT)) {
					cir.setReturnValue(false);
				}

				if (gameEvent.equals(GameEvent.ENTITY_DAMAGE)) {
					cir.setReturnValue(false);
				}

				if (gameEvent.equals(GameEvent.EQUIP)) {
					cir.setReturnValue(false);
				}

				if (gameEvent.equals(GameEvent.SHEAR)) {
					cir.setReturnValue(false);
				}

				if (gameEvent.equals(GameEvent.ITEM_INTERACT_FINISH)) {
					cir.setReturnValue(false);
				}

				if (gameEvent.equals(GameEvent.ITEM_INTERACT_START)) {
					cir.setReturnValue(false);
				}
			}
		}
	}
}
