package net.identitytheft.sculkitems.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.identitytheft.sculkitems.SculkItems;
import net.identitytheft.sculkitems.enchantment.ModEnchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetEnchantmentsLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class LootTableModifier {
	private static final Identifier CHEST_ANICIENT_CITY = new Identifier("minecraft", "chests/ancient_city");

	public static void modifyLootTables() {
		if (SculkItems.CONFIG.spawnOcclusion) {
			LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
				if (source.isBuiltin()) {
					if (CHEST_ANICIENT_CITY.equals(id)) {
						LootPool.Builder builder = LootPool.builder()
							.with(ItemEntry.builder(Items.ENCHANTED_BOOK))
							.conditionally(RandomChanceLootCondition.builder(0.10f))
							.apply(new SetEnchantmentsLootFunction.Builder(true)
								.enchantment(ModEnchantments.OCCLUSION, UniformLootNumberProvider.create(1, 1)).build());

						tableBuilder.pool(builder);
					}
				}
			}));
		}
	}
}