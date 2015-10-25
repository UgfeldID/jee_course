package ru.ugfeld.id.lec1;


import ru.ugfeld.id.lec1.warehouses.IWarehouse;

public class WarehouseOwner {
	private IWarehouse warehouse;

	public IWarehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(IWarehouse warehouse) {
		this.warehouse = warehouse;
	}
	
}
