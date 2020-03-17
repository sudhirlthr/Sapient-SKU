/**
 * 
 */
package com.cdk.shopping.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.cdk.shopping.model.DiscountPerCustomerType;
import com.cdk.shopping.model.Items;
import com.cdk.shopping.services.DiscountServices;
import com.cdk.shopping.services.ItemService;

/**
 * @author sudhirk
 *
 */
@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	ItemService itemService;
	
	@Autowired
	DiscountServices discountService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();
	}

	private void init() {
		itemService.save(new Items("Iphone", "11 Pro", 100000.0d, 10.0d, 90000.0d, true, "http://placehold.it/200x100"));
    	itemService.save(new Items("Iphone ", "X Pro", 80000.00, 15.0d, 68000.0d, true, "http://placehold.it/200x100"));
    	itemService.save(new Items("Iphone", "9 Pro", 60000.0d, 10.0d, 54000.0d, true, "http://placehold.it/200x100"));
    	itemService.save(new Items("Iphone", "7 Plus", 40000.0d, 10.0d, 36000.0d, true, "http://placehold.it/200x100"));
    	itemService.save(new Items("Google", "Pixel 3 XL", 70000.0d, 10.0d, 63000.0d, true, "http://placehold.it/200x100"));
    	itemService.save(new Items("Google", "Pixel 3 a", 35000.0d, 10.0d, 31500.0d, true, "http://placehold.it/200x100"));
    	itemService.save(new Items("Samsung", "S 20", 60000.0d, 10.0d, 54000.0d, true, "http://placehold.it/200x100"));
    	itemService.save(new Items("Samsung S1", "S1", 5000.0d, 10.0d, 5000.0d, true, "http://placehold.it/200x100"));
    	itemService.save(new Items("Samsung S2", "S2", 2000.0d, 10.0d, 2000.0d, true, "http://placehold.it/200x100"));
    	itemService.save(new Items("MI X1", "S2", 1500.0d, 10.0d, 1500.0d, true, "http://placehold.it/200x100"));
		
    	// for regular customer
    	discountService.save(new DiscountPerCustomerType(0, 5000, 0, "regular"));
    	discountService.save(new DiscountPerCustomerType(5001, 10000, 10, "regular"));
    	discountService.save(new DiscountPerCustomerType(10001, Integer.MAX_VALUE, 20, "regular"));
    	
    	// for Premium customer
    	discountService.save(new DiscountPerCustomerType(0, 4000, 10, "premium"));
    	discountService.save(new DiscountPerCustomerType(4001, 8000, 15, "premium"));
    	discountService.save(new DiscountPerCustomerType(8001, 12000, 20, "premium"));
    	discountService.save(new DiscountPerCustomerType(12001, Integer.MAX_VALUE, 30, "premium"));
    	
	}
}
