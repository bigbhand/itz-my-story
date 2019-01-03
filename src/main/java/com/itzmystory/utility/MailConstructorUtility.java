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
		
		String message = "";
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("Itz My Story - Temporary password");
		email.setText(message);
		email.setFrom(env.getProperty("support.mail"));
		
		return email;
	}
	

}
