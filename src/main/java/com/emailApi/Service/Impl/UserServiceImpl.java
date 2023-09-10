package com.emailApi.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emailApi.Domain.Confirmation;
import com.emailApi.Domain.User;
import com.emailApi.Repository.ConfirmationRepository;
import com.emailApi.Repository.UserRepository;
import com.emailApi.Service.EmailService;
import com.emailApi.Service.UserService;

/**
 * @author Azo-hub
 * @github (https://github.com/Azo-hub)
 * @since 2020
 */


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ConfirmationRepository confirmationRepository;
	
	@Autowired
	private EmailService emailService;


	@Override
	public User saveUser(User user) {

		if (userRepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("Email ALready exists");
		}

		user.setEnabled(false);
		userRepository.save(user);

		Confirmation confirmation = new Confirmation(user);
		confirmationRepository.save(confirmation);
		
		/*emailService.sendSimpleMailMessage(user.getUsername(),user.getEmail() , confirmation.getToken());*/
		/*emailService.sendMimeMessageWithAttachment(user.getUsername(),user.getEmail() , confirmation.getToken());*/
		emailService.sendMimeMessageWithEmbeddedFiles(user.getUsername(),user.getEmail() , confirmation.getToken());

		return user;
	}

	@Override
	public Boolean verifyToken(String token) {

		Confirmation confirmation = confirmationRepository.findByToken(token);
		User user = userRepository.findByEmailIgnoreCase(confirmation.getUser().getEmail());
		user.setEnabled(true);
		userRepository.save(user);
		confirmationRepository.delete(confirmation);

		return Boolean.TRUE;
	}

}
