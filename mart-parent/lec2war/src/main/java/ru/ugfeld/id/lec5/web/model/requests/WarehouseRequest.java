package ru.ugfeld.id.lec5.web.model.requests;

import ru.ugfeld.id.lec5.web.model.entities.Warehouse;

public class WarehouseRequest extends Request{

	private Warehouse warehouse;

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
}
