package com.emailApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emailApi.Domain.User;

/**
 * @author Azo-hub
 * @github (https://github.com/Azo-hub)
 * @since 2020
 */

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
	User findByEmailIgnoreCase(String email);
	Boolean existsByEmail(String email);

}
