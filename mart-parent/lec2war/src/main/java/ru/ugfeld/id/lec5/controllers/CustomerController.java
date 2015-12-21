package ru.ugfeld.id.lec5.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import ru.ugfeld.id.lec4.model.services.ICustomerService;
import ru.ugfeld.id.lec4.model.services.IOrderService;
import ru.ugfeld.id.lec5.web.model.entities.Order;
import ru.ugfeld.id.lec5.web.model.responses.OrdersResponse;
import ru.ugfeld.id.lec5.web.model.responses.Response;

@Controller
@RequestMapping( "/rest/customers" )
public class CustomerController extends BaseController{

	@Autowired
	@Qualifier("CustomerService")
	private ICustomerService customerService;
	
	@Autowired
	@Qualifier( "OrderService" )
	private IOrderService orderService;
	
	@RequestMapping( value = "/{cusromer_id}/orders", method = RequestMethod.GET )
	public @ResponseBody OrdersResponse getOrders
		(  @PathVariable( "cusromer_id" ) Integer customerId) throws Exception{
		
		ru.ugfeld.id.lec4.model.entities.Customer dbCustomer = customerService.findById(customerId);
		if( dbCustomer == null )
			throw new Exception(String.format("Клиент с идентификатором %d не найден", customerId));
		
		OrdersResponse ordersResponse = new OrdersResponse();
		for (ru.ugfeld.id.lec4.model.entities.Order dbOrder : dbCustomer.getOrders()) {
			Order order = Order.map(dbOrder);
			
			if( order != null )
				ordersResponse.getOrders().add(order);
		}
		
		return ordersResponse;
	}	
	
	@RequestMapping( value = "/{cusromer_id}/orders/{order_id}", method = RequestMethod.DELETE )
	public @ResponseBody Response deleteOrder( @PathVariable ("cusromer_id") Integer customerId,
			@PathVariable ("order_id") Integer orderId ) throws Exception{
		
		ru.ugfeld.id.lec4.model.entities.Customer dbCustomer = customerService.findById(customerId);
		if( dbCustomer == null )
			throw new Exception(String.format("Клиент с идентификатором %d не найден", customerId));
		
		ru.ugfeld.id.lec4.model.entities.Order dbOrder = findOrderById( orderId, dbCustomer.getOrders());
		if( dbOrder == null )
			throw new Exception(String.format( "Заказ с идентификатором %d не найден", orderId ));
		
		orderService.delete(orderId);
		return new Response();
	}

	private ru.ugfeld.id.lec4.model.entities.Order findOrderById(Integer orderId,
			List<ru.ugfeld.id.lec4.model.entities.Order> orders) {
		
		for (ru.ugfeld.id.lec4.model.entities.Order order : orders) {
			if( order.getId() == orderId)
				return order;
		}
		return null;
	}
	
}
