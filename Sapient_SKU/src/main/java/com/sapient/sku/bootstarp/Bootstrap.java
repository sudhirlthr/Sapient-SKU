/**
 * 
 */
package com.sapient.sku.bootstarp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sapient.sku.model.Address;
import com.sapient.sku.model.Brand;
import com.sapient.sku.model.Category;
import com.sapient.sku.model.Colors;
import com.sapient.sku.model.Product;
import com.sapient.sku.model.Seller;
import com.sapient.sku.model.Size;
import com.sapient.sku.service.AddressService;
import com.sapient.sku.service.BrandService;
import com.sapient.sku.service.ProductService;
import com.sapient.sku.service.SellerService;

/**
 * @author sudhirk
 *
 */
@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	BrandService brandService;
	@Autowired
	ProductService productService;
	@Autowired
	AddressService addressService;
	@Autowired
	SellerService sellerService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();
	}
	
	private void init() {
		Brand firstBrand = new Brand("United color of beneton");
		Brand secondBrand = new Brand("Raymond");
		Brand thirdBrand = new Brand("Fila");
		Brand fourthBrand = new Brand("Nike");
		brandService.saveBrand(firstBrand);
		brandService.saveBrand(secondBrand);
		brandService.saveBrand(thirdBrand);
		brandService.saveBrand(fourthBrand);
		
		List<Colors> colors = new ArrayList<>();
		//colors.add(Colors.BLUE);
		colors.add(Colors.BLACK);
		colors.add(Colors.GREEN);
		colors.add(Colors.MAGENTA);
		colors.add(Colors.WHITE);
		
		List<Size> sizeSet = new ArrayList<>();
		sizeSet.add(Size.SMALL);
		sizeSet.add(Size.MEDIUM);
		sizeSet.add(Size.LARGE);
		sizeSet.add(Size.EXTRALARGE);
		
		Seller seller1 = new Seller();
		Seller seller2 = new Seller();
		Seller savedSeller1 = sellerService.saveSeller(seller1);
		Seller savedSeller2 = sellerService.saveSeller(seller2);
		
		Address address1 = new Address("101","Mg road",100111, "Delhi","India",seller1);
		Address address2 = new Address("2121","Raod number 44, Banjara Hills",500080, "Telangana","India", seller1);
		Address address3 = new Address("232","Hauzkhas road",100001, "Delhi","India",seller2);
		Address address4 = new Address("782","Raod number 55, Ayyappa Society",500081, "Telangana","India", seller2);
		addressService.saveAddress(address1);
		addressService.saveAddress(address2);
		addressService.saveAddress(address3);
		addressService.saveAddress(address4);
		
		Set<Address> addressSet1 = Stream.of(address1,address2).collect(Collectors.toCollection(HashSet::new));
		Set<Address> addressSet2 = Stream.of(address3,address4).collect(Collectors.toCollection(HashSet::new));
		
		
		savedSeller1.setName("Abc electronics");
		savedSeller1.setAddress(addressSet1);
		savedSeller1.setEmail("abc@gmail.com");
		savedSeller2.setName("RetailNet");
		savedSeller2.setAddress(addressSet2);
		savedSeller2.setEmail("xyz@gmail.com");

		//seller1.setProducts(new HashSet<Product>());
		//seller2.setProducts(new HashSet<Product>());
		//Set<Seller> sellerSet = Stream.of(savedSeller1,savedSeller2).collect(Collectors.toCollection(HashSet::new));
		//save to Db
		
		sellerService.saveSeller(savedSeller1);
		sellerService.saveSeller(savedSeller2);
		
		
		//Product product = new Product("Polo Tshirt", brand, 1999.99, Category.Tshirt, 40, "Black",savedSeller1);
		Product product = new Product("Polo Tshirt", firstBrand, 1999.99, Category.Tshirt, sizeSet, "Black", savedSeller1);
		//Product product = new Product("Polo Tshirt", brand, 1999.99, Category.Tshirt,colors , sizeSet, savedSeller1);

		
		Product product2 = new Product("Tshirt", firstBrand, 1000.99, Category.Tshirt, sizeSet, "Black", savedSeller1);
		Product product3 = new Product("Slim Shirt", firstBrand, 2000.99, Category.Shirt, sizeSet, "Black", savedSeller1);
		Product product4 = new Product("Party Wear Shirt", firstBrand, 3000.99, Category.Shirt, sizeSet, "Black", savedSeller1);
		Product product5 = new Product("Formal Shirt", firstBrand, 1500.00, Category.Shirt, sizeSet, "White", savedSeller1);
		
		
		Product product22 = new Product("Casual shirt", secondBrand, 1999.99, Category.Shirt, sizeSet, "Mint", savedSeller1);
		Product product32 = new Product("Slim Shirt", secondBrand, 1999.99, Category.Shirt, sizeSet, "Cream", savedSeller1);
		Product product42 = new Product("Party Wear Shirt", secondBrand, 1999.99, Category.Shirt, sizeSet, "Red", savedSeller1);
		Product product52 = new Product("Formal Shirt", secondBrand, 1999.99, Category.Shirt, sizeSet, "Dark green", savedSeller1);
		
		//save to db
		productService.saveProduct(product);
		productService.saveProduct(product2);
		productService.saveProduct(product3);
		productService.saveProduct(product4);
		productService.saveProduct(product5);
		
		productService.saveProduct(product22);
		productService.saveProduct(product32);
		productService.saveProduct(product42);
		productService.saveProduct(product52);
		 
	}

}
