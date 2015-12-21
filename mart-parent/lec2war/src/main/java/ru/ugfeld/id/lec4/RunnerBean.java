package ru.ugfeld.id.lec4;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ugfeld.id.lec4.model.entities.*;
import ru.ugfeld.id.lec4.model.services.*;


public class RunnerBean {
	
	private static final Logger log = LoggerFactory.getLogger( RunnerBean.class );
	
	private ICustomerService customerService;
	private IOrderService orderService;
	private IOrderItemService orderItemService;
	private IProductService productService;
	private IWarehouseService warehouseService;
	private ICategoryService categoryService;
	
	public void init( )
	{
		try{			
			createAndFillBooksWarehouse();			
			createAndFillStationeryWarehouse();
			createCustomerAndOrder();
		}
		catch ( Exception exc )
		{
			log.error( "Fill db error", exc );
		}
	}
	
	private void createAndFillBooksWarehouse() throws Exception{
		Warehouse warehouse = new Warehouse("Склад книг", 5000);
		warehouseService.create(warehouse);
		
		Category category = new Category("Книга");
		categoryService.create(category);
		
		Product product = new Product("Колобок", "Сказка", 100.f, 
				300.f, 0.f, category, warehouse);		
		productService.create(product);
		
		product = new Product("Паттерны проектирования", "Образование", 800.f, 
				150.f, 0.f, category, warehouse);		
		productService.create(product);
		
		product = new Product("Мастер и Маргарита", "Роман", 500.f, 
				140.f, 5.f, category, warehouse);		
		productService.create(product);
		
		product = new Product("Физика 8 класс", "Образование", 300.f, 
				310.f, 10.f, category, warehouse);		
		productService.create(product);		
	}
	
	private void createAndFillStationeryWarehouse() throws Exception{
		
		Warehouse warehouse = new Warehouse("Склад канцелярских товаров", 10000);
		warehouseService.create(warehouse);
		
		Category category = new Category("Канцтовары");
		categoryService.create(category);
		
		Product product = new Product("Карандаш", "Карандаш зеленый средней жесткости", 10.f, 
				1000.f, 0.f, category, warehouse);		
		productService.create(product);	
		
		product = new Product("Ручка", "Авторучка черная гелевая", 15.f, 
				800.f, 0.f, category, warehouse);		
		productService.create(product);	
		
		product = new Product("Ластик", "Ластик белый", 5.f, 
				500.f, 0.f, category, warehouse);		
		productService.create(product);	
		
		product = new Product("Дырокол", "Дырокол Черный", 50.f, 
				200.f, 5.f, category, warehouse);		
		productService.create(product);			
	}	

	private void createCustomerAndOrder() throws Exception{
		Customer customer = new Customer("Иван");
		customerService.create(customer);
		
		Order order = new Order(customer);
		orderService.create(order);
		
		createItem("физика 8 класс", "18 шт.", order);
		createItem("ручка", "18 шт.", order);
		createItem("ластик", "18 шт.", order);
	}
	
	private void createItem (String productName, String productCount, Order order) throws Exception{
		
		List <Product> products = productService.findByName(productName);
		if( (products == null) || (products.isEmpty()) )
			throw new Exception( String.format("Товар с названием %s не найден", productName) );
		
		OrderItem orderItem = new OrderItem(productCount, products.get(0), order);	
		orderItemService.create(orderItem);
	}
	
	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public IOrderItemService getOrderItemService() {
		return orderItemService;
	}

	public void setOrderItemService(IOrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public IWarehouseService getWarehouseService() {
		return warehouseService;
	}

	public void setWarehouseService(IWarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	public ICategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
