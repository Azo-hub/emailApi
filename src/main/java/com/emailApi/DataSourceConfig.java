package com.emailApi;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.activation.DataSource;

@Configuration
public class DataSourceConfig {

	@Bean
	public javax.sql.DataSource getDataSource() {
		return DataSourceBuilder.create().driverClassName("org.postgresql.Driver")
				.url("jdbc:postgresql://localhost:5432/emailapidb").username("postgres").password("Pureand@applied1").build();
	}

}
