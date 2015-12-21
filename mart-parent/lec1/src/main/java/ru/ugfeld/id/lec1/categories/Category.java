package ru.ugfeld.id.lec1.categories;

public class Category implements ICategory{
	private String name;
	
	public Category() {	}
	
	public Category(String name) {
		this.name=name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {		
		return name;
	}

}
