package net.identitytheft.sculkitems.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.identitytheft.sculkitems.SculkItems;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModBlocks {
	public static Block ECHO_FIRE;
	public static Block REINFORCED_SCULK;

	private static Block register(String id, Block block) {
		return Registry.register(Registries.BLOCK, new Identifier(SculkItems.MOD_ID, id), block);
	}

	public static void registerBlocks() {
		SculkItems.LOGGER.info("Registering Blocks for " + SculkItems.MOD_ID);

		ECHO_FIRE = register("echo_fire", new EchoFireBlock(
			FabricBlockSettings.copyOf(Blocks.FIRE)
				.noCollision()
				.breakInstantly()
				.luminance(state -> 15)
				.nonOpaque()
				.sounds(BlockSoundGroup.WOOL)
			)
		);

		REINFORCED_SCULK = register("reinforced_sculk", new Block(
			FabricBlockSettings.copyOf(Blocks.SCULK)
				.strength(-1.0f, 3600000.0f)
				.dropsNothing()
				.sounds(BlockSoundGroup.SCULK)
			)
		);
	}
}
