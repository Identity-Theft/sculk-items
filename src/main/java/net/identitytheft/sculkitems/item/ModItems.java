package net.identitytheft.sculkitems.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.identitytheft.sculkitems.SculkItems;
import net.identitytheft.sculkitems.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

	//region Blocks
	 public static final Item REINFORCED_SCULK = registerBlockItem("reinforced_sculk", ModBlocks.REINFORCED_SCULK, ModItemGroups.SCULK_ITEMS);
	//endregion

	//region Items
	public static final Item SCULK_LIGHTER = registerItem("echo_lighter", new EchoLighterItem(new FabricItemSettings()
		.maxDamage(64)
		.group(ModItemGroups.SCULK_ITEMS)));
	//endregion


	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(SculkItems.MOD_ID, name), item);
	}

	private static Item registerBlockItem(String name, Block block, ItemGroup group) {
		return Registry.register(Registry.ITEM, new Identifier(SculkItems.MOD_ID, name),
			new BlockItem(block, new FabricItemSettings().group(group)));
	}

	public static void registerItems() {
		SculkItems.LOGGER.info("Registering Items for " + SculkItems.MOD_ID);
	}
}
