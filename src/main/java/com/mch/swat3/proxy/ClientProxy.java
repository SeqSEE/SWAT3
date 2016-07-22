package com.mch.swat3.proxy;

import com.mch.swat3.client.renderer.entity.RenderEntityConcussion;
import com.mch.swat3.client.renderer.entity.RenderEntityFlashbang;
import com.mch.swat3.client.renderer.entity.RenderEntityGunSlug;
import com.mch.swat3.client.renderer.entity.RenderEntityPipebomb;
import com.mch.swat3.client.renderer.entity.RenderEntitySmoke;
import com.mch.swat3.entity.EntityConcussion;
import com.mch.swat3.entity.EntityFlashbang;
import com.mch.swat3.entity.EntityGunSlug;
import com.mch.swat3.entity.EntityPipebomb;
import com.mch.swat3.entity.EntitySmoke;
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
		RenderingRegistry.registerEntityRenderingHandler(EntityConcussion.class, new IRenderFactory<EntityConcussion>() {
            @Override public RenderEntityConcussion createRenderFor (RenderManager manager) {
                return new RenderEntityConcussion(manager, SWATItems.GRENADE_CONCUSSION_ACTIVE);
            }
        });
		RenderingRegistry.registerEntityRenderingHandler(EntityFlashbang.class, new IRenderFactory<EntityFlashbang>() {
            @Override public RenderEntityFlashbang createRenderFor (RenderManager manager) {
                return new RenderEntityFlashbang(manager, SWATItems.GRENADE_FLASHBANG_ACTIVE);
            }
        });
		RenderingRegistry.registerEntityRenderingHandler(EntityPipebomb.class, new IRenderFactory<EntityPipebomb>() {
            @Override public RenderEntityPipebomb createRenderFor (RenderManager manager) {
                return new RenderEntityPipebomb(manager, SWATItems.PIPE_BOMB_ACTIVE);
            }
        });
		RenderingRegistry.registerEntityRenderingHandler(EntitySmoke.class, new IRenderFactory<EntitySmoke>() {
            @Override public RenderEntitySmoke createRenderFor (RenderManager manager) {
                return new RenderEntitySmoke(manager, SWATItems.GRENADE_SMOKE_ACTIVE);
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
