/**
 * 
 */
package com.sapient.sku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.sku.model.Brand;
import com.sapient.sku.repository.BrandRepository;

/**
 * @author sudhirk
 *
 */
@Service
public class BrandService {
	
	@Autowired
	BrandRepository brandRepository;
	
	public Brand saveBrand(Brand brand) {
		return brandRepository.save(brand);
	}
	
	public List<Brand> getAllBrands(){
		return brandRepository.findAll();
	}
}
