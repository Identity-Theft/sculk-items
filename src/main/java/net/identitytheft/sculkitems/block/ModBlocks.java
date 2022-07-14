package net.identitytheft.sculkitems.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.identitytheft.sculkitems.SculkItems;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	public static final Block ECHO_FIRE = registerBlock("echo_fire", new EchoFireBlock(
		FabricBlockSettings.of(Material.FIRE)
			.noCollision()
			.breakInstantly()
			.luminance(state -> 15)
			.nonOpaque()
			.sounds(BlockSoundGroup.WOOL)
		)
	);

	public static final Block REINFORCED_SCULK = registerBlock("reinforced_sculk", new Block(
		FabricBlockSettings.of(Material.SCULK)
			.strength(-1.0f, 3600000.0f)
			.dropsNothing()
			.sounds(BlockSoundGroup.SCULK)
		)
	);

	private static Block registerBlock(String id, Block block) {
		return Registry.register(Registry.BLOCK, new Identifier(SculkItems.MOD_ID, id), block);
	}

	public static void registerBlocks() {
		SculkItems.LOGGER.info("Registering Blocks");
	}
}
