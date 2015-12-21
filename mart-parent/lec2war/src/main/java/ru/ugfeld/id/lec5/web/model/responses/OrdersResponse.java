package ru.ugfeld.id.lec5.web.model.responses;

import java.util.ArrayList;
import java.util.List;

import ru.ugfeld.id.lec5.web.model.entities.Order;

public class OrdersResponse extends Response{
	
	private List<Order> orders = new ArrayList<>();

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
