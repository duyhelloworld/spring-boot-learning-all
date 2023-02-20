package com.duyhelloworld.amigoscode;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.duyhelloworld.amigoscode.config.SpringJdbcConfig;

@SpringBootApplication
public class AmigoscodeApplication {
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(AmigoscodeApplication.class, args);
		SpringJdbcConfig config = new SpringJdbcConfig();
		System.out.println(config.mysqlDS().getConnection() == null);
	}
}