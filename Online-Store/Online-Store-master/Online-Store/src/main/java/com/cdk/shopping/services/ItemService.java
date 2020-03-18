/**
 * 
 */
package com.cdk.shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.shopping.exception.ResourceNotFoundException;
import com.cdk.shopping.model.Items;
import com.cdk.shopping.repo.ItemRepository;

/**
 * @author sudhirk
 *
 */
@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public Iterable<Items> getAllItems(){
		return itemRepository.findAll();
	}
	
	public Items getItemById(Long itemId) {
		return itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item Not Found By id..."));
	}

	public Items save(Items items) {
		return itemRepository.save(items);
	}
}
