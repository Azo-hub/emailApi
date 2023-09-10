/**
 * 
 */
package com.emailApi.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author Azo-hub
 * @github (https://github.com/Azo-hub)
 * @since 2020
 */

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
@Entity
@Table(name="users")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	
	@Column(name = "email", nullable = false, updatable = false)
	private String email;
	private String password;
	private boolean isEnabled;

}
