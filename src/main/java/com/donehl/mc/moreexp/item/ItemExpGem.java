package com.donehl.mc.moreexp.item;

import com.donehl.mc.moreexp.item.wrapper.ItemInterface;
import com.donehl.mc.moreexp.item.wrapper.ItemWrapper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Exp gem
 */
public class ItemExpGem extends Item implements ItemInterface<ItemExpGem> {
    public ItemExpGem() {
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public String getName() {
        return "expGem";
    }

    @Override
    public void preInit() {

    }

    @Override
    public void init() {

    }

    @Override
    public ItemExpGem getItem() {
        return this;
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if (!playerIn.capabilities.isCreativeMode)
        {
            --stack.stackSize;
        }

        if (!worldIn.isRemote)
        {
            playerIn.addExperience(10);
        }

        return stack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 50;
    }

    /**
     * returns the action that specifies what animation to play when the item is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.EAT;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }
}
