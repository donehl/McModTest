package com.donehl.mc.moreexp.block;

import com.donehl.mc.moreexp.MoreExpMod;
import com.donehl.mc.moreexp.item.ExpItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;
import java.util.Map;

/**
 * All custom blocks.
 */
public class ExpBlocks {
    public static Map<String, Block> blocks = new HashMap<String, Block>();

    public static BlockCarbon blockCarbon;

    public static void preInit(FMLPreInitializationEvent event) throws Exception {
        blockCarbon = new BlockCarbon();

        blocks.put(blockCarbon.getName(), blockCarbon);
    }

    public static void init(FMLInitializationEvent event) throws Exception {
        CraftingManager.getInstance().addRecipe(new ItemStack(ExpBlocks.blockCarbon), new Object[] {"#X#", "X#X", "#X#", '#', Blocks.coal_block, 'X', Blocks.redstone_block});
        CraftingManager.getInstance().addRecipe(new ItemStack(Blocks.coal_block, 5), new Object[]{"#", '#', ExpBlocks.blockCarbon});

        if (event.getSide() == Side.CLIENT) {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockCarbon), 0,
                new ModelResourceLocation(MoreExpMod.MODID + ":" + blockCarbon.getName(), "inventory"));
        }
    }

    public static Block getBlock(String name) {
        return blocks.get(name);
    }
}
