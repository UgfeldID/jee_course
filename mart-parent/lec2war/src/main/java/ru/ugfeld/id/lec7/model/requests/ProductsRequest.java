package ru.ugfeld.id.lec7.model.requests;

import ru.ugfeld.id.lec7.model.entities.Warehouse;

public class ProductsRequest extends Request{

	private Warehouse warehouse;

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	
}
