package com.mch.swat3;

import com.mch.swat3.init.SWATItems;
import com.mch.swat3.proxy.ClientProxy;
import com.mch.swat3.proxy.CommonProxy;
import com.mch.swat3.stats.SWATAchievement;
import com.mch.swat3.util.VersionHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VER)
public class SWAT3 {

	@Instance(value = "swat3")
	public static SWAT3 instance;
	public static Configuration config;
	public static VersionHandler versionHandler;
	public static String latest;
	public static boolean isLatest = false;
	public static boolean getUpdates = true;
	public static boolean warned = false;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	private static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent) {
		proxy.preInit(preEvent);
	}

	@EventHandler
	private void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onPlayerTick(PlayerTickEvent event) {
		proxy.VersionCheck(event);
	}

	@SubscribeEvent
	public void onCraft(PlayerEvent.ItemCraftedEvent event) {

		Item item = event.crafting.getItem();
		if (item == SWATItems.STEEL_INGOT) {

			event.player.addStat(SWATAchievement.TheSWATExperience, 1);
		}
	}
	
	/*
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(KeyInputEvent event) {
		if(ClientProxy.reload.isPressed()){
			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer player = FMLClientHandler.instance().getClientPlayerEntity();
			ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);
			if (stack != null){
				stack.setItemDamage(0);
			}
		}
	}
	*/


	
	

}
