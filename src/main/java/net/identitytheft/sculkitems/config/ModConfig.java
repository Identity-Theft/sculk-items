package net.identitytheft.sculkitems.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.identitytheft.sculkitems.SculkItems;

@Config(name = SculkItems.MOD_ID)
public class ModConfig implements ConfigData {
	@ConfigEntry.Gui.Tooltip
	@ConfigEntry.Gui.RequiresRestart
	public boolean requireSculkLighter = true;

	@ConfigEntry.Gui.Tooltip
	@ConfigEntry.Gui.RequiresRestart
	public boolean spawnOcclusion = true;

	@ConfigEntry.Gui.Tooltip
	public boolean playerStepDetector = true;
}