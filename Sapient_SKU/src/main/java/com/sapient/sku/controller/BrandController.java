/**
 * 
 */
package com.sapient.sku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.sku.model.Brand;
import com.sapient.sku.service.BrandService;

/**
 * @author sudhirk
 *
 */
@RestController
public class BrandController {
	
	@Autowired
	BrandService brandService;

	@GetMapping(path = "/brand")
	public List<Brand> getAllBrands(){
		return brandService.getAllBrands();
	}
}
