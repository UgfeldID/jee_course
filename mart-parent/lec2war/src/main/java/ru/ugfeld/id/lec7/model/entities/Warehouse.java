package ru.ugfeld.id.lec7.model.entities;

import java.net.InetAddress;

public class Warehouse {
	
	private static final String UNKNOWN_HOST_NAME = "UNKNOWN";
	private String hostname;
		
	public Warehouse() {
	
		try{
			hostname = InetAddress.getLocalHost( ).getHostName( );
		}		
		catch ( Exception exc ){
			hostname = UNKNOWN_HOST_NAME;
		}
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}	
	
		
}
