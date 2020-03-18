/**
 * 
 */
package com.cdk.shopping.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdk.shopping.model.Items;
import com.cdk.shopping.services.ItemService;

/**
 * @author sudhirk
 *
 */
@RestController
@RequestMapping(path = "/api/items")
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@GetMapping(value = {"","/"})
	public @NotNull Iterable<Items> getItems(){
		return itemService.getAllItems();
	}
}
