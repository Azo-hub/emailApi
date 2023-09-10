/**
 * 
 */
package com.emailApi.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emailApi.Service.EmailService;

/**
 * @author Azo-hub
 * @github (https://github.com/Azo-hub)
 * @since 2020
 */

@Service
public class EmailServiceImpl implements EmailService {


	private static final String NEW_USER_ACCOUT_VERIFICATION = "NEW USER ACCOUT VERIFICATION";

	@Value("${spring.mail.verify.host}")
	private String host;

	@Value("${spring.mail.username}")
	private String from;

	@Autowired
	private JavaMailSender emailSender;

	@Override
	public void sendSimpleMailMessage(String username, String to, String token, String emailBody) {
		
		try {

			SimpleMailMessage message = new SimpleMailMessage();
			message.setSubject(NEW_USER_ACCOUT_VERIFICATION);
			message.setFrom(from);
			message.setTo(to);
			message.setText(emailBody);
			emailSender.send(message);
			
		} catch(Exception exception) {
			
			System.out.println(exception.getMessage());
			throw new RuntimeException(exception.getMessage());
			
		}

	}

	@Override
	public void sendMimeMessageWithAttachment(String username, String to, String token) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendMimeMessageWithEmbeddedFiles(String username, String to, String token) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendHtmlMessage(String username, String to, String token) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendHtmlMessageWithEmbeddedFiles(String username, String to, String token) {
		// TODO Auto-generated method stub

	}

}
