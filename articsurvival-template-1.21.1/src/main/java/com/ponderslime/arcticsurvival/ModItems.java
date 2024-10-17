package com.ponderslime.arcticsurvival;

import com.ponderslime.arcticsurvival.items.MagicWandItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    //Armor

    public static final Item SNOW_GEAR_HELMET = register(new ArmorItem(ModArmorMaterials.SNOW_GEAR, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(ModArmorMaterials.SNOW_GEAR_DURABILITY_MULTIPLIER))), "snow_gear_helmet");
    public static final Item SNOW_GEAR_CHESTPLATE = register(new ArmorItem(ModArmorMaterials.SNOW_GEAR, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(ModArmorMaterials.SNOW_GEAR_DURABILITY_MULTIPLIER))), "snow_gear_chestplate");
    public static final Item SNOW_GEAR_LEGGINGS = register(new ArmorItem(ModArmorMaterials.SNOW_GEAR, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(ModArmorMaterials.SNOW_GEAR_DURABILITY_MULTIPLIER))), "snow_gear_leggings");
    public static final Item SNOW_GEAR_BOOTS = register(new ArmorItem(ModArmorMaterials.SNOW_GEAR, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(ModArmorMaterials.SNOW_GEAR_DURABILITY_MULTIPLIER))), "snow_gear_boots");

    public static final Item MAGIC_WAND = register(new MagicWandItem(new Item.Settings()), "magic_wand");

    public static Item register(Item item, String id) {
        Identifier identifier = Identifier.of(ArcticSurvival.MOD_ID, id);

        return Registry.register(Registries.ITEM, identifier, item);
    }
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(ArcticSurvival.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.SNOW_GEAR_HELMET))
            .displayName(Text.translatable("itemGroup.arcticsurvival"))
            .build();

    public static void initialize() {
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.MAGIC_WAND);
            itemGroup.add(ModItems.SNOW_GEAR_HELMET);
            itemGroup.add(ModItems.SNOW_GEAR_CHESTPLATE);
            itemGroup.add(ModItems.SNOW_GEAR_LEGGINGS);
            itemGroup.add(ModItems.SNOW_GEAR_BOOTS);
        });
    }
}
