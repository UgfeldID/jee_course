package ru.ugfeld.id.lec5.web.model.responses;

public class IdResponse extends Response{

	private Integer id;
	
	// @formatter:off
	public void setId( Integer id ) { this.id = id; }
	public Integer getId( ) { return id; }
	// @formatter:on
}
