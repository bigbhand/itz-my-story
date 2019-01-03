package com.itzmystory.service;

import com.itzmystory.domain.User;

public interface UserService {

	User createUser(User user);
	
	User save(User user);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User findById(Long id);
}
