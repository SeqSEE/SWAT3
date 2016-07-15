package com.mch.swat3.proxy;

import com.mch.swat3.SWAT3;
import com.mch.swat3.init.SWATItems;
import com.mch.swat3.init.SWATRecipes;
import com.mch.swat3.util.ConfigHandler;
import com.mch.swat3.util.NetworkHandler;
import com.mch.swat3.util.VersionHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent preEvent) {
		ConfigHandler.config(preEvent);
		if (SWAT3.getUpdates && NetworkHandler.networkAvailable()){
			VersionHandler.check(preEvent);
		}
		register(preEvent);
	}

	private void register(FMLPreInitializationEvent preEvent) {
			SWATItems.register(preEvent);
			SWATRecipes.registerRecipes(preEvent);
	}

	public void init(FMLInitializationEvent event) {
		registerRender(event);
	}
	
	public void registerRender(FMLInitializationEvent event) {
		//Do nothing here
	}

	public void VersionCheck(PlayerTickEvent event) {
		//Do nothing here		
	}

}
