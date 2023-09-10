package com.emailApi.Service;

import com.emailApi.Domain.User;

/**
 * @author Azo-hub
 * @github (https://github.com/Azo-hub)
 * @since 2020
 */

public interface UserService {
	User saveUser(User user, String emailBody);
	Boolean verifyToken(String token);
	
}
