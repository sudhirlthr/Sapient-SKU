/**
 * 
 */
package com.sapient.sku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.sku.model.Brand;
import com.sapient.sku.model.Product;
import com.sapient.sku.repository.ProductRepository;

/**
 * @author sudhirk
 *
 */
@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public List<Product> getProductsByBrand(Brand brand){
		return productRepository.findByBrand(brand);
	}
}
