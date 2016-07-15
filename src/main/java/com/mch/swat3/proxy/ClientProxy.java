package com.mch.swat3.proxy;

import com.mch.swat3.init.SWATItems;
import com.mch.swat3.util.VersionHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ClientProxy extends CommonProxy{

	public void preInit(FMLPreInitializationEvent preEvent) {
		super.preInit(preEvent);		
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	public void registerRender(FMLInitializationEvent event) {
		SWATItems.registerRender(event);
	}
	
	@Override
	public void VersionCheck(PlayerTickEvent event) {
		VersionHandler.getWarning(event);
	}
	
	
}
