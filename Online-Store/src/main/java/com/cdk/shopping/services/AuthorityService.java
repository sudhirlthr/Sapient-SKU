/**
 * 
 */
package com.cdk.shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cdk.shopping.model.Authority;
import com.cdk.shopping.repo.AuhtorityRepository;

/**
 * @author sudhirk
 *
 */
@Service
public class AuthorityService {
	
	@Autowired
	AuhtorityRepository auhtorityRepository;
	
	public Authority saveAuthority(Authority authority) {
		return auhtorityRepository.save(authority);
	}
}
