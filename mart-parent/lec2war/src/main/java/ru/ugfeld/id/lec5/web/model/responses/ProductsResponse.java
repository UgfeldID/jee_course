package ru.ugfeld.id.lec5.web.model.responses;

import java.util.ArrayList;
import java.util.List;

import ru.ugfeld.id.lec5.web.model.entities.Product;

public class ProductsResponse extends Response{

	private List<Product> products = new ArrayList<>();

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	} 
}
