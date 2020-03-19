/**
 * 
 */
package com.sapient.sku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.sku.model.Seller;
import com.sapient.sku.repository.SellerRepository;

/**
 * @author sudhirk
 *
 */
@Service
public class SellerService {
	@Autowired
	SellerRepository sellerRepository;
	
	public Seller saveSeller(Seller seller) {
		return sellerRepository.save(seller);
	}
	public Boolean saveMultipleSeller(Iterable<Seller> sellerSet) {
		if(sellerRepository.saveAll(sellerSet).size()>0) return true;
		return false;
	}
	
	public List<Seller> getAllSellers(){
		return sellerRepository.findAll();
	}
}
