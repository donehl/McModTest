package com.donehl.mc.moreexp;

import com.donehl.mc.moreexp.items.ExpGemItem;
import com.donehl.mc.moreexp.items.ExpItems;
import com.donehl.mc.moreexp.items.ItemWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = MoreExpMod.MODID, version = MoreExpMod.VERSION)
public class MoreExpMod
{
    public static final String MODID = "moreexp";
    public static final String VERSION = "0.1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) throws Exception {
        ExpItems.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) throws Exception
    {
        ExpItems.init(event);
        MinecraftForge.EVENT_BUS.register(new ExpEventHandler());
    }

    public class ExpEventHandler {
        @SubscribeEvent
        public void onExpDrop(LivingExperienceDropEvent event) {
            int exp = event.getDroppedExperience();
            EntityPlayer player = event.getAttackingPlayer();
            player.dropItem(ExpItems.getItem("expGem"), exp);
        }

        @SubscribeEvent
        public void onExpPick(PlayerPickupXpEvent event) {
            int exp = event.orb.getXpValue();
            EntityPlayer player = event.entityPlayer;
            player.heal(exp);
        }
    }
}
