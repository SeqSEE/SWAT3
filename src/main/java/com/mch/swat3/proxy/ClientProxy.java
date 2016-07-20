package com.mch.swat3.proxy;

import com.mch.swat3.client.renderer.RenderEntityFlashbang;
import com.mch.swat3.entity.EntityFlashbang;
import com.mch.swat3.init.SWATItems;
import com.mch.swat3.util.VersionHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ClientProxy extends CommonProxy{

	



	public void preInit(FMLPreInitializationEvent preEvent) {
		super.preInit(preEvent);
	}
	
	
	@Override
	public void registerEntities(FMLPreInitializationEvent preEvent) {
		super.registerEntities(preEvent);
		RenderingRegistry.registerEntityRenderingHandler(EntityFlashbang.class, new IRenderFactory<EntityFlashbang>() {
            @Override public Render<EntityFlashbang> createRenderFor (RenderManager manager) {
                return new RenderEntityFlashbang(manager, SWATItems.GRENADE_FLASHBANG_ACTIVE);
            }
        });
		
	}	

	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	@Override
	public void registerRender(FMLInitializationEvent event) {
		SWATItems.registerRender(event);
	}
	
	@Override
	public void VersionCheck(PlayerTickEvent event) {
		VersionHandler.getWarning(event);
	}
	
	
}
