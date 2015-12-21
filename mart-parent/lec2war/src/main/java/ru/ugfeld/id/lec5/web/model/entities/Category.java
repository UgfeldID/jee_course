package ru.ugfeld.id.lec5.web.model.entities;

import ru.ugfeld.id.lec5.utils.Comparer;

public class Category {

	private Integer id;
	private String name;
	
	public static Category map( ru.ugfeld.id.lec4.model.entities.Category category) {
		
		Category newCategory = new Category();
		newCategory.setId(category.getId());
		newCategory.setName(category.getName());
		
		return newCategory;
	}
	
	public ru.ugfeld.id.lec4.model.entities.Category createDbEntity(){
		
		ru.ugfeld.id.lec4.model.entities.Category category = new ru.ugfeld.id.lec4.model.entities.Category();
		category.setName(name);
		
		return category;
	}
	
	public void updateDbEntity( ru.ugfeld.id.lec4.model.entities.Category category) {
		
		if( !Comparer.equals(name, category.getName()) )
			category.setName(name);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
