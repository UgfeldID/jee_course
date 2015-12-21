package ru.ugfeld.id.lec5.web.model.entities;

import ru.ugfeld.id.lec4.model.entities.Category;
import ru.ugfeld.id.lec5.utils.Comparer;

public class Product {
	
	private Integer id;
	private String name;
	private String description;
	private Float price;
	private Float quantity;
	private Float discount;
	private String categoryName;
	
	public static Product map ( ru.ugfeld.id.lec4.model.entities.Product product){
		
		Product newProduct = new Product();
		newProduct.setId(product.getId());
		newProduct.setDescription(product.getDescription());
		newProduct.setName(product.getName());
		newProduct.setPrice(product.getPrice());
		newProduct.setQuantity(product.getQuantity());
		newProduct.setDiscount(product.getDiscount());
		newProduct.setCategoryName(product.getCategory().getName());
		
		return newProduct;
	}
	
	public ru.ugfeld.id.lec4.model.entities.Product createDbEntity(){
		
		ru.ugfeld.id.lec4.model.entities.Product product = new ru.ugfeld.id.lec4.model.entities.Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setDiscount(discount);
	
		return product;
	}
	
	public void updateDbEntity ( ru.ugfeld.id.lec4.model.entities.Product product){
		
		if( !Comparer.equals(name, product.getName()) )
			product.setName(name);
		
		if( !Comparer.equals(description, product.getDescription()) )
			product.setDescription(description);
		
		if( !Comparer.equals(price, product.getPrice()) )
			product.setPrice(price);
		
		if( !Comparer.equals(quantity, product.getQuantity()) )
			product.setQuantity(quantity);
		
		if(	!Comparer.equals(discount, product.getDiscount()) )
			product.setDiscount(discount);	
	
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
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
