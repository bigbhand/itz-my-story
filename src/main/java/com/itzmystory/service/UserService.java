package com.itzmystory.service;

import java.util.Set;

import com.itzmystory.domain.User;
import com.itzmystory.domain.security.UserRole;

public interface UserService {

	User createUser(User user, Set<UserRole> userRoles);
}
