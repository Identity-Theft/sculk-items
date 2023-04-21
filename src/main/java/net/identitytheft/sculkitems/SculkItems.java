package net.identitytheft.sculkitems;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.identitytheft.sculkitems.block.ModBlocks;
import net.identitytheft.sculkitems.config.ModConfig;
import net.identitytheft.sculkitems.enchantment.ModEnchantments;
import net.identitytheft.sculkitems.item.ModItemGroups;
import net.identitytheft.sculkitems.item.ModItems;
import net.identitytheft.sculkitems.util.LootTableModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SculkItems implements ModInitializer {
	public static final String MOD_ID = "sculk_items";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ModConfig CONFIG;

	@Override
	public void onInitialize() {
		AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

		ModItemGroups.registerItemGroups();

		ModEnchantments.registerEnchantments();

		ModBlocks.registerBlocks();
		ModItems.registerItems();

		LootTableModifier.modifyLootTables();
	}
}
