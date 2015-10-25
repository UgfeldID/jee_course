package ru.ugfeld.id.lec1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.ugfeld.id.lec1.categories.Category;
import ru.ugfeld.id.lec1.products.IProduct;
import ru.ugfeld.id.lec1.products.Product;
import ru.ugfeld.id.lec1.warehouses.IWarehouse;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx=new ClassPathXmlApplicationContext( "classpath:warehouseOwnerBeans.xml" );    
    	WarehouseOwner warehouseOwner=(WarehouseOwner)ctx.getBean("WarehouseOwner");    	
    	
    	System.out.println( "Using warehouse class: "+warehouseOwner.getWarehouse().getClass().getName());       
    }
}
