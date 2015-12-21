package ru.ugfeld.id.lec6.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.ugfeld.id.lec4.model.services.ICustomerService;
import ru.ugfeld.id.lec4.model.services.IProductService;
import ru.ugfeld.id.lec4.model.services.IWarehouseService;
import ru.ugfeld.id.lec5.web.model.entities.Order;
import ru.ugfeld.id.lec5.web.model.entities.Product;
import ru.ugfeld.id.lec5.web.model.entities.ProductShortDescription;

@Controller
@RequestMapping( "/mvc" )
public class MvcController extends BaseController{
	
	@Autowired
	@Qualifier( "WarehouseService" )
	private IWarehouseService warehouseService;
	
	@Autowired
	@Qualifier( "ProductService" )
	private IProductService productService;
	
	@Autowired
	@Qualifier( "CustomerService" )
	private ICustomerService customerService;

	@RequestMapping( value = "/warehouses/{warehouse_id}/products", method = RequestMethod.GET )
	public ModelAndView getProductsShortDescription(@PathVariable ("warehouse_id") Integer warehouseId ){
		
		ModelAndView mav = new ModelAndView( "products" );
		ru.ugfeld.id.lec4.model.entities.Warehouse dbWarehouse = warehouseService.findById(warehouseId);
		if( dbWarehouse == null ){
			return getExceptionModelAndView( String.format( "Склад с идентификатором %d не найден", warehouseId ));
		}	
		
		List<ru.ugfeld.id.lec4.model.entities.Product> dbProducts = dbWarehouse.getProducts();	
		if( (dbProducts == null) || (dbProducts.isEmpty()) ){
			return getExceptionModelAndView( String.format( "На складе с идентификатором %d нет товаров", warehouseId ));
		}
		
		List<ProductShortDescription> productShortDescriptions = new ArrayList<>();
		for (ru.ugfeld.id.lec4.model.entities.Product product : dbProducts) {
			productShortDescriptions.add(ProductShortDescription.map(product));
		}
			
		mav.addObject("products", productShortDescriptions);
		return mav;
	}
	
	@RequestMapping( value = "/warehouses/{warehouse_id}/products/{product_id}", method = RequestMethod.GET )
	public ModelAndView getProductDescription(@PathVariable ("warehouse_id") Integer warehouseId,  
			@PathVariable ("product_id") Integer productId){
		
		ModelAndView mav = new ModelAndView( "product" );
		ru.ugfeld.id.lec4.model.entities.Warehouse dbWarehouse = warehouseService.findById(warehouseId);
		if( dbWarehouse == null )
			return getExceptionModelAndView( String.format( "Склад с идентификатором %d не найден", warehouseId ));
		
		ru.ugfeld.id.lec4.model.entities.Product dbProduct = findProductById(productId, dbWarehouse.getProducts());	
		mav.addObject("product", Product.map(dbProduct));
		return mav;
	}
	
	@RequestMapping( value = "/customers/{customer_id}/orders/{order_id}", method = RequestMethod.GET )
	public ModelAndView getOrderItems( @PathVariable ("customer_id") Integer customerId,
			@PathVariable ("order_id") Integer orderId){
		
		ModelAndView mav = new ModelAndView( "order" );
		ru.ugfeld.id.lec4.model.entities.Customer dbCustomer = customerService.findById(customerId);
		if( dbCustomer == null )
			return getExceptionModelAndView( String.format( "Клиент с идентификатором %d не найден", customerId ) );
		
		ru.ugfeld.id.lec4.model.entities.Order dbOrder = findOrderById(orderId, dbCustomer.getOrders());
		if( dbOrder == null )
			return getExceptionModelAndView( String.format( "Заказ с идентификатором %d не найден", orderId ) );
		
		Order order = Order.map(dbOrder);
		
		mav.addObject("order", order);
		return mav;
	}
	
	private ru.ugfeld.id.lec4.model.entities.Product findProductById( Integer productId,
			List<ru.ugfeld.id.lec4.model.entities.Product> products) {
		
		for (ru.ugfeld.id.lec4.model.entities.Product product : products) {
			if( product.getId() == productId )
				return product;
		}
		return null;
	}	
	
	private ru.ugfeld.id.lec4.model.entities.Order findOrderById( Integer orderId,
			List<ru.ugfeld.id.lec4.model.entities.Order> orders){
		
		for (ru.ugfeld.id.lec4.model.entities.Order order : orders) {
			if( order.getId() == orderId )
				return order;
		}
		return null;
	}
}
