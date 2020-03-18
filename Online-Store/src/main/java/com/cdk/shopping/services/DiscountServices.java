/**
 * 
 */
package com.cdk.shopping.services;

import java.util.List;

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
	
	public List<DiscountPerCustomerType> findDiscountDetails(String customerType) {
		List<DiscountPerCustomerType> discountList = discountRepository.findByType(customerType);
		return discountList;
	}
}
