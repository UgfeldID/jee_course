package ru.ugfeld.id.lec1.warehouses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.ugfeld.id.lec1.products.IProduct;

public abstract class WarehouseBase implements IWarehouse{
	private static final double PRODUCT_DEFAULT_QUANTITY=0;
	protected Map<IProduct,Double> products=null;
	
	public WarehouseBase(){
		products=new HashMap<>();
	}
	
	@Override
	public void addProduct(IProduct product, double quantity) {
		double totalQuantity=quantity;
		if(products.containsKey(product))
			totalQuantity+=products.get(product);
		products.put(product, totalQuantity);
		
	}
	
	@Override
	public double removeProduct(IProduct product) {
		if(!products.containsKey(product))
			return PRODUCT_DEFAULT_QUANTITY;
		return products.remove(product);
	}

	@Override
	public List<String> listProducts() {	
		return getProductsNames();
	}
	
	private List<String> getProductsNames(){
		List<String> productsNames=new ArrayList<>();
		for (IProduct product : products.keySet()) {
			productsNames.add(product.getName());
		}
		return productsNames;
	}
	
	public void setProducts(Map<IProduct, Double> products) {
		this.products = products;
	}

	public Map<IProduct, Double> getProducts() {
		return products;
	}
	
	
}
