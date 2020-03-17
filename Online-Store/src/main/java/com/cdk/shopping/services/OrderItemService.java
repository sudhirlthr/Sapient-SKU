/**
 * 
 */
package com.cdk.shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.shopping.model.OrderItems;
import com.cdk.shopping.repo.OrderItemRepository;

/**
 * @author sudhirk
 *
 */
@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	public OrderItems createOrderItems(OrderItems orderItems) {
		return orderItemRepository.save(orderItems);
	}
}
