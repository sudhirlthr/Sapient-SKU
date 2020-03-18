/**
 * 
 */
package com.cdk.shopping.services;

import java.util.ArrayList;
import java.util.List;

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
	
	public Users getUsersDetails(String email) {
		List<Users> list = userRepository.findByUsername(email);
		if(list != null) return list.get(0);
		else return new Users();
	}
}
