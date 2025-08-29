package com.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailConfig {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	String from = "ashoklagadapati198@gmail.com";
	
	public void sendMail(String to, String subject, String body) {
		
		SimpleMailMessage obj = new SimpleMailMessage();
		obj.setTo(to);
		obj.setSubject(subject);
		obj.setFrom(from);
		obj.setText(body);
		
		javaMailSender.send(obj);
		
	}

}
