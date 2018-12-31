package com.itzmystory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.itzmystory.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> finaAll();
}
