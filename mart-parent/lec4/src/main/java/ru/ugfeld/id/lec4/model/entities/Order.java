package ru.ugfeld.id.lec4.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table( name = "orders" )
public class Order {
		
	public Order() {
		super();
	}


	public Order(Customer customer) {
		super();
		this.customer = customer;
	}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Integer id;	

	@ManyToOne
	@JoinColumn( name = "id_customer", nullable = false )
	private Customer customer;

	@OneToMany( mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@CascadeOnDelete
	private List< OrderItem > orderItems = new ArrayList<>( );
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
