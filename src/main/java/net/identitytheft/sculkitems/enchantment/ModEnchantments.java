package net.identitytheft.sculkitems.enchantment;

import net.identitytheft.sculkitems.SculkItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
	public static Enchantment OCCLUSION = register("occlusion", new OcclusionEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_CHEST, EquipmentSlot.CHEST));


	private static Enchantment register(String name, Enchantment enchantment) {
		return Registry.register(Registry.ENCHANTMENT, new Identifier(SculkItems.MOD_ID, name), enchantment);
	}

	public static void registerEnchantments() {
		SculkItems.LOGGER.info("Registering Enchantments for " + SculkItems.MOD_ID);
	}
}
