package com.donehl.mc.moreexp.items;

import com.donehl.mc.moreexp.MoreExpMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Wrapper for item to make creating item more convenience.
 */
public abstract class ItemWrapper extends Item {

    private String name;

    protected ItemWrapper(String name) {
        this.name = name;

        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
    }

    public void init(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            renderItem.getItemModelMesher().register(getInstance(), 0,
                new ModelResourceLocation(MoreExpMod.MODID + ":" + getName(), "inventory"));
        }
        this.init();
    }

    protected void init() {}

    public ItemWrapper getInstance() {
        return ExpItems.getItem(name);
    }

    public String getName() {
        return name;
    }
}
