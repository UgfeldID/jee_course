package ru.ugfeld.id.lec4.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.ugfeld.id.lec4.model.entities.Customer;
import ru.ugfeld.id.lec4.model.repositories.ICustomerRepository;

public class CustomerService implements ICustomerService{
	
	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Customer delete(int id) throws Exception {
		Customer deletedCustomer = customerRepository.findOne(id);
		
		if( deletedCustomer == null )
			throw new Exception("Customer not found");
		
		customerRepository.delete(deletedCustomer);
		return deletedCustomer;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Customer update(Customer customer) throws Exception {
		Customer updatedCustomer = customerRepository.findOne(customer.getId());
		
		if( updatedCustomer == null )
			throw new Exception("Customer not found");
		
		updatedCustomer.setName(customer.getName());
		
		customerRepository.save(updatedCustomer);
		return updatedCustomer;
	}

	@Override
	public Customer findById(int id) {
		return customerRepository.findOne(id);
	}

}
