package ru.ugfeld.id.lec5.web.model.entities;

public class ProductShortDescription {
	
	private Integer id;
	private String name;
	private String categoryName;
	
	public static ProductShortDescription map( ru.ugfeld.id.lec4.model.entities.Product product){
		
		ProductShortDescription newProduct = new ProductShortDescription();
		newProduct.setId(product.getId());
		newProduct.setCategoryName(product.getCategory().getName());
		newProduct.setName(product.getName());
		
		return newProduct;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
