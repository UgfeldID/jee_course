package ru.ugfeld.id.lec1.products;

import ru.ugfeld.id.lec1.categories.ICategory;

public class Product implements IProduct{
	private String name;
	private ICategory category;
	private double price;
	
	public Product(String name, ICategory category, double price) {
		this.name=name;
		this.category=category;
		this.price=price;
	}
	public Product() {
		
	}

	
	public void setName(String name) {
		this.name = name;
	}


	public void setCategory(ICategory category) {
		this.category = category;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getName() {		
		return name;
	}

	
	public ICategory getCategory() {
		return category;
	}

	
	public double getPrice() {
		return price;
	}

}
