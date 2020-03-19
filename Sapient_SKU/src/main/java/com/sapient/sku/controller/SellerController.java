/**
 * 
 */
package com.sapient.sku.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.sku.model.Product;
import com.sapient.sku.model.Seller;
import com.sapient.sku.service.ProductService;
import com.sapient.sku.service.SellerService;

/**
 * @author sudhirk
 *
 */
@RestController(value = "/")
public class SellerController {
	@Autowired
	SellerService sellerService;
	@Autowired
	ProductService productService;
	

	@GetMapping(path = "seller")
	public List<Seller> getAllSellers(){
		System.out.println("In Seller");
		return sellerService.getAllSellers();
	}
	
	@GetMapping("sellerwithproducts")
	public List<Seller> getSellerWithProducts(){
		List<Seller> allSellers = sellerService.getAllSellers();
		List<Product> allProducts = productService.getAllProducts();
		Set<Product> productSet = null;
		
		for (Iterator sellerIterator = allSellers.iterator(); sellerIterator.hasNext();) {
			Seller seller = (Seller) sellerIterator.next();
			productSet = new HashSet<>();
			for (Iterator productIterator = allProducts.iterator(); productIterator.hasNext();) {
				Product product = (Product) productIterator.next();
				if(product.getSeller().getSeller_id().equals(seller.getSeller_id()))
					productSet.add(product);
			}
			seller.setProducts(productSet);
			productSet = null;
		}
		return allSellers;
	}
}
