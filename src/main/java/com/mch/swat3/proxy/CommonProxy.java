package com.mch.swat3.proxy;

import com.mch.swat3.init.SWATItems;
import com.mch.swat3.init.SWATRecipes;
import com.mch.swat3.util.VersionHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent preEvent) {
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

}
