/**
 * 
 */
package com.sapient.sku.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.sku.model.Brand;
import com.sapient.sku.model.Product;
import com.sapient.sku.model.Size;
import com.sapient.sku.service.BrandService;
import com.sapient.sku.service.ProductService;

/**
 * @author sudhirk
 *
 */
@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	BrandService brandService;
	
	@GetMapping(path = "/")
	public String greeting() {
		return "Greet from ABC ecommerce...";
	}
	
	@GetMapping(path = "/products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping(path = "/productsGrpByBrand")
	public Map<String, List<Product>> getAllProductsGroupByBrand(){
		
		List<Brand> allBrands = brandService.getAllBrands();
		Map<String, List<Product>> productMapByBrand = new HashMap<>();
		for (Brand brand : allBrands) {
			productMapByBrand.put(brand.getName(), productService.getProductsByBrand(brand));
		}

		return productMapByBrand;
		 
		
		/*
		 * List<Product> productsList = productService.getAllProducts(); Map<Brand,
		 * List<Product>> productsGrpByBrand =
		 * productsList.stream().collect(Collectors.groupingBy(Product::getBrand));
		 * return productsGrpByBrand;
		 */
	}
	
	
	@GetMapping(path = "/productsGrpByPrice")
	public Map<Double, List<Product>> getAllProductsGrpByPrice(){
		List<Product> allProducts = productService.getAllProducts();
		Map<Double, List<Product>> groupByPriceMap = allProducts.stream().collect(Collectors.groupingBy(Product::getPrice));
		return groupByPriceMap;
	}
	
	@GetMapping(path = "/productsGrpBySize")
	public Map<Collection<Size>, List<Product>> getAllProductsGrpBySize(){
		List<Product> allProducts = productService.getAllProducts();
		Map<Collection<Size>, List<Product>> prodcutsGrpBySize = allProducts
				.stream()
				.collect(Collectors
						.groupingBy(Product::getSize, Collectors.toList()));
		return prodcutsGrpBySize;
	}
	@GetMapping(path = "/productsGrpByColor")
	public Map<String, List<Product>> getAllProductsGrpByColor(){
		List<Product> allProducts = productService.getAllProducts();
		Map<String, List<Product>> productListGrpByColor = allProducts.stream().collect(Collectors.groupingBy(Product::getColor));
		return productListGrpByColor;
	}
}
