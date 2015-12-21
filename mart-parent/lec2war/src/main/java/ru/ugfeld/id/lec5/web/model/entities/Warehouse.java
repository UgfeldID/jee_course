package ru.ugfeld.id.lec5.web.model.entities;

import ru.ugfeld.id.lec5.utils.Comparer;

public class Warehouse {
	
	private Integer id;
	private String name;
	private Integer capacity;
	
	public static Warehouse map( ru.ugfeld.id.lec4.model.entities.Warehouse warehouse) {
		
		Warehouse newWarehouse = new Warehouse();
		newWarehouse.setId(warehouse.getId());
		newWarehouse.setName(warehouse.getName());
		newWarehouse.setCapacity(warehouse.getCapacity());
		
		return newWarehouse;
	}
	
	public ru.ugfeld.id.lec4.model.entities.Warehouse createDbEntity(){
		
		ru.ugfeld.id.lec4.model.entities.Warehouse warehouse = new ru.ugfeld.id.lec4.model.entities.Warehouse();
		warehouse.setName(name);
		warehouse.setCapacity(capacity);
		
		return warehouse;
	}
	
	public void updateDbEntity( ru.ugfeld.id.lec4.model.entities.Warehouse warehouse){
		
		if( !Comparer.equals(name, warehouse.getName()) )
			warehouse.setName(name);
		
		if(	!Comparer.equals(capacity, warehouse.getCapacity()) )
			warehouse.setCapacity(capacity);
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
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
}
