package net.identitytheft.sculkitems.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class OcclusionEnchantment extends Enchantment {
	public OcclusionEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.ARMOR_CHEST, slotTypes);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}
}
