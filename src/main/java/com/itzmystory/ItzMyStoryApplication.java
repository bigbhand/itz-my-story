package com.itzmystory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itzmystory.config.SecurityUtility;
import com.itzmystory.domain.User;
import com.itzmystory.service.UserService;

@SpringBootApplication
public class ItzMyStoryApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ItzMyStoryApplication.class, args);
		System.out.println("cool!!");
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User();
		user1.setName("Admin");
		user1.setUsername("admin@itzmystory.com");
		user1.setEmail("admin@itzmystory.com");
		user1.setEnabled(true);
		user1.setPhone("0987654321");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user1.setRole("ROLE_ADMIN");
		userService.createUser(user1);
		
		
		User user2 = new User();
		user2.setName("User");
		user2.setUsername("user@itzmystory.com");
		user2.setEmail("user@itzmystory.com");
		user2.setEnabled(true);
		user2.setPhone("0987654321");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("user"));
		user2.setRole("ROLE_USER");
		userService.createUser(user2);
		
		User user3 = new User();
		user3.setName("User");
		user3.setUsername("dev@dev");
		user3.setEmail("dev@dev");
		user3.setEnabled(true);
		user3.setPhone("0987654321");
		user3.setPassword(SecurityUtility.passwordEncoder().encode("password"));
		user3.setRole("ROLE_USER");
		userService.createUser(user3);
		
		User user4 = new User();
		user4.setName("User");
		user4.setUsername("a@a");
		user4.setEmail("a@a");
		user4.setEnabled(true);
		user4.setPhone("0987654321");
		user4.setPassword("password");
		user4.setRole("ROLE_USER");
		userService.createUser(user4);
		
		User user5 = new User();
		user5.setName("Ganesh");
		user5.setUsername("ganesh.jsg3@gmail.com");
		user5.setEmail("ganesh.jsg3@gmail.com");
		user5.setEnabled(true);
		user5.setPhone("0987654321");
		user5.setPassword(SecurityUtility.passwordEncoder().encode("password"));
		user5.setRole("ROLE_USER");
		userService.createUser(user5);
		
		
	}

}

