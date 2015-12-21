package ru.ugfeld.id.lec4.model.services;

import java.util.List;

import ru.ugfeld.id.lec4.model.entities.Warehouse;

public interface IWarehouseService {
	public Warehouse create(Warehouse warehouse);
	public Warehouse delete (int id) throws Exception;
	public List< Warehouse > findAll( );
	public Warehouse update( Warehouse warehouse ) throws Exception;
	public Warehouse findById( int id );
	public Warehouse getOrCreateByName( String name );
}
