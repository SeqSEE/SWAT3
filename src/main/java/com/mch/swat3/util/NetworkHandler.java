package com.mch.swat3.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.mch.swat3.Reference;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {
	
	public static SimpleNetworkWrapper INSTANCE;
    private static int id = 0;

    public static void init() {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.ID);

        INSTANCE.registerMessage(KeyBindMessage.KeyBindMessageHandler.class, KeyBindMessage.class, id++, Side.SERVER);
    }
	/*
	 * Returns true if can openConnection for google.com
	 * 
	 * Used for VersionHandler
	 */
    public static boolean networkAvailable(){
    	try {
    		final URL url = new URL("http://www.google.com");
    		final URLConnection con = url.openConnection();
    		con.connect();
    		return true;
    	} 
    	catch (MalformedURLException e) {
    		throw new RuntimeException(e);
    		
    	}
    	catch (IOException e) {
    		return false;
    	}	    	
    }
}

