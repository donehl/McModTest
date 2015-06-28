package com.donehl.mc.moreexp.item.wrapper;

import com.donehl.mc.moreexp.MoreExpMod;
import com.donehl.mc.moreexp.item.ExpItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Wrapper for item to make creating item more convenience.
 */
public class ItemWrapper<T extends Item & ItemInterface<T>> {

    private T item;

    public ItemWrapper(T item) {
        this.item = item;
    }

    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerItem(item, item.getName());
        item.setUnlocalizedName(item.getName());
        item.preInit();
    }

    public void init(FMLInitializationEvent event) {
        if (event.getSide() == Side.CLIENT) {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            renderItem.getItemModelMesher().register(getItem(), 0,
                new ModelResourceLocation(MoreExpMod.MODID + ":" + getName(), "inventory"));
        }
        item.init();
    }

    public T getItem() {
        return item;
    }

    public String getName() {
        return item.getName();
    }
}
