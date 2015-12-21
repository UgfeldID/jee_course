package ru.ugfeld.id.lec5.web.model.responses;

import ru.ugfeld.id.lec5.web.model.entities.Order;

public class OrderResponse extends Response{
	
	private Order order;	
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
