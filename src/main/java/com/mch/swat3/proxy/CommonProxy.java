package com.mch.swat3.proxy;

import com.mch.swat3.SWAT3;
import com.mch.swat3.entity.EntityConcussion;
import com.mch.swat3.entity.EntityFlashbang;
import com.mch.swat3.entity.EntityGunSlug;
import com.mch.swat3.entity.EntityPipebomb;
import com.mch.swat3.entity.EntitySmoke;
import com.mch.swat3.init.SWATItems;
import com.mch.swat3.init.SWATRecipes;
import com.mch.swat3.stats.SWATAchievement;
import com.mch.swat3.util.ConfigHandler;
import com.mch.swat3.util.KeyBindMessage;
import com.mch.swat3.util.KeyBindMessage.KeyBindMessageHandler;
import com.mch.swat3.util.NetworkHandler;
import com.mch.swat3.util.VersionHandler;

import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

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
		EntityRegistry.registerModEntity(EntityConcussion.class, "grenadeConcussion", id++, SWAT3.instance, 64, 2, true);
		EntityRegistry.registerModEntity(EntityFlashbang.class, "greandeFlashbang", id++, SWAT3.instance, 64, 2, true);
		EntityRegistry.registerModEntity(EntityPipebomb.class, "grenadePipebomb", id++, SWAT3.instance, 64, 2, true);
		EntityRegistry.registerModEntity(EntitySmoke.class, "grenadeSmoke", id++, SWAT3.instance, 64, 2, true);
		EntityRegistry.registerModEntity(EntityGunSlug.class, "gunSlug", id++, SWAT3.instance, 64, 2, true);
	
	}

	private void register(FMLPreInitializationEvent preEvent) {
			SWATItems.register(preEvent);
			SWATRecipes.registerRecipes(preEvent);
			MinecraftForge.EVENT_BUS.register(new SWAT3());
			NetworkHandler.init();
	
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
