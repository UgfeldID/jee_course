package ru.ugfeld.id.lec5.web.model.requests;

import ru.ugfeld.id.lec5.web.model.entities.Customer;

public class CustomerRequest extends Request{
	
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	} 
}
