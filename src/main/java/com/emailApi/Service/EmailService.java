package com.emailApi.Service;

/**
 * @author Azo-hub
 * @github (https://github.com/Azo-hub)
 * @since 2020
 */

public interface EmailService {

	void sendSimpleMailMessage(String username, String to, String token);

	void sendMimeMessageWithAttachment(String username, String to, String token);

	void sendMimeMessageWithEmbeddedFiles(String username, String to, String token);

	void sendHtmlMessage(String username, String to, String token);

	void sendHtmlMessageWithEmbeddedFiles(String username, String to, String token);

	

	
	
}
