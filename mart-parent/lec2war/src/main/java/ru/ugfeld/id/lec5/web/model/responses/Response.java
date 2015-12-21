package ru.ugfeld.id.lec5.web.model.responses;

public class Response {
	
	private String status = "ok";
	
	// @formatter:off
	public void setStatus( String status ) { this.status = status; }
	public String getStatus( ) { return status; }
	// @formatter:on
}
