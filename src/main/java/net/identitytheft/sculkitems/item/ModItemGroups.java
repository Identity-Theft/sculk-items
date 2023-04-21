package net.identitytheft.sculkitems.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.identitytheft.sculkitems.SculkItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
	public static ItemGroup SCULK_ITEMS;

	public static void registerItemGroups() {
		SCULK_ITEMS = FabricItemGroup.builder(new Identifier(SculkItems.MOD_ID, "sculk_items"))
				.displayName(Text.translatable("itemGroup.sculkitems.sculk_items"))
				.icon(() -> new ItemStack(Items.SCULK))
				.build();
	}
}
