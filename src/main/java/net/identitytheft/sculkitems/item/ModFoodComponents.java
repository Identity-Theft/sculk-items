package net.identitytheft.sculkitems.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

	public static final FoodComponent BLEACH = new FoodComponent.Builder()
//		.statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 400, 0), 1.0f)
		.alwaysEdible()
		.build();
}
