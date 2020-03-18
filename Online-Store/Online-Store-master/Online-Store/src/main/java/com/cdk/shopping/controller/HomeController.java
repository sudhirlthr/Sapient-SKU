/**
 * 
 */
package com.cdk.shopping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhirk
 *
 */
@RestController
public class HomeController {
	
	@GetMapping(path = "/greeting")
	public String greet() {
		return "Hi...";
	}
	
	@GetMapping("/")
	public String defaultMessage() {
		return "This is DefaultPage";
	}
}
