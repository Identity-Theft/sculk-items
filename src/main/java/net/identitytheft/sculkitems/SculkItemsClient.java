package net.identitytheft.sculkitems;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.identitytheft.sculkitems.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class SculkItemsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECHO_FIRE, RenderLayer.getCutout());
    }
}
