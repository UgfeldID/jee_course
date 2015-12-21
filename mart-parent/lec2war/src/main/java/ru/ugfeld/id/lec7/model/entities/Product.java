package ru.ugfeld.id.lec7.model.entities;

import java.util.List;

public class Product {
	
	private String name;
	private String description;
	private Float price;
	private Float quantity;
	private List<String> categories;
	
	public ru.ugfeld.id.lec4.model.entities.Product create (){
		
		ru.ugfeld.id.lec4.model.entities.Product product = new ru.ugfeld.id.lec4.model.entities.Product();
		product.setId(null);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		
		return product;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Float getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
}
