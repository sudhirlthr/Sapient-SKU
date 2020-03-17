/**
 * 
 */
package com.cdk.shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.shopping.model.Users;
import com.cdk.shopping.repo.UserRepository;

/**
 * @author sudhirk
 *
 */
@Service
public class UsersService {
	
	@Autowired
	UserRepository userRepository;
	
	public Users saveUser(Users users) {
		return userRepository.save(users);
	}	
}
