package com.ponderslime.arcticsurvival;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block MAGIC_DIRT = register(new Block(AbstractBlock.Settings.copy(Blocks.DIRT)), "magic_dirt");

    public static Block register(Block block, String id) {
        Identifier identifier = Identifier.of(ArcticSurvival.MOD_ID, id);

        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, identifier, blockItem);

        return Registry.register(Registries.BLOCK, identifier, block);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((group) -> group.add(MAGIC_DIRT));
    }
}
