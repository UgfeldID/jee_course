package ru.ugfeld.id.lec5.web.model.entities;

import ru.ugfeld.id.lec5.utils.Comparer;

public class OrderItem {
	
	private Integer id;
	private String quantity;
		
	private String name;
	private Float price;	
	private Float discount;
	
	public static OrderItem map ( ru.ugfeld.id.lec4.model.entities.OrderItem orderItem){
		
		OrderItem newOrderItem = new OrderItem();
		newOrderItem.setId(orderItem.getId());
		newOrderItem.setQuantity(orderItem.getQuantity());
		newOrderItem.setDiscount(orderItem.getProduct().getDiscount());
		
		newOrderItem.setName(orderItem.getProduct().getName());
		newOrderItem.setDiscount(orderItem.getProduct().getDiscount());
		newOrderItem.setPrice(orderItem.getProduct().getPrice());
		
		return newOrderItem;
	}
	
	public ru.ugfeld.id.lec4.model.entities.OrderItem createDbEntity (){
		
		ru.ugfeld.id.lec4.model.entities.OrderItem orderItem = new ru.ugfeld.id.lec4.model.entities.OrderItem();
		orderItem.setId(id);
		orderItem.setQuantity(quantity);
		
		return orderItem;
	}
	
	public void updateDbEntity( ru.ugfeld.id.lec4.model.entities.OrderItem orderItem){
	
		if ( ! Comparer.equals( quantity, orderItem.getQuantity() ) )
			orderItem.setQuantity(quantity);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}
}
