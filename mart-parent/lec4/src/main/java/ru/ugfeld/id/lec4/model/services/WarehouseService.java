package ru.ugfeld.id.lec4.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.ugfeld.id.lec4.model.entities.Warehouse;
import ru.ugfeld.id.lec4.model.repositories.IWarehouseRepository;

public class WarehouseService implements IWarehouseService{
	
	@Autowired
	private IWarehouseRepository warehouseRepository;

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Warehouse create(Warehouse warehouse) {
		return warehouseRepository.save(warehouse);
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Warehouse delete(int id) throws Exception {
		Warehouse deletedWarehouse = warehouseRepository.findOne(id);
		
		if( deletedWarehouse == null)
			throw new Exception("Warehouse not found");
		
		warehouseRepository.delete(deletedWarehouse);
		return deletedWarehouse;
	}

	@Override
	public List<Warehouse> findAll() {
		return warehouseRepository.findAll();
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Warehouse update(Warehouse warehouse) throws Exception {
		Warehouse updatedWarehouse = warehouseRepository.findOne(warehouse.getId());
		
		if( updatedWarehouse == null)
			throw new Exception("Warehouse not found");
		
		updatedWarehouse.setCapacity(warehouse.getCapacity());	
		updatedWarehouse.setName(warehouse.getName());		
		
		warehouseRepository.save(updatedWarehouse);
		return updatedWarehouse;
		
	}

	@Override
	public Warehouse findById(int id) {
		return warehouseRepository.findOne(id);
	}

	@Override
	public Warehouse getOrCreateByName(String name) {
		
		List<Warehouse> warehouses = warehouseRepository.getWarehousesByName(name);
		if( (warehouses == null) || (warehouses.isEmpty()))
			return create(new Warehouse(name, 0));
		
		return warehouses.get(0);		
	}
}
