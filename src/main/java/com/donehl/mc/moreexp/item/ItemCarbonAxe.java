package com.donehl.mc.moreexp.item;

import com.donehl.mc.moreexp.block.ExpBlocks;
import com.donehl.mc.moreexp.item.wrapper.ItemInterface;
import com.donehl.mc.moreexp.item.wrapper.ItemWrapper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Carbon axe
 */
public class ItemCarbonAxe extends ItemAxe implements ItemInterface<ItemCarbonAxe> {
    protected ItemCarbonAxe() {
        super(ExpToolMaterial.CARBON);
        setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public String getName() {
        return "carbonAxe";
    }

    @Override
    public void preInit() {
    }

    @Override
    public void init() {
        GameRegistry.addRecipe(new ItemStack(this, 1), new Object[] {"##", "#I", " I", '#', ExpBlocks.blockCarbon, 'I', Items.stick});
    }

    @Override
    public ItemCarbonAxe getItem() {
        return this;
    }
}
