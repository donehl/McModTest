package com.donehl.mc.moreexp.block;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by donehl on 6/27/2015.
 */
public class BlockCarbon extends Block {
    private static final String name = "blockCarbon";

    protected BlockCarbon() {
        super(Material.rock);

        GameRegistry.registerBlock(this, name);

        setLightLevel(1.0F);
        setHardness(5.0F);
        setResistance(10.0F);
        setStepSound(soundTypePiston);
        setUnlocalizedName("blockCarbon");
        setCreativeTab(CreativeTabs.tabBlock);
    }

    public String getName() {
        return name;
    }
}
