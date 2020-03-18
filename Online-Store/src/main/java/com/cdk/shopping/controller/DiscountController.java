/**
 * 
 */
package com.cdk.shopping.controller;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdk.shopping.model.Customer;
import com.cdk.shopping.model.DiscountPerCustomerType;
import com.cdk.shopping.model.Users;
import com.cdk.shopping.services.CustomerServices;
import com.cdk.shopping.services.DiscountServices;
import com.cdk.shopping.services.UsersService;

/**
 * @author sudhirk
 *
 */
@RestController
@RequestMapping(path = "/api/discount/")
public class DiscountController {
	
	@Autowired
	DiscountServices discountService;
	
	@Autowired
	CustomerServices customerServices;
	
	@GetMapping(path = "/{total}")
	@ResponseBody
	public Double getDiscoutOnTotal(@PathVariable("total") String total, Principal principal) {
		String userName = principal.getName();
		Customer customer = customerServices.findByEmail(userName);
		List<DiscountPerCustomerType> discountDetails = discountService.findDiscountDetails(customer.getCustomer_type());
		Double discount = 0d;
		Integer discountInPrecenatge = 0;
		for (Iterator iterator = discountDetails.iterator(); iterator.hasNext();) {
			DiscountPerCustomerType discountPerCustomerType = (DiscountPerCustomerType) iterator.next();
			if(discountPerCustomerType.getHigher() >= Integer.parseInt(total) && discountPerCustomerType.getLower() <= Integer.parseInt(total))
				discountInPrecenatge = discountPerCustomerType.getDiscount();
		}
		if(discountInPrecenatge != 0) {
			discount =  (double) ((Integer.parseInt(total) * discountInPrecenatge))/100;
		}
		
		return discount;
	}
}
