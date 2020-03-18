/**
 * 
 */
package com.cdk.shopping.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdk.shopping.exception.ResourceNotFoundException;
import com.cdk.shopping.model.Order;
import com.cdk.shopping.repo.OrderRepository;

/**
 * @author sudhirk
 *
 */
@Service
@Transactional
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	public Iterable<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	public Order creatOrder(Order order) {
		order.setDateCreated(LocalDate.now());
		return orderRepository.save(order);
	}
	
	public void updateOrder(Order order) {// in caseof clone issue
		Order dbOrder = orderRepository.findById(order.getId()).orElseThrow(()-> new ResourceNotFoundException("Order Id is not Found"));
		dbOrder.setDateCreated(order.getDateCreated());
		dbOrder.setOrderItems(order.getOrderItems());
		dbOrder.setStatus(order.getStatus());
		orderRepository.save(dbOrder);
	}
}
