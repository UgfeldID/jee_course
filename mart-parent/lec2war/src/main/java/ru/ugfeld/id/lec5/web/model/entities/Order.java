package ru.ugfeld.id.lec5.web.model.entities;

import java.util.ArrayList;
import java.util.List;

import ru.ugfeld.id.lec5.utils.Comparer;

public class Order {
	
	private Integer id;
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public static Order map( ru.ugfeld.id.lec4.model.entities.Order order){
		
		Order newOrder = new Order();
		newOrder.setId(order.getId());	
		
		for (ru.ugfeld.id.lec4.model.entities.OrderItem orderItem : order.getOrderItems()) {
			newOrder.getOrderItems().add(OrderItem.map(orderItem));
		}
		
		return newOrder;
	}
	
	public ru.ugfeld.id.lec4.model.entities.Order createDbEntity(){
		
		ru.ugfeld.id.lec4.model.entities.Order order = new ru.ugfeld.id.lec4.model.entities.Order();			
		
		return order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
