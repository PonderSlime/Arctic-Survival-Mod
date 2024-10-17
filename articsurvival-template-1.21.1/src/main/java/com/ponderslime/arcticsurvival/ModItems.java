package com.ponderslime.arcticsurvival;

import com.ponderslime.arcticsurvival.items.MagicWandItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item MAGIC_WAND = register(new MagicWandItem(new Item.Settings()), "magic_wand");

    public static Item register(Item item, String id) {
        Identifier identifier = Identifier.of(ArcticSurvival.MOD_ID, id);

        return Registry.register(Registries.ITEM, identifier, item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((group) -> group.add(MAGIC_WAND));
    }
}
