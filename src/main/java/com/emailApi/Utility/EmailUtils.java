package com.emailApi.Utility;

/**
 * @author Azo-hub
 * @github (https://github.com/Azo-hub)
 * @since 2020
 */
public class EmailUtils {
	
	public static String getEmailMessage(String username, String host, String token ) {
		return "Hello " + username + ",\n\nYour new acount has been created. Please click the link below to verify your account. \n\n" +
				getVerificationUrl(host, token) +  "\n\nThe Support Team";
	}

	private static String getVerificationUrl(String host, String token) {
		
		return host + "/api/users?token=" + token;
	}
}
