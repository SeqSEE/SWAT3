package com.mch.swat3.proxy;

import com.mch.swat3.SWAT3;
import com.mch.swat3.entity.EntityGrenade;
import com.mch.swat3.entity.EntityGunSlug;
import com.mch.swat3.init.SWATItems;
import com.mch.swat3.init.SWATRecipes;
import com.mch.swat3.stats.SWATAchievement;
import com.mch.swat3.util.ConfigHandler;
import com.mch.swat3.util.NetworkHandler;
import com.mch.swat3.util.VersionHandler;

import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent preEvent) {
		ConfigHandler.config(preEvent);
		if (SWAT3.getUpdates && NetworkHandler.networkAvailable()){
			VersionHandler.check(preEvent);
		}
		register(preEvent);
		registerEntities(preEvent);
	}

	public void registerEntities(FMLPreInitializationEvent preEvent) {
		int id = 0;
		EntityRegistry.registerModEntity(EntityGrenade.class, "grenadeConcussion", id++, SWAT3.instance, 64, 2, true);
		EntityRegistry.registerModEntity(EntityGrenade.class, "greandeFlashbang", id++, SWAT3.instance, 64, 2, true);
		EntityRegistry.registerModEntity(EntityGrenade.class, "grenadePipebomb", id++, SWAT3.instance, 64, 2, true);
		EntityRegistry.registerModEntity(EntityGrenade.class, "grenadeSmoke", id++, SWAT3.instance, 64, 2, true);
		EntityRegistry.registerModEntity(EntityGunSlug.class, "gunSlug", id++, SWAT3.instance, 64, 2, true);
	
	}

	private void register(FMLPreInitializationEvent preEvent) {
			SWATItems.register(preEvent);
			SWATRecipes.registerRecipes(preEvent);
			MinecraftForge.EVENT_BUS.register(new SWAT3());
	}

	public void init(FMLInitializationEvent event) {
		registerRender(event);
		AchievementPage.registerAchievementPage(SWATAchievement.SWATAchievePage);
	}
	
	public void registerRender(FMLInitializationEvent event) {
		//Do nothing here
	}

	public void VersionCheck(PlayerTickEvent event) {
		//Do nothing here		
	}

}
