package net.identitytheft.sculkitems.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.identitytheft.sculkitems.SculkItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModItemGroups {
	public static final ItemGroup SCULK_ITEMS = FabricItemGroupBuilder.build(
		new Identifier(SculkItems.MOD_ID, "sculk_items"), () -> new ItemStack(Items.SCULK));
}
