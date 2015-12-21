package ru.ugfeld.id.lec5.web.model.entities;

import ru.ugfeld.id.lec5.utils.Comparer;

public class Customer {
	
	private Integer id;
	private String name;
	
	public static Customer map( ru.ugfeld.id.lec4.model.entities.Customer customer){
		
		Customer newCustomer = new Customer();
		newCustomer.setId(customer.getId());
		newCustomer.setName(customer.getName());
		
		return newCustomer;
	}
	
	public ru.ugfeld.id.lec4.model.entities.Customer createDbEntity(){
		
		ru.ugfeld.id.lec4.model.entities.Customer customer = new ru.ugfeld.id.lec4.model.entities.Customer();
		customer.setId(null);
		customer.setName(name);
		
		return customer;
	}
	
	public void updateDbEntity ( ru.ugfeld.id.lec4.model.entities.Customer customer){
		if ( ! Comparer.equals( name, customer.getName( ) ) )
			customer.setName( name );
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
