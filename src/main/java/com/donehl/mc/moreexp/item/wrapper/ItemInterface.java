package com.donehl.mc.moreexp.item.wrapper;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Interface
 */
public interface ItemInterface<T extends Item> {
    String getName();

    void preInit();

    void init();

    T getItem();
}
