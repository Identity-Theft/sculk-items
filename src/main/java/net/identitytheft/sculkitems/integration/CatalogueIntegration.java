package net.identitytheft.sculkitems.integration;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.loader.api.ModContainer;
import net.identitytheft.sculkitems.config.ModConfig;
import net.minecraft.client.gui.screen.Screen;

public final class CatalogueIntegration {

	public static Screen createConfigScreen(Screen currentScreen, ModContainer modContainer) {
		return AutoConfig.getConfigScreen(ModConfig.class, currentScreen).get();
	}
}
