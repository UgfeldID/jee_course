package ru.ugfeld.id.lec3.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;



public class WarehousesRestrictionsFactory implements ObjectFactory{

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)
			throws Exception {
		if( obj instanceof Reference){
			Reference ref = ( Reference )obj;
			if ( ref.getClassName( ).equals( WarehousesRestrictions.class.getName( ) ) )  
			{
				RefAddr addrRef = ref.get( WarehousesRestrictions.REF_ADDR_REF );
				RefAddr addrProductsMaxCount = ref.get( WarehousesRestrictions.REF_ADDR_PRODUCTS_MAX_COUNT);
				RefAddr addrProductsMaxCountInCategory=ref.get(WarehousesRestrictions.REF_ADDR_PRODUCTS_MAX_COUNT_IN_CATEGORY);
				RefAddr addrProductsUpdateRate=ref.get(WarehousesRestrictions.REF_ADDR_PRODUCTS_UPDATE_RATE);
				
				if ( null != addrRef && null != addrProductsMaxCount && null !=addrProductsMaxCountInCategory && null != addrProductsUpdateRate )
				{
					return new WarehousesRestrictions( 
						addrRef.getContent( ).toString( ), 
						Integer.parseInt( addrProductsMaxCount.getContent( ).toString( ) ),
						Integer.parseInt( addrProductsMaxCountInCategory.getContent( ).toString( ) ),
						Integer.parseInt( addrProductsUpdateRate.getContent( ).toString( ) ) 
					);
				}
			}
		}
		return null;
	}

}
