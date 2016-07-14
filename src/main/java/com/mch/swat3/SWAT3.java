package com.mch.swat3;

import com.mch.swat3.proxy.CommonProxy;
import com.mch.swat3.util.VersionHandler;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
    
}