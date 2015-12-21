package ru.ugfeld.id.lec1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger log = LoggerFactory.getLogger(App.class );
    public static void main( String[] args )
    {
    	ApplicationContext ctx=new ClassPathXmlApplicationContext( "classpath:beans.xml" );    
    	WarehouseOwner warehouseOwner=(WarehouseOwner)ctx.getBean("WarehouseOwner");    	
    	
    	System.out.println( "Using warehouse class: "+warehouseOwner.getWarehouse().getClass().getName()); 
    	log.info("Using warehouse class: "+warehouseOwner.getWarehouse().getClass().getName());
    }
}
