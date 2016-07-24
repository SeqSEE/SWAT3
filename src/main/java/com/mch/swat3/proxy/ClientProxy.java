package com.mch.swat3.proxy;

import com.mch.swat3.client.renderer.entity.RenderEntityGrenade;
import com.mch.swat3.client.renderer.entity.RenderEntityGunSlug;
import com.mch.swat3.entity.EntityGrenade;
import com.mch.swat3.entity.EntityGunSlug;
import com.mch.swat3.init.SWATItems;
import com.mch.swat3.util.VersionHandler;

import net.minecraft.client.renderer.entity.RenderManager;
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
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new IRenderFactory<EntityGrenade>() {
            @Override public RenderEntityGrenade createRenderFor (RenderManager manager) {
                return new RenderEntityGrenade(manager);
            }
        });
		RenderingRegistry.registerEntityRenderingHandler(EntityGunSlug.class, new IRenderFactory<EntityGunSlug>() {
            @Override public RenderEntityGunSlug createRenderFor (RenderManager manager) {
                return new RenderEntityGunSlug(manager, SWATItems.SLUG);
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
