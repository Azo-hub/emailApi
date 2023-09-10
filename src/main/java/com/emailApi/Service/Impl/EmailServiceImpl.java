/**
 * 
 */
package com.emailApi.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.emailApi.Service.EmailService;
import com.emailApi.Utility.EmailUtils;

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
	@Async
	public void sendSimpleMailMessage(String username, String to, String token) {
		
		try {

			SimpleMailMessage message = new SimpleMailMessage();
			message.setSubject(NEW_USER_ACCOUT_VERIFICATION);
			message.setFrom(from);
			message.setTo(to);
			message.setText(EmailUtils.getEmailMessage(username, host, token));
			emailSender.send(message);
			
		} catch(Exception exception) {
			
			System.out.println(exception.getMessage());
			throw new RuntimeException(exception.getMessage());
			
		}

	}

	@Override
	@Async
	public void sendMimeMessageWithAttachment(String username, String to, String token) {
		// TODO Auto-generated method stub

	}

	@Override
	@Async
	public void sendMimeMessageWithEmbeddedFiles(String username, String to, String token) {
		// TODO Auto-generated method stub

	}

	@Override
	@Async
	public void sendHtmlMessage(String username, String to, String token) {
		// TODO Auto-generated method stub

	}

	@Override
	@Async
	public void sendHtmlMessageWithEmbeddedFiles(String username, String to, String token) {
		// TODO Auto-generated method stub

	}

}
