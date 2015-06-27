package com.donehl.mc.moreexp;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = MoreExpMod.MODID, version = MoreExpMod.VERSION)
public class MoreExpMod
{
    public static final String MODID = "moreexp";
    public static final String VERSION = "0.1";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());

        MinecraftForge.EVENT_BUS.register(new ExpEventHandler());
    }

    public class ExpEventHandler {
        @SubscribeEvent
        public void onExpDrop(LivingExperienceDropEvent event) {
            int exp = event.getDroppedExperience();
            event.setDroppedExperience(exp * 10);
        }

        @SubscribeEvent
        public void onExpPick(PlayerPickupXpEvent event) {
            int exp = event.orb.getXpValue();
            EntityPlayer player = event.entityPlayer;
            player.heal(exp);
        }
    }
}
