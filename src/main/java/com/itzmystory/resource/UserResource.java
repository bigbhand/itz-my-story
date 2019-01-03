package com.itzmystory.resource;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itzmystory.config.SecurityUtility;
import com.itzmystory.domain.User;
import com.itzmystory.repository.UserRepository;
import com.itzmystory.utility.MailConstructorUtility;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MailConstructorUtility mailConstructorUtility;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/forgotPassword", method=RequestMethod.POST)
	public ResponseEntity forgotPassword(HttpServletRequest request, @RequestBody HashMap<String, String> mapper) throws Exception{
		
		User user = userRepository.findByEmail(mapper.get("email"));
		
		if(user == null ) {
			return new ResponseEntity("Email not found", HttpStatus.BAD_REQUEST);
		}
		
		String newPassword = SecurityUtility.randomPassword();
		SecurityUtility.passwordEncoder().encode(newPassword);
		
		user.setPassword(newPassword);
		
		SimpleMailMessage newMail = mailConstructorUtility.createForgotPasswordEMail(user, user.getPassword());
		mailSender.send(newMail);
		
		return new ResponseEntity("Email sent", HttpStatus.OK);
	}
}
