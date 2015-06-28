package com.donehl.mc.moreexp.item;


import com.donehl.mc.moreexp.item.wrapper.ItemInterface;
import com.donehl.mc.moreexp.item.wrapper.ItemWrapper;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * Static resources for all custom item.
 */
public class ExpItems {

    private static Map<String, ItemWrapper> items = new HashMap<String, ItemWrapper>();

    public static ItemExpGem expGem;
    public static ItemCarbonAxe carbonAxe;

    public static Item getItem(String name) {
        return items.get(name).getItem();
    }

    public static void preInit(FMLPreInitializationEvent event) throws Exception {
        expGem = new ItemExpGem();
        carbonAxe = new ItemCarbonAxe();
        items.put(expGem.getName(), new ItemWrapper<ItemExpGem>(expGem));
        items.put(carbonAxe.getName(), new ItemWrapper<ItemCarbonAxe>(carbonAxe));

        for (ItemWrapper item : items.values()) {
            item.preInit(event);
        }
    }

    public static void init(FMLInitializationEvent event) throws Exception {
        for (ItemWrapper item : items.values()) {
            item.init(event);
        }
    }
}