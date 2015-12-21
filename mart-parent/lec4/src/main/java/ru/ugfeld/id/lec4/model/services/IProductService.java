package ru.ugfeld.id.lec4.model.services;

import java.util.List;

import ru.ugfeld.id.lec4.model.entities.Product;

public interface IProductService {
	public Product create(Product product);
	public Product delete (int id) throws Exception;
	public List< Product > findAll( );
	public Product update( Product product ) throws Exception;
	public Product findById( int id );
	public List< Product > findByName( String name );
}
