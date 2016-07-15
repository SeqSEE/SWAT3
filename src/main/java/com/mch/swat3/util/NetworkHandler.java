package com.mch.swat3.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkHandler {
	
	
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
