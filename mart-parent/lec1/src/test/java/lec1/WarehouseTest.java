package lec1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.ugfeld.id.lec1.products.IProduct;
import ru.ugfeld.id.lec1.warehouses.WarehouseBase;

public class WarehouseTest {
	
	private WarehouseBase testingWarehouse;	
	private ApplicationContext context;

	@Before
	public void initialiseWarehouse(){
		context=new ClassPathXmlApplicationContext( "classpath:warehouseBeans.xml" );  
		testingWarehouse=(WarehouseBase)context.getBean("Warehouse"); //new Warehouse();
	}
	
	@Test
	public void testAddNewProduct() {
		
		IProduct product=(IProduct) context.getBean("Physics8Grade");
		double quantity=12;
		testingWarehouse.addProduct(product, quantity);
		assertTrue(testingWarehouse.getProducts().keySet().contains(product));
		assertEquals(testingWarehouse.getProducts().get(product).doubleValue(),quantity,0);
	}
	
	@Test
	public void testAddExistingProduct(){
		IProduct product=(IProduct) context.getBean("DesignPatterns");		
		double quantity=7;
		double totalQuantity=testingWarehouse.getProducts().get(product)+quantity;
		testingWarehouse.addProduct(product,quantity);
		assertTrue(testingWarehouse.getProducts().keySet().contains(product));
		assertEquals(testingWarehouse.getProducts().get(product).doubleValue(),totalQuantity,0);		
	}
	
	@Test
	public void testRemoveProduct() {		
		IProduct product=(IProduct) context.getBean("MasterAndMargarita");
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
		IProduct product=(IProduct) context.getBean("Physics8Grade");
		double quantity=testingWarehouse.removeProduct(product);
		assertEquals(quantity, 0,0);
	}

}
