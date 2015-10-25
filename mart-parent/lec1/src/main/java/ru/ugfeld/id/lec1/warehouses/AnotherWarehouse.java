package ru.ugfeld.id.lec1.warehouses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ru.ugfeld.id.lec1.products.IProduct;

public class AnotherWarehouse extends WarehouseBase{
	public AnotherWarehouse(){
		super();
		products=new LinkedHashMap<>();
	}

}
