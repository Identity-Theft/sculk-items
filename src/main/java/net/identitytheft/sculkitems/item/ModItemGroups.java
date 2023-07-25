package net.identitytheft.sculkitems.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.identitytheft.sculkitems.SculkItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
	public static ItemGroup SCULK_ITEMS = Registry.register(Registries.ITEM_GROUP, new Identifier(SculkItems.MOD_ID, "sculk_items"),
		FabricItemGroup.builder().displayName(Text.translatable("itemGroup.sculk_items.sculk_items"))
			.icon(() -> new ItemStack(Items.SCULK))
			.entries((displayContext, entries) -> {
				entries.add(ModItems.REINFORCED_SCULK);
				entries.add(ModItems.ECHO_LIGHTER);
			}).build()
	);

	public static void registerItemGroups() {
		SculkItems.LOGGER.info("Registering Items Groups for " + SculkItems.MOD_ID);
	}
}
