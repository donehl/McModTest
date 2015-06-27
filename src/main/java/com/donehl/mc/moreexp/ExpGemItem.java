package com.donehl.mc.moreexp;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Exp gem
 */
public class ExpGemItem extends Item {
    ExpGemItem() {
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("expGem");
    }
}
