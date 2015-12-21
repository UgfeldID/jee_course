package ru.ugfeld.id.lec7.model.responses;

import java.util.ArrayList;
import java.util.List;

import ru.ugfeld.id.lec7.model.entities.Product;

public class ProductsResponse extends Response{

	List<Product> products = new ArrayList<>();

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}	
}
