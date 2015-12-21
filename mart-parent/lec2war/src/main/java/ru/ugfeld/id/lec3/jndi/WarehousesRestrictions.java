package ru.ugfeld.id.lec3.jndi;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

public class WarehousesRestrictions implements Referenceable{
	
	public static final String REF_ADDR_REF = "ref";
	public static final String REF_ADDR_PRODUCTS_MAX_COUNT = "productsMaxCount";
	public static final String REF_ADDR_PRODUCTS_MAX_COUNT_IN_CATEGORY = "productsMaxCountInCategory";
	public static final String REF_ADDR_PRODUCTS_UPDATE_RATE = "productsUpdateRate";
	
	private String ref;
	private int productsMaxCount;
	private int productsMaxCountInCategory;
	private int productsUpdateRate;
	
	public WarehousesRestrictions(String ref, int productsMaxCount, int productsMaxCountInCategory, int productsUpdateRate) {
		this.ref=ref;
		this.productsMaxCount=productsMaxCount;
		this.productsMaxCountInCategory=productsMaxCountInCategory;
		this.productsUpdateRate=productsUpdateRate;
	}
	

	@Override
	public Reference getReference() throws NamingException {
		Reference reference=new Reference(
				this.getClass().getName( ),
				new StringRefAddr( REF_ADDR_REF, ref ),
				WarehousesRestrictionsFactory.class.getName( ),
				null
			);
		
		reference.add( new StringRefAddr( REF_ADDR_PRODUCTS_MAX_COUNT, 
				Integer.toString(productsMaxCount ) ) ); 
		
		reference.add(new StringRefAddr(REF_ADDR_PRODUCTS_MAX_COUNT_IN_CATEGORY,
				Integer.toString(productsMaxCountInCategory)));
		
		reference.add(new StringRefAddr(REF_ADDR_PRODUCTS_UPDATE_RATE,
				Integer.toString(productsUpdateRate)));
		return reference;
	}
	
	public String toString( )
	{
		return ref;
	}
	
	public String getRef() {
		return ref;
	}


	public int getProductsMaxCount() {
		return productsMaxCount;
	}


	public int getProductsMaxCountInCategory() {
		return productsMaxCountInCategory;
	}


	public int getProductsUpdateRate() {
		return productsUpdateRate;
	}

}
