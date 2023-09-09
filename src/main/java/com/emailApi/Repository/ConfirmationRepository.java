package com.emailApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emailApi.Domain.Confirmation;

/**
 * @author Azo-hub
 * @github (https://github.com/Azo-hub)
 * @since 2020
 */
public interface ConfirmationRepository  extends JpaRepository<Confirmation, Long> {
	Confirmation findByToken(String token);

}
