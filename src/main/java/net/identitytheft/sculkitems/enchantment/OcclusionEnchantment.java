package net.identitytheft.sculkitems.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class OcclusionEnchantment extends Enchantment {
	public OcclusionEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
		super(weight, type, slotTypes);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}
}
