package com.mch.swat3.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.mch.swat3.Reference;
import com.mch.swat3.SWAT3;

import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class VersionHandler implements Runnable{

	 private static String latestRev = null;

	public static void check(FMLPreInitializationEvent preEvent) {
	    	if (SWAT3.getUpdates == true){
	    		SWAT3.versionHandler = new VersionHandler();
	        	Thread versionCheckThread = new Thread(SWAT3.versionHandler);
	        	versionCheckThread.start();
	        }
	    }
	
	
	@Override
	public void run() {
		InputStream versionFile = null;
    	try{
    		versionFile = new URL("https://raw.githubusercontent.com/SeqSEE/SWAT3/master/latest-1.10.2").openStream();
    	} 
    	catch (MalformedURLException e) {
    		e.printStackTrace();
    	} 
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    	try {
    		latestRev = IOUtils.readLines(versionFile).get(0);
    	} 
    	catch (IOException e) {
    			e.printStackTrace();
    	} 
    	finally {
    		IOUtils.closeQuietly(versionFile);
    	}
    	SWAT3.latest = latestRev;
    	SWAT3.isLatest = Reference.VER.equals(latestRev);
    	String output = SWAT3.isLatest == true ? "Recommended " + Reference.NAME + " version:" + latestRev : "Recommended " + Reference.NAME + " version:" + latestRev + " You are running a different version!";
    	System.out.println(output);        
    }
    
    public boolean isLatestVersion() {
     return SWAT3.isLatest;
    }
    
    public String getLatestVersion() {
     return latestRev;
    }
    
    public static boolean getWarning(PlayerTickEvent event) {
    	boolean warned = SWAT3.warned;
    	if (!warned && event.player.worldObj.isRemote && SWAT3.isLatest == false && SWAT3.getUpdates != false){
            TextComponentString update = new TextComponentString("[Update to " + latestRev + "]");
            Style link = new Style();
            link.setBold(true);
           	link.setUnderlined(true);
           	link.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString("Click here to visit the Curse page.")));
           	link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://mods.curse.com/mc-mods/minecraft/247416-swat3"));
            update.setStyle(link);
            event.player.addChatMessage(new TextComponentString("Your SWAT3 Mod is not the recommended version!"));
            event.player.addChatMessage(update);
            SWAT3.warned = true;
    	}
    	return warned;
    }

}
