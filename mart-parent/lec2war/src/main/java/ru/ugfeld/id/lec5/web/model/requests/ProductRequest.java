package ru.ugfeld.id.lec5.web.model.requests;

import ru.ugfeld.id.lec5.web.model.entities.Category;
import ru.ugfeld.id.lec5.web.model.entities.Product;

public class ProductRequest extends Request {

	private Product product;
	private Category category;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
