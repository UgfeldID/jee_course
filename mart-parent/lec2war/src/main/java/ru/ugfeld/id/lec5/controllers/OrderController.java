package ru.ugfeld.id.lec5.controllers;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import ru.ugfeld.id.lec4.model.services.ICustomerService;
import ru.ugfeld.id.lec4.model.services.IOrderService;
import ru.ugfeld.id.lec4.model.services.IProductService;
import ru.ugfeld.id.lec5.web.model.entities.Order;
import ru.ugfeld.id.lec5.web.model.requests.OrderItemRequest;
import ru.ugfeld.id.lec5.web.model.responses.OrderResponse;
import ru.ugfeld.id.lec5.web.model.responses.Response;

@Controller
@RequestMapping( "/rest/orders" )
public class OrderController extends BaseController{

	@Autowired
	@Qualifier( "OrderService" )
	private IOrderService orderService;
	
	@Autowired
	@Qualifier("CustomerService")
	private ICustomerService customerService;
	
	@Autowired
	@Qualifier( "ProductService" )
	private IProductService productService;
	
	@RequestMapping( value = "", method = RequestMethod.POST )
	public @ResponseBody OrderResponse createOrder(  @RequestParam Integer customerId, 
			@RequestBody OrderItemRequest request) throws Exception{
		
		ru.ugfeld.id.lec4.model.entities.Customer dbCustomer = customerService.findById(customerId);
		if( dbCustomer == null )
			throw new Exception(String.format("Клиент с идентификатором %d не найден", customerId));
		
		Integer productId = request.getProductId();
		ru.ugfeld.id.lec4.model.entities.Product dbProduct = productService.findById(productId);
		if( dbProduct == null )
			throw new Exception(String.format( "Товар с идентификатором %d не найден", productId ));
		
		ru.ugfeld.id.lec4.model.entities.Order dbOrder = new ru.ugfeld.id.lec4.model.entities.Order(dbCustomer);			
		
		ru.ugfeld.id.lec4.model.entities.OrderItem dbOrderItem = new ru.ugfeld.id.lec4.model.entities.OrderItem();
		dbOrderItem.setOrder(dbOrder);
		dbOrderItem.setQuantity(request.getQuantity());
		dbOrderItem.setProduct(dbProduct);
		
		
		dbOrder.setOrderItems(Arrays.asList(dbOrderItem));
		orderService.create(dbOrder);
		
		OrderResponse response = new OrderResponse();
		response.setOrder(Order.map(dbOrder));
		
		return response;		
	}
	

	
	@RequestMapping (value = "/{order_id}", method = RequestMethod.DELETE)
	public @ResponseBody Response deleteOrder ( @PathVariable( "order_id" ) Integer orderId)
			throws Exception{
		
		ru.ugfeld.id.lec4.model.entities.Order dbOrder = orderService.findById(orderId);
		if( dbOrder == null )
			throw new Exception(String.format( "Заказ с идентификатором %d не найден", orderId ));
		
		orderService.delete(orderId);
		return new Response();
	}

}
