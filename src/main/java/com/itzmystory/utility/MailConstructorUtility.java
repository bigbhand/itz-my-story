package com.itzmystory.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.itzmystory.domain.User;

@Component
public class MailConstructorUtility {
	
	@Autowired
	private Environment env;
	
	public SimpleMailMessage createForgotPasswordEMail(User user, String password) {
		
		String message = "Please use the following password for the login. Its recommnened to reset the password after the login. \n "+password;
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("Itz My Story - Temporary password");
		email.setText(message);
		email.setFrom("support.itzmystory@gmail.com");
		
		return email;
	}
	

}
