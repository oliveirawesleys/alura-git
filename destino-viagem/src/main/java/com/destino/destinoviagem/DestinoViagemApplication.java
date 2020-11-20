package com.destino.destinoviagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class DestinoViagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DestinoViagemApplication.class, args);
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bancodedestino");
		dataSource.setUsername("root");
		dataSource.setPassword("apartamento141");
		return dataSource;
	}
}
