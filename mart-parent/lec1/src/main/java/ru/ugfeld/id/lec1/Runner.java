package ru.ugfeld.id.lec1;

public class Runner {
	private WarehouseOwner warehouseOwner;
	public WarehouseOwner getWarehouseOwner() {
		return warehouseOwner;
	}
	public void setWarehouseOwner(WarehouseOwner warehouseOwner) {
		this.warehouseOwner = warehouseOwner;
	}
	public void init(){
		System.out.println( "Using warehouse class: "+warehouseOwner.getWarehouse().getClass().getName());       
	}
}
