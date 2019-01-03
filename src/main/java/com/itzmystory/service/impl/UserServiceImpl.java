package com.itzmystory.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itzmystory.domain.User;
import com.itzmystory.repository.UserRepository;
import com.itzmystory.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User createUser(User user) {
		User localUser = userRepository.findByUsername(user.getUsername());
		
		if(localUser !=  null) {
			LOG.info("User with username {} already exist. Nothing will be done.", user.getUsername());
		}else {
			localUser = userRepository.save(user);
		}
		return localUser;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override 
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findById(Long id) {
		return null;
	}

}
