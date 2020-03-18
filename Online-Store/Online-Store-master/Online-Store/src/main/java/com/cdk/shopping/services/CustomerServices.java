/**
 * 
 */
package com.cdk.shopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.shopping.model.Customer;
import com.cdk.shopping.repo.CustomerRepository;

/**
 * @author sudhirk
 *
 */
@Service
public class CustomerServices {
	
	@Autowired
	CustomerRepository customerRepository;

	public Customer save(Customer customer) {
		if(customer == null) return null;
		
		Customer savedCustomer = customerRepository.save(customer);
		return savedCustomer;
	}
	
	public List<Customer> findAllCustomers(){
		return customerRepository.findAll();
	}
	
	public Customer findCustomerById(Long custId) {
		if(custId == null) return null;
		
		return customerRepository.findById(custId).get();
	}
	
	public Customer findByEmail(String email) {
		List<Customer> customers = customerRepository.findByEmail(email);
		if(customers != null && customers.size() > 0) return customers.get(0);
		else return null;
	}
	
	public Customer findByConfirmationToken(String token) {
		return customerRepository.findByConfirmationToken(token).get(0);
	}
}
