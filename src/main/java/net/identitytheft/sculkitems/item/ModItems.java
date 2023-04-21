package net.identitytheft.sculkitems.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.identitytheft.sculkitems.SculkItems;
import net.identitytheft.sculkitems.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModItems {
	public static Item REINFORCED_SCULK;
	public static Item ECHO_LIGHTER;

	private static Item register(Block block) {
		return register(Registries.BLOCK.getId(block), new BlockItem(block, new FabricItemSettings()));
	}

	private static Item register(String id, Item item) {
		return register(new Identifier(SculkItems.MOD_ID, id), item);
	}

	private static Item register(Identifier id, Item item) {
		return Registry.register(Registries.ITEM, id, item);
	}

	private static void addItemToGroup(ItemGroup group, Item item) {
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
	}

	public static void registerItems() {
		SculkItems.LOGGER.info("Registering Items for " + SculkItems.MOD_ID);

		REINFORCED_SCULK = register(ModBlocks.REINFORCED_SCULK);
		ECHO_LIGHTER = register("echo_lighter", new EchoLighterItem(new FabricItemSettings().maxDamage(64)));

		addItemToGroup(ModItemGroups.SCULK_ITEMS, REINFORCED_SCULK);
		addItemToGroup(ModItemGroups.SCULK_ITEMS, ECHO_LIGHTER);
	}
}
