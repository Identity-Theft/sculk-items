package net.identitytheft.sculkitems.enchantment;

import net.identitytheft.sculkitems.SculkItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
	public static Enchantment OCCLUSION;

	private static Enchantment register(String id, Enchantment enchantment) {
		return Registry.register(Registries.ENCHANTMENT, new Identifier(SculkItems.MOD_ID, id), enchantment);
	}

	public static void registerEnchantments() {
		SculkItems.LOGGER.info("Registering Enchantments for " + SculkItems.MOD_ID);

		OCCLUSION = register("occlusion", new OcclusionEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_CHEST, EquipmentSlot.CHEST));
	}
}
