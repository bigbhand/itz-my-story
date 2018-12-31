package com.itzmystory.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itzmystory.domain.User;
import com.itzmystory.domain.security.UserRole;
import com.itzmystory.repository.RoleRepository;
import com.itzmystory.repository.UserRepository;
import com.itzmystory.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userRepository.findByUsername(user.getUsername());
		
		if(localUser !=  null) {
			LOG.info("User with username {} already exist. Nothing will be done.", user.getUsername());
		}else {
			for(UserRole u : userRoles) {
				roleRepository.save(u.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			
			localUser = userRepository.save(user);
		}
		return localUser;
	}

}
