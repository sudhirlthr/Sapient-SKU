/**
 * 
 */
package com.cdk.shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.shopping.model.DiscountPerCustomerType;
import com.cdk.shopping.repo.DiscountRepository;

/**
 * @author sudhirk
 *
 */
@Service
public class DiscountServices {

	@Autowired
	DiscountRepository discountRepository;
	
	public DiscountPerCustomerType save(DiscountPerCustomerType discountPerCustomerType) {
		return discountRepository.save(discountPerCustomerType);
	}
}
