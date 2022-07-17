package net.identitytheft.sculkitems;

import net.fabricmc.api.ModInitializer;
import net.identitytheft.sculkitems.block.ModBlocks;
import net.identitytheft.sculkitems.enchantment.ModEnchantments;
import net.identitytheft.sculkitems.item.ModItems;
import net.identitytheft.sculkitems.sound.ModSounds;
import net.identitytheft.sculkitems.util.LootTableModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SculkItems implements ModInitializer {
	public static final String MOD_ID = "sculkitems";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModSounds.registerSounds();
		ModEnchantments.registerEnchantments();
		ModBlocks.registerBlocks();
		ModItems.registerItems();

		LootTableModifier.modifyLootTables();
	}
}
