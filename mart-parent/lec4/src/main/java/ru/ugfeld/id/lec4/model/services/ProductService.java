package ru.ugfeld.id.lec4.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.ugfeld.id.lec4.model.entities.Product;
import ru.ugfeld.id.lec4.model.repositories.IProductRepository;

public class ProductService implements IProductService{
	
	@Autowired
	private IProductRepository productRepository;
	
	@Override
	@Transactional( rollbackFor = Exception.class )
	public Product create(Product product) {		
		return productRepository.save(product);
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Product delete(int id) throws Exception {
		Product deletedProduct = productRepository.findOne(id);
		
		if( deletedProduct == null )
			throw new Exception("Product not found");
		
		productRepository.delete(deletedProduct);
		return deletedProduct;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Product update(Product product) throws Exception {
		Product updatedProduct = productRepository.findOne(product.getId());
		
		if( updatedProduct == null )
			throw new Exception("Product not found");
		
		updatedProduct.setCategory(product.getCategory());
		updatedProduct.setDescription(product.getDescription());
		updatedProduct.setDiscount(product.getDiscount());
		updatedProduct.setName(product.getName());	
		updatedProduct.setPrice(product.getPrice());
		updatedProduct.setQuantity(product.getQuantity());
		updatedProduct.setWarehouse(product.getWarehouse());
		
		productRepository.save(updatedProduct);
		return updatedProduct;
	}

	@Override
	public Product findById(int id) {
		return productRepository.findOne(id);
	}

	@Override
	public List<Product> findByName(String name) {
		return productRepository.getProductsByName(name);
	}

}
