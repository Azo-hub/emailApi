/**
 * 
 */
package com.emailApi.Service.Impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.emailApi.Service.EmailService;
import com.emailApi.Utility.EmailUtils;

import jakarta.mail.internet.MimeMessage;

/**
 * @author Azo-hub
 * @github (https://github.com/Azo-hub)
 * @since 2020
 */

@Service
public class EmailServiceImpl implements EmailService {

	private static final String UTF_8_ENCODING = "UTF-8";

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

		} catch (Exception exception) {

			System.out.println(exception.getMessage());
			throw new RuntimeException(exception.getMessage());

		}

	}

	@Override
	@Async
	public void sendMimeMessageWithAttachment(String username, String to, String token) {

		try {

			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
			helper.setPriority(1);
			helper.setSubject(NEW_USER_ACCOUT_VERIFICATION);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setText(EmailUtils.getEmailMessage(username, host, token));

			/* Add attachment */
			FileSystemResource andrew = new FileSystemResource(
					new File(System.getProperty("user.home") + "/Downloads/uploads/andrew.jpg"));
			FileSystemResource arthur = new FileSystemResource(
					new File(System.getProperty("user.home") + "/Downloads/uploads/arthur.jpg"));
			FileSystemResource bashNote = new FileSystemResource(
					new File(System.getProperty("user.home") + "/Downloads/uploads/BashNote.pdf"));
			FileSystemResource prominent = new FileSystemResource(
					new File(System.getProperty("user.home") + "/Downloads/uploads/Prominent Physics Questions.docx"));

			helper.addAttachment(andrew.getFilename(), andrew);
			helper.addAttachment(arthur.getFilename(), arthur);
			helper.addAttachment(bashNote.getFilename(), bashNote);
			helper.addAttachment(prominent.getFilename(), prominent);
			emailSender.send(message);

		} catch (Exception exception) {

			System.out.println(exception.getMessage());
			throw new RuntimeException(exception.getMessage());

		}

	}

	@Override
	@Async
	public void sendMimeMessageWithEmbeddedFiles(String username, String to, String token) {

		try {

			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
			helper.setPriority(1);
			helper.setSubject(NEW_USER_ACCOUT_VERIFICATION);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setText(EmailUtils.getEmailMessage(username, host, token));

			/* Add attachment */
			
			  FileSystemResource andrew = new FileSystemResource( new
			  File(System.getProperty("user.home") + "/Downloads/uploads/andrew.jpg"));
			  FileSystemResource arthur = new FileSystemResource( new
			  File(System.getProperty("user.home") + "/Downloads/uploads/arthur.jpg"));
			  FileSystemResource bashNote = new FileSystemResource( new
			  File(System.getProperty("user.home") + "/Downloads/uploads/BashNote.pdf"));
			 
			FileSystemResource prominent = new FileSystemResource(
					new File(System.getProperty("user.home") + "/Downloads/uploads/Prominent Physics Questions.docx"));

			
			  helper.addInline(getContentId(andrew.getFilename()), andrew);
			  helper.addInline(getContentId(arthur.getFilename()), arthur);
			  helper.addInline(getContentId(bashNote.getFilename()), bashNote);
			 
			helper.addInline(getContentId(prominent.getFilename()), prominent);
			emailSender.send(message);

		} catch (Exception exception) {

			System.out.println(exception.getMessage());
			throw new RuntimeException(exception.getMessage());

		}

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

	private String getContentId(String filename) {
		
		return "<" + filename + ">";
	}

}
