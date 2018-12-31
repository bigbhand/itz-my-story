package com.itzmystory.repository;

import org.springframework.data.repository.CrudRepository;

import com.itzmystory.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

}
