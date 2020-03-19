/**
 * 
 */
package com.sapient.sku.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.sku.model.Address;
import com.sapient.sku.repository.AddressRepository;

/**
 * @author sudhirk
 *
 */
@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;
	
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}
	
	public Boolean saveMultipleAddress(Iterable<Address> addressSet) {
		if(addressRepository.saveAll(addressSet).size()>0) return true;
		return false;
	}
}
