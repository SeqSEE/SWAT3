package com.mch.swat3.util;

import com.mch.swat3.SWAT3;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	
	public static void config(FMLPreInitializationEvent preEvent) {
		SWAT3.config = new Configuration(preEvent.getSuggestedConfigurationFile());
		SWAT3.config.load();
    	boolean updates = SWAT3.config.getBoolean("Check for updates:", "Updates", true, "Whether to check for an updates.");
    	SWAT3.getUpdates = updates;
    	SWAT3.config.save();
     	MinecraftForge.EVENT_BUS.register(SWAT3.instance);
     	sync();	
	}

	public static void sync() {
			if (SWAT3.config.hasChanged()) {
				SWAT3.config.save();
			}
		}
}
