package ru.ugfeld.id.lec4.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.ugfeld.id.lec4.model.entities.OrderItem;
import ru.ugfeld.id.lec4.model.repositories.IOrderItemRepository;

public class OrderItemService implements IOrderItemService{

	@Autowired
	private IOrderItemRepository orderItemRepository;
	
	@Override
	@Transactional( rollbackFor = Exception.class )
	public OrderItem create(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public OrderItem delete(int id) throws Exception {
		OrderItem deletetOrderItem = orderItemRepository.findOne(id);
		
		if ( orderItemRepository == null)
			throw new Exception("Order item not found");
		
		orderItemRepository.delete(deletetOrderItem);
		return deletetOrderItem;
	}

	@Override
	public List<OrderItem> findAll() {		
		return orderItemRepository.findAll();
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public OrderItem update(OrderItem orderItem) throws Exception {
		OrderItem updatedOrderItem = orderItemRepository.findOne(orderItem.getId());
		
		if ( updatedOrderItem == null)
			throw new Exception("Order item not found");
		
		updatedOrderItem.setOrder(orderItem.getOrder());
		updatedOrderItem.setProduct(orderItem.getProduct());
		updatedOrderItem.setQuantity(orderItem.getQuantity());
		
		orderItemRepository.save(updatedOrderItem);
		return updatedOrderItem;
	}

	@Override
	public OrderItem findById(int id) {
		return orderItemRepository.findOne(id);
	}

}
