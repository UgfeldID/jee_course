package ru.ugfeld.id.lec3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.ugfeld.id.lec3.jndi.WarehousesRestrictions;

public class RunnerBean {
	private static final Logger log = LoggerFactory.getLogger( RunnerBean.class );
	
	private WarehousesRestrictions warehousesRestrictions;

	public WarehousesRestrictions getWarehousesRestrictions() {
		return warehousesRestrictions;
	}

	public void setWarehousesRestrictions(WarehousesRestrictions warehousesRestrictions) {
		this.warehousesRestrictions = warehousesRestrictions;
	}
	
	public void init( )
	{
		log.info(String.format("Reference %s describes max products count as %d, "
				+ "max products count in single category as %d, "
				+ "products update rate as %d in warehouse ",warehousesRestrictions.getRef(),
				warehousesRestrictions.getProductsMaxCount(),warehousesRestrictions.getProductsMaxCountInCategory(),
				warehousesRestrictions.getProductsUpdateRate()));
	}

}
