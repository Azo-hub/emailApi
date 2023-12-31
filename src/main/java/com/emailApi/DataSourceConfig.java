package com.emailApi;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;



@Configuration
@Component
public class DataSourceConfig {

	@Bean
	public DataSource getDataSource() {
		return DataSourceBuilder.create().driverClassName("org.postgresql.Driver")
				.url("jdbc:postgresql://localhost:5432/emailapidb").username("postgres").password("***************").build();
	}

}
