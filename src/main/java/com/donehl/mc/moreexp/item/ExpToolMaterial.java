package com.donehl.mc.moreexp.item;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Tool material hack.
 */
public class ExpToolMaterial {
    public static Item.ToolMaterial CARBON;

    static {
        CARBON = EnumHelper.addToolMaterial("EXP_CARBON", 3, 100, 8.0F, 12, 20);
    }
}
