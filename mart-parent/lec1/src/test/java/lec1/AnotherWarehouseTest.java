package lec1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.ugfeld.id.lec1.products.IProduct;
import ru.ugfeld.id.lec1.warehouses.WarehouseBase;

public class AnotherWarehouseTest {
	private WarehouseBase testingWarehouse;	
	private ApplicationContext context;

	@Before
	public void initialiseWarehouse(){
		context=new ClassPathXmlApplicationContext( "classpath:anotherWarehouseBeans.xml" );  
		testingWarehouse=(WarehouseBase)context.getBean("AnotherWarehouse");
	}
	
	@Test
	public void testAddNewProduct() {		
		IProduct product=(IProduct) context.getBean("Puncher");
		double quantity=6;
		testingWarehouse.addProduct(product, quantity);
		assertTrue(testingWarehouse.getProducts().keySet().contains(product));
		assertEquals(testingWarehouse.getProducts().get(product).doubleValue(),quantity,0);
	}
	
	@Test
	public void testAddExistingProduct(){
		IProduct product=(IProduct) context.getBean("Rubber");		
		double quantity=9;
		double totalQuantity=testingWarehouse.getProducts().get(product)+quantity;
		testingWarehouse.addProduct(product,quantity);
		assertTrue(testingWarehouse.getProducts().keySet().contains(product));
		assertEquals(testingWarehouse.getProducts().get(product).doubleValue(),totalQuantity,0);		
	}
	
	@Test
	public void testRemoveProduct() {		
		IProduct product=(IProduct) context.getBean("Pen");
		double quantity=testingWarehouse.getProducts().get(product);
		assertEquals(testingWarehouse.removeProduct(product), quantity,0);
	}
	
	@Test	
	public void testRemoveNullProduct(){
		double quantity=testingWarehouse.removeProduct(null);
		assertEquals(quantity, 0,0);
	}
	
	@Test 
	public void testRemoveNotExistingProduct(){
		IProduct product=(IProduct) context.getBean("Puncher");
		double quantity=testingWarehouse.removeProduct(product);
		assertEquals(quantity, 0,0);
	}

}
