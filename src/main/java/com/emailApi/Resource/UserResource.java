package com.emailApi.Resource;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emailApi.Domain.User;

import com.emailApi.Service.UserService;
import com.emailApi.Utility.CustomHttpResponse;



/**
 * @author Azo-hub
 * @github (https://github.com/Azo-hub)
 * @since 2020
 */

@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public ResponseEntity<CustomHttpResponse> createUser(@RequestBody User user, @RequestParam("emailBody") String emailBody) {

		User newUser = userService.saveUser(user, emailBody);

		return ResponseEntity.created(URI.create(""))
				.body(CustomHttpResponse.builder().timeStamp(LocalDateTime.now())
						.data(Map.of("user", newUser)).message("User Created").status(HttpStatus.CREATED)
						.statusCode(HttpStatus.CREATED.value()).build());

	}

	@GetMapping
	public ResponseEntity<CustomHttpResponse> confirmUserAccount(@RequestParam("token") String token) {

		Boolean isSuccess = userService.verifyToken(token);

		return ResponseEntity.created(URI.create(""))
				.body(CustomHttpResponse.builder().timeStamp(LocalDateTime.now())
						.data(Map.of("Success", isSuccess)).message("Account Verified").status(HttpStatus.OK)
						.statusCode(HttpStatus.OK.value()).build());

	}

}
