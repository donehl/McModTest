package com.donehl.mc.moreexp.items;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Static resources for all custom items.
 */
public class ExpItems {

    private static Map<String, ItemWrapper> items = new HashMap<String, ItemWrapper>();

    public static ExpGemItem expGem = new ExpGemItem();

    public static ItemWrapper getItem(String name) {
        return items.get(name);
    }

    public static void preInit(FMLPreInitializationEvent event) throws Exception {
        items.put(expGem.getName(), expGem);
    }

    public static void init(FMLInitializationEvent event) throws Exception {
        for (ItemWrapper item : items.values()) {
            item.init(event);
        }
    }
}
