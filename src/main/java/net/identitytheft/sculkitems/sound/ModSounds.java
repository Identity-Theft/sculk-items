package net.identitytheft.sculkitems.sound;

import net.identitytheft.sculkitems.SculkItems;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
	public static final SoundEvent PEPSI_MAN_SECRET = registerSoundEvent("pepsi_man_secret");

	private static SoundEvent registerSoundEvent(String name) {
		Identifier id = new Identifier(SculkItems.MOD_ID, name);
		return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
	}

	public static void registerSounds() {
		SculkItems.LOGGER.info("Registering Sounds");
	}
}
