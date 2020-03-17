package com.cdk.shopping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cdk.shopping.model.Items;
import com.cdk.shopping.services.ItemService;

@SpringBootApplication
public class OnlineStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreApplication.class, args);
	}

	/*
	 * @Bean CommandLineRunner runner(ItemService itemService) { return args -> {
	 * itemService.save(new Items("Iphone", "11 Pro", 100000.0d, 10.0d, 90000.0d,
	 * true, "http://placehold.it/200x100")); itemService.save(new Items("Iphone ",
	 * "X Pro", 80000.00, 15.0d, 68000.0d, true, "http://placehold.it/200x100"));
	 * itemService.save(new Items("Iphone", "9 Pro", 60000.0d, 10.0d, 54000.0d,
	 * true, "http://placehold.it/200x100")); itemService.save(new Items("Iphone",
	 * "7 Plus", 40000.0d, 10.0d, 36000.0d, true, "http://placehold.it/200x100"));
	 * itemService.save(new Items("Google", "Pixel 3 XL", 70000.0d, 10.0d, 63000.0d,
	 * true, "http://placehold.it/200x100")); itemService.save(new Items("Google",
	 * "Pixel 3 a", 35000.0d, 10.0d, 31500.0d, true,
	 * "http://placehold.it/200x100")); itemService.save(new Items("Samsung",
	 * "S 20", 60000.0d, 10.0d, 54000.0d, true, "http://placehold.it/200x100")); };
	 * 
	 * }
	 */
}
