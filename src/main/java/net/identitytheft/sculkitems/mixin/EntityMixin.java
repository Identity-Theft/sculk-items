package net.identitytheft.sculkitems.mixin;

import net.identitytheft.sculkitems.util.SculkItemsUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Inject(method = "occludeVibrationSignals", at = @At("HEAD"), cancellable = true)
    public void occlude(CallbackInfoReturnable<Boolean> cir)
    {
        if ((Entity)(Object) this instanceof LivingEntity livingEntity && SculkItemsUtil.occlusionLevel(livingEntity) >= 2)
            cir.setReturnValue(true);
    }

    @Inject(method = "bypassesSteppingEffects", at = @At("HEAD"), cancellable = true)
    public void bypassStep(CallbackInfoReturnable<Boolean> cir){
        if ((Entity)(Object) this instanceof LivingEntity livingEntity && SculkItemsUtil.occlusionLevel(livingEntity) >= 1)
            cir.setReturnValue(true);
    }
}
